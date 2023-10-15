package com.ntt.testproject.configuration;

import com.ntt.testproject.entities.Address;
import com.ntt.testproject.entities.Branch;
import com.ntt.testproject.entities.Company;
import com.ntt.testproject.entities.Person;
import com.ntt.testproject.repositories.AddressRepository;
import com.ntt.testproject.repositories.BranchRepository;
import com.ntt.testproject.repositories.CompanyRepository;
import com.ntt.testproject.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Инициализатор базы данных при запуске приложения.
 * Добавляет начальные данные в базу данных, если она пуста.
 */
@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    private final CompanyRepository companyRepository;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final BranchRepository branchRepository;

    @PostConstruct
    public void initDb() {
        if (companyRepository.count() == 0) {
            for (int i = 1; i <= 50; i++) {
                Person ceo = new Person();
                ceo.setFirstName("Фамилия" + i);
                ceo.setLastName("Имя" + i);
                ceo.setBirthDate(getRandomBirthDate());
                personRepository.save(ceo);

                Address address = new Address();
                address.setZipCode("0000" + i);
                address.setCountry("Россия");
                address.setCity("Город " + i);
                address.setStreet("ул. Главная " + i);
                address.setBuilding(String.valueOf(i));
                address.setOffice(String.valueOf(i));

                addressRepository.save(address);

                Company company = new Company();
                company.setFullName("Компания " + i + " ООО");
                company.setShortName("К" + i);
                company.setInn("100000000" + i);
                company.setOgrn("100000000" + i + "000");
                company.setPostalAddress(address);
                company.setLegalAddress(address);
                company.setCeo(ceo);

                companyRepository.save(company);

                Branch branch = new Branch();
                branch.setName("Филиал " + i);
                branch.setPostalAddress(address);
                branch.setCeo(ceo);
                branch.setCompany(company);

                branchRepository.save(branch);

                Branch branch2 = new Branch();
                branch2.setName("Филиал2 " + i);
                branch2.setPostalAddress(address);
                branch2.setCeo(ceo);
                branch2.setCompany(company);

                branchRepository.save(branch2);
            }
        }
    }

    private LocalDate getRandomBirthDate() {
        long minDay = LocalDate.of(1950, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2000, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}