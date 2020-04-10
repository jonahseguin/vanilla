package com.jonahseguin.vanilla

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.koin.dsl.module

class VanillaModule(
    private val vanillaPlugin: VanillaPlugin,
    private val mongoClient: MongoClient,
    private val database: MongoDatabase
) {

    val vanillaModule = module(createdAtStart = true) {
        single { vanillaPlugin }
        single { mongoClient }
        single { database }
    }

}