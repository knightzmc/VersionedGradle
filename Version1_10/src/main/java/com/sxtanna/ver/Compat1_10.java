package com.sxtanna.ver;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Compat1_10 implements Compat {

    @Override
    public void sendActionBar(Player player, String message) {
        final IChatBaseComponent component = ChatSerializer.a(
                String.format("{\"text\":\"%s\"}", message));

        PacketPlayOutChat chat = new PacketPlayOutChat(component, (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chat);
    }
}
