package sr.unasat.hotelreservering.service;

import sr.unasat.hotelreservering.config.JPAConfiguration;
import sr.unasat.hotelreservering.dao.KlantenDao;
import sr.unasat.hotelreservering.dao.LocatieDao;
import sr.unasat.hotelreservering.entities.Klanten;
import sr.unasat.hotelreservering.entities.Locatie;

import java.util.List;

public class LocatieService {
    private static List<Locatie> locatieList;
    private static int locatieListId;
    private LocatieDao locatieDao;


    public LocatieService() {
        this.locatieDao = new LocatieDao(JPAConfiguration.getEntityManager());
    }
        /*public KlantenService(){
        if (klantenList == null) {
            klantenListId = 0;
            klantenList = new ArrayList<>();
            klantenList.add(new Klanten(++klantenListId));
        }
    }*/


    public List<Locatie> findAll(){ //get
        return locatieDao.retrieveLocatieList();
    }

    public void insertLocatie(Locatie menuObj){ //post
        locatieDao.insert(menuObj);
    }

    public Locatie updateLocatie(int locatieUpdate){ //put
        return locatieDao.findByLocatieId(locatieUpdate);
    }

    public void deleteLocatie(int locatieDelete){ //delete
        locatieDao.delete(locatieDelete);
    }
}
