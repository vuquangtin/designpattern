package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgDrawingRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRectangleHeight;
	private JTextField txtRectangleWidth;
	private Exception exc;

	protected int rectangleHeight, rectangleWidth;
	protected boolean confirmed = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingRectangle dialog = new DlgDrawingRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingRectangle() {
		setModal(true);
		setTitle("Drawing a rectangle");
		setBounds(100, 100, 450, 149);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCentar = new JPanel();
			contentPanel.add(pnlCentar, BorderLayout.CENTER);
			GridBagLayout gbl_pnlCentar = new GridBagLayout();
			gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
			gbl_pnlCentar.rowHeights = new int[]{0, 0, 0};
			gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			pnlCentar.setLayout(gbl_pnlCentar);
			{
				JLabel lblRectangleHeight = new JLabel("Enter rectangle's height:");
				GridBagConstraints gbc_lblRectangleHeight = new GridBagConstraints();
				gbc_lblRectangleHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblRectangleHeight.gridx = 0;
				gbc_lblRectangleHeight.gridy = 0;
				pnlCentar.add(lblRectangleHeight, gbc_lblRectangleHeight);
			}
			{
				txtRectangleHeight = new JTextField();
				GridBagConstraints gbc_txtRectangleHeight = new GridBagConstraints();
				gbc_txtRectangleHeight.anchor = GridBagConstraints.NORTH;
				gbc_txtRectangleHeight.insets = new Insets(0, 0, 5, 0);
				gbc_txtRectangleHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRectangleHeight.gridx = 2;
				gbc_txtRectangleHeight.gridy = 0;
				pnlCentar.add(txtRectangleHeight, gbc_txtRectangleHeight);
				txtRectangleHeight.setColumns(10);
			}
			{
				JLabel lblRectangleWidth = new JLabel("Enter rectangle's width:");
				GridBagConstraints gbc_lblRectangleWidth = new GridBagConstraints();
				gbc_lblRectangleWidth.insets = new Insets(0, 0, 0, 5);
				gbc_lblRectangleWidth.gridx = 0;
				gbc_lblRectangleWidth.gridy = 1;
				pnlCentar.add(lblRectangleWidth, gbc_lblRectangleWidth);
			}
			{
				txtRectangleWidth = new JTextField();
				GridBagConstraints gbc_txtRectangleWidth = new GridBagConstraints();
				gbc_txtRectangleWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRectangleWidth.gridx = 2;
				gbc_txtRectangleWidth.gridy = 1;
				pnlCentar.add(txtRectangleWidth, gbc_txtRectangleWidth);
				txtRectangleWidth.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							if(Integer.parseInt(txtRectangleHeight.getText())>0 && Integer.parseInt(txtRectangleWidth.getText())>0){
								confirmed = true;

								rectangleHeight = Integer.parseInt(txtRectangleHeight.getText());
								rectangleWidth= Integer.parseInt(txtRectangleWidth.getText());
								setVisible(false);
							}
							else{
								throw exc;
							}
						}
						catch(NumberFormatException c)
						{
							JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
							txtRectangleHeight.setText("");
							txtRectangleWidth.setText("");
						}
						catch(Exception exc){
							if(Integer.parseInt(txtRectangleHeight.getText()) <= 0 && Integer.parseInt(txtRectangleWidth.getText()) <= 0){
								JOptionPane.showMessageDialog(null, "Height and width have to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtRectangleHeight.setText("");
								txtRectangleWidth.setText("");
							}
							else if(Integer.parseInt(txtRectangleHeight.getText()) <=0)
							{
								JOptionPane.showMessageDialog(null, "Height has to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtRectangleHeight.setText("");
							} else if(Integer.parseInt(txtRectangleWidth.getText()) <=0) {
								JOptionPane.showMessageDialog(null, "Height has to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtRectangleWidth.setText("");
							}
						}
					}
				});
				btnConfirm.setActionCommand("OK");
				buttonPane.add(btnConfirm);
				getRootPane().setDefaultButton(btnConfirm);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						confirmed = false;
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	public JTextField getTxtRectangleHeight() {
		return txtRectangleHeight;
	}

	public void setTxtRectangleHeight(JTextField txtRectangleHeight) {
		this.txtRectangleHeight = txtRectangleHeight;
	}

	public JTextField getTxtRectangleWidth() {
		return txtRectangleWidth;
	}

	public void setTxtRectangleWidth(JTextField txtRectangleWidth) {
		this.txtRectangleWidth = txtRectangleWidth;
	}

	public int getRectangleHeight() {
		return rectangleHeight;
	}

	public void setRectangleHeight(int rectangleHeight) {
		this.rectangleHeight = rectangleHeight;
	}

	public int getRectangleWidth() {
		return rectangleWidth;
	}

	public void setRectangleWidth(int rectangleWidth) {
		this.rectangleWidth = rectangleWidth;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}
