/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tzhware7
 */
public class UserAdapter {

    public static final String RANK = "grad";
    public static final String PRENAME = "vorname";
    public static final String LASTNAME = "nachname";
    public static final String UID = "uid";
    public static final String AVAILABLE = "availabLe";

    public static final String DATABASE_TABLE = "TBL_USER";

    //Konstruktor
    public UserAdapter() {

    }

    public void createUser(String grad, String vorname, String nachname, String uid, boolean available) {
        Database mDb = new Database();
        try {
            String CREATE_USER = "insert into " + DATABASE_TABLE
                    + "(" + RANK + "," + PRENAME + "," + LASTNAME + "," + UID + "," + AVAILABLE + ") "
                    + "values('" + grad + "','" + vorname + "','" + nachname + "','" + uid + "'," + available + ")";

            Connection conn = mDb.openDatabase();

            Statement statement = conn.createStatement();
            statement.execute(CREATE_USER);
            statement.closeOnCompletion();

            /* Wäre eigentlich die richtige Lösung funktioniert aber aus
             * aus unerklärlichen Gründen nicht....
             try (PreparedStatement mPreparedStatement = conn.prepareStatement(CREATE_USER)) {
             mPreparedStatement.executeQuery();
             }*/
            System.out.println("User wurde hinzugefügt");

        } catch (SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getUserByUID(String uid) {
        Database mDb = new Database();
        try {

            String GET_USER_BY_UID = "SELECT grad,vorname,nachname,uid,available FROM " + DATABASE_TABLE + " WHERE uid='" + uid + "'";

            Connection conn = mDb.openDatabase();
            PreparedStatement mPreparedStatement = conn.prepareStatement(GET_USER_BY_UID, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mPreparedStatement.closeOnCompletion();

            
            mResultSet.last();
            final int size = mResultSet.getRow();
            System.out.println("Size of Shit : " + size);
            mResultSet.beforeFirst();
            
            int i;
            while(mResultSet.next()){
                
                for (i = 1; i <= size; i++){
                   System.out.println("testing :" + i);
                    //auslese der natürlichen gewinner
                }
                
            }


            //Inhalt auslesen
          /* while (mResultSet.next()){
               
             }*/
        } catch (SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
