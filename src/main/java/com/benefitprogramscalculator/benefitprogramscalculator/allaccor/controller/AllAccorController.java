package com.benefitprogramscalculator.benefitprogramscalculator.allaccor.controller;

import com.benefitprogramscalculator.benefitprogramscalculator.allaccor.domain.AllAccorPartner;
import com.benefitprogramscalculator.benefitprogramscalculator.allaccor.domain.AllAccorPartners;
import com.benefitprogramscalculator.benefitprogramscalculator.allaccor.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/allaccor")
public class AllAccorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/convert")
    public ResponseEntity<List<AllAccorPartner>> convert(@RequestParam("value") Float value) {

        List<AllAccorPartner> allAccorPartnerList = new ArrayList<>();
        AllAccorPartners.getAllPartners().forEach(partner -> {
                    Float newValue = calculatorService.calculatePoints(
                            partner,
                            calculatorService.calculatePoints(partner, value)
                    );
            DecimalFormat df = new DecimalFormat("#.##");

                    allAccorPartnerList.add(AllAccorPartner.builder()
                            .name(partner.getDescription())
                            .value("R$"+ df.format(newValue))
                            .build()
                    );
                }
        );
        return ResponseEntity.ok(allAccorPartnerList);
    }
}
