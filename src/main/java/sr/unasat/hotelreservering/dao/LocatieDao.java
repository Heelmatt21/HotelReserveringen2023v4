package sr.unasat.hotelreservering.dao;

import sr.unasat.hotelreservering.entities.Locatie;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class LocatieDao {
    private EntityManager entityManager;

    public LocatieDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Locatie> retrieveLocatieList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Locatie c";
        TypedQuery<Locatie> query = entityManager.createQuery(jpql, Locatie.class);
        List<Locatie> locatieList = query.getResultList();
        entityManager.getTransaction().commit();
        return locatieList;
    }

    public Locatie findByLocatieId(Integer locatieId) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Locatie c  where c.locatie_id = :locatie_id";
        TypedQuery<Locatie> query = entityManager.createQuery(jpql, Locatie.class);
        Locatie locatie = query.setParameter("locatie_id", locatieId).getSingleResult();
        entityManager.getTransaction().commit();
        return locatie;
    }

    public Locatie insert(Locatie locatie) {
        entityManager.getTransaction().begin();
        entityManager.persist(locatie);
        entityManager.getTransaction().commit();
        return locatie;
    }

    public int updateLocatie(Locatie locatie) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Locatie c SET c.locatienaam = :locatienaam where c.locatie_id= :locatie_id");
        query.setParameter("locatie_id", locatie.getLocatie_id());
        query.setParameter("locatienaam", locatie.getLocatienaam());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int delete(Integer locatieId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Locatie c where c.locatie_id = :locatie_id");
        query.setParameter("locatie_id", locatieId);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
