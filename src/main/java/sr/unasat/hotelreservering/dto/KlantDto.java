package sr.unasat.hotelreservering.dto;

public class KlantDto {
    private int klant_id;

    private String familienaam;

    private String voornaam;

    private String adres;

    private String distrikt;

    private String land;

    private int telefoonnummer;

    private String klantnummer;

    public KlantDto(){}

    public KlantDto(int klant_id, String familienaam, String voornaam, String adres, String distrikt, int telefoonnummer, String klantnummer) {
        this.klant_id = klant_id;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.adres = adres;
        this.distrikt = distrikt;
        this.telefoonnummer = telefoonnummer;
        this.klantnummer = klantnummer;
    }
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





    @Override
    public String toString() {
        return "KlantDto{" +
                "klant_id=" + klant_id +
                ", familienaam='" + familienaam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", adres='" + adres + '\'' +
                ", distrikt='" + distrikt + '\'' +
                ", land='" + land + '\'' +
                ", telefoonnummer='" + telefoonnummer + '\'' +
                ", klantnummer='" + klantnummer + '\'' +
                '}';
    }
}

