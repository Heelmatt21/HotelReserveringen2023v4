package sr.unasat.hotelreservering.service;


import sr.unasat.hotelreservering.config.JPAConfiguration;
import sr.unasat.hotelreservering.dao.KlantenDao;
import sr.unasat.hotelreservering.entities.Klanten;
import static sr.unasat.hotelreservering.config.JPAConfiguration.getEntityManager;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class KlantenService {

    private static List<Klanten> klantenList;
    private static int klantenListId;
    private KlantenDao klantenDao = new KlantenDao(JPAConfiguration.getEntityManager());
    private EntityManager entityManager = getEntityManager();
    //private KlantenDao klantenDao;


//    public KlantenService() {
//        this.klantenDao = new KlantenDao(JPAConfiguration.getEntityManager());
//    }
        /*public KlantenService(){
        if (klantenList == null) {
            klantenListId = 0;
            klantenList = new ArrayList<>();
            klantenList.add(new Klanten(++klantenListId));
        }
    }*/


    public List<Klanten> findAll(){ //get
        return klantenDao.retrieveKlantenList();
    }

    public void insertKlanten(Klanten menuObj){ //post
        klantenDao.insert(menuObj);
    }

//    public Klanten updateKlanten(int klantenUpdate){ //put
//        return klantenDao.findByKlantId(klantenUpdate);
//    }
//    public Klanten updateKlanten(Klanten klantenUpdate){ //put
//        return klantenDao.updateKlanten(klantenUpdate);
//    }
public Klanten updateKlantInfo(int klantUpdate){ //put
    return klantenDao.findByKlantId(klantUpdate);
}

    public Klanten updateKlant(Klanten updatedKlant) {
        Klanten existingKlant = klantenDao.findByKlantId(updatedKlant.getKlant_id());
        if (existingKlant == null) {
            return null;
        }
        existingKlant.setFamilienaam(updatedKlant.getFamilienaam());
        existingKlant.setVoornaam(updatedKlant.getVoornaam());
        existingKlant.setAdres(updatedKlant.getAdres());
        existingKlant.setDistrikt(updatedKlant.getDistrikt());
        existingKlant.setLand(updatedKlant.getLand());
        existingKlant.setTelefoonnummer(updatedKlant.getTelefoonnummer());
        existingKlant.setKlantnummer(updatedKlant.getKlantnummer());
        entityManager.getTransaction().begin();
        entityManager.merge(existingKlant);
        entityManager.getTransaction().commit();
        return existingKlant;
    }





    public void deleteKlanten(int klantenDelete){ //delete
        klantenDao.delete(klantenDelete);
    }


}
