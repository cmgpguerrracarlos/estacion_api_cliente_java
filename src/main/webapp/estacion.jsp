<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos de las estaciones</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h4>Datos de las estaciones</h4>
                        </div>
                        <table class="table table-striped">
                            <thead class="thead-dark bg-dark text-white">
                                <tr>
                                    <th>Id estacion</th>
                                    <th>Fecha</th>
                                    <th>temperatura</th>
                                    <th>presion</th>
                                    <th>Direccion viento</th>
                                    <th>Velocidad viento</th>
                                    <th>Radiacion solar</th>
                                    <th>Radiacion uv</th>
                                    <th>Humedad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cliente" items="${datos}" varStatus="status">
                                    <tr>
                                        <td>${cliente.id_estacion}</td>
                                        <td>${cliente.fecha}</td>
                                        <td>${Float.parseFloat(cliente.temperatura)}</td>
                                        <td>${Float.parseFloat(cliente.presion)}</td>
                                        <td>${cliente.direccion}</td>
                                        <td>${Float.parseFloat(cliente.velocidad)}</td>
                                        <td>${cliente.solar}</td>
                                        <td>${cliente.uv}</td>
                                        <td>${Float.parseFloat(cliente.humedad)}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
        </div>
    </section>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

        <script src="https://kit.fontawesome.com/9b2bfdfb60.js" crossorigin="anonymous"></script>
    </body>
</html>
