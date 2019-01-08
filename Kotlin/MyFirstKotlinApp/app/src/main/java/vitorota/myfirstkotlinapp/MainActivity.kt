package vitorota.myfirstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)
    }

    fun toastMe(v: View) {
        val toast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countMe(v: View) {
        val countString = textView?.text.toString()

        var count: Int = countString.toInt()
        count++

        textView?.text = count.toString()
    }

    fun randomMe(v: View) {
        val randomIntent = Intent(this, SecondActivity::class.java)

        val countString = textView?.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        startActivity(randomIntent)
    }
}
