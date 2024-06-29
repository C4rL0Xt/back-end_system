package com.bbraun.producto.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
public class LotePresentationDto {

    private String code;
    private String operativeStatus;
    private String disponibilityState;
    private String securityState;
    private Integer stock;
    private Date expiredDate;
}
