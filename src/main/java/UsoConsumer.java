import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UsoConsumer {

    public static void main(String[] args) {
        Consumer<String> consumer = valorConsumido -> {
            var texto = "Valor consumido: "+valorConsumido;
            System.out.println(texto);
        };

        List<String> listaTexto = new ArrayList<>();
        listaTexto.add("Hello Word");
        listaTexto.add("Ei consumer");

        listaTexto.forEach(consumer);

        //consumer.accept("Hello Word");
        //consumer.accept("Ei consumer");

        Consumer<Integer> consumerInteiros = valorConsumido -> {
            var soma10 = valorConsumido + 10;
            System.out.println(soma10);
        };

    }

    private static void print(Consumer<String> consumer, String value) {
        consumer.accept(value);
    }
}
