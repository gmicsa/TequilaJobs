package ro.micsa.tequilajobs.job;

import org.junit.Before;
import org.junit.Test;
import ro.micsa.tequilajobs.domain.Company;
import ro.micsa.tequilajobs.domain.Job;
import ro.micsa.tequilajobs.domain.builder.JobBuilder;
import ro.micsa.tequilajobs.test.ScenarioTestCase;
import ro.micsa.tequilajobs.repository.CompanyRepository;
import ro.micsa.tequilajobs.repository.JobRepository;

import static com.google.common.collect.Lists.newArrayList;

public class JobScenarioTest extends ScenarioTestCase {

    private JobRepository jobRepository;
    private CompanyRepository companyRepository;

    private Job javaDeveloper, dotNetDeveloper;
    private Company companyCegeka;

    @Before
    public void setUp(){
        jobRepository = getBean(JobRepository.class);
        companyRepository = getBean(CompanyRepository.class);

        companyCegeka =  companyRepository.findByName("Cegeka Romania");
    }

    @Test
    public void given2JobsInDatabase_whenShowingHomePage_thenThese2JobsAreDisplayed(){
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

        jobRepository.save(newArrayList(javaDeveloper, dotNetDeveloper));

        goToHomePage();

        assertPageContains("Available jobs");
        assertElementWithIdVisible("jobpanel_" + javaDeveloper.getId());
        assertElementWithIdVisible("jobpanel_" + dotNetDeveloper.getId());
    }
}
