package org.techtown.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        
        var carList = mutableListOf<Car>()
        for(i in 0..10){
            // "" + Int -> String값
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
        }

        val container = findViewById<LinearLayoutCompat>(R.id.container)
        val inflater = LayoutInflater.from(this@AddViewActivity)

        carList.forEach {
            val carItemView = inflater.inflate(R.layout.car_item, null)
            val carImg = carItemView.findViewById<ImageView>(R.id.carImg)
            val nthCar = carItemView.findViewById<TextView>(R.id.nthCar)
            val nthEngine = carItemView.findViewById<TextView>(R.id.nthEngine)

            carImg.setImageDrawable(resources.getDrawable(R.drawable.ic_launcher_background, this.theme))
            nthCar.text = it.nthCar
            nthEngine.text = it.nthEngine

            container.addView(carItemView)

        }
    }
}

class Car(val nthCar: String, val nthEngine: String){

}