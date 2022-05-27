package developers.sastapp.viphotdog.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developers.sastapp.viphotdog.Models.Menu
import developers.sastapp.viphotdog.databinding.ItemMenuBinding

class MenuAdapter(
    private var list: ArrayList<Menu>,
    private var onItemClickListener: OnMenuClickListener
) :
    RecyclerView.Adapter<MenuAdapter.ViewHolderMenu>() {

    inner class ViewHolderMenu(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(menu: Menu, position: Int) {
            binding.apply {
                menuImage.setImageResource(menu.image)
                menuName.text = menu.name
                menuPrice.text = menu.price
                menuItem.setOnClickListener {
                    onItemClickListener.onClick(menu, position)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMenu {
        val bin = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderMenu(bin)
    }

    override fun onBindViewHolder(holder: ViewHolderMenu, position: Int) =
        holder.onBind(list[position], position)

    override fun getItemCount(): Int = list.size
}

interface OnMenuClickListener {
    fun onClick(menu: Menu, position: Int)
}