#SOAL

1. Buatlah program pencarian menggunakan algoritma Depth-First Search (DFS) dalam bahasa Java. Gunakan graf dengan 7 node yang mewakili a1, a2, a3, a4, a5, a6, a7 (tentukan sendiri nilai hubungan antar node). Lakukan pencarian angka n pada graf tersebut dengan DFS. Jelaskan tahap demi tahap proses pencarian dan gambarkan dengan rinci prosesnya.
2. Buatlah program pencarian menggunakan algoritma Breadth-First Search (BFS) dalam bahasa Java. Gunakan graf dengan 7 node yang mewakili a1, a2, a3, a4, a5, a6, a7 (tentukan sendiri nilai hubungan antar node). Lakukan pencarian angka n pada graf tersebut dengan BFS. Jelaskan tahap demi tahap proses pencarian dan gambarkan dengan rinci prosesnya.

#JAWABAN

\*PENJELASAN ALGORITMA
Konsep DFS:
Depth-First Search (DFS) adalah algoritma untuk melintasi atau mencari struktur data pohon atau graf. Algoritma ini memulai di root (atau node sembarang) dan menjelajahi sejauh mungkin di sepanjang setiap cabang sebelum backtracking.
Analogi:
Bayangkan kita sedang menjelajahi labirin. Dengan DFS, kita akan memilih satu jalur, dan terus berjalan menyusuri jalur itu sejauh mungkin (mendalam) sampai kita menemui jalan buntu. Jika menemui jalan buntu, kita akan kembali (backtrack) ke persimpangan terakhir dan mencoba jalur lain yang belum dijelajahi. kita terus melakukan ini sampai kita menemukan jalan keluar atau menjelajahi seluruh labirin.

Konsep BFS:
Breadth-First Search (BFS) adalah algoritma untuk melintasi atau mencari struktur data pohon atau graf. Algoritma ini memulai di root (atau node sembarang) dan menjelajahi semua node tetangga di tingkat yang sama sebelum bergerak ke node di tingkat berikutnya.
Analogi:
Dengan BFS, kita akan menelusuri labirin lapis demi lapis. kita menjelajahi semua persimpangan yang dapat dijangkau dari lokasi saat ini (tingkat 1), lalu dari semua persimpangan itu kita menjelajahi semua persimpangan yang bisa dijangkau (tingkat 2), dan seterusnya. Ini seperti gelombang yang menyebar dari titik awal.

\*PERBANDINGAN DFS vs BFS

| Fitur                 | DFS (Depth-First Search)                  | BFS (Breadth-First Search)                       |
| --------------------- | ----------------------------------------- | ------------------------------------------------ |
| **Struktur Data**     | Stack (atau menggunakan rekursi)          | Queue (antrian FIFO)                             |
| **Jalur Ditemukan**   | Tidak selalu jalur terpendek              | Selalu jalur terpendek (untuk graf tak berbobot) |
| **Penggunaan Memori** | Lebih hemat pada graf sempit dan dalam    | Bisa boros memori jika graf sangat lebar         |
| **Cocok Untuk**       | Mencari apakah path ada (existence check) | Mencari path/jalur terpendek                     |
| **Kecepatan**         | Cepat untuk graf dengan kedalaman kecil   | Efektif untuk pencarian luas dan pendek          |
| **Implementasi**      | Lebih sederhana secara rekursif           | Lebih eksplisit dan terstruktur                  |

\*TAHAPAN PROSES DFS DAN BFS:

1. Membuat Graf yang Akan Digunakan
2. Membuat hubungan Antar Node (Adjacency List):
3. Gambaran Graf
   a1 (0)
   / \
    / \
   a2 (1) a3 (2)
   | / \
    | / \
   a4 (3) a5 (4) a6 (5)
   | |
   | |
   a7 (6) a7 (6)

\*TAHAPAN PROSES DFS:
Secara garis besar:

- Mulai: Pilih satu titik awal (node).
- Jelajah Mendalam: Dari titik saat ini, pilih salah satu jalur yang belum pernah lewati dan ikuti jalur itu sejauh mungkin ke depan.
- Tandai: Setiap kali mengunjungi node baru, tandai bahwa node itu sudah dikunjungi (supaya tidak bolak-balik ke tempat yang sama atau terjebak putaran).
- Cari Target: Setiap kali tiba di node baru, periksa apakah itu adalah yang dicari.
- Jalan Buntu/Sudah Dikunjungi: Jika sampai di node yang tidak punya jalur baru (semua tetangga sudah dikunjungi atau tidak ada tetangga), mundur (backtrack) ke node sebelumnya.
- Ulangi: Dari node tempat mundur, cari lagi jalur lain yang belum dilewati dan ulangi langkah 2-5 sampai target ditemukan atau semua jalur sudah dijelajahi.

Detail:

