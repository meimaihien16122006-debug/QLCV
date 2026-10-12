
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
    private lateinit var tvTrangThai: TextView

    private lateinit var btnChinhSua: Button
    private lateinit var btnHoanThanh: Button

    private var congViec = CongViec("", "", "Chua hoan thanh")

    private val suaCongViecLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data

                congViec.tenCongViec =
                    data?.getStringExtra("TEN_CONG_VIEC")
                        ?: congViec.tenCongViec

                congViec.moTa =
                    data?.getStringExtra("MO_TA")
                        ?: congViec.moTa

                capNhatGiaoDien()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvTenCongViec = findViewById(R.id.tvTenCongViec)
        tvMoTa = findViewById(R.id.tvMoTa)
        tvTrangThai = findViewById(R.id.tvTrangThai)

        btnChinhSua = findViewById(R.id.btnChinhSua)
        btnHoanThanh = findViewById(R.id.btnHoanThanh)

        congViec.tenCongViec =
            intent.getStringExtra("TEN_CONG_VIEC") ?: ""

        congViec.moTa =
            intent.getStringExtra("MO_TA") ?: ""

        capNhatGiaoDien()

        btnChinhSua.setOnClickListener {
            val intentSua = Intent(
                this,
                ChinhSuaCongViecActivity::class.java
            )

            intentSua.putExtra(
                "TEN_CONG_VIEC",
                congViec.tenCongViec
            )

            intentSua.putExtra(
                "MO_TA",
                congViec.moTa
            )

            suaCongViecLauncher.launch(intentSua)
        }

        btnHoanThanh.setOnClickListener {
            congViec.trangThai = "Da hoan thanh"
            capNhatGiaoDien()
        }
    }

    private fun capNhatGiaoDien() {
        tvTenCongViec.text = congViec.tenCongViec
        tvMoTa.text = congViec.moTa

        tvTrangThai.text =
            "Trang thai: ${congViec.trangThai}"

        congViec.layThongTin()

        if (congViec.trangThai == "Da hoan thanh") {
            btnHoanThanh.isEnabled = false
            btnHoanThanh.text = "Da hoan thanh"
        } else {
            btnHoanThanh.isEnabled = true
            btnHoanThanh.text = "Danh dau hoan thanh"
        }
    }
}