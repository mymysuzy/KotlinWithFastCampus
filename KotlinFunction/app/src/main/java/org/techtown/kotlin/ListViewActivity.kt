package org.techtown.kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        var carList = mutableListOf<Car>()

        for (i in 0..100) {
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
        }
        val adapter = ListViewAdapter(
            carList,
            LayoutInflater.from(this),
            this
        )

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }
}

class ListViewAdapter(
    val carList: MutableList<Car>,
    val layoutInflater: LayoutInflater,
    val context: Context
) : BaseAdapter() {
    // 전체 데이터의 크기(갯수)
    override fun getCount(): Int {
        return carList.size
    }

    // 전체 데이터 중에서 해당번째의 데이터를 리턴
    override fun getItem(position: Int): Any {
        return carList[position]
    }

    // 잘 사용하지 않음
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 해당번째 뷰를 리턴
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val holder: ViewHolder

        if(convertView == null){
            //재활용 불가능
            view = layoutInflater.inflate(R.layout.car_item, null)
            holder = ViewHolder()

            holder.carImg = view.findViewById(R.id.carImg)
            holder.nthCar = view.findViewById(R.id.nthCar)
            holder.nthEngine = view.findViewById(R.id.nthEngine)

            view.tag = holder
        }else{
            //재활용 가능
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        val car = carList[position]
        holder.carImg?.setImageDrawable(
            context.resources.getDrawable(R.drawable.ic_launcher_background, context.theme)
        )
        holder.nthCar?.text = car.nthCar
        holder.nthEngine?.text = car.nthEngine

//        val view = layoutInflater.inflate(R.layout.car_item, null)
//        val carImage = view.findViewById<ImageView>(R.id.carImg)
//        val nthCar = view.findViewById<TextView>(R.id.nthCar)
//        val nthEngine = view.findViewById<TextView>(R.id.nthEngine)
//
//        val car = carList[position]
//        carImage.setImageDrawable(
//            context.resources.getDrawable(R.drawable.ic_launcher_background, context.theme)
//        )
//
//        nthCar.text = car.nthCar
//        nthEngine.text = car.nthEngine

        return view
    }

}

class ViewHolder {
    var carImg : ImageView? = null
    var nthCar: TextView? = null
    var nthEngine: TextView? = null
}