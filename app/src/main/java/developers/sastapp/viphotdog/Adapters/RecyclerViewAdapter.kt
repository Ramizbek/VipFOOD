package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.R

class RecyclerViewAdapter(
    private val listData: List<User>,
    var clickListener: ClickListener
) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_row, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var titleTextView: TextView = view.findViewById(R.id.titleTextView)
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = listData[position].dataModelTitle
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(listData[position])
        }
    }

    interface ClickListener {
        fun onItemClick(dataModel: User)
    }
}

