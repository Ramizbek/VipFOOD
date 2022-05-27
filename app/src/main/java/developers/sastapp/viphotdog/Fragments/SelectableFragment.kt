package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developers.sastapp.viphotdog.Adapters.SelectableAdapter
import developers.sastapp.viphotdog.Models.Selectable
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    private lateinit var binding: FragmentSelectableBinding
    private lateinit var list: ArrayList<Selectable>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        list = MyData.myList
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.selectableRv.adapter = SelectableAdapter(list)
        return binding.root
    }
}