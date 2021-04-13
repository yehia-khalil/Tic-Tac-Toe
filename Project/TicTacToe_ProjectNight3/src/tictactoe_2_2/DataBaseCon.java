package tictactoe_2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseCon {

    Connection con;
    Statement stmt;
    String queryString;
    ResultSet rs;

    DataBaseCon() {
    }

    Connection openCon() {
        try {
            System.out.println("Start for Connection Establishment-0");
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Connection Established - 1");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamedatabase", "root", "4244590ass");
            System.out.println("Connection Established - 2");
            return con;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ie) {
            ie.printStackTrace();
        } catch (IllegalAccessException ie) {
            ie.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //  Connection c=null;   
        return null;
    }

    void closeCon() {
        try {
            con.close();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    Connection getCon() {
        return con;
    }

    public void insertFN(String queryString) {
        openCon();
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(queryString);
            pst.executeUpdate();

            /* ***** PRINT IN CONSOLE THE TABLE CONTENT ********** */
            try {
                //  DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "$Walaa4242");
                Statement stmt = con.createStatement();
                queryString = new String("select * from gameData");
                ResultSet rs;
                rs = stmt.executeQuery(queryString);
                while (rs.next()) {
                    System.out.print(rs.getInt(1));
                    System.out.print(": ");
                    System.out.print(rs.getString(2));
                    System.out.print(": ");
                    System.out.print(rs.getString(3));
                    System.out.print(": ");
                    System.out.print(rs.getString(4));
                    System.out.print(": ");
                    System.out.print(rs.getString(5));
                }
                stmt.close();
            } catch (SQLException sq) {
                sq.printStackTrace();
            }//connection w close yt3mlo f method gwa class tnia //finally con             
            /**
             * ********** End*****************
             */
            con.close();
            closeCon();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeCon();
        }
    }

    void updateFN(String queryString) {
        openCon();
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(queryString);
            pst.executeUpdate();

            /* ******** PRINT IN CONSOLE THE TABLE CONTENT *************** */
            try {
                //  DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "$Walaa4242");
                Statement stmt = con.createStatement();
                queryString = new String("select * from gameData");
                ResultSet rs;
                rs = stmt.executeQuery(queryString);
                while (rs.next()) {
                    System.out.print(rs.getInt(1));
                    System.out.print(": ");
                    System.out.print(rs.getString(2));
                    System.out.print(": ");
                    System.out.print(rs.getString(3));
                    System.out.print(": ");
                    System.out.print(rs.getString(4));
                    System.out.print(": ");
                    System.out.print(rs.getString(5));
                }
                stmt.close();
            } catch (SQLException sq) {
                sq.printStackTrace();
            }//connection w close yt3mlo f method gwa class tnia //finally con

            /* ***********End****************/
            con.close();
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            closeCon();
        }
    }

    public int loadidFromDB(int Gid) {

        try {
            openCon();
            queryString = "select G_id from gamedata";
            stmt = getCon().createStatement();
            rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                Gid = rs.getInt(1);
                System.out.println(Gid);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Gid;
    }

    void updateSequence(String sqnce, int id) {
        queryString = "update gamedata set sequence='" + sqnce + "'where G_id=" + id;
        updateFN(queryString);

    }

    void insertID(int id) {
        queryString = "insert into gamedata (G_id) values (" + id + ")";
        insertFN(queryString);

    }

    String RetrieveCurrentGameSequence(String GID) {
        String seq = "";
        try {
            openCon();
            stmt = getCon().createStatement();
            queryString = new String("select * from gamedata where G_id=" + GID);
            rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                seq = rs.getString(2);
                // scoreX = rs.getString(3);
                //scoreO = rs.getString(4);
                //Mode = rs.getString(5);            
            }
            rs.close();
            stmt.close();
            closeCon();

            return seq;
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seq;
    }

    String selectAllIDs() {
        String idString = "";
        try {
            openCon();
            stmt = getCon().createStatement();
            queryString = new String("select G_id from gamedata");
            System.out.println("G_ID selected from database");
            rs = stmt.executeQuery(queryString);
            System.out.println("result set is in rs");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                idString += rs.getInt(1) + ",";
                //  comboBox.getItems().add(idString);
            }
            stmt.close();
            closeCon();
            rs.close();

            return idString;

        } catch (SQLException ex) {
            Logger.getLogger(DataBaseCon.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idString;
    }

    
}
