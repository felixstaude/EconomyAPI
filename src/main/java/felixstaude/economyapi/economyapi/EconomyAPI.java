package felixstaude.economyapi.economyapi;

import felixstaude.economyapi.sql.SQLEconomyCommand;
import felixstaude.economyapi.sql.SQLEconomyConnection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class EconomyAPI extends JavaPlugin {

    private static String prefix = "EconomyAPI ";
    SQLEconomyConnection sqlconnection = new SQLEconomyConnection();

    @Override
    public void onEnable() {
        System.out.println(getPrefix() + "API startup");
        sqlconnection.connect();
    }

    @Override
    public void onDisable() {
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

}
