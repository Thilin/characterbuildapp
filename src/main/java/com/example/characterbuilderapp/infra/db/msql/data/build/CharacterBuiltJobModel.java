package com.example.characterbuilderapp.infra.db.msql.data.build;

import com.example.characterbuilderapp.infra.db.msql.data.character.CharacterJobModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_character_built_job")
public class CharacterBuiltJobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CBJ_ID")
    private Long id;

    @Column(name = "CBJ_ISMAIN")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "CBJ_CJO_ID")
    private CharacterJobModel characterJob;

    @ManyToOne
    @JoinColumn(name = "CBJ_CHB_ID")
    private CharacterBuiltModel characterBuilt;
}
