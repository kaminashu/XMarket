package www.uzmd.xmarket

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import kotlinx.coroutines.launch
import www.uzmd.xmarket.databinding.ActivityMainBinding
import www.uzmd.xmarket.network.Internet
import www.uzmd.xmarket.network.ShopService
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: RecAdapter
    lateinit var vpAdapter: ViewPagerAdapter
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager()
        var network = Internet().getREtrofit().create(ShopService::class.java)
        lifecycleScope.launch {
            var list = network.getProduct()
            adapter = RecAdapter(list) {
                var name = it.name
                var info = it.batafsil
                var narx = it.narx
                var url = it.suratId

                var intent = Intent(this@MainActivity, ShopActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("narx", narx)
                intent.putExtra("info", info)
                intent.putExtra("url", url)
                startActivity(intent)
            }
            binding.recId.adapter = adapter
        }

    }

    private fun viewPager() {
        installViewPager()
        setUpTransformer()
    }

    private fun setUpTransformer() {
        var transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(20))
        transformer.addTransformer { page, position ->
            var r = 1 - abs(position)
            page.scaleY = 0.80f + r * 0.18f
        }
        binding.vPager.setPageTransformer(transformer)
    }

    private fun installViewPager() {
        var arrayList = ArrayList<String>()
        arrayList.add("https://blogimages.musement.com/2019/11/Outlet-malls-in-America.jpeg")
        arrayList.add("https://s0.rbk.ru/v6_top_pics/media/img/2/25/756013859957252.jpg")
        arrayList.add("https://m.foolcdn.com/media/dubs/images/Intro_slide_-_Source_Getty.original.jpg")
        arrayList.add("https://avatars.mds.yandex.net/i?id=2e450c81d0da5c5ad635f0c1e591bad7_l-5880001-images-thumbs&n=13")
        arrayList.add("https://cdn.prod.www.spiegel.de/images/725ea6a0-9c7f-45cf-b29a-2e9a7b2b5005_w1280_r1.77_fpx42.66_fpy50.jpg")
        arrayList.add("https://avatars.mds.yandex.net/i?id=b364fe106f784fe261d7c4ec122bd82c_l-5419788-images-thumbs&n=13")
        vpAdapter = ViewPagerAdapter(arrayList, binding.vPager)

        binding.vPager.adapter = vpAdapter

        binding.vPager.offscreenPageLimit = 3
        binding.vPager.clipToPadding = false
        binding.vPager.clipChildren = false
        binding.vPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }


}