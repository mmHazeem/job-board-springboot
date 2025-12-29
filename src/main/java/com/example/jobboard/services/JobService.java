package com.example.jobboard.services;

import com.example.jobboard.entities.Job;
import org.springframework.stereotype.Service;
import com.example.jobboard.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public Job save(Job job) {
        return jobRepository.save(job);
    }
}
