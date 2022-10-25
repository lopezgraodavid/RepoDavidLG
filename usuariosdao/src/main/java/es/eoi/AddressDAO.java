package es.eoi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class AddressDAO {

	public static void createAddress(Address direccion) throws SQLException {

			Connection con = null;
			try {
			con = Utils.getConnection();
			
			String insert = "INSERT INTO persona.address (name,address,number,apartment,zipcode) "
						  + "VALUES (?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, direccion.getName());
			pst.setString(2, direccion.getAddress());
			pst.setString(3, direccion.getNumber());
			pst.setString(4, direccion.getApartment());
			pst.setString(5, direccion.getZipcode());
			
			pst.executeUpdate();
			
			insert = "SELECT * FROM persona.address "
					+ "ORDER BY ADDRESS.id DESC "
					+ "LIMIT 0,1";
			
			pst =  con.prepareStatement(insert);
			
			ResultSet rs = pst.executeQuery();
			int idAddress;
			rs.next();
			idAddress = rs.getInt("id");
			
			insert = "INSERT INTO PERSONA.USER_ADDRESS(iduser,idaddress) "
				   + "VALUES (?,?)";

			for (int cont = 0; cont < direccion.getUsuarios().size(); cont++) {
				pst = con.prepareStatement(insert);
				pst.setInt(1, direccion.getUsuarios().get(cont).getId());
				pst.setInt(2, idAddress);
				
				pst.executeUpdate();
			}
			
			} catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("este usuario ya tiene una huella");
			} finally {
				con.close();
			}
	}
	
	public static Address viewAddress(int id) throws Exception {
		
		Connection con = null;
		Address address = null;
		
		try {
			
			con = Utils.getConnection();
			
			String insert = "SELECT * FROM PERSONA.address WHERE id=?";
			
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				address = new Address();
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setAddress(rs.getString("address"));
				address.setNumber(rs.getString("number"));
				address.setApartment(rs.getString("apartment"));
				address.setZipcode(rs.getString("zipcode"));

			}
			
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			
			con.close();
			
		}
		
		return address;
		
		
	}
	
}
