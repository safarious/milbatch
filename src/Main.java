
import Database.Database;
import Database.UserAdapter;
import Views.WelcomeScreen;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tzhware7
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO: 
        // RFID-Booten (Fehlerbehebung)
        UserAdapter mUa = new UserAdapter();
        mUa.createUser("asdf", "asdf", "asdf", "test", true);

        
        ArrayList<HashMap<String, Object>> check = mUa.getUserByUID("test");
        
        mUa.deleteUserByUID("test");
        

        //Start des Screens
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        welcomeScreen.setVisible(true);
    }
    
}
