package cc.aenri.boorudown.apis

import cc.aenri.boorudown.util.Option
import cc.aenri.boorudown.util.Result

interface BooruApi<Post: BooruPost, Continuation: Any?> {

    suspend fun tagSearch(text: String): Option<List<BooruTag>>

    suspend fun getPosts(tags: List<String>, continuation: Continuation?): Result<List<Post>, Throwable>


}