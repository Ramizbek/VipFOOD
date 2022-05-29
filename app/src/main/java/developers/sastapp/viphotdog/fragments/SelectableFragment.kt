package developers.sastapp.viphotdog.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import developers.sastapp.viphotdog.adapters.SelectableAdapter
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.R
import developers.sastapp.viphotdog.adapters.SwipeAdapter
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding
import developers.sastapp.viphotdog.models.Selectable
import java.util.*
import kotlin.collections.ArrayList

class SelectableFragment : Fragment() {
    lateinit var adapter: SwipeAdapter
    lateinit var items: ArrayList<Selectable>
    lateinit var binding: FragmentSelectableBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.selectableRv.adapter =
            SelectableAdapter(MyData.myList[arguments?.getInt("sel")!!])
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        val recyclerView: RecyclerView = binding.root.findViewById(R.id.selectable_rv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        items = fetchData()
        adapter = SwipeAdapter(items)
        recyclerView.adapter = adapter
        val swipe: SwipeRefreshLayout = binding.root.findViewById(R.id.swipeRefreshLayout)
        swipe.setOnClickListener {
            adapter.notifyDataSetChanged()
            swipe.isRefreshing = false
        }
        val itemTouchHelper = ItemTouchHelper(simpleCallBack)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private val simpleCallBack =
        object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END,
            ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                Collections.swap(items, fromPosition, toPosition)
                adapter.notifyItemMoved(fromPosition, toPosition)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                items.remove(items[position])
                adapter.notifyItemRemoved(position)
            }
        }

    private fun fetchData(): ArrayList<Selectable> {
        val list = ArrayList<Selectable>()
        for (i in 0 until list.size) {
            list.add(Selectable("ABDUSAMID", "ABDUSAMID", "ABDUSAMID"))
        }
        return list
    }
}