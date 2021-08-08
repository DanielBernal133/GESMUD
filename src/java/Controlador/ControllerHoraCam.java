/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.HorarioCamionesDAO;
import ModeloVO.HorarioCamionesVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "ControllerHoraCam", urlPatterns = {"/HorarioCam"})
public class ControllerHoraCam extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String id_Ho = request.getParameter("textid_Ho");
        String fecha_ho = request.getParameter("textfecha_ho");
        String hora_salida = request.getParameter("texthora_salida");
        String hora_entrada = request.getParameter("texthora_entrada");
        String estado_ho = request.getParameter("textestado_ho");
        
        HorarioCamionesVO horaCamVO = new HorarioCamionesVO(id_Ho, fecha_ho, hora_salida, hora_entrada, estado_ho);
        HorarioCamionesDAO horaCamDAO = new HorarioCamionesDAO(horaCamVO);
       
        switch (opcion){
            case 1: 
                if (horaCamDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El Horario se registro correctamente");
                    
                }else {
                     request.setAttribute("mensajeError", "El Horario no se registro correctamente");
                }
                request.getRequestDispatcher("registraHorariocam.jsp").forward(request, response);
                break;
                
            case 2: 
                horaCamVO = horaCamDAO.Consultar(id_Ho);
                if (horaCamVO != null) {
                    request.setAttribute("HorariConsultafo", horaCamVO);
                    request.getRequestDispatcher("actualizarHorarioCam.jsp").forward(request, response);
                }else {
                    request.setAttribute("mensajeError", "El horario NO existe");
                    request.getRequestDispatcher("ConsultarHorarioCam.jsp").forward(request, response);
                }       
               break;     
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
