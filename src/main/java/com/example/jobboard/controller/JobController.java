package com.example.jobboard.controller;

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
    public List<Job> getAllJobs() {return jobService.findAll(); }

    @PostMapping
    public Job createJob(@RequestBody Job job) { return jobService.save(job); }

}
