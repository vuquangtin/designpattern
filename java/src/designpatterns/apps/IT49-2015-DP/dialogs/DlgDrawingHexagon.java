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

public class DlgDrawingHexagon extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtHexagonRadius;
	private Exception exc;
	
	protected int r;
	protected boolean confirmed = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingCircle dialog = new DlgDrawingCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingHexagon() {
		setTitle("Drawing a hexagon");
		setModal(true);
		setBounds(100, 100, 450, 115);
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
				JLabel lblHexagonRadius = new JLabel("Enter hexagon's radius");
				GridBagConstraints gbc_lblHexagonRadius = new GridBagConstraints();
				gbc_lblHexagonRadius.insets = new Insets(0, 0, 0, 5);
				gbc_lblHexagonRadius.gridx = 0;
				gbc_lblHexagonRadius.gridy = 0;
				pnlCentar.add(lblHexagonRadius, gbc_lblHexagonRadius);
			}
			{
				txtHexagonRadius = new JTextField();
				GridBagConstraints gbc_txtHexagonRadius = new GridBagConstraints();
				gbc_txtHexagonRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtHexagonRadius.gridx = 2;
				gbc_txtHexagonRadius.gridy = 0;
				pnlCentar.add(txtHexagonRadius, gbc_txtHexagonRadius);
				txtHexagonRadius.setColumns(10);
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
							if(Integer.parseInt(txtHexagonRadius.getText()) > 0)
							{
								confirmed = true;
								r = Integer.parseInt(txtHexagonRadius.getText());
								setVisible(false);
							}
							else
								throw exc;
						}
						catch(NumberFormatException c)
						{
							JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
							txtHexagonRadius.setText("");
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Radius has to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
							txtHexagonRadius.setText("");
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
	
	public JTextField getTxtCircleRadius() {
		return txtHexagonRadius;
	}

	public void setTxtCircleRadius(JTextField txtCircleRadius) {
		this.txtHexagonRadius = txtCircleRadius;
	}

	public int getR() {
		return r;
	}

	public void setR(int radius) {
		this.r = radius;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}
