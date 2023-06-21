package blestit.giveaway;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static blestit.giveaway.eventhandler.StartGiveaway;

public class commandhandler implements CommandExecutor {
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                if (player.hasPermission("avalon.op")) {
                    if (cmd.getName().equalsIgnoreCase("startgiveaway")) {
                        StartGiveaway();
                    }
                }
                else {
                    sender.sendMessage("You are not allowed to use this command");
                }
                return true;
            }
            else {
                sender.sendMessage("Only players can use that command");
                return true;
            }
        }
}
