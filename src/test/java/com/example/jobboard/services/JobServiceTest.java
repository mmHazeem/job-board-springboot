package com.example.jobboard.services;

import com.example.jobboard.entities.Job;
import com.example.jobboard.repositories.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JobServiceTest {
    private JobRepository jobRepository;
    private JobService jobService;

    @BeforeEach
    void setUp() {
        jobRepository = mock(JobRepository.class);
        jobService = new JobService(jobRepository);
    }
    @Test
    void findAll() {
        Job firstJob = new Job();
        firstJob.setTitle("Java Developer");

        Job secondJob = new Job();
        secondJob.setTitle("Spring boot Engineer");

        when(jobRepository.findAll()).thenReturn(Arrays.asList(firstJob, secondJob));

        List<Job> result = jobService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(firstJob));
        assertTrue(result.contains(secondJob));

    }

    @Test
    void save() {
        Job newJob = new Job();
        newJob.setTitle("Backend Developer");
        newJob.setSalary(60000.0);
        newJob.setLocation("Bremen");

        when(jobRepository.save(newJob)).thenReturn(newJob);

        Job result = jobService.save(newJob);
        assertNotNull(result);
        assertEquals("Backend Developer", result.getTitle());
        assertEquals("Bremen", result.getLocation());
        assertEquals(60000.0, result.getSalary());
    }
}