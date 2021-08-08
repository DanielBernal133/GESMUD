<%-- 
    Document   : ConsultarHorarioCam
    Created on : 6/08/2021, 05:08:05 PM
    Author     : Daniel
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.HorarioCamionesDAO"%>
<%@page import="ModeloVO.HorarioCamionesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="HorarioCam">
            <h1>Horarios Camiones</h1>
            <br>
            <table >
                <tr>
                    <th>
                        Horario 
                        <input type="text" name="textid_Ho">
                        <button>Consultar Horario</button>
                        <input type="hidden" value="2" name="opcion">
                    </th>
                </tr>
            </table><br><br><br>           
        </form><br><br>
        <div style="color: red;">
            <%                if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}
            <%} else {%>
            <div style="color: darkgreen;">${mensajeExito}   </div>  
        </div>
        <form>
            <table style="border: solid 2px">
                <thead>
                    <tr>
                        <th>Fecha del Horario Registrada</th>
                        <th>Hora Entrada</th>
                        <th>Hora Salida</th>
                        <th>Estado Horario</th>
                    </tr>
                </thead>
                <%
                    HorarioCamionesVO horaCamVO = new HorarioCamionesVO();
                    HorarioCamionesDAO horapDAO = new HorarioCamionesDAO(horaCamVO);
                    ArrayList<HorarioCamionesVO> ListarHorarios = horapDAO.ListarHo();
                    for (int i = 0; i < ListarHorarios.size(); i++) {

                        horaCamVO = ListarHorarios.get(i);
                %>
                <tbody>
                    <tr>
                        <th><%=horaCamVO.getFecha_ho()%></th>
                        <th><%=horaCamVO.getHora_entrada()%></th>
                        <th><%=horaCamVO.getHora_salida()%></th>
                        <th><%=horaCamVO.getEstado_ho()%></th>
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>                    
        </form>
    </body>
</html>
