import java.util.ArrayList;
import java.util.List;

public class Jogador extends Personagem implements Atacavel {

    private int pontuacao;
    private List<Item> inventario;

    public Jogador(String nome, int vida, int ataque) {

        super(nome, vida, ataque);

        this.pontuacao = 0;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
                getNome() +
                        " atacou " +
                        alvo.getNome() +
                        " causando " +
                        getAtaque() +
                        " de dano!"
        );

        alvo.receberDano(getAtaque());
    }

    public void adicionarItem(Item item) {

        inventario.add(item);

        System.out.println(
                item.getNome() +
                        " foi adicionado ao inventário."
        );
    }

    public void usarItem(int indice) {

        if (indice >= 0 && indice < inventario.size()) {

            Item item = inventario.remove(indice);

            item.usar(this);

        } else {

            System.out.println("Item inválido.");
        }
    }

    public void mostrarInventario() {

        if (inventario.isEmpty()) {

            System.out.println("Inventário vazio.");

            return;
        }

        System.out.println("\n===== INVENTÁRIO =====");

        for (int i = 0; i < inventario.size(); i++) {

            System.out.println(
                    (i + 1) +
                            " - " +
                            inventario.get(i).getNome()
            );
        }
    }

    public int getQuantidadeItens() {
        return inventario.size();
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void adicionarPontos(int pontos) {

        pontuacao += pontos;
    }
}