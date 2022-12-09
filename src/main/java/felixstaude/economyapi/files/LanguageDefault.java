package felixstaude.economyapi.files;

import org.bukkit.configuration.file.FileConfiguration;

public class LanguageDefault {

    LanguageFileGetterSetter lang = new LanguageFileGetterSetter();
    FileConfiguration gercfg = lang.getGERFileConfiguration();
    FileConfiguration engcfg = lang.getENGFileConfiguration();

    public void setGERDefault(){
        // standart german file
        gercfg.addDefault("sql.connected", "SQL Datenbank ist Verbunden!");
        gercfg.addDefault("sql.disconnected", "SQL Datenbank Verbindung ist getrennt");
        gercfg.addDefault("sql.error.2001", "Die SQL Datenbank konnte nicht Verbunden werden, es könnten verbindungsfehler vorliegen oder schau in der 'mysql.yml' nach Tippfehlern nach");
        gercfg.addDefault("message.apienable", "Die API wird gestartet");
        gercfg.addDefault("message.apidisable", "Die API wird beendet");
        gercfg.addDefault("error.1003", "Um den Befehl nutzen zu können, musst du ein Spieler sein! Nutze %COMMAND%");
    }

    public void setENGDefault(){
        // standart english file
        engcfg.addDefault("error.1001", "can't find the language file, check your settings.yml to set the correct language!");
        engcfg.addDefault("sql.connected", "SQL database is connected!");
        engcfg.addDefault("sql.disconnected", "SQL database is disconnected");
        engcfg.addDefault("sql.error.2001", "can't connect to the SQL database, check your database for connection issues or typos in your 'mysql.yml'");
        engcfg.addDefault("message.apienable", "API is starting");
        engcfg.addDefault("message.apidisable", "API is terminating");
        engcfg.addDefault("error.1003.1", "You have to be a Player to execute this command! Use %COMMAND%");
    }
}
