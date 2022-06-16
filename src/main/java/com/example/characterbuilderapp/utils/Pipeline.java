package com.example.characterbuilderapp.utils;

import lombok.Getter;

/*
Reprecenta um processamento linear em várias etapas
Cada etapa é executada utilizando uma mónade de transformação que recebe como input o resultado do passo anterior.
O resultado dessa etapa serve então como input da próxima e assim por diante.

Exemplo de conversão de um uuid para string em maiusculo

String output = Pipeline
                    .given(UUID.randomUUID())
                    .process(uuid -> uuid.toString())
                    .process(uuidString -> uuidString.toUpperCase())
                    .getOutput();

 */

// <T> O tipo de retorno de um processamento
public class Pipeline<T> {

    @Getter
    private final T output;

    private Pipeline(T output){
        this.output = output;
    }

    /*
    Inicia uma linha de processamento sem um input inicial.
    Retorna a etapa vazia(Void)
     */
     public static Pipeline<Void> startEmpty(){
        return new Pipeline<>(null);
     }

     /**
     Inicia uma linha de processamento com um input inicial
     * @param input O input inicial do processamento
      * @param <T2> O tipo deste imput inicial
      * @return Retorna a etapa baseada neste input inicial
      **/
     public static <T2> Pipeline<T2> given(T2 input){
        return new Pipeline<>(input);
     }

    /**
     * Executa uma etapa do processamento
     * @param processor A mónade de transformação que implementa a etapa de processamento
     * @param <T2> O tipo de retorno dessa etapa
     * @return Uma nova etapa que tem como input o resultado deste processamento
     */
     public  <T2> Pipeline<T2> process(Processor<T, T2> processor){
        final T2 newOutput = processor.process(output);
        return new Pipeline<>(newOutput);
     }
}
