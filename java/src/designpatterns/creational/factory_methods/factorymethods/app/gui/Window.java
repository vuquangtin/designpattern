package factorymethods.app.gui;



public class Window {
	
	private MyFrame frame;
	private MyPanel panel;
	
	public Window(String title, int width, int heigth, int scale) {		
		frame = new MyFrame(title);
		panel = new MyPanel(width, heigth, scale);
		frame.addContent(panel);		
		panel.makePanelFocusable();
		
		
		
		
	}
	
	
	public MyFrame getFrame() { return frame; }	
	public MyPanel getPanel() { return panel; }
	
}