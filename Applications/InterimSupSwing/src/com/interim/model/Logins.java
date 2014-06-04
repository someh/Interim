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

import java.util.HashSet;
import java.util.Set;

/**
 * Logins generated by hbm2java
 */
public class Logins implements java.io.Serializable {

	@Override
	public String toString() {
		return "Logins [idLogin=" + idLogin
				+ ", username=" + username + ", password=" + password
				+ ", token=" + token + "]";
	}

	private Integer idLogin;
	private String username;
	private String password;
	private String token;
	private Set userses = new HashSet(0);

	public Logins() {
	}

	public Logins(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Logins(String username, String password, String email,
			String token, Set userses) {
		this.username = username;
		this.password = password;
		this.token = token;
		this.userses = userses;
	}

	public Integer getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}