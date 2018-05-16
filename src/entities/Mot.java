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
public class Mot {
        private int id;
    private String francais,anglais,lingala, swahili;

    public Mot() {
    }

    public Mot(int id, String francais, String anglais, String lingala, String swahili) {
        this.id = id;
        this.francais = francais;
        this.anglais = anglais;
        this.lingala = lingala;
        this.swahili = swahili;
    }

    public Mot(int id) {
        this.id = id;
    }

    public Mot(String francais, String anglais, String lingala, String swahili) {
        this.francais = francais;
        this.anglais = anglais;
        this.lingala = lingala;
        this.swahili = swahili;
    }



    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrancais() {
        return francais;
    }

    public void setFrancais(String francais) {
        this.francais = francais;
    }

    public String getAnglais() {
        return anglais;
    }

    public void setAnglais(String anglais) {
        this.anglais = anglais;
    }

    public String getLingala() {
        return lingala;
    }

    public void setLingala(String lingala) {
        this.lingala = lingala;
    }

    public String getSwahili() {
        return swahili;
    }

    public void setSwahili(String swahili) {
        this.swahili = swahili;
    }
    
    
}
