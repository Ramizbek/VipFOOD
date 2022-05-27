package developers.sastapp.viphotdog

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import developers.sastapp.viphotdog.databinding.ActivityMySplashScreenBinding

@SuppressLint("CustomSplashScreen")
class MySplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            binding.myProgress.visibility = View.INVISIBLE
            finish()
        }, 1000)
    }
}