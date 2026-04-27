package com.rishu.jobportal.controller;

import com.rishu.jobportal.entity.JobApplication;
import com.rishu.jobportal.repository.JobApplicationRepository;
import com.rishu.jobportal.repository.JobRepository;
import com.rishu.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apply")
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository applicationRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JobRepository jobRepo;

    @PostMapping("/{userId}/{jobId}")
    public String applyForJob(@PathVariable Long userId, @PathVariable Long jobId) {
        JobApplication application = new JobApplication();

        // Connect the specific User and Job to this application
        application.setUser(userRepo.findById(userId).orElseThrow());
        application.setJob(jobRepo.findById(jobId).orElseThrow());

        applicationRepo.save(application);
        return "Applied successfully! User " + userId + " applied for Job " + jobId;
    }

    @GetMapping("/all")
    public List<JobApplication> getAllApplications() {
        return applicationRepo.findAll();
    }
}