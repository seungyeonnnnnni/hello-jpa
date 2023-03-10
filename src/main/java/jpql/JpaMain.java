package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {


            Member member1 = new Member();
            member1.setUsername("관리자1");
            em.persist(member1);


            Member member2 = new Member();
            member2.setUsername("관리자2");
            em.persist(member2);


            em.flush();
            em.clear();

            // concat,substring,trim
//            String query = "select concat('a', 'b') From Member m ";
//            String query = "select substring(?????? ) From Member m ";
//            String query = "select locate('de', 'abcdef') From Member m "; -> return 4
          String query = "";
            List<String> result = em.createQuery(query, String.class)
                    .getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
