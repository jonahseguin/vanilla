package com.jonahseguin.vanilla

import com.mongodb.MongoClientURI
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.litote.kmongo.KMongo

class VanillaPlugin : JavaPlugin() {

    companion object {
        lateinit var vanilla: Vanilla
    }

    override fun onEnable() {
        saveDefaultConfig()
        val mongoClient = KMongo.createClient(MongoClientURI(config.getString("mongo")!!))
        val database = mongoClient.getDatabase("vanilla")
        val module = VanillaModule(this, mongoClient, database)

        startKoin {
            printLogger()
            modules(module.vanillaModule)
        }

        vanilla = Vanilla()
        vanilla.start()
    }

    override fun onDisable() {
        vanilla.stop()
        stopKoin()
    }

}