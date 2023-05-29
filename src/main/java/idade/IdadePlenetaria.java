package idade;

// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma:
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class IdadePlenetaria {
    private static double MARTE = 1.88;
    private static double VENUS = 0.62;
    private static double JUPITER = 11.86;
    private static String MENSAGEM_PADRAO = "Idade equivalente em %s: %s anos";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double idadeTerrestre = scanner.nextDouble();
        String planeta = scanner.next();

        String idadeEquivalente;
        String mensagem = "";

        //TODO: Crie as condições para calcular a idade equivalente de cada planeta.
        switch (planeta) {
            case "Jupiter": idadeEquivalente = calcularIdadeEquivalente(planeta, idadeTerrestre, JUPITER);
                mensagem = String.format(MENSAGEM_PADRAO, planeta, idadeEquivalente);
                break;
            case "Marte": idadeEquivalente = calcularIdadeEquivalente(planeta, idadeTerrestre, MARTE);
                mensagem = String.format(MENSAGEM_PADRAO, planeta, idadeEquivalente);
                break;
            case "Venus": idadeEquivalente = calcularIdadeEquivalente(planeta, idadeTerrestre, VENUS);
                mensagem = String.format(MENSAGEM_PADRAO, planeta, idadeEquivalente);
                break;
            default: mensagem = "Planeta invalido.";
        }

        //TODO: Imprima a saída conforme descrito neste desafio.
        System.out.println(mensagem);
        scanner.close();
    }

    private static String calcularIdadeEquivalente(String nomePlaneta, double idadeTerrestre, double constante) {
        return new BigDecimal(idadeTerrestre / constante).setScale(2,  RoundingMode.HALF_EVEN).toString();
    }
}

