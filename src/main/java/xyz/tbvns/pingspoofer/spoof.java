package xyz.tbvns.pingspoofer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class spoof implements CommandExecutor {
    HashMap<String, Integer> spoof = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 1) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                try {
                    spoof.put(command.getName(), Integer.parseInt(strings[0]));
                    player.sendMessage("§2§lSuccess: §r§aspoof set to §b" + strings[0]);
                } catch (Exception e) {
                    player.sendMessage("§4§lError: §r§c<Ping> need to be a number");
                    player.sendMessage("§4§lUsage: §r§c/spoof <Ping>");
                }
            }
        } else if (strings.length == 2) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                try {
                    spoof.put(strings[1], Integer.parseInt(strings[0]));
                    player.sendMessage("§2§lSuccess: §r§aspoof set to §b" + strings[0] + " §afor player §a" + strings[1]);
                } catch (Exception e) {
                    player.sendMessage("§4§lError: §r§c<Ping> need to be a number");
                    player.sendMessage("§4§lUsage: §r§c/spoof <Ping> <Player>");
                }
            }
        } else {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                player.sendMessage("§4§lError: §r§cWrong arguments");
                player.sendMessage("§4§lUsage: §r§c/spoof <Ping> <Player>");
                player.sendMessage("§4§lUsage: §r§c/spoof <Ping>");
            }
        }
        return true;
    }
}
