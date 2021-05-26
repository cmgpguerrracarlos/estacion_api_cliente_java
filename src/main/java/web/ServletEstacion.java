/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uy.com.cmgp.api.AccesoApiEstacion;
import uy.com.cmgp.datos.DaoClienteApi;
import uy.com.cmgp.dominio.ClienteApi;

@WebServlet("/ServletEstacion")
public class ServletEstacion extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DaoClienteApi ca = new DaoClienteApi();
        AccesoApiEstacion.startApp();
        System.out.println("********************App started*************************");
        List<ClienteApi> lista = ca.listar();
        HttpSession session = req.getSession();
        session.setAttribute("datos", lista);
        res.sendRedirect("estacion.jsp");
    }
}
