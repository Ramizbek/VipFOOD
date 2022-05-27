package developers.sastapp.viphotdog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import developers.sastapp.viphotdog.models.Selectable
import developers.sastapp.viphotdog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list1 = ArrayList<Selectable>()
    private val list2 = ArrayList<Selectable>()
    private val list3 = ArrayList<Selectable>()
    private val list4 = ArrayList<Selectable>()
    private val list5 = ArrayList<Selectable>()
    private val list6 = ArrayList<Selectable>()
    private val list7 = ArrayList<Selectable>()
    private val list8 = ArrayList<Selectable>()
    private val list9 = ArrayList<Selectable>()
    private val list10 = ArrayList<Selectable>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyData.myList.add(list1)
        MyData.myList.add(list2)
        MyData.myList.add(list3)
        MyData.myList.add(list4)
        MyData.myList.add(list5)
        MyData.myList.add(list6)
        MyData.myList.add(list7)
        MyData.myList.add(list8)
        MyData.myList.add(list9)
        MyData.myList.add(list10)
    }

    override fun onSupportNavigateUp(): Boolean =
        Navigation.findNavController(this, R.id.my_container).navigateUp()
}