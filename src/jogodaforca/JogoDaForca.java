/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodaforca;

import java.util.Scanner;

/**
 *
 * @author ALUNO
 */
public class JogoDaForca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a palavra secreta para iniciarmos o jogo!");
        String secretWord = sc.nextLine();
        int qtdLetras = secretWord.length();
        
        String interfaceWord = "_";
        for(int i = 1; i<qtdLetras; i++){
            interfaceWord += "_";
        }
        
        StringBuilder sb = new StringBuilder(interfaceWord);
        
        int qtdVidas = 7;
        // int index = 0;
        char posicao = ' ';
        String chute = "";
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Certo! Caro jogador, o jogo funcionará da seguinte maneira: ");
        System.out.println("Você deve descobrir a palavra secreta. Para isso, você pode chutar a palavra ou chutar uma letra.");
        System.out.println("Caso você acerte a palavra, o jogo termina, caso acertar a letra, a palavra secreta será preenchida com ela.");
        System.out.println("Caso a palavra esteja incorreta, ou a letra informada não esteja presente na palavra, você perde 1 das 7 vidas que possui.");
        System.out.println("Portanto, chute com cuidado e inteligência, divirta-se!!!");
        
        while(qtdVidas != 0){
            System.out.println("Digite uma letra ou informe a palavra");
            chute = sc.nextLine();
            if(chute.length() == 1){
                //System.out.println(secretWord.matches(".*"+chute+".*"));
                if(secretWord.matches(".*"+chute+".*")){
                    System.out.println("Você acertou uma letra!");
                    /*index = secretWord.indexOf(chute);
                    // posicao = interfaceWord.charAt(index);
                    
                    sb.setCharAt(index, chute.charAt(0));
                    interfaceWord = sb.toString();
                    System.out.println(interfaceWord);*/
                    MostraPalavra(chute, secretWord, interfaceWord, sb);
                }
                else {
                    qtdVidas--;
                    System.out.println("Você errou! Possui agora " + qtdVidas + " vidas!");
                }
            }
            else if(chute.length() > 1){
                if(chute.equals(secretWord)){
                    System.out.println("Parabéns, você acertou a palavra!!!");
                    System.out.println("Fim de jogo!!!");
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
    }
    
    static void MostraPalavra(String chute, String secretWord, String interfaceWord, StringBuilder sb){
        //StringBuilder sb = new StringBuilder(interfaceWord);
        
        int index = secretWord.indexOf(chute);
                    // posicao = interfaceWord.charAt(index);
                    
        sb.setCharAt(index, chute.charAt(0));
        interfaceWord = sb.toString();
        System.out.println(interfaceWord);
    }
}
