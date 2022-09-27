package id.inixindo.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // mengenali toolbar yang ada di layout
        val toolbarAbout = findViewById<Toolbar>(R.id.custom_toolbar_about)
        // mengakses object yang ada didalam myToolbar
        toolbarAbout.title = "About Page"
        toolbarAbout.navigationIcon = ContextCompat.getDrawable(this, R.drawable.icon_about)
        toolbarAbout.setNavigationOnClickListener {
            Toast.makeText(applicationContext, "About is clicked", Toast.LENGTH_LONG).show()
        }

        setSupportActionBar(toolbarAbout)
    }
}