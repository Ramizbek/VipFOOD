package developers.sastapp.viphotdog.Fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developers.sastapp.viphotdog.Object.MyObject
import developers.sastapp.viphotdog.R
import developers.sastapp.viphotdog.databinding.FragmentSplashBinding
import java.time.LocalTime

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        binding.apply {
            Handler().postDelayed({
                findNavController().popBackStack()
                findNavController().navigate(R.id.tableFragment)
            }, 1000)
            return root
        }
    }
}