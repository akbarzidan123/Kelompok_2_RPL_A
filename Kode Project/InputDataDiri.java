import java.util.*;
public class InputDataDiri{
	//Variable Class
	public static String nama,email,noTelf;
	public static long saldo;
	boolean cNama,cNo,cSaldo,cEmail;
	// Konstruktor Input data diri
	public InputDataDiri(){
		
	}
	public InputDataDiri(Scanner in){
		inputData(in);
	}

	public void inputData(Scanner in){
		System.out.println("Silahkan Isi Data Diri Anda");
		System.out.println("---------------------------");
		boolean tanyaEmail = true;
		Scanner test = new Scanner(System.in);
		do{
			System.out.print(String.format("%-15s: ","Nama"));
			nama = test.nextLine();
			//Menghindarai karakter selain Huruf
			if(nama.matches("[a-zA-Z\\s]+") && nama.length() > 0 ){
				cNama = false;
			}
			else{
				System.out.println("Inputan Salah !!!");
				cNama=true;
			}
		}while(cNama);

		do{
			System.out.print(String.format("%-15s: ","Nomor Telfon"));
			noTelf = in.next();
				//Pengecekan digit no telfon
				if(noTelf.matches("[0-9]{8,14}")){
					cNo = false;
				}
				else{
					cNo = true;
					System.out.println("Inputan harus berupa Angka (8-14) Digit");
				}
		}while(cNo);
		//Email
		do{
			System.out.print("Ingin Memasukkan Email? (Y/N): ");
			String tesEmail = in.next();
			if(tesEmail.equalsIgnoreCase("Y")){
				do{
					tanyaEmail = false;
					System.out.print(String.format("%-15s: ","Email(Opsional)"));
					email = in.next();
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

		// Isi Saldo
		do{
			System.out.print(String.format("%-15s: Rp.","Isi Saldo"));
			saldo += in.nextLong();
			if(saldo >= 10_000){
				cSaldo = false;
			}
			else{
				System.out.println("Minimal Saldo yang diisi sebesar Rp.10.000");
				cSaldo = true;
			}
		}while(cSaldo);
		checkDataDiri(in);
	}
	public void checkDataDiri(Scanner in){	
		do{	
			System.out.println("---------------------------");
			System.out.println("      Menu Pengecekkan     ");
			System.out.println("---------------------------");
			System.out.println("1. Check Data Diri");
			System.out.println("2. Lanjut Pembayaran");
			System.out.println("3. Isi Saldo");
			System.out.println("4. Batalkan Pemesanan");
			String pilih;
			int pilihNum=0;
			do{
				System.out.print("Pilih: ");
				pilih = in.next();
				pilihNum = 0;
				if(!pilih.matches("[0-9]+")){
						System.out.println("Pilihan Harus Berupa Angka");
					}
				else{
					pilihNum = Integer.parseInt(pilih); 
					if(pilihNum > 0  && pilihNum <= 4){
						break;
					}
					else{
						System.out.println("Pilihan Tidak Valid");
					}
				}
		}while(true);
			switch(pilihNum){
				case 1:
					System.out.println("---------------------------");
					System.out.println("      Data Diri Anda");
					System.out.println("---------------------------");
					System.out.println(String.format("%-15s: "+nama,"Nama"));
					System.out.println(String.format("%-15s: "+noTelf,"Nomor Telfon"));
					System.out.println(String.format("%-15s: "+email,"Email"));
					System.out.println(String.format("%-15s: Rp."+saldo,"Saldo "));
					checkDataDiri(in);
				break;
				case 2:
				Pembayaran objBayar = new Pembayaran(in);
				break;
				case 3:
					System.out.println("---------------------------");
					System.out.println("     Silahkan Isi Saldo    ");
					System.out.println("---------------------------");
					do{
						System.out.print(String.format("Memasukkan Nominal: Rp."));
						saldo += in.nextInt();
						if(saldo >= 10_000){
							cSaldo = false;
						}
						else{
							System.out.println("Minimal Saldo yang diisi sebesar Rp.10.000");
							cSaldo = true;
						}
					}while(cSaldo);
					checkDataDiri(in);
				break;
				case 4:
				System.exit(1);
			}

		}while(true);

	}
}
