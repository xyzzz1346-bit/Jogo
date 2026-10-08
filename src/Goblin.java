public class Goblin extends Inimigo {

    public Goblin(String nome, int vida, int ataque) {

        super(nome, vida, ataque);
    }

    @Override
    public void atacar(Personagem alvo) {

        System.out.println(
                getNome() +
                        " deu uma mordida e causou " +
                        getAtaque() +
                        " de dano!"
        );

        alvo.receberDano(getAtaque());
    }
}