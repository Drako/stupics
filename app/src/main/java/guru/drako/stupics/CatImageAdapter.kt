package guru.drako.stupics

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CatImageAdapter @Inject constructor(
    picasso: Picasso,
    private val catApiService: CatApiService
) : AbstractImageAdapter(picasso) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        catApiService.getRandomCats()
            .enqueue(object : Callback<List<CatMetaData>> {
                override fun onFailure(call: Call<List<CatMetaData>>, t: Throwable) {
                    holder.bind(R.drawable.ic_times_circle)
                    logError("Failed loading random cat image metadata.", t)
                }

                override fun onResponse(call: Call<List<CatMetaData>>, response: Response<List<CatMetaData>>) {
                    val url = response.body()!![0].url
                    logInfo("Loading image \"$url\".")
                    holder.bind(url)
                }
            })
    }
}