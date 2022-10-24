//package org.techtown.kotlin
//
//import android.content.res.ColorStateList
//import android.graphics.Color
//import android.graphics.drawable.Drawable
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.Layout
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import java.util.zip.Inflater
//
//class RecyclerViewActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycler_view)
//
//        val carList = mutableListOf<Car>()
//
//        for (i in 0..100){
//            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
//        }
//
//        // Recyclerview에 adapter장착
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
//        // item과 view를 바인딩해둔 것을 layoutManager로 가로/세로 배치를 지정해줄 수 있다
//        recyclerView.layoutManager = LinearLayoutManager(this) // 세로배치
//        // recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) // 세로배치 또다른 버전
////        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true) // 여전히 세로배치이긴 하나 순서가 뒤바뀌어 나온다
////        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) // 가로 배치
//
//
//    }
//}
//
//// outer class
//class RecyclerViewAdapter(
//    var carList: MutableList<Car>,
//    var inflater: LayoutInflater
//): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
//
//    // inner class
//    // data를 채워줄 view 컴포넌트를 잡아둔다 -> carImage, nthCar, nthEngine
//    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//
//        val carImage : ImageView
//        val nthCar : TextView
//        val nthEngine : TextView
//
//        init {
//
//            carImage = itemView.findViewById(R.id.carImg)
//            nthCar = itemView.findViewById(R.id.nthCar)
//            nthEngine = itemView.findViewById(R.id.nthEngine)
//
//            itemView.setOnClickListener{
//                val position: Int = adapterPosition
//                val car = carList[position]
//            }
//
//        }
//
//    }
//
//    // item view를 리턴
//    // item 한 칸에서 사용될 xml을 inflate시킨다음 viewholder를 생성시킨 다음 리턴
//    16-Tablayout&Pager.txt        val view = inflater.inflate(R.layout.car_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    // data와 item view의 컴포넌트와 묶어주는 역할
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.carImage.setImageResource(R.drawable.ic_launcher_foreground)
//
//        holder.nthCar.text = carList[position].nthCar
//        holder.nthCar.setTextColor(Color.parseColor("#ffffff"))
//
//        holder.nthEngine.text = carList[position].nthEngine
//        holder.nthEngine.setTextColor(Color.parseColor("#ffffff"))
//
//    }
//
//    override fun getItemCount(): Int {
//        return carList.size
//    }
//
//}