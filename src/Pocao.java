public class Pocao extends Item {

    private int cura;

    public Pocao(String nome, int cura) {

        super(nome);

        this.cura = cura;
    }

    @Override
    public void usar(Jogador jogador) {

        int vidaAntes = jogador.getVida();

        int vidaNova = Math.min(
                100,
                vidaAntes + cura
        );

        int recuperado = vidaNova - vidaAntes;

        jogador.receberCura(recuperado);

        System.out.println(
                jogador.getNome() +
                        " usou " +
                        getNome() +
                        " e recuperou " +
                        recuperado +
                        " de vida!"
        );
    }
}
