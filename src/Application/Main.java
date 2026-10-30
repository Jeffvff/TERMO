package Application;

import Entities.JogoController;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        JogoController jogo = new JogoController();
        boolean veriMenu = false;

        System.out.println("\u001B[91m" + "ERRO" + "\u001B[0m");

        System.out.println("\u001B[33m" + "AVISO" + "\u001B[0m");

        System.out.println("\u001B[32m" + "SUCESSO" + "\u001B[0m");

        if (jogo.escolherPalavra() == null) {
            System.out.println("Lista Vazia!");
        } else {
            veriMenu = true;
        }

        while(veriMenu) {
            String palavraSorteada = jogo.escolherPalavra();
            String palavraJogador = "";

            boolean ganhou = false;

            System.out.println("[][][][][]");

            do {
                do {
                    System.out.print("Escolha uma palavra de 5 letras: ");
                    palavraJogador = sc.next().toLowerCase().trim();

                    if (!jogo.verificarPalavra(palavraJogador)) {
                        System.out.println("A palavra deve conter exatamente 5 letras. Tente novamente!");
                    }

                } while (!jogo.verificarPalavra(palavraJogador));

                System.out.print(jogo.jogarRodada(palavraJogador));

                if (palavraJogador.equals(palavraSorteada)) {
                    System.out.println("Você acertou!");
                    ganhou = true;
                }

            } while (!ganhou);








            veriMenu = false;
        }







    }
}
