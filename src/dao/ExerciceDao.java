/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Concours;
import entities.Eleve;
import entities.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class ExerciceDao {

    private static ConnectionDao connection;

    public static Exercice ajouterExercice(int idConcours, int idMot, String resultat) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("INSERT INTO exercice(idConcours, idMot, resultat)"
                + " VALUES (" + idConcours + "," + idMot + ",'" + resultat + "')").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(id) as idC from exercice ").executeQuery();
        Concours concoursById = ConcoursDao.concoursById(idConcours);
        Exercice exo = new Exercice(idMot, concoursById, resultat);
        while (rs.next()) {
            exo.setId(rs.getInt("idC"));
        }
        return exo;
    }

    public static Exercice modifierExercice(int idExercice, int idConcours, int idMot, String resultat) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("UPDATE exercice SET idConcours = " + idConcours + ""
                + ",idMot=" + idMot + ",resultat='" + resultat + "' WHERE id=" + idExercice + "").executeUpdate();
        Concours concoursById = ConcoursDao.concoursById(idConcours);
        Exercice exo = new Exercice(idMot, concoursById, idMot, resultat);
        return exo;
    }

    public static List<Exercice> allExercices() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from exercice").executeQuery();
        List<Exercice> exos = new ArrayList<>();
        while (rs.next()) {
            Exercice exo = new Exercice();
            exo.setId(rs.getInt("id"));
            Concours concoursById = ConcoursDao.concoursById(rs.getInt("idConcours"));
            exo.setConcours(concoursById);
            exo.setIdMot(rs.getInt("idMot"));
            exo.setResultat(rs.getString("resultat"));
            exos.add(exo);
        }

        return exos;
    }

    /*
    public static Exercice getExerciceByFr(String fr) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from mot where francais = '" + fr + "'").executeQuery();
        Exercice mot = new Exercice();
        while (rs.next()) {
            mot.setId(rs.getInt("id"));
            mot.setAnglais(rs.getString("anglais"));
            mot.setFrancais(rs.getString("francais"));
            mot.setLingala(rs.getString("lingala"));
            mot.setSwahili(rs.getString("swahili"));
        }
        return mot;
    }*/
}
