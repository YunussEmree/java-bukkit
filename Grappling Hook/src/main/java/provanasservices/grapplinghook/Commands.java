package provanasservices.grapplinghook;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§4Only players can use this command.");
            return true;
        } else {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equalsIgnoreCase("getgrapplinghook")) {
                    player.getInventory().addItem(ItemManager.GrapplingHook);
                }
            } else {
                sender.sendMessage("§4You don't have enough permission!");
            }
            return true;
        }
    }
}
