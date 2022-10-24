package org.techtown.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentManager = supportFragmentManager
        val fragmentFirst = FragmentFirst()


        // Transaction
        // :: 작업의 단위 -> 시작과 끝이 있다

        // Commit의 종류

        // 1) commit
        // 2) commitAllowingStateLoss
        // 3) commitNot
        // 4) commitNowAllowingStateLoss

        (findViewById<TextView>(R.id.add)).setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            
            transaction.replace(R.id.root, fragmentFirst)
            transaction.commit() // commit :: 끝을 의미



        }

        (findViewById<TextView>(R.id.remove)).setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()


        }
    }
}