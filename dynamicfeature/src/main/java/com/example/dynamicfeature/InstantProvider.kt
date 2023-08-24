package com.example.dynamicfeature

import androidx.annotation.Keep
import com.example.r8desugarinstant.InstantProvider
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

object Bogus {
    fun calculateInstant() = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
}

@Keep
class InstantProviderImpl: InstantProvider {
    override fun provideInstant(): Instant = Bogus.calculateInstant()
}