package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ItemArxivBinding

class ArxivAdapter(
    private var list: ArrayList<User>
) :
    RecyclerView.Adapter<ArxivAdapter.ViewHolderArxiv>() {

    inner class ViewHolderArxiv(private val binding: ItemArxivBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(arxiv: User, position: Int) {
            binding.apply {
                arxivName.text = arxiv.arxivName
                arxivPrice.text = arxiv.arxivPrice
                arxivCount.text = arxiv.arxivCount
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderArxiv {
        val bin = ItemArxivBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderArxiv(bin)
    }

    override fun onBindViewHolder(holder: ViewHolderArxiv, position: Int) =
        holder.onBind(list[position], position)

    override fun getItemCount(): Int = list.size
}