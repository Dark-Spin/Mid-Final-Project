import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GifRunner
{

public static void main(String[] args) throws MalformedURLException {

      
    }

public static void main() throws MalformedURLException
	{
	  URL url = new URL("http://fc06.deviantart.net/fs71/f/2012/088/e/6/skyward_sword_gif_v2_by_shad0w8-d4ubens.gif");
        
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("Animation");
        
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        Scanner input = new Scanner(System.in);
        System.out.println("You have beaten Ganon.");
        int name = input.nextInt();

        if(name == 2)
        	{
        	System.exit(0);
        	}
	
	}
}
