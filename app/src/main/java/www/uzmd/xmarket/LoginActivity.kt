package www.uzmd.xmarket

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import www.uzmd.xmarket.database.MyAppDatabase
import www.uzmd.xmarket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = MyAppDatabase.getDb(this).getService()
        try {
            val login = db.getUser(1)?.login ?: "salom"

            if (login != "salom") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE), 1)
                }
            }
        } catch (e: Exception) {
            Log.d("MY_TAG", "onCreate: $e ")
        }
        binding.kirishBtn.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}