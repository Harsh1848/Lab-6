package com.example.todoliist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.todoliist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var item: EditText
    private lateinit var itemsList: ListView
    private lateinit var addButton: Button
    private lateinit var itemList: ArrayList<String>
    private lateinit var itemAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemList = ArrayList<String>()
        itemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, itemList)
        itemsList.adapter = itemAdapter

        addButton.setOnClickListener {
            val newItem = item.text.toString().trim()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem)
                itemAdapter.notifyDataSetChanged()
                item.text.clear()
            }
        }

        itemsList.setOnItemClickListener { _, _, position, _ ->
            itemsList.setItemChecked(position, true)
        }

        itemsList.setOnItemLongClickListener { _, _, position, _ ->
            itemList.removeAt(position)
            itemAdapter.notifyDataSetChanged()
            true
        }
    }


}