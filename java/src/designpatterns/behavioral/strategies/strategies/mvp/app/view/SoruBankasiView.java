/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategies.mvp.app.view;

import javax.swing.JOptionPane;

import strategies.mvp.app.presenter.SoruBankasiPresenter;
import strategies.mvp.app.presenter.strategypattern.CoktanSecmeliKolaySoru;
import strategies.mvp.app.presenter.strategypattern.CoktanSecmeliOrtaSoru;
import strategies.mvp.app.presenter.strategypattern.CoktanSecmeliZorSoru;
import strategies.mvp.app.presenter.strategypattern.Context;
import strategies.mvp.app.presenter.strategypattern.ContextListele;
import strategies.mvp.app.presenter.strategypattern.DogruYanlisKolaySoru;
import strategies.mvp.app.presenter.strategypattern.DogruYanlisOrtaSoru;
import strategies.mvp.app.presenter.strategypattern.DogruYanlisZorSoru;
import strategies.mvp.app.presenter.strategypattern.KlasikKolaySoru;
import strategies.mvp.app.presenter.strategypattern.KlasikOrtaSoru;
import strategies.mvp.app.presenter.strategypattern.KlasikZorSoru;
import strategies.mvp.app.presenter.strategypattern.ListeleKolaySoru;
import strategies.mvp.app.presenter.strategypattern.ListeleOrtaSoru;
import strategies.mvp.app.presenter.strategypattern.ListeleZorSoru;

/**
 * <h1>Strategy</h1> Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán
 * lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi
 * độc lập khi người dùng sử dụng chúng.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class SoruBankasiView extends javax.swing.JFrame {

	/**
	 * Creates new form SoruBankasıView
	 */
	private SoruBankasiPresenter presenter;
	Context context = new Context(new CoktanSecmeliKolaySoru());
	Context context2 = new Context(new CoktanSecmeliOrtaSoru());
	Context context3 = new Context(new CoktanSecmeliZorSoru());
	Context context4 = new Context(new DogruYanlisKolaySoru());
	Context context5 = new Context(new DogruYanlisOrtaSoru());
	Context context6 = new Context(new DogruYanlisZorSoru());
	Context context7 = new Context(new KlasikKolaySoru());
	Context context8 = new Context(new KlasikOrtaSoru());
	Context context9 = new Context(new KlasikZorSoru());
	ContextListele context10 = new ContextListele(new ListeleKolaySoru());
	ContextListele context11 = new ContextListele(new ListeleOrtaSoru());
	ContextListele context12 = new ContextListele(new ListeleZorSoru());

	public SoruBankasiView() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jInternalFrame1 = new javax.swing.JInternalFrame();
		jLabel1 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jLabel4 = new javax.swing.JLabel();
		jComboBox3 = new javax.swing.JComboBox();
		jTextField1 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jComboBox4 = new javax.swing.JComboBox();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jInternalFrame1.setVisible(true);
		jInternalFrame1.getContentPane().setLayout(
				new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setText("Ders Seç:");
		jInternalFrame1.getContentPane().add(
				jLabel1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1,
						-1));

		jInternalFrame1.getContentPane().add(
				jComboBox1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 220,
						-1));

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabel2.setText("Soru Bankası Oluşturma");
		jInternalFrame1.getContentPane().add(
				jLabel2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 270,
						-1));

		jLabel3.setText("Soru Tipi Seç:");
		jInternalFrame1.getContentPane().add(
				jLabel3,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1,
						-1));

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Çoktan Seçmeli", "Klasik", "Doğru Yanlış", "" }));
		jInternalFrame1.getContentPane().add(
				jComboBox2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 220,
						-1));

		jLabel4.setText("Zorluk Derecesine Göre Listele:");
		jInternalFrame1.getContentPane().add(
				jLabel4,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 190,
						-1));

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Kolay", "Orta", "Zor", " " }));
		jInternalFrame1.getContentPane().add(
				jComboBox3,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120,
						220, -1));
		jInternalFrame1.getContentPane().add(
				jTextField1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160,
						220, 80));

		jLabel5.setText("Soru Gir:");
		jInternalFrame1.getContentPane().add(
				jLabel5,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1,
						20));

		jLabel6.setText("Soru Yanıt:");
		jInternalFrame1.getContentPane().add(
				jLabel6,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60,
						10));
		jInternalFrame1.getContentPane().add(
				jTextField2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250,
						230, 20));

		jLabel7.setText("Soru Puan Değeri");
		jInternalFrame1.getContentPane().add(
				jLabel7,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 90,
						10));
		jInternalFrame1.getContentPane().add(
				jTextField3,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290,
						230, 20));

		jButton1.setText("Soruyu Kaydet");
		jButton1.setActionCommand("Listele");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jInternalFrame1.getContentPane().add(
				jButton1,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320,
						130, 40));

		jLabel8.setText("Zorluk Derecesi:");
		jInternalFrame1.getContentPane().add(
				jLabel8,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1,
						-1));

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Kolay", "Orta", "Zor" }));
		jInternalFrame1.getContentPane().add(
				jComboBox4,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 220,
						-1));

		jButton2.setText("Listele");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jInternalFrame1.getContentPane().add(
				jButton2,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 130,
						40));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jInternalFrame1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 411,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(38, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
		// TODO add your handling code here:
		presenter.DosyaOku();
	}// GEN-LAST:event_formWindowOpened

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
		context10.executeStrategy2(jComboBox4.getSelectedItem().toString());
		context11.executeStrategy2(jComboBox4.getSelectedItem().toString());
		context12.executeStrategy2(jComboBox4.getSelectedItem().toString());
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:

		presenter.messageBox(jTextField3.getText());

		context.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));

		context2.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context3.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context4.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context5.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context6.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context7.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context8.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));
		context9.executeStrategy(jComboBox1.getSelectedItem().toString(),
				jComboBox2.getSelectedItem().toString(), jComboBox3
						.getSelectedItem().toString(), jTextField1.getText(),
				jTextField2.getText(), Integer.valueOf(jTextField3.getText()));

	}// GEN-LAST:event_jButton1ActionPerformed

	public void setPresenter(SoruBankasiPresenter pres) {
		presenter = pres;
	}

	public void updateStatusComboBox2(String line) {
		jComboBox1.addItem(line);
	}

	public void updateMessageBox() {
		JOptionPane.showMessageDialog(null, "Puan Değerini sayı girmelisiniz!",
				"Hatalı Giriş", -1);

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JInternalFrame jInternalFrame1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}
