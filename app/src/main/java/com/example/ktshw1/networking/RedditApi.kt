package studio.kts.android.school.lection4.networking.data

import com.example.ktshw1.networking.ServerListingWrapper
import com.example.ktshw1.networking.ServerResponseWrapper
import com.example.ktshw1.networking.Subreddit
import retrofit2.http.*

interface RedditApi {
    @GET("best")
    suspend fun loadBestStart(
        @Query("count") count: Int = 10
    ): ServerResponseWrapper<
            ServerListingWrapper<
                    ServerResponseWrapper<
                            Subreddit>>>
    @GET("best")
    suspend fun loadBestAfter(
        @Query("after") after: String,
        @Query("count") count: Int = 10
    ): ServerResponseWrapper<
            ServerListingWrapper<
                    ServerResponseWrapper<
                            Subreddit>>>

    @FormUrlEncoded
    @POST("api/vote")
    suspend fun vote(
        @Field("id") id: String,
        @Field("dir") dir: Int
    )

}
