package com.ntt.testproject.repositories;

import com.ntt.testproject.entityes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByFullNameContaining(String fullName);
}