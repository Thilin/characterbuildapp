package com.example.characterbuilderapp.infra.db.msql.data.character;

import com.example.characterbuilderapp.infra.db.msql.data.element.ElementModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_character")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CTR_ID")
    private Long id;

    @Column(name = "CTR_NAME")
    private String name;

    @Column(name = "CTR_IMAGE")
    private String image;

    @Column(name = "CTR_RARITY")
    private String rarity;

    @OneToOne
    @JoinColumn(name = "CTR_ELE_ID", referencedColumnName = "ELE_ID")
    private ElementModel element;
}
