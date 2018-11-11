package pwGen;
import java.util.Scanner;
import java.util.Random;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class Generator {

	public static void main(String[] args) {
		
		String inBuffer = ReadInput();
		PropSet(inBuffer);
		
		
	}
	
	public static void charOutput(int chars, int strength) {
		String[] pwLowSec = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

		String[] pwMedSec = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Ä", "ä", "Ö", "ö", "Ü", "ü", "*", "_"};

		String[] pwHighSec = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Ä", "ä", "Ö", "ö", "Ü", "ü", "*", "_", "-", "?", "!", "#", "$", "%", "&", "/", "(", ")", "=", "^", "°", "<", ">", ":", ";", "@", "€", "~", "+"};

		String genPW = "";
		
		for(int i = 0; i < chars; i++) {
			if(strength == 0) {
				Random r = new Random();
		        int counter = r.nextInt(pwLowSec.length);
		        genPW = genPW + pwLowSec[counter];
			}
			
			if(strength == 1) {
				Random r = new Random();
		        int counter = r.nextInt(pwLowSec.length);
		        genPW = genPW + pwMedSec[counter];
			}
			
			if(strength == 2) {
				Random r = new Random();
		        int counter = r.nextInt(pwHighSec.length);
		        genPW = genPW + pwHighSec[counter];
			}
		}
		
		System.out.println(genPW);
		
		StringSelection stringSelection = new StringSelection(genPW);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		System.out.println();
		main(null);
		
	}
	
	public static String ReadInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password properties: ");
        return scanner.next();
    }
	
	public static void PropSet(String userInput) {
		
		if(userInput.contains("l") | userInput.contains("L")) {
			String[] pwParser = userInput.split("l");
			int pwLength = Integer.parseInt(pwParser[0]);
			charOutput(pwLength, 0);
		}
		
		if(userInput.contains("m") | userInput.contains("M")) {
			String[] pwParser = userInput.split("m");
			int pwLength = Integer.parseInt(pwParser[0]);
			charOutput(pwLength, 1);
		}
		
		if(userInput.contains("h") | userInput.contains("H")) {
			String[] pwParser = userInput.split("h");
			int pwLength = Integer.parseInt(pwParser[0]);
			charOutput(pwLength, 2);
		}
		
	}
	
}
