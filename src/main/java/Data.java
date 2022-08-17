import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;

public class Data {

    public static void main(String[] args) {
        datas();
    }

    static void datas() {
        // Pegar a data atual
        LocalDate dataAtual = LocalDate.now();
        System.out.println("Data atual "+dataAtual);

        // Pegar a data com método of
        LocalDate dataAniverMari = LocalDate.of(1995, 2, 3);
        System.out.println("Aniver da mari "+dataAniverMari);

        // Convertar um texto para uma data
        LocalDate dataString = LocalDate.parse("1993-02-10");
        System.out.println("Aniver do Douglas "+dataString);

        // Pegar dia da semana
        DayOfWeek diaDaSemana = dataAniverMari.getDayOfWeek();
        System.out.println("A mari nasceu na "+ diaDaSemana);

        // Validar se o ano é bissexto
        LocalDate dataAnoBissexto = LocalDate.of(2016, 1, 1);
        Boolean eAnoBissexto = dataAnoBissexto.isLeapYear();
        System.out.println("A data "+dataAnoBissexto+" é ano bissexto? "+eAnoBissexto);

        // Pegar primeiro dia do mês
        LocalDate primeiroDiaMes = dataAtual.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("Primeiro dia do mês baseado na data atual " + primeiroDiaMes);

        // LocalTime - Hora
        // Pegar a hora atual
        LocalTime horaAtual = LocalTime.now();
        System.out.println("\n");
        System.out.println("Hora atual: "+ horaAtual);

        // Passar uma hora específica
        LocalTime horaEspecifica = LocalTime.of(18, 2, 10, 10);
        System.out.println("Hora específica: " + horaEspecifica);

        // Converter texto para hora
        LocalTime horaString = LocalTime.parse("10:30:10.05");
        System.out.println("Hora em texto convertida: "+horaString);

        // Pegar minutos de uma hora
        System.out.println("Minutos da hora atual "+horaAtual.getMinute());

        // LocalDateTime
        // Dia e hora atual
        LocalDateTime diaHoraAtual = LocalDateTime.now();
        System.out.println("\n");
        System.out.println("Dia e hora atual: "+diaHoraAtual);

        // Passar data e hora
        LocalDateTime dataHoraEspecifica = LocalDateTime.of(2022,03, 10, 12, 50, 40);
        System.out.println("Data e hora específica: " + dataHoraEspecifica);

        // Passar LocalDate e LocalTime
        LocalDateTime localDateELocalTime = LocalDateTime.of(dataAniverMari, horaAtual);
        System.out.println("LocalDateTime com um LocalDate e um LocalTime: "+localDateELocalTime);

        // Converter texto para LocalDateTime
        LocalDateTime dataHoraConvertida = LocalDateTime.parse("2020-03-19T15:15:15");
        System.out.println("Data e hora convertida de um texto: "+dataHoraConvertida);

        // Criar uma zona
        ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
        ZonedDateTime dataHoraComZona = ZonedDateTime.of(diaHoraAtual, zoneIdParis);
        System.out.println("Data e hora com zona de paris: " +dataHoraComZona);

        // Formatação de data
        String dataFormatadaComFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(dataAtual);
        System.out.println("Data Formatada com Full: "+dataFormatadaComFull);

        String dataFormatadaComLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(dataAtual);
        System.out.println("Data Formatada com Long: "+dataFormatadaComLong);

        String dataFormatadaComMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(dataAtual);
        System.out.println("Data Formatada com Medium: "+dataFormatadaComMedium);

        DateTimeFormatter formatadorShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String dataFormatadaComShort = formatadorShort.format(dataAtual);
        System.out.println("Data Formatada com Short: "+dataFormatadaComShort);

        // Criar formatação padrão
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatadaComFormatacaoPadrao = formatacao.format(diaHoraAtual);
        System.out.println("Data com formatação padrão: "+dataFormatadaComFormatacaoPadrao);

        // Horário de verão
        ZoneId zoneIdSp  = ZoneId.of("America/Sao_Paulo");
        Boolean eHorarioDeVerao = zoneIdSp.getRules().isDaylightSavings(diaHoraAtual.toInstant(ZoneOffset.UTC));
        System.out.println("A data "+dataHoraComZona+" é horário de verão? "+eHorarioDeVerao);
    }
}
