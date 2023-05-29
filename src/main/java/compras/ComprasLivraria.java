package compras;
// Para ler e escrever dados em Java, aqui na DIO padronizamos da seguinte forma:
// - new Scanner(System.in): cria um leitor de Entradas, com métodos úteis com prefixo "next";
// - System.out.println:.imprime um texto de Saída (Output) e pulando uma linha.

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComprasLivraria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();

        // Instancia 2 objetos do tipo "Livro" com os dados de entrada.
        var cont = 1;
        while (cont < 3) {
            var titulo = scanner.nextLine();
            var valor = scanner.nextDouble();
            var quantidade = scanner.nextInt();
            scanner.nextLine();
            cont++;
            livros.add(new Livro(titulo, valor, quantidade));
        }

        //TODO: Considerando os objetos "livro1" e "livro2", calcule o valor total da compra.
        var soma = livros.stream().mapToDouble(t-> t.totalCompra).sum();
        BigDecimal totalValorCompra = new BigDecimal(soma).setScale(2, RoundingMode.HALF_EVEN);

        //TODO: Considerando os objetos "livro1" e "livro2", calcule o número de livros comprados.
        var quantidadeCompra = livros.stream().mapToInt(l-> l.quantidade).sum();

        //TODO: Imprima as linhas necessárias conforme a saída deste desafio.
        var mensagem = "" +
                "\n Valor total da compra: " + totalValorCompra +
                "\n Numero de livros comprados: " + quantidadeCompra +
                "\n Obrigado por comprar na nossa livraria!";

        System.out.println(mensagem);
    }

    static class Livro {
        String nome;
        double preco;
        int quantidade;
        double totalCompra;

        Livro(String nome, double preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
            totalCompra = preco * quantidade;
        }

    }
}