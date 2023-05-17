package com.example.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.retrofitapplication.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter=ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FirstFragment(),"About Us")
        adapter.addFragment(SecondFragment(),"Gallery")
        adapter.addFragment(ThirdFragment(),"Contact Us")

        binding.viewPager.adapter=adapter
        binding.tbLayout.setupWithViewPager(binding.viewPager)
    }
    private fun navigateToHome() {
        val intent = Intent(this, LogoutActivity::class.java)
        intent.addFlags(
            Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        navigateToHome()
        return true
    }
}