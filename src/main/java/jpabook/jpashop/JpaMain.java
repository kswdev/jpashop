package jpabook.jpashop;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            Item item = new Book();
            item.setName("book");

            entityManager.persist(item);


            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            entityManager.close();
        }

        emf.close();
    }
}
