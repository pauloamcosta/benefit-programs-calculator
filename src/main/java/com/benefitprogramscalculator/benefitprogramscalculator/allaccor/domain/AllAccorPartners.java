package com.benefitprogramscalculator.benefitprogramscalculator.allaccor.domain;

import java.util.Arrays;
import java.util.List;

public enum AllAccorPartners {

    LIVELO("Livelo", 2.5F, 42.0F),
    SMILES_REGULAR("Smiles", 7.0F, 17.0F),
    SMILES_DIAMANTE("Smiles com clube", 6.0F, 17.0F),
    AZUL_REGULAR("Tudo Azul", 10.0F, 21.0F),
    AZUL_DIAMANTE("Tudo Azul Diamante", 8.0F, 21.0F),
    LATAM_PASS("Latam Pass", 6.0F, 25.0F);

    private String description;
    private Float rate;
    private Float default1000PointsValue;


    AllAccorPartners(String description, Float rate, Float default1000PointsValue) {
        this.description = description;
        this.rate = rate;
        this.default1000PointsValue = default1000PointsValue;
    }

    public static List<AllAccorPartners> getAllPartners(){
        return Arrays.asList(
                AllAccorPartners.LIVELO,
                AllAccorPartners.AZUL_DIAMANTE,
                AllAccorPartners.AZUL_REGULAR,
                AllAccorPartners.LATAM_PASS,
                AllAccorPartners.SMILES_DIAMANTE,
                AllAccorPartners.SMILES_REGULAR);
    }

    public String getDescription() {
        return description;
    }

    public Float getRate() {
        return rate;
    }

    public Float getDefault1000PointsValue() {
        return default1000PointsValue;
    }
}
