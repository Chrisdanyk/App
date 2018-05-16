/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import dao.ConcoursDao;
import entities.Concours;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author chris dany
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Exercice exo = ExerciceDao.modifierExercice(2,1, 1, "correct", sdf.format(new Date()));
//        System.out.println("exo = " + exo.getResultat());
        //  List<Concours> allConcourss = ConcoursDao.allConcourss();
//         for (Concours c : allConcourss) {
//             System.out.println("c = " + c.getEleve().getNom());
//        }
        List<Concours> allConcourss = ConcoursDao.allConcourss();
        for (Concours concours : allConcourss) {
            System.out.println("xxxxx: " + concours.getNbreReussites());
//            model.addRow(new Object[]{
//                concours.getEleve().getNom(),
//                concours.getEleve().getPrenom(),
//                concours.getEleve().getGenre(),
//                concours.getEleve().getClass(),
//                concours.getNbreReussites()});        
        }

        //    EleveDAO.modiferEleve(5, 2, "benj", "smile", "m","2018-12-12");
        List<Concours> concoursTriDate = ConcoursDao.concoursTriDate("10", "05", "2018");
        for (Concours concours : concoursTriDate) {
            System.out.println("concours = " + concours.getDate());
        }
    }

}
