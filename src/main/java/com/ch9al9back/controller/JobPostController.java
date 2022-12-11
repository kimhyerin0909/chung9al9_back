package com.ch9al9back.controller;

import com.ch9al9back.domain.JobPost;
import com.ch9al9back.repository.JobPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<JobPost> GetPost(@RequestParam double lat, @RequestParam double lon, @RequestParam int distance) throws Exception {
        return jobPostRepository.getPostByLatLon(lat, lon, distance);
    }

    @RequestMapping(value = "/getPostDetail", method = RequestMethod.GET)
    public JobPost GetPostDetail(@RequestParam long post_id) throws Exception {
        return jobPostRepository.findDetailById(post_id);
    }

    @RequestMapping(value = "/deletePost", method = RequestMethod.DELETE)
    public String DeletePost(@RequestParam long post_id) throws Exception {
        jobPostRepository.deletePost(post_id);
        return "deleted";
    }
}
