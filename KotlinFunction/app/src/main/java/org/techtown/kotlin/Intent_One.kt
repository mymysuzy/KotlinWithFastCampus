package org.techtown.kotlin

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import org.techtown.kotlin.R

class Intent_One : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        // 1.
        // 암시적 인텐트  -->> 사진첩, 전화 기능 이외에는 그다지 잘 사용하지 않는다
        // - 전화, SMS, Google Play Store, Website, GoogleMap, 사진첩, 등등
        //  - 상수
        //      - 변하지 않는 수(문자)
        //      - 상수의 변수명은 전부 대분자로 만드는 문화가 있다
        //  - URI (Uniform Resource Indentifier)
        //      - id라고 생각을 하면 된다 -> 고유하다
        //      - 자원을 나타내는 고유한 주소
        //      - URL
        //          - 인터넷 페이지의 고유한 주소
        val implicit_intent: TextView = findViewById(R.id.implicit_intent)

        implicit_intent.setOnClickListener {
            val intent: Intent = Intent(
                Intent.ACTION_DIAL, // ACTION_DIAL : 암시적 Intent의 종류 중 하나. 이것 외에도 아주 많다.
                Uri.parse("tel:" + "010-1111-1111")
            )
            // intent를 실행하기 위한 매서드
            startActivity(intent)
        }

        // 2.
        // 명시적 인텐트 1
        // 이 방법은 사용하지 않음

        // 명시적 인텐트는 Activity를 전환시키는 즉, 화면을 전환하는 역할을 한다

        // 명시적 인텐트 + ComponentName -> 엑티비티 전환
        val intent_one: TextView = findViewById(R.id.intent_one)

        intent_one.setOnClickListener {
            val intent: Intent = Intent()
//            val componentName: ComponentName = ComponentName(
//                "org.techtown.kotlin",
//                "org.techtown.kotlin.Intent_Two"
//            )
            val componentName: ComponentName = ComponentName(
                this,
                Intent_Two::class.java
            )
            intent.component = componentName

            startActivity(intent)
        }

        // 3.
        // 명시적 인텐트 2
        // 이 방법으로 명시적 인텐트 이용하자


        // 명시적 인텐트  -> 엑티비티 전환
        // Context
        //  - 문맥
        // A엑티비티 -> B엑티비티

//        val intent_two_value : TextView = findViewById(R.id.intent_two)
//        (intent_two_value).apply {

        (findViewById<TextView>(R.id.intent_two)).apply {

            this.setOnClickListener {
                startActivity(
                    Intent(this@Intent_One, Intent_Two::class.java) // (출발지, 목적지)
                )
            }
        }

        // 4.
        // 명시적 인텐트 + data 전달
        (findViewById<TextView>(R.id.intent_three)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                // 데이터 넣어주는 메서드 putExtra(key, value)
                intent.putExtra("extra-data", "data")
                startActivity(intent)
            }
        }

        // 5-1.
        // 명시적 인텐트 + 결과 받기
        // startActivityForResult() 그리고 onActivityResult를 이용하여 결과를 받음
        (findViewById<TextView>(R.id.intent_four)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                // 결과를 받기 위한 메서드는 startActivityForResult()
                startActivityForResult(intent, 1)
                // requestCode
                // - 구분을 하기 위해서
                // - Intent_One -> Intent_Two (request 1)
                // - Intent_One -> Intent_Three (request 2)
                // - Intent_One -> Intent_Four (request 3)
            }
        }

        // 5-2
        // 명시적 인텐트 + 결과 받기 ActivityResult API사용한 버전
        // -> RequestCode가 없다
        //    즉, reqeustCode없이도 요청자를 구분할 수 있다

        // startActivity가 아닌 startActivityLauncher 즉, 런처를 직접 만들어주자

        // -> deprecated된 startActivityForResult보단 이 방식을 사용하자

        // ActivityResultLauncher : 액티비티를 실행시키는 클래스
        val startActivityLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                // onActivityResult에 해당하는 부분

                // resultcode, requestcode 모두 it 안에 들어있다
                when (it.resultCode) {
                    RESULT_OK -> {
                        Log.d("dattaa", it.data?.extras?.getString("result")!!)
                    }
                }


            }
        (findViewById<TextView>(R.id.intent_five)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                startActivityLauncher.launch(intent)
            }


        }

        // 명시적 인텐트 + 이미지 URI 전달
        (findViewById<TextView>(R.id.intent_six)).apply {
            this.setOnClickListener{
                val intent = Intent(this@Intent_One, Intent_Two::class.java).apply {
                    val imgURI = Uri.parse("android.resource://" + packageName + "/drawable/" + "calculator_bg")

                    // 이미지를 보낼 때 필요한 절차들! 외울필요X
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imgURI)
                    // 모든 이미지 파일 종류를 말함
                    this.setType("image/*")
                }
                startActivity(intent)
            }
        }
    }


    // resultcode : status code
    // - 최종결과 : 성공 or 실패
    // ex) 404 NOT FOUND

    // 모든 intent가 한 곳에서 처리되기 때문에 구분이 필요하다
    // 반면 ActivityResult API는 각각의 intent가 처리되는 곳이 별도로 있어 구분이 필요없다
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            1 -> {
                when (resultCode) {
                    RESULT_OK -> {
                        val data: String? = data?.extras?.getString("result")
                        Log.d("dattaa", data!!)
                    }
                }
            }
            2 -> {

            }
        }

    }
}

