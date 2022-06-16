package com.example.characterbuilderapp.infra.db.msql.data.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_job")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_ID")
    private Long id;

    @Column(name = "JOB_DESCRIPTION")
    private String description;

    @Column(name = "JOB_IMAGE")
    private String image;
}
