package com.example.characterbuilderapp.service.impl;

import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
import com.example.characterbuilderapp.dto.BuildRequest;
import com.example.characterbuilderapp.dto.CharacterBuiltDetailedResponse;
import com.example.characterbuilderapp.dto.CharacterBuiltResumedResponse;
import com.example.characterbuilderapp.core.exception.ObjectNotFoundException;
import com.example.characterbuilderapp.mapper.*;
import com.example.characterbuilderapp.infra.db.msql.repository.CharacterBuiltRepositoryMysql;
import com.example.characterbuilderapp.service.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.example.characterbuilderapp.core.exception.ErrorConstants.*;

//Command
// classe de dominio
//extrai os comandos(lógica que efetua algo)
//Chama o método executa
//Implementa interface Command
//Command Handler separa
//Command Hanndler
//1 classe pra ser um handler com construtor de injeção de dependencia
//método execute no handler(parametrosCommand)
//O parametrosCommand é onde ficam as representações

//Observer
//Transforma as ações em um atributo List<Interface>
//Interface tem o método  no handler
//No método execute executa todas as ações
//Na hora de instanciar o handler, passa as dependencias pelo construtor

@Service
public class CharacterBuiltServiceImpl implements CharacterBuiltService {

    private final CharacterBuiltRepositoryMysql characterBuiltRepository;
    private final CharacterService characterService;
    private final EsperService esperService;
    private final UserService userService;
    private final ReactionService reactionService;
    private final CharacterBuiltJobService characterBuiltJobService;
    private final CharacterBuiltEquipmentService characterBuiltEquipmentService;
    private final CharacterBuiltSupportAbilityService characterBuiltSupportAbilityService;
    private final CharacterBuiltVisionCardService characterBuiltVisionCardService;

    public CharacterBuiltServiceImpl(CharacterBuiltRepositoryMysql characterBuiltRepository,
                                     CharacterService characterService, EsperService esperService,
                                     UserService userService, ReactionService reactionService,
                                     CharacterBuiltJobService characterBuiltJobService,
                                     CharacterBuiltEquipmentService characterBuiltEquipmentService,
                                     CharacterBuiltSupportAbilityService characterBuiltSupportAbilityService,
                                     CharacterBuiltVisionCardService characterBuiltVisionCardService){
        this.characterBuiltRepository = characterBuiltRepository;
        this.characterService = characterService;
        this.esperService = esperService;
        this.userService = userService;
        this.reactionService = reactionService;
        this.characterBuiltJobService = characterBuiltJobService;
        this.characterBuiltEquipmentService = characterBuiltEquipmentService;
        this.characterBuiltSupportAbilityService = characterBuiltSupportAbilityService;
        this.characterBuiltVisionCardService = characterBuiltVisionCardService;
    }

    @Override
    public CharacterBuiltModel findById(Long id) {
        return characterBuiltRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException(CHARACTER_BUILT_NAO_ENCONTRADO));
    }

    @Override
    public Page<CharacterBuiltModel> pageAllByUserId(Long id, Pageable pageable) {
        return characterBuiltRepository.findByUserId(id, pageable);
    }

    @Override
    @Transactional
    public CharacterBuiltModel createByUserId(BuildRequest buildDTO) throws ExecutionException, InterruptedException {
        var producer = new KafkaProducer<String, String>(properties());

        var characterBuilt = new CharacterBuiltModel();
        var character = characterService.findById(buildDTO.getCharacterId());
        var esper = esperService.findById(buildDTO.getEsperId());
        var user = userService.findById(buildDTO.getUserId());
        var reaction = reactionService.findById(buildDTO.getReactionId());

        characterBuilt.setName(buildDTO.getName());
        characterBuilt.setCharacter(character);
        characterBuilt.setEsper(esper);
        characterBuilt.setUser(user);
        characterBuilt.setReaction(reaction);

        characterBuiltRepository.save(characterBuilt);

        characterBuiltJobService.saveBuildJobs(buildDTO.getJobsId(), characterBuilt);
        characterBuiltEquipmentService.saveEquipmentsBuild(buildDTO.getEquipmentsId(), characterBuilt);
        characterBuiltSupportAbilityService.saveSupportAbilitiesBuild(buildDTO.getSupportAbilityId(), characterBuilt);
        characterBuiltVisionCardService.saveVisionCardBuild(buildDTO.getVisionCards(), characterBuilt);

        var value = characterBuilt.getId().toString();
        var record = new ProducerRecord<>("BUILT_CREATED", value, value);
        producer.send(record, (data, ex) ->{
            if(ex != null){
                ex.printStackTrace();;
                return;
            }
            System.out.println("Build criada com sucesso: " + data.topic() + ":::partition " + data.partition() + "/ offset " + data.offset() + "/ timestamp " + data.timestamp());
        }).get();

        return characterBuilt;
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //properties.setProperty(ProducerConfig.);
        return properties;
    }

    @Override
    public List<CharacterBuiltResumedResponse> findResumedBuildByUserId(Long userId) {
        var buildResumedResponses = new ArrayList<CharacterBuiltResumedResponse>();
        var characterBuilts = characterBuiltRepository.findByUserId(userId);
        characterBuilts.forEach(characterBuilt -> {
            var buildResumedResponse = new CharacterBuiltResumedResponse();
            var visionCards = characterBuiltVisionCardService.findByBuiltId(characterBuilt.getId());
            var equipments = characterBuiltEquipmentService.findByBuildId(characterBuilt.getId());
            buildResumedResponse.setId(characterBuilt.getId());
            buildResumedResponse.setName(characterBuilt.getName());
            buildResumedResponse.setCharacter(CharacterMapper.INSTANCE.mapToDTO(characterBuilt.getCharacter()));
            buildResumedResponse.setEsper(EsperMapper.INSTANCE.mapToDTO(characterBuilt.getEsper()));
            buildResumedResponse.setVisioncards(visionCards.stream().map(VisionCardMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
            buildResumedResponse.setEquipments(equipments.stream().map(EquipmentMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
            buildResumedResponses.add(buildResumedResponse);
        });
        return buildResumedResponses;
    }

    @Override
    public CharacterBuiltDetailedResponse findDetailedBuildById(Long id) {
        var detailedBuild = new CharacterBuiltDetailedResponse();
        var characterBuilt = characterBuiltRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(CHARACTER_BUILT_NAO_ENCONTRADO));
        var visionCards = characterBuiltVisionCardService.findByBuiltId(characterBuilt.getId());
        var equipments = characterBuiltEquipmentService.findByBuildId(characterBuilt.getId());
        var jobs = characterBuiltJobService.findByBuildId(characterBuilt.getId());
        var supportAbilities = characterBuiltSupportAbilityService.findByBuildId(characterBuilt.getId());
        detailedBuild.setId(characterBuilt.getId());
        detailedBuild.setName(characterBuilt.getName());
        detailedBuild.setCharacter(CharacterMapper.INSTANCE.mapToDTO(characterBuilt.getCharacter()));
        detailedBuild.setEsper(EsperMapper.INSTANCE.mapToDTO(characterBuilt.getEsper()));
        detailedBuild.setVisioncards(visionCards.stream().map(VisionCardMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
        detailedBuild.setEquipments(equipments.stream().map(EquipmentMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
        detailedBuild.setJobs(jobs.stream().map(JobMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
        detailedBuild.setSupportAbilities(supportAbilities.stream().map(SupportAbilityMapper.INSTANCE::mapToDTO).collect(Collectors.toList()));
        return detailedBuild;
    }
}
