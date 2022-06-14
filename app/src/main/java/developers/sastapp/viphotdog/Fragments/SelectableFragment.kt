package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import developers.sastapp.viphotdog.Adapters.SelectableAdapter
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.databinding.FragmentSelectableBinding

class SelectableFragment : Fragment() {
    private lateinit var binding: FragmentSelectableBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectableBinding.inflate(layoutInflater)
        binding.apply {
            val myDBHelper = MyDBHelper(root.context)
            selectableRv.adapter = SelectableAdapter(myDBHelper.readUser())
            return root
        }
    }
}