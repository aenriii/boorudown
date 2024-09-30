package cc.aenri.boorudown.apis.gelbooru.entities

import cc.aenri.boorudown.apis.BooruTag
import kotlinx.serialization.*


@Serializable
data class GelbooruTags (
    @SerialName("@attributes")
    val attributes: Attributes,

    val tag: List<Tag>
) {
    fun intoCommonTags(): List<BooruTag> = tag.map { BooruTag(it.name, it.count) }
}

@Serializable
data class Attributes (
    val limit: Long,
    val offset: Long,
    val count: Long
)

@Serializable
data class Tag (
    val id: Long,
    val name: String,
    val count: Long,
    val type: Long,
    val ambiguous: Long
)
