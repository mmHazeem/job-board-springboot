package com.example.jobboard.services;

import com.example.jobboard.entities.Job;
import com.example.jobboard.entities.Company;
import com.example.jobboard.repositories.CompanyRepository;
import org.springframework.stereotype.Service;
import com.example.jobboard.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    private final CompanyRepository companyRepository;

    public JobService(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public Job save(Job job) {
        if (job.getCompany() != null && job.getCompany().getId() == null) {
            Company savedCompany = companyRepository.save(job.getCompany());
            job.setCompany(savedCompany);
        }
        return jobRepository.save(job);
    }
}
