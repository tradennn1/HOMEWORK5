package com.tradennn1.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.tradennn1.homework5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count: Int = 0
    private var result: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnNext.setOnClickListener() {
                count++
                result = count.toString()
                binding.editText.setText(result)
                if (count == 10) {
                    btnNext.visibility = View.GONE
                    btnTwo.visibility = View.VISIBLE
                    btnTwo.setOnClickListener {
                        if (count != 0) {
                            count--
                            result = count.toString()
                            binding.editText.setText(result)
                        }
                        if (count == 0) {
                            btnTwo.text = "Красавчик"
                            if (btnTwo.toString() == "Красавчик")
                                showToast("jknkjnxcv")
                            val intent = Intent(this@MainActivity, SecondActivity::class.java)
                            intent.putExtra(Key.KEY_ONE, binding.editText.toString())
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    private fun showToast(s: String) {

    }
}

