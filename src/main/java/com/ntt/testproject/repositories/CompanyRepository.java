package com.ntt.testproject.repositories;

import com.ntt.testproject.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {
//    List<Company> findByFullNameContaining(String fullName);
}