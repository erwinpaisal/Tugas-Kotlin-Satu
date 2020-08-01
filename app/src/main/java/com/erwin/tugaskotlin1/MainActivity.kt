package com.erwin.tugaskotlin1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_list.view.imgGambarBinatang
import kotlinx.android.synthetic.main.item_list.view.txtDesc
import kotlinx.android.synthetic.main.item_list.view.txtNama
import kotlinx.android.synthetic.main.item_list_genap.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAbout = findViewById<ImageButton>(R.id.toolbarAbout)
        btnAbout.setOnClickListener(this)

        listBinatang.add(
            Binatang("Kucing", "Saat ini, kucing adalah salah satu hewan peliharaan terpopuler di dunia. Kucing yang garis keturunannya tercatat secara resmi sebagai kucing trah atau galur murni (pure breed), seperti persia, siam, manx, dan sphinx. Kucing seperti ini biasanya dibiakkan di tempat pemeliharaan hewan resmi. Jumlah kucing ras hanyalah 1% dari seluruh kucing di dunia, sisanya adalah kucing dengan keturunan campuran seperti kucing liar atau kucing kampung.", R.drawable.poto1, false)
        )
        listBinatang.add(
            Binatang("Anjing", "Anjing adalah mamalia yang telah mengalami domestikasi dari serigala sejak 15.000 tahun yang lalu, bahkan kemungkinan sudah sejak 100.000 tahun yang lalu berdasarkan bukti genetik berupa penemuan fosil dan tes DNA. Penelitian lain mengungkap sejarah domestikasi anjing yang belum begitu lama.", R.drawable.poto2, true)
        )
        listBinatang.add(
            Binatang("Kelinci", "Kelinci adalah hewan mamalia dari famili Leporidae, yang dapat ditemukan di banyak bagian bumi. Kelinci berkembangbiak dengan cara beranak yang disebut vivipar. Dulunya, hewan ini adalah hewan liar yang hidup di Afrika hingga ke daratan Eropa. Pada perkembangannya, tahun 1912, kelinci diklasifikasikan dalam ordo Lagomorpha. Ordo ini dibedakan menjadi dua famili, yakni Ochtonidae (jenis pika yang pandai bersiul) dan Leporidae (termasuk di dalamnya jenis kelinci dan terwelu).", R.drawable.poto3, false)
        )
        listBinatang.add(
            Binatang("Monyet", "Monyet adalah istilah untuk semua anggota primata yang bukan prosimia (pra-kera, seperti lemur dan tarsius) atau kera, baik yang tinggal di Dunia Lama maupun Dunia Baru. Hingga saat ini dikenal 264 jenis monyet yang hidup di dunia. Tidak seperti kera, monyet biasanya berekor dan berukuran lebih kecil. Monyet diketahui dapat belajar dan menggunakan alat untuk membantunya dalam mendapatkan makanan.", R.drawable.poto4, true)
        )
        listBinatang.add(
            Binatang("Singa", "Singa (bahasa Sanskerta: Siṃha, atau dalam bahasa Latin: Panthera leo) adalah spesies hewan dari keluarga felidae atau jenis kucing. Singa merupakan hewan yang hidup berkelompok. Biasanya terdiri dari seekor jantan dan banyak betina. Kelompok ini menjaga daerah kekuasaannya. Umur singa antara 10 sampai 15 tahun di alam bebas, tetapi dalm penangkaran memungkinkan lebih dari 20 tahun.", R.drawable.poto5, false)
        )
        listBinatang.add(
            Binatang("Buaya", "Assalamualaikum Ukhti", R.drawable.poto6, true)
        )
        listBinatang.add(
            Binatang("Kudanil", "Kudanil memiliki tubuh yang besar dan berat, serta kulit kelabu gelap. Mereka juga memiliki gading besar yang biasa mereka gunakan untuk mempertahankan diri dari predator. Kuda nil memiriki ciri khas tubuh yang besar, mulut dan gigi yang sangat besar, empat kaki yang pendek dan gemuk, serta badan yang hampir tidak berambut.", R.drawable.poto7, false)
        )
        listBinatang.add(
            Binatang("Jerapah", "Jerapah atau zarafah (nama ilmiah: Giraffa camelopardalis) adalah mamalia berkuku genap endemik Afrika dan merupakan spesies hewan tertinggi yang hidup di darat. Jerapah jantan dapat mencapai tinggi 4,8 sampai 5,5 meter dan memiliki berat yang dapat mencapai 1.360 kilogram. Jerapah betina biasanya sedikit lebih pendek dan lebih ringan.", R.drawable.poto8, true)
        )
        listBinatang.add(
            Binatang("Kura-Kura", "Kura-kura adalah hewan bersisik berkaki empat yang termasuk golongan reptil. Bangsa hewan yang disebut (ordo) Testudinata (atau Chelonians) ini khas dan mudah dikenali dengan adanya ‘rumah’ atau batok (bony shell) yang keras dan kaku.", R.drawable.poto9, false)
        )
        listBinatang.add(
            Binatang("Zebra", "Zebra adalah binatang dari famili kuda yang tubuhnya berbelang-belang hitam dan putih. Habitat hewan ini tersebar di Afrika Selatan, Afrika Barat, dan Afrika Timur. Ada tiga jenis zebra yaitu zebra gunung (Equus zebra), zebra dataran (Equus quagga) dan zebra primitif (Equus grevyi).", R.drawable.poto10, true)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter
    }

    inner class AdapterBinatang: BaseAdapter {
        var listBinatang = ArrayList<Binatang>()
        var context: Context?=null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>) : super() {
            this.listBinatang = listOfAnimals
            this.context = context
        }

        

        override fun getView(p0: Int, pl: View?, p3: ViewGroup?): View {
            val binatang = listBinatang[p0]
            if (binatang.BarisGenap == true) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator  .inflate(R.layout.item_list_genap, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource (binatang.gambar!!)
                myView.weku.setOnClickListener{

                    val intent = Intent (context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }else{
                val binatang = listBinatang[p0]
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as
                        LayoutInflater
                var myView = inflator.inflate(R.layout.item_list, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imgGambarBinatang.setImageResource(binatang.gambar!!)
                myView.weku2.setOnClickListener{

                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)

                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listBinatang[p0]
        }

        override fun getItemId(p0: Int): Long{
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.toolbarAbout -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
