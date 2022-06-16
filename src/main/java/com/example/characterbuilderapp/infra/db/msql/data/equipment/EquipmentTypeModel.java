package com.example.characterbuilderapp.infra.db.msql.data.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_equipment_type")
public class EquipmentTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ETY_ID")
    private Long id;

    @Column(name = "ETY_DESCRIPTION")
    private String description;
}
