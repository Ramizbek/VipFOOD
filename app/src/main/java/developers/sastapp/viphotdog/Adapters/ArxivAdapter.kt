package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ItemArxivBinding

class ArxivAdapter(
    private var list: ArrayList<User>
) :
    RecyclerView.Adapter<ArxivAdapter.VHSelectable>() {

    inner class VHSelectable(private val binding: ItemArxivBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(user: User) {
            binding.apply {
                date.text = user.date
                arxivName.text = user.name
                arxivPrice.text = user.price
                arxivCount.text = user.count
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHSelectable =
        VHSelectable(
            ItemArxivBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: VHSelectable, position: Int) =
        holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}