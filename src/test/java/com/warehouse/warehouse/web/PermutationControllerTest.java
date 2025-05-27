package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.PermutationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PermutationControllerTest {

    @Mock
    private PermutationService permutationService;

    @InjectMocks
    private PermutationController permutationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void controllerTest(){
        String family = "EST";
        int size = 2;
        List<String> expected = Arrays.asList("AA", "AB", "AC", "BA", "BB", "BC", "CA", "CB", "CC");

        when(permutationService.calculatePermutations(family, size)).thenReturn(expected);

        List<String> result = permutationController.calculatePermutations(family, size);

        assertEquals(expected, result);
        verify(permutationService, times(1)).calculatePermutations(family, size);
    }
}
