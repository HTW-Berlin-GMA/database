import org.apache.derby.jdbc.EmbeddedDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

public class AddressDAO {
    private EmbeddedDriver embeddedDriver;
    private Properties dbProperties = null;
    private String dbName;

    public AddressDAO(String addressBookName) {
        embeddedDriver = new EmbeddedDriver();
        this.dbName = addressBookName;
        setDBSystemDir();
        dbProperties = loadDBProperties();
        String driverName = dbProperties.getProperty("derby.driver");
        loadDatabaseDriver(driverName);
    }

    private Properties loadDBProperties() {
        InputStream dbPropInputStream = null;
        dbPropInputStream = AddressDAO.class.getResourceAsStream("Configuration.properties");
        dbProperties = new Properties();
        try {
            dbProperties.load(dbPropInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dbProperties;
    }

    private void loadDatabaseDriver(String driverName) {
        // Load the Java DB driver.
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void setDBSystemDir() {
        // Decide on the db system directory: <userhome>/.addressbook/
        String userHomeDir = System.getProperty("user.home", ".");
        String systemDir = userHomeDir + "/.addressbook";

        // Set the db system directory.
        System.setProperty("derby.system.home", systemDir);
    }


}
