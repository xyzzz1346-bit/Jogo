import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       RPG AVENTURA OO");
        System.out.println("=================================");

        System.out.print("Digite o nome do seu herói: ");
        String nome = scanner.nextLine();

        Jogador jogador = new Jogador(nome, 100, 15);

        Inimigo inimigo = new Goblin("Goblin", 60, 10);

        Pocao pocao = new Pocao("Poção de Cura", 30);

        jogador.adicionarItem(pocao);

        Fase fase = new Fase(
                1,
                "Floresta Sombria",
                jogador,
                inimigo
        );

        fase.iniciar(scanner);

        scanner.close();
    }
}