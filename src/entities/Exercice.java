/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author chris dany
 */
public class Exercice {

    private int id, idMot;
    private Eleve eleve;
    private Mot mot;
    private String resultat;
    private Concours concours;

    public Exercice() {
    }

    public Exercice(int id, Concours concours, int idMot, String resultat) {
        this.id = id;
        this.concours = concours;
        this.idMot = idMot;
        this.resultat = resultat;
    }

    public Exercice(int idMot, Concours concours, String resultat) {
        this.idMot = idMot;
        this.resultat = resultat;
        this.concours = concours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMot() {
        return idMot;
    }

    public void setIdMot(int idMot) {
        this.idMot = idMot;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Mot getMot() {
        return mot;
    }

    public void setMot(Mot mot) {
        this.mot = mot;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Concours getConcours() {
        return concours;
    }

    public void setConcours(Concours concours) {
        this.concours = concours;
    }

}
