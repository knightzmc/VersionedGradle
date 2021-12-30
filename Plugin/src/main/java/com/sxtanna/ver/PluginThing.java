package com.sxtanna.ver;

import org.apache.commons.lang.StringUtils;
import org.bukkit.plugin.java.JavaPlugin;

class PluginThing extends JavaPlugin {
    private static PluginThing INSTANCE;
    private String version;

    private Compat compat;

    @Override
    public void onLoad() {
        INSTANCE = this;

        version = StringUtils.substringBefore(getServer().getBukkitVersion(), "-");
    }

    @Override
    public void onEnable() {
        switch (version) {
            case "1.8.8":
                compat = new Compat1_8();
                break;
            case "1.9.4":
                compat = new Compat1_9();
                break;
            case "1.10.2":
                compat = new Compat1_10();
                break;
            default:
                throw new IllegalStateException("Unsupported version: " + version);
        }

        getServer().getOnlinePlayers().forEach(player ->
                compat.sendActionBar(player, "Hello!!"));
    }

}
