/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.service;

import com.montes.persistence.entity.Factura;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author MONTES
 */
@Path("/factura")
public class FacturaRest {
    
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
	String output = "Jersey say : " + msg;
	return Response.status(200).entity(output).build();
    }
    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response save(
            @FormParam("nit") String nit,
            @FormParam("nombre") String nombre,
            @Context HttpServletResponse servletResponse
    ) {
	String output = "nit : " + nit+" - nombre: "+nombre;
        System.out.println(output);
	return Response.status(200).entity(output).build();
    }
    
    
}
