package cc.aenri.boorudown

import cc.aenri.boorudown.platform.selectFolder
import cc.aenri.boorudown.util.Option

actual fun selectDirectory(): Option<String> = selectFolder()