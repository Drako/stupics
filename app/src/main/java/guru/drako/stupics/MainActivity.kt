package guru.drako.stupics

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
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

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        val itemCount = prefs
            .getString("preference_item_count", "")?.toInt() ?: 10
        catImageAdapter.loadItemCount = itemCount
        dogImageAdapter.loadItemCount = itemCount

        image_list.adapter = catImageAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_settings -> startActivity(
                Intent(this, SettingsActivity::class.java)
            )
        }
        return true
    }
}
