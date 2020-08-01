package com.erwin.tugaskotlin1

class Binatang {
    var nama: String? = null
    var deskripsi: String? = null
    var gambar: Int? = null
    var BarisGenap: Boolean? = null

    constructor(nama: String?, deskripsi: String?, gambar: Int?, genap: Boolean?) {
        this.nama = nama
        this.deskripsi = deskripsi
        this.gambar = gambar
        this.BarisGenap = genap
    }
}