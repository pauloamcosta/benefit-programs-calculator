package com.benefitprogramscalculator.benefitprogramscalculator.allaccor;

import com.benefitprogramscalculator.benefitprogramscalculator.commons.CurrencyConverter;
import com.benefitprogramscalculator.benefitprogramscalculator.allaccor.domain.AllAccorPartners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {

    public static final int ALL_ACCOR_POINTS_RATE = 2000;
    public static final float ALL_ACCOR_EUROS_RATE = 40.0F;

    @Autowired
    CurrencyConverter currencyConverter;

    public Float calculatePoints(AllAccorPartners parter, Float allAccorReaisValue) {

        try {
            Float allAccorEuroValue = currencyConverter.convertToEuros(allAccorReaisValue);
            Float allAccorPoints = (allAccorEuroValue / ALL_ACCOR_EUROS_RATE) * ALL_ACCOR_POINTS_RATE;
            allAccorPoints = (allAccorPoints * parter.getRate()) / 1000;
            allAccorPoints = allAccorPoints * parter.getDefault1000PointsValue();

            System.out.println("Valor em pontos para " + parter.getDescription() + ": R$" + allAccorPoints.shortValue());
            getDifference(allAccorReaisValue, allAccorPoints, parter.getDescription());
            return allAccorPoints;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getDifference(float allAccorReaisValue, Float realValueInPoints, String partner) {
        if (realValueInPoints > allAccorReaisValue) {
            Float differenceForRealBetter = realValueInPoints - allAccorReaisValue;
            System.out.println("O valor para " + partner + " está R$" + differenceForRealBetter.shortValue() + " mais caro em pontos");
        } else {
            Float differenceForPointsBetter = allAccorReaisValue - realValueInPoints;
            System.out.println("O valor para " + partner + " está R$" + differenceForPointsBetter.shortValue() + " mais barato em pontos");
        }
    }
}
