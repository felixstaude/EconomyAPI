package felixstaude.economyapi.sql;

import felixstaude.economyapi.economyapi.EconomyAPI;
import felixstaude.economyapi.files.SQLFileGetterSetter;
import felixstaude.economyapi.language.Language;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLEconomyConnection {

    static SQLFileGetterSetter sqlfile = new SQLFileGetterSetter();

    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;
    public static Connection con;

    public static void connect(){
        if(!isConnected()){
            sqlfile.setSQLDefault();
            sqlfile.readSQLData();
            try {
                con = DriverManager.getConnection(
                        "jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `EconomySystem`." +
                        "`MoneyDatabase` ( `UUID` VARCHAR(100), " +
                        "`Value` INT(100)) ENGINE = InnoDB; ");
                ps.executeUpdate();
                Bukkit.getLogger().info(Language.getString("sqlconnected"));
            } catch (SQLException throwables) {
                Bukkit.getLogger().warning(Language.getString("sqlerror2001"));
                throwables.printStackTrace();
                Bukkit.getServer().getPluginManager().disablePlugin(EconomyAPI.getPlugin(EconomyAPI.class));
            }
        }
    }
    public static void disconnect(){
        if(isConnected()) {
            try {
                con.close();
                Bukkit.getLogger().info(Language.getString("sqldisconnected"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static boolean isConnected(){
        return (con == null ? false : true);
    }

    public static Connection getConnection(){
        return con;
    }
}
