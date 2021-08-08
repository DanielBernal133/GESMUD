<%-- 
    Document   : registraHorariocam
    Created on : 1/08/2021, 04:57:59 PM
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
        <h1>Registrar Horario Camiones</h1>
        <form method="POST" action="HorarioCam">
            <table>
                <tr>
                    <th>
                        Id Horario
                        <input type="text" name="textid_Ho"><br><br>
                        Fecha Horario
                        <input type="date" name="textfecha_ho"><br><br>
                        Hora entrada
                        <input type="time" name="texthora_entrada"><br><br>
                        Hora salida 
                        <input type="time" name="texthora_salida"><br><br>                        
                        Estado Hora
                        <input type="text" name="textestado_ho"><br><br>
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
