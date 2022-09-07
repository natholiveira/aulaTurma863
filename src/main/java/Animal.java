import java.io.Serializable;

public class Animal implements Serializable {

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

    static public Boolean PodeNadar() {return true;}

    @Override
    public String toString() {
        return "Animal{" +
                "especie='" + especie + '\'' +
                ", podeSaltar=" + podeSaltar +
                ", podeNadar=" + podeNadar +
                '}';
    }
}
