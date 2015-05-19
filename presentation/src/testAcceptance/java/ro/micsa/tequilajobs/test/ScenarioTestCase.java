package ro.micsa.tequilajobs.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.jdbc.core.JdbcTemplate;
import ro.micsa.tequilajobs.tomcat.TomcatEmbedded;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ScenarioTestCase {

    public static final int TIME_OUT_IN_SECONDS = 30;
    protected static WebDriver driver;
    private static TomcatEmbedded tomcatEmbedded;

    static {
        tomcatEmbedded = new TomcatEmbedded();
        tomcatEmbedded.start();
    }

    @BeforeClass
    public static void setUpClass(){
        driver = new FirefoxDriver();
    }

    @Before
    public void setUpTest(){
        cleanupDatabase();
    }

    @AfterClass
    public static void tearDownClass(){
        driver.quit();
    }

    private void cleanupDatabase() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getBean(DataSource.class));
        jdbcTemplate.execute("DELETE from Job");
    }

    protected void waitForAngularHttpRequests() {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null) && (angular.element(document).injector() != null) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            }
        });
    }

    protected void waitFor(By by) {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForPageLoaded() {
        new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    protected void goToHomePage() {
        driver.get("http://localhost:8080/tequila-jobs/");
        waitForAngularHttpRequests();
    }

    protected void assertElementWithIdVisible(String id) {
        assertThat(driver.findElement(By.id(id)).isDisplayed()).isTrue();
    }

    protected void assertPageContains(String expectedString) {
        assertThat(driver.getPageSource()).contains(expectedString);
    }

    protected <T> T getBean(Class<T> clazz){
        return tomcatEmbedded.getApplicationContext().getBean(clazz);
    }
}
