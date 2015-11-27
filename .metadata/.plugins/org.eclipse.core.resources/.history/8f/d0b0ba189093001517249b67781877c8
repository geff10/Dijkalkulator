package esse.Dijkalkulator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class GUIForDijkalkulator extends JFrame {
	PointTypesMenuActionListener oPointTypesMenuActionListener = new PointTypesMenuActionListener();
	public PointTypesMenuActionListener getoPointTypesMenuActionListener() {
		return oPointTypesMenuActionListener;
	}
	
	public void setoPointTypesMenuActionListener(PointTypesMenuActionListener oPointTypesMenuActionListener) {
		this.oPointTypesMenuActionListener = oPointTypesMenuActionListener;
	}
	PointsMenuActionListener oPointsMenuActionListener = new PointsMenuActionListener();
	public PointsMenuActionListener getoPointsMenuActionListener() {
		return oPointsMenuActionListener;
	}
	
	public void setoPointsMenuActionListener(PointsMenuActionListener oPointsMenuActionListener) {
		this.oPointsMenuActionListener = oPointsMenuActionListener;
	}
	
	//ctr
	public GUIForDijkalkulator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		
		getContentPane().setLayout(new MigLayout("", "[grow][][]", "[grow][]"));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmPontTpusok = new JMenuItem("Pont típusok");		
		mntmPontTpusok.addActionListener(oPointTypesMenuActionListener);
		mnFile.add(mntmPontTpusok);
		
		JMenuItem mntmPontok = new JMenuItem("Pontok");
		mntmPontok.addActionListener(oPointsMenuActionListener);
		mnFile.add(mntmPontok);
	}//ctr

}
