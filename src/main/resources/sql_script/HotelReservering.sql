create schema hotelreservering_db;

create table klanten (
                         klant_id int primary key auto_increment not null,
                         familienaam varchar(50) not null,
                         voornaam varchar(50) not null,
                         adres varchar(50) not null,
                         distrikt varchar(50) not null,
                         land varchar (50) not null,
                         telefoonnummer int (20) not null);

create table locatie (
                         locatie_id int primary key auto_increment not null,
                         locatienaam varchar (50) not null,
                         distrikt varchar (50) not null );

create table werknemers (
                            werknemer_id int primary key auto_increment not null,
                            familienaam varchar (50) not null,
                            voornaam varchar (50) not null,
                            geboortedatum varchar (15) not null,
                            adres varchar (50) not null,
                            telefoonnummer int (20) not null,
                            locatie_id int not null,
                            constraint locatie_fk foreign key (locatie_id) references hotelreservering_db.locatie (locatie_id));

create table reserveringen (
                               reservering_id int primary key auto_increment not null,
                               reserveer_datum varchar(15) not null,
                               locatie_id int not null,
                               klant_id int not null,
                               werknemer_id int not null,
                               constraint fk_locatie foreign key (locatie_id) references hotelreservering_db.locatie (locatie_id),
                               constraint fk_klant foreign key (klant_id) references hotelreservering_db.klanten (klant_id),
                               constraint fk_werknemer foreign key (werknemer_id) references hotelreservering_db.werknemers (werknemer_id) );

create table betalingen (
                            betaling_id int primary key auto_increment not null,
                            betaling_datum varchar (15) not null,
                            bedrag int (10) not null,
                            betalingsmethode varchar (20) not null,
                            klant_id int not null,
                            reservering_id int not null,
                            constraint klant_fk foreign key (klant_id) references hotelreservering_db.klanten (klant_id),
                            constraint reservering_fk foreign key (reservering_id) references hotelreservering_db.reserveringen (reservering_id) );

alter table klanten
    add klantnummer varchar(20) not null unique;