package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class Homework_1 : AppCompatActivity() {

    // 변수들을 이 코틀린 파일 전체에서 사용하기 위해 onCreate전에 선언.
    // 그런데 초기화해줘야하니까 lateinit 사용
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView

    lateinit var ca: TextView
    lateinit var plus: TextView
    lateinit var equal: TextView

    lateinit var result: TextView

    var input: String = ""
    var temp: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework1) // 이 작업이 끝나야 View가 그려지는 작업이 끝나는 것. 이 코드 이후에 findById를 사용해 View를 찾아야 한다.

        findViews() // 이제 View를 찾아주자
        setNumberTextViewListener()

        ca.setOnClickListener {
            input = ""
            temp = ""
            result.text = "0"
        }
        plus.setOnClickListener {
            temp = result.text.toString()
            input = ""
        }
        equal.setOnClickListener {
            val finalResult: String = (input.toInt() + temp.toInt()).toString()
            result.text = finalResult
            temp = finalResult
        }

    }

    fun setNumberTextViewListener() {
        val numberTextViewList: List<TextView> = listOf(
            one, two, three, four, five, six, seven, eight, nine, zero
        )
        val listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                input += (p0 as TextView).text
                result.text = input
            }
        }
        numberTextViewList.forEach { it.setOnClickListener(listener) }
    }

    fun findViews() {
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        ca = findViewById(R.id.ca)
        result = findViewById(R.id.result)
    }


}