import java.util.Scanner;

public class Calculations {

	static String[] IP;
	static String[] SIP;
	static String dIP, sIP, inputIP, inputSIP, inputBIP, inputSBIP, resultIP, resultBIP;
	static boolean binary;

	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Decimal to Binary IP");
			System.out.println("2. Binary IP to Decimal");
			System.out.print("Enter your choice: ");
			input = sc.nextInt();

			// flip the trigger for binary or not
			switch (input) {
			case 1:
				binary = false;
				break;
			case 2:
				binary = true;
				break;
			}

			// read input
			Scanner kb = new Scanner(System.in);
			System.out.print("Enter the ip seperated by periods: ");
			dIP = kb.nextLine();
			IP = dIP.split("\\.");

			System.out.print("Enter subnet mask adress: ");
			sIP = kb.nextLine();
			SIP = sIP.split("\\.");

			// Ask for operation
			operation();
		}
	}

	public static void operation() {
		inputIP = "";
		inputBIP = "";
		inputSIP = "";
		inputSBIP = "";
		resultIP = "";
		resultBIP = "";
		Scanner sc = new Scanner(System.in);
		int input;
		System.out.println("1. AND");
		System.out.println("2. XOR");
		System.out.print("Enter your choice: ");
		input = sc.nextInt();
		switch (input) {
		case 1:
			// Perform AND
			// True triggers AND
			if (binary) {
				binaryCalculation(true);
				printResult();
			} else {
				//true triggers AND
				decimalCalculation(true);
				printResult();
			}
			break;
		case 2:
			// Perform XOR
			// False triggers XOR
			if (binary) {
				binaryCalculation(false);
				printResult();
			} else {
				decimalCalculation(false);
				printResult();
			}
			break;
		}
	}

	private static void printResult() {
		System.out.println("-----------Results-----------");
		System.out.println("IP:\t\t" + inputIP.substring(0, inputIP.length() - 1) + "\t==  "
				+ inputBIP.substring(0, inputBIP.length() - 1));
		System.out.println("Subnet IP:\t" + inputSIP.substring(0, inputSIP.length() - 1) + "\t==  "
				+ inputSBIP.substring(0, inputSBIP.length() - 1));
		System.out.println("Result:\t\t" + resultIP.substring(0, resultIP.length() - 1) + "\t==  "
				+ resultBIP.substring(0, resultBIP.length() - 1) + "\n" + "\n");
	}

	private static void decimalCalculation(boolean operation) {
		for (int i = 0; i < IP.length; i++) {
			inputIP += IP[i] + ".";
			inputBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(IP[i]))).replace(' ', '0') + ".";
			inputSIP += SIP[i] + ".";
			inputSBIP += String.format("%8s", Integer.toBinaryString(Integer.parseInt(SIP[i]))).replace(' ', '0') + ".";
			int result;
			if (operation) {
				result = Integer.parseInt(IP[i]) & Integer.parseInt(SIP[i]);
			} else {
				result = Integer.parseInt(IP[i]) ^ Integer.parseInt(SIP[i]);
			}
			resultIP += result + ".";
			resultBIP += String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0') + ".";
		}
	}
	
	private static void binaryCalculation(boolean operation) {
		for (int i = 0; i < IP.length; i++) {
			inputIP += Integer.parseInt(IP[i], 2) + ".";
			inputBIP += IP[i] + ".";
			inputSIP += Integer.parseInt(SIP[1], 2) + ".";
			inputSBIP += SIP[i] + ".";
			int result;
			if(operation) {
				result = Integer.parseInt(IP[i], 2) & Integer.parseInt(SIP[i], 2);				
			} else {
				result = Integer.parseInt(IP[i], 2) ^ Integer.parseInt(SIP[i], 2);				
			}
			resultIP += result + ".";
			resultBIP += String.format("%8s", Integer.toBinaryString(result)).replace(' ', '0') + ".";
		}
	}
}
