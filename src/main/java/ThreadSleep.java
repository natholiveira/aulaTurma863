import java.time.LocalDate;

public class ThreadSleep {

    private static boolean enviada = false;

    public static void main(String[] args) {
        try {
            System.out.println(LocalDate.now());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            System.out.println(e.getMessage());
        }

        System.out.println("Pizza Chegou!");
        System.out.println(LocalDate.now());

        // ------ Exemplo Farol -----------

        System.out.println("Verde");
        pause();

        System.out.println("Amarelo");
        pause();

        System.out.println("Vermelho");
        pause();

        // ------ Fim Exemplo Farol -----------

        // Thread principal

        final Thread main = Thread.currentThread();

        new Thread(() -> {
            try {
                // Dorme por 5 segundos
                Thread.sleep(5000);
                // controla se a mensagem foi enviada
                enviada = true;
                main.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        while (!enviada) {
            System.out.println("Enviando mensagem...");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Erro");
                System.exit(0);
            }
        }

        System.out.println("Mensagem Enviada");
    }

    private static void pause() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            System.out.println(e.getMessage());
        }
    }

}
