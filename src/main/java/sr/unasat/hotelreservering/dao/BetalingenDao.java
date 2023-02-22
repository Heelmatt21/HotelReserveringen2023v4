package sr.unasat.hotelreservering.dao;

import sr.unasat.hotelreservering.entities.Betalingen;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

public class BetalingenDao {
    private EntityManager entityManager;

    public BetalingenDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Betalingen> retrieveBetalingList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Betalingen c";
        TypedQuery<Betalingen> query = entityManager.createQuery(jpql, Betalingen.class);
        List<Betalingen> betalingenList = query.getResultList();
        entityManager.getTransaction().commit();
        return betalingenList;
    }

    public Betalingen findByBetalingId(Integer betalingId) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Betalingen c  where c.betaling_id = :betaling_id";
        TypedQuery<Betalingen> query = entityManager.createQuery(jpql, Betalingen.class);
        Betalingen betalingen = query.setParameter("betaling_id", betalingId).getSingleResult();
        entityManager.getTransaction().commit();
        return betalingen;
    }

    public Betalingen insert(Betalingen betalingen) {
        entityManager.getTransaction().begin();
        entityManager.persist(betalingen);
        entityManager.getTransaction().commit();
        return betalingen;
    }

    public int updateBetalingen(Betalingen betalingen) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Betalingen c SET c.bedrag = :bedrag where c.betaling_id= :betaling_id");
        query.setParameter("betaling_id", betalingen.getBetaling_id());
        query.setParameter("bedrag", betalingen.getBedrag());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int delete(Integer betalingId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Betalingen c where c.betaling_id = :betaling_id");
        query.setParameter("betaling_id", betalingId);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
    //Rapportage
    public List<Betalingen>getBetalingRapportage(Date startDate, java.util.Date endDate){
        entityManager.getTransaction().begin();
        String jpql = "select c from Betalingen c where c.betalingDatum between :startDate and :endDate";
        TypedQuery<Betalingen> query = entityManager.createQuery(jpql, Betalingen.class);
        query.setParameter("startDate",startDate);
        query.setParameter("endDate",endDate);

        List<Betalingen> betalingenlist = query.getResultList();
        System.out.println("=======================================================================================================================");
        System.out.printf("%10s %15s %20s %20s %20s %20s", "betaling_Id","betaling_datum", "bedrag","betalingsmethode", "klant_id", "reservering_id");
        System.out.println();
        System.out.println("=======================================================================================================================");
        for (Betalingen betalingen: betalingenlist){
            System.out.format("%5s %20s %20s %20s %20s %20s", betalingen.getBetaling_id(),betalingen.getBetalingDatum(),betalingen.getBedrag(),betalingen.getBetalingsmethode(),betalingen.getKlantId(),betalingen.getReserveringId());
            System.out.println();
        }
        entityManager.getTransaction().commit();
        System.out.println("======================================================================================================================");
        return betalingenlist;
    }

}
