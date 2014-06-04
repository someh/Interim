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

package com.interim.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

public class ModelAnnonce extends DefaultTableModel {
	public ModelAnnonce(List<Annonces> annonces) {
        //JTable table = new JTable(this);
        addColumn("Annonce");
        addColumn("id");
      
        for(Annonces annonce : annonces){
        	String Annonce = "<html>"
            		+ "<body>"
            		+ "<br>"
            		+ "<b color='red'>" 
            		+ "Date de publication : "
            		+ "</b>"
            		+ annonce.getDate()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Secteur : "
            		+ "</b>"
            		+ annonce.getSecteur()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Fonction : "
            		+ "</b>"
            		+ annonce.getFonction()
            		+ "<br><br>"
            		+ "<b color='red'>" 
            		+ "Description : "
            		+ "</b>"
            		+ annonce.getDescription()
            		+ "<br><br><br><br>"
            		+ "<b color='blue'>" 
            		+ "Entreprise : "
            		+ "</b>"
            		+ annonce.getContacts().getEntreprise()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Contact : "
            		+ "</b>"
            		+ annonce.getContacts().getContact()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Adresse : "
            		+ "</b>"
            		+ annonce.getContacts().getAdresse()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Ville : "
            		+ "</b>"
            		+ annonce.getContacts().getCommune()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Email : "
            		+ "</b>"
            		+ annonce.getContacts().getEmail()
            		+ "<br><br>"
            		+ "<b color='blue'>" 
            		+ "Tel :"
            		+ "</b>"
            		+ annonce.getContacts().getTel()
            		+ "<br><br>"
            		+ "</body>"
            		+ "</html>";
        	 addRow(new Object[] { Annonce, annonce.getIdAnnonce() });
        } 
}

}
