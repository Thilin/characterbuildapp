package com.example.characterbuilderapp.core.operations.visioncard;

import com.example.characterbuilderapp.domain.visioncard.VisionCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListVisionCardsOperation {

    private List<VisionCard> visionCards;
}
