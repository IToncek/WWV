package cf.itoncek.weirdwelprvideo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public final class WeirdWelprVideo extends JavaPlugin {
    public static HashMap<String, String> resourcepacky = new HashMap<>();
    public static HashMap<Player, Boolean> invincibility = new HashMap<>();
    public static WeirdWelprVideo plugin;
    public static BukkitRunnable run = new BukkitRunnable() {
        @Override
        public void run() {
            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "⚠️ Loading new resourcepack ⚠️", "If you see this, please move.", 20, 10000, 20);
            }
            WeirdWelprVideo.run();
        }
    };

    @Override
    public void onEnable() {
        plugin = this;
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv0.zip", "e5f2174f02936f5bc2e3f019bb7daa9bc96ff092");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv1.zip", "aef3d15b56c3c566bedd6b3330f7b6670ffe331f");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv2.zip", "a23a0ef9442dc64dc595890010e5c436adffffa7");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv3.zip", "b3c5fa4913dcb94032ed708da941212930613302");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv4.zip", "fb51a0c0cbeee15f94159015f9bfafb3e5d172df");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv5.zip", "030ccc64307ace0a306c690a9a6959bf04e4b2fa");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv6.zip", "9f182b6a857bdeb2b51d147f81c0e8f9ea39516f");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv7.zip", "1f8163082d0b32b3286759a75583f4f41c203d25");
        resourcepacky.put("https://github.com/IToncek/WWV/raw/main/packs/wwv8.zip", "5da953b70bda49ac8eb71b65339edce09e19afda");
        Bukkit.getPluginCommand("start").setExecutor(new StartCommand());
        getServer().getPluginManager().registerEvents(new MoveListener(), plugin);
    }
    public static void run(){
        Random rand = new Random();
        int number = rand.nextInt(8);
        for (Player p : Bukkit.getOnlinePlayers()){
            p.setGameMode(GameMode.SPECTATOR);
            invincibility.put(p, true);
            p.setResourcePack("https://github.com/IToncek/WWV/raw/main/packs/wwv" + number + ".zip");
        }
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()){
            p.kickPlayer(ChatColor.RED + "Server is closed, thanks for playing " + ChatColor.YELLOW + ChatColor.BOLD + "★");
        }
    }

}
