/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Eleve;
import entities.Concours;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class ConcoursDao {

    private static ConnectionDao connection;

    public static Concours ajouterConcours(int idEleve, String date) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("INSERT INTO concours(idEleve, date) VALUES (" + idEleve + ",'" + date + "')").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(idConcours) as idC from concours ").executeQuery();
        Eleve eleve = EleveDAO.getEleveById(idEleve);
        Concours concours = new Concours(eleve, date);
        while (rs.next()) {
            concours.setId(rs.getInt("idC"));
        }
        return concours;
    }

    public static Concours ajouterConcours(int idEleve, String date, int x) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        conn.prepareStatement("INSERT INTO concours(idEleve, date, nbreReussites) VALUES (" + idEleve + ",'" + date + "'," + x + ")").executeUpdate();
        ResultSet rs = conn.prepareStatement("select max(idConcours) as idC from concours ").executeQuery();
        Eleve eleve = EleveDAO.getEleveById(idEleve);
        Concours concours = new Concours(eleve, date);
        while (rs.next()) {
            concours.setId(rs.getInt("idC"));
        }
        return concours;
    }

    public static Concours modifierConcours(int idConcours, int idEleve, int resultat, String date) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        Eleve eleve = EleveDAO.getEleveById(idEleve);
        conn.prepareStatement("UPDATE concours SET "
                + "idEleve=" + idEleve + ",date='" + date + "',nbreReussites=" + resultat + " WHERE where idConcours = " + idConcours + "").executeUpdate();
        Concours exo = new Concours(idConcours, eleve, date, resultat);
        return exo;
    }

    public static List<Concours> allConcourss() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours order by nbreReussites desc").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }

        return exos;
    }

    public static List<Concours> concoursParEleve(int idEleve) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours where idEleve = " + idEleve + "").executeQuery();
        List<Concours> con = new ArrayList<>();
        while (rs.next()) {
            Concours concours = new Concours();
            concours.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            concours.setEleve(eleve);
            concours.setNbreReussites(rs.getInt("nbreReussites"));
            concours.setDate(rs.getString("date"));
            con.add(concours);
        }

        return con;
    }

    public static Concours concoursById(int idC) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours where idConcours = " + idC + "").executeQuery();
        List<Concours> con = new ArrayList<>();
        Concours concours = null;
        while (rs.next()) {
            concours = new Concours();
            concours.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            concours.setEleve(eleve);
            concours.setNbreReussites(rs.getInt("nbreReussites"));
            concours.setDate(rs.getString("date"));
        }

        return concours;
    }

    public static List<Concours> concoursByReussiteDesc() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours order by nbreReussites desc ").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }

        return exos;
    }

    public static List<Concours> concoursByReussiteAlphaDesc() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours inner join eleve on concours.idEleve = eleve.id  order by nbreReussites and eleve.nom  desc ").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }

        return exos;
    }

    public static List<Concours> concoursTriDate(String day, String month, String year) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours where year(date) = " + year + " and day(date) = " + day + " and month(date) = " + month + " ").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }
        return exos;
    }

    public static List<Concours> concoursTri60() throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from concours left join eleve on concours.idEleve=eleve.id where month(date)=6 and (nbreReussites*100/12) >= 60").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }
        return exos;
    }

    public static List<Concours> concoursParClasse(String classe) throws SQLException {
        Connection conn = ConnectionDao.getConnection();
        int idClasse = ClasseDAO.getClasseByDesignation(classe);
        ResultSet rs = conn.prepareStatement("select * from concours left join eleve on concours.idEleve = eleve.id where classe = " + idClasse+" order by nbreReussites desc").executeQuery();
        List<Concours> exos = new ArrayList<>();
        while (rs.next()) {
            Concours exo = new Concours();
            exo.setId(rs.getInt("idConcours"));
            Eleve eleve = EleveDAO.getEleveById(rs.getInt("idEleve"));
            exo.setEleve(eleve);
            exo.setNbreReussites(rs.getInt("nbreReussites"));
            exo.setDate(rs.getString("date"));
            exos.add(exo);
        }
        return exos;
    }
}
