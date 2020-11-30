import java.util.*;
public class MakanMinum{
	//Menu makanan
	public String [] makanan = {"French Fries","Pisang Goreng","Popcorn Salt","Chicken Burger","Popcorn Sweet Glaze"}; 
	public String [] minuman = {"Iced Lychee","Iced Peach","Iced Mochaccino","Iced	Mojito Lime","Iced Blenccino"}; 
	public int [] hargaMakan = {35_000,30_000,20_000,35_000,23_000}; 
	public int [] hargaMinum = {40_000,30_000,45_000,48_000,55_000};
 
 	//Makanan yang dibeli
 	public ArrayList <String> makananUser = new ArrayList <String>();
 	public ArrayList <Integer> jumMakananUser = new ArrayList <Integer>();
 	public int totalMakanan = 0;

 	//Minuman yang dibeli
 	public ArrayList <String> minumanUser = new ArrayList <String>();
 	public ArrayList <Integer> jumMinumanUser = new ArrayList <Integer>();
 	public int totalMinuman = 0;

 	//Konstruktor MakanMinum
 	public MakanMinum(Scanner huruf,Scanner angka){
 		makananMinuman(huruf,angka);
 	}

 	//Menampilkan pilihan makanan atau minuman
	public void makananMinuman(Scanner huruf,Scanner angka){
		System.out.println("===============================");
		System.out.println("     Makanan dan Minuman");
		System.out.println("===============================");
		System.out.println("1. Makanan");
		System.out.println("2. Minuman");
		System.out.println("3. Lanjut Isi Data Diri");
		System.out.println("4. Batalkan Pemesanan");
		System.out.print("Pilih: ");
		int pilih = angka.nextInt();
		switch(pilih){
			case 1:
			makanan(huruf,angka);
			break;
			case 2:
			minuman(huruf,angka);
			break;
			case 3:
			InputDataDiri input = new InputDataDiri(huruf,angka);
			break;
			case 4:
			System.exit(1);
			default:
			makananMinuman(huruf,angka);
			break;
		}
	}

	public void minuman(Scanner huruf,Scanner angka){
		boolean loop = true;
		do{
			System.out.println("\n");
			System.out.println(" Daftar Minuman");
			System.out.println("=================================");
			System.out.println(String.format("1. %-15s Rp.40.000","Iced Lychee"));
			System.out.println(String.format("2. %-15s Rp.30.000","Iced Peach"));
			System.out.println(String.format("3. %-15s Rp.45.000","Iced Mochaccino"));
			System.out.println(String.format("4. %-15s Rp.48.000","Iced	Mojito Lime"));
			System.out.println(String.format("5. %-15s Rp.55.000","Iced Blenccino"));
			System.out.print("Pilih: " );
			int pilihMinuman = angka.nextInt();
			System.out.print("\nJumlah Minuman Yang ingin dibeli: ");
			int jumlahMinuman= angka.nextInt();

			minumanUser.add(minuman[pilihMinuman-1]);
			totalMinuman += hargaMinum[pilihMinuman-1]*jumlahMinuman;
			jumMinumanUser.add(jumlahMinuman);

			System.out.print("\nApakah ingin membeli Minuman lagi?(Y/N) ");
			String check = huruf.next();
			if(check.equalsIgnoreCase("Y")){
				loop = true;
			}
			else if(check.equalsIgnoreCase("N")){
				loop = false;
				System.out.println("Total Harga Minuman: " + totalMinuman);
				for (int i = 0;i < minumanUser.size() ;i++ ) {
					System.out.println((i+1)+". "+ minumanUser.get(i) +" sebanyak: " + jumMinumanUser.get(i));
				}

				makananMinuman(huruf,angka);
			}	
		}while(loop);

	}

	public void makanan(Scanner huruf,Scanner angka){
		boolean loop = true;
		do{
			System.out.println("\n");
			System.out.println(" Daftar Makanan");
			System.out.println("=================================");
			System.out.println(String.format("1. %-20s Rp.35.000","French Fries"));
			System.out.println(String.format("2. %-20s Rp.30.000","Pisang Goreng"));
			System.out.println(String.format("3. %-20s Rp.20.000","Popcorn Salt"));
			System.out.println(String.format("4. %-20s Rp.35.000","Chicken Burger"));
			System.out.println(String.format("5. %-20s Rp.23.000","Popcorn Sweet Glaze"));
			System.out.print("Pilih: " );
			int pilihMakanan = angka.nextInt();
			System.out.print("\nJumlah Makanan Yang ingin dibeli: ");
			int jumlahMakanan= angka.nextInt();

			makananUser.add(makanan[pilihMakanan-1]);
			totalMakanan += hargaMakan[pilihMakanan-1]*jumlahMakanan;
			jumMakananUser.add(jumlahMakanan);
			
			System.out.print("\nApakah ingin membeli Makanan lagi?(Y/N) ");
			String check = huruf.next();
			if(check.equalsIgnoreCase("Y")){
				loop = true;
			}
			else if(check.equalsIgnoreCase("N")){
				loop = false;
				System.out.println("Total Harga Makanan: " + totalMakanan);
				for (int i = 0;i < makananUser.size() ;i++ ) {
					System.out.println((i+1)+". "+ makananUser.get(i) +" sebanyak: " + jumMakananUser.get(i));
				}

				makananMinuman(huruf,angka);
			}	
		}while(loop);
	}
}