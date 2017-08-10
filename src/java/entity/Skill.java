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
@JsonIgnoreProperties(value={"vacancies"})
public class Skill {
    @Id
    @GeneratedValue
    private long skillId;
    
    private String skillName;

    //双向
    @ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
    @JoinTable(
            name="skill_vacancy",
            joinColumns={@JoinColumn(name="skillId")},
            inverseJoinColumns={@JoinColumn(name="vacancyId")}
    )
    private List<Vacancy> vacancies=new ArrayList<Vacancy>();
    
    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public long getSkillId() {
        return skillId;
    }

    public void setSkillId(long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }
    
}
