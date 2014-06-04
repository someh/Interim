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

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import org.apache.commons.lang3.StringEscapeUtils;

public class UserACommeMetierTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserACommeMetier> userACommeMetiers;

    public UserACommeMetierTableModel(List<UserACommeMetier> userACommeMetiers) {
        this.userACommeMetiers = new ArrayList<UserACommeMetier>(userACommeMetiers);
    }

    public List<UserACommeMetier> getUserACommeMetiers() {
		return userACommeMetiers;
	}

	@Override
    public int getRowCount() {
        return userACommeMetiers.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "metier";
                break;
            case 1:
                name = "cv";
                break;
            case 2:
                name = "idMetier";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
            	type = String.class;
                break;
            case 2:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	UserACommeMetier userACommeMetier = userACommeMetiers.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = StringEscapeUtils.unescapeHtml4(userACommeMetier.getMetiers().getMetier());
                break;
            case 1:
                value = userACommeMetier.getCv();
                break;
            case 2:
                value = userACommeMetier.getId().getIdMetier();
                break;
        }
        return value;
    }   
    
    public void addRow(UserACommeMetier userACommeMetier) {
    	userACommeMetiers.add(userACommeMetier);
        fireTableRowsInserted(userACommeMetiers.size() - 1, userACommeMetiers.size() - 1);
    
    }   

    
    public void deleteRow(int rowToDelete){
    	userACommeMetiers.remove(rowToDelete);
        fireTableRowsDeleted(rowToDelete, rowToDelete);
     }
}        
	

