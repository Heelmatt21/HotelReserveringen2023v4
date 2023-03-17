package sr.unasat.hotelreservering.controller;


import sr.unasat.hotelreservering.config.JPAConfiguration;
import sr.unasat.hotelreservering.entities.Klanten;
import sr.unasat.hotelreservering.service.KlantenService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/klant")
public class KlantController {

    private final KlantenService klantenService = new KlantenService();


   /*@Path("/list")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Klanten> findKlant() {
        return klantenService.findAll();*/

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Klanten> findKlant(){
        System.out.println(klantenService.findAll());
        return klantenService.findAll();
    }

    @Path("/add")
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Klanten klanten){
        klantenService.insertKlanten(klanten);
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
//    @Path("/remove")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void remove(int klanten){
//        klantenService.deleteKlanten(klanten);
//    }



    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/remove/{klant_id}")
    public Response getAll(@PathParam("klant_id") int klant_id){
        klantenService.deleteKlanten(klant_id);
        if(findKlant().isEmpty()){
            return Response.status(200)
                        .entity("Klant is not deleted").build();
        }else{
            return Response.status(200)
                    .entity("Klant is deleted").build();
        }
    }


    @Path("/getKlanten")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Klanten getKlanten(int klant_id){
        return klantenService.updateKlanten(klant_id);
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
