//package com.example.characterbuilderapp.usecases.command.characterbuild;
//
//import com.example.characterbuilderapp.core.operations.CreateCharacterBuildOperation;
//import com.example.characterbuilderapp.core.business.characterbuild.CreateCharacterBuildCommand;
//import com.example.characterbuilderapp.usecases.processors.*;
//import com.example.characterbuilderapp.utils.Pipeline;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class CreateCharacterBuildCommandImpl implements CreateCharacterBuildCommand {
//
//    private final FindCharacterProcessor findCharacterProcessor;
//    private final FindEsperProcessor findEsperProcessor;
//    private final FindReactionProcessor findReactionProcessor;
//    private final FindUserProcessor findUserProcessor;
//    private final CreateCharacterBuiltProcessor createCharacterBuiltProcessor;
//
//    @Override
//    public CreateCharacterBuildOperation execute(CreateCharacterBuildOperation operation) {
//        return Pipeline
//                .given(operation)
//                .process(findCharacterProcessor)
//                .process(findEsperProcessor)
//                .process(findReactionProcessor)
//                .process(findUserProcessor)
//                .process(createCharacterBuiltProcessor)
//                .getOutput();
//    }
//}
