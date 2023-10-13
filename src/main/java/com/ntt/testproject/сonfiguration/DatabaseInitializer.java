package com.ntt.testproject.сonfiguration;

import com.ntt.testproject.entityes.Company;
import com.ntt.testproject.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final CompanyRepository companyRepository;

    @PostConstruct
    public void initDb() {
        if (companyRepository.count() == 0) {
            for (int i = 1; i <= 50; i++) {
                Company company = new Company();
                company.setId((long) i);
                company.setFullName("Компания " + i + " ООО");
                company.setShortName("К" + i);
                company.setInn("100000000" + i);
                company.setOgrn("100000000" + i + "000");
                company.setPostalAddress("ул. Главная " + i + ", Город " + i);
                company.setLegalAddress("ул. Главная " + i + ", Город " + i);
                company.setCeoName("Директор " + i);
                companyRepository.save(company);
            }
        }
    }
}
