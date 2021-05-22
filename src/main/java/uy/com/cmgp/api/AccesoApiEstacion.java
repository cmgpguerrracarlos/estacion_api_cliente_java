package uy.com.cmgp.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import uy.com.cmgp.datos.DaoClienteApi;
import uy.com.cmgp.dominio.ClienteApi;

public class AccesoApiEstacion {
    private static Boolean apagado= true;
//    
    public static void startApp() {
        if(apagado){
            Thread t = new Thread() {
            @Override
            public void run() {
                DaoClienteApi dca = new DaoClienteApi();
                while (true) {
                    try {
                        
                        List<ClienteApi> csa = AccesoApiEstacion.getResultApi();
                        csa.forEach(ca -> {
                            dca.insertar(ca);
                            System.out.println(ca);                            
                        });
                        System.out.println("========Ejecutando busqueda en api=============");
//                        Thread.sleep(1000*60*60*2);
                          Thread.sleep(1000*60*2);
                    } catch (InterruptedException ie) {
                        System.out.println("End round");
                    }
                }
            }
            };
            apagado = false;
            t.start();
        }

    }

    public static List<ClienteApi> getResultApi() {
        String url = "http://localhost/JAVAEE/estacion/";
        Client client = ClientBuilder.newClient();
        String result = client.target(url).request(APPLICATION_JSON).get(String.class);
        List<String> li = separar(result);
        List<ClienteApi> usuarios = new ArrayList<>();
        li.forEach(u -> {
            usuarios.add(data(u));
        });
        return usuarios;
    }

    private static ClienteApi data(String user) {
        ClienteApi ca = new ClienteApi();
        String[] atri = user.split(",");
        Map<String, String> map = new HashMap<>();
        for (String a : atri) {
            String[] d = a.split(":");
            d[0] = d[0].substring(1, d[0].length() - 1);
            map.put(d[0], d[1]);
        }

        ca.setId_estacion(Integer.parseInt(map.get("id_estacion")));
        String fechad = map.get("fecha");
        String temp = map.get("temperatura");
        String pres = map.get("presion");
        String vel = map.get("velocidad_viento");
        String hum = map.get("humedad");
    
        ca.setFecha(fechad.substring(1, fechad.length()));
        ca.setTemperatura(temp.substring(1, temp.length()-1));
        ca.setPresion(pres.substring(1, pres.length()-1));
        ca.setDireccion(Integer.parseInt(map.get("direccion_viento")));
        ca.setVelocidad(vel.substring(1, vel.length()-1));
        ca.setSolar(Integer.parseInt(map.get("radiacion_solar")));
        ca.setUv(Integer.parseInt(map.get("radiacion_uv")));
        ca.setHumedad(hum.substring(1, hum.length()-1));
        return ca;
    }

    private static List<String> separar(String result) {
        List<String> li = new ArrayList<>();
        result = result.substring(2, result.length() - 1);
        result = result.replace("{", "&");
        result = result.replace("}", "&");
        String[] lista = result.split("&");
        for (String l : lista) {
            if (!l.equals(",")) {
                li.add(l);
            }
        }
        return li;
    }
}
