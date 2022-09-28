package id.inixindo.firstkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class ProductActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        // mengenali toolbar yang ada di layout
        val myToolbar = findViewById<Toolbar>(R.id.custom_toolbar_product)
        // mengakses object yang ada didalam myToolbar
        myToolbar.title = "Product List"
        myToolbar.subtitle = "Display All Products"
        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view)

        val modelList = readFromAsset();

        val adapter = ProductAdapter(modelList as ArrayList<Product>)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : ProductAdapter.ClickListener {
            override fun onClick(position: Int, iView: View) {
                Toast.makeText(
                    this@ProductActivity,
                    modelList.get(position).name,
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

    private fun readFromAsset(): List<Product> {
        val modelList = mutableListOf<Product>()
        val bufferedReader = application.assets.open("products.json").bufferedReader()
        val jsonString = bufferedReader.use {
            it.readText()
        }

        val jsonArray = JSONArray(jsonString)
        for (p in 0..jsonArray.length() - 1) {
            val jsonObject: JSONObject = jsonArray.getJSONObject(p)
            val model = Product(jsonObject.getString("name"), jsonObject.getString("price"))
            modelList.add(model)
        }
        return modelList
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        // super.onBackPressed()
        startActivity(Intent(applicationContext, MainActivity::class.java))
    }
}