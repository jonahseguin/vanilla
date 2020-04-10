package com.jonahseguin.vanilla

import com.jonahseguin.vanilla.listener.ChatListener
import com.jonahseguin.vanilla.listener.JoinListener
import com.jonahseguin.vanilla.listener.SleepListener
import org.koin.core.KoinComponent
import org.koin.core.inject

class Vanilla : KoinComponent {

    private val plugin: VanillaPlugin by inject()

    fun start() {
        plugin.logger.info("Starting vanilla")

        // Register listeners
        plugin.server.pluginManager.registerEvents(ChatListener(), plugin)
        plugin.server.pluginManager.registerEvents(JoinListener(), plugin)
        plugin.server.pluginManager.registerEvents(SleepListener(), plugin)

    }

    fun stop() {
        plugin.logger.info("Stopped vanilla")
    }

}