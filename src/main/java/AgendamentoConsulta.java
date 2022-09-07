import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AgendamentoConsulta {
    private String nomePaciente;
    private String nomeMedico;
    private String especialidade;
    private LocalDate data;
    private LocalTime hora;

    public AgendamentoConsulta(String nomePaciente, String nomeMedico, String especialidade, LocalDate data, LocalTime hora) {
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.data = data;
        this.hora = hora;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "AgendamentoConsulta{" +
                "nomePaciente='" + nomePaciente + '\'' +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
