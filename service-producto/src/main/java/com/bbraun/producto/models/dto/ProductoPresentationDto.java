package com.bbraun.producto.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class ProductoPresentationDto {
    private String code;
    private String category;
    private String type;
    private String name;
    private Float price;
    private String concentracion;
    private String presentation;
    private String description;
    private List<LotePresentationDto> lots;
}
