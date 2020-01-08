package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgModifyingSquare extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtMoveByX;
	private JTextField txtMoveByY;
	private boolean borderColorChanged = false, innerColorChanged = false;
	private JRadioButton rdbtnMoveTo;
	private JRadioButton rdbtnMoveBy;
	private Exception exc;

	protected int x, y, moveByX, moveByY, sideLength;
	protected boolean confirmed = false;
	protected JTextField txtCoordinateX;
	protected JTextField txtCoordinateY;
	protected JTextField txtSideLength;
	protected JButton btnInnerColor;
	protected JButton btnBorderColor;
	protected boolean optionChosen;

	public Color borderColor = Color.BLACK;
	public Color innerColor = Color.WHITE;
	public Color squareBorderColor;
	public Color squareInnerColor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyingSquare dialog = new DlgModifyingSquare();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyingSquare() {
		setModal(true);
		setTitle("Modify square");
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCentar = new JPanel();
			contentPanel.add(pnlCentar, BorderLayout.CENTER);
			GridBagLayout gbl_pnlCentar = new GridBagLayout();
			gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlCentar.setLayout(gbl_pnlCentar);
			{
				JLabel lblOption = new JLabel("Pick an option:");
				GridBagConstraints gbc_lblOption = new GridBagConstraints();
				gbc_lblOption.insets = new Insets(0, 0, 5, 5);
				gbc_lblOption.gridx = 0;
				gbc_lblOption.gridy = 0;
				pnlCentar.add(lblOption, gbc_lblOption);
			}
			{
				rdbtnMoveTo = new JRadioButton("Move to");
				rdbtnMoveTo.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(rdbtnMoveTo.isSelected())
						{
							optionChosen = true;
							txtCoordinateX.setEditable(true);
							txtCoordinateY.setEditable(true);
							txtMoveByX.setText("");
							txtMoveByY.setText("");
						}
						else
						{
							optionChosen = false;
							txtCoordinateX.setEditable(false);
							txtCoordinateY.setEditable(false);
						}
					}
				});
				buttonGroup.add(rdbtnMoveTo);
				GridBagConstraints gbc_rdbtnMoveTo = new GridBagConstraints();
				gbc_rdbtnMoveTo.insets = new Insets(0, 0, 5, 5);
				gbc_rdbtnMoveTo.gridx = 3;
				gbc_rdbtnMoveTo.gridy = 0;
				pnlCentar.add(rdbtnMoveTo, gbc_rdbtnMoveTo);
			}
			{
				rdbtnMoveBy = new JRadioButton("Move by");
				rdbtnMoveBy.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(rdbtnMoveBy.isSelected())
						{
							txtMoveByX.setEditable(true);
							txtMoveByY.setEditable(true);
						}
						else
						{
							txtMoveByX.setEditable(false);
							txtMoveByY.setEditable(false);
						}
					}
				});
				buttonGroup.add(rdbtnMoveBy);
				GridBagConstraints gbc_rdbtnMoveBy = new GridBagConstraints();
				gbc_rdbtnMoveBy.insets = new Insets(0, 0, 5, 0);
				gbc_rdbtnMoveBy.gridx = 6;
				gbc_rdbtnMoveBy.gridy = 0;
				pnlCentar.add(rdbtnMoveBy, gbc_rdbtnMoveBy);
			}
			{
				JLabel lblBorderColor = new JLabel("Pick border color:");
				GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
				gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblBorderColor.gridx = 0;
				gbc_lblBorderColor.gridy = 1;
				pnlCentar.add(lblBorderColor, gbc_lblBorderColor);
			}
			{
				btnBorderColor = new JButton("Border color");
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColorChanged = true;
						btnBorderColor.setBackground(colorChoosing(btnBorderColor.getBackground()));
						borderColor = btnBorderColor.getBackground();
					}
				});
				GridBagConstraints gbc_btnBorderColor = new GridBagConstraints();
				gbc_btnBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnBorderColor.gridx = 3;
				gbc_btnBorderColor.gridy = 1;
				pnlCentar.add(btnBorderColor, gbc_btnBorderColor);
			}
			{
				JLabel lblInnerColor = new JLabel("Pick inner color:");
				GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
				gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblInnerColor.gridx = 0;
				gbc_lblInnerColor.gridy = 2;
				pnlCentar.add(lblInnerColor, gbc_lblInnerColor);
			}
			{
				btnInnerColor = new JButton("Inner color");
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColorChanged = true;
						btnInnerColor.setBackground(colorChoosing(btnInnerColor.getBackground()));
						innerColor = btnInnerColor.getBackground();
					}
				});
				GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
				gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnInnerColor.gridx = 3;
				gbc_btnInnerColor.gridy = 2;
				pnlCentar.add(btnInnerColor, gbc_btnInnerColor);
			}
			{
				JLabel lblSideLength = new JLabel("Enter side's length:");
				GridBagConstraints gbc_lblSideLength = new GridBagConstraints();
				gbc_lblSideLength.insets = new Insets(0, 0, 5, 5);
				gbc_lblSideLength.gridx = 0;
				gbc_lblSideLength.gridy = 3;
				pnlCentar.add(lblSideLength, gbc_lblSideLength);
			}
			{
				txtSideLength = new JTextField();
				GridBagConstraints gbc_txtSideLength = new GridBagConstraints();
				gbc_txtSideLength.insets = new Insets(0, 0, 5, 5);
				gbc_txtSideLength.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSideLength.gridx = 3;
				gbc_txtSideLength.gridy = 3;
				pnlCentar.add(txtSideLength, gbc_txtSideLength);
				txtSideLength.setColumns(10);
			}
			{
				JLabel lblCoordinateX = new JLabel("Upper left point's X coordinate:");
				GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
				gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
				gbc_lblCoordinateX.gridx = 0;
				gbc_lblCoordinateX.gridy = 4;
				pnlCentar.add(lblCoordinateX, gbc_lblCoordinateX);
			}
			{
				txtCoordinateX = new JTextField();
				txtCoordinateX.setEditable(false);
				GridBagConstraints gbc_txtCoordinateX = new GridBagConstraints();
				gbc_txtCoordinateX.insets = new Insets(0, 0, 5, 5);
				gbc_txtCoordinateX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCoordinateX.gridx = 3;
				gbc_txtCoordinateX.gridy = 4;
				pnlCentar.add(txtCoordinateX, gbc_txtCoordinateX);
				txtCoordinateX.setColumns(10);
			}
			{
				JLabel lblCoordinateY = new JLabel("Upper left point's Y coordinate:");
				GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
				gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCoordinateY.gridx = 0;
				gbc_lblCoordinateY.gridy = 5;
				pnlCentar.add(lblCoordinateY, gbc_lblCoordinateY);
			}
			{
				txtCoordinateY = new JTextField();
				txtCoordinateY.setEditable(false);
				GridBagConstraints gbc_txtCoordinateY = new GridBagConstraints();
				gbc_txtCoordinateY.insets = new Insets(0, 0, 5, 5);
				gbc_txtCoordinateY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCoordinateY.gridx = 3;
				gbc_txtCoordinateY.gridy = 5;
				pnlCentar.add(txtCoordinateY, gbc_txtCoordinateY);
				txtCoordinateY.setColumns(10);
			}
			{
				JLabel lblMoveByX = new JLabel("Move upper left point's X by:");
				GridBagConstraints gbc_lblMoveByX = new GridBagConstraints();
				gbc_lblMoveByX.insets = new Insets(0, 0, 5, 5);
				gbc_lblMoveByX.gridx = 0;
				gbc_lblMoveByX.gridy = 6;
				pnlCentar.add(lblMoveByX, gbc_lblMoveByX);
			}
			{
				txtMoveByX = new JTextField();
				txtMoveByX.setEditable(false);
				GridBagConstraints gbc_txtMoveByX = new GridBagConstraints();
				gbc_txtMoveByX.insets = new Insets(0, 0, 5, 5);
				gbc_txtMoveByX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByX.gridx = 3;
				gbc_txtMoveByX.gridy = 6;
				pnlCentar.add(txtMoveByX, gbc_txtMoveByX);
				txtMoveByX.setColumns(10);
			}
			{
				JLabel lblMoveByY = new JLabel("Move upper left point's Y by:");
				GridBagConstraints gbc_lblMoveByY = new GridBagConstraints();
				gbc_lblMoveByY.insets = new Insets(0, 0, 0, 5);
				gbc_lblMoveByY.gridx = 0;
				gbc_lblMoveByY.gridy = 7;
				pnlCentar.add(lblMoveByY, gbc_lblMoveByY);
			}
			{
				txtMoveByY = new JTextField();
				txtMoveByY.setEditable(false);
				GridBagConstraints gbc_txtMoveByY = new GridBagConstraints();
				gbc_txtMoveByY.insets = new Insets(0, 0, 0, 5);
				gbc_txtMoveByY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByY.gridx = 3;
				gbc_txtMoveByY.gridy = 7;
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
					public void actionPerformed(ActionEvent arg0) {
						try{
							confirmed = true;

							if(borderColorChanged)
								squareBorderColor = borderColor;

							if(innerColorChanged)
								squareInnerColor = innerColor;

							if(rdbtnMoveTo.isSelected())
							{
								if(!txtCoordinateX.getText().equals("") && !txtCoordinateY.getText().equals("") && !txtSideLength.getText().equals(""))
								{	x = Integer.parseInt(txtCoordinateX.getText());
								y = Integer.parseInt(txtCoordinateY.getText());
								sideLength = Integer.parseInt(txtSideLength.getText());
								if(x > 0 && y > 0 && sideLength > 0)
									setVisible(false);
								else throw exc;
								} else throw new NumberFormatException();
							}
							else if(rdbtnMoveBy.isSelected())
							{
								if(!txtMoveByX.getText().equals("") && !txtMoveByY.getText().equals(""))
								{
									moveByX = Integer.parseInt(txtMoveByX.getText());
									moveByY = Integer.parseInt(txtMoveByY.getText());
									sideLength = Integer.parseInt(txtSideLength.getText());
									if(sideLength > 0)
										setVisible(false);
									else throw exc;
								} else throw new NumberFormatException();
							}
							else JOptionPane.showMessageDialog(null, "Pick option \"Move by\" or \"Move to\".", "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch(NumberFormatException c){
							if(rdbtnMoveTo.isSelected() || rdbtnMoveBy.isSelected()){
								JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
								if(rdbtnMoveTo.isSelected()){
									txtCoordinateX.setText("");
									txtCoordinateY.setText("");
									txtSideLength.setText("");
								}
								else if(rdbtnMoveBy.isSelected()){
									txtMoveByX.setText("");
									txtMoveByY.setText("");
									txtSideLength.setText("");
								}
							}
						}
						catch(Exception exc){
							if(rdbtnMoveTo.isSelected()){
								JOptionPane.showMessageDialog(null, "You have to enter numbers greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtCoordinateX.setText("");
								txtCoordinateY.setText("");
							}
							else if(rdbtnMoveBy.isSelected()){
								JOptionPane.showMessageDialog(null, "You have to enter numbers greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtSideLength.setText("");
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

	public Color colorChoosing(Color color)
	{
		Color newColor = JColorChooser.showDialog(null, "Pick a color:", color);
		if(newColor == null)
			return color;
		else
			return newColor;
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

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public JTextField getTxtCoordinateX() {
		return txtCoordinateX;
	}

	public void setTxtCoordinateX(JTextField txtCoordinateX) {
		this.txtCoordinateX = txtCoordinateX;
	}

	public JTextField getTxtCoordinateY() {
		return txtCoordinateY;
	}

	public void setTxtCoordinateY(JTextField txtCoordinateY) {
		this.txtCoordinateY = txtCoordinateY;
	}

	public JTextField getTxtSideLength() {
		return txtSideLength;
	}

	public void setTxtSideLength(JTextField txtSideLength) {
		this.txtSideLength = txtSideLength;
	}

	public Color getSquareBorderColor() {
		return squareBorderColor;
	}

	public void setSquareBorderColor(Color squareBorderColor) {
		this.squareBorderColor = squareBorderColor;
	}

	public Color getSquareInnerColor() {
		return squareInnerColor;
	}

	public void setSquareInnerColor(Color squareInnerColor) {
		this.squareInnerColor = squareInnerColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public boolean isOptionChosen() {
		return optionChosen;
	}

	public void setOptionChosen(boolean optionChosen) {
		this.optionChosen = optionChosen;
	}

	public int getMoveByX() {
		return moveByX;
	}

	public void setMoveByX(int moveByX) {
		this.moveByX = moveByX;
	}

	public int getMoveByY() {
		return moveByY;
	}

	public void setMoveByY(int moveByY) {
		this.moveByY = moveByY;
	}

	

}
