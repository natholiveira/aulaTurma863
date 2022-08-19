public class VerificadorPodeSaltar implements Verificador {

    @Override
    public Boolean verificar(Animal animal) {

        return animal.podeSaltar();
    }
}
