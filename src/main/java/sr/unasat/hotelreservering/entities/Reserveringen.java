package sr.unasat.hotelreservering.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

@Entity
public class Reserveringen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservering_id")
    private int reservering_id;
    @Basic
    @Column(name = "reserveer_datum")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate reserveerDatum;
    @Column(name = "reserveringsnummer")
    private String reserveringsnummer;
    @Basic
    @Column (name = "locatie_id",insertable = false, updatable = false)
    private int locatieId;
    @Basic
    @Column(name = "klant_id", insertable = false, updatable = false)
    private int klantId;


//    @Basic
//    @Column(name = "werknemer_id", insertable = false, updatable = false)
//    private int werknemerId;
//    @OneToMany(mappedBy = "reserveringenByReserveringId", cascade = CascadeType.REMOVE)
//    private Collection<Betalingen> betalingensByReserveringId;
    @ManyToOne
    @JoinColumn(name = "locatie_id", referencedColumnName = "locatie_id", nullable = false)
    private Locatie locatieByLocatieId;
    @ManyToOne
    @JoinColumn(name = "klant_id", referencedColumnName = "klant_id", nullable = false)
    private Klanten klanten;
//    @ManyToOne
//    @JoinColumn(name = "werknemer_id", referencedColumnName = "werknemer_id", nullable = false)
//    private Werknemers werknemersByWerknemerId;

//    public Werknemers getWerknemersByWerknemerId() {
//        return werknemersByWerknemerId;
//    }
//
//    public void setWerknemersByWerknemerId(Werknemers werknemersByWerknemerId) {
//        this.werknemersByWerknemerId = werknemersByWerknemerId;
//    }

    public int getReservering_id() {
        return reservering_id;
    }

    public void setReservering_id(int reservering_id) {
        this.reservering_id = reservering_id;
    }

    public LocalDate getReserveerDatum() {
        return reserveerDatum;
    }

    public void setReserveerDatum(LocalDate reserveerDatum) {
        this.reserveerDatum = reserveerDatum;
    }

    public String getReserveringsnummer() {
        return reserveringsnummer;
    }

    public void setReserveringsnummer(String reserveringsnummer) {
        this.reserveringsnummer = reserveringsnummer;
    }

    public int getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(int locatieId) {
        this.locatieId = locatieId;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }



//    public int getWerknemerId() {
//        return werknemerId;
//    }
//
//    public void setWerknemerId(int werknemerId) {
//        this.werknemerId = werknemerId;
//    }

    @Override
    public String toString() {
        return "Reserveringen{" +
                "reservering_id=" + reservering_id + '\'' +
                ", reserveerDatum='" + reserveerDatum + '\'' +
                ", reserveerNummer='" + reserveringsnummer + '\'' +
                ", locatieId='" + locatieId +'\'' +
                ", klantId='" + klantId + '\'' +
                ", familienaam='" + klanten.getFamilienaam() + '\'' +
                ", voornaam='" + klanten.getVoornaam() + '\'' +
                ", locatieNaam='" + locatieByLocatieId.getLocatienaam() +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Reserveringen{" +
//                "reservering_id=" + reservering_id +
//                ", reserveerdatum='" + reserveerDatum + '\'' +
//                ", reserveringsnummer='" + reserveringsnummer + '\'' +
//                ", locatie_id='" + locatieId + '\'' +
//                ", klant_id=" + klantId +
//                '}';
//    }
}