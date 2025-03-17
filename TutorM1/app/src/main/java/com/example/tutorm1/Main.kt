package com.example.tutorm1

/**
 * Ada 3 cara untuk menjalankan kode Kotlin pada console
 * 1. klik gambar play disebelah fun main (dekat angka baris)
 * 2. Ctrl + Shift + F10
 * 3. Klik gambar play pada bagian menubar (disebelah kanan pojok atas)
 *
*/

/** Kelebihan Menggunakan KOTLIN
 * 1. Tidak perlu pakai titik koma (;) di akhir baris
 * 2. Tidak perlu SELALU (sometimes masi butuh deklarasi -> dijelaskan dibawah) deklarasi tipe data, karena Kotlin bisa otomatis mengenali tipe data (smart cast)
 */

fun main(){
//    kotlinBasic()
    kotlinOOP()
}

fun kotlinBasic(){
    belajarVariabel()
    belajarOperator()
    belajarCondition()
    belajarLooping()
    belajarList()
    belajarPenggunaanNUll()
    belajarTerimaInput()
    belajarShortHandIf()
    belajarProcedureFunction()
    belajarLambdaFunction()
    belajarMengolahString()
}

fun belajarVariabel(){
    //cara print ke console
    print("Hello World!") // untuk print ke console tanpa newline
    println("Hello World2!") // untuk print ke console dengan newline

    println("== Belajar Variabel ==")
    //deklarasi variable
    //kotlin punya 2 jenis variable, yaitu val dan var
    //val -> immutable, tidak bisa diubah
    //var -> mutable, bisa diubah
    val bahasa:String = "Kotlin"
    var umur:Int = 20
    println("umur sebelum diubah $umur")
    umur = 21 //bisa diubah karena var
    println("umur setelah diubah $umur")

    //kotlin bisa otomatis mengenali tipe data dengan smart cast
    val _IDE = "Android Studio"    // otomatis String
    val kkm = 55    // otomatis integer

    //multi line string (pakai petik 2 sebanyak 3x)
    val pilihan_bahasa = """
        Android Studio
         - Kotlin
         - Java
    """
    println(pilihan_bahasa)

    //!!IMPORTANT!!
    println('a' + 1) // hati hati saat menambahkan tipe data yang berbeda -> dihitung sebagai ASCII
    // println(1 + 'a')
    // code diatas bisa error apabila smart cast kotlin tidak bisa menentukan tipe data
    println('a' + 1.toString())

    //cara print dengan variable mirip dengan php pakai $
    val namaku = "Jessica"
    println("Hello" + namaku + ", selamat datang di Kotlin")
    //kan panjang ya, lbh cepet disingkat seperti dibawah ini
    println("Hello $namaku, selamat datang di Kotlin")
    //bisa juga kalau mau ditambahkan kurung kurawal {}
    println("Belajar $bahasa menggunakan ${_IDE}")
}

fun belajarOperator(){
    println("== Belajar Operator ==")
    println(3 + 2)
    println(3 - 2)
    println(3 * 2)
    println(3 / 2)
    println(3 * 1.0 / 2)
}

fun belajarCondition(){
    println("== Belajar Condition ==")
    val ip = 3.75f
    if(ip > 4){
        println("Sempurna")
    }
    else if(ip > 2){
        println("Lulus")
    }
    else{
        println("Gagal")
    }

    println("Penggunaan when")
    when (ip) {
        4.0f -> println("Sempurna")
        in 2.0f..3.0f -> println("Lulus")
        1.9f -> println("Lulus bersyarat")
        else -> println("Gagal")
    }
}

fun belajarLooping(){
    println("== Belajar Looping ==")

    println("Looping biasa")
    for(i in 1..10){
        println(i)
    }

    println("Looping array")
    val list = listOf("Kotlin", "Java", "PHP")
    for(i in list){
        println(i)
    }

    println("Looping array dengan index")
    for((index, value) in list.withIndex()){
        println("$index -> $value")
    }

    println("Looping array dengan index")
    for(i in list.indices){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in 0 until list.size){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }

    println("Looping array dengan index")
    for(i in list.size-1 downTo 0 step 2){
        println("$i -> ${list[i]}")
    }
}

fun belajarList(){
    println("LIST (Tidak bisa di add/remove dan read only)")
    val hari = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
    println(hari)
//    hari[0] = "Minggu" //error karena read only

    println("MutableList & ArrayList (Bisa di add/remove)")
    println("ArrayList merupakan implementation dari MutableList")
//    val todo = mutableListOf("Kerja tugas praktikum", "Belajar materi minggu depan", "Cari makan", "Tidur")
     val todo = arrayListOf("Kerja tugas praktikum", "Belajar materi minggu depan", "Cari makan", "Tidur")
    println(todo)
    todo.add("Mandi")
    todo.removeAt(0)
    println(todo)
    todo[0] = "Belajar materi praktikum minggu depan"
    println(todo[0])

    println("Array (Tidak bisa di add/remove)")
    val angka = arrayOf(1, 2, 3, 4, 5)
    println(angka[0])
    angka[0] = 10
    println(angka[0])
}

fun belajarPenggunaanNUll(){
    // Penggunaan null bisa digunakan dengan memberi tanda tanya pada tipe data
    var pilihan: Int? = null

    // saat melakuakn print, kita bisa hanya print apabila ada valuenya dengan 2 cara
    // 1. menggunakan if

    if(pilihan != null){
        println(pilihan)
    }

    // 2. menggunakan safe call
    println(pilihan?.toString())

    // 3. elvis operator, menggunakan value pengganti apabila null
    println(pilihan ?: "Tidak ada pilihan")

    // kalau pasti tidak null, kita bisa menggunakan !! operator
    pilihan = 0
    println(pilihan!!.toString())
}

fun belajarTerimaInput(){
    println("== Belajar Terima Input ==")
    // Terima Input
    print("Masukkan nama anda:")
    val nama = readLine()
    println("Halo $nama")

    // Terima Input dengan tipe data
    print("Masukkan umur anda:")
    val umur = readLine()?.toInt()
    println("Umur anda $umur tahun")
}

fun belajarShortHandIf(){
    val umur = readLine()?.toInt()
    // kalau if else hanya 1 baris, bisa disingkat seperti ini
    val isDewasa = if(umur!! > 17) "Dewasa" else "Anak-anak"
    println(isDewasa)
}

fun belajarProcedureFunction(){
    //pada kotlin, procedure dan function menggunakan awalan "fun", yg membedakan adalah return value..
    //tidak ada return value -> procedure
    //ada return value -> function
    println("== Belajar Procedure & Function ==")

    //contoh procedure dengan default parameter
    //default parameter bisa digunakan untuk memberikan nilai default pada parameter
    welcome()
    welcome("Jessica")

    //contoh function dengan return value
    println(hitungUmur(2003))

    // bisa optional parameter dengan tambah tanda tanya dan default value
    println("dengan diskon : " + hitungTotal(arrayListOf(1000, 2000, 3000), 1000))
    println("tanpa diskon : " +hitungTotal(arrayListOf(1000, 2000, 3000)))

    // named argument
    println(deskipsi("Jessica", ip=3.9f, umur=21, jurusan="Informatika"))
}

fun welcome(nama: String = "Pengguna"): Unit {
    //apabila fun welcome tidak menerima parameter, maka default yang akan di print adalah "Pengguna"
    //jika menerima parameter, maka value dari parameter tersebut yang akan di print
    println("Selamat datang, $nama")
}

fun hitungUmur(tahunLahir: Int): Int {
    return 2025 - tahunLahir
}

fun hitungTotal(jumlah: ArrayList<Int>, diskon: Int? = null): Int{
    var total = 0
    for (j in jumlah){
        total += j
    }
    if(diskon != null){
        total -= diskon
    }
    return total
}

fun deskipsi(nama: String, umur: Int, jurusan:String, ip: Float?=0f): String{
    return """
        Nama: $nama
        Umur: $umur
        Jurusan: $jurusan
        IP: $ip
    """
}

