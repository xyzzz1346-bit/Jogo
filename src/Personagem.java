public abstract class Personagem {

    private String nome;
    private int vida;
    private int ataque;

    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
    }

    public abstract void atacar(Personagem alvo);

    public void receberDano(int dano) {

        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
    }

    public void receberCura(int valor) {

        vida += valor;

        if (vida > 100) {
            vida = 100;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
}