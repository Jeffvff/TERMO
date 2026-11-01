package Application;

import Entities.JogoController;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        JogoController jogo = new JogoController();
        boolean veriMenu = false;

        System.out.println("\u001B[32mBem Vindo\u001B[33m ao termo\u001B[34mV2\u001B[91m do Jeferson\u001B[0m");

        if (jogo.escolherPalavra() == null) {
            System.out.println("Lista Vazia!");
        } else {
            veriMenu = true;
        }
        int menu = 0;

        do {
            System.out.printf("[1] - Iniciar Jogo%n[2] - Adicionar Palavras%n[0] - Sair%nSelecione: ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
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
                    break;
                case 2:



                    break;
                case 0:
                    System.out.println("Fechando Programa!6");

                    break;
                default:
                    System.out.println("Opção invalida, tente novamente!");
                    break;
            }
        } while(menu != 0);




    }
}
