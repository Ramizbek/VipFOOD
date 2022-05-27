package developers.sastapp.viphotdog.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.models.Arxiv
import developers.sastapp.viphotdog.databinding.ItemArxivBinding

class ArxivAdapter(
    private var list: ArrayList<Arxiv>
) :
    RecyclerView.Adapter<ArxivAdapter.ViewHolderArxiv>() {

    inner class ViewHolderArxiv(private val binding: ItemArxivBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(arxiv: Arxiv, position: Int) {
            binding.apply {
                arxivName.text = arxiv.name
                arxivPrice.text = arxiv.price
                arxivCount.text = arxiv.count
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