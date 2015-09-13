package ro.micsa.tequilajobs.repository.builder;

import ro.micsa.tequilajobs.domain.*;

import java.util.Date;

public class JobTestBuilder {
    private Long id;
    private String title = "Senior Java Developer";
    private Company company;
    private String location = "Bucharest";
    private JobDomain domain = JobDomain.SOFTWARE;
    private String description = "We are currently looking for a Senior Java Developer with AngularJS knowledge";
    private String profile = "Java minimum 7 years of experience";
    private String offer = "great opportunities";
    private String extraInformation;
    private Integer numberOfPositions = 3;
    private Integer minYearsOfExperience = 7;
    private CareerLevel careerLevel = CareerLevel.SENIOR;
    private Integer salaryFrom = 1000;
    private Integer salaryTo = 3000;
    private Date createdAt = new Date();
    private String createdBy = "user";
    private Date validFrom = new Date();
    private Date validUntil =  new Date();
    private JobState state = JobState.OPEN;

    private JobTestBuilder() {
    }

    public static JobTestBuilder aJob() {
        return new JobTestBuilder();
    }

    public JobTestBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public JobTestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public JobTestBuilder withCompany(Company company) {
        this.company = company;
        return this;
    }

    public JobTestBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public JobTestBuilder withDomain(JobDomain domain) {
        this.domain = domain;
        return this;
    }

    public JobTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public JobTestBuilder withProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public JobTestBuilder withOffer(String offer) {
        this.offer = offer;
        return this;
    }

    public JobTestBuilder withExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
        return this;
    }

    public JobTestBuilder withNumberOfPositions(Integer numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
        return this;
    }

    public JobTestBuilder withMinYearsOfExperience(Integer minYearsOfExperience) {
        this.minYearsOfExperience = minYearsOfExperience;
        return this;
    }

    public JobTestBuilder withCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
        return this;
    }

    public JobTestBuilder withSalaryFrom(Integer salaryFrom) {
        this.salaryFrom = salaryFrom;
        return this;
    }

    public JobTestBuilder withSalaryTo(Integer salaryTo) {
        this.salaryTo = salaryTo;
        return this;
    }

    public JobTestBuilder withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public JobTestBuilder withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public JobTestBuilder withValidFrom(Date validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public JobTestBuilder withValidUntil(Date validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public JobTestBuilder withState(JobState state) {
        this.state = state;
        return this;
    }

    public Job build() {
        Job job = new Job(title);
        job.setId(id);
        job.setCompany(company);
        job.setLocation(location);
        job.setDomain(domain);
        job.setDescription(description);
        job.setProfile(profile);
        job.setOffer(offer);
        job.setExtraInformation(extraInformation);
        job.setNumberOfPositions(numberOfPositions);
        job.setMinYearsOfExperience(minYearsOfExperience);
        job.setCareerLevel(careerLevel);
        job.setSalaryFrom(salaryFrom);
        job.setSalaryTo(salaryTo);
        job.setCreatedAt(createdAt);
        job.setCreatedBy(createdBy);
        job.setValidFrom(validFrom);
        job.setValidUntil(validUntil);
        job.setState(state);
        return job;
    }
}
