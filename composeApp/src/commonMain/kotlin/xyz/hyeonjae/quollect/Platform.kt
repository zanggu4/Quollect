package xyz.hyeonjae.quollect

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform