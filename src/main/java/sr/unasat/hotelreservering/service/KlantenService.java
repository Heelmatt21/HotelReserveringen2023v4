package sr.unasat.hotelreservering.service;


import sr.unasat.hotelreservering.config.JPAConfiguration;
import sr.unasat.hotelreservering.dao.KlantenDao;
import sr.unasat.hotelreservering.entities.Klanten;

import javax.persistence.EntityManager;
import java.util.List;

public class KlantenService {

    private static List<Klanten> klantenList;
    private static int klantenListId;
    private KlantenDao klantenDao;


    public KlantenService() {
        this.klantenDao = new KlantenDao(JPAConfiguration.getEntityManager());
    }
    //    public MenuService(){
//        if (menuList == null) {
//            menuListId = 0;
//            menuList = new ArrayList<>();
//            menuList.add(new Menu(++menuListId));
//        }
//    }


    public List<Klanten> findAll(){ //get
        return klantenDao.retrieveKlantenList();
    }

    public void insertKlanten(Klanten menuObj){ //post
        klantenDao.insert(menuObj);
    }

    public Klanten updateKlanten(int klantenUpdate){ //put
        return klantenDao.findByKlantId(klantenUpdate);
    }

    public void deleteKlanten(int klantenDelete){ //delete
        klantenDao.delete(klantenDelete);
    }
}
