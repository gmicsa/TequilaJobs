package ro.micsa.tequilajobs.repository;

import org.springframework.data.repository.CrudRepository;
import ro.micsa.tequilajobs.domain.Company;
import ro.micsa.tequilajobs.domain.Job;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    public Company findByName(String name);

}
