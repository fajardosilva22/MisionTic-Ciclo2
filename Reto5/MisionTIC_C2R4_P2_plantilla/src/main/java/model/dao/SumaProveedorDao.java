package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.SumaProveedor;

public class SumaProveedorDao {

    public ArrayList<SumaProveedor> rankingSumaProveedor() throws SQLException {
        ArrayList<SumaProveedor> respuesta = new ArrayList<SumaProveedor>();
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT SUM(c.Cantidad) as 'Suma Cantidades' "
                            + "FROM Compra c "
                            + "WHERE Proveedor = 'Homecenter' ;" ;

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                SumaProveedor sumaProveedor = new SumaProveedor();
                sumaProveedor.setSuma(resultSet.getString("Suma Cantidades"));
                respuesta.add(sumaProveedor);
            }
            
            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando Proyecto Suma Proveedor!!" + e);
            
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        
            return respuesta;

    }

}