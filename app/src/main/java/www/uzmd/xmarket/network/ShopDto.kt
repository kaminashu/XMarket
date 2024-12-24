package www.uzmd.xmarket.network

import com.google.gson.annotations.SerializedName

data class ShopDto(

	@field:SerializedName("surat_id")
	val suratId: String? = null,

	@field:SerializedName("batafsil")
	val batafsil: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("narx")
	val narx: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
