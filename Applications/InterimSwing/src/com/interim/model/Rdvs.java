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

import java.util.Date;
// default package
// Generated 06-mai-2014 5:17:18 by Hibernate Tools 4.0.0

/**
 * Rdvs generated by hbm2java
 */
public class Rdvs implements java.io.Serializable {

	private RdvsId id;
	private Contacts contacts;
	private Users users;
	private Date date;
	private String description;
	private String dir;

	public Rdvs() {
	}

	public Rdvs(RdvsId id, Contacts contacts, Users users, Date date) {
		this.id = id;
		this.contacts = contacts;
		this.users = users;
		this.date = date;
	}

	public Rdvs(RdvsId id, Contacts contacts, Users users, Date date,
			String description, String dir) {
		this.id = id;
		this.contacts = contacts;
		this.users = users;
		this.date = date;
		this.description = description;
		this.dir = dir;
	}

	public RdvsId getId() {
		return this.id;
	}

	public void setId(RdvsId id) {
		this.id = id;
	}

	public Contacts getContacts() {
		return this.contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDir() {
		return this.dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

}
