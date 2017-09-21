package com.egco428.listview

import android.app.ListActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class MainActivity : ListActivity() {

    var mobileList = arrayOf("Samsung","Apple","Nokia","LG","Oppo","HTC","Asus","Vivo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,mobileList)
        listAdapter = adapter
    }
}
