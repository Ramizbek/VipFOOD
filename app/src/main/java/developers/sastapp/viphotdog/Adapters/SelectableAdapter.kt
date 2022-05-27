package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Models.Selectable
import developers.sastapp.viphotdog.databinding.ItemSelectableBinding

class SelectableAdapter(
    private var list: ArrayList<Selectable>
) :
    RecyclerView.Adapter<SelectableAdapter.ViewHolderSelectable>() {

    inner class ViewHolderSelectable(private val binding: ItemSelectableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(selectable: Selectable, position: Int) {
            binding.apply {
                selectableName.text = selectable.name
                selectablePrice.text = selectable.price
                selectableCount.text = selectable.count
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSelectable {
        val bin = ItemSelectableBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderSelectable(bin)
    }

    override fun onBindViewHolder(holder: ViewHolderSelectable, position: Int) =
        holder.onBind(list[position], position)

    override fun getItemCount(): Int = list.size
}