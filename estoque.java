package proj;

import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String codigo;
    String nome;
    String categoria;
    int quantidade;
    double preco;

    public Produto(String codigo, String nome, String categoria, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                " | Nome: " + nome +
                " | Categoria: " + categoria +
                " | Quantidade: " + quantidade +
                " | Preço: R$" + preco;
    }
}

public class estoque {

    static ArrayList<Produto> produtos = new ArrayList<>();
    static ArrayList<String> movimentacoes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        while (true) {

            System.out.println("\n-------------------------");
            System.out.println("   SISTEMA DE ESTOQUE");
            System.out.println("-------------------------");

            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Entrada de estoque");
            System.out.println("3 - Saída de estoque");
            System.out.println("4 - Consultar produtos");
            System.out.println("5 - Relatório de estoque");
            System.out.println("6 - Relatório de movimentações");
            System.out.println("7 - Sair");

            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {

                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    entradaEstoque();
                    break;

                case 3:
                    saidaEstoque();
                    break;

                case 4:
                    consultarProduto();
                    break;

                case 5:
                    relatorioEstoque();
                    break;

                case 6:
                    relatorioMovimentacoes();
                    break;

                case 7:
                    sair();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void cadastrarProduto() {

        System.out.println("\nCódigo:");
        String codigo = sc.nextLine();

        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Categoria:");
        String categoria = sc.nextLine();

        System.out.println("Quantidade:");
        int quantidade = sc.nextInt();

        System.out.println("Preço:");
        double preco = sc.nextDouble();
        sc.nextLine();

        Produto p = new Produto(codigo, nome, categoria, quantidade, preco);

        produtos.add(p);

        movimentacoes.add("Produto cadastrado: " + nome);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void entradaEstoque() {

        System.out.println("Digite o código do produto:");
        String codigo = sc.nextLine();

        for (Produto p : produtos) {

            if (p.codigo.equals(codigo)) {

                System.out.println("Quantidade para adicionar:");
                int qtd = sc.nextInt();
                sc.nextLine();

                p.quantidade += qtd;

                movimentacoes.add("Entrada: +" + qtd + " no produto " + p.nome);

                System.out.println("Estoque atualizado!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void saidaEstoque() {

        System.out.println("Digite o código do produto:");
        String codigo = sc.nextLine();

        for (Produto p : produtos) {

            if (p.codigo.equals(codigo)) {

                System.out.println("Quantidade para remover:");
                int qtd = sc.nextInt();
                sc.nextLine();

                if (qtd > p.quantidade) {

                    System.out.println("Quantidade insuficiente no estoque!");

                } else {

                    p.quantidade -= qtd;

                    movimentacoes.add("Saída: -" + qtd + " do produto " + p.nome);

                    System.out.println("Saída realizada!");
                }

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public static void consultarProduto() {

        System.out.println("1 - Buscar por código");
        System.out.println("2 - Buscar por nome");
        System.out.println("3 - Buscar por categoria");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {

            case 1:

                System.out.println("Código:");
                String codigo = sc.nextLine();

                for (Produto p : produtos) {

                    if (p.codigo.equals(codigo)) {
                        System.out.println(p);
                    }
                }

                break;

            case 2:

                System.out.println("Nome:");
                String nome = sc.nextLine();

                for (Produto p : produtos) {

                    if (p.nome.equalsIgnoreCase(nome)) {
                        System.out.println(p);
                    }
                }

                break;

            case 3:

                System.out.println("Categoria:");
                String categoria = sc.nextLine();

                for (Produto p : produtos) {

                    if (p.categoria.equalsIgnoreCase(categoria)) {
                        System.out.println(p);
                    }
                }

                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void relatorioEstoque() {

        System.out.println("\n------ RELATÓRIO ------");

        for (Produto p : produtos) {

            System.out.println(p);

            if (p.quantidade == 0) {

                System.out.println("ALERTA: Produto zerado!");

            } else if (p.quantidade <= 5) {

                System.out.println("ALERTA: Estoque baixo!");
            }
        }
    }

    public static void relatorioMovimentacoes() {

        System.out.println("\n------ MOVIMENTAÇÕES ------");

        for (String m : movimentacoes) {
            System.out.println(m);
        }
    }

    // SAIR
    public static void sair() {

        System.out.println("Encerrando...");
        System.exit(0);
    }
}