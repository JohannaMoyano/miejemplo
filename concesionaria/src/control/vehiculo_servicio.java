
package control;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.vehiculo;


public class vehiculo_servicio {
    
private final String tabla = "vehiculo";
    
    public void guardar(Connection conexion, vehiculo ve) throws SQLException{
        try{
            PreparedStatement consulta;//prepara la consulta pero no ejecuta 
            if(ve.getId() != 0)
            {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(modelo,marca,kilometraje,id,color,placa,precio) VALUES(?, ?, ?, ?, ?, ?, ?)");
                consulta.setString(1, ve.getModelo());
                consulta.setString(2, ve.getMarca());
                consulta.setInt(3, ve.getKilometraje());
                consulta.setInt(4, ve.getId());
                consulta.setString(5, ve.getColor());
                consulta.setString(6, ve.getPlaca());
                consulta.setFloat(7, ve.getPrecio());
   
            }
            else{
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET modelo =?, marca =?, kilometraje =?, color =?, placa=?, precio = ?, WHERE id=?");
                consulta.setString(1, ve.getModelo());
                consulta.setString(2, ve.getMarca());
                consulta.setInt(3, ve.getKilometraje());
                consulta.setString(4, ve.getColor());
                consulta.setString(5, ve.getPlaca());
                consulta.setFloat(6, ve.getPrecio());
                
                consulta.setInt(7, ve.getId());
            }
                consulta.executeUpdate();
                
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }

     public vehiculo recuperarPorId(Connection conexion, int id_vehiculo) throws SQLException {
        vehiculo ve = null;
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT modelo,marca,kilometraje,id,color,placa,precio FROM " + this.tabla + " WHERE id= ?" );
            consulta.setInt(1, id_vehiculo);
            ResultSet resultado = consulta.executeQuery();//obtiene el conjunto de datos.
            while(resultado.next())
            {
                ve= new vehiculo(resultado.getString("modelo"), resultado.getString("marca"), resultado.getInt("kilometraje"),resultado.getInt("id"),resultado.getString("color"), resultado.getString("placa"), resultado.getFloat ("precio"));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return ve;
        
        
    }
   
public void eliminar(Connection conexion, vehiculo veh) throws SQLException{
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla+ " WHERE id= ?");
            consulta.setInt(1, veh.getId());
            consulta.executeUpdate();
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
    }
    


    public List<vehiculo> recuperarTodas(Connection conexion) throws SQLException{
        List<vehiculo> lvehiculos = new ArrayList<>();
        try{
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla+ " ORDER BY marca");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
            {
                lvehiculos.add(new vehiculo(resultado.getString("modelo"), resultado.getString("marca"), resultado.getInt("kilometraje"),resultado.getInt("id"),resultado.getString("color"), resultado.getString("placa"), resultado.getFloat("precio")));
            }
        }catch(SQLException ex){
            throw new SQLException(ex);
        }
        return lvehiculos;
    }

}
