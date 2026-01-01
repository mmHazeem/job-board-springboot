package com.example.jobboard.repositories;

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

    @Test
    void testSaveAndFindAll() {
        Job job = new Job();
        job.setTitle("Java Developer");
        job.setLocation("Berlin");
        job.setSalary(60000.0);

        jobRepository.save(job);
        List<Job> jobs = jobRepository.findAll();

        assertThat(jobs).hasSize(1);
        assertThat(jobs.get(0).getTitle()).isEqualTo("Java Developer"); }
}