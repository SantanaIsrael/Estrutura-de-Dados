#include "ordenacao.h"

// vetor[N]  = {45, 50, 72, 5, 28, 100, 1, -1, 2, 7};
//Gera vetor de forma randomica

void criaVetor(int *vetor)
{
    srand(time(NULL));
    for (int i = 0; i < N; i++)
    {
        vetor[i] = rand() % 20;
    }
}

//Métodos de ordenação
void insertSort(gente *vetor){
    int indice, i;
    gente copia;

    for (i = 1; i < N; i++)
    {
        indice = i;
        copia = vetor[i];
        while (indice > 0 && copia.matricula < vetor[indice - 1].matricula)
        {
            vetor[indice] = vetor[indice - 1];
            indice--;
        }
        vetor[indice] = copia;
    }
}

void selectSort(gente *vetor)
{
    int i, j, indexMenor;
    gente aux;

    for (j = 0; j < N - 1; j++)
    {
        indexMenor = j;
        for (i = j + 1; i < N; i++)
        {

            if (vetor[indexMenor].matricula > vetor[i].matricula)
            {
                indexMenor = i;
            }
        }
        if (vetor[indexMenor].matricula < vetor[j].matricula)
        {
            aux = vetor[indexMenor];
            vetor[indexMenor] = vetor[j];
            vetor[j] = aux;
        }
    }
}

/*void mergeSort(int *vetor, int inicio, int fim)
{
    if (inicio - fim > 1)
    {
        int meio = (inicio + fim) / 2;
        mergeSort(vetor, inicio, meio);
        mergeSort(vetor, meio, fim);
        merge(vetor, inicio, meio, fim);
    }    
}*/

void inserePessoa (gente *pessoa){
    for (int i = 0; i < N; i++){
        printf("\n------------- CADASTRANDO PESSOA [%d] ------------\n", i);
        printf("Matricula: ");
        scanf("%d", &pessoa[i].matricula);
        printf("Nome: ");
        scanf("%s", &pessoa[i].nome);
        printf("Nota: ");
        scanf("%f", &pessoa[i].nota);
        system("cls");
    }
}
void bubbleSort(gente *vetor)
{
    gente aux;
    for (int j = 0; j < N; j++)
    {
        for (int i = 0; i < N - 1; i++)
        {
            if (vetor[i + 1].matricula < vetor[i].matricula)
            {
                aux = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = aux;
            }
        }
    }
}
//Impressões
void imprimeVetor(int *vetor, int tamanho)
{
    printf("Vetor = [");
    for (int i = 0; i < tamanho; i++)
    {
        printf("%d", vetor[i]);
        if (i < tamanho - 1)
            printf(",");
    }
    printf("]\n");
}

void imprimePessoa(gente *pessoa){
    int i = 0;
    while (i < N)
    {
        printf("\n------------- IMPRIMINDO PESSOA [%d] -------------\n", i);
        printf("Matricula: %d\n", pessoa[i].matricula);
        printf("Nome: %s\n", pessoa[i].nome);
        printf("Nota: %.2f\n", pessoa[i].nota);
        printf("\n-----------------------------------------\n");
        i++;
    }
    printf("\n-------------------FIM----------------------\n");
    system("pause");
    system("cls");
    
}