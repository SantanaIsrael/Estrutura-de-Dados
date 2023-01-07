public class Q3{
    public static void main(String[] args){
        Tree<Integer> arvoTree = new Tree<Integer>();
        Integer i;

        i = 17;
        arvoTree.insertTree(i);

        i = 10;
        arvoTree.insertTree(i);

        i = 15;
        arvoTree.insertTree(i);

        i = 10;
        arvoTree.insertTree(i);
        System.out.println(arvoTree.heightTree());
    }
}