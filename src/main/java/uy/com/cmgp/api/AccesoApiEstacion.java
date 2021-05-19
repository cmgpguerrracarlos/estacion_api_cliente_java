package uy.com.cmgp.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import uy.com.cmgp.dominio.ClienteApi;

public class AccesoApiEstacion {
    
       public static List<ClienteApi> getResultApi(){
        String url = "http://localhost/JAVAEE/estacion/";
        Client client = ClientBuilder.newClient();
        System.out.println("begin..............");
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
        String fechad = map.get("fecha").concat("\"");
        ca.setFecha(fechad);
        ca.setTemperatura(map.get("temperatura"));
        ca.setPresion(map.get("presion"));
        ca.setDireccion(Integer.parseInt(map.get("direccion_viento")));
        ca.setVelocidad(map.get("velocidad_viento"));
        ca.setSolar(Integer.parseInt(map.get("radiacion_solar")));
        ca.setUv(Integer.parseInt(map.get("radiacion_uv")));
        ca.setHumedad(map.get("humedad"));
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