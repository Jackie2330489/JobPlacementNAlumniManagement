
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justin
 */
public class Test {
    private int id;
    private String name;

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public static void main(String[] args) throws JsonProcessingException{
        
    }
    public void reBuild(){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        tx.commit();
    }
}
