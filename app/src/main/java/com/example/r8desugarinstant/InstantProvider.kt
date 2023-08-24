package com.example.r8desugarinstant

import java.time.Instant

interface InstantProvider {
    fun provideInstant(): Instant
}