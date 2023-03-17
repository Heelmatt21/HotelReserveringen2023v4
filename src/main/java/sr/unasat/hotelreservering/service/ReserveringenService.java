package sr.unasat.hotelreservering.service;

import sr.unasat.hotelreservering.config.JPAConfiguration;
import sr.unasat.hotelreservering.dao.KlantenDao;
import sr.unasat.hotelreservering.dao.ReserveringenDao;
import sr.unasat.hotelreservering.entities.Klanten;
import sr.unasat.hotelreservering.entities.Reserveringen;

import java.util.List;

public class ReserveringenService {
    private static List<Klanten> reserveringList;
    private static int reserveringListId;

    private ReserveringenDao reserveringenDao;


    public ReserveringenService() {
        this.reserveringenDao = new ReserveringenDao(JPAConfiguration.getEntityManager());
    }
        /*public KlantenService(){
        if (klantenList == null) {
            klantenListId = 0;
            klantenList = new ArrayList<>();
            klantenList.add(new Klanten(++klantenListId));
        }
    }*/


    public List<Reserveringen> findAll(){ //get
        return reserveringenDao.retrieveReserveringenList();
    }//get

//    public List<Reserveringen> findAllByKlantId(){
//        return reserveringenDao.retrieveReserveringenByKlantId();
//    }
    public List<Reserveringen> findReserveringKlanten(){ //get
    return reserveringenDao.reserveringenKlantenList();
}

//    public List<Reserveringen> findReserveringKlantenNew(){ //get
//    return reserveringenDao.reserveringenKlantenListNew();
//}

    public void insertReserveringen(Reserveringen menuObj){ //post
        reserveringenDao.insert(menuObj);
    }

    public Reserveringen updateReserveringen(int reserveringenUpdate){ //put
        return reserveringenDao.findByReserveringId(reserveringenUpdate);
    }

    public void deleteReserveringen(int reserveringDelete){ //delete
        reserveringenDao.delete(reserveringDelete);
    }
}

