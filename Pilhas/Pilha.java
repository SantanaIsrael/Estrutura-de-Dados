public class Pilha<T extends Comparable<T>> extends Lista<T>{
    //Metodo push que coloca um objeto na pilha
    public void push(T data){
        setRearList(data);
    }//Fim push

    //Retorna o tamanho da pilha
    public int stackSize(){
        return getSizeList();
    }//Fim stackSize

    //Retorna verdadeiro se a pilha estiver vazia
    public boolean isEmpty(){
        if(getSizeList() == 0){
            return true;
        }else{
            return false;
        }
    }//Fim isEmpty

    //Metodo pop que remove um objeto da pilha
    public T pop(){
        if(getSizeList() == 0){
            System.out.printf("Pilha cheia\n");
            System.exit(-1);
        }
        T v = removeRear();
        return v;
    }//Fim pop

    //Metodo stackTop que retorna o objeto que está no topo da pilha
    public T stackTop(){
        if(getSizeList() == 0){
            System.out.printf("Pilha vazia\n");
            System.exit(-1);
        }
        T temp = pop();
        setRearList(temp);
        return temp;
    }//Fim pop
}//Fim classe Stack