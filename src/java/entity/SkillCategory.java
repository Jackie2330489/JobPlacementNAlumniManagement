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
import javax.persistence.OneToMany;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author Justin
 */
@Entity
@JsonIgnoreProperties(value={"scSons"})
public class SkillCategory {
    @Id
    @GeneratedValue
    private int scId;
    
    private String scName;
    
    //单向
    @JsonIgnore
    @OneToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinColumn(name="scId")
    private List<Skill> scSons=new ArrayList<Skill>();
    
    public SkillCategory() {
    }

    public SkillCategory(String scName) {
        this.scName = scName;
    }

    public int getScId() {
        return scId;
    }

    public void setScId(int scId) {
        this.scId = scId;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public List<Skill> getScSons() {
        return scSons;
    }

    public void setScSons(List<Skill> scSons) {
        this.scSons = scSons;
    }
    
}
