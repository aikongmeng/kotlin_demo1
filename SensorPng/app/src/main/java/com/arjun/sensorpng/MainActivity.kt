package com.arjun.sensorpng

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import android.widget.TextView

/**
 * 本demo是为了求证两个问题：
 *
 * 1. 测试listView 局部刷新:
 * 获取到listView的 itemView 设置即可。
 * DEMO中仅仅是取了listview 的 一个 childView ，实际应用当中可能会根据position 去到itemView
 * 2. kotlin 试用
 * 方法都用 fun 类似的js fun
 * 定义变量 var 类似js 中var
 * 定义常量 val 类似js 中val
 * String  str ——> str:String   先写变量名后写变量的类型，之所以这么些，我想跟js 中推导类型有关
 * kotlin 中没有静态的概念，使用Java文件转kotlin文件，可以看到静态被加上了companion object
 * instance --> is
 * cast 强制类型转换 -->View as TextView
 *
 *
 *
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.textView)
        tv.text= "点击设置新数据"
        val listView = findViewById<View>(R.id.listView) as ListView
        val adapter = MyAdapter(this, getList())
        listView.adapter = adapter

        tv.setOnClickListener {
            tv.text = "已经设置新数据"
            val view = listView.getChildAt(2)
            adapter.notifyDataSetChanged()
             if(view.tag is MyAdapter.ViewHolder){
                (view.tag as MyAdapter.ViewHolder).hodlerTextView.text = "new data"
            }
        }
    }

    private fun getList(): ArrayList<String> {
        val list = arrayListOf("java", "kotlin", "c")
        for (i in 1..300) {
            list.add(i.toString())
        }
        return list
    }
}
