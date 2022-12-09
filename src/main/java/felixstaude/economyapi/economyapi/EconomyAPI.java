package felixstaude.economyapi.economyapi;

import felixstaude.economyapi.files.*;
import felixstaude.economyapi.language.Language;
import felixstaude.economyapi.sql.SQLEconomyCommand;
import felixstaude.economyapi.sql.SQLEconomyConnection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class EconomyAPI extends JavaPlugin {

    private static String prefix = "EconomyAPI ";
    SQLEconomyConnection sqlconnection = new SQLEconomyConnection();
    Language language = new Language();
    LanguageDefault languageStandart = new LanguageDefault();
    private static boolean debugMode = false;


    @Override
    public void onEnable() {
        language.setLanguage();
        setConfigDefaults();
        System.out.println(getPrefix() + " " + Language.getString("message.apienable"));
        sqlconnection.connect();
    }

    @Override
    public void onDisable() {
        System.out.println(getPrefix() + " " + Language.getString("message.apidisable"));
        sqlconnection.disconnect();
    }

    public String getPrefix(){
        return prefix;
    }

    public static Integer getEconomy(UUID uuid){
        return SQLEconomyCommand.getEconomy(uuid);
    }

    public static void setEconomy(UUID uuid, int amount){
        if(amount >= 0){
            SQLEconomyCommand.update(uuid, amount, false);
        } else {
            SQLEconomyCommand.update(uuid, amount, true);
        }
    }

    public static void removePlayer(UUID uuid){
        SQLEconomyCommand.delete(uuid);
    }

    public static boolean isUserExist(UUID uuid){
        return SQLEconomyCommand.isUserExists(uuid);
    }

    public static String getMessageString(String messageid){
        return Language.getString(messageid);
    }

    public static String getCommandMessageString(String messageid, String command){
        return Language.getCommandString(messageid, command);
    }

    public static boolean getDebugMode(){
        return getDebugMode();
    }

    public static void setDebugMode(){
        ConfigFileGetterSetter configFileGetterSetter = new ConfigFileGetterSetter();
        debugMode = configFileGetterSetter.getDebugMode();
    }

    private void setConfigDefaults(){
        if(getDebugMode()){
            System.out.println(getPrefix() + "set Config defaults:");
            ConfigFileGetterSetter configFileGetterSetter = new ConfigFileGetterSetter();
            configFileGetterSetter.setConfigDefault();
            System.out.println(getPrefix() + "Configuration file defaults set");
            DataFileGetterSetter dataFileGetterSetter = new DataFileGetterSetter();
            dataFileGetterSetter.setDataDefault();
            System.out.println(getPrefix() + "Data file defaults set");
            LanguageFileGetterSetter languageFileGetterSetter = new LanguageFileGetterSetter();
            languageFileGetterSetter.setDefault();
            System.out.println(getPrefix() + "Language file defaults set");
            SQLFileGetterSetter sqlFileGetterSetter = new SQLFileGetterSetter();
            sqlFileGetterSetter.setSQLDefault();
            System.out.println(getPrefix() + "SQL file defaults set");
        } else {
            ConfigFileGetterSetter configFileGetterSetter = new ConfigFileGetterSetter();
            configFileGetterSetter.setConfigDefault();
            DataFileGetterSetter dataFileGetterSetter = new DataFileGetterSetter();
            dataFileGetterSetter.setDataDefault();
            LanguageFileGetterSetter languageFileGetterSetter = new LanguageFileGetterSetter();
            languageFileGetterSetter.setDefault();
            SQLFileGetterSetter sqlFileGetterSetter = new SQLFileGetterSetter();
            sqlFileGetterSetter.setSQLDefault();
        }

    }

}
