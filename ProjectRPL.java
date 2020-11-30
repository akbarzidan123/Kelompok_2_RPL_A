import java.util.*;
public class ProjectRPL{
	public static void main(String[] args) {
		Scanner huruf = new Scanner(System.in);
		Scanner angka = new Scanner(System.in);
		System.out.println("-----------------------------------------");
		System.out.println("      Selamat Datang Di....         ");
		System.out.println("-----------------------------------------");
		// InputDataDiri inp = new InputDataDiri(in);
		FilmBioskop film = new FilmBioskop(huruf,angka);
	}
}