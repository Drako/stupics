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
        catApiService.getRandomCat()
            .enqueue(object : Callback<List<CatMetaData>> {
                override fun onFailure(call: Call<List<CatMetaData>>, t: Throwable) {
                    holder.bind(R.drawable.ic_times_circle)
                }

                override fun onResponse(call: Call<List<CatMetaData>>, response: Response<List<CatMetaData>>) {
                    holder.bind(response.body()!![0].url)
                }
            })
    }
}