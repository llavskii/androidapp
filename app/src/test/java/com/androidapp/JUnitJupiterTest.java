package com.androidapp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

@Epic("Основные asserts Junit5")
public class JUnitJupiterTest {

    @Test
    @Description("Assert equals")
    public void assertEqualsTest() {
        assertEquals(10, 10);
    }

    @Test
    @Description("Assert not equals")
    public void assertNotEqualsTest() {
        assertNotEquals(10, 10 + new Random().nextInt(10));
    }

    static Stream<Arguments> parameterizedTest() {
        return Stream.of(
                of(
                        //title
                        "Parameterized test",
                        //params for assertion
                        4,
                        4
                )
        );
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource()
    public void parameterizedTest(
            String name,
            int value1,
            int value2
    ) {
        Assertions.assertEquals(value1, value2, "Actual value and expected are not equals!");
        System.err.println("Ошибка!!! ---------");
        throw new AssertionError("Ошибка!!! ---------");

    }
}