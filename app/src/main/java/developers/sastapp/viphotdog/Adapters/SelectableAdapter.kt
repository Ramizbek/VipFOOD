package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ItemSelectableBinding

class SelectableAdapter(
    private var list: ArrayList<User>
) :
    RecyclerView.Adapter<SelectableAdapter.ViewHolderSelectable>() {

    inner class ViewHolderSelectable(private val binding: ItemSelectableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(selectable: User) {
            binding.apply {
                selectableName.text = selectable.selectableName
                selectablePrice.text = selectable.selectablePrice
                selectableCount.text = selectable.selectableCount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSelectable {
        val bin = ItemSelectableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderSelectable(bin)
    }

    override fun onBindViewHolder(holder: ViewHolderSelectable, position: Int) =
        holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}