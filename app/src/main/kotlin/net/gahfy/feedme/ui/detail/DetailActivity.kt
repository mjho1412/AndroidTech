package net.gahfy.feedme.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.gahfy.feedme.R

class DetailActivity : AppCompatActivity() {
    var title:String=""
    var body:String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val textView: TextView = findViewById<TextView>(R.id.textView)
        title=intent.getStringExtra("title")
        body=intent.getStringExtra("body")

        val actionBar = supportActionBar
        actionBar!!.title = title
        textView.text = body

    }
}
