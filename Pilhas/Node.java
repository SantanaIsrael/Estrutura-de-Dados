public class Node<T>{
    //Atributos da classe Node
    public T dados; //Objeto generico que o nó armazena
    public Node<T> proximNode; //Nó para o proximo objeto
    public Node<T> anteriorNode; //Nó para o ojeto anterior

    //Construtor que recebe um dado generico
    Node(T dados){
        this.dados = dados;
        this.proximNode = null;
        this.anteriorNode = null;
    }//fim
}//Fim classe Node