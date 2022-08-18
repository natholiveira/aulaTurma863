import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Data {

    public static void main(String[] args) {
        informacoesData();
    }

    static void informacoesData() {
        Scanner ler = new Scanner(System.in);
        String dataTexto = ler.next();

        // Informar se é ano bissexto


        // formatar para o formato dd/MM/yyyy HH:mm


        // formatar para o estilo FULL


        // Informar o dia da semana


        // Informar o proximo mês


        // Informar ultimo dia do ano


        // Informar se é horário de verão em SP


        // Informar data de 3 dias antes


        // Informar hora daqui a 4 horas


        // Informar se a data é anterior a data de hoje

        // Formartar data pro estilo americano


        // Pegar data do proxima segunda


        // Data daqui há 2 meses
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
        ZonedDateTime zonedDateTimeVerao = ZonedDateTime.of(2016, 1, 10, 10,30, 10, 10, zoneIdSp);
        ZonedDateTime dataHoraComZonaSP = ZonedDateTime.of(diaHoraAtual, zoneIdSp);
        Boolean eHorarioDeVerao = zoneIdSp.getRules().isDaylightSavings(zonedDateTimeVerao.toInstant());
        System.out.println("A data "+zonedDateTimeVerao+" é horário de verão? "+eHorarioDeVerao);

        // Passar data para um Time Zone diferente
        ZonedDateTime dataZonaParis = dataHoraComZonaSP.withZoneSameInstant(zoneIdParis);

        System.out.println("Data com Zona em SP: "+dataHoraComZonaSP);
        System.out.println("Data convertida para zona de Paris: "+ dataZonaParis);

        // Somar data e hora

        LocalDateTime dataDaqui3dias = diaHoraAtual.plusDays(3);
        System.out.println("Data daqui há 3 dias: "+ dataDaqui3dias);

        LocalDateTime dataDaqui1ano = diaHoraAtual.plusYears(1);
        System.out.println("Data daqui há 1 ano: "+dataDaqui1ano);

        LocalDateTime dataMenos2Horas = diaHoraAtual.minusHours(2);
        System.out.println("Data e hora 2 horas antes: "+dataMenos2Horas);

        // Proximo Dia
        ZonedDateTime proximaSexta = dataHoraComZonaSP.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("Próxima sexta é: "+proximaSexta);

        // Validações
        var eAntes = diaHoraAtual.isBefore(dataHoraConvertida);
        System.out.println(diaHoraAtual + " é anterior a data "+dataHoraConvertida+"? " +eAntes);

        var eDepois = diaHoraAtual.isAfter(dataHoraConvertida);
        System.out.println(diaHoraAtual + " é posterior a data "+dataHoraConvertida+"? " +eDepois);

        // Converter
        LocalDate toLocalDate = diaHoraAtual.toLocalDate();
        System.out.println("Data: "+toLocalDate);

        LocalTime toLocalTime = diaHoraAtual.toLocalTime();
        System.out.println("Hora: "+toLocalTime);

        ZoneOffset zonaInstant = ZoneOffset.of("+02:00");
        Instant toInstant = diaHoraAtual.toInstant(zonaInstant);
        System.out.println("Data convertida para instant: "+toInstant);

        String toString = diaHoraAtual.toString();
        System.out.println("Data convertida para texto: "+toString);

        //Periodo
        ZonedDateTime dataInicio = ZonedDateTime.of(diaHoraAtual, zoneIdSp);
        Period periodo = Period.ofMonths(3);
        ZonedDateTime dataFim = dataInicio.plus(periodo);

        System.out.println("Data inicio: "+dataInicio+" Data após 3 meses: "+dataFim);

        // Duracao
        LocalTime horaInicio = LocalTime.of(12, 30, 10);
        LocalTime horaFinal = LocalTime.of(14, 30,10);

        Long minutos = ChronoUnit.MINUTES.between(horaInicio, horaFinal);

        Duration duracao = Duration.ofMinutes(minutos);

        System.out.println("Total de minutos: "+minutos);
        System.out.println("Duração do intervalo: "+duracao);

        // Localizacao
        Locale localizaoJapao = new Locale("ja");
        var dataJapao = dataHoraComZona.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(localizaoJapao));
        System.out.println("Data Japão: "+dataJapao);
    }
}
