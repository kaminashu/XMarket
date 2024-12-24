package www.uzmd.xmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import www.uzmd.xmarket.databinding.ItemProductBinding
import www.uzmd.xmarket.network.ShopDto

class RecAdapter(var list: List<ShopDto>,var onClik:(ShopDto)->Unit) : RecyclerView.Adapter<RecAdapter.VH>() {
    inner class VH(var itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {
        fun build(shopDto: ShopDto) {
            //Picasso.get().load(IMG + getItem(position).imageUrl).into(holder.binding.ivLogoCoin)
            Picasso.get().load(shopDto.suratId).into(itemProductBinding.productImg)
            itemProductBinding.productName.text = shopDto.name.toString()
            itemProductBinding.productImg.setOnClickListener {
                onClik.invoke(shopDto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.build(list[position])
    }

}