/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Daniel
 */
public class HorarioCamionesVO {
    
    public String id_Ho, fecha_ho, hora_salida, hora_entrada, estado_ho;
    
    
    public HorarioCamionesVO(String id_Ho, String fecha_ho, String hora_salida, String hora_entrada, String estado_ho) {
        this.id_Ho = id_Ho;
        this.fecha_ho = fecha_ho;
        this.hora_salida = hora_salida;
        this.hora_entrada = hora_entrada;
        this.estado_ho = estado_ho;
    }
    
    
    public HorarioCamionesVO() {
    }

    public String getId_Ho() {
        return id_Ho;
    }

    public void setId_Ho(String id_Ho) {
        this.id_Ho = id_Ho;
    }

    public String getFecha_ho() {
        return fecha_ho;
    }

    public void setFecha_ho(String fecha_ho) {
        this.fecha_ho = fecha_ho;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getEstado_ho() {
        return estado_ho;
    }

    public void setEstado_ho(String estado_ho) {
        this.estado_ho = estado_ho;
    }

    
    
    
    
}
