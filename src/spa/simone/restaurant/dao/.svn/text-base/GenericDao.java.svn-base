/*
 * This file is part of Restaurant project.
 * 
 * Restaurant is a java project for the second assignment of Enterprise Application. 
 * Copyright (C) 2011 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spa.simone.restaurant.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import spa.simone.restaurant.HibernateUtil;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
public abstract class GenericDao<T extends Serializable> {

   private Class<T> classType;

   public GenericDao() {
   }

   public GenericDao(Class<T> classType) {
      this.classType = classType;
   }

   public T findById(Long id) {
      Session session = openSession();
      Transaction tx = session.beginTransaction();
      T result = (T) session.get(classType, id);
      tx.commit();
      session.close();
      return result;
   }

   public List<T> findAll() {
      Session session = openSession();
      Transaction tx = session.beginTransaction();
      List<T> result = session.createCriteria(classType).list();
      tx.commit();
      session.close();
      return result;
   }

   public Long insert(T dto) {
      Session session = openSession();
      Transaction transaction = session.beginTransaction();
      Long id = (Long) session.save(dto);
      transaction.commit();
      session.close();
      return id;
   }

   public void update(T dto) {
      Session session = openSession();
      Transaction transaction = session.beginTransaction();
      session.saveOrUpdate(dto);
      transaction.commit();
      session.close();
   }

   public void delete(T dto) {
      Session session = openSession();
      Transaction transaction = session.beginTransaction();
      session.delete(dto);
      transaction.commit();
      session.close();
   }

   protected static Session openSession() {
      return HibernateUtil.getSessionFactory().openSession();
   }

}