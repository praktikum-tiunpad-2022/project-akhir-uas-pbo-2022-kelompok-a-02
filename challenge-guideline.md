# Challenge Guidelines

A. Deskripsi Masalah
- Implementasi dari game terkenal yaitu Snake dimana ada seekor ular yang dapat diarahkan untuk memakan buah. Dan jika ular tersebut memakan buah, panjangnya akan bertambah.
- Panjang dan tinggi frame untuk area bermain berukuran 100x100 sel yang dimana satu selnya merupakan persegi dengan ukuran dibebaskan, yang penting sama setiap selnya.
- Buah berukuran satu sel dan ditempatkan secara acak.
- Jika ular menabrak dinding atau menabrak tubuhnya sendiri, maka game akan selesai.
- Ketika game selesai, tunjukan score yang dihitung dari jumlah buah yang dimakan.
- Nama main class adalah SnakeGame (Contoh command untuk menjalankan adalah: java SnakeGame).
- Kontrol dari game adalah
    - Tombol-tombol panah untuk mengarahkan ular.
    - Spasi untuk memulai game.

B. Setelah App Berjalan
- Ular muncul dengan panjang awal 5 sel dan posisi kepala ada ditengah-tengah area game.
- Ular akan mulai bergerak maju setelah pengguna memberikan input dengan menekan tombol spasi.
- Dan juga setelah aplikasi dimulai buah pertama akan muncul secara random.
- Jika buah termakan oleh ular, maka ular akan bertambah panjangnya pada bagian kepala sebanyak satu sel. Dengan kata lain, pada saat buah dimakan, buah tersebut berubah menjadi kepala baru ular.
- Jika game selesai, munculkan dialog baru untuk menampilkan score. Dan jika dialog ditutup, game akan mereset ke posisi awal lagi.

C. Batasan Lainnya
- Gunakan struktur proyek yang rapi.
- JDK yang digunakan adalah versi 8.
- Gunakan modularitas pada struktur kodenya, misal terdapat class Food untuk buah/makanan.
- Refresh rate dari game adalah 2 frame per detik.
- Background texture setiap sel dapat berupa warna solid saja atau berupa gambar.

D. Challenge Ideas (Optional)
- Dapat menyimpan dan menampilkan leaderboard dengan 10 score terbaik.
- Terdapat 2 mode game, yaitu singleplayer mode dan multiplayer mode (1 v 1).
- Di multiplayer mode, fitur yang berbeda dengna singleplayer yaitu :
  - Terdapat controler yang berbeda untuk masing-masing playernya.
  - Terdapat banyak food dalam satu frame

Game Referensi
- https://helpfulsheep.com/snake/
- https://playsnake.org/
