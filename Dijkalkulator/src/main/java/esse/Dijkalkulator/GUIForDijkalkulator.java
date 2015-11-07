package esse.Dijkalkulator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dialog;

import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIForDijkalkulator extends JFrame {
	PointTypesMenuActionListener oPointTypesMenuActionListener = new PointTypesMenuActionListener();
	public PointTypesMenuActionListener getoPointTypesMenuActionListener() {
		return oPointTypesMenuActionListener;
	}
	
	public void setoPointTypesMenuActionListener(PointTypesMenuActionListener oPointTypesMenuActionListener) {
		this.oPointTypesMenuActionListener = oPointTypesMenuActionListener;
	}
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
		
//		mntmPontTpusok.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				JFramePointTypes jfpt = new JFramePointTypes();
//				jfpt.setVisible(true);
//			}
//		});
		mnFile.add(mntmPontTpusok);
		
		JMenuItem mntmPontok = new JMenuItem("Pontok");
		mnFile.add(mntmPontok);
	}

}
