package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgModifyingLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtMoveByX;
	private JTextField txtMoveByY;
	private boolean colorChanged = false;

	public Color color = Color.BLACK;
	public Color lineColor;

	protected int x,y;
	protected JButton btnColor;
	protected boolean confirmed = false;
	protected JTextField txtStartXY;
	protected JTextField txtEndXY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyingLine dialog = new DlgModifyingLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyingLine() {
		setModal(true);
		setTitle("Modify line");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCentar = new JPanel();
			contentPanel.add(pnlCentar);
			GridBagLayout gbl_pnlCentar = new GridBagLayout();
			gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlCentar.setLayout(gbl_pnlCentar);
			{
				JLabel lblColorChooser = new JLabel("Pick a color:");
				GridBagConstraints gbc_lblColorChooser = new GridBagConstraints();
				gbc_lblColorChooser.insets = new Insets(0, 0, 5, 5);
				gbc_lblColorChooser.gridx = 0;
				gbc_lblColorChooser.gridy = 0;
				pnlCentar.add(lblColorChooser, gbc_lblColorChooser);
			}
			{
				btnColor = new JButton("Color");
				btnColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						colorChanged = true;
						btnColor.setBackground(colorChoosing(btnColor.getBackground()));
						color = btnColor.getBackground();
					}
				});
				GridBagConstraints gbc_btnColor = new GridBagConstraints();
				gbc_btnColor.insets = new Insets(0, 0, 5, 0);
				gbc_btnColor.gridx = 3;
				gbc_btnColor.gridy = 0;
				pnlCentar.add(btnColor, gbc_btnColor);
			}
			{
				JLabel lblStartXY = new JLabel("Line's starting point's X,Y coordinates:");
				GridBagConstraints gbc_lblStartXY = new GridBagConstraints();
				gbc_lblStartXY.insets = new Insets(0, 0, 5, 5);
				gbc_lblStartXY.gridx = 0;
				gbc_lblStartXY.gridy = 1;
				pnlCentar.add(lblStartXY, gbc_lblStartXY);
			}
			{
				txtStartXY = new JTextField();
				txtStartXY.setEditable(false);
				GridBagConstraints gbc_txtStartXY = new GridBagConstraints();
				gbc_txtStartXY.insets = new Insets(0, 0, 5, 0);
				gbc_txtStartXY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtStartXY.gridx = 3;
				gbc_txtStartXY.gridy = 1;
				pnlCentar.add(txtStartXY, gbc_txtStartXY);
				txtStartXY.setColumns(10);
			}
			{
				JLabel lblEndXY = new JLabel("Line's ending point's X,Y coordinates:");
				GridBagConstraints gbc_lblEndXY = new GridBagConstraints();
				gbc_lblEndXY.insets = new Insets(0, 0, 5, 5);
				gbc_lblEndXY.gridx = 0;
				gbc_lblEndXY.gridy = 2;
				pnlCentar.add(lblEndXY, gbc_lblEndXY);
			}
			{
				txtEndXY = new JTextField();
				txtEndXY.setEditable(false);
				GridBagConstraints gbc_txtEndXY = new GridBagConstraints();
				gbc_txtEndXY.insets = new Insets(0, 0, 5, 0);
				gbc_txtEndXY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEndXY.gridx = 3;
				gbc_txtEndXY.gridy = 2;
				pnlCentar.add(txtEndXY, gbc_txtEndXY);
				txtEndXY.setColumns(10);
			}
			{
				JLabel lblMoveByX = new JLabel("Move line's X coordinates by:");
				GridBagConstraints gbc_lblMoveByX = new GridBagConstraints();
				gbc_lblMoveByX.insets = new Insets(0, 0, 5, 5);
				gbc_lblMoveByX.gridx = 0;
				gbc_lblMoveByX.gridy = 5;
				pnlCentar.add(lblMoveByX, gbc_lblMoveByX);
			}
			{
				txtMoveByX = new JTextField();
				GridBagConstraints gbc_txtMoveByX = new GridBagConstraints();
				gbc_txtMoveByX.insets = new Insets(0, 0, 5, 0);
				gbc_txtMoveByX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByX.gridx = 3;
				gbc_txtMoveByX.gridy = 5;
				pnlCentar.add(txtMoveByX, gbc_txtMoveByX);
				txtMoveByX.setColumns(10);
			}
			{
				JLabel lblMoveByY = new JLabel("Move line's Y coordinates by:");
				GridBagConstraints gbc_lblMoveByY = new GridBagConstraints();
				gbc_lblMoveByY.insets = new Insets(0, 0, 0, 5);
				gbc_lblMoveByY.gridx = 0;
				gbc_lblMoveByY.gridy = 6;
				pnlCentar.add(lblMoveByY, gbc_lblMoveByY);
			}
			{
				txtMoveByY = new JTextField();
				GridBagConstraints gbc_txtMoveByY = new GridBagConstraints();
				gbc_txtMoveByY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByY.gridx = 3;
				gbc_txtMoveByY.gridy = 6;
				pnlCentar.add(txtMoveByY, gbc_txtMoveByY);
				txtMoveByY.setColumns(10);
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
							confirmed = true;

							if(colorChanged)
								lineColor = color;

							if(!txtMoveByX.getText().equals("") && !txtMoveByY.getText().equals(""))
							{
								x = Integer.parseInt(txtMoveByX.getText());
								y = Integer.parseInt(txtMoveByY.getText());
								setVisible(false);
							} else throw new NumberFormatException();
						}
						catch(NumberFormatException c){
							JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
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

	public Color colorChoosing(Color Color)
	{
		Color newColor = JColorChooser.showDialog(null, "Pick a color:", Color);
		if(newColor == null)
			return Color;
		else
			return newColor;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public JTextField getTxtMoveByX() {
		return txtMoveByX;
	}

	public void setTxtMoveByX(JTextField txtMoveByX) {
		this.txtMoveByX = txtMoveByX;
	}

	public JTextField getTxtMoveByY() {
		return txtMoveByY;
	}

	public void setTxtMoveByY(JTextField txtMoveByY) {
		this.txtMoveByY = txtMoveByY;
	}

	public boolean isColorChanged() {
		return colorChanged;
	}

	public void setColorChanged(boolean colorChanged) {
		this.colorChanged = colorChanged;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public JTextField getTxtStartXY() {
		return txtStartXY;
	}

	public void setTxtStartXY(JTextField txtStartXY) {
		this.txtStartXY = txtStartXY;
	}

	public JTextField getTxtEndXY() {
		return txtEndXY;
	}

	public void setTxtEndXY(JTextField txtEndXY) {
		this.txtEndXY = txtEndXY;
	}

}
