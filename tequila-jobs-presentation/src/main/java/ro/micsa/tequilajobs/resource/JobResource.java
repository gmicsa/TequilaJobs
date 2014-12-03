package ro.micsa.tequilajobs.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.micsa.tequilajobs.domain.Job;
import ro.micsa.tequilajobs.repository.JobRepository;

@RestController
public class JobResource {

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping(value = "/jobs")
    public Iterable<Job> jobs() {
        return jobRepository.findAll();
    }
}