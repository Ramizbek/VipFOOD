package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ItemSelectableBinding

class SelectableAdapter(
    private var list: ArrayList<User>
) :
    RecyclerView.Adapter<SelectableAdapter.VHSelectable>() {

    inner class VHSelectable(private val binding: ItemSelectableBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {
            binding.apply {
                selectableName.text = user.name
                selectablePrice.text = user.price
                selectableCount.text = user.count
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHSelectable =
        VHSelectable(
            ItemSelectableBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: VHSelectable, position: Int) =
        holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}