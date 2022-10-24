package org.techtown.kotlin

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val backgroundTask = BackgroundAsyncTask(
            findViewById(R.id.progressBar),
            findViewById(R.id.progressBarText)
        )

        findViewById<TextView>(R.id.start).setOnClickListener {
            backgroundTask.execute()
        }

        findViewById<TextView>(R.id.stop).setOnClickListener {
            backgroundTask.cancel(true)
        }
    }
}



class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
): AsyncTask<Int,Int,Int>(){
    // AsynceTask<Params, Progress, Result>
// Params : doInbackground에서 사용할 타입
// Progress : onProgressUpdate에서 사용할 타입
// Result : onPostExecute에서 사용할 타입

    // 코루틴 -> 특정 기능을 뭉쳐서 만든 기능

    var percent: Int = 0


    // forground : 사용자 눈에 보이는 작업
    // background : 사용자 눈에 보이지 않는 작업

    // background에서 작업하고 싶은 코드를 작성
    override fun doInBackground(vararg p0: Int?): Int {
        while(!isCancelled()){
            percent++
            if(percent > 100) break
            else{
                publishProgress(percent)
            }
            Thread.sleep(100)
        }
        return percent
    }

    // BackgroundAsyncTask를 실행하기 전에 실행해주고 싶은 코드를 작성
    override fun onPreExecute() {
        percent = 0
        progressBar.progress = percent

        super.onPreExecute()
    }

    // BackgroundAsyncTask를 다 실행한 후 실행해주고 싶은 코드를 생성
    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        progressText.text = "작업이 완료되었습니다"
    }

    // 진행중에 업데이트 하고 싶은 부분이 있으면 코드를 생성
    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        progressBar.setProgress(values[0] ?: 0)
        progressText.text = "퍼센트 : " + values[0]
    }

    //BackgroundAsyncTask 작업이 멈추었을 때 실행해주고 싶은 코드를 생성
    override fun onCancelled() {
        super.onCancelled()

        progressBar.progress = 0
        progressText.text = "작업이 취소되었습니다"
    }

}