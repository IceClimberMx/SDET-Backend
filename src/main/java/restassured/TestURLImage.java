package restassured;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestURLImage {

	public void openImageFromURL(String URL) {
		Image image = null;
		try {
			URL url = new URL(URL);
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame();
		frame.setSize(800, 800);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);

	}

}