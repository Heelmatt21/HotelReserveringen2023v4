package sr.unasat.hotelreservering.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Werknemers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "werknemer_id")
    private int werknemer_id;
    @Basic
    @Column(name = "familienaam")
    private String familienaam;
    @Basic
    @Column(name = "voornaam")
    private String voornaam;
    @Basic
    @Column(name = "geboortedatum")
    private String geboortedatum;
    @Basic
    @Column(name = "adres")
    private String adres;
    @Basic
    @Column(name = "telefoonnummer")
    private int telefoonnummer;
    @Basic
    @Column (name = "werknemersnummer")
    private String werknemersnummer;
    @Basic
    @Column(name = "datum_in_dienst")
    private java.sql.Date datum_in_dienst;
    @Basic
    @Column(name = "locatie_id", insertable = false, updatable = false)
    private int locatieId;
    @OneToMany(mappedBy = "werknemersByWerknemerId")
    private Collection<Reserveringen> reserveringensByWerknemerId;
    @ManyToOne
    @JoinColumn(name = "locatie_id", referencedColumnName = "locatie_id", nullable = false)
    private Locatie locatieByLocatieId;

    public int getWerknemer_id() {
        return werknemer_id;
    }

    public void setWerknemer_id(int werknemer_id) {
        this.werknemer_id = werknemer_id;
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

    public String getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(String geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(int telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getWerknemersnummer() {
        return werknemersnummer;
    }

    public void setWerknemersnummer(String werknemersnummer) {
        this.werknemersnummer = werknemersnummer;
    }

    public Date getDatum_in_dienst() {
        return datum_in_dienst;
    }

    public void setDatum_in_dienst(java.sql.Date datum_in_dienst) {
        this.datum_in_dienst = datum_in_dienst;
    }

    public int getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(int locatieId) {
        this.locatieId = locatieId;
    }

    @Override
    public String toString() {
        return "Werknemers{" +
                "werknemer_id=" + werknemer_id + '\'' +
                ", familienaam='" + familienaam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", geboortedatum='" + geboortedatum + '\'' +
                ", adres='" + adres + '\'' +
                ", telefoonnummer='" + telefoonnummer + '\'' +
                ", werknemersnummer=' "+ werknemersnummer + '\'' +
                ", datum_in_dienst=' " + datum_in_dienst +
                '}';
    }
}