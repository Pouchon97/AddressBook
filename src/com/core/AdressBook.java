package com.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AdressBook {
	
	public void addPersonInfo() {
		String name = JOptionPane.showInputDialog("Entrez le nom");
		String adress = JOptionPane.showInputDialog("Entrez l'adresse");
		String phone = JOptionPane.showInputDialog("Entrez le téléphone");
		String gmail = JOptionPane.showInputDialog("Entrez l'email");
		Personinfo personinfo = new Personinfo(name,adress,phone,gmail);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/address_book";
			String user = "root";
			String passwd = "";
			Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
	
			Statement st = (Statement) conn.createStatement();
			String query ="INSERT INTO `bookinfo`(`name`, `address`, `phone`, `gmail`) VALUES('"+personinfo.getName()+"','"+personinfo.getAddress()+"','"+personinfo.getPhone()+"','"+personinfo.getGmail()+"')";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null,personinfo.getName()+": Est enregistrer avec succés");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Enregistrement existe déja");
			e.printStackTrace();
		}
	}
	
	public void listOfInfos() {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("DRIVER OK ! ");
				String url = "jdbc:mysql://localhost:3306/address_book";
				String user = "root";
				String passwd = "";
				Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
				Statement st = (Statement) conn.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM bookinfo");
			
				while(result.next()){
					JOptionPane.showMessageDialog(null," No: "+result.getInt("id")+"\n "+"Nom: "+result.getString("name")+"\n "+"Adresse: "+result.getString("address")+"\n"+"Telephone: "+result.getString("phone")+"\n"+"Gmail: "+result.getString("gmail"),null, JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				 JScrollPane scrollpane = new JScrollPane(); 
			       String categories[] = {result.getString("name")};
			       JList list = new JList(categories);

			       scrollpane = new JScrollPane(list);

			       JPanel panel = new JPanel(); 
			       panel.add(scrollpane);

			       scrollpane.getViewport().add(list);
			       JOptionPane.showMessageDialog(null, scrollpane, "Error List",JOptionPane.PLAIN_MESSAGE);
			       
				result.close();
				st.close();
				} catch (Exception e) {
			
				}
	}
	
	public void searchPersonInfo(String nameOfPersonForSearch) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("DRIVER OK ! ");
				String url = "jdbc:mysql://localhost:3306/address_book";
				String user = "root";
				String passwd = "";
				Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
				Statement st = (Statement) conn.createStatement();
				ResultSet result = st.executeQuery("SELECT * FROM bookinfo WHERE name='"+nameOfPersonForSearch+"'");
				ResultSetMetaData resultMeta = result.getMetaData();
				while(result.next()){
				 JOptionPane.showMessageDialog(null," Nom: "+result.getString("name")+"\n "+"Adresse: "+result.getString("address")+"\n "+"Telephone: "+result.getString("phone")+"\n "+"Gmail: "+result.getString("gmail"),null, JOptionPane.INFORMATION_MESSAGE);
				}
				result.close();
				st.close();
				} catch (Exception e) {
			
				}
	}
	
	public void deletePersonInfo(String nameOfPersonForDelete) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER OK ! ");
			String url = "jdbc:mysql://localhost:3306/address_book";
			String user = "root";
			String passwd = "";
			Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
			String name ="PAPA";
			Statement st = (Statement) conn.createStatement();
			String query = "DELETE FROM bookinfo WHERE name='"+nameOfPersonForDelete+"'";
			JOptionPane.showMessageDialog(null,nameOfPersonForDelete+"Suppression effectuer");
			st.executeUpdate(query);
			st.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, nameOfPersonForDelete+" Suppression échouer");
			}
	}
	
	
	public void update(int nameOfPersonForDelete) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER OK ! ");
			String url = "jdbc:mysql://localhost:3306/address_book";
			String user = "root";
			String passwd = "";
			Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
			String nom = JOptionPane.showInputDialog("Entrez le Nom:  ");
			String address = JOptionPane.showInputDialog("Entrez l'adresse :  ");
			String phone = JOptionPane.showInputDialog("Entrez le telephone:  ");
			String gmail = JOptionPane.showInputDialog("Entrez l'email:  ");
			Statement st = (Statement) conn.createStatement();
			String query = "UPDATE bookinfo SET name='"+nom+"',address='"+address+"',phone='"+phone+"',gmail='"+gmail+"' WHERE id='"+nameOfPersonForDelete+"'";
			JOptionPane.showMessageDialog(null,"No: "+nameOfPersonForDelete+" Modification effectuer");
			st.executeUpdate(query);
			st.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, nameOfPersonForDelete+" Modification échouer");
			}
	}
	
	public void sendMail(String subject,String bodyofmail,String AdressMail) {
		try {
			Mail.sendMail(bodyofmail,AdressMail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
