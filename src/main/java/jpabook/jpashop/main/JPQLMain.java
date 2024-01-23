package jpabook.jpashop.main;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;

import javax.persistence.*;
import java.util.List;

public class JPQLMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("member1");
            member.setAge(10);
            em.persist(member);

            //TypedQuery<Member> query = em.createQuery("select m from Member as m", Member.class);
            List<Member> list = em.createQuery("select m from Member as m where m.name = :name", Member.class)
                    .setParameter("name", "member1")
                    .getResultList();

            System.out.println(list.get(0).toString());

            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
