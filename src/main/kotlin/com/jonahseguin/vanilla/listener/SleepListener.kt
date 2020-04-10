package com.jonahseguin.vanilla.listener

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent
import org.bukkit.event.player.PlayerJoinEvent

class SleepListener : Listener {

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.player.isSleepingIgnored = true
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onEnterBed(event: PlayerBedEnterEvent) {
        Bukkit.broadcastMessage("${ChatColor.DARK_PURPLE}${event.player.name} ${ChatColor.GRAY}went to bed.  Sweet dreams :)")
    }

}