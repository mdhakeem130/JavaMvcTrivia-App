package trythis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO 
{
	// this metod use to insert the data to database
	
 public String insert(String name, String q1answer, String q2answer) {
		Connection con = null;
		PreparedStatement pstm;
		String insertflage;
		try {
			MysqlConnection obj = new MysqlConnection();
			con = obj.getConnecion();

			pstm = con.prepareStatement("insert into tapp(name,q1answer,q2answer)values (?,?,?);");
			pstm.setString(1, name);
			pstm.setString(2, q1answer);
			pstm.setString(3, q2answer);

			int n = pstm.executeUpdate();

			System.out.println("nomber of records affected: " + n);
			if (n >= 1) {
				insertflage = "Success";
				System.out.println("record inserted successfully");
			} else {
				insertflage = "false";
				System.out.println("record failed in insertion");
			}

		} catch (SQLException e) {
			insertflage = "false";

			e.printStackTrace();
		} catch (Exception e) {
			insertflage = "false";

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				insertflage = "false";

				e.printStackTrace();
			} catch (Exception e) {
				insertflage = "false";

				e.printStackTrace();
			}
		}
		return insertflage;

	}

	// this method are use to get all data from database
	public ArrayList getAllDetails() 
	{
		Connection con = null;
		PreparedStatement pstm;
		String insertflage;
		ArrayList all_details = new ArrayList();

		try {
			MysqlConnection obj = new MysqlConnection();
			con = obj.getConnecion();
		     //pstm = con.prepareStatement("select * from tapp ");
			pstm = con.prepareStatement("select *from tapp ORDER BY idtapp DESC LIMIT 1");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				// creating object of model(bean)class and set by using set
				// method of bean class
				Bean objnew = new Bean();
				objnew.setName(rs.getString(2));
				objnew.setQ1answer(rs.getString(3));
				objnew.setQ2answer(rs.getString(4));

				all_details.add(objnew);
			}

		} catch (SQLException e) {
			insertflage = "false";

			e.printStackTrace();
		} catch (Exception e) {
			insertflage = "false";

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				insertflage = "false";

				e.printStackTrace();
			} catch (Exception e) {
				insertflage = "false";

				e.printStackTrace();
			}
		}
		return all_details;

	}
	
	
	
	public ArrayList getAllDetailss() 
	{
		Connection con = null;
		PreparedStatement pstm;
		String insertflage;
		ArrayList all_detailss = new ArrayList();

		try {
			MysqlConnection obj = new MysqlConnection();
			con = obj.getConnecion();
		     pstm = con.prepareStatement("select * from tapp ");
			//pstm = con.prepareStatement("select *from tapp ORDER BY idtapp DESC LIMIT 1");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				// creating object of model(bean)class and set by using set
				// method of bean class
				Bean objnew = new Bean();
				objnew.setName(rs.getString(2));
				objnew.setQ1answer(rs.getString(3));
				objnew.setQ2answer(rs.getString(4));

				all_detailss.add(objnew);
			}

		} catch (SQLException e) {
			insertflage = "false";

			e.printStackTrace();
		} catch (Exception e) {
			insertflage = "false";

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				insertflage = "false";

				e.printStackTrace();
			} catch (Exception e) {
				insertflage = "false";

				e.printStackTrace();
			}
		}
		return all_detailss;

	}
}
