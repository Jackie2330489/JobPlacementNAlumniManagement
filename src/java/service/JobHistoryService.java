/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.JobHistoryDao;
import dao.impl.JobHistoryDaoImpl;
import dto.DataExecution;
import dto.MsgExecution;
import entity.JobHistory;
import java.util.List;

/**
 *
 * @author Justin
 */
public class JobHistoryService {
    
    private JobHistoryDao jhDao=new JobHistoryDaoImpl();
            
    public MsgExecution deleteJobHistory(long jhId){
        MsgExecution me=null;
        try{
            jhDao.deleteJobHistoryById(jhId);
        }catch(Exception e){
            e.printStackTrace();
            me=new MsgExecution(false,"System Exception Failed To Delete JobHistory");
        }
        if(me==null)me=new MsgExecution(true,"Delete JobHistory Successfully");
        return me;
    }
    
    public DataExecution<List<JobHistory>> showJobHistory(String studentId){
        DataExecution<List<JobHistory>> de=null;
        List<JobHistory> jhs=jhDao.getJobHistoriesByStudentId(studentId);
        if(jhs==null){
            de=new DataExecution(false,"No His/Her JobHistories On Database");
        }
        else{
            de=new DataExecution(true,jhs);
        }
        return de;
    }
}
