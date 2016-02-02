
package vista;

import control.conexion;
import java.sql.Connection;
import java.sql.SQLException;


public class interfaz {
    
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    
         conexion cx = new conexion(); 
         Connection obj = cx.obtener();
         cx.crearConexion();
         cx.cerrar();
           
    }
}
