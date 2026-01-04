package com.example.jobboard.controller;

import com.example.jobboard.dtos.JobDto;
import com.example.jobboard.entities.Job;
import com.example.jobboard.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.findAll().stream()
            .map(job -> new JobDto(
                    job.getTitle(),
                    job.getDescription(),
                    job.getLocation(),
                    job.getSalary(),
                    job.getCompany() !=null ?job.getCompany().getName() : null
            )).toList()
            ; }

    @PostMapping
    public JobDto createJob(@RequestBody Job job) {
        Job savedJob = jobService.save(job);
        return new JobDto(
                savedJob.getTitle(),
                savedJob.getDescription(),
                savedJob.getLocation(),
                savedJob.getSalary(),
                savedJob.getCompany() != null ? savedJob.getCompany().getName() :  null
        );
    }

}
