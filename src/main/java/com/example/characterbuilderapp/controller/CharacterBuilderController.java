//package com.example.characterbuilderapp.controller;
//
//import com.example.characterbuilderapp.infra.db.msql.data.build.CharacterBuiltModel;
//import com.example.characterbuilderapp.dto.BuildRequest;
//import com.example.characterbuilderapp.dto.CharacterBuiltDetailedResponse;
//import com.example.characterbuilderapp.dto.CharacterBuiltResumedResponse;
//import com.example.characterbuilderapp.operations.CreateCharacterBuildOperation;
//import com.example.characterbuilderapp.service.CharacterBuiltService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//@RequestMapping("/builders")
//public class CharacterBuilderController {
//
//    private final CharacterBuiltService characterBuiltService;
//    private final CreateCharacterBuildCommand createCharacterBuildCommand;
//
//    public CharacterBuilderController(CharacterBuiltService characterBuiltService,
//                                      CreateCharacterBuildCommand createCharacterBuildCommand){
//        this.characterBuiltService = characterBuiltService;
//        this.createCharacterBuildCommand = createCharacterBuildCommand;
//    }
//
////    @PostMapping(value = "/build")
////    public ResponseEntity<CharacterBuilt> createBuild(@RequestBody BuildRequest dto) throws ExecutionException, InterruptedException {
////        return ResponseEntity.ok(characterBuiltService.createByUserId(dto));
////    }
//
//    @PostMapping(value = "/build")
//    public ResponseEntity<CharacterBuiltModel> createBuild(@RequestBody BuildRequest dto) throws ExecutionException, InterruptedException {
//        var operation = new CreateCharacterBuildOperation();
//        operation.setBuildRequest(dto);
//        var characterbuiltOperation = createCharacterBuildCommand.execute(operation);
//        return ResponseEntity.ok(characterbuiltOperation.getCharacterBuilt());
//    }
//
//    @GetMapping(value = "/{userId}")
//    public ResponseEntity<List<CharacterBuiltResumedResponse>> findResumedBuildByUserId(@PathVariable Long userId){
//        var response = characterBuiltService.findResumedBuildByUserId(userId);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping(value = "/{buildId}/detailed")
//    public ResponseEntity<CharacterBuiltDetailedResponse> findDetailedBuildByBuildId(@PathVariable Long buildId){
//        var response = characterBuiltService.findDetailedBuildById(buildId);
//        return ResponseEntity.ok(response);
//    }
//}
