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

import com.interim.model.Metiers;
import com.interim.util.HibernateUtil;

public class MetiersDao {
	
	Session session;

    public MetiersDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addMetier(Metiers metier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(metier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteMetier(Metiers metier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(metier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateMetier(Metiers metier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(metier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveMetier(Metiers metier) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(metier);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Metiers> getAllMetiers() {
        List<Metiers> metiers = new ArrayList<Metiers>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            metiers = session.createQuery("from Metiers").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return metiers;
    }

    public Metiers getMetierById(int metierid) {
        Metiers metier = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            metier = (Metiers) session.get(Metiers.class, new Integer(metierid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return metier;
    }
    
    
    public List<Metiers> getMetierbyCriteria(Map<String, String> m) {
		List<Metiers> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Metiers.class);
            StringBuilder query = new StringBuilder("from Metiers ");
    		
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
    public ArrayList<String> getAllStringMetiers() {
    	ArrayList<String> metiers = new ArrayList<String>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            metiers = (ArrayList<String>) session.createQuery("select metiers.metier from Metiers metiers").list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return metiers;
    }
    
    
}