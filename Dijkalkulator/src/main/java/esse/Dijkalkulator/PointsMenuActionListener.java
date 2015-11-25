package esse.Dijkalkulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointsMenuActionListener implements ActionListener {
	JDialogPoints oJDialogPoints;
	
	public void actionPerformed(ActionEvent e) {
		oJDialogPoints = new JDialogPoints();
		oJDialogPoints.setVisible(true);
	}

	public JDialogPoints getoJDialogPoints() {
		return oJDialogPoints;
	}

	public void setoJDialogPoints(JDialogPoints oJDialogPoints) {
		this.oJDialogPoints = oJDialogPoints;
	}


	
}
