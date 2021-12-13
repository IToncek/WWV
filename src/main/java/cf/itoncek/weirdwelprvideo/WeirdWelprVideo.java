package cf.itoncek.weirdwelprvideo;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

public final class WeirdWelprVideo extends JavaPlugin {
    public static final HashMap<Player, Long> countdown = new HashMap<>();
    public static WeirdWelprVideo plugin;
    public static final Logger log = Bukkit.getLogger();
    public static final BukkitRunnable run = new BukkitRunnable() {
        @Override
        public void run() {
            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle(ChatColor.DARK_RED.toString() + ChatColor.BOLD + "⚠️ Loading new resourcepack ⚠️", "If you see this, please move.", 20, 10000, 20);
            }
            try {
                WeirdWelprVideo.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    public static final BukkitRunnable pinger = new BukkitRunnable() {
        @Override
        public void run() {
            LocalTime before = LocalTime.now();
            try {
                request("https://WWVresourcepackhelper.madebyitoncek.repl.co/");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                LocalTime now = LocalTime.now();
                long ms = ChronoUnit.MILLIS.between(before, now);
                for (Player p:Bukkit.getOnlinePlayers()){
                    p.sendActionBar(Component.text(ChatColor.GREEN + "Ping: " + ms));
                }
            }
        }
    };

    @Override
    public void onEnable() {
        plugin = this;
        Objects.requireNonNull(Bukkit.getPluginCommand("start")).setExecutor(new StartCommand());
    }
    public static void run() throws IOException {
        Random rand = new Random();
        int number = rand.nextInt(8);
        log.info(String.valueOf(number));
        log.info(String.valueOf(number));
        log.info(String.valueOf(number));
        log.info(String.valueOf(number));
        for (Player p : Bukkit.getOnlinePlayers()){
            p.setGameMode(GameMode.SPECTATOR);
            countdown.put(p, 10L);
            p.setResourcePack("https://wwvresourcepackhelper.madebyitoncek.repl.co/download/" + number, request("https://wwvresourcepackhelper.madebyitoncek.repl.co/sha1/"+number),true);
        }
    }

    public static String request(@NotNull String url) throws IOException {
        URL licenceserver = new URL(url);
        URLConnection yc = licenceserver.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        return in.readLine();
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()){
            p.kickPlayer(ChatColor.RED + "Server is closed, thanks for playing " + ChatColor.YELLOW + ChatColor.BOLD + "★");
        }
    }

}
