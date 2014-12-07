import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class MAIN {

	public static void main(String[] args) {

		String s = JOptionPane.showInputDialog("please enter ur data :");
		Hofman h1 = new Hofman();
		
		JOptionPane.showMessageDialog(null, "data after addition: "+h1.stringCounter(s),"the data after addition"
				,JOptionPane.PLAIN_MESSAGE);
		
		try {
			BufferedWriter in = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File("keko.txt"))));
			in.write(s.toString());
			in.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
