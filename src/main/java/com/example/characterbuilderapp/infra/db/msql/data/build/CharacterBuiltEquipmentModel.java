package com.example.characterbuilderapp.infra.db.msql.data.build;

import com.example.characterbuilderapp.infra.db.msql.data.equipment.EquipmentModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built_equipment")
public class CharacterBuiltEquipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CHE_EQP_ID")
    private EquipmentModel equipment;

    @ManyToOne
    @JoinColumn(name = "CHE_CHB_ID")
    private CharacterBuiltModel characterBuilt;
}
