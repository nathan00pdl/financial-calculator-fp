package com.example.financial_calculator_fp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financial_calculator_fp.exceptions.ValidationException;
import com.example.financial_calculator_fp.models.request.CompoundInterestRequestDTO;
import com.example.financial_calculator_fp.models.response.CompoundInterestResponseDTO;
import com.example.financial_calculator_fp.services.JavaCompoundInterestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compound-interest-java")
public class JavaCompoundInterestController {
    private final JavaCompoundInterestService javaService;

    @Autowired
    public JavaCompoundInterestController(@Qualifier("javaImplementation") JavaCompoundInterestService javaService) {
        this.javaService = javaService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CompoundInterestResponseDTO> calculateCompoundInterest(@Valid @RequestBody CompoundInterestRequestDTO request) {
        if (request.getYears() > 200) {
            throw new ValidationException("years", "The Maximium Period Allowed Is 200 Years!");
        }

        CompoundInterestResponseDTO response = javaService.calculateCompoundInterest(request);
        return ResponseEntity.ok(response);
    }
}
