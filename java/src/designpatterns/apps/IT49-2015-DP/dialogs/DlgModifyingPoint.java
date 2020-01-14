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

public class DlgModifyingPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtMoveByX;
	private JTextField txtMoveByY;
	private JRadioButton rdbtnMoveTo;
	private JRadioButton rdbtnMoveBy;
	private boolean colorChanged = false;
	private Exception exc;

	public Color color = Color.BLACK;
	public Color pointColor;

	protected int x,y,moveByX,moveByY;
	protected JTextField txtCoordinateX;
	protected JTextField txtCoordinateY;
	protected JButton btnColor;
	protected boolean confirmed = false;
	protected boolean choosenOption;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifyingPoint dialog = new DlgModifyingPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifyingPoint() {
		setModal(true);
		setTitle("Modify point");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblOptionChooser = new JLabel("Choose the option:");
			GridBagConstraints gbc_lblOptionChooser = new GridBagConstraints();
			gbc_lblOptionChooser.insets = new Insets(0, 0, 5, 5);
			gbc_lblOptionChooser.gridx = 0;
			gbc_lblOptionChooser.gridy = 0;
			contentPanel.add(lblOptionChooser, gbc_lblOptionChooser);
		}
		{
			{
				rdbtnMoveTo = new JRadioButton("Move to");
				rdbtnMoveTo.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(rdbtnMoveTo.isSelected())
						{
							choosenOption = true;
							txtCoordinateX.setEditable(true);
							txtCoordinateY.setEditable(true);
							txtMoveByX.setText("");
							txtMoveByY.setText("");
						}
						else
						{
							choosenOption = false;
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
				contentPanel.add(rdbtnMoveTo, gbc_rdbtnMoveTo);
			}
		}
		rdbtnMoveBy = new JRadioButton("Move by");
		rdbtnMoveBy.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
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
		gbc_rdbtnMoveBy.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMoveBy.gridx = 5;
		gbc_rdbtnMoveBy.gridy = 0;
		contentPanel.add(rdbtnMoveBy, gbc_rdbtnMoveBy);
		{
			JLabel lblColorChooser = new JLabel("Pick a color:");
			GridBagConstraints gbc_lblColorChooser = new GridBagConstraints();
			gbc_lblColorChooser.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorChooser.gridx = 0;
			gbc_lblColorChooser.gridy = 2;
			contentPanel.add(lblColorChooser, gbc_lblColorChooser);
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
			gbc_btnColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnColor.gridx = 3;
			gbc_btnColor.gridy = 2;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JLabel lblCoordinateX = new JLabel("Point's X coordinate:");
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 0;
			gbc_lblCoordinateX.gridy = 3;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			txtCoordinateX = new JTextField();
			txtCoordinateX.setEditable(false);
			GridBagConstraints gbc_txtCoordinateX = new GridBagConstraints();
			gbc_txtCoordinateX.anchor = GridBagConstraints.NORTH;
			gbc_txtCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_txtCoordinateX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoordinateX.gridx = 3;
			gbc_txtCoordinateX.gridy = 3;
			contentPanel.add(txtCoordinateX, gbc_txtCoordinateX);
			txtCoordinateX.setColumns(10);
		}
		{
			JLabel lblCoordinateY = new JLabel("Point's Y coordinate:");
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 0;
			gbc_lblCoordinateY.gridy = 4;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			txtCoordinateY = new JTextField();
			txtCoordinateY.setEditable(false);
			GridBagConstraints gbc_txtCoordinateY = new GridBagConstraints();
			gbc_txtCoordinateY.anchor = GridBagConstraints.NORTH;
			gbc_txtCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_txtCoordinateY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCoordinateY.gridx = 3;
			gbc_txtCoordinateY.gridy = 4;
			contentPanel.add(txtCoordinateY, gbc_txtCoordinateY);
			txtCoordinateY.setColumns(10);
		}
		{
			JLabel lblMoveByX = new JLabel("Move coordinate X by:");
			GridBagConstraints gbc_lblMoveByX = new GridBagConstraints();
			gbc_lblMoveByX.insets = new Insets(0, 0, 5, 5);
			gbc_lblMoveByX.gridx = 0;
			gbc_lblMoveByX.gridy = 5;
			contentPanel.add(lblMoveByX, gbc_lblMoveByX);
		}
		{
			txtMoveByX = new JTextField();
			txtMoveByX.setEditable(false);
			GridBagConstraints gbc_txtMoveByX = new GridBagConstraints();
			gbc_txtMoveByX.insets = new Insets(0, 0, 5, 5);
			gbc_txtMoveByX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMoveByX.gridx = 3;
			gbc_txtMoveByX.gridy = 5;
			contentPanel.add(txtMoveByX, gbc_txtMoveByX);
			txtMoveByX.setColumns(10);
		}
		{
			JLabel lblMoveByY = new JLabel("Move coordinate Y by:");
			GridBagConstraints gbc_lblMoveByY = new GridBagConstraints();
			gbc_lblMoveByY.insets = new Insets(0, 0, 0, 5);
			gbc_lblMoveByY.gridx = 0;
			gbc_lblMoveByY.gridy = 6;
			contentPanel.add(lblMoveByY, gbc_lblMoveByY);
		}
		{
			txtMoveByY = new JTextField();
			txtMoveByY.setEditable(false);
			GridBagConstraints gbc_txtMoveByY = new GridBagConstraints();
			gbc_txtMoveByY.insets = new Insets(0, 0, 0, 5);
			gbc_txtMoveByY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMoveByY.gridx = 3;
			gbc_txtMoveByY.gridy = 6;
			contentPanel.add(txtMoveByY, gbc_txtMoveByY);
			txtMoveByY.setColumns(10);
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
								pointColor = color;

							if(rdbtnMoveTo.isSelected())
							{
								if(!txtCoordinateX.getText().equals("") && !txtCoordinateY.getText().equals(""))
								{	x = Integer.parseInt(txtCoordinateX.getText());
								y = Integer.parseInt(txtCoordinateY.getText());
								if(x > 0 && y > 0)
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
									setVisible(false);
								} else throw new NumberFormatException();
							}
							else JOptionPane.showMessageDialog(null, "Pick option \"Move by\" or \"Move to\".", "Error", JOptionPane.ERROR_MESSAGE);
						}
						catch(NumberFormatException c)
						{
							if(rdbtnMoveTo.isSelected() || rdbtnMoveBy.isSelected()){
								JOptionPane.showMessageDialog(null, "You have to enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
								if(rdbtnMoveTo.isSelected()){
									txtCoordinateX.setText("");
									txtCoordinateY.setText("");
								}
								else if(rdbtnMoveBy.isSelected()){
									txtMoveByX.setText("");
									txtMoveByY.setText("");
								}
							}
						}
						catch(Exception exc){
							JOptionPane.showMessageDialog(null, "You have to enter values greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
							if(rdbtnMoveTo.isSelected()){
								txtCoordinateX.setText("");
								txtCoordinateY.setText("");
							}
							else if(rdbtnMoveBy.isSelected()){
								txtMoveByX.setText("");
								txtMoveByY.setText("");
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
		Color newColor = JColorChooser.showDialog(null, "Choose a color:", color);
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

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
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

	public Color getPointColor() {
		return pointColor;
	}

	public void setPointColor(Color pointColor) {
		this.pointColor = pointColor;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public boolean isChoosenOption() {
		return choosenOption;
	}

	public void setChoosenOption(boolean choosenOption) {
		this.choosenOption = choosenOption;
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
