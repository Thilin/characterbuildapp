package com.example.characterbuilderapp.validator;

import br.com.fluentvalidator.AbstractValidator;
import com.example.characterbuilderapp.dto.BuildRequest;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static java.util.function.Predicate.*;

@Component
public class CreateCharacterBuildValidator extends AbstractValidator<BuildRequest> {

    @Override
    public void rules() {
        ruleFor(BuildRequest::getName).must(not(String::isEmpty))
                .withMessage("Build name must not be null or empty")
                .withFieldName("name");
    }
}
