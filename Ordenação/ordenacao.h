#ifndef ordenacao_h
#define ordenacao_h
#define N 4
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct pessoa
{
    int matricula;
    char nome[50];
    float nota;
};
typedef struct pessoa gente;

void insertSort(gente*);
void bubbleSort(gente *);
void selectSort(gente*);
//impressões e incerções
void inserePessoa (gente *);
void imprimePessoa(gente *);
void imprimeVetor(int *, int);
void criaVetor (int *);
#endif