/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.NotiStatusEnum;
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
import javax.persistence.ManyToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"fromWho","toWho"})
public class Notification {
    @Id
    @GeneratedValue
    private long notiId;
    
    //单向
    @ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="companyId")
    private Company fromWho;
    
    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="student_notification",
            joinColumns={@JoinColumn(name="notiId")},
            inverseJoinColumns={@JoinColumn(name="studentId")}
    )
    private List<Student> toWho=new ArrayList<Student>();
    
    private String content;
    
    private NotiStatusEnum notiStatus;

    public Notification() {
    }

    public Notification(Company fromWho, String content) {
        this.fromWho = fromWho;
        this.content = content;
        this.notiStatus = NotiStatusEnum.UNREADED;
    }

    public long getNotiId() {
        return notiId;
    }

    public void setNotiId(long notiId) {
        this.notiId = notiId;
    }

    public Company getFromWho() {
        return fromWho;
    }

    public void setFromWho(Company fromWho) {
        this.fromWho = fromWho;
    }

    public List<Student> getToWho() {
        return toWho;
    }

    public void setToWho(List<Student> toWho) {
        this.toWho = toWho;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotiStatusEnum getNotiStatus() {
        return notiStatus;
    }

    public void setNotiStatus(NotiStatusEnum notiStatus) {
        this.notiStatus = notiStatus;
    }
    
}
