package www.uzmd.xmarket

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import www.uzmd.xmarket.databinding.ActivityShopBinding
private val REQUEST_CALL_PERMISSION = 1
class ShopActivity : AppCompatActivity() {
    lateinit var binding: ActivityShopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var name = intent.getStringExtra("name")
        var info = intent.getStringExtra("info")
        var narx = intent.getStringExtra("narx")
        var url = intent.getStringExtra("url")

        binding.productInfo.text = info.toString()
        binding.productName.setText("$name || Narxi: $narx $")
        lifecycleScope.launch {
            Picasso.get().load(url).into(binding.phoneImg)
        }


        binding.phoneCall.setOnClickListener {

            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Ruxsat so‘rash
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_CALL_PERMISSION)
            } else {
                // Qo‘ng‘iroq qilish
                var tellNumber = "976010322"
                val dialIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$tellNumber"))
                startActivity(dialIntent)
            }


        }
    }
}