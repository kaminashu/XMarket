package www.uzmd.xmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import www.uzmd.xmarket.databinding.ItemPagerBinding

class ViewPagerAdapter(var list: ArrayList<String>,var viewPager2: ViewPager2) : RecyclerView.Adapter<ViewPagerAdapter.VH>() {
    inner class VH(var itemPagerBinding: ItemPagerBinding) :
        RecyclerView.ViewHolder(itemPagerBinding.root) {
        fun build(photoLink: String) {
            Picasso.get().load(photoLink).into(itemPagerBinding.suratVp)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.build(list[position])
        if(position==list.size-1){
            viewPager2.post(runable)
        }
    }

    private var runable = Runnable {
        list.addAll(list)
        notifyDataSetChanged()
    }
}