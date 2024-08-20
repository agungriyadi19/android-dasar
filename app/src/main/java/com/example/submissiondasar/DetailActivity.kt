package com.example.submissiondasar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionBar = supportActionBar
        actionBar?.title = "Detail"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvCountry: TextView = findViewById(R.id.tv_country)
        val tvLanguage: TextView = findViewById(R.id.tv_language)
        val tvCurrency: TextView = findViewById(R.id.tv_currency)
        val tvCapital: TextView = findViewById(R.id.tv_capital)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)

        val country  = intent.getStringExtra(EXTRA_COUNTRY)
        val photo = intent.getStringExtra(EXTRA_PHOTO)
        val capital = intent.getStringExtra(EXTRA_CAPITAL)
        val currency = intent.getStringExtra(EXTRA_CURRENCY)
        val desc = intent.getStringExtra(EXTRA_DESCRIPTION)
        val language = intent.getStringExtra(EXTRA_LANGUAGE)

        tvCountry.text = country
        Glide.with(this)
            .load(photo)
            .apply(RequestOptions())
            .into(imgPhoto)
        tvLanguage.text = language
        tvCurrency.text = currency
        tvCapital.text = capital
        tvDescription.text = desc
    }

    companion object {
        const val EXTRA_COUNTRY = "extra_country"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_CAPITAL = "extra_capital"
        const val EXTRA_CURRENCY = "extra_currency"
        const val EXTRA_LANGUAGE = "extra_language"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
