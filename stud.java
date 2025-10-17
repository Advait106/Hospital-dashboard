import java.sql.*;
public class stud {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Adu@2006");
			
			Statement stm = con.createStatement();
			System.out.println("Connection done");
			
			String tbl = "CREATE TABLE IF NOT EXISTS patient("+
			              "patient_id INT PRIMARY KEY,"+
					      "name VARCHAR(50),"+
			              "doctor_assinged VARCHAR(50) )";
			
			String ins = "INSERT INTO patient(patient_id,name,doctor_assinged) VALUES" + 
					"(101,'Ram','Dr. Smith'),"+
					"(102,'John','Dr. Green'),"+
					"(103,'Snehil','Dr. Mishra')";
			
			stm.executeUpdate(tbl);
			System.out.println("Table Created");
			
			stm.executeUpdate(ins);
			System.out.println("Rows inserted");
			
			ResultSet rs = stm.executeQuery("SELECT * FROM patient");
			
			while(rs.next()) {
				int id = rs.getInt("patient_id");
				String name = rs.getString("name");
				String doc = rs.getString("doctor_assinged");
				System.out.println(id + " | "+name+" | "+doc+" | ");
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
