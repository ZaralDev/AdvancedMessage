package fr.zaral.advancedmessage;

import java.io.IOException;

import org.bukkit.plugin.java.JavaPlugin;

import fr.zaral.advancedmessage.command.MessageCommand;
import fr.zaral.advancedmessage.utils.Metrics;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getLogger().info("Loading plugin...");
		
		getLogger().info("Loadings commands...");
		getCommand("cmessage").setExecutor(new MessageCommand());
		
		getLogger().info("Loading metrics...");
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			getLogger().severe("Failed to load Metrics");
		}
		
		getLogger().info("Plugin enabled !");

	}
	

	public static String getMessage(String[] msg) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < msg.length; i++) {
		    if (i != 0) {
			    builder.append(msg[i] + " ");
		    }
		}
		String finalMsg = builder.toString();
		return finalMsg;
	}
}
