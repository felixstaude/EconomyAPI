package felixstaude.economyapi.language;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Language {
    private static Languages language;
    public static String langString;

    public static String getString(String string){
        if(getConfigFile().getString(string) != null){
            return getConfigFile().getString(string);
        }
        return "ERROR-1002 can't find string in language file";
    }

    public static String getCommandString(String string, String command){
        if(getConfigFile().getString(string) != null){
            return getConfigFile().getString(string).replace("%COMMAND%",command);
        }
        return "ERROR-1002 can't find string in language file";
    }

    public static void setLanguage(){
        if(langString.equalsIgnoreCase("german") || langString.equalsIgnoreCase("ger")){
            language = Languages.GERMAN;
        } else if(langString.equalsIgnoreCase("english") || langString.equalsIgnoreCase("eng")){
            language = Languages.ENGLISH;
        } else {
            language = Languages.ENGLISH;
            System.out.println(getString("error1001"));
        }
    }

    private static File getFile(){
        return new File("plugins/EconomySystem/languages", language.getFileName());
    }

    private static YamlConfiguration getConfigFile(){
        return YamlConfiguration.loadConfiguration(getFile());
    }
}
