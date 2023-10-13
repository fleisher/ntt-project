package com.ntt.testproject.сontrollers;

import com.ntt.testproject.dto.CompanyDto;
import com.ntt.testproject.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDto> getCompanies(@RequestParam(required = false) String fullName) {
        List<CompanyDto> companies;
        if (fullName != null) {
            companies = companyService.getCompaniesByFullName(fullName);
        } else {
            companies = companyService.getAllCompanies();
        }
        return companies;
    }

    @GetMapping("/{id}")
    public CompanyDto getOrganizationById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }
}
