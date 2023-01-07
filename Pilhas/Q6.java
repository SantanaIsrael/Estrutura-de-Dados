import java.util.Scanner;

public class Q6{
    public static void main(String[] args){
        Scanner tecladoScanner = new Scanner(System.in);
        String respString;
        Carro[] c = new Carro[10];
        int p;
        Pilha<Carro> pilhaCarro1 = new Pilha<Carro>();
        Pilha<Carro> pilhaCarro2 = new Pilha<Carro>();

        for(int i = 0; i < 10;){
            System.out.printf("Digite E para dar entrada ou S para sair: ");
            respString = tecladoScanner.nextLine();
            
            if(respString.equals("E") || respString.equals("e")){
                System.out.printf("Qual a placa do carro: ");
                c[i] = new Carro();
                c[i].setPlaca(tecladoScanner.nextInt());
                tecladoScanner.nextLine();
                ++i;
            }else{
                System.out.printf("Qual a placa do carro para a retirada: ");
                p = tecladoScanner.nextInt();
                tecladoScanner.nextLine();

                int j;
                int pos = 0;
                for(j = 0; j < i; j++){
                    Carro var;

                    if(c[j].getPlaca() != p){
                        if(pilhaCarro1.stackSize() > 0){
                            if(c[j].getPlaca() == -1){
                                c[j].setManobra(0);
                            }else{
                                c[j].setManobra(1);
                            }

                            var = c[j];
                            pilhaCarro1.push(var);
                        }else{
                            pos++;
                        }
                    }else{
                        Carro carroN = new Carro();
                        carroN.setPlaca(-1);
                        c[j] = carroN;
                        var = c[j];
                        pilhaCarro1.push(var);
                    }
                }

                for(int k = pos + 1; k < j; k++){
                    pilhaCarro2.push(pilhaCarro1.pop());
                }
                pilhaCarro1.pop();

                for(int k = pos + 1; k < j; k++){
                    c[k] = pilhaCarro2.pop();
                }

                for(int k = 0; k < i; k++){
                    System.out.println(c[k]);
                }
            }
        }
        tecladoScanner.close();
    }
}