/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"company","skills","notifications","jobHistories","vacancies"})
public class Student {
    @Id
    @GeneratedValue(generator="studentId_generator")
    @GenericGenerator(name="studentId_generator",strategy="assigned")
    @Column(length=12)
    private String studentId;
    
    private String name;
    
    private String sex;
    
    private String region;
    
    private Integer grade;
    
    private String institute;
    
    private String specialize;
    
    private String phone;
    
    private String email;
    
    private String qqOrWechat;
    
    private String others;
    
    //双向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
    private Company company;
    
    //单向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="student_skill",
            joinColumns={@JoinColumn(name="studentId")},
            inverseJoinColumns={@JoinColumn(name="skillId")}
    )
    private List<Skill> skills=new ArrayList<Skill>();
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="student_notification",
            joinColumns={@JoinColumn(name="studentId")},
            inverseJoinColumns={@JoinColumn(name="notiId")}
    )
    private List<Notification> notifications=new ArrayList<Notification>();
    
    //双向
    @OneToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="studentId")
    private List<JobHistory> jobHistories=new ArrayList<JobHistory>();
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="students_vacancies",
            joinColumns={@JoinColumn(name="studentId")},
            inverseJoinColumns={@JoinColumn(name="vacancyId")}
    )
    private List<Vacancy> vacancies=new ArrayList<Vacancy>();
    
    public Student() {
    }

    public Student(String studentId, String name, String sex, String region, Integer grade, String institute, String specialize, String phone, String email, String qqOrWechat, String others) {
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.region = region;
        this.grade = grade;
        this.institute = institute;
        this.specialize = specialize;
        this.phone = phone;
        this.email = email;
        this.qqOrWechat = qqOrWechat;
        this.others = others;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqOrWechat() {
        return qqOrWechat;
    }

    public void setQqOrWechat(String qqOrWechat) {
        this.qqOrWechat = qqOrWechat;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
    
}
