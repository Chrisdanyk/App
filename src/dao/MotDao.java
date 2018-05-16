/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Mot;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class MotDao {

    private static ConnectionDao connection;

    public static Mot ajouterMot(String francais, String swahili, String lingala, String anglais) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("INSERT INTO mot(francais, swahili, lingala, anglais) "
                + "VALUES ('" + francais + "','" + swahili + "','" + lingala + "','" + anglais + "')").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(id) as idC from mot ").executeQuery();
        Mot c = new Mot(francais, anglais, lingala, swahili);
        while (rs.next()) {
            c.setId(rs.getInt("idC"));
        }
        return c;
    }

    public static Mot modiferMot(int idMot, String francais, String swahili, String lingala, String anglais) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("UPDATE mot SET "
                + "francais='" + francais + "',swahili='" + swahili + "',lingala='" + lingala + "',anglais='" + anglais + "' WHERE id = " + idMot + "").executeUpdate();

        Mot c = new Mot(idMot, francais, anglais, lingala, swahili);

        return c;
    }

    public static List<Mot> allMots() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from mot").executeQuery();
        List<Mot> mots = new ArrayList<>();
        while (rs.next()) {
            Mot c = new Mot();
            c.setId(rs.getInt("id"));
            c.setAnglais(rs.getString("anglais"));
            c.setFrancais(rs.getString("francais"));
            c.setLingala(rs.getString("lingala"));
            c.setSwahili(rs.getString("swahili"));
            mots.add(c);
        }

        return mots;
    }

    public static Mot getMotByFr(String fr) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from mot where francais = '" + fr + "'").executeQuery();
        Mot mot = new Mot();
        while (rs.next()) {
            mot.setId(rs.getInt("id"));
            mot.setAnglais(rs.getString("anglais"));
            mot.setFrancais(rs.getString("francais"));
            mot.setLingala(rs.getString("lingala"));
            mot.setSwahili(rs.getString("swahili"));
        }
        return mot;
    }
    
   
}
