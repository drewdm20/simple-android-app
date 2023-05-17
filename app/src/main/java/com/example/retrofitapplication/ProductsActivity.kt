package com.example.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitapplication.databinding.ActivityLogoutBinding
import com.example.retrofitapplication.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun navigateToDashboard() {
        val intent = Intent(this, LogoutActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        navigateToDashboard()
        return true
    }
}