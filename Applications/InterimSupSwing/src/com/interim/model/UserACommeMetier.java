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
// default package
// Generated 06-mai-2014 5:17:18 by Hibernate Tools 4.0.0

/**
 * UserACommeMetier generated by hbm2java
 */
public class UserACommeMetier implements java.io.Serializable/*, Comparable<UserACommeMetier>*/ {

	private UserACommeMetierId id;
	private Metiers metiers;
	private Users users;
	private String cv;

	@Override
	public String toString() {
		return "UserACommeMetier [id=" + id + ", metiers=" + metiers
				+ ", cv=" + cv + "]";
	}

	public UserACommeMetier() {
	}

	public UserACommeMetier(UserACommeMetierId id, Metiers metiers,
			Users users, String cv) {
		this.id = id;
		this.metiers = metiers;
		this.users = users;
		this.cv = cv;
	}

	public UserACommeMetierId getId() {
		return this.id;
	}

	public void setId(UserACommeMetierId id) {
		this.id = id;
	}

	public Metiers getMetiers() {
		return this.metiers;
	}

	public void setMetiers(Metiers metiers) {
		this.metiers = metiers;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

/*	@Override
	public int compareTo(UserACommeMetier o) {
		// TODO Auto-generated method stub
		return this.getMetiers().getMetier().compareTo(o.getMetiers().getMetier());
	}
*/
}