<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../../css/estilos.css">
        <script src="./js/funciones.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <title>Graficas de barra</title>
    </head>

    <body>
        <table>
            <thead>
                <tr>
                    <td>Año</td>
                    <td>Poblacion1</td>
                    <td>Poblacion2</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1879</td>
                    <td>0.5</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1882</td>
                    <td>0.7</td>
                    <td>1.7</td>
                </tr>
                <tr>
                    <td>1900</td>
                    <td>0.9</td>
                    <td>1.9</td>
                </tr>
                <tr>
                    <td>1910</td>
                    <td>1.05</td>
                    <td>1.95</td>
                </tr>
                <tr>
                    <td>1963</td>
                    <td>2.6</td>
                    <td>3.6</td>
                </tr>
                <tr>
                    <td>1975</td>
                    <td>2.8</td>
                    <td>3.5</td>
                </tr>
                <tr>
                    <td>1985</td>
                    <td>3</td>
                    <td>3.4</td>
                </tr>
                <tr>
                    <td>1996</td>
                    <td>3.1</td>
                    <td>2.1</td>
                </tr>
                <tr>
                    <td>2004</td>
                    <td>3.2</td>
                    <td>3.1</td>
                </tr>
                <tr>
                    <td>2011</td>
                    <td>3.3</td>
                    <td>3.3</td>
                </tr>
            </tbody>
        </table>
        <div>
            <canvas id="grafica" class="largo"></canvas>
        </div>

<!--        <script src="js/funciones.js">

        </script>-->
        <br>
        <a href="index.jsp">Regreasar</a>
    </body>
</html>