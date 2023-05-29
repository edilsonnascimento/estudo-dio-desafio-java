package mudanca;

// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma:
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MudancaParaIrlanda {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Leitura do salário e dos benefícios
        double salarioBruto = input.nextDouble();
        double beneficios = input.nextDouble();

        //TODO: Implemente as regras para o cálculo do imposto.
        double aliquota = 0.0;
        if (salarioBruto <= 1100.00) {
            aliquota = 0.05;
        }else if (salarioBruto >= 1100.01 && salarioBruto < 2500.00) {
            aliquota = 0.10;
        } else if (salarioBruto >= 2500.00) {
            aliquota = 0.15;
        }
        double imposto = salarioBruto * aliquota;

        // Cálculo do salário líquido
        double salarioLiquido = (salarioBruto - imposto) + beneficios;

        //TODO: Imprimir o salário líquido com 2 casas decimais.
        System.out.println(new BigDecimal(salarioLiquido).setScale(2, RoundingMode.HALF_EVEN));
    }
}
