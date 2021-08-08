/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.Crud;
import Util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class UsuarioDAO extends conexion implements Crud{
    
    //1. Declarar variables u objetos.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String usuId = "", usuLogin = "", usuPassword = "";
    
    public UsuarioDAO (UsuarioVO usuVO){
        
        super();
        
        try {
             //3. conectarse a la base de datos 
            conexion = this.obtenerConexion();
            //4. traer al DAO los datos del VO para hacer la operación 
            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
        } catch (Exception e) {
            //Log es la secuencia completa de lo que esta pasando en el sistema.
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Override
    public boolean agregarRegistro() {
        
        try {
            sql = "insert into usuario(USULOGIN, USUPASSWORD) values (?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuLogin);
            puente.setString(2, usuPassword);
            puente.executeUpdate();
            operacion = true;

        }catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
    }finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }
    
    
    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
