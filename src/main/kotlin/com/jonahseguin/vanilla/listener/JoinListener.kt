package com.jonahseguin.vanilla.listener

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = ChatColor.translateAlternateColorCodes('&', "&5${event.player.name} &ajoined!")
    }

    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        event.quitMessage = ChatColor.translateAlternateColorCodes('&', "&5${event.player.name} &cleft :(")
    }

}