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
public class Classe {

    private int id;
    private String designation;

    public Classe() {
    }

    public Classe(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Classe(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
