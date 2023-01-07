public class Q5{
    public static void main(String[] args){
        String eString = "{2 + [(16 + 2 ∧ 3) - 4)} * 3";
        Pilha<Character> pilha = new Pilha<Character>();
        
        for(int i = 0; i < eString.length(); i++){
            Character simboloCharacter = eString.charAt(i);

            if(simboloCharacter == '{' || simboloCharacter == '[' || simboloCharacter == '('){
                pilha.push(simboloCharacter);
            }else if(simboloCharacter == '}' || simboloCharacter == ']' || simboloCharacter == ')'){
                if(simboloCharacter == '}'){
                    simboloCharacter = '{';
                }else if(simboloCharacter == ']'){
                    simboloCharacter = '[';
                }else if(simboloCharacter == ')'){
                    simboloCharacter = '(';
                }

                if(pilha.isEmpty()){
                    System.out.printf("Equacao invalida\n");
                    System.exit(-1);
                }else if(simboloCharacter.compareTo(pilha.stackTop()) == 0){
                    pilha.pop();
                }else{
                    System.out.printf("Equacao valida\n");
                    System.exit(-1);
                }
            }
        }

        if(pilha.isEmpty()){
            System.out.printf("Equacao valida\n");
        }else{
            System.out.printf("Equacao invalida\n");
        }
    }
}