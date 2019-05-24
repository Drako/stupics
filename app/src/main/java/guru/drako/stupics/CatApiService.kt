package guru.drako.stupics

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class CatMetaData(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)

interface CatApiService {
    @GET("images/search")
    fun getRandomCats(@Query("limit") limit: Int = 1): Call<List<CatMetaData>>
}
