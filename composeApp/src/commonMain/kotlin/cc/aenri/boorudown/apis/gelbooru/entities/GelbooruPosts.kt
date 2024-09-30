package cc.aenri.boorudown.apis.gelbooru.entities

import cc.aenri.boorudown.apis.BooruPost
import cc.aenri.boorudown.util.Option
import cc.aenri.boorudown.util.Some
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class GelbooruPosts (
    @SerialName("@attributes")
    val attributes: Attributes,

    val post: List<Post>
)

@Serializable
data class Post (
    val id: Long,

    @SerialName("created_at")
    val createdAt: String,

    val score: Long,
    val width: Long,
    val height: Long,
    val md5: String,
    val directory: String,
    val image: String,
    val rating: Rating,
    val source: String,
    val change: Long,
    val owner: String,

    @SerialName("creator_id")
    val creatorID: Long,

    @SerialName("parent_id")
    val parentID: Long,

    val sample: Long,

    @SerialName("preview_height")
    val previewHeight: Long,

    @SerialName("preview_width")
    val previewWidth: Long,

    val tags: String,
    val title: String,

    @SerialName("has_notes")
    val hasNotes: String,

    @SerialName("has_comments")
    val hasComments: String,

    @SerialName("file_url")
    val fileURL: String,

    @SerialName("preview_url")
    val previewURL: String,

    @SerialName("sample_url")
    val sampleURL: String,

    @SerialName("sample_height")
    val sampleHeight: Long,

    @SerialName("sample_width")
    val sampleWidth: Long,

    val status: Status,

    @SerialName("post_locked")
    val postLocked: Long,

    @SerialName("has_children")
    val hasChildren: String
) : BooruPost {
    override fun imageUri(): Option<String> = Some(image)

    override fun hash(): Option<String> = Some(md5)

}

@Serializable
enum class Rating(val value: String) {
    @SerialName("explicit") Explicit("explicit"),
    @SerialName("general") General("general"),
    @SerialName("questionable") Questionable("questionable"),
    @SerialName("sensitive") Sensitive("sensitive");
}

@Serializable
enum class Status(val value: String) {
    @SerialName("active") Active("active");
}