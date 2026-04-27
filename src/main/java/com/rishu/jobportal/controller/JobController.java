package com.rishu.jobportal.controller;

import com.rishu.jobportal.entity.Job;
import com.rishu.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepo;

    @PostMapping("/add")
    public Job addJob(@RequestBody Job job) {
        return jobRepo.save(job);
    }

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }
    @GetMapping("/search")
    public List<Job> searchJobs(@RequestParam String title) {
        return jobRepo.findByTitleContainingIgnoreCase(title);
    }
}