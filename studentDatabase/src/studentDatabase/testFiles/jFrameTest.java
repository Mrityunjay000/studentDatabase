package studentDatabase;
import javax.swing.*;
import java.awt.GraphicsConfiguration;

public class jFrameTest {
	
	static GraphicsConfiguration gc;

	public static void main (String[] args) {
		System.out.println("frame created");
		//JFrame frame = new JFrame(gc);
		//frame.setVisible(true);
		//frame.pack();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame frame = new JFrame("BatmanVSuperman");
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("this is a new JLabel");
		
		panel.add(label);
		frame.add(panel);
		
		
		
	}

	
}
