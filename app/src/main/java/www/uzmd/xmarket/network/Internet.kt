package www.uzmd.xmarket.network

//https://uzmd.uz/XSHOP/info.php
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Internet {
    fun getREtrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://uzmd.uz/").addConverterFactory(GsonConverterFactory.create()).build()
    }
}