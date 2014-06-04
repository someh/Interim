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

import com.interim.model.Logins;
import com.interim.util.HibernateUtil;

public class LoginsDao {
	
	Session session;

    public LoginsDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveLogin(Logins login) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(login);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Logins> getAllLogins() {
        List<Logins> logins = new ArrayList<Logins>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            logins = session.createQuery("from Logins").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return logins;
    }

    public Logins getLoginById(int loginid) {
        Logins login = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            login = (Logins) session.get(Logins.class, new Integer(loginid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return login;
    }
    
    
    public List<Logins> getLoginbyCriteria(Map<String, String> m) {
		List<Logins> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Logins.class);
            StringBuilder query = new StringBuilder("from Logins ");
    		
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