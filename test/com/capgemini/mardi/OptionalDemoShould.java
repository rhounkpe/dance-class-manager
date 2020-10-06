package com.capgemini.mardi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Optional Demo should")
class OptionalDemoShould {
    @Test
    @DisplayName("compute the average of a list of value")
    void computeTheAverageOfAListOfValue() {
        assertEquals(0.0, OptionalDemo.average());
    }
}
