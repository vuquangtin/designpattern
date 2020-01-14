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

public class DlgDrawingCircle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCircleRadius;
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
	public DlgDrawingCircle() {
		setTitle("Drawing a circle");
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
				JLabel lblCircleRadius = new JLabel("Enter circle's radius");
				GridBagConstraints gbc_lblCircleRadius = new GridBagConstraints();
				gbc_lblCircleRadius.insets = new Insets(0, 0, 0, 5);
				gbc_lblCircleRadius.gridx = 0;
				gbc_lblCircleRadius.gridy = 0;
				pnlCentar.add(lblCircleRadius, gbc_lblCircleRadius);
			}
			{
				txtCircleRadius = new JTextField();
				GridBagConstraints gbc_txtCircleRadius = new GridBagConstraints();
				gbc_txtCircleRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCircleRadius.gridx = 2;
				gbc_txtCircleRadius.gridy = 0;
				pnlCentar.add(txtCircleRadius, gbc_txtCircleRadius);
				txtCircleRadius.setColumns(10);
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
							if(Integer.parseInt(txtCircleRadius.getText()) > 0)
							{
								confirmed = true;
								r = Integer.parseInt(txtCircleRadius.getText());
								setVisible(false);
							}
							else
								throw exc;
						}
						catch(NumberFormatException c)
						{
							JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
							txtCircleRadius.setText("");
						}
						catch(Exception exc)
						{
							JOptionPane.showMessageDialog(null, "Radius has to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
							txtCircleRadius.setText("");
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
		return txtCircleRadius;
	}

	public void setTxtCircleRadius(JTextField txtCircleRadius) {
		this.txtCircleRadius = txtCircleRadius;
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
