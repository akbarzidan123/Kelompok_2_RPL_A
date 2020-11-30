import java.util.*;
public class FilmBioskop{
	// Array multi dimensional berisi jadwal film
	final String [][] film = {	{"Avanger End Game", "12.00"},
							  	{"Black Panther", "14.30"},
								{"Thor Ragnarok", "15.30"},
								{"Bucin", "16.00"},
								{"Captain Marvel", "17.20"},
								{"Single", "18.40"},
								{"Habibie & Ainun 3", "20.00"},
								{"Joker", "21.00"},
								{"Dua Garis Biru (18+)", "22.00"}};
	// index pertama(bangku[0]) = Huruf bangku
	// inedex kedua (bangku[0][0])= nomor bangku
	String [][] bangku = {{"1.A","2.A","3.A","4.A","5.A","6.A","7.A","8.A","9.A","10.A","11.A","12.A"},
						  {"1.B","2.B","3.B","4.B","5.B","6.B","7.B","8.B","9.B","10.B","11.B","12.B"},
						  {"1.C","2.C","3.C","4.C","5.C","6.C","7.C","8.C","9.C","10.C","11.C","12.C"},
						  {"1.D","2.D","3.D","4.D","5.D","6.D","7.D","8.D","9.D","10.D","11.D","12.D"},
						  {"1.E","2.E","3.E","4.E","5.E","6.E","7.E","8.E","9.E","10.E","11.E","12.E"},
						  {"1.F","2.F","3.F","4.F","5.F","6.F","7.F","8.F","9.F","10.F","11.F","12.F"},
						  {"1.G","2.G","3.G","4.G","5.G","6.G","7.G","8.G","9.G","10.G","11.G","12.G"}};
	
	//Variable Class 
	int pilihFilm;
	int hargaFilm = 50_000;
	public int totalHargaFilm;

	public ArrayList <String> pilihanBangku = new ArrayList <String>();

	// Constructor FilmBioskop
	public FilmBioskop(Scanner huruf,Scanner angka){
		jadwalFilm(huruf,angka);
	}

	// Menampilkan Jadwal Film
	public void jadwalFilm(Scanner huruf,Scanner angka){
		
		boolean checkFilm = true;
		boolean checkBangku = true;
		System.out.println(String.format("%-7s Jadwal Film Hari Senin",""));
		System.out.println("-----------------------------------------");
		System.out.println(String.format("%-11s Film %15s Waktu","",""));
		for(int i = 0; i < film.length; i++){
			String format = String.format((i+1)+". "+"%-30s" + "%s",film[i][0], film[i][1]);
			System.out.println(format);
		}
		// Pemilihan film bioskop
		do{
			System.out.print("\nPilih Film Yang ingin ditonton: ");
			pilihFilm = angka.nextInt();
			if(pilihFilm > film.length || pilihFilm <= 0){
				System.out.println("Pilihan Tidak Valid");
				checkFilm = true;
			}
			else
				checkFilm = false;

		}while(checkFilm);
		//Pengecekan bangku film
			System.out.println("\nFilm " + film[pilihFilm-1][0] +  " Harga Rp. " + hargaFilm);
				System.out.println("Daftar Bangku Film " + film[pilihFilm-1][0] + " Pukul " + film[pilihFilm-1][1]+" WIB");
				System.out.println("--------------------------------------------------------------------");
				layarBioskop();

				String bangkuUser;
				System.out.println("(Contoh milih bangku: 1.A)");
				boolean checkLagi = true;
				do{
					do{
						System.out.print("Pilih Bangku: ");
						bangkuUser = huruf.next().toUpperCase();
						int no = encodeNo(bangkuUser);
						int huruf1 = encodeHuruf(bangkuUser);
						//Pengecekkan bangku
						if(bangkuUser.equals(encodeBangku(bangkuUser) )){
							checkBangku = false;
							bangku[no][huruf1] = " X ";
						}
						else{
							checkBangku = true;
							System.out.println("Pilihan Bangku Anda Salah!");
						}
					}while(checkBangku);

					pilihanBangku.add(bangkuUser);
					System.out.print("Apakah Anda Ingin Menambah Bangku Lagi? (Y/N): ");
					String nambah = huruf.next();
					checkLagi = nambah.equalsIgnoreCase("y");

					layarBioskop();

				}while(checkLagi);
				MakanMinum objectMakan = new MakanMinum(huruf,angka);

					// boolean checkMakan = true;
				
					// do{
					// 	System.out.print("Ingin Memesan Makanan/Minuman? (Y/N): ");
					// 	String makan = in.next();
					// 	if(makan.equalsIgnoreCase("y") || makan.equalsIgnoreCase("n")){
					// 		MakanMinum objectMakan = new MakanMinum(in);
					// 		checkMakan = false;
					// 	}
					// 	else{
					// 		checkMakan = true;
					// 	}
					// }while(checkMakan);
	}

	public String encodeBangku(String bangkuUser){
		String [] nomor = bangkuUser.split("\\.");
		int huruf = Integer.parseInt(nomor[0]) - 1; 
		int convertNo = bangkuUser.charAt(bangkuUser.length()-1) - 65;
		// System.out.println(bangku[convertNo][huruf]);
		return bangku[convertNo][huruf];
	}

	public int encodeHuruf(String bangkuUser){
		String [] nomor = bangkuUser.split("\\.");
		int huruf = (Integer.parseInt(nomor[0])) - 1;
		return huruf; 
	}
	public int encodeNo(String bangkuUser){
		int convertNo = bangkuUser.charAt(bangkuUser.length()-1) - 65;
		return convertNo;
	}
	public void layarBioskop(){
		for(int i = 0; i < bangku.length; i++){
				System.out.print("||  ");
				for(int j = 0; j<bangku[0].length; j++){
					System.out.print(bangku[i][j]+" ");
					if((j+1) % 4 == 0 && (j+1) < bangku[0].length){
						System.out.print("|  | ");
						}
					}
					System.out.print(" ||\n");
				}
		System.out.println("||Masuk-----------------------------------------------------Keluar||");		
		System.out.println("--------------------------------------------------------------------");	
		System.out.println(String.format("%-12s----------------------------------------------",""));
		System.out.println(String.format("%-12s|                LAYAR BIOSKOP               |",""));
		System.out.println(String.format("%-12s----------------------------------------------",""));

	}

}