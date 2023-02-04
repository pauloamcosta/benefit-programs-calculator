package com.benefitprogramscalculator.benefitprogramscalculator.allaccor.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class AllAccorPartner implements Serializable {
    private String name;
    private String value;
}
