package com.jonahseguin.vanilla.listener

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ChatListener : Listener {

    @EventHandler
    fun onChat(event: AsyncPlayerChatEvent) {
        val colorCode: Char = if (event.player.isOp) 'c' else '5'
        event.format = ChatColor.translateAlternateColorCodes('&', "&$colorCode.&f%s&7: &f%s")
    }

}