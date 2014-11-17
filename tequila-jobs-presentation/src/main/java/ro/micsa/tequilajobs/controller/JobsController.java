package ro.micsa.tequilajobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobsController {

    @RequestMapping("/jobs")
    public String jobs(@RequestParam(value="job_name", required=false, defaultValue="Java Developer") String jobName, Model model) {
        model.addAttribute("jobName", jobName);
        return "jobs";
    }
}