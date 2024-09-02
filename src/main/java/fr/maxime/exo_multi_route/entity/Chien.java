package fr.maxime.exo_multi_route.entity;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "chien")
public class Chien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chien")
    private int idChien;
    @Column(name = "nom_chien")
    private String nomChien;
    @Column(name = "race")
    private String race;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    public Chien(int idChien, String nomChien, String race, LocalDate dateNaissance) {
        this.idChien = idChien;
        this.nomChien = nomChien;
        this.race = race;
        this.dateNaissance = dateNaissance;
    }

    public Chien( ) {
    }

    public int getIdChien() {
        return idChien;
    }

    public void setIdChien(int idChien) {
        this.idChien = idChien;
    }

    public String getNomChien() {
        return nomChien;
    }

    public void setNomChien(String nomChien) {
        this.nomChien = nomChien;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
