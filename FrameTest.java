import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class FrameTest extends JFrame{
    JButton changeButton = null;
	/**
	 * @param args
	 */
	public FrameTest(String appTitle){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(appTitle);
		this.setBounds(100, 100, 500, 250);
		this.setContentPane(getFrameCont());

		/*this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Click! "+SwingUtilities.isEventDispatchThread());
			}
		});*/
		//this.setVisible(true);
	}

	/**/
	private JPanel getFrameCont(){
		JPanel contPanel = new JPanel();
		contPanel.setLayout(new BorderLayout());
		final JFrame parent = this;
		if(changeButton == null){
			changeButton = new JButton("Push");
			changeButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(parent ,"Push!");
				}
			});
		}

		contPanel.add(changeButton ,BorderLayout.NORTH);
		return contPanel;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				FrameTest framTest = new FrameTest("Test");
				framTest.setVisible(true);
			}
		});

		//System.out.println("コンソール");
	}

}
