import java.util.ArrayList;
import java.util.List;

public class UsoLambdas {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Joao");
        nomes.add("Jose");
        nomes.add("Maria");

        System.out.println("Nomes: "+nomes);

        nomes.removeIf(nome -> !nome.startsWith("J"));
        System.out.println("Nomes iniciados com J: "+nomes);

        nomes.add("Araci");
        nomes.add("Ze");

        System.out.println(nomes);

        nomes.sort((nome1, nome2) -> nome1.compareTo(nome2));

        System.out.println(nomes);

        nomes.forEach(nome -> System.out.println("nome: "+nome));
    }
}
