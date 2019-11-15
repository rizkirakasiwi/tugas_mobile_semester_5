package com.kuhaku.tugasmobile.menu

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuhaku.tugasmobile.R
import com.kuhaku.tugasmobile.data.menu
import com.kuhaku.tugasmobile.menu.Adapter.MenuIcon
import com.kuhaku.tugasmobile.menu.Adapter.ProfileAdapter
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.menu_fragment.*


class Menu : Fragment() {

    companion object {
        fun newInstance() = Menu()
    }

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        val grupAdapter = GroupAdapter<GroupieViewHolder>()

        val icon = resources.obtainTypedArray(R.array.image_icon)
        val nama_icon = resources.getStringArray(R.array.nama_icon)
        val menu_depan = arrayListOf<menu>()
        for (i in nama_icon.indices){
            menu_depan.add(menu(nama_icon[i], icon.getResourceId(i, 0)))
        }
        grupAdapter.add(ProfileAdapter())
        grupAdapter.add(MenuIcon(menu_depan))
        recycler_menu.layoutManager = LinearLayoutManager(this.context)
        recycler_menu.adapter = grupAdapter
    }

}
