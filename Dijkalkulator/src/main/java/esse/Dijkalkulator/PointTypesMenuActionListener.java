package esse.Dijkalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointTypesMenuActionListener implements ActionListener {
	JDialogPointTypes oJDialogPointTypes;
	
	public void actionPerformed(ActionEvent e) {
		oJDialogPointTypes = new JDialogPointTypes();
		oJDialogPointTypes.setVisible(true);
	}

	public JDialogPointTypes getoJDialogPointTypes() {
		return oJDialogPointTypes;
	}

	public void setoJDialogPointTypes(JDialogPointTypes oJDialogPointTypes) {
		this.oJDialogPointTypes = oJDialogPointTypes;
	}


	
}
