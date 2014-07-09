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
import java.util.ArrayList;
import java.util.HashMap;
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


    /**
     * Create a new User.
     * @param grad
     * @param vorname
     * @param nachname
     * @param uid
     * @param available 
     */
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

    
    /**
     * Find User by UID.
     * @param uid 
     * @return  ArrayList<HashMap<String, Object>>
     */
    public ArrayList<HashMap<String, Object>> getUserByUID(String uid) {
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
            System.out.println("Size of Right Entry's : " + size);
            mResultSet.beforeFirst();
            
            
            ArrayList<HashMap<String, Object>> mArrayList = new ArrayList<>();
                
            while(mResultSet.next()){
                
                HashMap<String, Object> mHashMap = new HashMap<>();
                System.out.println("test new: " + mResultSet.getRow());
                
                mHashMap.put(RANK, mResultSet.getString(1));
                mHashMap.put(PRENAME, mResultSet.getString(2));
                mHashMap.put(LASTNAME, mResultSet.getString(3));
                mHashMap.put(UID, mResultSet.getString(4));
                mHashMap.put(AVAILABLE, mResultSet.getBoolean(5));
                mArrayList.add(mHashMap);
   
            }
            
            return mArrayList;

        } catch (SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    
    /**
     * Modify current User by UID.
     * @param grad
     * @param vorname
     * @param nachname
     * @param uid
     * @param available 
     */
    public void modifyUserByUid(String grad, String vorname, String nachname, String uid, boolean available){
        Database mDb = new Database();
        try{
            String MODIFY_USER_BY_UID = "UPDATE "+DATABASE_TABLE
                    +   " SET "+RANK+"='"+grad+"', "+PRENAME+"='"+vorname+"', "+LASTNAME+"='"+nachname
                    +   "', "+UID+"='"+uid+"', "+AVAILABLE+"='"+available+"' WHERE uid='"+uid+"'";
            
            Connection conn = mDb.openDatabase();
            Statement statement = conn.createStatement();
            statement.execute(MODIFY_USER_BY_UID);
            statement.closeOnCompletion();
            
            
        }catch(SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    /**
     * Deletes all Users in Table.
     */
    public void deleteAllUsers(){
        Database mDb = new Database();
        try{
            String DELETE_ALL_USERS = "DELETE FROM "+DATABASE_TABLE;
            
            Connection conn = mDb.openDatabase();
            Statement statement = conn.createStatement();
            statement.execute(DELETE_ALL_USERS);
            statement.closeOnCompletion();
            
            
        }catch(SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Delets User by his UID.
     * @param uid 
     */
    public void deleteUserByUid(String uid){
        Database mDb = new Database();
        
        try{
            String DELETE_USER_BY_UID = "DELETE FROM "+DATABASE_TABLE+" WHERE uid='"+uid+"'";
            
            Connection conn = mDb.openDatabase();
            Statement statement = conn.createStatement();
            statement.execute(DELETE_USER_BY_UID);
            statement.closeOnCompletion();
            
            System.out.println("Alle User wurden erfolgreich gelöscht");
            
        
        }catch(SQLException ex) {
            Logger.getLogger(UserAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
