/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_de_Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author thomis
 */
    

public class conexion {
   
    public Connection conexionUP = null;
    public Statement sentencia;
    public ResultSet resultado;
    

/** 
* Método utilizado para establecer la conexión con la base de datos
* @return estado regresa el estado de la conexión, true si se estableció la conexión,
* falso en caso contrario
*/
public boolean crearConexion()
{
        try {
            
      conexionUP = DriverManager.getConnection("jdbc:mysql://localhost/bdparqueo?useSSL=false&serverTimezone=UTC","root","");
                
             } catch (SQLException ex) {
            
                 JOptionPane.showMessageDialog(null,"Error al conectar con el servidor","Error critico",JOptionPane.ERROR_MESSAGE);
                   ex.printStackTrace();
                   return false;
           
                    }

        return true;
      }

/**
*
*Método utilizado para realizar la instrucción SELECT
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
public ResultSet ejecutarSQLSelect(String sql)
        
    {
      
      try {
          
         PreparedStatement pSentencia = conexionUP.prepareStatement(sql);
         resultado = pSentencia.executeQuery();
         
         
      } catch (SQLException ex) {
         ex.printStackTrace();
         return null;
      }

      return resultado;
      
      
   }//fin resulset select

/**
*
*Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
*param sql Cadena que contiene la instrucción SQL a ejecutar
*@return estado regresa el estado de la ejecución, true(éxito) o false(error)
*
*/
public ResultSet ejecutarSQL(String sql)
    {
        try {
            PreparedStatement pSentencia = conexionUP.prepareStatement(sql);
            
            pSentencia.executeUpdate();
 
        }
        catch (SQLException ex) {
            
                JOptionPane.showMessageDialog(null,"Error al registrar vehiculo" + ex);

            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }

        return resultado;
        
    }//din resultset update

    /**
* Método utilizado para recuperar el valor del atributo conexion
* @return conexion contiene el estado de la conexión
*
*/
    
public Connection getConexion()
    {
       return conexionUP;
       
    }

}//fin clase