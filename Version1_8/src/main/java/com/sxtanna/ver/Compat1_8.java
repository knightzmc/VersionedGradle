package com.sxtanna.ver;

import com.avaje.ebean.validation.NotNull;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Compat1_8 implements Compat {

    @Override
    public void sendActionBar(Player player, String message) {
        final IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a(
                String.format("{\"text\":\"%s\"}", message));

        PacketPlayOutChat chat = new PacketPlayOutChat(component, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chat);
    }

}
