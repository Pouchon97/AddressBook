package com.core;

import javax.swing.JOptionPane;

public class Mainbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdressBook ab = new AdressBook();
		String input;
		String search;
		String titleOfMail;
		String BobyOfMail;
		String AdressMail;
		int pointer;
		int s;
		boolean start = true;
		
		while(start) {
			input = JOptionPane.showInputDialog
					(null," Entrez 1 pour ajouter"+
					"\n Entrez 2 pour rechercher"+
					"\n Entrez 3 pour supprimer"+
					"\n Entrez 4 pour modifier"+
					"\n Entrez 5 pour voir la liste des contacts"+
					"\n Entrez 6 pour Envoyer un message par mail avec une personne dans votre contact"+
					"\n Entrez 7 pour quitter","Liste des options",JOptionPane.INFORMATION_MESSAGE);
			pointer = Integer.parseInt(input);
			switch(pointer) {
			case 1:
				ab.addPersonInfo();
			break;
			case 2:
				search = JOptionPane.showInputDialog(null,"Entrez le nom de la personne a rechercher","Nom",JOptionPane.INFORMATION_MESSAGE);
				ab.searchPersonInfo(search);
			break;
			case 3:
				search = JOptionPane.showInputDialog(null,"Entrez le nom de la personne a supprimer","Nom",JOptionPane.INFORMATION_MESSAGE);
				ab.deletePersonInfo(search);
			break;
			case 4:
				search = JOptionPane.showInputDialog(null,"Entrez le No:  ","Id de la personne",JOptionPane.INFORMATION_MESSAGE);
				s = Integer.parseInt(search);
				ab.update(s);
			break;
			case 5:
				ab.listOfInfos();
			break;
			case 6:
				AdressMail = JOptionPane.showInputDialog(null,"Entrez l'adresse mail de la personne pour envoyer le message ?","email",JOptionPane.INFORMATION_MESSAGE);
				titleOfMail = JOptionPane.showInputDialog(null,"Entrez le message","contenue",JOptionPane.INFORMATION_MESSAGE);
				ab.sendMail(titleOfMail,titleOfMail,AdressMail);
			break;
			case 7:
				System.exit(0);
			
			}
		}
		
	} 

}
