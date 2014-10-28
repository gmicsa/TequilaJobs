package ro.micsa.tequilajobs.domain;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private Job() {
    }

    public Job(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
