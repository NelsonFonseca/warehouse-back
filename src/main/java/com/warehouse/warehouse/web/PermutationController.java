package com.warehouse.warehouse.web;

import com.warehouse.warehouse.domain.service.PermutationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permutations")
public class PermutationController {
    @Autowired
    private PermutationService permutationService;

    @GetMapping
    public List<String> calculatePermutations(@RequestParam String family, @RequestParam int size) {
        return permutationService.calculatePermutations(family, size);
    }
}
