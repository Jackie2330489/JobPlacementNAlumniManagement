/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.JobHistory;
import entity.Student;
import entity.Vacancy;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Justin
 */
public interface JobHistoryDao {
    public void addJobHistory(Date wantTime,Date workTime,String studentId,long vacancyId);
    public void deleteJobHistoryById(long jhId);
    public List<JobHistory> getJobHistoriesByStudentId(String studentId);
}
