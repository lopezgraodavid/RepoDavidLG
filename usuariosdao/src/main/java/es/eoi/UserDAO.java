package es.eoi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Data Access Object - CRUD
public class UserDAO {
//minimos de un DAO:
	//CRUD:
	//crear un usuario -Create
	//leer un usuario -Read
	//modificar un usuario -Update
	//borrar un usuario -Delete
	//DAO = CRUD pero puede tener meodos adicionales
	//Cualquier metodo adicional
	
	
//crear usuario
	public static void create(User user) throws SQLException {
		
		Connection con = null;
		
		try {
			
			con = Utils.getConnection();
			
			String insert = "INSERT INTO PERSONA.user (username,mail,password,lastaccess) "
						  + "VALUES (?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getMail());
			pst.setString(3, user.getPassword());
			pst.setDate(4, new Date(user.getLastAcess().getTime()));
			
			pst.executeUpdate();
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			con.close();
			
		}
		
		
		
	}
//Ver usuario	
	public static User view(int id) throws SQLException {
		
		Connection con = null;
		User user = null;
		
		try {
			
			con = Utils.getConnection();
			
			String insert = "SELECT * FROM PERSONA.user WHERE id=?";
			
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setMail(rs.getString("mail"));
				user.setPassword(rs.getString("password"));
				user.setLastAcess(rs.getDate("lastaccess"));
				
			}
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			con.close();
			
		}
		
		return user;
		
	}
//Borrar Usuario
	public static void delete(int id) throws SQLException {
		
		Connection con = null;
		
		try {
			
			con = Utils.getConnection();
			
			String delete = "DELETE FROM PERSONA.user "
						  + "WHERE user.id = ?";
			
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, id);

			pst.executeUpdate();
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			con.close();
			
		}
		
	}
//Modificar Usuario
	public static void update(User user) throws Exception {
		
		Connection con = null;
		if(user.getId()!=0) {
			try {
	
				con = Utils.getConnection();
	
				String update = "UPDATE PERSONA.user "
					   + "SET username = ?, "
					   + "mail = ?, "
					   + "password = ?, "
					   + "lastaccess = ? "
					   + "WHERE id=?";
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, user.getUsername());
				pst.setString(2, user.getMail());
				pst.setString(3, user.getPassword());
				pst.setDate(4, new Date(user.getLastAcess().getTime()));
				pst.setInt(5, user.getId());
				
				pst.executeUpdate();
				
				
			} catch (Exception e) {
				
				throw e;
				
			} finally {
				
				con.close();
				
			}
		} else {
			throw new Exception("Falta el id");
		}
		
	}

	

}
