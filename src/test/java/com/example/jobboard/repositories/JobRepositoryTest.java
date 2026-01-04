package com.example.jobboard.repositories;

import com.example.jobboard.entities.Company;
import com.example.jobboard.entities.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class JobRepositoryTest {

    @Autowired
    @SuppressWarnings("unused")
    private JobRepository jobRepository;
    @Autowired
    @SuppressWarnings("unused")
    private CompanyRepository companyRepository;

    @Test
    void testSaveAndFindAll() {
        //create and save company
        Company company = new Company();
        company.setName("Acme Corp");
        company.setIndustry("IT");
        Company savedCompany = companyRepository.save(company);

        // create and save job
        Job job = new Job();
        job.setTitle("Backend Developer");
        job.setDescription("Spring Boot API");
        job.setLocation("Berlin");
        job.setSalary(60000.0);
        job.setCompany(savedCompany);

        Job savedJob = jobRepository.save(job);

        // verify job persisted
        assertThat(savedJob.getId()).isNotNull();
        assertThat(savedJob.getCompany().getName()).isEqualTo("Acme Corp");

        // verify findAll
        List<Job> jobs = jobRepository.findAll();
        assertThat(jobs).hasSize(1);
        assertThat(jobs.get(0).getTitle()).isEqualTo("Backend Developer");
    }
}