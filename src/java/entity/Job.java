/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"fromCompanies"})
public class Job {
    @Id
    @GeneratedValue
    private long jobId;
    
    private String jobName;
    
    private int count;
    
    private double oldRating;
    
    private double nowRating;
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="job_company",
            joinColumns={@JoinColumn(name="jobId")},
            inverseJoinColumns={@JoinColumn(name="companyId")}
    )
    private List<Company> fromCompanies=new ArrayList<Company>();

    public Job() {
    }

    public Job(String jobName) {
        this.jobName = jobName;
        this.count=0;
        this.oldRating=0;
        this.nowRating=0;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getOldRating() {
        return oldRating;
    }

    public void setOldRating(double oldRating) {
        this.oldRating = oldRating;
    }

    public double getNowRating() {
        return nowRating;
    }

    public void setNowRating(double nowRating) {
        this.nowRating = nowRating;
    }

    public List<Company> getFromCompanies() {
        return fromCompanies;
    }

    public void setFromCompanies(List<Company> fromCompanies) {
        this.fromCompanies = fromCompanies;
    }

    
    
}
