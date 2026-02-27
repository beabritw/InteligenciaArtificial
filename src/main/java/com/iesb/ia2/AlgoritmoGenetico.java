package com.iesb.ia2;

import java.util.Arrays;
import java.util.Random;

/*
  * PSEUDOCODIGO REFATORADO:
 \*
  * função inicializarPop (nInd, cromLim)
    nCrom = tamanho_linhas(cromLim)
    matriz pop[nInd, nCrom] // Você PRECISA desta variável para guardar os dados

    para i de 0 ate nInd - 1
        para j de 0 ate nCrom - 1
            inf = cromLim[j, 0]
            sup = cromLim[j, 1]
            pop[i, j] = randomico() * (sup - inf) + inf
        fim para
    fim para

    retorne pop

    fim função
 \*
 \*
  * */

public class AlgoritmoGenetico {

    public int[][] novaPopulacao(Integer numeroIndividuo, Integer[][] limiteCromossomos){
        int numeroCromossomos = limiteCromossomos.length;
        int[][] populacao = new int[numeroIndividuo][numeroCromossomos];
        Random random = new Random();

        for(int i = 0; i < numeroIndividuo; i++){
            for(int j = 0; j < numeroCromossomos; j++){
                Integer limiteInferior = limiteCromossomos[j][0];
                Integer limiteSuperior = limiteCromossomos[j][1];

                populacao[i][j] = random.nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
            }
        }

        return populacao;
    }


    public static void main (String[] args){

        AlgoritmoGenetico algoritmoGenetico = new AlgoritmoGenetico();
        Integer[][] limites = {{0,9}, {0,9}, {0, 9}, {0, 9}, {0, 9}}; //quantidade de carcateres (ex: numeros da senha, seriam 5 numeros de 0 a 9)

        int[][] populacao01 = algoritmoGenetico.novaPopulacao(5, limites);

        System.out.println("Indivíduos da populacao: ");
        for(int i = 0; i < populacao01.length; i ++){
            System.out.println("Indivíduo " + i + ": " + Arrays.toString(populacao01[i]));
        }

    }
}

