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
public class HorarioPersonalVO {

    //Variables
    private String idH, fecha_H, hora_H, estado_H, ho_sal;

    public HorarioPersonalVO(String idH, String fecha_H, String hora_H, String estado_H, String ho_sal) {
        this.idH = idH;
        this.fecha_H = fecha_H;
        this.hora_H = hora_H;
        this.estado_H = estado_H;
        this.ho_sal = ho_sal;
    }

    public HorarioPersonalVO() {
    }

    public String getIdH() {
        return idH;
    }

    public void setIdH(String idH) {
        this.idH = idH;
    }

    public String getFecha_H() {
        return fecha_H;
    }

    public void setFecha_H(String fecha_H) {
        this.fecha_H = fecha_H;
    }

    public String getHora_H() {
        return hora_H;
    }

    public void setHora_H(String hora_H) {
        this.hora_H = hora_H;
    }

    public String getEstado_H() {
        return estado_H;
    }

    public void setEstado_H(String estado_H) {
        this.estado_H = estado_H;
    }

    public String getHo_sal() {
        return ho_sal;
    }

    public void setHo_sal(String ho_sal) {
        this.ho_sal = ho_sal;
    }

    
}
