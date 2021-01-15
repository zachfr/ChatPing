package me.zachary.chatping;

import me.zachary.chatping.listeners.MessageListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chatping extends JavaPlugin {

    @Override
    public void onEnable() {
        new MessageListeners(this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
