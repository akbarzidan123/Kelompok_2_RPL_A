import java.util.*;
public class InputDataDiri{
	//Variable Class
	public String nama,email,noTelf;
	public int saldo;
	boolean cNama,cNo,cSaldo,cEmail;
	// Konstruktor Input data diri
	public InputDataDiri(Scanner huruf,Scanner angka){
		inputData(huruf,angka);
	}

	public void inputData(Scanner huruf,Scanner angka){
		System.out.println("Silahkan Isi Data Diri Anda");
		System.out.println("---------------------------");
		boolean tanyaEmail = true;
		Scanner test = new Scanner(System.in);
		do{
			System.out.print(String.format("%-15s: ","Nama"));
			nama = test.nextLine();
			//Menghindarai karakter selain Huruf
			if(!nama.matches(".*[0-9].*") && nama.length() > 0 ){
				cNama = false;
			}
			else{
				System.out.println("Inputan Salah !!!");
				cNama=true;
			}
		}while(cNama);

		do{
			System.out.print(String.format("%-15s: ","Nomor Telfon"));
				noTelf = huruf.next();
				//Pengecekan digit no telfon
				if(noTelf.matches("[0-9]{8,14}")){
					cNo = false;
				}
				else{
					cNo = true;
					System.out.println("Inputan harus berupa Angka (8-14) Digit");
				}
		}while(cNo);

		do{
			System.out.print("Ingin Memasukkan Email? (Y/N): ");
			String tesEmail = huruf.next();
			if(tesEmail.equalsIgnoreCase("Y")){
				do{
					tanyaEmail = false;
					System.out.print(String.format("%-15s: ","Email(Opsional)"));
					email = huruf.next();
						if(email.matches("[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,6}")){
							cEmail = false;
						}
						else{
							cEmail = true;
							System.out.println("Inputan Salah!!");
						}
				}while(cEmail);
			}
				else if(tesEmail.equalsIgnoreCase("N")){
					tanyaEmail = false;
					email = null;
			}
			else{
				tanyaEmail = true;
			}
		}while(tanyaEmail);


		do{
			System.out.print(String.format("%-15s: Rp.","Isi Saldo"));
			saldo = angka.nextInt();
			if(saldo >= 10_000){
				cSaldo = false;
			}
			else{
				System.out.println("Minimal Saldo yang diisi sebesar Rp.10.000");
				cSaldo = true;
			}
		}while(cSaldo);
		checkDataDiri(huruf,angka);
	}
	public void checkDataDiri(Scanner huruf,Scanner angka){	
		do{	
			System.out.println("---------------------------");
			System.out.println("      Menu Pengecekkan     ");
			System.out.println("---------------------------");
			System.out.println("1. Check Data Diri");
			System.out.println("2. Lanjut Pembayaran");
			System.out.print("Pilih: ");
			int pilih = angka.nextInt();
			switch(pilih){
				case 1:
				System.out.println("---------------------------");
				System.out.println("      Data Diri Anda");
				System.out.println("---------------------------");
				System.out.println(String.format("%-15s: "+nama,"Nama"));
				System.out.println(String.format("%-15s: "+noTelf,"Nomor Telfon"));
				System.out.println(String.format("%-15s: "+email,"Email"));
				System.out.println(String.format("%-15s: Rp."+saldo,"Saldo "));
				checkDataDiri(huruf,angka);
				break;
				case 2:
				break;
			}
		}while(false);

	}
}