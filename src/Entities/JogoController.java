package Entities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class JogoController {
    private String palavraColorida = "";
    private String palavraEscolhida;

    public String getPalavraEscolhida() {
        return palavraEscolhida;
    }

    public String jogarRodada(String palavraJogador) {
        this.palavraColorida = "";

        char[] letrasPalavraJogador = palavraJogador.toCharArray();
        char[] letrasPalavraEscolhida = palavraEscolhida.toCharArray();

        boolean[] letrasUsadas = new boolean[5];

        for (int i = 0; i < letrasPalavraJogador.length; i++) {
            if (letrasPalavraJogador[i] == letrasPalavraEscolhida[i]) {
                letrasUsadas[i] = true;
            }
        }

        for (int i = 0; i < letrasPalavraJogador.length; i++) {
            int existe = 0;
            String caracterTemporario = "";

            if (letrasPalavraJogador[i] == letrasPalavraEscolhida[i]) {
                caracterTemporario = "\u001B[32m" + letrasPalavraJogador[i] + "\u001B[0m" + " "; // Verde

            } else {

                for (int j = 0; j < letrasPalavraEscolhida.length; j++) {
                    if (letrasPalavraJogador[i] == letrasPalavraEscolhida[j] && !letrasUsadas[j]) {
                        existe++;
                        letrasUsadas[j] = true;
                        break;
                    }
                }

                if (existe != 0) {
                    caracterTemporario = "\u001B[33m" + letrasPalavraJogador[i] + "\u001B[0m" + " "; // Amarelo

                } else {
                    caracterTemporario = "\u001B[91m" + letrasPalavraJogador[i] + "\u001B[0m" + " "; // Vermelho
                }
            }

            this.palavraColorida += caracterTemporario;
        }

        return String.format("%s%n", palavraColorida);
    }

    public boolean verificarPalavra(String palavraJogador) {
        palavraJogador = Normalizer.normalize(palavraJogador, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        if (palavraJogador.matches("[a-zA-Z]{5}")) {
            return true;
        }
        return false;
    }

    public String escolherPalavra() {

        Path arquivo = Path.of("palavras.txt");

        try {
            // Cria o arquivo caso não exista
            if (Files.notExists(arquivo)) {
                Files.createFile(arquivo);
            }

            // Lê todas as palavras
            List<String> palavras = Files.readAllLines(arquivo);

            // Verifica se o arquivo está vazio
            if (palavras.isEmpty()) {
                return null;
            }

            // Sorteia uma palavra
            Random random = new Random();
            int indice = random.nextInt(palavras.size());
            this.palavraEscolhida = palavras.get(indice).toLowerCase().trim();

            return palavraEscolhida;

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return null;
        }
    }




}