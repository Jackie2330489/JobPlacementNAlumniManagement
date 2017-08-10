/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.SkillCategory;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface SkillCategoryDao {
    public void addSkillCategory(String scName);
    public void updateSkillCategory(SkillCategory sc);
    public SkillCategory getSkillCategoryById(int scId);
    public List<SkillCategory> getSkillCategorys();
}
