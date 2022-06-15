package developers.sastapp.viphotdog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developers.sastapp.viphotdog.Adapters.BigArxivAdapter
import developers.sastapp.viphotdog.DataBase.MyDBHelper
import developers.sastapp.viphotdog.databinding.FragmentBigArxivBinding

class BigArxivFragment : Fragment() {
    private lateinit var binding: FragmentBigArxivBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBigArxivBinding.inflate(layoutInflater)
        binding.apply {
            val myDBHelper = MyDBHelper(root.context)
            rv.adapter = BigArxivAdapter(myDBHelper.readUser())
            return root
        }
    }
}