package com.shverma.booknexus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform