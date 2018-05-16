/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class ClasseDAO {

    private static ConnectionDao connection;

    public static Classe ajouterClasse(String d) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("insert into classe(designation) values('" + d + "')").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(id) as idC from classe ").executeQuery();
        Classe c = new Classe(d);
        while (rs.next()) {
            c.setId(rs.getInt("idC"));
        }
        return c;
    }

    public static Classe modiferClasse(int idClasse, String d) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("update classe set designation = '" + d + "' where id = " + idClasse + "").executeUpdate();

        Classe c = new Classe();
        c.setId(idClasse);
        c.setDesignation(d);
        return c;
    }

    public static List<Classe> allClasses() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select id,designation from classe").executeQuery();
        List<Classe> classes = new ArrayList<>();
        while (rs.next()) {
            Classe c = new Classe();
            c.setId(rs.getInt("id"));
            c.setDesignation(rs.getString("designation"));
            classes.add(c);
        }

        return classes;
    }

    public static Classe getClasseById(int id) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from classe where id = " + id + "").executeQuery();
        Classe c = new Classe();
        while (rs.next()) {
            c.setDesignation(rs.getString("designation"));
            c.setId(rs.getInt("id"));
        }
        return c;
    }

    public static int getClasseByDesignation(String designation) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from classe where designation = '" + designation + "'").executeQuery();
        int idClasse = 0;
        while (rs.next()) {
            idClasse = rs.getInt("id");
        }
        return idClasse;
    }

}
