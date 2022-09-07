import java.time.LocalDate;
import java.time.LocalDateTime;

public class MultiplasThreads {
    public static void main(String[] args) {
        Runnable catalogo = () -> System.out.println("Catalogo de produtos");

        Runnable imprimirCatalogo = () -> {
          for (int i=0; i<5; i++) {
              System.out.println("imprimir registros: "+i);
          }
        };

        System.out.println(LocalDateTime.now());
        System.out.println("Inicio");

        Thread t = new Thread(escreve());
        Thread t1 = new Thread(envia());
        Thread t2 = new Thread(recebe());

        t.setPriority(10);
        t.setPriority(9);
        t.setPriority(8);

        t.start();
        t1.start();
        t2.start();

        System.out.println("Fim");
        System.out.println(LocalDateTime.now());
    }

    public static Runnable escreve() {
        return () -> {
            for (int i=0; i<5; i++) {
                System.out.println("1 - imprimir registros: "+i);
            }
        };
    }
    public static Runnable envia() {
        return () -> {
            for (int i=0; i<5; i++) {
                System.out.println("2 - enviar carta: "+i);
            }
        };
    }
    public static Runnable recebe() {
        return () -> {
            for (int i=0; i<5; i++) {
                System.out.println("3 - recebe: "+i);
            }
        };
    }
}

