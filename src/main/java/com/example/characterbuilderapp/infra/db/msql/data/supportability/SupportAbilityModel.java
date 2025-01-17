package com.example.characterbuilderapp.infra.db.msql.data.supportability;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_support_ability")
public class SupportAbilityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAB_ID")
    private Long id;

    @Column(name = "SAB_DESCRIPTION")
    private String description;

    @OneToOne
    @JoinColumn(name = "SAB_JOB_ID", referencedColumnName = "JOB_ID")
    private JobModel job;
}
