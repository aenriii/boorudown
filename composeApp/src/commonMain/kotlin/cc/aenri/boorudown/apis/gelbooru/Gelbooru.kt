package cc.aenri.boorudown.apis.gelbooru

import cc.aenri.boorudown.apis.BooruApi
import cc.aenri.boorudown.apis.BooruPost
import cc.aenri.boorudown.apis.BooruTag
import cc.aenri.boorudown.apis.gelbooru.entities.GelbooruPosts
import cc.aenri.boorudown.apis.gelbooru.entities.GelbooruTags
import cc.aenri.boorudown.apis.gelbooru.entities.Post
import cc.aenri.boorudown.util.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

object Gelbooru : BooruApi<Post, String> {

    private val httpClient: HttpClient by lazy {
        HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "gelbooru.com"
                    path("/index.php")
                    parameters.append("page", "dapi")
                    parameters.append("q", "index")
                    parameters.append("json", "1")
                }
            }
            install(ContentNegotiation) {
                json()
            }
        }
    }
    data class GelbooruPost(
        private val imageUri: String,
        private val hash: String
    ) : BooruPost {
        override fun imageUri(): Option<String> = Some(imageUri)

        override fun hash(): Option<String> = Some(hash)

    }

    override suspend fun tagSearch(text: String): Option<List<BooruTag>> {
        try {
            val res = httpClient.get {
                parameters {
                    append("s", "tag")
                    append("name_pattern", "$text%")
                    append("limit", "10")
                    append("orderby", "count")
                }
            }
            return Some(res.body<GelbooruTags>().intoCommonTags())
        } catch (e: Exception) {
            return None()
        }
    }

    override suspend fun getPosts(tags: List<String>, continuation: String?): Result<List<Post>, Throwable> {
        try {
            val res = httpClient.get {
                parameters {
                    append("s", "post")
                    append("tags", tags.joinToString("+"))
                    if (continuation != null) {
                        append("pid", continuation)
                    }
                }
            }
            return Ok(res.body<GelbooruPosts>().post)
        } catch (e: Exception) {
            return Err(e)
        }
    }
}
