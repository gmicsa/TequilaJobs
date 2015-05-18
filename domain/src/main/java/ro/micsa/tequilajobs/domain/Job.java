package ro.micsa.tequilajobs.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private JobDomain domain;

    @Column(nullable = false)
    private String description;

    @Column
    private String profile;

    @Column
    private String offer;

    @Column(name = "extra_info")
    private String extraInformation;

    @Column(name = "positions_number")
    private Integer numberOfPositions;

    @Column(name = "min_experience")
    private Integer minYearsOfExperience;

    @Column(name = "career_level")
    @Enumerated(EnumType.STRING)
    private CareerLevel careerLevel;

    @Column(name = "salary_from")
    private Integer salaryFrom;

    @Column(name = "salary_to")
    private Integer salaryTo;

    @Column(name = "created_at")
    private Date createdAt = new Date();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "valid_from")
    private Date validFrom;

    @Column(name = "valid_until")
    private Date validUntil;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private JobState state = JobState.OPEN;

    private Job() {
    }

    public Job(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JobDomain getDomain() {
        return domain;
    }

    public void setDomain(JobDomain domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(String extraInformation) {
        this.extraInformation = extraInformation;
    }

    public Integer getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(Integer numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public Integer getMinYearsOfExperience() {
        return minYearsOfExperience;
    }

    public void setMinYearsOfExperience(Integer minYearsOfExperience) {
        this.minYearsOfExperience = minYearsOfExperience;
    }

    public CareerLevel getCareerLevel() {
        return careerLevel;
    }

    public void setCareerLevel(CareerLevel careerLevel) {
        this.careerLevel = careerLevel;
    }

    public Integer getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(Integer salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public Integer getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(Integer salaryTo) {
        this.salaryTo = salaryTo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public JobState getState() {
        return state;
    }

    public void setState(JobState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (careerLevel != job.careerLevel) return false;
        if (company != null ? !company.equals(job.company) : job.company != null) return false;
        if (createdAt != null ? !createdAt.equals(job.createdAt) : job.createdAt != null) return false;
        if (createdBy != null ? !createdBy.equals(job.createdBy) : job.createdBy != null) return false;
        if (description != null ? !description.equals(job.description) : job.description != null) return false;
        if (domain != job.domain) return false;
        if (extraInformation != null ? !extraInformation.equals(job.extraInformation) : job.extraInformation != null)
            return false;
        if (id != null ? !id.equals(job.id) : job.id != null) return false;
        if (location != null ? !location.equals(job.location) : job.location != null) return false;
        if (minYearsOfExperience != null ? !minYearsOfExperience.equals(job.minYearsOfExperience) : job.minYearsOfExperience != null)
            return false;
        if (numberOfPositions != null ? !numberOfPositions.equals(job.numberOfPositions) : job.numberOfPositions != null)
            return false;
        if (offer != null ? !offer.equals(job.offer) : job.offer != null) return false;
        if (profile != null ? !profile.equals(job.profile) : job.profile != null) return false;
        if (salaryFrom != null ? !salaryFrom.equals(job.salaryFrom) : job.salaryFrom != null) return false;
        if (salaryTo != null ? !salaryTo.equals(job.salaryTo) : job.salaryTo != null) return false;
        if (state != job.state) return false;
        if (title != null ? !title.equals(job.title) : job.title != null) return false;
        if (validFrom != null ? !validFrom.equals(job.validFrom) : job.validFrom != null) return false;
        if (validUntil != null ? !validUntil.equals(job.validUntil) : job.validUntil != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (domain != null ? domain.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (offer != null ? offer.hashCode() : 0);
        result = 31 * result + (extraInformation != null ? extraInformation.hashCode() : 0);
        result = 31 * result + (numberOfPositions != null ? numberOfPositions.hashCode() : 0);
        result = 31 * result + (minYearsOfExperience != null ? minYearsOfExperience.hashCode() : 0);
        result = 31 * result + (careerLevel != null ? careerLevel.hashCode() : 0);
        result = 31 * result + (salaryFrom != null ? salaryFrom.hashCode() : 0);
        result = 31 * result + (salaryTo != null ? salaryTo.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validUntil != null ? validUntil.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
