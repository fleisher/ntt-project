package com.ntt.testproject.services;

import com.ntt.testproject.dto.CompanyDto;
import com.ntt.testproject.entityes.Company;
import com.ntt.testproject.exceptions.CompanyNotFoundException;
import com.ntt.testproject.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CompanyDto> getCompaniesByFullName(String fullName) {
        List<Company> companies = companyRepository.findByFullNameContaining(fullName);
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CompanyDto getCompanyById(Long id) {
        return companyRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
    }

    public List<CompanyDto> searchOrganizationsByFullName(String fullName) {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CompanyDto convertToDto(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setFullName(company.getFullName());
        dto.setShortName(company.getShortName());
        dto.setInn(company.getInn());
        dto.setOgrn(company.getOgrn());
        dto.setPostalAddress(company.getPostalAddress());
        dto.setLegalAddress(company.getLegalAddress());
        dto.setCeoName(company.getCeoName());
        return dto;
    }
}
