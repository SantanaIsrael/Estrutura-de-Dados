public class NoArvore<T>{
    
    T dado; 
    NoArvore<T> pai; 
    NoArvore<T> esquerdo; 
    NoArvore<T> direito; 

    //Construtor
    public NoArvore(){
        this.dado = null;
        this.pai = null;
        this.esquerdo = null;
        this.direito = null;
    }
}