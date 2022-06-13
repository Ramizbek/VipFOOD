package developers.sastapp.viphotdog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import developers.sastapp.viphotdog.databinding.ActivityMySplashScreenBinding

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