package com.example.tutorm3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.tutorm3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mhsAdapter: MahasiswaAdapter
    private val NUMBER_OF_COL = 2
    var rvMode: Int = 1
    var sortMode: Int = 1


    // Fungsi untuk memperbarui daftar mahasiswa yang ditampilkan di RecyclerView.
    fun refreshList(){
        mhsAdapter.submitList(
            MockDB.listMhs.map { it.copy() }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setAdapterAndLayoutManager(rvMode)

        binding.btnToAddMahasiswa.setOnClickListener {
            val intent = Intent(this@MainActivity, AddMhsActivity::class.java)
            intent.putExtra("mode","INSERT")
            startActivity(intent)
        }

        binding.btnSort.setOnClickListener {
            if(sortMode==1){
                sortMode = 0
                //Untuk sorting secara descending, pakai sortByDescending
                //untuk multiple sort, bisa dilakukan dengan memberi tanda +
                MockDB.listMhs.sortByDescending {
                        mhs-> mhs.nrp + mhs.nama
                }
                binding.btnSort.text = "Sort Ascending"
            }else {
                sortMode = 1
                //Untuk sorting secara ascending, pakai sortBy saja
                MockDB.listMhs.sortBy {
                        mhs-> mhs.nrp + mhs.nama
                }
                binding.btnSort.text = "Sort Descending"
            }
            refreshList()
        }
        binding.btnChange.setOnClickListener {
            when(rvMode){
                1 -> {
                    rvMode = 2
                    binding.btnChange.text = "Change to Horizontal List"
                }
                2 -> {
                    rvMode = 3
                    binding.btnChange.text = "Change to Vertical List"
                }
                else->{
                    rvMode = 1
                    binding.btnChange.text = "Change to Grid"
                }
            }
            setAdapterAndLayoutManager(rvMode)
        }
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun setAdapterAndLayoutManager(tipe:Int){
        lateinit var layoutManager: LayoutManager
        var layout:Int = R.layout.mahasiswa_item
        when (tipe) {
            1 -> {
                //linear layout bentuknya seperti list biasa urut ke bawah
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            2 -> {
                // tipe grid yang berbentuk card
                // untuk jumlah kolom gunakan parameter kedua
                layoutManager = GridLayoutManager(this, NUMBER_OF_COL)
                layout = R.layout.mahasiswa_item_2
            }
            else -> {
                // linear dengan scroll horizontal
                // agar horizontal tambahkan properti LinearLayoutManager.HORIZONTAL
                // reverse layout = false, maka akan rata kiri
                // bila true maka akan menjadi rata kanan
                layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
                layout = R.layout.mahasiswa_item_2
            }
        }

        // perlu untuk memasangkan adapter
        // serta layout manager ke recycler view
        mhsAdapter = MahasiswaAdapter(MockDB.listMhs, layout) { mhs ->
            val intent = Intent(this@MainActivity, AddMhsActivity::class.java)
            intent.putExtra("mode","UPDATE")
            intent.putExtra("nrp",mhs.nrp)
            startActivity(intent)
        }
        binding.rvMahasiswa.apply {
            this.layoutManager = layoutManager
            this.adapter = mhsAdapter
        }
    }
}