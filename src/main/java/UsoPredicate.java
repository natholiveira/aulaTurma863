import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsoPredicate {

    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));

        print(animais, animal -> animal.podeNadar());

        List<Casa> casas = new ArrayList<>();
        casas.add(new Casa(true, true));
        casas.add(new Casa(true, false));

        printCasa(casas, casa -> casa.possuiVaranda());

    }

    private static void printCasa(List<Casa> casas, Predicate<Casa> verificadorCasa) {
        casas.forEach(casa -> {
            if (verificadorCasa.test(casa)) {
                System.out.println(casa);
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
