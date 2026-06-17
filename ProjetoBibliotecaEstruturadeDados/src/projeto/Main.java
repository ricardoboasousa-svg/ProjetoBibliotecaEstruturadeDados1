package projeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- SISTEMA DE BIBLIOTECA ACADÊMICA ---");
            System.out.println("1. Inserir livro");
            System.out.println("2. Buscar livro");
            System.out.println("3. Remover livro");
            System.out.println("4. Exibir livros em ordem");
            System.out.println("5. Exibir livros em pré-ordem");
            System.out.println("6. Exibir livros em pós-ordem");
            System.out.println("7. Mostrar livro com maior ISBN");
            System.out.println("8. Mostrar livro com menor ISBN");
            System.out.println("9. Mostrar quantidade de livros");
            System.out.println("10. Mostrar altura da árvore");
            System.out.println("11. Encerrar sistema");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ISBN: ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite a área: ");
                    String area = scanner.nextLine();
                    System.out.print("Digite a quantidade disponível: ");
                    int qtd = scanner.nextInt();
                    
                    Livro novoLivro = new Livro(isbn, titulo, autor, area, qtd);
                    arvore.inserir(novoLivro);
                    System.out.println("Livro inserido com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o ISBN para busca: ");
                    long isbnBusca = scanner.nextLong();
                    Livro livroBuscado = arvore.buscar(isbnBusca);
                    if (livroBuscado != null) {
                        System.out.println("Livro encontrado: " + livroBuscado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o ISBN para remoção: ");
                    long isbnRemover = scanner.nextLong();
                    if (arvore.buscar(isbnRemover) != null) {
                        arvore.remover(isbnRemover);
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado para remoção.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Exibição em Ordem ---");
                    arvore.exibirEmOrdem();
                    break;

                case 5:
                    System.out.println("\n--- Exibição em Pré-Ordem ---");
                    arvore.exibirPreOrdem();
                    break;

                case 6:
                    System.out.println("\n--- Exibição em Pós-Ordem ---");
                    arvore.exibirPosOrdem();
                    break;

                case 7:
                    Livro maior = arvore.mostrarMaiorIsbn();
                    if (maior != null) {
                        System.out.println("Maior ISBN: " + maior);
                    } else {
                        System.out.println("Árvore vazia.");
                    }
                    break;

                case 8:
                    Livro menor = arvore.mostrarMenorIsbn();
                    if (menor != null) {
                        System.out.println("Menor ISBN: " + menor);
                    } else {
                        System.out.println("Árvore vazia.");
                    }
                    break;

                case 9:
                    System.out.println("Quantidade total de livros cadastrados: " + arvore.mostrarQuantidade());
                    break;

                case 10:
                    System.out.println("Altura da árvore: " + arvore.mostrarAltura());
                    break;

                case 11:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 11);

        scanner.close();
    }
}
