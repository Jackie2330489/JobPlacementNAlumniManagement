/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Skill;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface SkillDao {
    public void addSkill(String skillName);
    public void deleteSkillById(long skillId);
    public void updateSkillId(Skill skill);
    public Skill getSkillById(long skillId);
    public List<Skill> getSkillsByscId(int scId);
    public List<Skill> getAllSkills();
}
