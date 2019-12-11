package by.bsu.framework.util;

import java.time.format.DateTimeFormatter;

public class FormatterPattern {
    public static final DateTimeFormatter DATA_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");
    public static final DateTimeFormatter CURRENT_TIME_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
}
