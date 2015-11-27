package esse.Dijkalkulator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

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
	
	//to be accessible:
	JLabel labelCapacityTypes;
	JLabel labelCapacities;
	JLabel labelInput;
	//ctr
	public GUIForDijkalkulator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 700);
		
		getContentPane().setLayout(new MigLayout("", "[grow][][]", "[grow][]"));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[][]", "[][][]"));
		
		labelCapacityTypes = new JLabel("...");
		panel.add(labelCapacityTypes, "cell 1 0");
		
		JButton btnKapacitsokFjlVlaszt = new JButton("Kapacitások fájl választó");
		btnKapacitsokFjlVlaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(
						App.getoGUIForDijkalkulator().getoPointTypesMenuActionListener().getoJDialogPointTypes());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File openedFile = fc.getSelectedFile();
					//TODO logic
					labelCapacities.setText(openedFile.toString());
					labelCapacities.setToolTipText(labelCapacities.getText());
				}
			}
		});
		panel.add(btnKapacitsokFjlVlaszt, "cell 0 1,growx");
		
		labelCapacities = new JLabel("...");
		panel.add(labelCapacities, "cell 1 1");
		
		JButton btnKapacitstpusokFjlVlaszt = new JButton("Kapacitástípusok fájl választó");
		btnKapacitstpusokFjlVlaszt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(
						App.getoGUIForDijkalkulator().getoPointTypesMenuActionListener().getoJDialogPointTypes());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File openedFile = fc.getSelectedFile();
					//TODO logic
					labelCapacityTypes.setText(openedFile.toString());
					labelCapacityTypes.setToolTipText(labelCapacityTypes.getText());
				}
			}
		});
		panel.add(btnKapacitstpusokFjlVlaszt, "cell 0 0");
		
		JButton btnBemenet = new JButton("Bemenet");
		btnBemenet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(
						App.getoGUIForDijkalkulator().getoPointTypesMenuActionListener().getoJDialogPointTypes());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File openedFile = fc.getSelectedFile();
					//TODO logic
					labelInput.setText(openedFile.toString());
					labelInput.setToolTipText(labelCapacityTypes.getText());
				}
			}
		});
		panel.add(btnBemenet, "cell 0 2,growx");
		
		labelInput = new JLabel("...");
		panel.add(labelInput, "cell 1 2");
		
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
