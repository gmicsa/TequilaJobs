package ro.micsa.tequilajobs.repository;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ro.micsa.tequilajobs.domain.Company;
import ro.micsa.tequilajobs.domain.Job;
import ro.micsa.tequilajobs.domain.JobBuilder;

import java.util.Iterator;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.api.Assertions.assertThat;

public class JobRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    private Job javaDeveloper, dotNetDeveloper;

    private Company companyCegeka;

    @Before
    public void setUp() throws Exception {
        companyCegeka =  companyRepository.findByName("Cegeka Romania");

        javaDeveloper = JobBuilder
                .aJob()
                .withTitle("Java developer")
                .withCompany(companyCegeka)
                .build();
        dotNetDeveloper = JobBuilder
                .aJob()
                .withTitle(".NET developer")
                .withCompany(companyCegeka)
                .build();
    }

    @Test
    public void findAll_given2JobsInDatabase_then2JobsAreReturned(){
        jobRepository.save(newArrayList(javaDeveloper, dotNetDeveloper));

        Iterable<Job> jobs = jobRepository.findAll();

        assertThat(jobs).hasSize(2);
        Iterator<Job> jobIterator = jobs.iterator();
        assertThat(jobIterator.next()).isEqualTo(javaDeveloper);
        assertThat(jobIterator.next()).isEqualTo(dotNetDeveloper);
    }
}
