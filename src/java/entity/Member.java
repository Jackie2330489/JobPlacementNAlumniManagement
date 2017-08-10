/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.MemberStatusEnum;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"student"})
public class Member {
    @Id
    @GeneratedValue(generator="memberId_generator")
    @GenericGenerator(name="memberId_generator",strategy="assigned")
    @Column(length=12)
    private String memberId;
    
    private String password;
    
    private MemberStatusEnum memberStatus;

    //单向
    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="studentId")
    private Student student;
    
    
    public Member() {
    }
    
    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
        this.memberStatus = MemberStatusEnum.MANAGER;
        this.student=null;
    }

    public Member(String memberId, String password, Student student) {
        this.memberId = memberId;
        this.password = password;
        this.memberStatus = MemberStatusEnum.INACTIVATED;
        this.student = student;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberStatusEnum getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatusEnum memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
