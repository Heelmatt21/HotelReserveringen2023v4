package sr.unasat.hotelreservering.dao;

import sr.unasat.hotelreservering.entities.Klanten;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class KlantenDao {
    private EntityManager entityManager;

    public KlantenDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Klanten> retrieveKlantenList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Klanten c";
        TypedQuery<Klanten> query = entityManager.createQuery(jpql, Klanten.class);
        List<Klanten> klantenList = query.getResultList();
        entityManager.getTransaction().commit();
        return klantenList;
    }

    //find by familienaam
    public Klanten findByKlantFamilienaam(String familienaam) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Klanten c  where c.familienaam = :familienaam";
        TypedQuery<Klanten> query = entityManager.createQuery(jpql, Klanten.class);
        Klanten klanten = query.setParameter("familienaam", familienaam).getSingleResult();
        entityManager.getTransaction().commit();
        return klanten;
    }

    //find by telefoonnummer
    public Klanten findByTelefoonnummer(Integer telefoonnummer) {
        entityManager.getTransaction().begin();
        String jpql1 = "select c from Klanten c where c.telefoonnummer = :telefoonnummer";
        TypedQuery<Klanten> query = entityManager.createQuery(jpql1, Klanten.class);
        Klanten klanten1 = query.setParameter("telefoonnummer", telefoonnummer).getSingleResult();
        entityManager.getTransaction().commit();
        return klanten1;
    }

    //find by klantId
    public Klanten findByKlantId(Integer klant_id) {
        entityManager.getTransaction().begin();
        String jpql4 = "select c from Klanten c where c.klant_id = :klant_id";
        TypedQuery<Klanten> query = entityManager.createQuery(jpql4, Klanten.class);
        Klanten klanten4 = query.setParameter("klant_id", klant_id).getSingleResult();
        entityManager.getTransaction().commit();
        return klanten4;
    }

    //find by familienaam en telefoonnummer
    public Klanten findByFamilienaamTelefoonnummer(String familienaam, Integer telefoonnummer) {
        entityManager.getTransaction().begin();
        String jpql2 = "select c from Klanten c where c.familienaam = :familienaam and c.telefoonnummer = :telefoonnummer";
        TypedQuery<Klanten> query = entityManager.createQuery(jpql2, Klanten.class);
        Klanten klanten2 = query.setParameter("familienaam", familienaam).setParameter("telefoonnummer", telefoonnummer).getSingleResult();
        entityManager.getTransaction().commit();
        return klanten2;

    }

    //find by klantnummer
    public Klanten findByKlantnummer(String klantnummer) {
        if (klantnummer == null) {
            System.out.println("Klantnummer bestaat niet!");

            entityManager.getTransaction().begin();
            String jpql3 = "select c from Klanten c where c.klantnummer = :klantnummer";
            TypedQuery<Klanten> query = entityManager.createQuery(jpql3, Klanten.class);
            Klanten klanten3 = query.setParameter("klantnummer", klantnummer.toLowerCase()).getSingleResult();
            entityManager.getTransaction().commit();
            return klanten3;

        }return null;


    }

    public Klanten insert(Klanten klanten) {
        klanten.setKlantnummer(klanten.getKlantnummer().toLowerCase());
        entityManager.getTransaction().begin();
        entityManager.persist(klanten);
        entityManager.getTransaction().commit();
        return klanten;
    }

    public int updateKlanten(Klanten klanten) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Klanten c SET c.adres = :adres where c.familienaam= :familienaam and c.telefoonnummer= :telefoonnummer");
        query.setParameter("familienaam", klanten.getFamilienaam());
        query.setParameter("telefoonnummer", klanten.getTelefoonnummer());
        query.setParameter("adres", klanten.getAdres());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    /*public int delete(String klantnummer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Klanten c where c.klantnummer = :klantnummer");
        query.setParameter("klantnummer", klantnummer.toLowerCase());
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }*/
    public int delete(int klant_id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Klanten c where c.klant_id = :klant_id");
        query.setParameter("klant_id", klant_id);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
