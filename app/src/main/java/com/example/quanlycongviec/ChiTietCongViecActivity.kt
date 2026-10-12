package com.example.quanlycongviec

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvTenCongViec: TextView
    private lateinit var tvMoTa: TextView

    private var tenCongViec = ""
    private var moTa = ""

    private val suaCongViecLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data

                tenCongViec =
                    data?.getStringExtra("TEN_CONG_VIEC") ?: tenCongViec

                moTa = data?.getStringExtra("MO_TA") ?: moTa

                capNhatGiaoDien()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTa)

        val btnChinhSua = findViewById<Button>(R.id.btnChinhSua)

        tenCongViec = intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        moTa = intent.getStringExtra("MO_TA") ?: ""

        capNhatGiaoDien()

        btnChinhSua.setOnClickListener {
            val intentSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentSua.putExtra("TEN_CONG_VIEC", tenCongViec)
            intentSua.putExtra("MO_TA", moTa)

            suaCongViecLauncher.launch(intentSua)
        }
    }

    private fun capNhatGiaoDien() {
        tvTenCongViec.text = tenCongViec
        tvMoTa.text = moTa
    }
}