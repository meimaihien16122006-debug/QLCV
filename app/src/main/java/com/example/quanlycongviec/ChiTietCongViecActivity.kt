
package com.example.quanlycongviec

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tvTenCongViec =
            findViewById<TextView>(R.id.tvTenCongViec)

        val tvMoTa =
            findViewById<TextView>(R.id.tvMoTa)

        val tenCongViec =
            intent.getStringExtra("TEN_CONG_VIEC") ?: ""

        val moTa =
            intent.getStringExtra("MO_TA") ?: ""

        tvTenCongViec.text = tenCongViec
        tvMoTa.text = moTa
    }
}