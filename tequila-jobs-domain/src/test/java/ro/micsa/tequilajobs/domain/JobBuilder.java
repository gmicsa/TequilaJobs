package ro.micsa.tequilajobs.domain;

import java.util.Date;

public class JobBuilder {
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

    private JobBuilder() {
    }

    public static JobBuilder aJob() {
        return new JobBuilder();
    }

    public JobBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public JobBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public JobBuilder withCompany(Company company) {
        this.company = company;
        return this;
    }

    public JobBuilder withLocation(String location) {
        this.location = location;
        return this;
    }

    public JobBuilder withDomain(JobDomain domain) {
        this.domain = domain;
        return this;
    }

    public JobBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public JobBuilder withProfile(String profile) {
        this.profile = profile;
        return this;
    }

    public JobBuilder withOffer(String offer) {
        this.offer = offer;
        return this;
    }

    public JobBuilder withExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
        return this;
    }

    public JobBuilder withNumberOfPositions(Integer numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
        return this;
    }

    public JobBuilder withMinYearsOfExperience(Integer minYearsOfExperience) {
        this.minYearsOfExperience = minYearsOfExperience;
        return this;
    }

    public JobBuilder withCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
        return this;
    }

    public JobBuilder withSalaryFrom(Integer salaryFrom) {
        this.salaryFrom = salaryFrom;
        return this;
    }

    public JobBuilder withSalaryTo(Integer salaryTo) {
        this.salaryTo = salaryTo;
        return this;
    }

    public JobBuilder withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public JobBuilder withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public JobBuilder withValidFrom(Date validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public JobBuilder withValidUntil(Date validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public JobBuilder withState(JobState state) {
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
