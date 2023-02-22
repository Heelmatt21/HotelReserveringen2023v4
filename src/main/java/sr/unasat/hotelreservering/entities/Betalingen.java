package sr.unasat.hotelreservering.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Betalingen {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "betaling_id")
    private int betaling_id;
    @Basic
    @Column(name = "betaling_datum")
    private Date betalingDatum;
    @Basic
    @Column(name = "bedrag")
    private int bedrag;
    @Basic
    @Column(name = "betalingsmethode")
    private String betalingsmethode;
    @Basic
    @Column(name = "klant_id", insertable = false, updatable = false)
    private int klantId;
    @Basic
    @Column(name = "reservering_id", insertable = false, updatable = false)
    private int reserveringId;

    @ManyToOne
    @JoinColumn(name = "klant_id", referencedColumnName = "klant_id", nullable = false)
    private Klanten klanten;

    @ManyToOne
    @JoinColumn(name = "reservering_id", referencedColumnName = "reservering_id", nullable = false)
    private Reserveringen reserveringenByReserveringId;

    public Reserveringen getReserveringenByReserveringId() {
        return reserveringenByReserveringId;
    }

    public void setReserveringenByReserveringId(Reserveringen reserveringenByReserveringId) {
        this.reserveringenByReserveringId = reserveringenByReserveringId;
    }

    public Klanten getKlanten() {
        return klanten;
    }

    public void setKlanten(Klanten klanten) {
        this.klanten = klanten;
    }

    public int getBetaling_id() {
        return betaling_id;
    }

    public void setBetaling_id(int betaling_id) {
        this.betaling_id = betaling_id;
    }

    public Date getBetalingDatum() {
        return betalingDatum;
    }

    public void setBetalingDatum(Date betalingDatum) {
        this.betalingDatum = betalingDatum;
    }

    public int getBedrag() {
        return bedrag;
    }

    public void setBedrag(int bedrag) {
        this.bedrag = bedrag;
    }

    public String getBetalingsmethode() {
        return betalingsmethode;
    }

    public void setBetalingsmethode(String betalingsmethode) {
        this.betalingsmethode = betalingsmethode;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public int getReserveringId() {
        return reserveringId;
    }

    public void setReserveringId(int reserveringId) {
        this.reserveringId = reserveringId;
    }

    @Override
    public String toString() {
        return "Betalingen{" +
                "betaling_id=" + betaling_id +
                ", betalingDatum='" + betalingDatum + '\'' +
                ", bedrag='" + bedrag + '\'' +
                ", betalingsmethode='" + betalingsmethode +
                '}';
    }
}
