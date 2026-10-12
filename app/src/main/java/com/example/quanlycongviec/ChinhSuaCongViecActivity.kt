
package com.example.quanlycongviec

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var edtTen: EditText
    private lateinit var edtMoTa: EditText
    private lateinit var btnLuu: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        edtTen = findViewById(R.id.edtTenCongViecSua)
        edtMoTa = findViewById(R.id.edtMoTaSua)
        btnLuu = findViewById(R.id.btnLuu)

        // Hien thi du lieu cu
        edtTen.setText(
            intent.getStringExtra("TEN_CONG_VIEC") ?: ""
        )

        edtMoTa.setText(
            intent.getStringExtra("MO_TA") ?: ""
        )

        // Luu thay doi va tra ket qua ve man hinh chi tiet
        btnLuu.setOnClickListener {
            val tenCongViec = edtTen.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            if (tenCongViec.isEmpty()) {
                edtTen.error = "Vui long nhap ten cong viec"
                edtTen.requestFocus()
                return@setOnClickListener
            }

            val ketQua = intent.apply {
                putExtra("TEN_CONG_VIEC", tenCongViec)
                putExtra("MO_TA", moTa)
            }

            setResult(Activity.RESULT_OK, ketQua)
            finish()
        }
    }
}