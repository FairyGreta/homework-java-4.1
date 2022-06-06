package ru.netology.javaqa.javamaven.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/data.csv")
    void testBonusService(long amount, boolean registered, long expected) {

        BonusService service = new BonusService();
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }
}
