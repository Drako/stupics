package guru.drako.stupics

import retrofit2.Call
import retrofit2.http.GET

data class CatMetaData(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)

interface CatApiService {
    @GET("images/search")
    fun getRandomCat(): Call<List<CatMetaData>>
}
