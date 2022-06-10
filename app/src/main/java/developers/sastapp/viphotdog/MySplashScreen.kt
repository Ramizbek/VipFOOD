package developers.sastapp.viphotdog

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import developers.sastapp.viphotdog.Class.User
import developers.sastapp.viphotdog.databinding.ActivityMySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class MySplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMySplashScreenBinding
    private val list1 = ArrayList<User>()
    private val list2 = ArrayList<User>()
    private val list3 = ArrayList<User>()
    private val list4 = ArrayList<User>()
    private val list5 = ArrayList<User>()
    private val list6 = ArrayList<User>()
    private val list7 = ArrayList<User>()
    private val list8 = ArrayList<User>()
    private val list9 = ArrayList<User>()
    private val list10 = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySplashScreenBinding.inflate(layoutInflater)
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

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            binding.myProgress.visibility = View.INVISIBLE
            finish()
        }, 999)
    }
}