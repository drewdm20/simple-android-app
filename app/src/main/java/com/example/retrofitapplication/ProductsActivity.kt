package com.example.retrofitapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofitapplication.databinding.ActivityLogoutBinding
import com.example.retrofitapplication.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PersonAdapter(Helper.defineDatas())

        binding.recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter = adapter

        binding.se.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

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

    fun filter(text: String) {
        val filteredCourseAry: ArrayList<Persons> = ArrayList()
        for (eachCourse in Helper.defineDatas()) {
            if (eachCourse.isim.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)
            }
        }
        adapter.filterList(filteredCourseAry);
    }
}