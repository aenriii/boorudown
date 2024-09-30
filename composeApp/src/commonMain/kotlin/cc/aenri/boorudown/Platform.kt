package cc.aenri.boorudown

import cc.aenri.boorudown.util.Option

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun selectDirectory(): Option<String>