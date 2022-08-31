import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Arquivos {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
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

        // Criar arquivo
        File arquivo2 = new File("/Users/nath", "/Documents/aula863.txt");
        File diretorio = new File("/Users/nath");
        File arquivo3 = new File(diretorio, "/Documents/aula863.txt");

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
