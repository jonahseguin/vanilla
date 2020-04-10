package com.jonahseguin.vanilla.service.type

import com.jonahseguin.vanilla.land.Claim
import org.bukkit.entity.Player
import org.koin.core.KoinComponent

interface LandService : KoinComponent {

    fun startClaiming(player: Player)
    fun isClaiming(player: Player): Boolean
    fun cancelClaiming(player: Player)
    fun isClaimingComplete(player: Player): Boolean
    fun completeClaiming(player: Player)
    fun isValidClaim(claim: Claim): Boolean
    fun saveClaim(claim: Claim): Boolean
    fun deleteClaim(claim: Claim): Boolean
    fun saveClaims(): Boolean

}