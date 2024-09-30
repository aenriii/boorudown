package cc.aenri.boorudown.apis

import cc.aenri.boorudown.util.Option

interface BooruPost {

    fun imageUri(): Option<String>

    fun hash(): Option<String>
}