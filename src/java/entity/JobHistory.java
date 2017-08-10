/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"student","vacancy"})
public class JobHistory {
    @Id
    @GeneratedValue
    private long jhId;
    
    private Date wantTime;
    
    //若处于未被录取状态时为null
    private Date workTime;
    
    //双向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="studentId")
    private Student student;
    
    //单向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="vacancyId")
    private Vacancy vacancy;

    public JobHistory() {
    }

    public JobHistory(Date wantTime, Date workTime, Student student, Vacancy vacancy) {
        this.wantTime = wantTime;
        this.workTime = workTime;
        this.student = student;
        this.vacancy = vacancy;
    }

    public long getJhId() {
        return jhId;
    }

    public void setJhId(long jhId) {
        this.jhId = jhId;
    }

    public Date getWantTime() {
        return wantTime;
    }

    public void setWantTime(Date wantTime) {
        this.wantTime = wantTime;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
    
}
