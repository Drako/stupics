package guru.drako.stupics

import retrofit2.Call
import retrofit2.http.GET

data class DogMetaData(
    val status: String,
    val message: String
)

interface DogApiService {
    @GET("breeds/image/random")
    fun getRandomDog(): Call<DogMetaData>
}
