package www.uzmd.xmarket.network

import retrofit2.http.GET

interface ShopService {
    @GET("XSHOP/info.php")
    suspend fun getProduct():ArrayList<ShopDto>
}