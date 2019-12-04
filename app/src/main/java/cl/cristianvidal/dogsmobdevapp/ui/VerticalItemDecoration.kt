package cl.cristianvidal.dogsmobdevapp.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Cristian Vidal on 2019-12-04.
 */
class VerticalItemDecoration(private val margin: Int,
                             private val includeEdge: Boolean = false) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        with(outRect) {
            if (includeEdge && parent.getChildAdapterPosition(view) == 0) top = margin
            bottom = margin
        }
    }
}