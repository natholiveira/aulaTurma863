public class Animal {

    public String especie;
    public Boolean podeSaltar;
    public Boolean podeNadar;

    public Animal(String especie, Boolean podeSaltar, Boolean podeNadar) {
        this.especie = especie;
        this.podeSaltar = podeSaltar;
        this.podeNadar = podeNadar;
    }

    public Boolean podeSaltar() {
        return podeSaltar;
    }

    public Boolean podeNadar() {
        return podeNadar;
    }

    public String getEspecie() {
        return especie;
    }
}
