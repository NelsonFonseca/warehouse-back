package com.warehouse.warehouse.domain.service.impl;

import com.warehouse.warehouse.domain.service.PermutationService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PermutationServiceImpl implements PermutationService {

    public List<String> calculatePermutations(String family, int size) {
        char[] types;
        if (family.equals("EST")) {
            types = new char[]{'A', 'B', 'C'};
        } else if (family.equals("ROB")) {
            types = new char[]{'A', 'C', 'D'};
        } else {
            throw new IllegalArgumentException("Invalid family type");
        }

        List<String> permutations = new ArrayList();
        generatePermutations(permutations, "", types, size);
        return permutations;
    }

    private void generatePermutations(List<String> permutations, String current, char[] types, int size) {
        if (current.length() == size) {
            permutations.add(current);
            return;
        }

        for (char type : types) {
            generatePermutations(permutations, current + type, types, size);
        }
    }
}
