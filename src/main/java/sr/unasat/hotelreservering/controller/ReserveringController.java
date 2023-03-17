package sr.unasat.hotelreservering.controller;



import sr.unasat.hotelreservering.entities.Reserveringen;
import sr.unasat.hotelreservering.service.ReserveringenService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/reservering")
public class ReserveringController {
    private final ReserveringenService reserveringenService = new ReserveringenService();


   /*@Path("/list")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Klanten> findKlant() {
        return klantenService.findAll();*/

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserveringen> findreservering(){
        System.out.println(reserveringenService.findAll());
        return reserveringenService.findAll();
    }
    @Path("/listklant")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserveringen> findReserveringKlanten(){
        System.out.println(reserveringenService.findReserveringKlanten());
        return reserveringenService.findReserveringKlanten();
    }
//    @Path("/listklantnew")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Reserveringen> findReserveringKlantenNew(){
//        System.out.println(reserveringenService.findReserveringKlantenNew());
//        return reserveringenService.findReserveringKlantenNew();
//    }
//    @Path("/listbyklant")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Reserveringen> findreserveringbyklantid(){
//        System.out.println(reserveringenService.findAllByKlantId());
//        return reserveringenService.findAllByKlantId();
//    }

    @Path("/add")
    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(Reserveringen reserveringen){
        reserveringenService.insertReserveringen(reserveringen);
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
    public void remove(int reserveringen){
        reserveringenService.deleteReserveringen(reserveringen);
    }

    @Path("/getReservering")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reserveringen getReserveringen(int reservering_id){
        return reserveringenService.updateReserveringen(reservering_id);
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

