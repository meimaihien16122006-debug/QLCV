
package com.example.quanlycongviec

import android.content.Intent
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

        // Nut Tao cong viec
        binding.btnTaoCongViec.setOnClickListener {
            val tenCongViec =
                binding.edtTenCongViec.text.toString().trim()

            val moTa =
                binding.edtMoTa.text.toString().trim()

            if (tenCongViec.isEmpty()) {
                binding.edtTenCongViec.error =
                    "Vui long nhap ten cong viec"
                binding.edtTenCongViec.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(
                this,
                ChiTietCongViecActivity::class.java
            )

            intent.putExtra("TEN_CONG_VIEC", tenCongViec)
            intent.putExtra("MO_TA", moTa)

            startActivity(intent)
        }

        // Nut Xem danh sach cong viec
        binding.btnXemDanhSach.setOnClickListener {
            Toast.makeText(
                this,
                "Chuc nang danh sach se duoc bo sung",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}