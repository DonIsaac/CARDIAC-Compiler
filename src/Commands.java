
public class Commands {
	public static String getBasicCommand(String[] cmd) {
		switch (cmd[0]) {
		case "INP":// INP addr
			return ("0" + cmd[1]);
		case "CLA":// CLA addr
			return ("1" + cmd[1]);
		case "ADD":// CLA addr
			return ("2" + cmd[1]);
		case "TAC":// TAC addr
			return ("3" + cmd[1]);
		case "SFT":// SFT lshift, rshift
			return ("4" + cmd[1]);
		case "OUT":// OUT addr
			return ("5" + cmd[1]);
		case "STO":// STO addr
			return ("6" + cmd[1]);
		case "SUB":// SUB addr
			return ("7" + cmd[1]);
		case "JMP":// JMP addr
			return ("8" + cmd[1]);
		case "HRS":// HRS addr
			return ("9" + cmd[1]);
		default:
			System.out.println("DNE: "+cmd[0]);
			return "DNE";
		}
		
	}
}
