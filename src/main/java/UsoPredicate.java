import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsoPredicate {

    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));

        print(animais, animal -> animal.podeNadar());

        List<Comodo> casas = new ArrayList<>();
        casas.add(new Comodo("cozinha", true, true));
        casas.add(new Comodo("sala", true, false));

        printCasa(casas, comodo -> comodo.getPossuiPiso());

    }

    private static void printCasa(List<Comodo> comodos, Predicate<Comodo> verificadorCasa) {
        comodos.forEach(comodo -> {
            if (verificadorCasa.test(comodo)) {
                System.out.println(comodo);
            }
        });
    }

    private static void print(List<Animal> animais, Predicate<Animal> verificador) {
        animais.forEach(animal -> {
            var boleano = verificador.test(animal);
            if (boleano) {
                System.out.println(animal);
            }
        });
    }
}
