package com.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.simplilearn.model.LoginMaster;
import com.simplilearn.util.HibernateUtil;

public class LoginDao {
  public boolean validate(int userId, String password,String role) {
    Transaction transaction = null;
    LoginMaster user = null;

    try {
      Session session = HibernateUtil.getSessionFactory().openSession();
      transaction = session.beginTransaction();
      System.out.println("The checking userId is "+ userId);

      user =
          (LoginMaster)
              session
                  .createQuery("FROM LoginMaster loginMaster WHERE loginMaster.employeeId =:userId")
                  .setParameter("userId", userId)
                  .uniqueResult();

      if (user != null && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(role)) {
        return true;
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return false;
  }
}
