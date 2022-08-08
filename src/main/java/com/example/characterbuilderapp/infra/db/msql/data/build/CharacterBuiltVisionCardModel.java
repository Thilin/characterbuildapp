package com.example.characterbuilderapp.infra.db.msql.data.build;

import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_character_built_vision_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterBuiltVisionCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CBV_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CBV_VCD_ID")
    private VisionCardModel visionCard;

    @ManyToOne
    @JoinColumn(name = "CBV_CHB_ID")
    private CharacterBuiltModel characterBuilt;
}
