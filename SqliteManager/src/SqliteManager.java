/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kim
 */

public class SqliteManager {
    
    private String dbFileName;
    private Connection connection;
    private Statement stmt;
    private boolean isOpened = false;
    
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch(Exception e) { e.printStackTrace(); }
    }
    
    private static SqliteManager _instance;
    
    public static SqliteManager getInstance() {
        if (_instance == null) _instance = new SqliteManager("doorlock_db.sqlite");
        return _instance;
    }
    
    public SqliteManager(String databaseFileName) {
        this.dbFileName = databaseFileName;
        open();
    }
    
    public boolean open() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + this.dbFileName);
            stmt = connection.createStatement();
        } catch(SQLException e) {
            return false;
        }
        isOpened = true;
        return true;
    }
    
    
    public boolean close() {
        if(this.isOpened == false) { return true; }
        
        try {
            this.stmt.close();
            this.connection.close();
        } catch(SQLException e) {return false; }
        return true;
    }
    
    public boolean checkPhoneNumber(String number)
    {
        if(this.isOpened == false) { return false; }
        try{
            String query = "select count(*) as  count from door_lock_user where phone_number= '" + number +"'";
            ResultSet row = stmt.executeQuery(query);
            int count = 0;
            if(row.next())
            {
                count = row.getInt("count");
            }
            return (count>0);
        }catch (SQLException ex) {
            Logger.getLogger(SqliteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void insertPhoneData(String number)
    {
        if(this.isOpened == false) { return; }
        try{
            String query = "INSERT INTO door_lock_user (phone_number) VALUES ('"+number+"')";
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SqliteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
