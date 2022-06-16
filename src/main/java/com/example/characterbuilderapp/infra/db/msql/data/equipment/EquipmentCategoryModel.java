package com.example.characterbuilderapp.infra.db.msql.data.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_equipment_category")
public class EquipmentCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ECA_ID")
    private Long id;

    @Column(name = "ECA_DESCRIPTION")
    private String description;
}