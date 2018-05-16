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
public class Concours {
    private int id;
    private Eleve eleve;
    private String date;
    private int nbreReussites;

    public Concours() {
    }

    public Concours(Eleve eleve, String date) {
        this.eleve = eleve;
        this.date = date;
    }

    public Concours(int id, Eleve eleve, String date, int nbreReussites) {
        this.id = id;
        this.eleve = eleve;
        this.date = date;
        this.nbreReussites = nbreReussites;
    }

    public Concours(Eleve eleve, String date, int nbreReussites) {
        this.eleve = eleve;
        this.date = date;
        this.nbreReussites = nbreReussites;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbreReussites() {
        return nbreReussites;
    }

    public void setNbreReussites(int nbreReussites) {
        this.nbreReussites = nbreReussites;
    }
    
    
}
