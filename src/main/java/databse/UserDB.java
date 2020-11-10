/**
 * @author Dustin Eikmeier
 * @version 1.0
 * @since 1.8
 */

package databse;

import org.apache.derby.catalog.UUID;
import org.apache.derby.impl.services.uuid.BasicUUID;

import java.sql.SQLException;
import java.util.Locale;

public class UserDB implements org.apache.derby.database.Database {
    private Locale locale;
    private UUID uuid;
    private Boolean readOnly;

    public UserDB() {
        this.locale = new Locale("de-DE");
        this.uuid = new BasicUUID();
        readOnly = false;
    }

    @Override
    public boolean isReadOnly() {
        return this.readOnly;
    }

    @Override
    public void backup(String s, boolean b) throws SQLException {

    }

    @Override
    public void backupAndEnableLogArchiveMode(String s, boolean b, boolean b1) throws SQLException {

    }

    @Override
    public void disableLogArchiveMode(boolean b) throws SQLException {

    }

    @Override
    public void freeze() throws SQLException {

    }

    @Override
    public void unfreeze() throws SQLException {

    }

    @Override
    public void checkpoint() throws SQLException {

    }

    @Override
    public Locale getLocale() {
        return this.locale;
    }

    @Override
    public UUID getId() {
        return this.uuid;
    }
}
