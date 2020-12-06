import java.util.*;
public class MakanMinum{
	//Menu makanan
	public String [] makanan = {"French Fries","Pisang Goreng","Popcorn Salt","Chicken Burger","Popcorn Sweet Glaze"}; 
	public String [] minuman = {"Iced Lychee","Iced Peach","Iced Mochaccino","Iced	Mojito Lime","Iced Blenccino"}; 
	public int [] hargaMakan = {35_000,30_000,20_000,35_000,23_000}; 
	public int [] hargaMinum = {40_000,30_000,45_000,48_000,55_000};
 
 	//Makanan yang dibeli
 	public static ArrayList <String> makananUser = new ArrayList <String>();
 	public static ArrayList <Integer> jumMakananUser = new ArrayList <Integer>();
 	public static int totalMakanan = 0;

 	//Minuman yang dibeli
 	public static ArrayList <String> minumanUser = new ArrayList <String>();
 	public static ArrayList <Integer> jumMinumanUser = new ArrayList <Integer>();
 	public static int totalMinuman = 0;

 	//Konstruktor MakanMinum
 	public MakanMinum(){

 	}

 	public MakanMinum(Scanner in){
 		makananMinuman(in);
 	}

 	//Menampilkan pilihan makanan atau minuman
	public void makananMinuman(Scanner in){
		System.out.println("===============================");
		System.out.println("     Makanan dan Minuman");
		System.out.println("===============================");
		System.out.println("1. Makanan");
		System.out.println("2. Minuman");
		System.out.println("3. Lanjut Isi Data Diri");
		System.out.println("4. Batalkan Pemesanan");
		System.out.print("Pilih: ");
		int pilih = in.nextInt();
		switch(pilih){
			case 1:
			makanan(in);
			break;
			case 2:
			minuman(in);
			break;
			case 3:
			InputDataDiri input = new InputDataDiri(in);
			break;
			case 4:
			System.exit(1);
			default:
			makananMinuman(in);
			break;
		}
	}

	public void minuman(Scanner in){
		boolean loop = true;
		do{
			System.out.println("=================================");
			System.out.println(" Daftar Minuman");
			System.out.println("=================================");
			for (int i = 1; i < minuman.length ; i++ ) {
				System.out.println(String.format(i+". %-20s "+hargaMinum[i-1], minuman[i-1]));	
			}
			System.out.print("Pilih: " );
			int pilihMinuman = in.nextInt();
			System.out.print("\nJumlah Minuman Yang ingin dibeli: ");
			int jumlahMinuman= in.nextInt();

			minumanUser.add(minuman[pilihMinuman-1]);
			totalMinuman += hargaMinum[pilihMinuman-1]*jumlahMinuman;
			jumMinumanUser.add(jumlahMinuman);

			System.out.print("\nApakah ingin membeli Minuman lagi?(Y/N) ");
			String check = in.next();
			if(check.equalsIgnoreCase("Y")){
				loop = true;
			}
			else if(check.equalsIgnoreCase("N")){
				loop = false;
				System.out.println("Total Harga Minuman: " + totalMinuman);
				for (int i = 0;i < minumanUser.size() ;i++ ) {
					System.out.println((i+1)+". "+ minumanUser.get(i) +" sebanyak: " + jumMinumanUser.get(i));
				}

				makananMinuman(in);
			}	
		}while(loop);

	}

	public void makanan(Scanner in){
		boolean loop = true;
		do{
			System.out.println("=================================");
			System.out.println(" Daftar Makanan");
			System.out.println("=================================");
			for(int i = 1 ; i < makanan.length; i++){
				System.out.println(String.format(i+". %-20s "+hargaMakan[i-1], makanan[i-1]));
			}
			System.out.print("Pilih: " );
			int pilihMakanan = in.nextInt();
			System.out.print("\nJumlah Makanan Yang ingin dibeli: ");
			int jumlahMakanan= in.nextInt();

			makananUser.add(makanan[pilihMakanan-1]);
			totalMakanan += hargaMakan[pilihMakanan-1]*jumlahMakanan;
			jumMakananUser.add(jumlahMakanan);
			
			System.out.print("\nApakah ingin membeli Makanan lagi?(Y/N) ");
			String check = in.next();
			if(check.equalsIgnoreCase("Y")){
				loop = true;
			}
			else if(check.equalsIgnoreCase("N")){
				loop = false;
				System.out.println("Total Harga Makanan: " + totalMakanan);
				for (int i = 0;i < makananUser.size() ;i++ ) {
					System.out.println((i+1)+". "+ makananUser.get(i) +" sebanyak: " + jumMakananUser.get(i));
				}

				makananMinuman(in);
			}	
		}while(loop);
	}
}
