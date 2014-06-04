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

import com.interim.model.Annonces;
import com.interim.model.Users;
import com.interim.util.HibernateUtil;

public class AnnoncesDao {
	
	Session session;

    public AnnoncesDao() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

    public void addAnnonce(Annonces annonce) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.save(annonce);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAnnonce(Annonces annonce) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.delete(annonce);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAnnonce(Annonces annonce) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(annonce);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void saveAnnonce(Annonces annonce) {
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.saveOrUpdate(annonce);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Annonces> getAllAnnonces() {
        List<Annonces> annonces = new ArrayList<Annonces>();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            annonces = session.createQuery("from Annonces").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return annonces;
    }

    public Annonces getAnnonceById(int annonceid) {
        Annonces annonce = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            annonce = (Annonces) session.get(Annonces.class, new Integer(annonceid));
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return annonce;
    }
    
    public List<Annonces> getAnnoncesByIdMetier(int id_metier) {
		List<Annonces> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            list = session.createSQLQuery("select * from annonces,metiers where annonces.id_metier = metiers.id_metier and annonces.id_metier = :id_metier")
            		.addEntity(Annonces.class)
            		.setParameter("id_metier", id_metier)
            		.list();
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public List<Annonces> getAnnoncebyCriteria(Map<String, String> m) {
		List<Annonces> list = null;
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            Criteria cr = session.createCriteria(Annonces.class);
            StringBuilder query = new StringBuilder("from Annonces ");
    		
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