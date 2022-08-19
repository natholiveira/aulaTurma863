public class VerificadorPodeNadar implements Verificador {
    @Override
    public Boolean verificar(Animal animal) {
        return animal.podeNadar;
    }
}
