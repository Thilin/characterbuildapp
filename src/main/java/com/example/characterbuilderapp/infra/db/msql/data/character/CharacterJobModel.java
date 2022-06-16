package com.example.characterbuilderapp.infra.db.msql.data.character;

import com.example.characterbuilderapp.infra.db.msql.data.job.JobModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_character_job")
@Data
public class CharacterJobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CJO_ID")
    private Long id;

    @Column(name = "CJO_ISMAIN")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "CJO_JOB_ID")
    private JobModel job;

    @ManyToOne
    @JoinColumn(name = "CJO_CTR_ID")
    private CharacterModel character;
}
