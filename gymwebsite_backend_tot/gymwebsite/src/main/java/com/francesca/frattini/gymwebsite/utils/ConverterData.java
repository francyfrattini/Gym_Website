package com.francesca.frattini.gymwebsite.utils;

import java.time.LocalDate;

public class ConverterData {

    public static LocalDate convertData(String date) {
        return LocalDate.parse(date);
    }
}
