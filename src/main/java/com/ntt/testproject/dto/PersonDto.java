package com.ntt.testproject.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) для сущности Person.
 * Представляет собой объект передачи данных между слоями приложения без логики.
 */
@Data
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
