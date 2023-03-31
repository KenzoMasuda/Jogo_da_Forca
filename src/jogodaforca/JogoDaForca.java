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
        String secretWord = JOptionPane.showInputDialog(null, "Informe a palavra secreta", "Palavra Secreta", 3).toLowerCase();
        int qtdLetras = secretWord.length();
        int qtdVidas = 7;
        String chute = "";
        String interfaceWord = "";
        for(int i = 0; i<qtdLetras; i++){
            interfaceWord += "*";
        }
        
        StringBuilder sb = new StringBuilder(interfaceWord);
         
        System.out.println("Certo! Caro jogador, o jogo funcionará da seguinte maneira: ");
        System.out.println("Você deve descobrir a palavra secreta. Para isso, você pode chutar a palavra ou chutar uma letra.");
        System.out.println("Caso você acerte a palavra, o jogo termina, caso acertar a letra, a palavra secreta será preenchida com ela.");
        System.out.println("Caso a palavra esteja incorreta, ou a letra informada não esteja presente na palavra, você perde 1 das 7 vidas que possui.");
        System.out.println("Portanto, chute com cuidado e inteligência, divirta-se!!!");
        //qtdVidas != 0 || 
        while(qtdVidas != 0 && !secretWord.equals(sb.toString())){
            System.out.println("Digite uma letra ou informe a palavra");
            chute = sc.nextLine();
            if(chute.length() == 1){
                if(secretWord.matches(".*"+chute+".*")){
                    System.out.println("Você acertou uma letra!");
                    //sb = MontaPalavra(chute, secretWord, sb);
                    MontaPalavra(chute, secretWord, sb);
                    System.out.println(sb.toString());
                }
                else {
                    qtdVidas--;
                    System.out.println("Você errou! Possui agora " + qtdVidas + " vidas!");
                }
            }
            else if(chute.length() > 1){
                if(chute.equals(secretWord)){
                    break;
                }
                else{
                    qtdVidas--;
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
    
    static void MontaPalavra(String chute, String secretWord, StringBuilder sb){
        char chuteLetra = chute.charAt(0);
        char letra;
        for(int i=0; i<secretWord.length(); i++){ //percorre a String para encontrar todas as ocorrências do valor de entrada
            letra = secretWord.charAt(i);
            if(letra == chuteLetra){
                sb.setCharAt(i, chute.charAt(0));
                //interfaceWord = sb.toString();
                
            }
        }
    }
    /*static StringBuilder MontaPalavra(String chute, String secretWord, StringBuilder sb){
        char chuteLetra = chute.charAt(0);
        char letra;
        for(int i=0; i<secretWord.length(); i++){ //percorre a String para encontrar todas as ocorrências do valor de entrada
            letra = secretWord.charAt(i);
            if(letra == chuteLetra){
                sb.setCharAt(i, chute.charAt(0));
                //interfaceWord = sb.toString();
                
            }
        }
        return sb;
    }*/
}


//Algorítmo de inserção da letra:
// percore a String secretWord, a cada índice obter o char e compará-lo com o valor de entrada
// se for igual, pega o indice correspondente e e insere o valor de entrada no respectivo indice da string interfaceWord
//repetir processo até o fim da String secretWord