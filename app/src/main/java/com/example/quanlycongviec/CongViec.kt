
package com.example.quanlycongviec

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: String
) {
    fun layThongTin(): String {
        return "Ten cong viec: $tenCongViec\n" +
                "Mo ta: $moTa\n" +
                "Trang thai: $trangThai"
    }
}