package com.ntt.testproject.dto;

import lombok.Data;

/**
 * DTO (Data Transfer Object) для сущности Address.
 * Представляет собой объект передачи данных между слоями приложения без логики.
 */
@Data
public class AddressDto {
    private Long id;
    private String zipCode;
    private String country;
    private String city;
    private String street;
    private String building;
    private String office;
}
