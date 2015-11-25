package esse.Dijkalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class JDialogPoints extends JDialog {
	Properties props = new Properties();
	CapacityConfigManager ccM = CapacityConfigManager.getInstance();

	private JTable tablePointTypes;
	private JTable tablePointTypes_1;
	final DefaultTableModel tableModelP;
	boolean isConfigurationSaved = false;
	String defaultConfigFile = System.getProperty("user.dir") + System.getProperty("file.separator")
			+ "point_type.config";
	String lastConfigFile = "";
	String defaultTitle = "Pontcsoportok";

	public JDialogPoints() {
		setTitle(defaultTitle);
		this.setSize(613, 400);
		this.setModal(true);
		getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][]"));

		JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 0 0,grow");

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		tablePointTypes_1 = new JTable();

		scrollPane.setViewportView(tablePointTypes_1);

		Object[][] data = new Object[][] {};

		tableModelP = new DefaultTableModel(data, new String[] { "Pontcsoport", "Ár[Ft/MJ/óra/év]" });
		tablePointTypes_1.setModel(tableModelP);
		tableModelP.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent tme) {
				if (tme.getType() == TableModelEvent.UPDATE) { // something
																// changed
					isConfigurationSaved = false;
				}
			}
		});

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[61px]", "[23px][]"));

		JButton btnUjSor = new JButton("Új sor");
		btnUjSor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addRow();
			}
		});
		panel_1.add(btnUjSor, "cell 0 0,alignx left,aligny top");

		JButton btnTorles = new JButton("Törlés");
		btnTorles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteRow(tablePointTypes_1.getSelectedRow());
			}
		});
		panel_1.add(btnTorles, "cell 0 1");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmMegnyitas = new JMenuItem("Megnyitás");
		mntmMegnyitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(
						App.getoGUIForDijkalkulator().getoPointTypesMenuActionListener().getoJDialogPointTypes());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File openedFile = fc.getSelectedFile();
					lastConfigFile = openedFile.toString();
					setJDialogTitleWithFileName();

					try {
						ccM.setCtFile(openedFile.toString());
						ccM.ReadCapacityTypes();
						props = ccM.getCapacityTypesProp();
						setTableModel();
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, "Nem létező fájl.", "Hiba", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Ki/bemeneti hiba.", "Hiba", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Sajnálatos hiba történt.", "Hiba",
								JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}

				}
			}
		});// mntmMegnyitas.addActionListener
		mnFile.add(mntmMegnyitas);

		JMenuItem mntmMentes = new JMenuItem("Mentés");
		mntmMentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!isConfigurationSaved) {
					if (lastConfigFile.isEmpty()) {
						if (!configFileExists()) {
							saveFileWithDialog();
						} else
							saveSimply(defaultConfigFile);
					} else
						saveSimply(lastConfigFile);
				}
			}

		});
		mnFile.add(mntmMentes);

		JMenuItem mntmMentesMaskent = new JMenuItem("Mentés másként...");
		mntmMentesMaskent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFileWithDialog();
			}
		});
		mnFile.add(mntmMentesMaskent);

	}// JDialogPointTypes

	// --------methods-----------------------------------------------------------
	private void addRow() {
		Object[] row = new Object[2];
		row[0] = "";
		row[1] = "";
		tableModelP.addRow(row);
	}// addRow()

	private void deleteRow(int i) {
		if (i == -1) // no rows
			return;
		if (JOptionPane.showConfirmDialog(this, "Valóban törölni szeretné a kijelölt sort?", "Törlés?",
				JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
			tableModelP.removeRow(i);
	}// deleteRow

	private void saveFileWithDialog() {
		 // are there rows to save 
		if (tableModelP.getRowCount() != 0){
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showSaveDialog(App.getoGUIForDijkalkulator().getoPointTypesMenuActionListener()
					.getoJDialogPointTypes()) == JFileChooser.APPROVE_OPTION) {
				File fileToSave = fileChooser.getSelectedFile();
				if (props != null) {
					copyTable2Props();
					saveSimply(fileToSave.toString());
				}
			} // if file was selected
		}
		else
			JOptionPane.showMessageDialog(null, "Nincsenek sorok.", "Hiba",
					JOptionPane.ERROR_MESSAGE);
	} // saveFileWithDialog()

	private boolean configFileExists() {
		File f = new File(defaultConfigFile);
		if (f.exists() && !f.isDirectory())
			return true;
		return false;
	}// configFileExists

	private void saveSimply(String file2Save) {
		if (tableModelP.getRowCount() == 0) // nothing to save
			return;
		File fileToSave = new File(file2Save);
		if (props != null) {
			copyTable2Props();
			try {
				ccM.setCapacityTypesProp(props);
				ccM.setCtFile(fileToSave.toString());
				ccM.WriteCapacityTypes();
				lastConfigFile = fileToSave.toString();
				setJDialogTitleWithFileName();
				isConfigurationSaved = true;
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "Nem létező fájl.", "Hiba", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Ki/bemeneti hiba.", "Hiba", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Sajnálatos hiba történt.", "Hiba", JOptionPane.ERROR_MESSAGE);
			System.out.println("props: null pointer");
		}
	}

	private void setJDialogTitleWithFileName() {
		this.setTitle(defaultTitle + " - " + lastConfigFile);
	}

	private void copyTable2Props() {
		props.clear();
		for (int i = 0; i < tableModelP.getRowCount(); i++) {
			props.setProperty(tableModelP.getValueAt(i, 0).toString(), tableModelP.getValueAt(i, 1).toString());
		}
	}// copyTable2Props()

	private void setTableModel() {
		tableModelP.setRowCount(0);
		for (Map.Entry<?, ?> entry : props.entrySet()) {
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			tableModelP.addRow(new Object[] { key, value });
		}
	} // setTableModel
}
