package id.inixindo.firstkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

        // mengelola tab layout dan view pager
        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabs)
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#008080"))

        // mengkoneksikan antara tablayout dengan viewpager sesuai posisinya
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(tab_titles[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    companion object {
        private val tab_titles = intArrayOf(
            R.string.tab1, R.string.tab2, R.string.tab3
        )
    }
}