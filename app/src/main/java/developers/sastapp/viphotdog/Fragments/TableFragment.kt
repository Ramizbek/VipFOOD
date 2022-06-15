package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import developers.sastapp.viphotdog.Adapters.TableAdapter
import developers.sastapp.viphotdog.Class.Table
import developers.sastapp.viphotdog.Object.MyObject
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
        binding.apply {
            list = ArrayList()
            for (i in 1..10) {
                list.add(Table(R.drawable.logo_food, "Стол - $i"))
            }
            tableRv.adapter =
                TableAdapter(root.context, list, object : TableAdapter.OnTableClickListener {
                    override fun onClick(table: Table, position: Int) {
                        val bottom = BottomSheetDialog(context!!, R.style.NewDialog)
                        ItemDialogTableBinding.inflate(layoutInflater).apply {
                            MyObject.pos = position
                            tableAdd.setOnClickListener {
                                findNavController().navigate(R.id.menuFragment)
                                bottom.cancel()
                            }
                            tableSelectable.setOnClickListener {
                                findNavController().navigate(R.id.selectableFragment)
                                bottom.cancel()
                            }
                            tableArxiv.setOnClickListener {
                                findNavController().navigate(R.id.arxivFragment)
                                bottom.cancel()
                            }
                            bottom.setCancelable(true)
                            bottom.setContentView(this.root)
                            bottom.show()
                        }
                    }
                })
            arxiv.setOnClickListener { findNavController().navigate(R.id.bigArxivFragment) }
            return this.root
        }
    }
}