package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import developers.sastapp.viphotdog.Adapters.OnTableClickListener
import developers.sastapp.viphotdog.Adapters.TableAdapter
import developers.sastapp.viphotdog.Models.Table
import developers.sastapp.viphotdog.R
import developers.sastapp.viphotdog.databinding.FragmentTableBinding
import developers.sastapp.viphotdog.databinding.ItemDialogTableBinding

class TableFragment : Fragment() {
    private lateinit var binding: FragmentTableBinding
    private lateinit var list: ArrayList<Table>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTableBinding.inflate(layoutInflater)
        start()
        binding.tableRv.adapter = TableAdapter(list, object : OnTableClickListener {
            override fun onClick(table: Table, position: Int) {
                val bottom = BottomSheetDialog(context!!, R.style.NewDialog)
                val view = ItemDialogTableBinding.inflate(layoutInflater)
                view.tableAdd.setOnClickListener {
                    findNavController().navigate(
                        R.id.menuFragment,
                        bundleOf("position" to position)
                    )
                    bottom.cancel()
                }
                view.tableSelectable.setOnClickListener {

                }
                view.tableArxiv.setOnClickListener {

                }
                bottom.setContentView(view.root)
                bottom.show()
            }
        })
        return binding.root
    }

    private fun start() {
        list = ArrayList()
        list.add(Table(R.drawable.logo_food, "Table 1", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 2", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 3", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 4", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 5", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 6", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 7", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 8", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 9", "12:12", "00.00.0000"))
        list.add(Table(R.drawable.logo_food, "Table 10", "12:12", "00.00.0000"))
    }
}