package guru.drako.stupics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Proxy
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @field:Inject
    lateinit var catImageAdapter: CatImageAdapter

    @field:Inject
    lateinit var dogImageAdapter: DogImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_cats -> image_list.adapter = catImageAdapter
                R.id.navigation_dogs -> image_list.adapter = dogImageAdapter
            }
            true
        }

        image_list.adapter = catImageAdapter
    }
}
