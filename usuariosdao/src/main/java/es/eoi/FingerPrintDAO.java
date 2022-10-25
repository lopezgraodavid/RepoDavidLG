package es.eoi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FingerPrintDAO {

	public static void createFingerPrint(FingerPrint huella) throws SQLException {

		Connection con = null;
		try {
		con = Utils.getConnection();
		
		String insert = "INSERT INTO persona.fingerprint(scandate,finger,image,iduser) "
					+ "VALUES (?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(insert);
		pst.setDate(1, new Date(huella.getScandate().getTime()));
		pst.setString(2, huella.getFinger());
		pst.setString(3, huella.getImage());
		pst.setInt(4, huella.getUser().getId());
		
		pst.executeUpdate();
		System.out.println("Añadiendo huella al usuario.");
		} catch(SQLIntegrityConstraintViolationException e) {
			System.out.println("este usuario ya tiene una huella");
		} finally {
			con.close();
		}
		
		
	}
	
	public static FingerPrint viewFingerPrintUser(int id) throws SQLException {
		
		Connection con = null;
		FingerPrint finger = null;
		User user = UserDAO.view(id);;
		
		try {
			
			con = Utils.getConnection();
			
			String insert = "select fingerprint.id,fingerprint.scandate,fingerprint.finger,fingerprint.image,user.username "
						  + "from fingerprint, user "
						  + "where fingerprint.iduser = user.id "
						  + "and user.id = ?";
			
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setInt(1, user.getId());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				finger = new FingerPrint();
				finger.setId(rs.getInt("id"));
				finger.setFinger(rs.getString("finger"));
				finger.setImage(rs.getString("image"));
				finger.setScandate(rs.getDate("scandate"));
				finger.setUser(user);
				
			}
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			con.close();
			
		}
		
		return finger;
		
		
	}

}
