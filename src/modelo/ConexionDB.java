// Copiar jar en files/root y añadir en libreria un jar/folder

package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    private  String urlString = "jdbc:mysql://localhost:3306/MRP2?autoReconnect=true&useSSL=false";    
    private  String driverName = "com.mysql.jdbc.Driver";   
    private  String username = "root";   
    private  String password = "goyo";
    private  Connection con;
    
    public ConexionDB() {
		// TODO Auto-generated constructor stub
	}
 
	// -----------------------------------------------------------------
	// METODOS
	// -----------------------------------------------------------------

	// -----------------------------------------------------------------
	// Metodo setConneccion:
	// Procedimiento que establece conección con la base de datos.
	//
	// -----------------------------------------------------------------
    
    public  Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlString, username, password);
                
                System.out.println("Conexion Satisfactoria con la base de datos curso sql"); 
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."+ex); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
    

	// -----------------------------------------------------------------
	// Metodo setCerrarConeccion:
	// Procedimiento que cierra la conección con la base de datos.
	//
	// ----------------------------------------------------------------- 
	public void setCerrarConeccion() throws SQLException {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) { /* ignore close errors */
			}
		}
	}

        /*
    public static void main(String[] args){
    	ConexionDB cman = new ConexionDB();
    	Connection cnx = cman.getConnection();

    }
	*/
}