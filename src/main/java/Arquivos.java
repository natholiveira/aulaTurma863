import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Arquivos {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //IO
        FileInputStream arquivoEntrada = null;
        FileOutputStream arquivoSaida = null;

        try {
            arquivoEntrada = new FileInputStream("/Users/nath/Documents/aula863.txt");
            arquivoSaida = new FileOutputStream("/Users/nath/Documents/novo_arquivo.txt");
            int pagina;

            while ((pagina = arquivoEntrada.read()) != -1) {
                arquivoSaida.write(pagina);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (arquivoEntrada != null) {
                arquivoEntrada.close();
            }
            if (arquivoSaida != null) {
                arquivoSaida.close();
            }
        }

        //IO
        try (
            FileInputStream arquivoEntrada2 = new FileInputStream("/Users/nath/Documents/aula863.txt");
            FileOutputStream arquivoSaida2 = new FileOutputStream("/Users/nath/Documents/novo_arquivo.txt");
        ) {
            int pagina;

            while ((pagina = arquivoEntrada2.read()) != -1) {
                arquivoSaida2.write(pagina);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Scanner
        File arquivo = new File("/Users/nath/Documents/aula863.txt");

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }

        // IO
        // Criar arquivo
        File arquivo2 = new File("/Users/nath", "/Documents");
        File diretorio = new File("/Users/nath");
        File arquivo3 = new File(diretorio, "/Documents/aula863.txt");

        // NIO
        Path arquivoPath = Path.of("/Users/nath/Documents/aula863.txt");
        Path arquivoPath2 = Path.of("/Users", "nath", "Documents");
        Path arquivoPath3 = Paths.get("/Users/nath/Documents/aula863.txt");
        Path arquivoPath4 = Paths.get("/Users", "nath", "Documents", "aula863.txt");

        // Converter path para file
        File pathToFile = arquivoPath.toFile();

        // Converter file para path
        Path fileToPath = arquivo.toPath();

        // Pegar nome do arquivo
        String nomeFile = arquivo.getName();
        System.out.println(nomeFile);

        // Pegar o nome do Path
        Path nomePath = arquivoPath.getFileName();
        System.out.println(nomePath);

        // Pegar diretorio
        System.out.println(arquivo.getParent());
        System.out.println(arquivoPath.getParent());

        // IO
        if (arquivo.exists()) {
            System.out.println("É um diretório? "+arquivo.isDirectory());
            if (arquivo.isFile()) {
                System.out.println("Tamanho: "+arquivo.length());
                System.out.println("Data modificação: "+arquivo.lastModified());
            } else {
                File[] arquivosDaPasta = arquivo.listFiles();
                Arrays.stream(arquivosDaPasta).forEach(subArquivo -> System.out.println(subArquivo.getName()));
            }
        }

        // NIO
        System.out.println("\n");
        if (Files.exists(arquivoPath)) {
            System.out.println("É um diretório? "+Files.isDirectory(arquivoPath));
            if (Files.isRegularFile(arquivoPath2)) {
                System.out.println("Tamanho: "+ Files.size(arquivoPath));
                System.out.println("Ultima modificação "+ Files.getLastModifiedTime(arquivoPath));
            } else {
                try (Stream<Path> pathStream = Files.list(arquivoPath2)) {
                    pathStream.forEach(path -> System.out.println(path.getFileName()));
                }
            }
        }

        // Pegar cada elemento de um path
        for (int i=0; i<arquivoPath.getNameCount(); i++) {
            System.out.println("Elemento "+i+" é "+ arquivoPath.getName(i));
        }

        // Criar diretório
        Files.createDirectories(Paths.get("/Users/nath/Documents/aulaArquivo"));

        // Deletar arquivo
        Files.delete(Paths.get("/Users/nath/Documents/aulaArquivo"));
        Files.deleteIfExists(Paths.get("/Users/nath/Documents/aulaArquivo"));

        // Escrever um arquivo em outro com BufferedWriter
        String caminhoEntradaArquivo = "/Users/nath/Documents/aula863.txt";
        String caminhoSaidaArquivo = "/Users/nath/Documents/saida.csv";

        StringBuilder stringBuilderExemplo = new StringBuilder();
        stringBuilderExemplo.append("texto 1");
        stringBuilderExemplo.append("\n");
        stringBuilderExemplo.append("texto 2").append(" é isso ai");

        System.out.println(stringBuilderExemplo.toString());

        StringBuilder stringBuilder = new StringBuilder();

        // Criando aruivo de saida(escrita, arqquivo que será escrito)
        BufferedWriter arquivoDeEscrita = new BufferedWriter(new FileWriter(caminhoSaidaArquivo));

        // Criando arquivo de entrada(leitura, arquivo que está sendo lido)
        BufferedReader arquivoDeLeitura = new BufferedReader(new FileReader(caminhoEntradaArquivo));

        Stream.of("linha 1", "linha 2", "linha 3");
        arquivoDeLeitura.lines().forEach(linha -> stringBuilder.append(linha).append("\n"));

        // Escrever no arquivo de escrita(csv)
        arquivoDeEscrita.write(stringBuilder.toString());
        arquivoDeEscrita.close();
        arquivoDeLeitura.close();

        System.out.println(stringBuilder.toString());

        // Criar csv com dados de um objeto
        String[] cabecalho = {"Espécie", "Pode saltar", "Pode nadar"};
        var animais = new ArrayList<Animal>();
        animais.add(new Animal("Peixe", false, true));
        animais.add(new Animal("águia", false, false));

        StringBuilder animaisStringBuilder = new StringBuilder();

        Arrays.stream(cabecalho).forEach(item -> animaisStringBuilder.append(item).append(","));
        animaisStringBuilder.append("\n");

        animais.forEach(animal -> {
            animaisStringBuilder.append(animal.getEspecie()).append(",");
            animaisStringBuilder.append(animal.podeSaltar()).append(",");
            animaisStringBuilder.append(animal.podeNadar()).append("\n");
        });

        OutputStream arquivoCsv = new FileOutputStream("/Users/nath/Documents/animais.csv");

        Writer escritor = new PrintWriter(new OutputStreamWriter(arquivoCsv, StandardCharsets.UTF_8), true);
        escritor.write(animaisStringBuilder.toString());
        escritor.close();

        System.out.println(animaisStringBuilder);

        // Gravar um objeto em arquivo
        var caminhoArquivoObjeto = "/Users/nath/Documents/objeto.txt";
        try (var objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(caminhoArquivoObjeto)))) {
            animais.forEach(animal -> {
                try {
                    objectOutputStream.writeObject(animal);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        // Recuperar objeto em arquivo
        var animaisResultado = new ArrayList<Animal>();
        try (var objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(caminhoArquivoObjeto)))) {
            Object animalGenerico = objectInputStream.readObject();
            if (animalGenerico instanceof Animal) {
                Animal animalConvertido = (Animal) animalGenerico;
                animaisResultado.add(animalConvertido);
            }
        }

        System.out.println(animaisResultado.toString());
    }


    static void cadastraClientesHomens() {
       try {
           cadastraCliente("João", "1234");
       } catch (ClassNotFoundException classNotFoundException) {
           System.out.println("Desculpe, não consegui cadastrar ele");
       }
    }

    static void cadastraClientesMulheres() {
        try {
            cadastraCliente("Maria", "1234");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Desculpe, não consegui cadastrar ela");
        }
    }

    static String cadastraCliente(String nome, String cep) throws ClassNotFoundException {
        var rua = buscaEnderecoPorCEP(cep);

       return "Cliente "+nome+" mora na rua "+ rua;
    }

    static String buscaEnderecoPorCEP(String cep) throws ClassNotFoundException {
        if (cep.equals("12345")) {
            return "Rua amazonas";
        } else {
            throw new ClassNotFoundException();
        }
    }

    static void metodoLancaUmaExcecao() {
       // throw new RuntimeException();
    }
}
