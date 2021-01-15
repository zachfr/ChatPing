package me.zachary.chatping.listeners;

import me.zachary.chatping.Chatping;
import me.zachary.zachcore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageListeners implements Listener {
    private Chatping plugin;

    public MessageListeners(Chatping plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String[] args;
        args = event.getMessage().split(" ");
        for (String message : args) {
            Player target = Bukkit.getPlayer(message);
            if(target != null){
                event.getRecipients().remove(target);
                target.sendMessage(ChatUtils.color(event.getFormat().replace("%1$s", player.getDisplayName()).replace("%2$s", getMessagePing(args, target.getName()))));
            }
        }
    }

    public String getMessagePing(String[] args, String target){
        String message = "";
        for (String arg : args) {
            if(arg.equals(target))
                message += ("&6&l" + arg + "&r ");
            else
                message += (arg + " ");
        }
        return message;
    }
}
