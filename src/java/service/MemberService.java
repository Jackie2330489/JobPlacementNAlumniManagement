/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MemberDao;
import dao.StudentDao;
import dao.impl.MemberDaoImpl;
import dao.impl.StudentDaoImpl;
import dto.MsgExecution;
import dto.SuperDataExecution;
import entity.JobHistory;
import entity.Member;
import entity.Student;
import enums.MemberStatusEnum;
import java.util.List;
import org.springframework.util.DigestUtils;

/**
 *
 * @author Justin
 */
public class MemberService {
    private MemberDao memberDao=new MemberDaoImpl();
    private StudentDao studentDao=new StudentDaoImpl();
    private final String slat="laskjdoqwjdoqiwpijasdjlanlnll93";
    private String getMD5(String password){
        String base=password+"/"+slat;
        String md5=DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    public SuperDataExecution details(String uid,String md5){
        SuperDataExecution sde=null;
        Member member=memberDao.getMemberById(uid);
        if(!md5.equals(getMD5(member.getPassword()))){
            sde=new SuperDataExecution(false,"Cookies Wrong/Please Login Again");
        }else{
            Student student=member.getStudent();
            sde=new SuperDataExecution(true,member);
            sde.setData2(student);
            sde.setData3(student.getCompany());
            List<JobHistory> jhs=student.getJobHistories();
            if(jhs.size()>0){
                sde.setData4(jhs.get(jhs.size()-1).getVacancy().getJob());
            }
            sde.setList1(student.getSkills());
        }
        return sde;
    }
    public MsgExecution login(Member member){
        MsgExecution me=null;
        Member actual=memberDao.getMemberById(member.getMemberId());
        if(actual==null){
            me=new MsgExecution(false,"Do Not Exist UserID:"+member.getMemberId());
        }else if(!actual.getPassword().equals(member.getPassword())){
            me=new MsgExecution(false,"UserID Or Password Is Wrong");
        }else if(actual.getMemberStatus()==MemberStatusEnum.INACTIVATED){
            me=new MsgExecution(false,"This User Is UnActivated");
        }else{
            me=new MsgExecution(true,getMD5(actual.getPassword()));
        }
        return me;
    }
    
    public MsgExecution rememberLogin(String uid,String md5){
        MsgExecution me=null;
        Member member=memberDao.getMemberById(uid);
        if(!getMD5(member.getPassword()).equals(md5)){
            me=new MsgExecution(false,"Cookies Wrong/Please Login Again");
        }else{
            String msg=null;
            if(member.getStudent()!=null)msg=member.getStudent().getName()+"("+member.getStudent().getStudentId()+")";
            else msg="(Manager)"+uid;
            me=new MsgExecution(true,msg);
        }
        return me;
    }
    
    public MsgExecution register(Member member,Student student){
        MsgExecution me=null;
        Member m=memberDao.getMemberById(member.getMemberId());
        Student s=studentDao.getStudentById(student.getStudentId());
        if(m!=null)me=new MsgExecution(false,"This User Already Exists");
        else if(s!=null)me=new MsgExecution(false,"This Student Already Exists");
        else{
            try{
                studentDao.saveStudent(student);
                memberDao.saveMember(member);
            }catch(Exception e){
                e.printStackTrace();
            }
            member.setStudent(student);
            memberDao.updateMember(member);
            me=new MsgExecution(true,getMD5(member.getPassword()));
        }
        return me;
    }
    
    public SuperDataExecution getAll(){
        SuperDataExecution sde=null;
        List<Member> members=memberDao.getAllMembers();
        sde=new SuperDataExecution(true,members);
        return sde;
    }
    
    public MsgExecution activate(String memberId){
        MsgExecution me=null;
        Member member=memberDao.getMemberById(memberId);
        if(member.getMemberStatus()==MemberStatusEnum.MANAGER){
            me=new MsgExecution(false,"No Activation For Manager");
        }else{
            member.setMemberStatus(MemberStatusEnum.ACTIVATED);
            memberDao.updateMember(member);
            me=new MsgExecution(true,"Activate Successly");
        }
        return me;
    }
    
    public MsgExecution addMember(Member member){
        MsgExecution me=null;
        try{
            memberDao.saveMember(member);
            me=new MsgExecution(true,"Add Successly");
        }catch(Exception ex){
            ex.printStackTrace();
            me=new MsgExecution(false,"Failed To Add");
        }
        return me;
    }
}
