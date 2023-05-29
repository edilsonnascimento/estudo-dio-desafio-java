package gerenciamento;

// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma:
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.util.Scanner;

public class LojaGeek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double media = scanner.nextDouble();
        String resultado = "";
        //TODO: Verifique a média lida e imprima a avaliação do funcionário.
        //Onde: "APR" é bom, "MED" é médio e "REP" é ruim.
        if(media <  5.0) {
            resultado = "REP";
        } else if (media >= 5.0 && media < 7.0) {
            resultado = "MED";
        } else if (media >= 7.0) {
            resultado = "APR";
        }
        System.out.println(resultado);
    }
}
