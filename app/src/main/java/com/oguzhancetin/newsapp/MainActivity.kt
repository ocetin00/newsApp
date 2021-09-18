package com.oguzhancetin.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.oguzhancetin.newsapp.databinding.ActivityMainBinding
import com.oguzhancetin.newsapp.databinding.FragmentOneBinding
import com.oguzhancetin.newsapp.fragment.FragmentOne
import com.oguzhancetin.newsapp.fragment.FragmentThre
import com.oguzhancetin.newsapp.fragment.FragmentTwo

class MainActivity : AppCompatActivity(), CallBackListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentOne>(binding.fragmentOneContainer.id)
                add<FragmentTwo>(binding.fragmentTwoContainer.id)
                add<FragmentThre>(binding.fragmentThreeContainer.id)
            }
        }

    }

    override fun onClick(fragment: Fragment) {
        Toast.makeText(fragment.requireContext(), "${fragment.id}", Toast.LENGTH_SHORT).show()
    }
    private fun clearFragments(){

    }
}

interface CallBackListener{
    fun onClick(fragment: Fragment)
}