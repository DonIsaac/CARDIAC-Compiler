import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Index {
	static Scanner scan;

	public static void main(String[] args) throws IOException {
		File in, out;
		BufferedWriter writer;
		ArrayList<String> writeableCode = new ArrayList<String>(512);

		if (args.length != 2) {
			throw new IllegalArgumentException(
					"You must pass both a path for the assembly code and the destination to compile to!");
		}

		in = new File(args[0]);
		out = new File(args[1]);
		out.createNewFile();
		scan = new Scanner(in);
		writer = new BufferedWriter(new FileWriter(out));
		int lineNum = 0;

		while (scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			if(line.equals("")) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
				break;
			}
			System.out.println("raw: " + line);
			String[] cmd = lineToCmdArray(line);
			System.out.println("LEN: "+cmd.length);
			System.out.println("OPCODE: "+cmd[0]);
			if (!cmd[0].substring(0, 2).equals("//")) {
				
			switch (cmd[0]) {
			case "BTSP":// BTSP startAddr
				ArrayList<String> codes = new ArrayList<String>();
				for (String[] nextLine = lineToCmdArray(
						scan.nextLine().trim()); nextLine[0].equals("ENDBTSP"); nextLine = lineToCmdArray(
								scan.nextLine().trim()), lineNum++) {
					String commands = Commands.getBasicCommand(nextLine);
					if (commands.equals("DNE")) {
						throw new UnsupportedOperationException("Illegal opcode on line " + lineNum);
					}
				}
				writeableCode.add("002");
				writeableCode.add("800");
				
				break;
			case "DATA":
				writeableCode.add(cmd[1]);
				break;
			case "ENDBTSP":
				break;
			default:
				String basicCmd = Commands.getBasicCommand(cmd);

				if (basicCmd.equals("DNE"))
					throw new UnsupportedOperationException("Illegal opcode on line " + lineNum);
				else
					writeableCode.add(basicCmd);
			}
			System.out.println("output: "+writeableCode.get(writeableCode.size()-1));
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
			lineNum++;
		} // end while

		for (String s : writeableCode) {
			writer.write(s + "\n");
		}
		writer.close();
	}

	public static String[] lineToCmdArray(String line) {

		ArrayList<String> params = new ArrayList<String>(5);

		for (String s : line.split(" ")) {
			if (!s.equals("")) {
				params.add(s);
			}
		}
		return params.toArray(new String[0]);
	}
}
