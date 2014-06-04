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

public class ModelUsers extends DefaultTableModel {
	public ModelUsers(List<Users> users) {
        addColumn("Nom");
        addColumn("Prenom");
        addColumn("Rue");
        addColumn("Code");
        addColumn("Ville");
        addColumn("Email");
        addColumn("Tel");
        addColumn("Id");
      
        for(Users user : users){
        	 addRow(new Object[] { user.getNom(), user.getPrenom(),
        			 user.getAdresses().getRue(), user.getAdresses().getCode(),
        			 user.getAdresses().getVille(), user.getEmail(),
        			 user.getTel(), user.getIdUser() });
        } 
}

}
