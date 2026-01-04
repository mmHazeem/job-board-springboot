package com.example.jobboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class JobIntegrationTest {
    @Autowired
    @SuppressWarnings("unused")
    private MockMvc mockMvc;
    @Test
    void testCreateAndGetJob() throws Exception {
        mockMvc.perform(post("/api/jobs")
                        .contentType("application/json")
                        .content("""
                                { "title":"Backend Developer",
                                "description":"Spring Boot API",
                                "location":"Berlin",
                                "salary":60000,
                                "company":{"name":"Acme Corp","industry":"IT"} }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Backend Developer"));

        mockMvc.perform(get("/api/jobs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Backend Developer"))
                .andExpect(jsonPath("$[0].location").value("Berlin"))
                .andExpect(jsonPath("$[0].salary").value(60000.0));
    }
}
