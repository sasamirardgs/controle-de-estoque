import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        ArrayList<ProdEstoque> produtos = new ArrayList<>();
        int opcao = 0;

        while (opcao != 6) {

            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Entrada de produto");
            System.out.println("4 - Saída de produto");
            System.out.println("5 - Mostrar quantidade em estoque");
            System.out.println("6 - Sair");
            System.out.println("===============================");
            System.out.print("Escolha uma opção: ");

            opcao = ler.nextInt();
            if (opcao == 1) {

            System.out.print("Digite o código do produto: ");
                int cod = ler.nextInt();

            System.out.print("Digite o nome do produto: ");
                String nome = ler.next();

            System.out.print("Digite o preço do produto: ");
                double preco = ler.nextDouble();

            System.out.print("Digite a quantidade em estoque: ");
                int quantidade = ler.nextInt();

            ProdEstoque produto = new ProdEstoque(cod, nome, preco, quantidade);
            produtos.add(produto);
            System.out.println("Produto cadastrado com sucesso!");
            }

            else if (opcao == 2) {
            System.out.print("Digite o nome do produto a ser consultado: ");
                String nomeBusca = ler.next();
                boolean encontrado = false;
                for (ProdEstoque produto : produtos) {
                    if (produto.getNome().equalsIgnoreCase(nomeBusca)) {
                        System.out.println("Código: " + produto.getCodigo());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preço: R$ " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado!");
                }
            }

            else if (opcao == 3) {

                System.out.print("Digite o nome do produto: ");
                String nomeBusca = ler.next();
                boolean encontrado = false;
                for (ProdEstoque produto : produtos) {
                    if (produto.getNome().equalsIgnoreCase(nomeBusca)) {
                        System.out.print("Quantas unidades chegaram? ");
                        int entrada = ler.nextInt();

                        if (entrada > 0) {
                            int novaQuantidade = produto.getQuantidade() + entrada;
                            produto.setQuantidade(novaQuantidade);
                            System.out.println("Entrada registrada!");
                            System.out.println("Nova quantidade: " + produto.getQuantidade());
                        } else {
                            System.out.println("A quantidade deve ser maior que zero.");
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado!");
                }
            }
            else if (opcao == 4) {
                System.out.print("Digite o nome do produto: ");
                String nomeBusca = ler.next();
                boolean encontrado = false;
                for (ProdEstoque produto : produtos) {
                    if (produto.getNome().equalsIgnoreCase(nomeBusca)) {
                        System.out.print("Quantas unidades deseja retirar? ");
                        int saida = ler.nextInt();
                        if (saida > 0 && saida <= produto.getQuantidade()) {
                            int novaQuantidade =produto.getQuantidade() - saida;
                            produto.setQuantidade(novaQuantidade);

                            System.out.println("Saída registrada!");
                            System.out.println("Quantidade restante: " +produto.getQuantidade());

                        } else if (saida <= 0) {
                            System.out.println("A quantidade deve ser maior que zero.");

                        } else {
                            System.out.println("Estoque insuficiente!");
                            System.out.println("Quantidade disponível: " +produto.getQuantidade());
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Produto não encontrado!");
                }
            }
            else if (opcao == 5) {
                if (produtos.isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                } else {
                    System.out.println("\n===== PRODUTOS EM ESTOQUE =====");
                    for (ProdEstoque produto : produtos) {
                        System.out.println("Código: " + produto.getCodigo());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Quantidade: " + produto.getQuantidade());
                    }
                }
            }

            else if (opcao == 6) {
            System.out.println("Encerrando o sistema...");
            }
            else {

                System.out.println("Opção inválida!");
            }
        }

        ler.close();
    }
}