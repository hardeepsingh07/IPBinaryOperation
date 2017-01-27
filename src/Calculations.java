import java.util.Scanner;

public class Calculations {

	static String dIP;
	static String sIP;
	static String [] IP;
	static String [] SIP;
	public static void main(String[] args) {	
		int input;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Decimal to Binary IP");
			System.out.println("2. Binary IP to Decimal");
			System.out.print("Enter your choice: ");
			input = sc.nextInt();
			
			switch(input) {
			case 1:
				Scanner kb = new Scanner(System.in);
				System.out.print("Enter the ip seperated by periods: ");
				dIP = kb.nextLine();
				IP = dIP.split("\\.");
				
				System.out.print("Enter subnet mask adress: ");
				sIP = kb.nextLine();
				SIP = sIP.split("\\.");
					
//				Ask for operation
				operation();
				break;
			case 2:
//				String s1 = "11111111";
//				System.out.println(Integer.parseInt(s1, 2));
				break;
			}
			
		}
	}
	
	public static void operation() {
		Scanner sc = new Scanner(System.in);
		int input;
		String inputIP = "", inputSIP = "";
		String inputBIP = "", inputSBIP = ""; 
		String resultIP = "", resultBIP = "";
		System.out.println("1. AND");
		System.out.println("2. XOR");
		System.out.print("Enter your choice: ");
		input = sc.nextInt();
		switch(input) {
		case 1:
			//Perform AND
			for(int i = 0; i < IP.length; i++) {
				inputIP += IP[i] + ".";
				inputBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(IP[i]))).replace(' ', '0') + ".";
				inputSIP += SIP[i] + ".";
				inputSBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(SIP[i]))).replace(' ', '0') + ".";
				int result = Integer.parseInt(IP[i]) & Integer.parseInt(SIP[i]);
				resultIP += result + ".";
				resultBIP += String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0') + ".";
			}
			System.out.println("-----------Results-----------");
			System.out.println("IP:\t\t" + inputIP.substring(0, inputIP.length() -1) 
			+ "\t==  " + inputBIP.substring(0, inputBIP.length() -1));
			System.out.println("Subnet IP:\t" + inputSIP.substring(0, inputSIP.length() -1)
			+ "\t==  " + inputSBIP.substring(0, inputSBIP.length() -1));
			System.out.println("Result:\t\t" + resultIP.substring(0, resultIP.length() -1)
			+ "\t==  " + resultBIP.substring(0, resultBIP.length() -1) + "\n" + "\n");
			break;
		case 2:	
			inputIP = ""; inputBIP = ""; inputSIP = ""; inputSBIP = ""; resultIP = ""; resultBIP = "";
			//Perform XOR
			for(int i = 0; i < IP.length; i++) {
				inputIP += IP[i] + ".";
				inputBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(IP[i]))).replace(' ', '0') + ".";
				inputSIP += SIP[i] + ".";
				inputSBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(SIP[i]))).replace(' ', '0') + ".";
				int result = Integer.parseInt(IP[i]) ^ Integer.parseInt(SIP[i]);
				resultIP += result + ".";
				resultBIP += String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0') + ".";
			}
			System.out.println("-----------Results-----------");
			System.out.println("IP:\t\t" + inputIP.substring(0, inputIP.length() -1) 
			+ "\t==  " + inputBIP.substring(0, inputBIP.length() -1));
			System.out.println("Subnet IP:\t" + inputSIP.substring(0, inputSIP.length() -1)
			+ "\t==  " + inputSBIP.substring(0, inputSBIP.length() -1));
			System.out.println("Result:\t\t" + resultIP.substring(0, resultIP.length() -1)
			+ "\t==  " + resultBIP.substring(0, resultBIP.length() -1) + "\n" + "\n");
			break;
		}
	}
	
	public static void convertToBinary(String [] result) {
		//convert
		String binaryRep = "";
		for(int i = 0; i < result.length; i++) {
			int t = Integer.parseInt(result[i]);
			binaryRep += String.format("%8s", Integer.toBinaryString(t)).replace(' ', '0');
		}
		System.out.println(binaryRep);
	}
	

}
