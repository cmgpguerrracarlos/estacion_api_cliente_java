package uy.com.cmgp.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import uy.com.cmgp.datos.DaoClienteApi;
import uy.com.cmgp.dominio.ClienteApi;

@Path("/estacion") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class EstacionApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    public Response sayHello() {
        DaoClienteApi dca = new DaoClienteApi();
        List<ClienteApi> ca = dca.listar();
        return Response.ok(ca,MediaType.APPLICATION_JSON).build();   
    } 
}
