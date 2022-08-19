import java.util.ArrayList;
import java.util.List;

public class BuscaTradicional {
    public static void main(String[] args) {
        //Lista de animais
        List<Animal> animais = new ArrayList<>();

        Animal peixe = new Animal("peixe", false, true);
        animais.add(peixe);

        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));

        VerificadorPodeSaltar verificadorPodeSaltar = new VerificadorPodeSaltar();
        VerificadorPodeNadar verificadorPodeNadar = new VerificadorPodeNadar();

        //imprimir(animais, verificadorPodeSaltar);
        //imprimir(animais, verificadorPodeNadar);

        animais.stream().forEach(animal -> System.out.println("epecie: "+animal.getEspecie()));

        imprimir(animais, animal -> animal.podeNadar());
        imprimir(animais, animal -> animal.podeNadar());
    }

    private static void imprimir(List<Animal> animais, Verificador verificador) {
        // Percorre por cada animal da lista
        for (Animal animal : animais) {

            // Chama método verificar da classe
            if (verificador.verificar(animal)) {

                // imprime animal caso verificar retorne verdadeiro
                System.out.println(animal.getEspecie());
            }
        }
    }
}
