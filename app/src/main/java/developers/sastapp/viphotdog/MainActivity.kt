package developers.sastapp.viphotdog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<ArrayList<User>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        for (i in 0..9) {
            val myList = ArrayList<User>()
            list.add(myList)
        }
        MyData.myList = list
    }

    override fun onSupportNavigateUp(): Boolean =
        findNavController(this, R.id.my_container).navigateUp()
}