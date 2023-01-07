//Classe para a arvore binária
public class Tree<T extends Comparable<T>>{
    //Atributos da classe
    private NoArvore<T> raiz;
    private int tamanho;

    //Construtor
    public Tree(){
        raiz = null;
    }//Fim

    //construtor com parametro
    public Tree(T dado){
        insertTree(dado);
    }//Fim

    //Pega o tamanho da arvore
    public int getSizeTree(){
        return this.tamanho;
    }//Fim getSizeTree

    //Cria nó da arvore
    private NoArvore<T> createNode(NoArvore<T> node, T i){
        node.dado = i;
        node.pai = null;
        node.esquerdo = null;
        node.direito = null;
        ++tamanho;
        return node;
    }//Fim createNode

    //Insere um objeto na arvore
    public void insertTree(T i){
        if(raiz == null){
            NoArvore<T> newNode = new NoArvore<T>();
            newNode = createNode(newNode, i);
            raiz = newNode;
        }else{
            if(i.compareTo(raiz.dado) == -1){
                insertesquerdo(raiz, i);
            }else if(i.compareTo(raiz.dado) == 1){
                insertdireito(raiz, i);
            }
        }
    }//Fim insrtTree

    //Insere a esquerda
    private void insertesquerdo(NoArvore<T> node, T i){
        if(node.esquerdo == null){
            NoArvore<T> newNode = new NoArvore<T>();
            newNode = createNode(newNode, i);
            newNode.dado = i;
            node.esquerdo = newNode;
            newNode.pai = node;
            return;
        }else{
            if(i.compareTo(node.esquerdo.dado) <= 0){
                insertesquerdo(node.esquerdo, i);
            }else if(i.compareTo(node.esquerdo.dado) == 1){
                insertdireito(node.esquerdo, i);
            }
        }
    }//Fim insertesquerdo

    //Insere a direita da arvore
    private void insertdireito(NoArvore<T> node, T i){
        if(node.direito == null){
            NoArvore<T> newNode = new NoArvore<T>();
            newNode = createNode(newNode, i);
            newNode.dado = i;
            node.direito = newNode;
            newNode.pai = node;
            return;
        }else{
            if(i.compareTo(node.direito.dado) >= 0){
                insertdireito(node.direito, i);
            }else if(i.compareTo(node.direito.dado) == -1){
                insertesquerdo(node.direito, i);
            }
        }
    }

 
    public void imprimirArvoreCompleta(){
        imprimeArvore(raiz);
    }

    //Imprime os nós da arvore em ordem
    private void imprimeArvore(NoArvore<T> raiz){
        if(raiz != null){
            imprimeArvore(raiz.esquerdo);
            System.out.println(raiz.dado.toString());
            imprimeArvore(raiz.direito);
        }
    }

    //Calcula a altura de uma arvore
    public int heightTree(){
        return this.heightTree(raiz);
    }

    private int heightTree(NoArvore<T> raiz){
        if(raiz == null){
            return 0;
        }else{
            int l = heightTree(raiz.esquerdo);
            int r = heightTree(raiz.direito);

            if(l > r){
                return l + 1;
            }else{
                return r + 1;
            }
        }
    }
    
    //Verificações
    private boolean isComplete(NoArvore<T> raiz, int index, int nNodes){
        if (raiz == null){
            return true;
        }
 
        if (index >= nNodes){
            return false;
        }
 
        return isComplete(raiz.esquerdo, (2 * index) + 1, nNodes) && isComplete(raiz.direito, (2 * index) + 2, nNodes);
    }

  
    private boolean isMaxHeap(NoArvore<T> raiz){
        if (raiz.esquerdo == null && raiz.direito == null){
            return true;
        }
 
        if (raiz.direito == null) {
            return raiz.dado.compareTo(raiz.esquerdo.dado) == 1;
        }else{
            if (raiz.dado.compareTo(raiz.esquerdo.dado) == 1 && raiz.dado.compareTo(raiz.direito.dado) == 1){
                return isMaxHeap(raiz.esquerdo) && isMaxHeap(raiz.direito);
            }else{
                return false;
            }
        }
    }

 
    private boolean isMinHeap(NoArvore<T> raiz){
        if (raiz.esquerdo == null && raiz.direito == null){
            return true;
        }
 
        if (raiz.direito == null) {
            return raiz.dado.compareTo(raiz.esquerdo.dado) == 1;
        }else{
            if (raiz.dado.compareTo(raiz.esquerdo.dado) == -1 && raiz.dado.compareTo(raiz.direito.dado) == -1){
                return isMinHeap(raiz.esquerdo) && isMinHeap(raiz.direito);
            }else{
                return false;
            }
        }
    }

   
    public int isHeap(NoArvore<T> raiz){
        if (raiz == null){
            return 1;
        }
 
        int nodeCounter = this.tamanho;
 
        if (isComplete(raiz, 0, nodeCounter) == true && isMaxHeap(raiz) == true){
            return 1;
        }else if(isComplete(raiz, 0, nodeCounter) == true && isMinHeap(raiz) == true){
            return -1;
        }

        return 0;
    }

    public int isHeap(){
        return this.isHeap(this.raiz);
    }
}