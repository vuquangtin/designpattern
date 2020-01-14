package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgModifyingRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private boolean borderColorChanged = false, innerColorChanged = false;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtMoveByX;
	private JTextField txtMoveByY;
	private JRadioButton rdbtnMoveTo;
	private JRadioButton rdbtnMoveBy;
	private Exception exc;

	protected int x, y, moveByX, moveByY, height, width;
	protected boolean confirmed = false;
	protected JButton btnBorderColor;
	protected JButton btnInnerColor;
	protected JTextField txtCoordinateX;
	protected JTextField txtCoordinateY;
	protected JTextField txtRectangleWidth;
	protected JTextField txtRectangleHeight;
	protected boolean optionChosen;

	public Color borderColor = Color.BLACK;
	public Color innerColor = Color.WHITE;
	public Color rectangleBorderColor;
	public Color rectangleInnerColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyingRectangle dialog = new DlgModifyingRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyingRectangle() {
		setModal(true);
		setTitle("Modify rectangle");
		setBounds(100, 100, 519, 334);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlCenter = new JPanel();
			contentPanel.add(pnlCenter, BorderLayout.CENTER);
			GridBagLayout gbl_pnlCenter = new GridBagLayout();
			gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			pnlCenter.setLayout(gbl_pnlCenter);
			{
				JLabel lblOption = new JLabel("Pick an option:");
				GridBagConstraints gbc_lblOption = new GridBagConstraints();
				gbc_lblOption.insets = new Insets(0, 0, 5, 5);
				gbc_lblOption.gridx = 0;
				gbc_lblOption.gridy = 0;
				pnlCenter.add(lblOption, gbc_lblOption);
			}
			{
				rdbtnMoveTo = new JRadioButton("Move to");
				rdbtnMoveTo.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
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
				pnlCenter.add(rdbtnMoveTo, gbc_rdbtnMoveTo);
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
				pnlCenter.add(rdbtnMoveBy, gbc_rdbtnMoveBy);
			}
			{
				JLabel lblBorderColor = new JLabel("Pick border color:");
				GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
				gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblBorderColor.gridx = 0;
				gbc_lblBorderColor.gridy = 1;
				pnlCenter.add(lblBorderColor, gbc_lblBorderColor);
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
				pnlCenter.add(btnBorderColor, gbc_btnBorderColor);
			}
			{
				JLabel lblInnerColor = new JLabel("Pick inner color:");
				GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
				gbc_lblInnerColor.insets = new Insets(0, 0, 5, 5);
				gbc_lblInnerColor.gridx = 0;
				gbc_lblInnerColor.gridy = 2;
				pnlCenter.add(lblInnerColor, gbc_lblInnerColor);
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
				pnlCenter.add(btnInnerColor, gbc_btnInnerColor);
			}
			{
				JLabel lblRectangleWidth = new JLabel("Rectangle's width:");
				GridBagConstraints gbc_lblRectangleWidth = new GridBagConstraints();
				gbc_lblRectangleWidth.insets = new Insets(0, 0, 5, 5);
				gbc_lblRectangleWidth.gridx = 0;
				gbc_lblRectangleWidth.gridy = 3;
				pnlCenter.add(lblRectangleWidth, gbc_lblRectangleWidth);
			}
			{
				txtRectangleWidth = new JTextField();
				GridBagConstraints gbc_txtRectangleWidth = new GridBagConstraints();
				gbc_txtRectangleWidth.insets = new Insets(0, 0, 5, 5);
				gbc_txtRectangleWidth.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRectangleWidth.gridx = 3;
				gbc_txtRectangleWidth.gridy = 3;
				pnlCenter.add(txtRectangleWidth, gbc_txtRectangleWidth);
				txtRectangleWidth.setColumns(10);
			}
			{
				JLabel lblRectangleHeight = new JLabel("Rectangle's height:");
				GridBagConstraints gbc_lblRectangleHeight = new GridBagConstraints();
				gbc_lblRectangleHeight.insets = new Insets(0, 0, 5, 5);
				gbc_lblRectangleHeight.gridx = 0;
				gbc_lblRectangleHeight.gridy = 4;
				pnlCenter.add(lblRectangleHeight, gbc_lblRectangleHeight);
			}
			{
				txtRectangleHeight = new JTextField();
				GridBagConstraints gbc_txtRectangleHeight = new GridBagConstraints();
				gbc_txtRectangleHeight.insets = new Insets(0, 0, 5, 5);
				gbc_txtRectangleHeight.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtRectangleHeight.gridx = 3;
				gbc_txtRectangleHeight.gridy = 4;
				pnlCenter.add(txtRectangleHeight, gbc_txtRectangleHeight);
				txtRectangleHeight.setColumns(10);
			}
			{
				JLabel lblCoordinateX = new JLabel("Upper left point X coordinate:");
				GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
				gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
				gbc_lblCoordinateX.gridx = 0;
				gbc_lblCoordinateX.gridy = 5;
				pnlCenter.add(lblCoordinateX, gbc_lblCoordinateX);
			}
			{
				txtCoordinateX = new JTextField();
				txtCoordinateX.setEditable(false);
				GridBagConstraints gbc_txtCoordinateX = new GridBagConstraints();
				gbc_txtCoordinateX.insets = new Insets(0, 0, 5, 5);
				gbc_txtCoordinateX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCoordinateX.gridx = 3;
				gbc_txtCoordinateX.gridy = 5;
				pnlCenter.add(txtCoordinateX, gbc_txtCoordinateX);
				txtCoordinateX.setColumns(10);
			}
			{
				JLabel lblCoordinateY = new JLabel("Upper left point Y coordinate:");
				GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
				gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
				gbc_lblCoordinateY.gridx = 0;
				gbc_lblCoordinateY.gridy = 6;
				pnlCenter.add(lblCoordinateY, gbc_lblCoordinateY);
			}
			{
				txtCoordinateY = new JTextField();
				txtCoordinateY.setEditable(false);
				GridBagConstraints gbc_txtCoordinateY = new GridBagConstraints();
				gbc_txtCoordinateY.insets = new Insets(0, 0, 5, 5);
				gbc_txtCoordinateY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCoordinateY.gridx = 3;
				gbc_txtCoordinateY.gridy = 6;
				pnlCenter.add(txtCoordinateY, gbc_txtCoordinateY);
				txtCoordinateY.setColumns(10);
			}
			{
				JLabel lblMoveByX = new JLabel("Move upper left point X by:");
				GridBagConstraints gbc_lblMoveByX = new GridBagConstraints();
				gbc_lblMoveByX.insets = new Insets(0, 0, 5, 5);
				gbc_lblMoveByX.gridx = 0;
				gbc_lblMoveByX.gridy = 7;
				pnlCenter.add(lblMoveByX, gbc_lblMoveByX);
			}
			{
				txtMoveByX = new JTextField();
				txtMoveByX.setEditable(false);
				GridBagConstraints gbc_txtMoveByX = new GridBagConstraints();
				gbc_txtMoveByX.insets = new Insets(0, 0, 5, 5);
				gbc_txtMoveByX.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByX.gridx = 3;
				gbc_txtMoveByX.gridy = 7;
				pnlCenter.add(txtMoveByX, gbc_txtMoveByX);
				txtMoveByX.setColumns(10);
			}
			{
				JLabel lblMoveByY = new JLabel("Move upper left point Y by:");
				GridBagConstraints gbc_lblMoveByY = new GridBagConstraints();
				gbc_lblMoveByY.insets = new Insets(0, 0, 0, 5);
				gbc_lblMoveByY.gridx = 0;
				gbc_lblMoveByY.gridy = 8;
				pnlCenter.add(lblMoveByY, gbc_lblMoveByY);
			}
			{
				txtMoveByY = new JTextField();
				txtMoveByY.setEditable(false);
				GridBagConstraints gbc_txtMoveByY = new GridBagConstraints();
				gbc_txtMoveByY.insets = new Insets(0, 0, 0, 5);
				gbc_txtMoveByY.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtMoveByY.gridx = 3;
				gbc_txtMoveByY.gridy = 8;
				pnlCenter.add(txtMoveByY, gbc_txtMoveByY);
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

							if(borderColorChanged)
								rectangleBorderColor = borderColor;

							if(innerColorChanged)
								rectangleInnerColor = innerColor;

							if(rdbtnMoveTo.isSelected())
							{
								if(!txtCoordinateX.getText().equals("") && !txtCoordinateY.getText().equals("") && !txtRectangleHeight.getText().equals("") && !txtRectangleWidth.getText().equals(""))
								{	x = Integer.parseInt(txtCoordinateX.getText());
								y = Integer.parseInt(txtCoordinateY.getText());
								height = Integer.parseInt(txtRectangleHeight.getText());
								width = Integer.parseInt(txtRectangleWidth.getText());
								if(x > 0 && y > 0 && height > 0 && width > 0)
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
									height = Integer.parseInt(txtRectangleHeight.getText());
									width = Integer.parseInt(txtRectangleWidth.getText());
									if(height > 0 && width > 0)
										setVisible(false);
									else throw exc;
								} else throw new NumberFormatException();
							}
							else JOptionPane.showMessageDialog(null, "Pick option \"Move to\" or \"Move by\".", "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch(NumberFormatException c){
							if(rdbtnMoveTo.isSelected() || rdbtnMoveBy.isSelected()){
								JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
								if(rdbtnMoveTo.isSelected()){
									txtCoordinateX.setText("");
									txtCoordinateY.setText("");
									txtRectangleHeight.setText("");
									txtRectangleWidth.setText("");
								}
								else if(rdbtnMoveBy.isSelected()){
									txtMoveByX.setText("");
									txtMoveByY.setText("");
									txtRectangleHeight.setText("");
									txtRectangleWidth.setText("");
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
								JOptionPane.showMessageDialog(null, "Height's and width's values have to be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
								txtRectangleHeight.setText("");
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
					public void actionPerformed(ActionEvent arg0) {
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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

	public JTextField getTxtRectangleWidth() {
		return txtRectangleWidth;
	}

	public void setTxtRectangleWidth(JTextField txtRectangleWidth) {
		this.txtRectangleWidth = txtRectangleWidth;
	}

	public JTextField getTxtRectangleHeight() {
		return txtRectangleHeight;
	}

	public void setTxtRectangleHeight(JTextField txtRectangleHeight) {
		this.txtRectangleHeight = txtRectangleHeight;
	}

	public Color getRectangleBorderColor() {
		return rectangleBorderColor;
	}

	public void setRectangleBorderColor(Color rectangleBorderColor) {
		this.rectangleBorderColor = rectangleBorderColor;
	}

	public Color getRectangleInnerColor() {
		return rectangleInnerColor;
	}

	public void setRectangleInnerColor(Color rectangleInnerColor) {
		this.rectangleInnerColor = rectangleInnerColor;
	}

	public JButton getBtnBorderColor() {
		return btnBorderColor;
	}

	public void setBtnBorderColor(JButton btnBorderColor) {
		this.btnBorderColor = btnBorderColor;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
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