fun belajarLambdaFunction(){
    // lambda function
    val jumlah = {a: Int, b: Int -> a + b}
    println(jumlah(1, 2))

    // lambda function dengan tipe
    val kurang: (Int, Int) -> Int = {a, b -> a - b}
    println(kurang(2, 1))

    // contoh penggunaan lambda function
    val data = arrayListOf(10,2,5,3,7,8,1)
    val data_baru = modif(data) { it * 2 }
    println("Data baru" + data_baru)

    val data_genap = data.filter{ it % 2 == 0}
    println("Data genap" + data_genap)

    val data_ribu = data.map{ it * 1000}
    println("Data ribu" + data_ribu)

    val data_nol = data.find{ it == 0 }
    println("Ini adalah data $data_nol")
    //Data disini bernilai null karena pada saat menggunakan find,
    // data dengan kondisi yang diberikan tidak ada
    // kita bisa menggunakan elvis operator untuk memberikan nilai default

    println("Ini adalah data ${data_nol ?: 0}")
}

fun modif(data: ArrayList<Int>, modif: (Int) -> Int): ArrayList<Int>{
    val data_baru = arrayListOf<Int>()
    for(d in data){
        data_baru.add(modif(d))
    }
    return data_baru
}

fun belajarMengolahString(){
    //ada berbagai macam cara untuk mengolah string di kotlin
    //yang sering terpakai adalah .split
    print("Masukkan string dengan spasi:")
    val cmd = readLine()
    println("kalimat : $cmd")
    for (i in cmd!!.split(' ')){
        println(i)
    }
}

fun kotlinOOP(){
    basicTutor()
}

fun basicTutor(){
    //Berikut adalah beberapa cara membuat instance object
    val hewan1:Hewan = Hewan(3000,5000, jumlahKaki = 2)
    val hewan2:Hewan = Hewan(hargaJual = 1500, hargaBeli = 900, jumlahKaki = 10)

    //coba print, ini sudah dioverride untuk method tostring
    println(hewan1)
    println(hewan2)
//    println(hewan3)

    //untuk getter setter bisa langsung diakses dengan NamaClass.Properti
    hewan1.hargaBeli = 10
//    print(hewan1.hargaBeli)

    //apabila parameter pada constructor diset sebagai val, maka properti tsb tidak bisa diset lagi
//    hewan1.jumlahKaki = 20 //pasti error Val cannot be reassigned

    //coba panggil custom getter untuk mendapatkan profit jual hewan
    println(hewan2.profitJual)

    hewan2.namaHewan = "Malika"
    hewan2.nomorKodeHewan = 0
    println(hewan2.kodeHewan)

    val anjing1:Anjing = Anjing(30, "A")
    println(anjing1)
    anjing1.hargaBeli = 1100 //bisa langsung set properti parent class seperti ini
    anjing1.hargaJual = 2000
    anjing1.namaHewan = "Samoyed"
    anjing1.nomorKodeHewan = 1
    println(anjing1.kodeHewan)
    println(anjing1.hasilHewan())

    val ikan1:Ikan = Ikan()
    ikan1.namaHewan = "Nemo"

    //konsep polymorphism, dimana semua instance di atas merupakan instance dari class Hewan,
    // maupun subclass / turunan dari class hewan
    val listHewanDummy: ArrayList<Hewan> = arrayListOf(hewan1, hewan2, anjing1, ikan1)

    //untuk cek apakah object ini merupakan instance tertentu, bisa menggunakan is
    for (i in 0..listHewanDummy.size-1){
        val h = listHewanDummy[i]
        if(h is Anjing){
            println("Hewan ${h.namaHewan} adalah anjing")
        }else if(h is Ikan){
            println("Hewan ${h.namaHewan} adalah ikan")
        }else{
            println("Hewan ${h.namaHewan} adalah hewan selain anjing dan ikan")
        }
    }
}

//kita juga bisa extend function seperti di bawah ini, bisa digunakan apabila kita tidak mau
// memodifikasi class, namun memerlukan method tambahan untuk menjalankan logic tertentu
fun Int.toRupiah():String{
    return "Rp.$this"
}