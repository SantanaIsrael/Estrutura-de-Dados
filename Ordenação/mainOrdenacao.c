#include <stdio.h>
#include <stdlib.h>
#include "ordenacao.h"

int main(void){
    gente vetor[N];    
    //int vetor[N]  = {45, 50, 72, 5, 28, 100, 1, -1, 2, 7};

    printf("\n-----------------------------------------\n");
    inserePessoa(vetor);
    printf("Imprimindo vetor antes da ordenacao.\n");
    imprimePessoa(vetor, N);

    printf("Ordenando vetor - Insert Sort\n");
    insertSort(vetor, N);

    printf("Imprimindo vetor apos a ordenacao\n");
    imprimePessoa(vetor, N);

   /* printf("\n-----------------------------------------\n");

    printf("CRIANDO OUTRO VETOR\n\n");
    criaVetor(vetor2);

    printf("Imprimindo vetor antes da ordenacao.\n");
    imprimeVetor(vetor2, N);

    printf("Ordenando vetor - Bubble Sort\n");
    bubbleSort(vetor2, N);

    printf("Imprimindo vetor\n");
    imprimeVetor(vetor2, N);

    printf("\n-------------------FIM----------------------\n");

    system("pause");
    system("cls");

    printf("\n-----------------------------------------\n");

    printf("CRIANDO OUTRO VETOR\n\n");
    criaVetor(vetor2);
    
    printf("Imprimindo vetor antes da ordenacao.\n");
    imprimeVetor(vetor, N);
    
    printf("Ordenando vetor - Select Sort\n");
    selectSort(vetor, N);
    printf("Imprimindo vetor depois da ordenacao\n");
    imprimeVetor(vetor, N);
    
    printf("\n-------------------FIM----------------------\n");


    system("pause");
    system("cls");*/
    
    return 0;
}
