package developers.sastapp.viphotdog.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.adapters.SelectableAdapter
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    lateinit var binding: FragmentSelectableBinding
    lateinit var adapter: SelectableAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        adapter = SelectableAdapter(MyData.myList[MyData.tablePos])
        binding.selectableRv.adapter = adapter
        return binding.root
    }
}