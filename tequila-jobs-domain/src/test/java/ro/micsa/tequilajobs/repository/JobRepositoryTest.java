package ro.micsa.tequilajobs.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.micsa.tequilajobs.domain.Job;

import javax.transaction.Transactional;

import java.util.Iterator;

import static org.fest.assertions.api.Assertions.assertThat;

public class JobRepositoryTest extends AbstractRepositoryTest{

    public static final Job JOB_1 = new Job("job1");
    public static final Job JOB_2 = new Job("job2");

    @Autowired
    private JobRepository jobRepository;

    @Test
    public void findAll_given2JobsInDatabase_then2JobsAreReturned(){
        jobRepository.save(JOB_1);
        jobRepository.save(JOB_2);

        Iterable<Job> jobs = jobRepository.findAll();

        assertThat(jobs).hasSize(2);
        Iterator<Job> jobIterator = jobs.iterator();
        assertThat(jobIterator.next()).isEqualTo(JOB_1);
        assertThat(jobIterator.next()).isEqualTo(JOB_2);
    }
}
