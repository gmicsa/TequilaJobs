package ro.micsa.tequilajobs.job;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ro.micsa.tequilajobs.domain.Job;
import ro.micsa.tequilajobs.repository.JobRepository;
import ro.micsa.tequilajobs.test.IntegrationTestCase;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ro.micsa.tequilajobs.repository.builder.JobTestBuilder.aJob;

public class JobResourceIntegrationTest extends IntegrationTestCase{

    public static final String DEVELOPER_TITLE = "Java developer";

    @Autowired
    private JobRepository jobRepository;

    private Job developer;

    @Before
    public void setup() {
        developer = aJob().withTitle(DEVELOPER_TITLE).build();
        jobRepository.save(developer);
    }

    @Test
    public void getJobsTest() throws Exception {
        mockMvc.perform(get("/jobs"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is(DEVELOPER_TITLE)));
    }
}
