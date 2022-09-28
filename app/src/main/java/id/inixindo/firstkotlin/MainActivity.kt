package id.inixindo.firstkotlin

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mengenali toolbar yang ada di layout
        val myToolbar = findViewById<Toolbar>(R.id.custom_toolbar)
        // mengakses object yang ada didalam myToolbar
        myToolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.icon_menu)
        myToolbar.title = "My Custom Toolbar"
        myToolbar.subtitle = "Learn Android Kotlin at Inixindo"

        myToolbar.setNavigationOnClickListener {
            openSimpleDialog()
        }

        setSupportActionBar(myToolbar)

        val btnSimpleDialog = findViewById<Button>(R.id.button_simple_dialog)
        btnSimpleDialog.setOnClickListener {
            openSimpleDialog()
        }
    }

    private fun openSimpleDialog() {
        val openDialog = AlertDialog.Builder(this)
        with(openDialog) {
            setTitle("Simple Dialog")
            setMessage("This is very simple alert dialog")
            setCancelable(false)
            setNeutralButton("Neutral", null)
            setPositiveButton("Positive", null)
            setPositiveButtonIcon(resources.getDrawable(R.drawable.icon_home, theme))
            setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))
        }
        val alertDialog = openDialog.create()
        alertDialog.show()
        val buttonNeutral = alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL)
        with(buttonNeutral) {
            setBackgroundColor(Color.parseColor("#FF0000"))
            setTextColor(Color.WHITE)
        }
    }

    // mengakses options menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return true
    }

    // jika salah satu option menu dipilih
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_search -> {
                Toast.makeText(applicationContext, "Search is clicked", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item_about -> {
                Toast.makeText(applicationContext, "About is clicked", Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext, AboutActivity::class.java))
                true
            }
            R.id.item_contact -> {
                Toast.makeText(applicationContext, "Contact is clicked", Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext, ContactActivity::class.java))
                true
            }
            R.id.item_setting -> {
                Toast.makeText(applicationContext, "Setting is clicked", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item_products -> {
                startActivity(Intent(applicationContext, ProductActivity::class.java))
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}