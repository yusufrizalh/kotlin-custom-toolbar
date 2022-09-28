package id.inixindo.firstkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ContactActivity : AppCompatActivity() {

    // var bottomNavigation: BottomNavigationView? = null
    lateinit var bottomNavigation: BottomNavigationView

    private fun openFragment(fragment: Fragment) {
        val openFragment = supportFragmentManager.beginTransaction()
        openFragment.replace(R.id.bottom_container, fragment)
        openFragment.addToBackStack(null)
        openFragment.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val myToolbarContact = findViewById<Toolbar>(R.id.custom_toolbar_contact)
        myToolbarContact.title = "Contact Page with Back Button"
        myToolbarContact.subtitle = "Please contact us"
        setSupportActionBar(myToolbarContact)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        openFragment(HomeFragment())    // fragment yang pertama kali dibuka
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    openFragment(HomeFragment())
                    true
                }
                R.id.bottom_chat -> {
                    openFragment(ChatFragment())
                    true
                }
                R.id.bottom_account -> {
                    openFragment(AccountFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}