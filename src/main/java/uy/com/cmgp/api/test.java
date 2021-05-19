/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.cmgp.api;

import java.util.List;
import uy.com.cmgp.dominio.ClienteApi;

/**
 *
 * @author cmgp
 */
public class test {
    public static void main(String[] args) {
        List<ClienteApi> lista = AccesoApiEstacion.getResultApi();
         lista.forEach(c->{
             System.out.println(c);
         });
    }
}
