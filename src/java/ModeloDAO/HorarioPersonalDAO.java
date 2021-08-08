/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.HorarioPersonalVO;
import Util.conexion;
import Util.Crud;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class HorarioPersonalDAO extends conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;

    private boolean operacion = false;
    private String sql;

    private String idH = "", fecha_H = "", hora_H = "", estado_H = "", ho_sal="";

    public HorarioPersonalDAO() {
    }

    public HorarioPersonalDAO(HorarioPersonalVO horapVO) {

        super();

        try {
            conexion = this.obtenerConexion();
            idH = horapVO.getIdH();
            fecha_H = horapVO.getFecha_H();
            hora_H = horapVO.getHora_H();
            estado_H = horapVO.getEstado_H();
            ho_sal = horapVO.getHo_sal();

        } catch (Exception e) {
            Logger.getLogger(HorarioPersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            //INSERT INTO Horario_cam(id_Ho, fecha_ho, hora_salida, hora_entrada, estado_ho) VALUES  (2, 2021-08-16, '6:00', '11:00', 'Inactivo' ); 
            sql = "INSERT INTO horario VALUES (?, ?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, idH);
            puente.setString(2, fecha_H);
            puente.setString(3, hora_H);
            puente.setString(4, estado_H);
            puente.setString(5, ho_sal);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(HorarioPersonalDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(HorarioPersonalDAO.class.getName()).log(Level.SEVERE, null, e);
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
