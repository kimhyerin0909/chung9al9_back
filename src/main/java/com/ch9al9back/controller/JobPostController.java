package com.ch9al9back.controller;

import com.ch9al9back.domain.JobPost;
import com.ch9al9back.repository.JobPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JobPostController {
    private final JobPostRepository jobPostRepository;

    public JobPostController(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @RequestMapping("/post")
    public String Post(@RequestBody JobPost newPost) throws Exception {
        jobPostRepository.addJobPost(newPost);
        return "success";
    }

    @RequestMapping(value = "/getPost", method = RequestMethod.GET)
    public List<JobPost> GetPost(@RequestParam double lat, @RequestParam double lon) throws Exception {
        return jobPostRepository.getPostByLatLon(lat, lon);
    }
}
