package cc.aenri.boorudown

import android.os.Build
import cc.aenri.boorudown.util.Option

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()
actual fun selectDirectory(): Option<String> {
    TODO("Not yet implemented")
}