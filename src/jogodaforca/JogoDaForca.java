/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodaforca;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author KENZO
 */
public class JogoDaForca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String secretWord = "";
        
        do{
            secretWord = JOptionPane.showInputDialog(null, "Informe a palavra secreta", "Palavra Secreta", 3).toLowerCase();
        }while(secretWord.equals("") && secretWord.length() == 0 || secretWord.length() == 1);
        
        int qtdLetras = secretWord.length();
        int qtdVidas = 7;
        String chute = "";
        //char[] buffer =  new char[6+qtdLetras];
        String bufferString;
        String interfaceWord = "";
        for(int i = 0; i<qtdLetras; i++){
            interfaceWord += "-";
        }
        
        StringBuilder sb = new StringBuilder(interfaceWord);
        StringBuilder buffer = new StringBuilder("");
        
        System.out.println("Certo! Caro jogador, o jogo funcionará da seguinte maneira: ");
        System.out.println("Você deve descobrir a palavra secreta. Para isso, você pode chutar a palavra ou chutar uma letra.");
        System.out.println("Caso você acerte a palavra, o jogo termina, caso acertar a letra, a palavra secreta será preenchida com ela.");
        System.out.println("Mas, atenção! Se a letra informada não estiver presente na palavra, você perde 1 das 7 vidas que possui.");
        System.out.println("Se a palavra estiver errada, você perde todas as suas vidas!");
        System.out.println("Portanto, chute com cuidado e inteligência, divirta-se!!!\n\n");
        
        System.out.println(interfaceWord);
        while(qtdVidas != 0 && !secretWord.equals(sb.toString())){
            System.out.println("Digite uma letra ou informe a palavra");
            chute = sc.nextLine();
            bufferString = buffer.toString();
            if(chute.length() == 1){ // verifica se foi tentado uma letra
                if(bufferString.contains(chute)){ //verifica se a letra já foi tentada antes
                    System.out.println("\nAcho que vc já tentou esta letra antes...\nTente novamente!!!");
                }
                else{
                    buffer.append(chute);
                    if(secretWord.matches(".*"+chute+".*")){ //a letra está contida na palavra
                        System.out.println("Você acertou uma letra!");
                        MostraTentativas(qtdLetras, buffer);
                        interfaceWord = MontaPalavra(chute, secretWord, sb);
                        System.out.println("Palavra Secreta: " + interfaceWord);
                    }
                    else { 
                        qtdVidas--;
                        System.out.println("Você errou! Possui agora " + qtdVidas + " vidas!");
                        MostraTentativas(qtdLetras, buffer);
                        interfaceWord = MontaPalavra(chute, secretWord, sb);
                        System.out.println("Palavra Secreta: " + interfaceWord);
                    }
                }
            }
            else if(chute.length() > 1){ //foi tentado uma palavra
                if(chute.equals(secretWord)){
                    break;
                }
                else{
                    qtdVidas = 0;
                    System.out.println("Você errou! Possui agora " + qtdVidas + " vidas!");
                }
            }
        }
        
        if(qtdVidas == 0)
            System.out.println("Game Over!");
        else{
            System.out.println("Parabéns, você acertou a palavra!!!");
            System.out.println("Fim de jogo!!!");
        }
    }
    
    static String MontaPalavra(String chute, String secretWord, StringBuilder sb){
        char chuteLetra = chute.charAt(0);
        char letra;
        for(int i=0; i<secretWord.length(); i++){ //percorre a String para encontrar todas as ocorrências do valor de entrada
            letra = secretWord.charAt(i);
            if(letra == chuteLetra){
                sb.setCharAt(i, chute.charAt(0));
            }
        }
        return sb.toString();
    }
    
    
    static void MostraTentativas(int qtdLetras, StringBuilder buffer){
        if(buffer.length() > 0){
            StringBuilder tentativas = new StringBuilder(buffer.toString());
            for(int i = 1;i<tentativas.length(); i=i+2){
                tentativas.insert(i, ",");
            }
            System.out.println("\n\nPalpites tentados: " +  tentativas.toString());
        }
    }
    
    /*static void MostraTentativas(int qtdLetras, StringBuilder buffer){
        if(buffer.length() > 0){
            System.out.println(buffer.toString());
            StringBuilder tentativas = new StringBuilder(buffer.toString());
            int qtdLetrasPosFormat = tentativas.length();
            for(int i = 1;i<tentativas.length(); i=i+2){
                System.out.println("Qtd Letras tentadas: " + buffer.length());
                //System.out.println(buffer.charAt(i));
                tentativas.insert(i, ",");
                System.out.println("var tentativas: " + tentativas.toString());
                System.out.println("var buffer: " + buffer.toString());
                System.out.println("Qtd caracteres do buffer após adição do ',': " + tentativas.length());
            }
            System.out.println("Palpites tentados: " +  tentativas.toString());
        }
    }*/
    //buffer contem as letras tentadas
    //tentativa deverá conter as letras tentadas mais "," entre as letras
}


//Algorítmo de inserção da letra:
// percore a String secretWord, a cada índice obter o char e compará-lo com o valor de entrada
// se for igual, pega o indice correspondente e e insere o valor de entrada no respectivo indice da string interfaceWord
//repetir processo até o fim da String secretWord

//Algorítmo para verificar se a letra informada já foi digitada
//vetor de 6 + secretWord.length() caracteres - no pior dos casos o usuário digitará 6 caracteres errados, que não poderão ser digitados novamente.
//Dessa maneira, sobrará uma vida para conseguir acertar todas as letras da palavra
//supondo que a palavra seja : teste.
//Teste possui 5 letras, o vetor portanto terá que suportar os 6 caracteres incorretos + 5 caracteres corretos = 11
//A cada vez que o usuário digitar uma nova letra, deve-se comparar com os já inseridos no vetor
//Se for igual, mensagem: "Esta letra já foi digitada!"
//Se não, segue a rotina normal do código

//Algorítmo para verificar se a letra informada já foi digitada(2)
//Criar um StringBuilder que inicia em "" e recebe um append a cada letra inserida
//antes de inserir verifica se o StringBuilder contém a letra informada
//se conter, mensagem: "Esta letra já foi digitada!"
//se n, seguir rotina normal do código

//Algorítmo para mostrar tentativas
//Pega o StringBuilder buffer
//realizar insert entre as letras com o caractere ","
//retornar buffer.toString()
//imprimir antes do interfaceWord
