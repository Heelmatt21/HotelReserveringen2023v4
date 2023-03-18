package sr.unasat.hotelreservering.controller;

import sr.unasat.hotelreservering.entities.Locatie;
import sr.unasat.hotelreservering.entities.Reserveringen;
import sr.unasat.hotelreservering.service.LocatieService;
import sr.unasat.hotelreservering.service.ReserveringenService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/locatie")
public class LocatieController {
    private final LocatieService locatieService = new LocatieService();


   /*@Path("/list")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Klanten> findKlant() {
        return klantenService.findAll();*/

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Locatie> findlocatie(){
        System.out.println(locatieService.findAll());
        return locatieService.findAll();
    }

    @Path("/add")
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Locatie locatie){
        locatieService.insertLocatie(locatie);
//        System.out.println(menu);
    }
    //
//    @Path("/update")
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void update(Menu menu){
//        menuService.updateMenu(menu);
//    }
//
    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(int locatie){
        locatieService.deleteLocatie(locatie);
    }

    @Path("/getLocatie")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Locatie getLocatie(int locatie_id){
        return locatieService.updateLocatie(locatie_id);
    }

//    @Path("/updateMenu")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Menu getMenu(Menu menu){
//        return menuService.updateMenu(menu);
//
//    }
}

