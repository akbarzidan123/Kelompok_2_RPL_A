import java.util.*;
public class Pembayaran{
	static String nama,film,waktuFilm;
	//Konstruktor Pembayaran
	public Pembayaran(Scanner in){
		FilmBioskop objFilm = new FilmBioskop();
		MakanMinum objMakan = new MakanMinum();
		InputDataDiri objData = new InputDataDiri();
		bayar(in,objFilm,objMakan,objData);
	}

	public static void bayar(Scanner in, FilmBioskop objFilm, MakanMinum objMakan,InputDataDiri objData){
		//Deklarasi nama objek
		nama = objData.nama;
		film = objFilm.film[objFilm.pilihFilm-1][0];
		waktuFilm = objFilm.film[objFilm.pilihFilm][1];
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("		Menu Pembayaran");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println(String.format("%-18s: "+nama,"Nama Pemesan"));
		System.out.println(String.format("%-18s: "+film,"Judul Film"));
		System.out.println(String.format("%-18s: "+kodeTiket(objFilm,film,nama),"Kode Tiket"));
		// 2 huruf depan judul film, kode bangku(bangku yang pertama dipesan),2 huruf nama pemesan
		System.out.println(String.format("%-18s: "+objFilm.pilihanBangku.size(),"Jumlah Kursi"));

		System.out.print(String.format("%-18s: ","Nomor Kursi"));
		for (int i = 0;i < objFilm.pilihanBangku.size() ; i++ ) {
			if(i == 0)
				System.out.println("("+objFilm.pilihanBangku.get(i)+")");
			else if(i >=1){
				System.out.print(String.format("%-19s ("+objFilm.pilihanBangku.get(i)+")\n",""));	
			}
		}

		if(objMakan.makananUser.size() > 0 || objMakan.minumanUser.size() > 0){
			System.out.print(String.format("%-18s: ","Makanan"));// Opsional
			for (int i = 0;i < objMakan.makananUser.size() ; i++ ) {
				if(i == 0)
					System.out.println(String.format("%-15s sebanyak X"+objMakan.jumMakananUser.get(i), objMakan.makananUser.get(i)));
				else if(i >=1){
					System.out.println(String.format("%-19s %-15s sebanyak X"+objMakan.jumMakananUser.get(i),"", 
						objMakan.makananUser.get(i)));	
				}		
			}
			System.out.print(String.format("%-18s: ","Minuman"));// Opsional
			for (int i = 0;i < objMakan.minumanUser.size() ; i++ ) {
				if(i == 0)
					System.out.println(String.format("%-15s sebanyak X"+objMakan.jumMinumanUser.get(i), objMakan.minumanUser.get(i)));
				else if(i >=1){
					System.out.println(String.format("%-19s %-15s sebanyak X"+objMakan.jumMinumanUser.get(i),"", 
						objMakan.minumanUser.get(i)));	
				}		
			}
		}
		
		long totalHarga = (objMakan.totalMakanan+objMakan.totalMinuman+objFilm.totalHargaFilm);

		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println(String.format("%-18s: Rp."+totalHarga,"Total Pembayaran"));
		if((objData.saldo-totalHarga) >= 0){
			System.out.println("YEEEEEYY PEMBELIAN BERHASIL");
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
			System.out.println(String.format("%-18s: Rp."+(objData.saldo-totalHarga),"Sisa Saldo"));
			System.exit(0);
		}
		else{
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
			System.out.println("Maaf Saldo Anda Tidak Mencukupi !!!");
			objData.checkDataDiri(in);
		}
	}
	public static String kodeTiket(FilmBioskop objFilm, String film, String nama){
		String bangku = objFilm.pilihanBangku.get(0).replace(".","");
		String kode = film.substring(0,2) +"-"+ bangku +"-"+ nama.substring(0,2);
		return kode;
	}
}
