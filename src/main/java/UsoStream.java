import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
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

        min.ifPresent(s -> System.out.println("Palavra com menor tamanho: " + s));

        var listaTeste = Arrays.asList("a", "b", "c");
        System.out.println(listaTeste.get(0));

        // FindAny e FindFirst
        Stream<String> alfabeto = Stream.of("a","b","c", "d");
        System.out.println(alfabeto.findAny().get());

        var listaItens = List.of("mala", "1", "casa");

        List<String> listaString = List.of("casa");
        Stream<String> streamCasa = Stream.generate(() -> "casa");
        Stream<String> x = Stream.of("casa");
        Stream<String> streamDaLista2 = listaString.stream();

        Predicate<String> validacaoLetra = item -> Character.isLetter(item.charAt(2));

        var listaNumeros = List.of(1,2,3,4,5,6,7);

        Predicate<Integer> validaMaiorQue5 = item -> item>5;
        System.out.println("Qualquer item da lista é maior que 5? "+
                listaNumeros.stream().anyMatch(validaMaiorQue5));

        System.out.println("Todos os itens da lista são maiores que 5?"+
                listaNumeros.stream().allMatch(validaMaiorQue5));

        var comodos = List.of("cozinha", "quarto", "sala");
        System.out.println("Algum dos comodos é uma banheiro? "+
                comodos.stream().anyMatch(comodo -> comodo.equals("banheiro")));

        System.out.println("Nenhum item da lista é banheiro? " +
                comodos.stream().noneMatch(comodo -> comodo.equals("banheiro")));

        // Reduce
        var arrayString = new String[] { "c", "a", "s", "a" };
        var resultado = "";
        for (var letra: arrayString) {
            resultado = resultado+letra;
        }

        System.out.println(resultado);

        Stream<String> streamCasa2 = Stream.of("c", "a", "s", "a");
        String palavraCasa = streamCasa2.reduce("", (value1, value2) -> value1+value2);
        System.out.println(palavraCasa);

        Stream<Double> valoresTransacoes = Stream.of(100.0, 200.0, 50.0);
        Double valorTotal = valoresTransacoes.reduce(0.0, (valor1, valor2) -> valor1+valor2);
        System.out.println(valorTotal);

        BinaryOperator<Integer> operador = (a, b) -> a*b;
        Stream<Integer> multiplicacao = Stream.of(2,4,6);
        multiplicacao.reduce(operador).ifPresent(System.out::println);

        // filter
        Stream<String> filtro = Stream.of("madeira", "mão", "mouse", "tela", "câmera");
        filtro.filter(valor -> valor.startsWith("m")).forEach(System.out::println);

        List<Animal> animais = new ArrayList<>();

        Animal peixe = new Animal("peixe", false, true);
        animais.add(peixe);
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));

        var animaisPodemSaltar = animais.stream().filter(animal -> animal.podeSaltar()).collect(Collectors.toList());

        System.out.println(animaisPodemSaltar);

        var valores = List.of(100.0, 40.0, 120.0, 20.0, 240.0);
        valores.stream()
                .filter(valor -> valor>=100)
                .forEach(System.out::println);

        var valoresMaiorQue100 = new ArrayList<>();
        valores.forEach(valor -> {
            if (valor>=100) {
                valoresMaiorQue100.add(valor);
            }
        });
        System.out.println(valoresMaiorQue100);

        // Distinct
        Stream<String> valoresDiferentes = Stream.of("bola", "bola", "bola", "boneca", "boneca");
        valoresDiferentes.distinct().forEach(System.out::println);

        // map
        List<Animal> animais2 = new ArrayList<>();
        animais2.add(new Animal("peixe", false, true));
        animais2.add(new Animal("canguru", true, false));
        animais2.add(new Animal("coelho", true, false));

        var especies =  animais2.stream()
                .filter(animal -> animal.podeSaltar())
                .map(animal -> animal.getEspecie());
        System.out.println(especies.collect(Collectors.toList()));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("cleber", "1234561324", 20));
        clientes.add(new Cliente("cleber", "1234561324", 20));
        clientes.add(new Cliente("Mari", "12312412553", 18));
        clientes.add(new Cliente("ana", "12312412553", 20));

        var nomesClientes = clientes.stream()
                .filter(cliente -> cliente.getIdade() == 20)
                .map(cliente -> cliente.getNome())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(nomesClientes);

        // FlatMap
        var frutasVerdes = List.of(
                new Fruta("Maçã Vede", "verde"),
                new Fruta("Melancia", "verde"),
                new Fruta("uva", "verde")
        );
        var frutasAmarelas = List.of(
                new Fruta("melão", "amarela"),
                new Fruta("banana", "amarela")
        );

        var frutas = Stream.of(frutasVerdes, frutasAmarelas);
        var frutasOrdenadas = frutas
                .flatMap(frutas2 -> frutas2.stream()
                .map(fruta -> fruta.getNome()))
                .collect(Collectors.toList());

        System.out.println(frutasOrdenadas);
    }
}
