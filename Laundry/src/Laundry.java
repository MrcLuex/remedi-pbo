import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Laundry implements CRUD {
//Connect Database
    Connection conn;
    String url = "jdbc:mysql://localhost/laundry_nasional";
    String driver = "com.mysql.jdbc.Driver";

//Properti yang digunakan
    String noLaundry;
    String nama;
    String alamat;
    Integer berat;


//Menampilkan data dari database
    public void dataLaundry()throws SQLException{
        try{
            String sql = "SELECT * FROM laundry";
            conn = DriverManager.getConnection(url, "root", "");
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

        //perulangan agar data yang tidak ditampilkan hanya satu
        while (result.next()) {
            System.out.println();
            System.out.println("Nomor Laundry \t: " + result.getString("noLaundry"));
            System.out.println("Nama \t\t: " + result.getString("nama"));
            System.out.println("Alamat \t\t: " + result.getString("alamat"));
            System.out.println("Berat Laundry \t: " + result.getInt("berat"));
        }
        st.close();
    } catch (Exception e){
        System.out.println("GAGAL MENAMPILKAN DATA");
    }
}

//Menambah Data ke Database
    public void add() throws SQLException{

    Scanner strg = new Scanner(System.in);  
    Scanner intg = new Scanner(System.in);

        System.out.println("Masukkan Nomor Laundry : ");
        noLaundry = strg.next();
        System.out.println("Masukkan Nama : ");
        nama = strg.next();
        System.out.println("Masukkan Alamat : ");
        alamat = strg.next();
        System.out.println("Masukkan Berat (Dalam KG): ");
        berat = intg.nextInt();
    
//Percabangan yang bergantung pada boolean
    try{
//Koneksi ke database
    conn = DriverManager.getConnection(url, "root", "");
    Statement st = conn.createStatement();
//Query SQL untuk memasukkan data ke database
    String sql = "INSERT INTO laundry (noLaundry, nama, alamat, berat) VALUES ('"+ noLaundry 
    + "','"+ nama + "','"+ alamat + "','"+ berat + "') ";
    st.execute(sql);    
//Pesan jika data berhasil ditambah ke database
    System.out.println("DATA BERHASIL DITAMBAHKAN\n");

    } catch (Exception e) {
    e.printStackTrace();
    System.err.println("DATA GAGAL DITAMBAHKAN");
    }
}
    @Override
//update data pada Database
    public void update() throws SQLException {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Masukkan No Laundry  yang ingin diubah : ");
    noLaundry = scanner.next();
    conn = DriverManager.getConnection(url, "root", "");
    Statement st = conn.createStatement();
    
    System.out.println("Data yang ingin diubah\n");
    System.out.println("1. Nama");
    System.out.println("2. Alamat");
    System.out.println("3. Berat");
    
    System.out.println("Pilihan anda : ");
    Scanner terminalInput = new Scanner(System.in);
    Integer PilihanUser = terminalInput.nextInt();
    
        switch (PilihanUser) {
            case 1:
                System.out.print("Masukkan Nama yang baru : ");
                nama = scanner.next();
                String sql = String.format("UPDATE laundry SET nama = '%s' WHERE noLaundry ='%s'", nama,noLaundry);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            case 2:
                System.out.print("Masukkan Alamat yang baru : ");
                alamat = scanner.next();
                sql = String.format("UPDATE laundry SET namaK = '%s' WHERE noLaundry ='%s'", alamat,noLaundry);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            case 3:
                System.out.print("Masukkan Berat yang baru : ");
                berat = scanner.nextInt();
                sql = String.format("UPDATE laundry SET noPlat = '%s' WHERE noLaundry ='%s'", berat,noLaundry);
                st.executeUpdate(sql);
                System.out.println("DATA BERHASIL DIUPDATE\n");
                break;
            default:
                System.err.println("\nInput anda tidak ditemukan");
            }
        }
//hapus data pada Database
    public void delete() throws SQLException {
    
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Masukkan Nomor Laudry yang ingin dihapus : ");
            noLaundry = scanner.next();
    
            conn = DriverManager.getConnection(url, "root", "");
            String sql = String.format("DELETE FROM laundry WHERE noLaundry ='%s'", noLaundry);
            Statement st = conn.createStatement();
    
            st.executeUpdate(sql);
            System.out.println("Berhasil menghapus data laundry dengan No Laundry = " + noLaundry);
    
        } catch (Exception e) {
            System.out.println("No Laundry tidak ada dalam Database");
            }
            
        }
    
    
//print Struk
    public void printStruk(){
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nomor Laundry yang ingin di Cetak : ");
        noLaundry = scanner.next();
    
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM laundry WHERE noLaundry =?");
            pst.setString(1, noLaundry);
            ResultSet result = pst.executeQuery();
    
            Date date = new Date();
            SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yy");
            SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");
    
            if (result.next()) {
            System.out.println("----------- Laundry Nasional -----------");
            System.out.println(hari.format(date));
            System.out.println(jam.format(date));
            System.out.println("No Laundry \t: " + result.getString("noLaundry"));
            System.out.println("====================================");
            System.out.println("---------- DATA LAUNDRY NASIONAL ----------");
            System.out.println("Nama \t: " + result.getString("nama"));
            System.out.println("Alamat \t\t: " + result.getString("alamat"));
            System.out.println("Berat Laundry \t\t: " + result.getInt("berat"));
            System.out.println("Terimakasih Telah Datang Di Laundry Nasional");
            }
            else{
                System.out.println("Data tidak ditemukan");
            }
                
        } catch (Exception e) {
            e.printStackTrace();System.err.println("Data dengan No Laundry " + noLaundry + " tidak ditemukan");
        }
            
    
       
        }
        
    }
    