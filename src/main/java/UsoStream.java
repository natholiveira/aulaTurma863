import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsoStream {

    public static void main(String[] args) {
        // Criação de Stream
        Stream<String> streamVazia = Stream.empty(); // stream 0 elementos
        System.out.println(streamVazia.collect(Collectors.toList()));

        Stream<Integer> unicoElemento = Stream.of(1);
        System.out.println(unicoElemento.collect(Collectors.toList()));

        Stream<Integer> variosElementos = Stream.of(1, 2, 3);
        System.out.println(variosElementos.collect(Collectors.toList()));

        var lista = List.of("a", "b", "c");
        List<String> lista2 = List.of("a", "b", "c");

        Stream<String> streamDaLista = lista.stream();
        System.out.println(streamDaLista.collect(Collectors.toList()));

        // Streams infinitas
        Stream<Double> randomica = Stream.generate(Math::random);

        // Stream infinita com iterate
        Stream<Integer> numerosImpares = Stream.iterate(1, n -> n+2);

        Stream<Integer> numerosPares = Stream.iterate(2, n -> n < 100, n -> n+2);
        System.out.println("Números pares: "+numerosPares.collect(Collectors.toList()));

        Stream<String> quantidade = Stream.of("casa", "carro");
        System.out.println("Quantidade itens: "+quantidade.count());

        // min
        Stream<String> valorMinimo = Stream.of("casa", "carro", "comida");
        Optional<String> min = valorMinimo.min((value1, value2) -> value1.length() - value2.length());

        Stream<String> streamVazio = Stream.empty();
        Optional<String> minVazio = streamVazio.min((value1, value2) -> 0);
        System.out.println("Possui resultado: "+minVazio.isPresent());

        System.out.println("Possui resultado: "+min.isPresent());

        if (min.isPresent()) {
            System.out.println("Palavra com menor tamanho: "+min.get());
        }
    }
}
