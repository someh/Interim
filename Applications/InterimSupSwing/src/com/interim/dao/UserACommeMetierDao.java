/*
Copyright (C) April 2014 Mehboub Sophian

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License along
with this program; if not, write to the Free Software Foundation, Inc.,
51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package com.interim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.interim.model.UserACommeMetier;
import com.interim.util.HibernateUtil;

public class UserACommeMetierDao {
	
	Session session;

    public UserACommeMetierDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	

    public void addUserACommeMetier(UserACommeMetier userACommeMetier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(userACommeMetier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUserACommeMetier(UserACommeMetier userACommeMetier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(userACommeMetier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUserACommeMetier(UserACommeMetier userACommeMetier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(userACommeMetier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveUserACommeMetier(UserACommeMetier userACommeMetier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(userACommeMetier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<UserACommeMetier> getAllUserACommeMetier() {
        List<UserACommeMetier> userACommeMetiers = new ArrayList<UserACommeMetier>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            userACommeMetiers = session.createQuery("from UserACommeMetier").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return userACommeMetiers;
    }

    public UserACommeMetier getUserACommeMetierById(int userACommeMetierid) {
        UserACommeMetier userACommeMetier = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            userACommeMetier = (UserACommeMetier) session.get(UserACommeMetier.class, new Integer(userACommeMetierid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return userACommeMetier;
    }
    
    
    public List<UserACommeMetier> getUserACommeMetierbyCriteria(Map<String, String> m) {
		List<UserACommeMetier> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(UserACommeMetier.class);
            StringBuilder query = new StringBuilder("from UserACommeMetier ");
    		
    		for (Map.Entry<String, String> entry : m.entrySet())
    		{
    			cr.add(Restrictions.eq(entry.getKey(), entry.getValue()));
    		}
    		list = cr.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
}