package com.example.characterbuilderapp.infra.db.msql.data.build;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterModel;
import com.example.characterbuilderapp.infra.db.msql.data.esper.EsperModel;
import com.example.characterbuilderapp.infra.db.msql.data.user.UserModel;
import com.example.characterbuilderapp.infra.db.msql.data.visioncard.VisionCardModel;
import com.example.characterbuilderapp.infra.db.msql.data.reaction.ReactionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built")
public class CharacterBuiltModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHB_ID")
    private Long id;

    @Column(name = "CHB_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "CHB_VCD_ID", referencedColumnName = "VCD_ID")
    private VisionCardModel visionCard;

    @OneToOne
    @JoinColumn(name = "CHB_ESP_ID", referencedColumnName = "ESP_ID")
    private EsperModel esper;

    @OneToOne
    @JoinColumn(name = "CHB_CTR_ID", referencedColumnName = "CTR_ID")
    private CharacterModel character;

    @OneToOne
    @JoinColumn(name = "CHB_USR_ID", referencedColumnName = "USR_ID")
    private UserModel user;

    @OneToOne
    @JoinColumn(name = "CHB_REA_ID", referencedColumnName = "REA_ID")
    private ReactionModel reaction;
}