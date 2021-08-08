<%-- 
    Document   : registrarhorario
    Created on : 31/07/2021, 02:17:54 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Horario</h1>
        <form method="post" action="HorarioPersonal">
            <table>
                <tr>
                    <th>
                        Id Horario
                        <input type="text" name="textIdH"><br><br>
                        Fecha Horario
                        <input type="date" name="textfechaH"><br><br>
                        Hora Entrada
                        <input type="time" name="texthoraH"><br><br>
                        Hora Salida
                        <input type="time" name="textho_sal"><br><br>
                        Estado Horario                       
                        <select name="textestadoH">
                            <option>Activo</option>
                            <option>Inactivo</option>
                        </select>
                    </th>
                </tr> 
            </table>
            <button>Registrar</button>
            <input type="hidden" value="1" name="opcion">
        </form>
        <div style="color: red;">
            <% if (request.getAttribute("mensajeError") != null) { %>
            ${mensajeError}

            <%} else {%>
            <div style="color: darkgreen;">${mensajeExito}    </div> 
            <% }%>
        </div>
    </body>
</html>
