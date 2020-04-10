package com.jonahseguin.vanilla.land

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.bukkit.Location
import org.litote.kmongo.Id
import org.litote.kmongo.toId
import java.util.*
import kotlin.collections.HashSet

data class Claim(
    @BsonId val id: Id<Claim> = ObjectId().toString().toId(),
    val owner: UUID,
    val world: String,
    val minX: Int,
    val minZ: Int,
    val maxX: Int,
    val maxZ: Int,
    val members: MutableSet<UUID> = HashSet()
) {
    constructor(a: Location, b: Location, owner: UUID) : this(
        owner = owner,
        world = a.world!!.name,
        minX = a.blockX.coerceAtMost(b.blockX),
        minZ = a.blockZ.coerceAtMost(b.blockZ),
        maxX = a.blockX.coerceAtLeast(b.blockX),
        maxZ = a.blockZ.coerceAtLeast(b.blockZ)
    )

    fun getPrice(): Int {
        val x = maxX - minX
        val z = maxZ - minZ
        val blocks = x * z
        return blocks / 128
    }

}