public class Comodo {

    private String nome;
    private Boolean possuiJanela;
    private Boolean possuiPiso;

    public Comodo(String nome, Boolean possuiJanela, Boolean possuiPiso) {
        this.nome = nome;
        this.possuiJanela = possuiJanela;
        this.possuiPiso = possuiPiso;
    }

    public Boolean getPossuiJanela() {
        return possuiJanela;
    }

    public Boolean getPossuiPiso() {
        return possuiPiso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


