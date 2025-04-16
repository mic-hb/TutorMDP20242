package com.example.tutorm3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.tutorm3.databinding.ActivityAddMhsBinding

class AddMhsActivity : AppCompatActivity() {
    var mode:String? = "INSERT"
    lateinit var binding: ActivityAddMhsBinding

    var listJurusan: ArrayList<String> =
        arrayListOf("Informatika", "SIB", "DKV", "Elektro", "Lainnya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddMhsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.add_mhs)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mode = intent.getStringExtra("mode")

        //untuk isi data spinner bisa dua cara, static atau dynamic
        //untuk static, isi langsung di property entries pada component
        //untuk dynamic, perlu dideclare dulu array

        var spinnerAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, listJurusan
        )
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerJurusan.adapter = spinnerAdapter


        if (mode == "UPDATE") {
            //isi sesuai data yang dipilih
            binding.buttonAddMahasiswa.text = "Edit"
            var nrp: String? = intent.getStringExtra("nrp")

            var mhs = MockDB.listMhs.find { m -> m.nrp == nrp }
            if (mhs != null) {
                var selectedPosition: Int = when (mhs.jurusan) {
                    11 -> 0
                    18 -> 1
                    17 -> 2
                    10 -> 3
                    else -> 4
                }
                binding.etNRP.setText(nrp)
                binding.etNama.setText(mhs.nama)
                binding.spinnerJurusan.setSelection(selectedPosition)
                binding.etNRP.isEnabled = false
            }
        }

        binding.buttonAddMahasiswa.setOnClickListener {
            var nrp:String = binding.etNRP.text.toString()
            var nama:String = binding.etNama.text.toString()
            var jurusanString: String = binding.spinnerJurusan.selectedItem.toString()
            var jurusan:Int = when(jurusanString){
                "Informatika"->11
                "SIB"->18
                "DKV"->17
                "Elektro"->10
                else-> 1
            }
            if (mode == "INSERT") {
                val newMhs = Mahasiswa(nrp, nama, jurusan)
                MockDB.addMahasiswa(newMhs)
            } else {
                var indexMhs = -1
                for ((index, mhs) in MockDB.listMhs.withIndex()) {
                    if (mhs.nrp == nrp) {
                        indexMhs = index
                    }
                }
                if (indexMhs > -1) {
                    MockDB.listMhs[indexMhs].nama = nama
                    MockDB.listMhs[indexMhs].jurusan = jurusan
                }
            }
            finish()
        }
    }
}