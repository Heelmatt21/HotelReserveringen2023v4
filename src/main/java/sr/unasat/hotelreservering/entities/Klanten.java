package sr.unasat.hotelreservering.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Klanten {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    @Column
    private int klant_id;
    @Column
    private String familienaam;
    @Column
    private String voornaam;
    @Column
    private String adres;
    @Column
    private String distrikt;
    @Column
    private String land;
    @Column
    private int telefoonnummer;
    @Column
    private String klantnummer;
    //@OneToMany(mappedBy = "klanten",cascade = CascadeType.REMOVE)
    //@OneToMany(cascade = CascadeType.PERSIST)
    //@Column
    //private Set<Betalingen> betalingens;

    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDistrikt() {
        return distrikt;
    }

    public void setDistrikt(String distrikt) {
        this.distrikt = distrikt;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(int telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(String klantnummer) {
        this.klantnummer = klantnummer;
    }

    /*public Set<Betalingen> getBetalingens() {
        return betalingens;
    }

    public void setBetalingens(Set<Betalingen> betalingens) {
        this.betalingens = betalingens;
    }*/
    @Override
    public String toString() {
        return "Klanten{" +
                "klant_id=" + klant_id +
                ", familienaam='" + familienaam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", adres='" + adres + '\'' +
                ", distrikt=" + distrikt + '\'' +
                ", land=" + land + '\'' +
                ", telefoonnummer=" + telefoonnummer + '\'' +
                ", klantnummer=" + klantnummer +
                '}';
    }
}