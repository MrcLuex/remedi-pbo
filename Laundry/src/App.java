import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner inputan = new Scanner(System.in);
        String pilih;
        Integer next = 1;
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEEEE, dd/MM/yyyy");
        Date date = new Date();

        Laundry input = new Laundry();
        Login inputl = new Login();

        System.out.println(tanggal.format(date));
        inputl.login();
        
        while (next != 0) {
            System.out.println("\n+-DATABASE LAUNDRY NASIONAL-+");
            System.out.println("==============================\n");
            System.out.println("1.\tLihat Data Laundry");
            System.out.println("2.\tTambah Data Laundry");
            System.out.println("3.\tEdit Data Laundry");
            System.out.println("4.\tHapus Data Laundry");
            System.out.println("5.\tPrint Struk Laundry");
            System.out.println("0.\tKeluar");
            System.out.println("\n==============================\n");

            System.out.print("\nPilih Nomor: ");
            pilih = inputan.next();

            switch (pilih) {
                case "1":
                    System.out.println("\n==============================");
                    System.out.println("        DATA LAUNDRY      ");
                    System.out.println("==============================");
                    //menginput interface dari data laundry
                    input.dataLaundry();
                    break;
                case "2":
                    System.out.println("\n==============================");
                    System.out.println("     TAMBAH DATA LAUNDRY    ");
                    System.out.println("==============================");
                    //menginput interface dari data add
                    input.add();
                    break;
                case "3":
                    System.out.println("\n==============================");
                    System.out.println("     UBAH DATA LAUNDRY      ");
                    System.out.println("==============================");
                    //menginput interface dari data update
                    input.update();
                    break;
                case "4":
                    System.out.println("\n==============================");
                    System.out.println("     HAPUS DATA LAUNDRY     ");
                    System.out.println("==============================");
                    //menginput interface dari delete
                    input.delete();
                    break;
                 case "5":
                    System.out.println("\n==============================");
                    System.out.println("         STRUK LAUNDRY        ");
                    System.out.println("==============================");
                    //menginput interface dari data print
                    input.printStruk();
                    break;    
                case "0":
                    System.out.println("\n==============================");
                    System.out.println("ANDA TELAH KELUAR, SILAHKAN LOGIN KEMBALI");
                    System.out.println("==============================");
                    System.exit(0);
                    break;
                default:
                    System.err.println("\nInput anda tidak ditemukan");

            }
                
            }

        }

}