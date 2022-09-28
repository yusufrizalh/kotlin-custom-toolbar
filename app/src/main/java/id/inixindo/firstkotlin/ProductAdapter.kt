package id.inixindo.firstkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var list: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.activity_card_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolder).binding(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        val productName = itemView.findViewById<TextView>(R.id.txtViewProductName)
        val productPrice = itemView.findViewById<TextView>(R.id.txtViewProductPrice)
        fun binding(model: Product): Unit {
            productName.text = model.name
            productPrice.text = model.price
        }

        override fun onClick(v: View?) {
            myClickListener.onClick(adapterPosition, itemView)
        }

    }

    lateinit var myClickListener: ClickListener

    interface ClickListener {
        fun onClick(position: Int, iView: View)
    }

    fun setOnItemClickListener(iClickListener: ClickListener) {
        myClickListener = iClickListener
    }
}