1. DFS(0, 6) dipanggil.
2. DFSUtil(0, visited, 6, [])
   - Kunjungi a1 (0). visited[0] = true. path = ["a1"]. Output: "Mengunjungi Node a1".
   - a1 bukan a7.
   - Tetangga a1: a2 (1), a3 (2).
   - Ambil a2 (1). Belum dikunjungi.
   - Panggil DFSUtil(1, visited, 6, ["a1"])
     - Kunjungi a2 (1). visited[1] = true. path = ["a1", "a2"]. Output: "Mengunjungi Node a2".
     - a2 bukan a7.
     - Tetangga a2: a4 (3).
     - Ambil a4 (3). Belum dikunjungi.
     - Panggil DFSUtil(3, visited, 6, ["a1", "a2"])
       - Kunjungi a4 (3). visited[3] = true. path = ["a1", "a2", "a4"]. Output: "Mengunjungi Node a4".
       - a4 bukan a7.
       - Tetangga a4: a7 (6).
       - Ambil a7 (6). Belum dikunjungi.
       - Panggil DFSUtil(6, visited, 6, ["a1", "a2", "a4"])
         - Kunjungi a7 (6). visited[6] = true. path = ["a1", "a2", "a4", "a7"]. Output: "Mengunjungi Node a7".
         - a7 ADALAH a7!
         - Output: "TARGET DITEMUKAN: a7 (Node 6)", "Path yang dilalui: [a1, a2, a4, a7]".
         - Kembali true.
       - DFSUtil(3, ...) menerima true. Kembali true.
     - DFSUtil(1, ...) menerima true. Kembali true.
   - DFSUtil(0, ...) menerima true. Proses berhenti.

\*TAHAPAN PROSES BFS:
Secara garis besar:

- Mulai & Antrikan: Pilih satu titik awal (node) dan masukkan ke "antrean" (seperti daftar tunggu). Tandai sudah dikunjungi.
- Ambil & Periksa: Ambil node paling depan dari antrean. Periksa apakah itu yang cari.
- Jelajah Tetangga: Lihat semua tetangga dari node yang baru saja ambil.
- Antrikan Tetangga Baru: Untuk setiap tetangga yang belum pernah dikunjungi, tandai sebagai dikunjungi dan masukkan ke bagian belakang antrean.
- Ulangi: Terus ulangi langkah 2-4 sampai antrean kosong (berarti semua yang bisa dijangkau sudah dijelajahi) atau target ditemukan.

Detail:

1. BFS(0, 6) dipanggil.
2. Inisialisasi: visited semua false, queue = [], parentMap = {}.
3. visited[0] = true. queue.add(0). parentMap.put(0, -1).
   - queue = [0]
4. Loop 1:
   - current = queue.poll() (ambil 0 / a1). queue = [].
   - Output: "Mengunjungi Node a1".
   - a1 bukan a7.
   - Tetangga a1: a2 (1), a3 (2).
   - a2 belum dikunjungi: visited[1]=true, queue.add(1), parentMap.put(1, 0).
   - a3 belum dikunjungi: visited[2]=true, queue.add(2), parentMap.put(2, 0).
   - queue = [1, 2]
5. Loop 2:
   - current = queue.poll() (ambil 1 / a2). queue = [2].
   - Output: "Mengunjungi Node a2".
   - a2 bukan a7.
   - Tetangga a2: a4 (3).
   - a4 belum dikunjungi: visited[3]=true, queue.add(3), parentMap.put(3, 1).
   - queue = [2, 3]
6. Loop 3:
   - current = queue.poll() (ambil 2 / a3). queue = [3].
   - Output: "Mengunjungi Node a3".
   - a3 bukan a7.
   - Tetangga a3: a5 (4), a6 (5).
   - a5 belum dikunjungi: visited[4]=true, queue.add(4), parentMap.put(4, 2).
   - a6 belum dikunjungi: visited[5]=true, queue.add(5), parentMap.put(5, 2).
   - queue = [3, 4, 5]
7. Loop 4:
   - current = queue.poll() (ambil 3 / a4). queue = [4, 5].
   - Output: "Mengunjungi Node a4".
   - a4 bukan a7.
   - Tetangga a4: a7 (6).
   - a7 belum dikunjungi: visited[6]=true, queue.add(6), parentMap.put(6, 3).
   - queue = [4, 5, 6]
8. Loop 5:
   - current = queue.poll() (ambil 4 / a5). queue = [5, 6].
   - Output: "Mengunjungi Node a5".
   - a5 bukan a7.
   - Tetangga a5: a7 (6).
   - a7 SUDAH dikunjungi (visited[6] adalah true). Tidak akan ditambahkan lagi ke antrian.
   - queue = [5, 6]
9. Loop 6:
   - current = queue.poll() (ambil 5 / a6). queue = [6].
   - Output: "Mengunjungi Node a6".
   - a6 bukan a7.
   - Tidak ada tetangga a6.
   - queue = [6]
10. Loop 7:
    - current = queue.poll() (ambil 6 / a7). queue = [].
    - Output: "Mengunjungi Node a7".
    - a7 ADALAH a7!
    - Output: "TARGET DITEMUKAN: a7 (Node 6)", "Path yang dilalui: [a1, a2, a4, a7]".
    - targetFound = true. break.

#SCRIPT MENJALANKAN PROGRAM

BFS:
-compile
cd src
javac bfs/BFSGraph.java
-running
java bfs/BFSGraph.java

DFS:
-compile
cd src
javac dfs/DFSGraph.java
-running
java dfs/DFSGraph.java
