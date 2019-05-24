package guru.drako.stupics

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DogImageAdapter @Inject constructor(
    picasso: Picasso,
    private val dogApiService: DogApiService
) : AbstractImageAdapter(picasso) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        dogApiService.getRandomDog()
            .enqueue(object : Callback<DogMetaData> {
                override fun onFailure(call: Call<DogMetaData>, t: Throwable) {
                    holder.bind(R.drawable.ic_times_circle)
                    logError("Failed loading random dog image metadata.", t)
                }

                override fun onResponse(call: Call<DogMetaData>, response: Response<DogMetaData>) {
                    val url = response.body()!!.message
                    logInfo("Loading dog image \"$url\".")
                    holder.bind(url)
                }
            })
    }

}