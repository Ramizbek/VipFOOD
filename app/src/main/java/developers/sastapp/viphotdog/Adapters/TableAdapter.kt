package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ItemTableBinding
import java.time.LocalDate
import java.time.LocalTime

class TableAdapter(
    private var list: ArrayList<User>,
    var onItemClickListener: OnTableClickListener
) :
    RecyclerView.Adapter<TableAdapter.ViewHolderTable>() {

    inner class ViewHolderTable(var binding: ItemTableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(table: User, position: Int) {
            binding.apply {
                tableImage.setImageResource(table.tableImage!!)
                tableName.text = table.tableName
                tableTime.text = "${LocalTime.now()}"
                tableDate.text = "${LocalDate.now()}"
                tableItem.setOnClickListener {
                    onItemClickListener.onClick(table, position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTable {
        val bin = ItemTableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderTable(bin)
    }

    override fun onBindViewHolder(holder: ViewHolderTable, position: Int) =
        holder.onBind(list[position], position)

    override fun getItemCount(): Int = list.size
}

interface OnTableClickListener {
    fun onClick(table: User, position: Int)
}