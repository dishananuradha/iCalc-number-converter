import java.util.*;
class NumberConverter{
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		L1:while(true){
			System.out.println("\n\n\n");
			System.out.println("\t\t\t\t\t __   ______             __            ");
			System.out.println("\t\t\t\t\t|  \\ /      \\           |  \\           ");
			System.out.println("\t\t\t\t\t \\$$|  $$$$$$\\  ______  | $$  _______  ");
			System.out.println("\t\t\t\t\t|  \\| $$   \\$$ |      \\ | $$ /       \\ ");
			System.out.println("\t\t\t\t\t| $$| $$        \\$$$$$$\\| $$|  $$$$$$$ ");
			System.out.println("\t\t\t\t\t| $$| $$   __  /      $$| $$| $$       ");
			System.out.println("\t\t\t\t\t| $$| $$__/  \\|  $$$$$$$| $$| $$_____  ");
			System.out.println("\t\t\t\t\t| $$ \\$$    $$ \\$$    $$| $$ \\$$     \\ ");
			System.out.println("\t\t\t\t\t \\$$  \\$$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$ ");
			System.out.println();
			System.out.println("  _   _                       _                        _____                                         _                          ");
			System.out.println(" | \\ | |                     | |                      / ____|                                       | |                        ");
			System.out.println(" |  \\| |  _   _   _ __ ___   | |__     ___   _ __    | |        ___    _ __   __   __   ___   _ __  | |_    ___   _ __         ");
			System.out.println(" | . ` | | | | | | '_ ` _ \\  | '_ \\   / _ \\ | '__|   | |       / _ \\  | '_ \\  \\ \\ / /  / _ \\ | '__| | __|  / _ \\ | '__|");
			System.out.println(" | |\\  | | |_| | | | | | | | | |_) | |  __/ | |      | |____  | (_) | | | | |  \\ v /  |  __/ | |    | |_  |  __/ | |          ");
			System.out.println(" |_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|       \\_____|  \\___/  |_| |_|   \\_/    \\___| |_|     \\__|  \\___| |_|   ");
			System.out.println("\n========================================================================================================================");
			System.out.println("\n\n\n\t[01] Decimal converter ");
			System.out.println("\n\t[02] Binary converter ");
			System.out.println("\n\t[03] Octal converter ");
			System.out.println("\n\t[04] Hexadecimal converter ");
			System.out.println("\n\t[05] Roman Number converter ");

			System.out.print("\n\nEnter option -> ");
			int option1  = input.nextInt();
			
			switch(option1){
				case 1 : 
					while(true){
						clearConsole();
						
						System.out.println("+-----------------------------------------------+");
						System.out.println("|\t\tDecimal Converter\t\t|");
						System.out.println("+-----------------------------------------------+");
					
						System.out.print("\n\nEnter a Decimal number : ");
						int decimal = input.nextInt();
						
						//check number validation
						int temp = decimal;
						boolean isDecimal = true;
						while(temp != 0){
							int digit = temp%10;
							if(digit < 0 || digit > 9){
								isDecimal = false;
								break;
							}
							temp = temp/10;
						}
					
						boolean isValid = ((decimal >=0) && (isDecimal == true));
					
						if(isValid){
							//if valid...
							//decimal to binary value
							temp = decimal;
							String binary = "";
							while(temp != 0){
								int remainder = temp%2;
								binary = remainder + binary;
								temp = temp/2;
							}
							System.out.println("\n\tBinary number\t\t: "+binary);
							
							//decimal to octal value
							temp = decimal;
							String octal = "";
							while(temp != 0){
								int remainder = temp%8;
								octal = remainder + octal;
								temp = temp/8;
							}
							System.out.println("\tOctal number\t\t: "+octal);
							
							//decimal to hexadecimal value
							temp = decimal;
							String hexa = "";
							while(temp != 0){
								int remainder = temp%16;
								if(remainder < 10){
									hexa = remainder + hexa;
								}else{
									char ch = (char)('A' + (remainder - 10));
									hexa = ch + hexa;
								}
								temp = temp/16;
							}
							System.out.println("\tHexadecimal number\t: "+hexa);
							
							//return to homepage or not?
							System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue L1;
							}else{
								break L1;
							}
							
						}else{
							//if not valid
							System.out.println("\tInvalid input...");
							System.out.print("\nDo you want to input number again? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue;
							}else{
								continue L1;
							}
						}
					}
				case 2 : 
					while(true){
						clearConsole();
						
						System.out.println("+-----------------------------------------------+");
						System.out.println("|\t\tBinary Converter\t\t|");
						System.out.println("+-----------------------------------------------+");
					
						System.out.print("\n\nEnter a Binary number : ");
						long binary = input.nextLong();
						
						//check number validation
						long temp = binary;
						boolean isBinary = true;
						while(temp != 0){
							long digit = temp%10;
							if(digit != 0 && digit != 1 ){
								isBinary = false;
								break;
							}
							temp = temp/10;
						}
						
						if(isBinary){
							//if valid...
							//binary to decimal value
							temp = binary;
							long decimal = 0;
							long power = 0;
							while (temp != 0) {
								long digit = temp%10;
								decimal = (long)(decimal + digit*Math.pow(2, power));
								temp = temp/10;
								power++;
							}
							System.out.println("\n\tDecimal number\t\t: " + decimal);
							
							//binary to octal value(decimal to octal)
							temp = decimal;
							String octal = "";
							while(temp != 0){
								long remainder = temp%8;
								octal = remainder + octal;
								temp = temp/8;
							}
							System.out.println("\tOctal number\t\t: "+octal);
							
							//binary to hexadecimal value(decimal to hexadecimal)
							temp = decimal;
							String hexa = "";
							while(temp != 0){
								long remainder = temp%16;
								if(remainder < 10){
									hexa = remainder + hexa;
								}else{
									char ch = (char)(remainder - 10 + 'A');
									hexa = ch + hexa;
								}
								temp = temp/16;
							}
							System.out.println("\tHexadecimal number\t: "+hexa);
							
							//return to homepage or not?
							System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue L1;
							}else{
								break L1;
							}
							
						}else{
							//if not valid
							System.out.println("\tInvalid input...");
							System.out.print("\nDo you want to input number again? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue;
							}else{
								continue L1;
							}
						}
					}
				case 3 : 
					while(true){
						clearConsole();
						
						System.out.println("+-----------------------------------------------+");
						System.out.println("|\t\tOctal Converter\t\t\t|");
						System.out.println("+-----------------------------------------------+");
					
						System.out.print("\n\nEnter an Octal number : ");
						int octal = input.nextInt();
						
						//check number validation
						int temp = octal;
						boolean isOctal = true;
						while(temp != 0){
							int digit = temp%10;
							if(digit < 0 || digit > 7){
								isOctal = false;
								break;
							}
							temp = temp/10;
						}
						
						if(isOctal){
							//if valid...
							//octal to decimal value
							temp = octal;
							int decimal = 0;
							int power = 0;
							while (temp != 0) {
								int digit = temp%10;
								decimal = (int)(decimal + digit*Math.pow(8, power));
								temp = temp/10;
								power++;
							}
							System.out.println("\n\tDecimal number\t\t: " + decimal);
							
							//octal to binary value(decimal to binary)
							temp = decimal;
							String binary = "";
							while(temp != 0){
								int remainder = temp%2;
								binary = remainder + binary;
								temp = temp/2;
							}
							System.out.println("\tBinary number\t\t: "+binary);
							
							//octal to hexadecimal value(decimal to hexadecimal)
							temp = decimal;
							String hexa = "";
							while(temp != 0){
								long remainder = temp%16;
								if(remainder < 10){
									hexa = remainder + hexa;
								}else{
									char ch = (char)(remainder - 10 + 'A');
									hexa = ch + hexa;
								}
								temp = temp/16;
							}
							System.out.println("\tHexadecimal number\t: "+hexa);
							
							//return to homepage or not?
							System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue L1;
							}else{
								break L1;
							}
							
						}else{
							//if not valid
							System.out.println("\tInvalid input...");
							System.out.print("\nDo you want to input number again? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue;
							}else{
								continue L1;
							}
						}
						
					}
				case 4 :
					while(true){
						clearConsole();
						
						System.out.println("+-----------------------------------------------+");
						System.out.println("|\t\tHexadecimal Converter\t\t|");
						System.out.println("+-----------------------------------------------+");
					
						System.out.print("\n\nEnter a Hexadecimal number : ");
						String hexa = input.next().toUpperCase();
						
						//check number validation
						boolean isHexadecimal = true;
						for (int i = 0; i < hexa.length(); i++) {
							char ch = hexa.charAt(i);
							if (!((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F'))) {
								isHexadecimal = false;
								break;
							}
						}
					
						if(isHexadecimal){
							//if isHexadecimal...
							//hexa to decimal value
							int decimal = 0;
							for (int i = 0; i < hexa.length(); i++) {
								char digit = hexa.charAt(i);
								int digitValue = 0;
								if (digit >= '0' && digit <= '9') {
									digitValue = digit - '0';
								} else if (digit >= 'A' && digit <= 'F') {
									digitValue = digit - 'A' + 10;
								}
								decimal = decimal * 16 + digitValue;
							}
							System.out.println("\n\tDecimal number\t: " + decimal);
							
							//hexa to binary value(decimal to binary)
							int temp = decimal;
							String binary = "";
							while(temp != 0){
								int remainder = temp%2;
								binary = remainder + binary;
								temp = temp/2;
							}
							System.out.println("\tBinary number\t: "+binary);
							
							//hexa to octal value(decimal to octal)
							temp = decimal;
							String octal = "";
							while(temp != 0){
								int remainder = temp%8;
								octal = remainder + octal;
								temp = temp/8;
							}
							System.out.println("\tOctal number\t: "+octal);
							
							//return to homepage or not?
							System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue L1;
							}else{
								break L1;
							}
							
						}else{
							//if not isHexadecimal...
							System.out.println("\tInvalid input...");
							System.out.print("\nDo you want to input number again? (Y/N)-> ");
							char choice = input.next().charAt(0);
							
							clearConsole();
							
							if(choice == 'Y' || choice == 'y'){
								continue;
							}else{
								continue L1;
							}
						}
					}
				case 5 :  
					while(true){
						clearConsole();
						
						System.out.println("+-----------------------------------------------+");
						System.out.println("|\t\tRoman Number Converter\t\t|");
						System.out.println("+-----------------------------------------------+");
						System.out.println("\n\n\t[01] Decimal Number to Roman Number Converter");
						System.out.println("\n\t[02] Roman Number to Decimal Number Converter");
						System.out.print("\n\nEnter an option : ");
						int option2  = input.nextInt();
						
						switch(option2){
							case 1 :
								while(true){
									clearConsole();
						
									System.out.println("+-------------------------------------------------------+");
									System.out.println("|\tDecimal Number to Roman Number Converter\t|");
									System.out.println("+-------------------------------------------------------+");
								
									System.out.print("\n\nEnter a Decimal number : ");
									int decimal = input.nextInt();
									
									//check number validation
									int temp = decimal;
									boolean isDecimal = true;
									while(temp != 0){
										int digit = temp%10;
										if(digit < 0 || digit > 9){
											isDecimal = false;
											break;
										}
										temp = temp/10;
									}
								
									boolean isValid = ((decimal >=0) && (isDecimal == true));
									
									temp = decimal;
									if(isValid){
										//if valid...
										//decimal to roman
										String roman = "";
										
										while (temp >= 1000) {
										  roman += "M";
										  temp -= 1000;
										}
										while (temp >= 900) {
										  roman += "CM";
										  temp -= 900;
										}
										while (temp >= 500) {
										  roman += "D";
										  temp -= 500;
										}
										while (temp >= 400) {
										  roman += "CD";
										  temp -= 400;
										}
										while (temp >= 100) {
										  roman += "C";
										  temp -= 100;
										}
										while (temp >= 90) {
										  roman += "XC";
										  temp -= 90;
										}
										while (temp >= 50) {
										  roman += "L";
										  temp -= 50;
										}
										while (temp >= 40) {
										  roman += "XL";
										  temp -= 40;
										}
										while (temp >= 10) {
										  roman += "X";
										  temp -= 10;
										}
										while (temp >= 9) {
										  roman += "IX";
										  temp -= 9;
										}
										while (temp >= 5) {
										  roman += "V";
										  temp -= 5;
										}
										while (temp >= 4) {
										  roman += "IV";
										  temp -= 4;
										}
										while (temp >= 1) {
										  roman += "I";
										  temp -= 1;
										}
										System.out.println("\n\tRoman numeral\t: " + roman);
										
										//return to homepage or not?
										System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
										char choice = input.next().charAt(0);
										
										clearConsole();
										
										if(choice == 'Y' || choice == 'y'){
											continue L1;
										}else{
											break L1;
										}
										
									}else{
										//if not valid
										System.out.println("\tInvalid input...");
										System.out.print("\nDo you want to input number again? (Y/N)-> ");
										char choice = input.next().charAt(0);
										
										clearConsole();
										
										if(choice == 'Y' || choice == 'y'){
											continue;
										}else{
											continue L1;
										}
									}
								}
							case 2 :
								clearConsole();
					
								System.out.println("+-------------------------------------------------------+");
								System.out.println("|\tRoman Number to Decimal Number Converter\t|");
								System.out.println("+-------------------------------------------------------+");
							
								System.out.print("\n\nEnter a Roman number : ");
								String roman = input.next();
								
								int decimalValue = 0;
	
								for (int i = 0; i < roman.length(); i++) {
									char currentSymbol = roman.charAt(i);
									int currentValue = 0;
									switch (currentSymbol) {
										case 'I':
											currentValue = 1;
											break;
										case 'V':
											currentValue = 5;
											break;
										case 'X':
											currentValue = 10;
											break;
										case 'L':
											currentValue = 50;
											break;
										case 'C':
											currentValue = 100;
											break;
										case 'D':
											currentValue = 500;
											break;
										case 'M':
											currentValue = 1000;
											break;
										default:
											System.out.println("Invalid Roman numeral.");
											return;
									}

									if (i < roman.length() - 1) {
										char nextSymbol = roman.charAt(i + 1);
										int nextValue = 0;
										switch (nextSymbol) {
											case 'I':
												nextValue = 1;
												break;
											case 'V':
												nextValue = 5;
												break;
											case 'X':
												nextValue = 10;
												break;
											case 'L':
												nextValue = 50;
												break;
											case 'C':
												nextValue = 100;
												break;
											case 'D':
												nextValue = 500;
												break;
											case 'M':
												nextValue = 1000;
												break;
											default:
												System.out.println("Invalid Roman numeral.");
												return;
										}

										if (currentValue < nextValue) {
											decimalValue -= currentValue;
										} else {
											decimalValue += currentValue;
										}
									} else {
										decimalValue += currentValue;
									}
								}
								System.out.println("\n\tDecimal number: " + decimalValue);
								
								//return to homepage or not?
									System.out.print("\n\nDo you want to go to homepage? (Y/N)-> ");
									char choice = input.next().charAt(0);
									
									clearConsole();
									
									if(choice == 'Y' || choice == 'y'){
										continue L1;
									}else{
										break L1;
									}
								
						}
					}
				default : 
					System.out.println("\tinvalid option... ");
					
					try {
						Thread.sleep(750); // Delay for 0.75 seconds
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				clearConsole();
			}
		}	
	}
}
