public class Lista<T extends Comparable<T>> implements LInterface<T>{
 
    private int tamanho = 0; 
    private Node<T> head; 
    private Node<T> tail; 

    //Construtor
    public Lista(){
        this.head = null;
        this.tail = null;
    }

  
    public int getSizeList(){
        return this.tamanho;
    }

    public void setFrontList(T dados){
        T d = dados;
        d = dados;
        insertFront(d);
    }

    
    public void setRearList(T dados){
        T d = dados;
        insertRear(d);
    }

  
    public void setInPositionList(T dados, int position){
        T d = dados;
        insertInPosition(d, position);
    }

 
    private void insertFront(T dados){
        Node<T> novNode = new Node<T>(dados);

        if(this.head == null){ 
            head = novNode;
            tail = novNode;
            ++tamanho;
        }else{ 
            novNode.proximNode = head;
            novNode.anteriorNode = tail;
            head.anteriorNode = novNode;
            tail.proximNode = novNode;
            head = novNode;
            ++tamanho;
        }
    }

    
    private void insertRear(T dados){
        Node<T> novNode = new Node<T>(dados);

        if(this.head == null){ 
            head = novNode;
            tail = novNode;
            ++tamanho;
        }else{ 
            novNode.proximNode = head;
            novNode.anteriorNode = tail;
            head.anteriorNode = novNode;
            tail.proximNode = novNode;
            tail = novNode;
            ++tamanho;
        }
    }


    private void insertInPosition(T dados, int position){
        if((position > this.tamanho) || (position < 1)){
            System.out.printf("Error in insertInPosition, invalid position!!\n\n");
            System.exit(-1);
        }

        if(position == 1){
            insertFront(dados);
            return;
        }else if(position == tamanho){
            insertRear(dados);
            return;
        }else{
            Node<T> novNode = new Node<T>(dados);
            Node<T> aux = head;
            int count;

            for(count = 1; count < (position - 1); count++){
                aux = aux.proximNode;
            }

            novNode.proximNode = aux.proximNode;
            novNode.anteriorNode = aux;
            aux.proximNode.anteriorNode = novNode;
            aux.proximNode = novNode;
            ++tamanho;
        }
    }

 
    @Override
    public T removeFront(){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        T temp = head.dados;

        if(head == tail){
            head = null;
            tail = null;
            tamanho = 0;
            return temp;
        }else{
            Node<T> aux = head;

            head = aux.proximNode;
            head.anteriorNode = tail;
            tail.proximNode = head;
            aux = null;
            --tamanho;
            return temp;
        }
    }

    @Override
    public T removeRear(){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        T temp = tail.dados;

        if(head == tail){
            head = null;
            tail = null;
            tamanho = 0;
            return temp;
        }else{
            Node<T> aux = tail;

            tail = aux.anteriorNode;
            tail.proximNode = head;
            head.anteriorNode = tail;
            aux = null;
            --tamanho;
            return temp;
        }
    }

    @Override
    public T removeInPosition(int position){
        if(head == null){
            System.out.printf("Error in removeFront, list is empty!!\n\n");
            System.exit(-1);
        }

        if((position > tamanho) || (position < 1)){
            System.out.printf("Error is removeInPosition, ivalid position!!\n");
            System.exit(-1);
        }

        if(position == 1){
            return removeFront();
        }else if(position == tamanho){
            return removeRear();
        }else{
            Node<T> aux = head;
            
            for(int i = 1; i < position; i++){
                aux = aux.proximNode;
            }
            T temp = aux.dados;

            aux.anteriorNode.proximNode = aux.proximNode;
            aux.proximNode.anteriorNode = aux.anteriorNode;
            aux = null;
            --tamanho;
            return temp;
        }
    }

 
    @Override
    public T removeItem(T d){
        Node<T> item = findNode(head, d);

        if((getSizeList() == 1) || item == head){
            return removeFront();
        }else if(item == tail){
            return removeRear();
        }else{
            T temp = item.dados;
            item.anteriorNode.proximNode = item.proximNode;
            item.proximNode.anteriorNode = item.anteriorNode;
            item = null;
            --(this.tamanho);
            return temp;
        }
    }

    public void printList(){
        if(head == null){
            System.out.printf("Erro ao imprimir a lista, porque esta vazia.\n");
            System.exit(-1);
        }
        printNode(this.head, this.head);
    }

    private void printNode(Node<T> h1, Node<T> h2){
        if(h1.proximNode == h2){
            System.out.println(h1.dados.toString());
            return;
        }
        System.out.println(h1.dados.toString());
        printNode(h1.proximNode, h2);
    }


    private Node<T> findNode(Node<T> node, T d){
        if(node.dados.compareTo(d) == 0){
            return node;
        }

        if(node == this.tail){
            System.out.println("Não consegui encontrar os dados.\n");
            System.exit(-1);
        }

        return findNode(node.proximNode, d);
    }
}