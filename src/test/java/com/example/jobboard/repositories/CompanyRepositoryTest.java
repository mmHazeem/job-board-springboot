package com.example.jobboard.repositories;

import com.example.jobboard.entities.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    @SuppressWarnings("unused")
    private CompanyRepository companyRepository;

    @Test
    void testSaveAndFindCompany() {
        //create and save company
        Company company = new Company();
        company.setName("Acme Corp");
        company.setIndustry("IT");

        Company savedCompany = companyRepository.save(company);

        assertThat(savedCompany.getId()).isNotNull();
        assertThat(savedCompany.getName()).isEqualTo("Acme Corp");
        List<Company> result = companyRepository.findAll();
        assertThat(result).hasSize(1);
    }

}