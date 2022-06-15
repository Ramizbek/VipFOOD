package developers.sastapp.viphotdog.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.Table
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.Object.MyObject
import developers.sastapp.viphotdog.databinding.ItemTableBinding
import java.time.LocalTime

class TableAdapter(
    val context: Context,
    private var list: ArrayList<Table>,
    var onItemClickListener: OnTableClickListener
) :
    RecyclerView.Adapter<TableAdapter.ViewHolderTable>() {
    inner class ViewHolderTable(var binding: ItemTableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(table: Table, position: Int) {
            binding.apply {
                val myDBHelper = MyDBHelper(context)
                tableImage.setImageResource(table.image!!)
                tableName.text = table.name
                val list = ArrayList<User>()
                val list2 = ArrayList<User>()
                for (i in myDBHelper.readUser()) {
                    if (i.number == position && i.select == 1) list.add(i)
                    if (i.number == position) list2.add(i)
                }
                tableCounter.text = "${list.size}/${list2.size}"
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

    interface OnTableClickListener {
        fun onClick(table: Table, position: Int)
    }
}

