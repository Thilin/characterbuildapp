package com.example.characterbuilderapp.core.operations.esper;


import com.example.characterbuilderapp.domain.esper.Esper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ListAllEspersOperation {

    private List<Esper> espers;
}
