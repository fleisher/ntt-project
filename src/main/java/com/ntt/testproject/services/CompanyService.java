package com.ntt.testproject.services;

import com.ntt.testproject.dto.CompanyDto;
import com.ntt.testproject.entities.Company;
import com.ntt.testproject.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с компаниями.
 */
@Service
@RequiredArgsConstructor
public class CompanyService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    /**
     * Получает список компаний. Если указан параметр поиска, возвращает результаты поиска.
     *
     * @param search параметр поиска по компаниям
     * @return список DTO компаний
     */
    public List<CompanyDto> getCompaniesList(String search) {

        if (search != null) {
            return searchCompanies(search);
        }
        return getAllCompanies();
    }

    /**
     * Получает компанию по идентификатору.
     *
     * @param id идентификатор компании
     * @return DTO компании
     * @throws ResponseStatusException (HttpStatus.NOT_FOUND) если компания не найдена
     */
    public CompanyDto getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Company not found by ID: {}", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found");
                });
        return modelMapper.map(company, CompanyDto.class);
    }

    /**
     * Получает все компании из репозитория.
     *
     * @return список DTO всех компаний
     */
    private List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Ищет компании по заданному параметру.
     *
     * @param search параметр поиска
     * @return список найденных DTO компаний
     */
    private List<CompanyDto> searchCompanies(String search) {
        List<Company> companies = companyRepository.findAll((root, query, criteriaBuilder) -> {
            Predicate predicateForFullName = criteriaBuilder.like(root.get("fullName"), search);
            Predicate predicateForInn = criteriaBuilder.like(root.get("inn"), search);
            Predicate predicateForOgrn = criteriaBuilder.like(root.get("ogrn"), search);

            return criteriaBuilder.or(predicateForFullName, predicateForInn, predicateForOgrn);
        });

        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDto.class))
                .collect(Collectors.toList());
    }
}
