package ro.micsa.tequilajobs.repository;

import org.springframework.data.repository.CrudRepository;
import ro.micsa.tequilajobs.domain.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

}
