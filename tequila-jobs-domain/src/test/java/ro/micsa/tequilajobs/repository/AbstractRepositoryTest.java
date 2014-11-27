package ro.micsa.tequilajobs.repository;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.micsa.tequilajobs.config.PersistenceConfig;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
@Transactional
public abstract class AbstractRepositoryTest {

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("tequilaEnv", "test");
    }
}
