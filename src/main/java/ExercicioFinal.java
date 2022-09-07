import java.time.LocalDate;
import java.time.LocalTime;

public class ExercicioFinal {

    // Criar uma classe chamada AgendamentoConsulta
    // Essa classe deve conter
        // nome do paciente
        // nome do medico
        // Especialidade
        // Data e hora da consulta

    public static void main(String[] args) {
        AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta(
                "Angela",
                "Rafaela",
                "cardiologista",
                LocalDate.of(2022, 03, 12),
                LocalTime.of(12, 30)
        );
    }

    // Criar pelo menos 5 Agendamentos de consulta

    // Criar uma lista com os agendamentos criados

    // Filtrar pelos agendamentos em que a data é igual a data atual

    // Criar um arquivo csv com os dados dos agendamentos que foram filtrados

}
