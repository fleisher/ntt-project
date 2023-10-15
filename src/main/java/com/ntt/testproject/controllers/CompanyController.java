package com.ntt.testproject.controllers;

import com.ntt.testproject.dto.CompanyDto;
import com.ntt.testproject.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для работы с компаниями.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    /**
     * Получает список компаний. Если указан параметр поиска, возвращает результаты поиска.
     *
     * @param search параметр поиска по компаниям (необязательный)
     * @return список DTO компаний
     */
    @GetMapping
    public List<CompanyDto> getCompanies(@RequestParam(required = false) String search) {
        return companyService.getCompaniesList(search);
    }

    /**
     * Получает информацию о компании по идентификатору.
     *
     * @param id идентификатор компании
     * @return DTO компании
     */
    @GetMapping("/{id}")
    public CompanyDto getOrganizationById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

}
