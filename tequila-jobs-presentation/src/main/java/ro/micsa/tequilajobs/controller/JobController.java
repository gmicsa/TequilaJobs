package ro.micsa.tequilajobs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.micsa.tequilajobs.repository.JobRepository;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/jobs")
    public String jobs(Model model) {
        model.addAttribute("jobs",  jobRepository.findAll());
        return "jobs";
    }
}