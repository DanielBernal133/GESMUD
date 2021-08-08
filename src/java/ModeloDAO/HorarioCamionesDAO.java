/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.HorarioCamionesVO;
import Util.Crud;
import Util.conexion;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class HorarioCamionesDAO extends conexion implements Crud{
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;
    
    private String id_Ho ="" , fecha_ho = "", hora_salida = "", hora_entrada = "", estado_ho="";
    
    public HorarioCamionesDAO (HorarioCamionesVO horaCamVO) {
        super();
        
        try {
            conexion = this.obtenerConexion();
            id_Ho = horaCamVO.getId_Ho();
            fecha_ho = horaCamVO.getFecha_ho();
            hora_salida = horaCamVO.getHora_salida();
            hora_entrada = horaCamVO.getHora_entrada();
            estado_ho = horaCamVO.getEstado_ho();
            
        } catch (Exception e) {
            Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            //INSERT INTO Horario_cam(id_Ho, fecha_ho, hora_salida, hora_entrada, estado_ho) VALUES  (2, 2021-08-16, '6:00', '11:00', 'Inactivo' ); 
            sql = "INSERT INTO Horario_cam VALUES (?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id_Ho);
            puente.setString(2, fecha_ho);
            puente.setString(3, hora_salida);
            puente.setString(4, hora_entrada);
            puente.setString(5, estado_ho);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
//        finally{
//            try {
//                this.cerrarConexion();
//            } catch (SQLException e) {
//                Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
//            }
//        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
             sql = "update vehiculo set DATID=?,CATID=?,VEHMODELO=?,VEHMARCA=?,VEHESTADO=?,VEHPRECIO=? where VEHPLACA=? ";
             puente = conexion.prepareStatement(sql);
             puente.setString(1, id_Ho);
             puente.setString(2, fecha_ho);
             puente.setString(3, hora_salida);
             puente.setString(4, hora_entrada);
             puente.setString(5, estado_ho);
             puente.executeUpdate();
             operacion = true;
        } catch (Exception e) {
            Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public HorarioCamionesVO Consultar (String ID){
        HorarioCamionesVO horapVO = null;
        
        try {
           conexion = this.obtenerConexion(); 
           sql ="select * from Horario_cam where id_Ho = ?";
           puente = conexion.prepareStatement(sql);
           puente.setString(1, ID);
           mensajero = puente.executeQuery();
           
           while(mensajero.next()){
               horapVO = new HorarioCamionesVO(mensajero.getString(1), 
                                               mensajero.getString(2), 
                                               mensajero.getString(3), 
                                               mensajero.getString(4),
                                               mensajero.getString(5));
           }
        } catch (SQLException e) {
            Logger.getLogger(HorarioCamionesDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return horapVO;
    }
    
    
    public ArrayList<HorarioCamionesVO>ListarHo() {
    
        ArrayList<HorarioCamionesVO>ListarHorarios = new ArrayList<>();
        
        try {
        conexion = this.obtenerConexion(); 
        sql ="select * from Horario_cam"; 
        puente = conexion.prepareStatement(sql);
        mensajero = puente.executeQuery();
        
        while(mensajero.next()){
            HorarioCamionesVO horapVO = new HorarioCamionesVO(mensajero.getString(1), 
                                                              mensajero.getString(2), 
                                                              mensajero.getString(3), 
                                                              mensajero.getString(4),
                                                              mensajero.getString(5));
            ListarHorarios.add(horapVO);
        }
        
        } catch (Exception e) {
        }
     return ListarHorarios;
        
}
    
}
