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
		boolean checkPilihan = true;
		String pilih;
		do{
			System.out.print("Pilih: ");
			pilih = in.next();
			int pilihNum = 0;
			if(!pilih.matches("[0-9]+")){
					System.out.println("Pilihan Harus Berupa Angka");
					checkPilihan = true;
				}
			else{
				pilihNum = Integer.parseInt(pilih); 
				if(pilihNum > 0  && pilihNum <= 4){
					checkPilihan = false;
				}
				else{
					System.out.println("Pilihan Tidak Valid");
				}
			}
		}while(checkPilihan);
			
		switch(pilih){
			case "1":
			makanan(in);
			break;
			case "2":
			minuman(in);
			break;
			case "3":
			InputDataDiri input = new InputDataDiri(in);
			break;
			case "4":
			System.exit(1);
			default:
			makananMinuman(in);
			break;
		}
	}

	public void minuman(Scanner in){
		boolean loop = true;
		do{
			// System.out.println("\n");
			System.out.println("=================================");
			System.out.println("	 Daftar Minuman");
			System.out.println("=================================");
			for (int i = 1; i <= minuman.length ; i++ ) {
				System.out.println(String.format(i+". %-20s "+hargaMinum[i-1], minuman[i-1]));	
			}
			System.out.println((minuman.length+1)+". Kembali");
			String pilihMinum;
			int pilihMinuman =0;
			//Pengecekan inputan minuman
			do{
				System.out.print("Pilih: " );
				pilihMinum = in.next();
				if(!pilihMinum.matches("[0-9]+")){
					System.out.println("Pilihan Harus Berupa Angka");
				}
				else{
					pilihMinuman = Integer.parseInt(pilihMinum); 
					if(pilihMinuman > 0  && pilihMinuman <= minuman.length ){
						break;
					}
					else if(pilihMinuman == minuman.length+1){
						System.out.println("\nTotal Harga Minuman: " + totalMinuman);
						for (int i = 0;i < minumanUser.size() ;i++ ) {
							System.out.println((i+1)+". "+ minumanUser.get(i) +" sebanyak: " + jumMinumanUser.get(i));
						}
						makananMinuman(in);
					}
					else{
						System.out.println("Pilihan Tidak Valid");
					}
				}
			}while(true);
			int jumlahMinuman;
			String checkJumlahMinuman;
			do{
				System.out.print("\nJumlah Minuman Yang ingin dibeli: ");
				checkJumlahMinuman= in.next();
				if(!checkJumlahMinuman.matches("[0-9]+")){
					System.out.println("Inputan Harus Berupa Angka");
				}
				else{
					jumlahMinuman = Integer.parseInt(checkJumlahMinuman);
					break;
				}
			}while(true);
			
			minumanUser.add(minuman[pilihMinuman-1]);
			totalMinuman += hargaMinum[pilihMinuman-1]*jumlahMinuman;
			jumMinumanUser.add(jumlahMinuman);

			do{
				System.out.print("\nApakah ingin membeli Minuman lagi?(Y/N) ");
				String check = in.next();
				if(check.equalsIgnoreCase("Y")){
					loop = true;
					break;
				}
				else if(check.equalsIgnoreCase("N")){
					loop = false;
					System.out.println("\nTotal Harga Minuman: " + totalMinuman);
					for (int i = 0;i < minumanUser.size() ;i++ ) {
						System.out.println((i+1)+". "+ minumanUser.get(i) +" sebanyak: " + jumMinumanUser.get(i));
					}
					makananMinuman(in);
				}
				else{
					System.out.println("Inputan Salah!");
					loop = true;
				}	
			}while(loop);
		}while(loop);

	}

	public void makanan(Scanner in){
		boolean loop = true;
		do{
			System.out.println("=================================");
			System.out.println("	 Daftar Makanan");
			System.out.println("=================================");
			for(int i = 1 ; i <= makanan.length; i++){
				System.out.println(String.format(i+". %-20s "+hargaMakan[i-1], makanan[i-1]));
			}
			System.out.println((makanan.length+1)+". Kembali");
			String pilihMakan;
			int pilihMakanan =0;
			//Pengecekan inputan makanan
			do{
				System.out.print("Pilih: " );
				pilihMakan = in.next();
				if(!pilihMakan.matches("[0-9]+")){
					System.out.println("Pilihan Harus Berupa Angka");
				}
				else{
					pilihMakanan = Integer.parseInt(pilihMakan); 
					if(pilihMakanan > 0  && pilihMakanan <= makanan.length ){
						break;
					}
					else if(pilihMakanan == makanan.length+1){
						System.out.println("\nTotal Harga Makanan: " + totalMakanan);
						for (int i = 0;i < makananUser.size() ;i++ ) {
							System.out.println((i+1)+". "+ makananUser.get(i) +" sebanyak: " + jumMakananUser.get(i));
						}
						makananMinuman(in);
					}
					else{
						System.out.println("Pilihan Tidak Valid");
					}
				}
			}while(true);
			int jumlahMakanan;
			String checkJumlahMakanan;
			do{
				System.out.print("\nJumlah Makanan Yang ingin dibeli: ");
				checkJumlahMakanan= in.next();
				if(!checkJumlahMakanan.matches("[0-9]+")){
					System.out.println("Inputan Harus Berupa Angka");
				}
				else{
					jumlahMakanan = Integer.parseInt(checkJumlahMakanan);
					break;
				}
			}while(true);
			makananUser.add(makanan[pilihMakanan-1]);
			totalMakanan += hargaMakan[pilihMakanan-1]*jumlahMakanan;
			jumMakananUser.add(jumlahMakanan);
			
			do{
				System.out.print("\nApakah ingin membeli Makanan lagi?(Y/N) ");
				String check = in.next();
				if(check.equalsIgnoreCase("Y")){
					loop = true;
					break;
				}
				else if(check.equalsIgnoreCase("N")){
					loop = false;
					System.out.println("\nTotal Harga Makanan: " + totalMakanan);
					for (int i = 0;i < makananUser.size() ;i++ ) {
						System.out.println((i+1)+". "+ makananUser.get(i) +" sebanyak: " + jumMakananUser.get(i));
					}
					makananMinuman(in);
				}
				else{
					System.out.println("Inputan Salah!");
					loop = true;
				}	
			}while(loop);
		}while(loop);
	}
}
