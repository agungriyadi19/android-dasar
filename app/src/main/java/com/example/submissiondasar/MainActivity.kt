package com.example.submissiondasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.submissiondasar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvThings: RecyclerView
    private lateinit var binding: ActivityMainBinding

    private val list = ArrayList<Things>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvThings = findViewById(R.id.rv_things)
        rvThings.setHasFixedSize(true)

        list.addAll(listThings)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private val listThings: ArrayList<Things>
        get() {
            val dataCountry = resources.getStringArray(R.array.data_country)
            val dataCapital = resources.getStringArray(R.array.data_capital)
            val dataCurrency = resources.getStringArray(R.array.data_currency)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val dataLanguage = resources.getStringArray(R.array.data_language)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val listThings = ArrayList<Things>()
            for (i in dataCountry.indices) {
                val things = Things(dataCountry[i], dataCapital[i], dataPhoto[i], dataCurrency[i], dataLanguage[i], dataDescription[i] )
                listThings.add(things)
            }
            return listThings
        }

    private fun showSelectedHero(things: Things) {
        Toast.makeText(this, "Kamu memilih " + things.country, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList() {
        rvThings.layoutManager = LinearLayoutManager(this)
        val listThingsAdapter = ListThingsAdapter(list)
        rvThings.adapter = listThingsAdapter
        listThingsAdapter.setOnItemClickCallback(object : ListThingsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Things) {
                showSelectedHero(data)
            }
        })
    }
}
