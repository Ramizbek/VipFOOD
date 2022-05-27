package developers.sastapp.viphotdog.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developers.sastapp.viphotdog.adapters.SelectableAdapter
import developers.sastapp.viphotdog.MyData
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    private lateinit var binding: FragmentSelectableBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.selectableRv.adapter = SelectableAdapter(MyData.myList[arguments?.getInt("sel")!!])
        return binding.root
    }
}