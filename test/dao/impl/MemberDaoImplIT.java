/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.MemberDao;
import entity.Member;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 *
 * @author Justin
 */
public class MemberDaoImplIT {
    
    private MemberDao memberDao=new MemberDaoImpl();

    @Test
    public void testAddStudentMember() {
        memberDao.addStudentMember("jiumam456", "hst0316",null);
    }

    @Test
    public void testAddManagerMember() {
        memberDao.addManagerMember("qdhst123", "root");
        memberDao.addManagerMember("qdhst245", "root");
        memberDao.addManagerMember("qdhst256216", "root");
    }

    @Test
    public void testDeleteMemberById() {
        memberDao.deleteMemberById("qdhst2015");
        memberDao.deleteMemberById("qdhst2016");
    }

    @Test
    public void testGetMemberById(){
        Member member=memberDao.getMemberById("a704855911");
//        if(member.getStudent())
//        System.out.println(member.getMemberId()+member.getPassword());
    }
    
    @Test
    public void testUpdateMember() {
        Member member=memberDao.getMemberById("jiumam123");
        member.setPassword("hhhhhfffffhh");
        memberDao.updateMember(member);
    }

    @Test
    public void testGetAllMembers() {
        List<Member> members=memberDao.getAllMembers();
        for(Member member:members){
            System.out.println(member.getMemberId());
        }
    }
    
}
