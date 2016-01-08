package fr.zaral.advancedmessage.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.zaral.advancedmessage.Main;

public class MessageCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("advancedmessage.use")) {
			if (args.length > 1) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player != null) {
					String msg = Main.getMessage(args).replace("&", "§");
					player.sendMessage(msg);
				} else {
					sender.sendMessage("§cYou need to set an online player.");
				}
			} else {
				sender.sendMessage("§cFormat: /cmsg <target> message");
			}
		} else {
			sender.sendMessage("§cYou don't have permission to perform this command");

		}
		return true;
	}
}
