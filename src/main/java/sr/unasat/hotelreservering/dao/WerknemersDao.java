package sr.unasat.hotelreservering.dao;

import sr.unasat.hotelreservering.entities.Werknemers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class WerknemersDao {
    private EntityManager entityManager;

    public WerknemersDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Werknemers> retrieveWerknemersList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Werknemers c";
        TypedQuery<Werknemers> query = entityManager.createQuery(jpql, Werknemers.class);
        List<Werknemers> werknemersList = query.getResultList();
        entityManager.getTransaction().commit();
        return werknemersList;
    }
    //find by werknemersId
    /*public Werknemers findByWerknemerId(Integer werknemerId) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Werknemers c  where c.werknemer_id = :werknemer_id";
        TypedQuery<Werknemers> query = entityManager.createQuery(jpql, Werknemers.class);
        Werknemers werknemers = query.setParameter("werknemer_id", werknemerId).getSingleResult();
        entityManager.getTransaction().commit();
        return werknemers;
    }*/
    //find by werknemersnummer
    public Werknemers findByWerknemersnummer(String werknemersNummer){
        entityManager.getTransaction().begin();
        String jpql = "select c from Werknemers c where c.werknemersnummer = :werknemersnummer";
        TypedQuery<Werknemers> query = entityManager.createQuery(jpql, Werknemers.class);
        Werknemers werknemers = query.setParameter("werknemersnummer", werknemersNummer).getSingleResult();
        entityManager.getTransaction().commit();
        return werknemers;
    }

    public Werknemers insert(Werknemers werknemers) {
        entityManager.getTransaction().begin();
        entityManager.persist(werknemers);
        entityManager.getTransaction().commit();
        return werknemers;
    }

    public int updateWerknemers(Werknemers werknemers) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Werknemers c SET c.telefoonnummer = :telefoonnummer where c.werknemersnummer = :werknemersnummer");
        query.setParameter("werknemersnummer", werknemers.getWerknemersnummer());
        query.setParameter("telefoonnummer", werknemers.getTelefoonnummer());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int delete(String werknemersNummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Werknemers c where c.werknemersnummer = :werknemersnummer");
        query.setParameter("werknemersnummer", werknemersNummer);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    //Rapportage
    public List<Werknemers>getWerknemersRapportage(Date startDate, java.util.Date endDate){
        entityManager.getTransaction().begin();
        String jpql = "select c from Werknemers c where c.datum_in_dienst between :startDate and :endDate";
        TypedQuery<Werknemers> query = entityManager.createQuery(jpql, Werknemers.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate",endDate);

        List<Werknemers> werknemersList = query.getResultList();
        System.out.println("====================================================================================================================================================================================");
        System.out.printf("%10s %15s %20s %20s %20s %20s %20s %20s %20s", "werknemer_Id","familienaam", "voornaam","geboortedatum", "adres", "telefoonnummer", "werknemersnummer", "datum_in_dienst","locatie_id");
        System.out.println();
        System.out.println("====================================================================================================================================================================================");
        for (Werknemers werknemers: werknemersList){
            System.out.format("%5s %20s %20s %20s %20s %20s %20s %20s %20s", werknemers.getWerknemer_id(),werknemers.getFamilienaam(),werknemers.getVoornaam(), werknemers.getGeboortedatum(), werknemers.getAdres(),werknemers.getTelefoonnummer(),werknemers.getWerknemersnummer(),werknemers.getDatum_in_dienst(),werknemers.getLocatieId());
            System.out.println();
        }
        entityManager.getTransaction().commit();
        System.out.println("===================================================================================================================================================================================== ");
        return werknemersList;
    }
}
