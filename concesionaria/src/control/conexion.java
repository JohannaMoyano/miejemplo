
package control;
import java.sql.*;


public class conexion {
    
    
    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionaria?zeroDateTimeBehavior=convertToNull","root","");
               
            System.out.println("Conexion Exitosa");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    public boolean crearConexion() throws ClassNotFoundException
    {
        try{
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionaria?zeroDateTimeBehavior=convertToNull","root","");
                System.out.println("Conexion Exitosa");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false; 
        }
        
        return true; 
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
    
    
    
}
