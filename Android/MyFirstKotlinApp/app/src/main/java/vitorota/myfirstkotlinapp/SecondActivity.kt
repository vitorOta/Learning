package vitorota.myfirstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    fun showRandomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        val random = Random()
        var randomInt = if (count > 0) random.nextInt(count + 1) else 0

        findViewById<TextView>(R.id.textview_random).text = "" + randomInt

        findViewById<TextView>(R.id.textview_label).text = getString(R.string.random_heading,count)

    }


    companion object {
        const val TOTAL_COUNT = "total_count"
    }

}
