
package com.example.quanlycongviec

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlycongviec.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTaoCongViec.setOnClickListener {
            val tenCongViec =
                binding.edtTenCongViec.text.toString().trim()

            val moTa =
                binding.edtMoTa.text.toString().trim()

            if (tenCongViec.isEmpty()) {
                binding.edtTenCongViec.error =
                    "Vui long nhap ten cong viec"
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Da nhap cong viec: $tenCongViec",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnXemDanhSach.setOnClickListener {
            Toast.makeText(
                this,
                "Chuc nang danh sach se duoc bo sung",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}