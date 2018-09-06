package com.example.anwar.hellokotlin


import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.e
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val position = intent.getIntExtra("club", -1)

        val name = resources.getStringArray(R.array.club_name).getOrElse(position, { "" })
        val image = resources.obtainTypedArray(R.array.club_image).getResourceId(position, 0)
        val desc = resources.getStringArray(R.array.club_desc).getOrElse(position, { "" })

        e("club", desc)
        DetailUI(name, image, desc).setContentView(this)
    }

    class DetailUI(val nama: String, val gambar: Int, val desc: String) : AnkoComponent<com.example.anwar.hellokotlin.Detail> {


        override fun createView(ui: AnkoContext<Detail>) = with(ui) {
            verticalLayout {
                lparams(wrapContent, wrapContent)

                imageView {
                    Glide.with(this.context).load(gambar).into(this)
                    Gravity.CENTER
                }.lparams(width = dip(150), height = dip(150)) {
                    gravity = Gravity.CENTER
                }
                textView {
                    text = nama
                    textSize = 24f
                    setTypeface(null, Typeface.BOLD)
                }.lparams {
                    gravity = Gravity.CENTER
                }
                textView {
                    text = desc
                    textSize = 16f
                }.lparams {
                    gravity = Gravity.CENTER_HORIZONTAL
                    rightMargin = dip(10)
                    leftMargin = dip(10)
                }
            }

        }
    }
}

