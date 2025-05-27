package com.warehouse.warehouse.domain.service.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationServiceImplTest {

    private final PermutationServiceImpl permutationService = new PermutationServiceImpl();

    @Test
    void testCalculatePermutations_EST() {
        List<String> result = permutationService.calculatePermutations("EST", 2);
        assertEquals(9, result.size());
        assertTrue(result.contains("AA"));
        assertTrue(result.contains("BC"));
    }

    @Test
    void testCalculatePermutations_ROB() {
        List<String> result = permutationService.calculatePermutations("ROB", 2);
        assertEquals(9, result.size());
        assertTrue(result.contains("AD"));
        assertTrue(result.contains("CC"));
    }

    @Test
    void testCalculatePermutations_InvalidFamily() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                permutationService.calculatePermutations("XYZ", 2));
        assertEquals("Invalid family type", exception.getMessage());
    }

    @Test
    void testCalculatePermutations_SizeZero() {
        List<String> result = permutationService.calculatePermutations("EST", 0);
        assertEquals(1, result.size());
        assertEquals("", result.get(0));
    }
}
