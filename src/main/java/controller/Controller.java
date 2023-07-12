package controller;

import view.gui.PrincipalWindow;

public class Controller {
	
	private PrincipalWindow principalWindow;

	public void setPrincipalWindow(PrincipalWindow principalWindow) {
		this.principalWindow = principalWindow;
	}

	public void showPrincipalWindow() {
		principalWindow.setVisible(true);
	}

}
