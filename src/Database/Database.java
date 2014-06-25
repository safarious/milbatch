/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tzhware7
 */
public class Database {
    
    //Strings für die SQL_Statements
    private static final String ID = "row_id";	
    private static final String primaryText = " integer not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),";	
    private static final String stringText = " VARCHAR(1024) ,";
    private static final String stringEndText = " VARCHAR(1024) );";
    private static final String booleanEndText = " Boolean, CONSTRAINT primary_key PRIMARY KEY (row_id) )";
    
    
    //Konstruktor
    public Database() {
        try {
            initDatabase();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initDatabase() throws SQLException, Exception {
        System.out.println("Database gestartet");
        
            Connection conn1 = DriverManager.getConnection(getEmbeddedURL());
            if (conn1 != null) {
                System.out.println("Connected to database milbatch");
                createTableIfNotExists(conn1, UserAdapter.DATABASE_TABLE);
            } else {
                System.out.println("Not Connected");
            }
    }
    
    
    private String getEmbeddedURL() throws SQLException{
        
        //db system directory: <userhome>/.milbatch/
        String userHomeDir = System.getProperty("user.home", ".");
        String systemDir = userHomeDir + "/.milbatch";
        
        //embedded driver
        String dbURL1 = "jdbc:derby:"+systemDir +";create=true";
        
        return dbURL1;
    }
    
    
    public Connection openDatabase() throws SQLException{

        Connection conn1 = DriverManager.getConnection(getEmbeddedURL());
            if (conn1 != null) {
                System.out.println("Datenbankverbindung hergestellt");
                return conn1;
            } else {
                System.out.println("Datenbankverbindung konnte nicht hergestellt werden");
                return null;
            }
    }
    
    
    private static void createTableIfNotExists(Connection connection, String tableName) throws Exception, SQLException {
        
        ResultSet resultSet = connection.getMetaData().getTables("%", "%", "%", new String[]{"TABLE"});
        int columnCnt = resultSet.getMetaData().getColumnCount();
        boolean shouldCreateTable = true;
        while (resultSet.next() && shouldCreateTable) {
            if (resultSet.getString("TABLE_NAME").equalsIgnoreCase(tableName)) {
                System.out.println("Table allready exits");
                shouldCreateTable = false;
            }
        }
        resultSet.close();
        if (shouldCreateTable) {
            System.out.println("Creating Table: " + tableName);
            Statement statement = connection.createStatement();

            //Statement um die Db zu erstellen
            System.out.println("Create Statement");
            String CREATE_TABLE_USER = "create table " + UserAdapter.DATABASE_TABLE + " ("
            + ID + primaryText
            + UserAdapter.RANK + stringText
            + UserAdapter.PRENAME + stringText
            + UserAdapter.LASTNAME + stringText	
            + UserAdapter.UID + stringText
            + UserAdapter.AVAILABLE + booleanEndText;
            
            //Table erstellen
            statement.execute(CREATE_TABLE_USER);
            statement.closeOnCompletion();
            System.out.println("Table wurde erstellt");
            
        }
    }
}
       

