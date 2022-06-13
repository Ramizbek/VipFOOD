package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import developers.sastapp.viphotdog.Adapters.SelectableAdapter
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    lateinit var binding: FragmentSelectableBinding
    lateinit var adapter: SelectableAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.apply {
            adapter = SelectableAdapter(MyData.myList[MyData.tablePos])
            selectableRv.adapter = adapter
            return root
        }
    }
}