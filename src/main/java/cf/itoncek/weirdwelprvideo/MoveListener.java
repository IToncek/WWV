package cf.itoncek.weirdwelprvideo;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    @EventHandler
    public static void move(PlayerMoveEvent e){
        if (WeirdWelprVideo.invincibility.getOrDefault(e.getPlayer(), false)){
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
            WeirdWelprVideo.invincibility.put(e.getPlayer(), false);
            e.getPlayer().resetTitle();
        }
    }
}
