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

public class DlgDrawingSquare extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSquareSideLength;
	private Exception exc;
	
	protected boolean confirmed = false;
	protected int sideLength;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingSquare dialog = new DlgDrawingSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingSquare() {
		setModal(true);
		setTitle("Drawing a square");
		setBounds(100, 100, 451, 116);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCentar = new JPanel();
			contentPanel.add(pnlCentar, BorderLayout.CENTER);
			GridBagLayout gbl_pnlCentar = new GridBagLayout();
			gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
			gbl_pnlCentar.rowHeights = new int[]{0, 0};
			gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlCentar.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnlCentar.setLayout(gbl_pnlCentar);
			{
				JLabel lblSquareSideLength = new JLabel("Enter square's side length");
				GridBagConstraints gbc_lblSquareSideLength = new GridBagConstraints();
				gbc_lblSquareSideLength.insets = new Insets(0, 0, 0, 5);
				gbc_lblSquareSideLength.gridx = 0;
				gbc_lblSquareSideLength.gridy = 0;
				pnlCentar.add(lblSquareSideLength, gbc_lblSquareSideLength);
			}
			{
				txtSquareSideLength = new JTextField();
				GridBagConstraints gbc_txtSquareSideLength = new GridBagConstraints();
				gbc_txtSquareSideLength.anchor = GridBagConstraints.NORTH;
				gbc_txtSquareSideLength.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSquareSideLength.gridx = 2;
				gbc_txtSquareSideLength.gridy = 0;
				pnlCentar.add(txtSquareSideLength, gbc_txtSquareSideLength);
				txtSquareSideLength.setColumns(10);
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
							if(Integer.parseInt(txtSquareSideLength.getText()) > 0)
							{
								confirmed = true;
								sideLength = Integer.parseInt(txtSquareSideLength.getText());
								setVisible(false);
							}
							else
								throw exc;
						}
						catch(NumberFormatException c){
							JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
							txtSquareSideLength.setText("");
						}
						catch(Exception exc){
							JOptionPane.showMessageDialog(null, "Side length has to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
							txtSquareSideLength.setText("");
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

	public JTextField getTxtSquareSideLength() {
		return txtSquareSideLength;
	}

	public void setTxtSquareSideLength(JTextField txtSquareSideLength) {
		this.txtSquareSideLength = txtSquareSideLength;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

}
