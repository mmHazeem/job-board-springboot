package com.example.jobboard.controller;

import com.example.jobboard.entities.Job;
import com.example.jobboard.services.JobService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = JobController.class)
@AutoConfigureMockMvc(addFilters = false)
class JobControllerTest {

    @Autowired
    @SuppressWarnings("unused")
    private MockMvc mockMvc;
    @MockBean
    @SuppressWarnings("unused")
    private JobService jobService;

    @Test
    void getAllJobs() throws Exception {
        Job firstJob = new Job();
        firstJob.setTitle("Java Developer");

        Job secondJob = new Job();
        secondJob.setTitle("Spring Boot Engineer");

        when(jobService.findAll()).thenReturn(List.of(firstJob, secondJob));
        mockMvc.perform(get("/api/jobs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Java Developer"))
                .andExpect(jsonPath("$[1].title").value("Spring Boot Engineer"));
    }

    @Test
    void createJob() throws Exception {
        Job job = new Job();
        job.setTitle("Backend Developer");
        job.setLocation("Berlin");
        job.setSalary(60000.0);

        when(jobService.save(any(Job.class))).thenReturn(job);

        mockMvc.perform(post("/api/jobs")
                .contentType("application/json")
                .content("{\"title\":\"Backend Developer\",\"location\":\"Berlin\",\"salary\":60000}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Backend Developer"))
                .andExpect(jsonPath("$.location").value("Berlin"))
                .andExpect(jsonPath("$.salary").value(60000.0));
    }
}