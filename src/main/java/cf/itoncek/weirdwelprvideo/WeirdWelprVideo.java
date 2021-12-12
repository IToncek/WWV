package cf.itoncek.weirdwelprvideo;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public final class WeirdWelprVideo extends JavaPlugin {
    public static HashMap<String, String> resourcepacky = new HashMap<>();
    public static BukkitRunnable run = new BukkitRunnable() {
        @Override
        public void run() {
            Random random = new Random();
            int number = random.nextInt(8);
            for (Player p : Bukkit.getOnlinePlayers()){
                p.setResourcePack();
            }
        }
    };

    @Override
    public void onEnable() {


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
