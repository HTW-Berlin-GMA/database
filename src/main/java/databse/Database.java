/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private Connection dbConnection = null;
    private String strUrl = "jdbc:derby:DefaultAddressBook";
    public void method(){
        Properties props = new Properties();
        props.put("user", "dbuser");
        props.put("password", "dbuserpwd");
        try {
            dbConnection = DriverManager.getConnection(strUrl, props);
        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
