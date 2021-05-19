/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.cmgp.dominio;

/**
 *
 * @author cmgp
 */
public class ClienteApi {
    private int id_estacion;
    private String fecha;
    private String temperatura;
    private String presion;
    private String velocidad;
    private int direccion;
    private int solar;
    private int uv;
    private String humedad;

    public int getId_estacion() {
        return id_estacion;
    }

    public void setId_estacion(int id_estacion) {
        this.id_estacion = id_estacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getSolar() {
        return solar;
    }

    public void setSolar(int solar) {
        this.solar = solar;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }    

    @Override
    public String toString() {
        return "ClienteApi{" + "id_estacion=" + id_estacion + ", fecha=" + fecha + ", temperatura=" + temperatura + ", presion=" + presion + ", velocidad=" + velocidad + ", direccion=" + direccion + ", solar=" + solar + ", uv=" + uv + ", humedad=" + humedad + '}';
    }
    
    
}
