/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Eleve;
import entities.Exercice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class EleveDAO {

    private static ConnectionDao connection;

    public static Eleve ajouterEleve(String nom, String prenom, String genre, String dateNaissance) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("insert into eleve(nom,prenom,genre,dateNaissance) values('" + nom + "','" + prenom + "','" + genre + "','" + dateNaissance + "')").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(id) as idE from eleve ").executeQuery();
        Eleve e = new Eleve(nom, prenom, genre, dateNaissance);
        while (rs.next()) {
            e.setId(rs.getInt("idE"));
        }
        return e;
    }

    public static Eleve ajouterEleve(String nom, String prenom, String genre, String dateNaissance, int idClass) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("insert into eleve(nom,prenom,genre,dateNaissance,login,pwd,classe) values('" + nom + "','" + prenom + "','" + genre + "','" + dateNaissance + "','" + nom + "','" + prenom + "'," + idClass + ")").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(id) as idE from eleve ").executeQuery();
        Eleve e = new Eleve(nom, prenom, genre, dateNaissance);
        while (rs.next()) {
            e.setId(rs.getInt("idE"));
        }
        return e;
    }

    public static Eleve modiferEleve(int id, String nom, String prenom, String genre, String dateNaissance) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("UPDATE eleve SET nom='" + nom + "',prenom='" + prenom + "'"
                + ",genre='" + genre + "',login='" + nom + "',pwd='" + prenom + "',dateNaissance='" + dateNaissance + "' WHERE id = " + id + "").executeUpdate();
        Eleve eleve = new Eleve(id, nom, prenom, genre, dateNaissance);
        return eleve;
    }

    public static Eleve modiferEleve(int idEleve, int idClasse, String nom, String prenom, String genre, String dateNaissance) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("UPDATE eleve SET nom='" + nom + "',prenom='" + prenom + "'"
                + ",genre='" + genre + "',login='" + nom + "',pwd='" + prenom + "', classe = " + idClasse + ", dateNaissance='" + dateNaissance + "' WHERE id = " + idEleve + "").executeUpdate();
        Eleve eleve = new Eleve(idEleve, nom, prenom, genre, dateNaissance);
        return eleve;
    }

    public static List<Eleve> allEleves() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from eleve").executeQuery();
        List<Eleve> eleves = new ArrayList<>();
        while (rs.next()) {
            Eleve e = new Eleve();
            e.setId(rs.getInt("id"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setDateNaissance(rs.getString("dateNaissance"));
            e.setGenre(rs.getString("genre"));
            e.setLogin(rs.getString("login"));
            e.setPwd(rs.getString("pwd"));
            e.setIdClasse(Integer.parseInt(rs.getString("classe")));
            eleves.add(e);
        }
        return eleves;
    }

    public static List<Exercice> getExoByEleve(int idEleve) throws SQLException {
        List<Exercice> exos = new ArrayList<>();
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from  exercice where idEleve = " + idEleve + "").executeQuery();

        return null;
    }

    public static Eleve getEleveByLoginPwd(String login, String pwd) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from eleve where login = '" + login + "' and pwd = '" + pwd + "'").executeQuery();
        Eleve e = new Eleve();
        while (rs.next()) {
            e.setId(rs.getInt("id"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setDateNaissance(rs.getString("dateNaissance"));
            e.setGenre(rs.getString("genre"));
            e.setLogin(rs.getString("login"));
            e.setPwd(rs.getString("pwd"));

        }
        return e;
    }

    public static Eleve getEleveById(int id) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from eleve where id = " + id + "").executeQuery();
        Eleve e = new Eleve();
        while (rs.next()) {
            e.setId(rs.getInt("id"));
            e.setIdClasse(rs.getInt("classe"));
            e.setNom(rs.getString("nom"));
            e.setPrenom(rs.getString("prenom"));
            e.setDateNaissance(rs.getString("dateNaissance"));
            e.setGenre(rs.getString("genre"));
            e.setLogin(rs.getString("login"));
            e.setPwd(rs.getString("pwd"));

        }
        return e;
    }

}
