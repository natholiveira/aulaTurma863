import java.util.function.Supplier;

public class UsoSupplier {

    public static void main(String[] args) {
        Supplier<Integer> number = () -> 15;

        Supplier<String> texto = () -> "texto";

        var soma10 = 10+number.get();
        var soma15 = 15+number.get();



        System.out.println(texto.get());
        System.out.println(number.get());
    }
}
