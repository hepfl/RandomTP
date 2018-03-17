package net.thomi100;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * Created by thomi100 on 17.03.2018.
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[RandomTP] Enabling the plugin...");

        Configuration.setDefaults(this);
        Configuration.load(this);
    }

    @Override
    public void onDisable() {
        System.out.println("[RandomTP] Disabling the plugin...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("randomtp")) {
            if(args.length == 0) {
                if(!(sender instanceof Player) || (boolean) Configuration.get("enable_default_command")) {
                    sender.sendMessage(Configuration.get("prefix") + "§aRandomTP enabled on version §e" + getDescription().getVersion() + "§a by §e" + getDescription().getAuthors() + "§a.");
                    return true;
                }
            }
            sender.sendMessage((String) Configuration.get("help_message"));
            return true;
        }
        return false;
    }


}