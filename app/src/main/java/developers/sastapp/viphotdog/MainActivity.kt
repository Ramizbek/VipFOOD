package developers.sastapp.viphotdog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import developers.sastapp.viphotdog.databinding.ActivityMainBinding
import developers.sastapp.viphotdog.Swipe.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean =
        Navigation.findNavController(this, R.id.my_container).navigateUp()
}