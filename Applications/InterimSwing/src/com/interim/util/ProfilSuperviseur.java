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

package com.interim.util;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;

import com.interim.gui.Main;
import com.interim.model.Users;

public class ProfilSuperviseur extends JPanel {
	
	private AutoBinding<Users, String, JTextField, String> bindTel;
	private AutoBinding<Users, String, JTextField, String> bindVille;
	private AutoBinding<Users, String, JTextField, String> bindCodePostal;
	private AutoBinding<Users, String, JTextField, String> bindRue;
	private AutoBinding<Users, String, JTextField, String> bindPrenom;
	private AutoBinding<Users, String, JTextField, String> bindNom;
	private AutoBinding<Users, String, JTextField, String> bindPassword;
	private AutoBinding<Users, String, JTextField, String> bindEmail;
	private AutoBinding<Users, String, JTextField, String> bindUsername;
	private JTextField fieldUsername;
	private JTextField fieldEmail;
	private JTextField fieldPassword;
	private JTextField fieldPasswordconfirm;
	private JTextField fieldNom;
	private JTextField fieldPrenom;
	private JTextField fieldRue;
	private JTextField fieldCodePostal;
	private JTextField fieldVille;
	private JTextField fieldTel;
	private JButton btnEnregistrer;

	public JButton getBtnEnregistrer() {
		return btnEnregistrer;
	}

	private Users user = Main.user;

	/**
	 * Create the panel.
	 */
	public ProfilSuperviseur() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelLOGIN = new JPanel();
		GridBagConstraints gbc_panelLOGIN = new GridBagConstraints();
		gbc_panelLOGIN.gridheight = 12;
		gbc_panelLOGIN.gridwidth = 18;
		gbc_panelLOGIN.insets = new Insets(0, 0, 5, 5);
		gbc_panelLOGIN.fill = GridBagConstraints.BOTH;
		gbc_panelLOGIN.gridx = 0;
		gbc_panelLOGIN.gridy = 0;
		add(panelLOGIN, gbc_panelLOGIN);
		GridBagLayout gbl_panelLOGIN = new GridBagLayout();
		gbl_panelLOGIN.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLOGIN.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLOGIN.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelLOGIN.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelLOGIN.setLayout(gbl_panelLOGIN);
		
		JLabel lblLOGIN = new JLabel("LOGIN");
		GridBagConstraints gbc_lblLOGIN = new GridBagConstraints();
		gbc_lblLOGIN.insets = new Insets(0, 0, 5, 5);
		gbc_lblLOGIN.gridx = 1;
		gbc_lblLOGIN.gridy = 2;
		panelLOGIN.add(lblLOGIN, gbc_lblLOGIN);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 3;
		panelLOGIN.add(lblUsername, gbc_lblUsername);
		
