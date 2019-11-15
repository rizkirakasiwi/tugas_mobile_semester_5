package com.kuhaku.tugasmobile.menu.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuhaku.tugasmobile.R
import com.kuhaku.tugasmobile.data.menu
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.menu_child.view.*
import kotlinx.android.synthetic.main.profile.view.*
import kotlinx.android.synthetic.main.recycler_menu_icon.view.*

class ProfileAdapter:Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.profile
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.img_profile.setImageResource(R.drawable.profile)
        viewHolder.itemView.txt_nama.text = "Rizki Rakasiwi"
        viewHolder.itemView.txt_nim.text = "17184065"
    }
}


class MenuIcon(val iconData : List<menu>):Item<GroupieViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.recycler_menu_icon
    }
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.recycler_menu_icon.layoutManager = GridLayoutManager(
            viewHolder.itemView.context,
            4, GridLayoutManager.
                VERTICAL,
            false
        )

        viewHolder.itemView.recycler_menu_icon.adapter = iconAdapter(iconData)

    }
}

class iconAdapter(val iconData : List<menu>):RecyclerView.Adapter<IconViewHolder>(){
    override fun getItemCount(): Int {
        return iconData.count()
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        val view = holder.itemView
        view.img_icon_menu.setImageResource(iconData[position].image)
        view.txt_nama_icon.text = iconData[position].nama
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        return IconViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.menu_child, parent, false)
        )
    }
}


class IconViewHolder(view:View):RecyclerView.ViewHolder(view)
