package sr.unasat.hotelreservering.entities;

import javax.persistence.*;

@Entity
public class Locatie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "locatie_id")
    private int locatie_id;
    @Basic
    @Column(name = "locatienaam")
    private String locatienaam;
    @Basic
    @Column(name = "distrikt")
    private String distrikt;

    public int getLocatie_id() {
        return locatie_id;
    }

    public void setLocatie_id(int locatie_id) {
        this.locatie_id = locatie_id;
    }

    public String getLocatienaam() {
        return locatienaam;
    }

    public void setLocatienaam(String locatienaam) {
        this.locatienaam = locatienaam;
    }

    public String getDistrikt() {
        return distrikt;
    }

    public void setDistrikt(String distrikt) {
        this.distrikt = distrikt;
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "locatie_id=" + locatie_id + '\'' +
                ", locatienaam='" + locatienaam + '\'' +
                ", distrikt='" + distrikt +
                '}';
    }
}
