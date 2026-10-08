public abstract class Item {

    private String nome;

    public Item(String nome) {

        this.nome = nome;
    }

    public abstract void usar(Jogador jogador);

    public String getNome() {

        return nome;
    }
}