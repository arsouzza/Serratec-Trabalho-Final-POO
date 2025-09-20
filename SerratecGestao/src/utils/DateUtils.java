package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter CSV_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static LocalDate parseFromCsv(String s) {
        return LocalDate.parse(s.trim(), CSV_FMT);
    }

    public static String formatToCsv(LocalDate d) {
        return d.format(CSV_FMT);
    }
}