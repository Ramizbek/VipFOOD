package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import developers.sastapp.viphotdog.databinding.FragmentArxivBinding

class ArxivFragment : Fragment() {
    private lateinit var binding: FragmentArxivBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArxivBinding.inflate(layoutInflater)
        return binding.root
    }
}