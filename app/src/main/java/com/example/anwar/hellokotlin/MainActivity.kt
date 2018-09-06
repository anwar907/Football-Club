package com.example.anwar.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_lsit.layoutManager = LinearLayoutManager(this)
        club_lsit.adapter = RecyclerViewAdapter(this, items) {
            startActivity<Detail>("club" to it)
            toast("Sukses")
        }
    }
    private fun initData() {
        val image = resources.obtainTypedArray(R.array.club_image)
        val name = resources.getStringArray(R.array.club_name)
        val desc = resources.getStringArray(R.array.club_desc)

        items.clear()
        for (i in name.indices) {
            items.add(Item(image.getResourceId(i, 0), name[i], desc[i]))
        }
    }
}
