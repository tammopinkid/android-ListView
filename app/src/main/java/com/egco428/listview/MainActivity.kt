package com.egco428.listview

import android.app.ListActivity
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : ListActivity() {


    var mobileList = arrayOf("Samsung", "Apple", "Nokia", "LG", "Oppo", "HTC", "Asus", "Vivo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter = myCustomAdapter(this)
//        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,mobileList)
//        listAdapter = adapter
    }
}

    private class myCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context
        private val names = arrayListOf<String>("Samsung", "Apple", "Nokia", "LG", "Oppo", "HTC", "Asus", "Vivo")
        private val detail = arrayListOf<String>("Samsung", "Apple", "Nokia", "LG", "Oppo", "HTC", "Asus", "Vivo")

        init {
            mContext = context
        }

        override fun getItem(position: Int): Any {
            return names[position]
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val whiteColor = Color.parseColor("FFFFFF")
            val greyColor = Color.parseColor("#E0E0E0")
            val rowMain: View

            if (convertView == null) {
                val layoutInflator = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflator.inflate(R.layout.row_main, ViewGroup, false)
                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textView, rowMain.row_imageView)
                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            Log.d("Result", "Load name_textView")
            viewHolder.nameTextView.text = names.get(position)

            Log.d("Result", "Load position_textView")
            viewHolder.positionTextView.text = "Row number : $position"

            if (position % 2 == 1) {
                rowMain.setBackgroundColor(greyColor)
                rowMain.row_imageView.setImaggeResorce(R.drawable.sumikko1)
            } else {
                rowMain.setBackgroundColor(whiteColor)
                rowMain.row_imageView.setImaggeResorce(R.drawable.sumikko2)
            }
        }
    }
    private class ViewHolder(val nameTextView: TextView)
}
