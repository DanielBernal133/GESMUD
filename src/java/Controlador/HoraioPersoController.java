/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.HorarioPersonalDAO;
import ModeloVO.HorarioPersonalVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "HoraioPersoController", urlPatterns = {"/HorarioPersonal"})
public class HoraioPersoController extends HttpServlet {

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
        String idH = request.getParameter("textIdH");
        String fecha_H = request.getParameter("textfechaH");
        String hora_H = request.getParameter("texthoraH");
        String estado_H = request.getParameter("textestadoH");
        String ho_sal = request.getParameter("textho_sal");
        
        HorarioPersonalVO horapVO = new HorarioPersonalVO(idH, fecha_H, hora_H, estado_H, ho_sal);
        HorarioPersonalDAO horapDAO = new HorarioPersonalDAO(horapVO);
        
        switch (opcion){
            case 1://Agregar horario
                if (horapDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El horario se registro correctamente");
                }else {
                     request.setAttribute("mensajeError", "El horario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarhorario.jsp").forward(request, response);
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
