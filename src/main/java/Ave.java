public class Ave extends Animal{

    private float envergadura;
    private boolean podeVoar;

    public Ave(String nome, int idade, double peso) {
        super(nome, idade, peso);
        this.podeVoar = true;
        this.envergadura = 1.5f;
    }

    public boolean getPodeVoar() {
        return podeVoar;
    }

    public float getEnvergadura() {
        return envergadura;
    }

}
