package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Conexion() {}
	private static Connection connection=null ;
	
	public static Connection giveConnection() {
	try {
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowershop","root","");
	}
	catch(SQLException e) {System.out.println("not Working");}
	return connection;
	

	}
}


/*
el driver al build path. Tenes que ir al proyecto,click boton derecho,build path,java build path,class path,add external jars,y ahi añadis el driver. 
 */
