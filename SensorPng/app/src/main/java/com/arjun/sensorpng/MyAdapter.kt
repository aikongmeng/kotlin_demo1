package com.arjun.sensorpng

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context, var list: ArrayList<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder? = null
        var view: View
        if (convertView == null) {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder?
        }
        var item = getItem(position)
        viewHolder?.hodlerTextView?.setText(item.toString())
        return view

    }


    override fun getItem(position: Int): Any {

        return list!!.get(position);
    }

    override fun getItemId(position: Int): Long {

        return position.toLong();
    }

    override fun getCount(): Int {
        return list!!.size;
    }


    class ViewHolder(viewItem: View) {
        var hodlerTextView: TextView = viewItem.findViewById(R.id.item_txt) as TextView
    }

}