		fieldUsername = new JTextField();
		GridBagConstraints gbc_fieldUsername = new GridBagConstraints();
		gbc_fieldUsername.gridwidth = 8;
		gbc_fieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_fieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldUsername.gridx = 5;
		gbc_fieldUsername.gridy = 3;
		panelLOGIN.add(fieldUsername, gbc_fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 3;
		gbc_lblEmail.gridy = 5;
		panelLOGIN.add(lblEmail, gbc_lblEmail);
		
		fieldEmail = new JTextField();
		GridBagConstraints gbc_fieldEmail = new GridBagConstraints();
		gbc_fieldEmail.gridwidth = 8;
		gbc_fieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEmail.gridx = 5;
		gbc_fieldEmail.gridy = 5;
		panelLOGIN.add(fieldEmail, gbc_fieldEmail);
		fieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 7;
		panelLOGIN.add(lblPassword, gbc_lblPassword);
		
		fieldPassword = new JTextField();
		GridBagConstraints gbc_fieldPassword = new GridBagConstraints();
		gbc_fieldPassword.gridwidth = 8;
		gbc_fieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPassword.gridx = 5;
		gbc_fieldPassword.gridy = 7;
		panelLOGIN.add(fieldPassword, gbc_fieldPassword);
		fieldPassword.setColumns(10);
		
		JLabel lblPasswordconfirm = new JLabel("Password (confirm)");
		GridBagConstraints gbc_lblPasswordconfirm = new GridBagConstraints();
		gbc_lblPasswordconfirm.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswordconfirm.gridx = 3;
		gbc_lblPasswordconfirm.gridy = 9;
		panelLOGIN.add(lblPasswordconfirm, gbc_lblPasswordconfirm);
		
		fieldPasswordconfirm = new JTextField();
		GridBagConstraints gbc_fieldPasswordconfirm = new GridBagConstraints();
		gbc_fieldPasswordconfirm.gridwidth = 8;
		gbc_fieldPasswordconfirm.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPasswordconfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPasswordconfirm.gridx = 5;
		gbc_fieldPasswordconfirm.gridy = 9;
		panelLOGIN.add(fieldPasswordconfirm, gbc_fieldPasswordconfirm);
		fieldPasswordconfirm.setColumns(10);
		
		JPanel panelCURRICULUM = new JPanel();
		GridBagConstraints gbc_panelCURRICULUM = new GridBagConstraints();
		gbc_panelCURRICULUM.gridheight = 20;
		gbc_panelCURRICULUM.gridwidth = 18;
		gbc_panelCURRICULUM.fill = GridBagConstraints.BOTH;
		gbc_panelCURRICULUM.gridx = 18;
		gbc_panelCURRICULUM.gridy = 0;
		add(panelCURRICULUM, gbc_panelCURRICULUM);
		GridBagLayout gbl_panelCURRICULUM = new GridBagLayout();
		gbl_panelCURRICULUM.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCURRICULUM.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCURRICULUM.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCURRICULUM.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelCURRICULUM.setLayout(gbl_panelCURRICULUM);
		
		JLabel lblCURRICULUM = new JLabel("CURRICULUM");
		GridBagConstraints gbc_lblCURRICULUM = new GridBagConstraints();
		gbc_lblCURRICULUM.insets = new Insets(0, 0, 5, 5);
		gbc_lblCURRICULUM.gridx = 1;
		gbc_lblCURRICULUM.gridy = 2;
		panelCURRICULUM.add(lblCURRICULUM, gbc_lblCURRICULUM);
		
		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 3;
		gbc_lblNom.gridy = 3;
		panelCURRICULUM.add(lblNom, gbc_lblNom);
		
		fieldNom = new JTextField();
		GridBagConstraints gbc_fieldNom = new GridBagConstraints();
		gbc_fieldNom.gridwidth = 10;
		gbc_fieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldNom.gridx = 5;
		gbc_fieldNom.gridy = 3;
		panelCURRICULUM.add(fieldNom, gbc_fieldNom);
		fieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 3;
		gbc_lblPrenom.gridy = 5;
		panelCURRICULUM.add(lblPrenom, gbc_lblPrenom);
		
		fieldPrenom = new JTextField();
		GridBagConstraints gbc_fieldPrenom = new GridBagConstraints();
		gbc_fieldPrenom.gridwidth = 10;
		gbc_fieldPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPrenom.gridx = 5;
		gbc_fieldPrenom.gridy = 5;
		panelCURRICULUM.add(fieldPrenom, gbc_fieldPrenom);
		fieldPrenom.setColumns(10);
		
		JLabel lblRue = new JLabel("Rue et n\u00B0");
		GridBagConstraints gbc_lblRue = new GridBagConstraints();
		gbc_lblRue.insets = new Insets(0, 0, 5, 5);
		gbc_lblRue.gridx = 3;
		gbc_lblRue.gridy = 7;
		panelCURRICULUM.add(lblRue, gbc_lblRue);
		
		fieldRue = new JTextField();
		GridBagConstraints gbc_fieldRue = new GridBagConstraints();
		gbc_fieldRue.gridwidth = 10;
		gbc_fieldRue.insets = new Insets(0, 0, 5, 5);
		gbc_fieldRue.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldRue.gridx = 5;
		gbc_fieldRue.gridy = 7;
		panelCURRICULUM.add(fieldRue, gbc_fieldRue);
		fieldRue.setColumns(10);
		
		JLabel lblCodePostal = new JLabel("Code postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 3;
		gbc_lblCodePostal.gridy = 9;
		panelCURRICULUM.add(lblCodePostal, gbc_lblCodePostal);
		
		fieldCodePostal = new JTextField();
		GridBagConstraints gbc_fieldCodePostal = new GridBagConstraints();
		gbc_fieldCodePostal.gridwidth = 10;
		gbc_fieldCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_fieldCodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldCodePostal.gridx = 5;
		gbc_fieldCodePostal.gridy = 9;
		panelCURRICULUM.add(fieldCodePostal, gbc_fieldCodePostal);
		fieldCodePostal.setColumns(10);
		
		JLabel lblVille = new JLabel("Ville/Commune");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 3;
		gbc_lblVille.gridy = 11;
		panelCURRICULUM.add(lblVille, gbc_lblVille);
		
		fieldVille = new JTextField();
		GridBagConstraints gbc_fieldVille = new GridBagConstraints();
		gbc_fieldVille.gridwidth = 10;
		gbc_fieldVille.insets = new Insets(0, 0, 5, 5);
		gbc_fieldVille.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldVille.gridx = 5;
		gbc_fieldVille.gridy = 11;
		panelCURRICULUM.add(fieldVille, gbc_fieldVille);
		fieldVille.setColumns(10);
		
		JLabel lblTel = new JLabel("T\u00E9l");
		GridBagConstraints gbc_lblTel = new GridBagConstraints();
		gbc_lblTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTel.gridx = 3;
		gbc_lblTel.gridy = 13;
		panelCURRICULUM.add(lblTel, gbc_lblTel);
		
		fieldTel = new JTextField();
		GridBagConstraints gbc_fieldTel = new GridBagConstraints();
		gbc_fieldTel.gridwidth = 10;
		gbc_fieldTel.insets = new Insets(0, 0, 5, 5);
		gbc_fieldTel.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldTel.gridx = 5;
		gbc_fieldTel.gridy = 13;
		panelCURRICULUM.add(fieldTel, gbc_fieldTel);
		fieldTel.setColumns(10);
		
		btnEnregistrer = new JButton("Enregistrer");
		GridBagConstraints gbc_btnEnregistrer = new GridBagConstraints();
		gbc_btnEnregistrer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnregistrer.gridx = 1;
		gbc_btnEnregistrer.gridy = 20;
		panelCURRICULUM.add(btnEnregistrer, gbc_btnEnregistrer);
		
		initDataBindings();

	}
	
	public static void main(String[] args) {
		/*JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ProfilSuperviseur app = new ProfilSuperviseur();
        frame.getContentPane().add(app);

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setLocation(200, 200);
        frame.setVisible(true);*/
	}

	protected void initDataBindings() {
		BeanProperty<Users, String> usersBeanProperty = BeanProperty.create("logins.username");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		bindUsername = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty, fieldUsername, jTextFieldBeanProperty);
		bindUsername.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_1 = BeanProperty.create("logins.password");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		bindPassword = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_1, fieldPassword, jTextFieldBeanProperty_1);
		bindPassword.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_2 = BeanProperty.create("logins.email");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		bindEmail = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_2, fieldEmail, jTextFieldBeanProperty_2);
		bindEmail.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_3 = BeanProperty.create("nom");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		bindNom = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_3, fieldNom, jTextFieldBeanProperty_3);
		bindNom.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_4 = BeanProperty.create("prenom");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		bindPrenom = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_4, fieldPrenom, jTextFieldBeanProperty_4);
		bindPrenom.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_5 = BeanProperty.create("adresses.rue");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		bindRue = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_5, fieldRue, jTextFieldBeanProperty_5);
		bindRue.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_6 = BeanProperty.create("adresses.code");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty.create("text");
		bindCodePostal = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_6, fieldCodePostal, jTextFieldBeanProperty_6);
		bindCodePostal.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_7 = BeanProperty.create("adresses.ville");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_7 = BeanProperty.create("text");
		bindVille = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_7, fieldVille, jTextFieldBeanProperty_7);
		bindVille.bind();
		//
		BeanProperty<Users, String> usersBeanProperty_8 = BeanProperty.create("tel");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_8 = BeanProperty.create("text");
		bindTel = Bindings.createAutoBinding(UpdateStrategy.READ, user, usersBeanProperty_8, fieldTel, jTextFieldBeanProperty_8);
		bindTel.bind();
	}
	
}
