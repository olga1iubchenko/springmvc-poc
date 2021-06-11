package com.poc.springproject.repository;

import com.poc.springproject.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Autowired
//    private SessionFactory sessionFactory;


//    @Override
//    public void setUserInfoById(UserEntity userEntity, Long id) {
//      //  Session session = getHibernateSession();
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaUpdate<UserEntity> criteriaUpdate = cb.createCriteriaUpdate(UserEntity.class);
//        Root<UserEntity> root = criteriaUpdate.from(UserEntity.class);
//        criteriaUpdate.set("name", userEntity.getName())
//                .set("middlename", userEntity.getMiddleName())
//                .set("lastname", userEntity.getLastname())
//                .set("age", userEntity.getAge())
//                .set("email", userEntity.getEmail());
//        criteriaUpdate.where(cb.equal(root.get("id"), id));
//        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
//        sessionFactory.getCurrentSession().createQuery(criteriaUpdate).executeUpdate();
//        transaction.commit();
//    }
}
