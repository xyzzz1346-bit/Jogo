import java.util.Scanner;

public class Fase {

    private int numero;
    private String nome;
    private Jogador jogador;
    private Inimigo inimigo;

    public Fase(
            int numero,
            String nome,
            Jogador jogador,
            Inimigo inimigo
    ) {

        this.numero = numero;
        this.nome = nome;
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void iniciar(Scanner scanner) {

        System.out.println();
        System.out.println("==============================");
        System.out.println(
                "FASE " +
                        numero +
                        " - " +
                        nome
        );
        System.out.println("==============================");

        System.out.println(
                "Um " +
                        inimigo.getNome() +
                        " apareceu!"
        );

        while (
                jogador.estaVivo() &&
                        inimigo.estaVivo()
        ) {

            mostrarStatus();

            System.out.println();
            System.out.println("===== AÇÕES =====");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar item");
            System.out.println("3 - Ver inventário");
            System.out.println("4 - Encerrar jogo");

            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {

                case "1":

                    jogador.atacar(inimigo);

                    if (inimigo.estaVivo()) {

                        inimigo.atacar(jogador);
                    }

                    break;

                case "2":

                    if (jogador.getQuantidadeItens() == 0) {

                        System.out.println(
                                "Você não possui itens."
                        );

                    } else {

                        jogador.mostrarInventario();

                        System.out.print(
                                "Digite o número do item: "
                        );

                        try {

                            int indice =
                                    Integer.parseInt(
                                            scanner.nextLine()
                                    ) - 1;

                            jogador.usarItem(indice);

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "Digite um número válido."
                            );
                        }
                    }

                    break;

                case "3":

                    jogador.mostrarInventario();

                    break;

                case "4":

                    System.out.println(
                            "Jogo encerrado."
                    );

                    return;

                default:

                    System.out.println(
                            "Opção inválida!"
                    );
            }
        }

        if (jogador.estaVivo()) {

            jogador.adicionarPontos(100);

            System.out.println();
            System.out.println("==============================");
            System.out.println("        VOCÊ VENCEU!");
            System.out.println("==============================");

            System.out.println(
                    "Pontuação final: " +
                            jogador.getPontuacao()
            );

        } else {

            System.out.println();
            System.out.println("==============================");
            System.out.println("        VOCÊ PERDEU!");
            System.out.println("==============================");
        }
    }

    private void mostrarStatus() {

        System.out.println();
        System.out.println("===== STATUS =====");

        System.out.println(
                jogador.getNome() +
                        " | Vida: " +
                        jogador.getVida() +
                        " | Ataque: " +
                        jogador.getAtaque()
        );

        System.out.println(
                inimigo.getNome() +
                        " | Vida: " +
                        inimigo.getVida() +
                        " | Ataque: " +
                        inimigo.getAtaque()
        );
    }
}