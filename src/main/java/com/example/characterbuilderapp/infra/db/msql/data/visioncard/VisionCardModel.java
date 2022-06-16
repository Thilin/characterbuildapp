package com.example.characterbuilderapp.infra.db.msql.data.visioncard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_vision_card")
public class VisionCardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VCD_ID")
    private Long id;

    @Column(name = "VCD_NAME")
    private String description;

    @Column(name = "VCD_IMAGE")
    private String image;
}
