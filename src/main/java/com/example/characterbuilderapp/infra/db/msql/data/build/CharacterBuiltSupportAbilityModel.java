package com.example.characterbuilderapp.infra.db.msql.data.build;

import com.example.characterbuilderapp.infra.db.msql.data.supportability.SupportAbilityModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built_support_ability")
public class CharacterBuiltSupportAbilityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CSH_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CSH_SAB_ID")
    private SupportAbilityModel supportAbility;

    @ManyToOne
    @JoinColumn(name = "CSH_CHB_ID")
    private CharacterBuiltModel characterBuilt;
}
