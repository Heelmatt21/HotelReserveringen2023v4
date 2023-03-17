package sr.unasat.hotelreservering.dao;

import sr.unasat.hotelreservering.entities.Klanten;
import sr.unasat.hotelreservering.entities.Reserveringen;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class ReserveringenDao {
    private EntityManager entityManager;

    public ReserveringenDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Reserveringen> retrieveReserveringenList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Reserveringen c";
        //String jpql = "select c, DATE_FORMAT(reserveerDatum, '%m/%d/%Y') AS formatted_date from Reserveringen c";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        List<Reserveringen> rederveringenList = query.getResultList();
        entityManager.getTransaction().commit();
        return rederveringenList;
    }
    /*public List<Reserveringen> retrieveReserveringenByKlantId() {
        entityManager.getTransaction().begin();
        String jpql = "select o.reservering_id, o.reserveerDatum, o.reserveringsnummer, c.familienaam, c.voornaam from Reserveringen o inner join Klanten c on o.klantId = c.klant_id";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        List<Reserveringen> rederveringenListByKlantId = query.getResultList();
        entityManager.getTransaction().commit();
        return rederveringenListByKlantId;
    }*/
    /*public List<Reserveringen> retrieveReserveringenByKlantId2() throws SQLException {
        List<Reserveringen> orders = new ArrayList<>();

        String sql = "SELECT o.reservering_id, o.reserveer_datum, o.reserveringsnummer, c.familienaam, c.voornaam " +
                "FROM reserveringen o " +
                "INNER JOIN klanten c " +
                "ON o.klant_id = c.klant_id";

        try (Statement stmt = conn.createStatemen();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int reserveringId = rs.getInt("reservering_id");
                Date reserveerDate = rs.getDate("reserveer_datum");
                String reserveerNummer = rs.getString("reserveernummer");
                //int klantId = rs.getInt("klant_id");
                String klantFamilienaam = rs.getString("familienaam");
                String klantVoornaam = rs.getString("voornaam");

                Reserveringen reserveringen = new Reserveringen(reserveringId, reserveerDate, reserveerNummer, new Klanten(klantFamilienaam, klantVoornaam));
                reserveringen.add(reserveringen);
            }
        }

        return orders;
    }*/
    public List<Reserveringen> reserveringenKlantenList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Reserveringen c inner join Klanten o on (c.klantId = o.klant_id)";
        //String jpql = "select c, DATE_FORMAT(reserveerDatum, '%m/%d/%Y') AS formatted_date from Reserveringen c";

        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        List<Reserveringen> rederveringenList = query.getResultList();
        entityManager.getTransaction().commit();
        return rederveringenList;
    }

//    public List<Reserveringen> reserveringenKlantenListNew() {
//        entityManager.getTransaction().begin();
//        String jpql = "select Reserveringen.reservering_id, Reserveringen.reserveerDatum, Reserveringen.reserveringsnummer, Klanten.familienaam, Klanten.voornaam,Locatie.locatienaam from Reserveringen c inner join Klanten o on (c.klantId = o.klant_id) inner join Locatie a on (c.locatieId = a.locatie_id)";
//        //String jpql = "select c, DATE_FORMAT(reserveerDatum, '%m/%d/%Y') AS formatted_date from Reserveringen c";
//        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
//        List<Reserveringen> rederveringenList = query.getResultList();
//        entityManager.getTransaction().commit();
//        return rederveringenList;
//    }






//find by reserveringId
    /*public Reserveringen findByReserveringId(Integer resrveringId) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Reserveringen c  where c.reservering_id = :reservering_id";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        Reserveringen reserveringen = query.setParameter("reservering_id", resrveringId).getSingleResult();
        entityManager.getTransaction().commit();
        return reserveringen;
    }*/

    //find by reserveringsnummer
    public Reserveringen findByReserveringsnummer(String reserveringsnummer){
        entityManager.getTransaction().begin();
        String jpql = "select c from Reserveringen c where c.reserveringsnummer= :reserveringsnummer";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        Reserveringen reserveringen = query.setParameter("reserveringsnummer", reserveringsnummer).getSingleResult();
        entityManager.getTransaction().commit();
        return reserveringen;
    }
    //find by reserverings_id
    public Reserveringen findByReserveringId(Integer reservering_id) {
        entityManager.getTransaction().begin();
        String jpql4 = "select c from Reserveringen c where c.reservering_id = :reservering_id";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql4, Reserveringen.class);
        Reserveringen reserveringen4 = query.setParameter("reservering_id", reservering_id).getSingleResult();
        entityManager.getTransaction().commit();
        return reserveringen4;
    }

    public Reserveringen insert(Reserveringen reserveringen) {
        entityManager.getTransaction().begin();
        entityManager.persist(reserveringen);
        entityManager.getTransaction().commit();
        return reserveringen;
    }

    public int updateReserveringen(Reserveringen reserveringen) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Reserveringen c SET c.reserveerDatum = :reserveerDatum where c.reserveringsnummer = :reserveringsnummer");
        query.setParameter("reserveringsnummer", reserveringen.getReserveringsnummer());
        query.setParameter("reserveerDatum", reserveringen.getReserveerDatum());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int deletebyReserveringsNummer(String reserveringsNummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Reserveringen c where c.reserveringsnummer = :reserveringsnummer");
        query.setParameter("reserveringsnummer", reserveringsNummer);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    public int delete(int reservering_id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Reserveringen c where c.reservering_id = :reservering_id");
        query.setParameter("reservering_id", reservering_id);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    //Rapportage
    /*public List<Reserveringen>getReserveringRapportage(Date startDate, java.util.Date endDate){
        entityManager.getTransaction().begin();
        String jpql = "select c from Reserveringen c where c.reserveerDatum between :startDate and :endDate";
        TypedQuery<Reserveringen> query = entityManager.createQuery(jpql, Reserveringen.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate",endDate);

        List<Reserveringen> reserveringenList = query.getResultList();
        System.out.println("=======================================================================================================================");
        System.out.printf("%10s %15s %20s %20s %20s %20s", "reservering_id","reserveer_datum", "reserveringsnummer", "locatie_id","klant_id", "werknemer_id");
        System.out.println();
        System.out.println("=======================================================================================================================");
        for (Reserveringen reserveringen: reserveringenList){
            System.out.format("%5s %20s %20s %20s %20s %20s", reserveringen.getReservering_id(),reserveringen.getReserveerDatum(),reserveringen.getReserveringsnummer(),reserveringen.getLocatieId(),reserveringen.getKlantId(),reserveringen.getwerknemerId());
            System.out.println();
        }
        entityManager.getTransaction().commit();
        System.out.println("======================================================================================================================");
        return reserveringenList;
    }*/

}
