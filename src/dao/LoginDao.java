/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chris dany
 */
public class LoginDao {

    private static ConnectionDao connection;

    public static boolean logEleve(String login, String pwd) throws SQLException {

        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from eleve where login = '" + login + "' and pwd = '" + pwd + "'").executeQuery();
        return rs.first();
    }

    public static boolean logAdmin(String login, String pwd) throws SQLException {

        Connection conn = ConnectionDao.getConnection();
        ResultSet rs = conn.prepareStatement("select * from admin where login = '" + login + "' and pwd = '" + pwd + "'").executeQuery();
        return rs.first();
    }
}
