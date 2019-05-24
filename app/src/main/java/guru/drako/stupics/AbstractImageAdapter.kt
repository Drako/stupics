package guru.drako.stupics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.image_item.*

abstract class AbstractImageAdapter(
    private val picasso: Picasso
) : RecyclerView.Adapter<AbstractImageAdapter.ViewHolder>() {
    companion object {
        // TODO: make configurable at runtime
        const val ITEM_COUNT = 10
    }

    inner class ViewHolder(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(url: String) {
            picasso.load(url).into(image_view)
        }

        fun bind(@DrawableRes imageId: Int) {
            image_view.setImageResource(imageId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ITEM_COUNT
    }
}
