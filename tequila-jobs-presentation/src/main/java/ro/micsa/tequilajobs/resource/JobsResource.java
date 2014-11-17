package ro.micsa.tequilajobs.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobsResource {

    @RequestMapping("/rest/jobs")
    public ResponseEntity<String> jobs() {
        return ResponseEntity.ok("Jobs");
    }
}