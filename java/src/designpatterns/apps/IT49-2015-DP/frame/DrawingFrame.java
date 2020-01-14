package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
//import net.miginfocom.swing.MigLayout;
import view.DrawingView;
import controller.DrawingController;

public class DrawingFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btngrpOblici = new ButtonGroup();
	private final ButtonGroup btngrpOpcije = new ButtonGroup();
	private JList list;
	private DefaultListModel<String> dlmLogList;

	private DrawingView pnlDrawing = new DrawingView();
	public DrawingView getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(DrawingView pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}

	private DrawingController controller;

	private JFileChooser jFileChooser;
	private JFileChooser openChooser;
	
	private JMenuItem mntmUndo;
	private JMenuItem mntmRedo;
	private JMenuItem mntmToFront;
	private JMenuItem mntmToBack;
	private JMenuItem mntmBringToFront;
	private JMenuItem mntmBringToBack;
	private JMenuItem mntmGetLog;
	
	private JButton btnBorderColor;
	private JButton btnInnerColor;	
	private JButton btnModify;
	private JButton btnDelete;
	
	private Color borderColor = Color.BLACK;
	private Color innerColor = Color.WHITE;

	//	private boolean pomocniKlik = false;
	//	private Tacka pocetnaTacka, krajnjaTacka;
	//	private Color bojaIvice = Color.BLACK;
	//	private Color bojaUnutrasnjosti = Color.WHITE;
	//	private int brojElemenata;
	//	private boolean oblikSelektovan;


	public DrawingView getView() {
		return pnlDrawing;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingFrame() {
		setTitle("Nikola Savić IT49-2015");
		pnlDrawing.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setArmed(true);
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newFile();

			}
		});
		mnFile.add(mntmNew);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openChooser = new JFileChooser();
				openChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				openChooser.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				openChooser.enableInputMethods(true);
				openChooser.setMultiSelectionEnabled(false);
				openChooser.setFileHidingEnabled(false);
				openChooser.setEnabled(true);
				openChooser.setAcceptAllFileFilterUsed(false);

				openChooser.setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
				openChooser.setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
				controller.openFile();		

			}
		});
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
				jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jFileChooser.enableInputMethods(false);
				jFileChooser.setMultiSelectionEnabled(false);
				jFileChooser.setFileHidingEnabled(false);
				jFileChooser.setEnabled(true);
				jFileChooser.setDialogTitle("Save");
				jFileChooser.setAcceptAllFileFilterUsed(false);

				controller.save();

			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmClose);

		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setArmed(true);
		menuBar.add(mnEdit);

		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undoRedo(mntmUndo.getActionCommand());

			}
		});
		mnEdit.add(mntmUndo);
		mntmUndo.setEnabled(false);


		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.undoRedo(mntmRedo.getActionCommand());

			}
		});
		mnEdit.add(mntmRedo);
		mntmRedo.setEnabled(false);


		JMenuItem mntmBringToBack = new JMenuItem("Bring to back");
		mntmBringToBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.moveByZAxis(mntmBringToBack.getActionCommand());

			}
		});
		mnEdit.add(mntmBringToBack);
		mntmBringToBack.setEnabled(false);


		JMenuItem mntmBringToFront = new JMenuItem("Bring to front");
		mntmBringToFront.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.moveByZAxis(mntmBringToFront.getActionCommand());

			}
		});
		mnEdit.add(mntmBringToFront);
		mntmBringToFront.setEnabled(false);

		JMenuItem mntmToBack = new JMenuItem("To back");
		mntmToBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.moveByZAxis(mntmToBack.getActionCommand());

			}
		});
		mnEdit.add(mntmToBack);
		mntmToBack.setEnabled(false);


		JMenuItem mntmToFront = new JMenuItem("To front");
		mntmBringToFront.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.moveByZAxis(mntmBringToFront.getActionCommand());

			}
		});
		mnEdit.add(mntmToFront);
		mntmToFront.setEnabled(false);


		JMenuItem mntmGetLog = new JMenuItem("Get log");
		mntmGetLog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//controller.readCommand();

			}
		});
		mnEdit.add(mntmGetLog);
		mntmGetLog.setEnabled(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(pnlDrawing, BorderLayout.CENTER);

		JPanel pnlOptions = new JPanel();
		contentPane.add(pnlOptions, BorderLayout.NORTH);
		pnlOptions.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill][grow,fill]", "[15.00,grow,fill]"));

		//		JToggleButton tglbtnCrtaj = new JToggleButton("Crtaj");
		//		tglbtnCrtaj.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent arg0) {
		//				Iterator<Oblik> it = pnlCrtanje.listaOblika.iterator();
		//
		//				while(it.hasNext())
		//					it.next().setSelektovan(false);
		//			}
		//		});
		//		btngrpOpcije.add(tglbtnCrtaj);
		//		pnlOpcije.add(tglbtnCrtaj, "cell 0 0,alignx left,aligny top");

		JToggleButton tglBtnSelect = new JToggleButton("Select");

		btngrpOpcije.add(tglBtnSelect);
		pnlOptions.add(tglBtnSelect, "cell 0 0,alignx left,aligny top");
		tglBtnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnSelect.getActionCommand());

			}
		});

		//								tglBtnSelect.addItemListener(new ItemListener() {
		//									public void itemStateChanged(ItemEvent arg0) {
		//										if(tglBtnSelect.isSelected()){
		//											btnDelete.setEnabled(true);
		//											btnModify.setEnabled(true);
		//										}
		//										else
		//										{
		//											btnDelete.setEnabled(false);
		//											btnModify.setEnabled(false);
		//										}
		//									}
		//								});
		//		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.btnClicked(btnModify.getActionCommand());

			}
		});
		//				btnModify.addActionListener(new ActionListener() {
		//					public void actionPerformed(ActionEvent arg0) {
		//						if(pnlDrawing.listaOblika.isEmpty())
		//							JOptionPane.showMessageDialog(null, "Ne postoji ni jedan oblik koji bi mogao biti izmenjen.", "Greška", JOptionPane.ERROR_MESSAGE);
		//						else{
		//							Iterator<Oblik> it = pnlDrawing.listaOblika.iterator();
		//							while(it.hasNext())
		//							{						
		//								Oblik o = (Oblik) it.next();
		//
		//								if(o instanceof Tacka && o.isSelektovan()){
		//									Tacka t = (Tacka) o;
		//									DlgModifikacijaTacke dlgTacka = new DlgModifikacijaTacke();
		//
		//									dlgTacka.setBojaTacke(t.getBojaIvice());
		//									dlgTacka.txtKoordinataX.setText(Integer.toString(t.getX()));
		//									dlgTacka.txtKoordinataY.setText(Integer.toString(t.getY()));
		//									dlgTacka.btnBoja.setBackground(t.getBojaIvice());
		//
		//									dlgTacka.setVisible(true);
		//
		//									if(dlgTacka.prihvaceno)
		//									{
		//										t.setBojaIvice(dlgTacka.getBojaTacke());
		//
		//										if(dlgTacka.odabranaOpcija)
		//											t.pomeriNa(dlgTacka.x, dlgTacka.y);
		//										else if(!dlgTacka.odabranaOpcija)
		//											t.pomeriZa(dlgTacka.x, dlgTacka.y);
		//									}
		//
		//									t.setSelektovan(false);
		//
		//								}
		//								else if(o instanceof Linija && o.isSelektovan())
		//								{
		//									Linija l = (Linija) o;
		//									DlgModifikacijaLinije dlgLinija = new DlgModifikacijaLinije();
		//
		//									dlgLinija.setBojaLinije(l.getBojaIvice());
		//									dlgLinija.btnBoja.setBackground(l.getBojaIvice());
		//									dlgLinija.txtXYPocetna.setText(l.gettPocetna().toString());
		//									dlgLinija.txtXYKrajnja.setText(l.gettKrajnja().toString());
		//
		//									dlgLinija.setVisible(true);
		//
		//									if(dlgLinija.prihvaceno)
		//									{
		//										l.setBojaIvice(dlgLinija.getBojaLinije());
		//										l.pomeriZa(dlgLinija.x, dlgLinija.y);
		//									}
		//
		//									l.setSelektovan(false);
		//								}
		//								else if(o instanceof Kvadrat && !(o instanceof Pravougaonik) && o.isSelektovan())
		//								{
		//									Kvadrat kv = (Kvadrat) o;
		//									DlgModifikacijaKvadrata dlgKvadrat = new DlgModifikacijaKvadrata();
		//
		//									dlgKvadrat.setBojaIviceKvadrata(kv.getBojaIvice());
		//									dlgKvadrat.setBojaUnutrasnjostiKvadrata(kv.getBojaUnutrasnjost());
		//									dlgKvadrat.txtKoordinataX.setText(Integer.toString(kv.getGoreLevo().getX()));
		//									dlgKvadrat.txtKoordinataY.setText(Integer.toString(kv.getGoreLevo().getY()));
		//									dlgKvadrat.txtDuzinaStranice.setText(Integer.toString(kv.getDuzinaStranice()));
		//									dlgKvadrat.btnBojaIvice.setBackground(kv.getBojaIvice());
		//									dlgKvadrat.btnBojaUnutrasnjosti.setBackground(kv.getBojaUnutrasnjost());
		//
		//									dlgKvadrat.setVisible(true);
		//
		//									if(dlgKvadrat.prihvaceno)
		//									{
		//										kv.setBojaIvice(dlgKvadrat.getBojaIviceKvadrata());
		//										kv.setBojaUnutrasnjost(dlgKvadrat.getBojaUnutrasnjostiKvadrata());
		//										kv.setDuzinaStranica(dlgKvadrat.duzinaStranice);
		//
		//										if(dlgKvadrat.odabranaOpcija)
		//											kv.pomeriNa(dlgKvadrat.x, dlgKvadrat.y);
		//										else if(!dlgKvadrat.odabranaOpcija)
		//											kv.pomeriZa(dlgKvadrat.x, dlgKvadrat.y);
		//									}
		//
		//									kv.setSelektovan(false);
		//
		//								}
		//								else if(o instanceof Pravougaonik && o.isSelektovan())
		//								{
		//									Pravougaonik pr = (Pravougaonik) o;
		//									DlgModifikacijaPravougaonika dlgPravougaonik = new DlgModifikacijaPravougaonika();
		//
		//									dlgPravougaonik.setBojaIvicePravougaonika(pr.getBojaIvice());
		//									dlgPravougaonik.setBojaUnutrasnjostiPravougaonika(pr.getBojaUnutrasnjost());
		//									dlgPravougaonik.txtKoordinataX.setText(Integer.toString(pr.getGoreLevo().getX()));
		//									dlgPravougaonik.txtKoordinataY.setText(Integer.toString(pr.getGoreLevo().getY()));
		//									dlgPravougaonik.txtSirinaPravougaonika.setText(Integer.toString(pr.getDuzinaStranice()));
		//									dlgPravougaonik.txtVisinaPravougaonika.setText(Integer.toString(pr.getVisina()));
		//									dlgPravougaonik.btnBojaIvice.setBackground(pr.getBojaIvice());
		//									dlgPravougaonik.btnBojaUnutrasnjosti.setBackground(pr.getBojaUnutrasnjost());
		//
		//									dlgPravougaonik.setVisible(true);
		//
		//									if(dlgPravougaonik.prihvaceno)
		//									{
		//										pr.setBojaIvice(dlgPravougaonik.getBojaIvicePravougaonika());
		//										pr.setBojaUnutrasnjost(dlgPravougaonik.getBojaUnutrasnjostiPravougaonika());
		//										pr.setVisina(dlgPravougaonik.visinaPravougaonika);
		//										pr.setDuzinaStranica(dlgPravougaonik.sirinaPravougaonika);
		//
		//										if(dlgPravougaonik.odabranaOpcija)
		//											pr.pomeriNa(dlgPravougaonik.x, dlgPravougaonik.y);
		//										else if(!dlgPravougaonik.odabranaOpcija)
		//											pr.pomeriZa(dlgPravougaonik.x, dlgPravougaonik.y);
		//									}
		//
		//									pr.setSelektovan(false);
		//								}
		//								else if(o instanceof Krug && o.isSelektovan())
		//								{
		//									Krug kr = (Krug) o;
		//									DlgModifikacijaKruga dlgKrug = new DlgModifikacijaKruga();
		//
		//									dlgKrug.setBojaIviceKruga(kr.getBojaIvice());
		//									dlgKrug.setBojaUnutrasnjostiKruga(kr.getBojaUnutrasnjost());
		//									dlgKrug.txtKoordinataX.setText(Integer.toString(kr.getCentar().getX()));
		//									dlgKrug.txtKoordinataY.setText(Integer.toString(kr.getCentar().getY()));
		//									dlgKrug.txtPoluprecnik.setText(Integer.toString(kr.getR()));
		//									dlgKrug.btnBojaIvice.setBackground(kr.getBojaIvice());
		//									dlgKrug.btnBojaUnutrasnjosti.setBackground(kr.getBojaUnutrasnjost());
		//
		//									dlgKrug.setVisible(true);
		//
		//									if(dlgKrug.prihvaceno)
		//									{
		//										kr.setBojaIvice(dlgKrug.getBojaIviceKruga());
		//										kr.setBojaUnutrasnjost(dlgKrug.getBojaUnutrasnjostiKruga());
		//										kr.setR(dlgKrug.poluprecnik);
		//
		//										if(dlgKrug.odabranaOpcija)
		//											kr.pomeriNa(dlgKrug.x, dlgKrug.y);
		//										else if(!dlgKrug.odabranaOpcija)
		//											kr.pomeriZa(dlgKrug.x, dlgKrug.y);
		//									}
		//
		//									kr.setSelektovan(false);
		//								}
		//							}
		//						}
		//					}
		//				});
		btnModify.setEnabled(false);
		pnlOptions.add(btnModify, "cell 1 0,alignx left,aligny top");

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.btnClicked(btnDelete.getActionCommand());

			}
		});
		//				btnDelete.addActionListener(new ActionListener() {
		//					public void actionPerformed(ActionEvent arg0) {				
		//						if(pnlDrawing.listaOblika.isEmpty())
		//							JOptionPane.showMessageDialog(null, "Ne postoji ni jedan oblik koji bi mogao biti obrisan.", "Greška", JOptionPane.ERROR_MESSAGE);
		//						else{
		//							Iterator<Oblik> it = pnlDrawing.listaOblika.iterator();
		//							while(it.hasNext())
		//							{
		//								if(it.next().isSelektovan())
		//								{
		//									oblikSelektovan = true;
		//
		//									DlgBrisanje dlgBrisanje = new DlgBrisanje();
		//									dlgBrisanje.setVisible(true);
		//
		//									if(dlgBrisanje.prihvaceno)
		//										it.remove();
		//									break;
		//								}
		//								else
		//									oblikSelektovan = false;
		//							}
		//							if(!oblikSelektovan)
		//								JOptionPane.showMessageDialog(null, "Nije selektovan ni jedan oblik.", "Greška", JOptionPane.ERROR_MESSAGE);
		//						}
		//					}
		//				});
		btnDelete.setEnabled(false);
		pnlOptions.add(btnDelete, "flowx,cell 2 0,alignx left,aligny top");

		JPanel pnlShapes = new JPanel();
		contentPane.add(pnlShapes, BorderLayout.WEST);
		pnlShapes.setLayout(new MigLayout("", "[grow,fill]", "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][29.00][grow,fill][grow,fill]"));

		JToggleButton tglBtnPoint = new JToggleButton("Point");
		btngrpOblici.add(tglBtnPoint);
		pnlShapes.add(tglBtnPoint, "cell 0 0,growx,aligny center");
		tglBtnPoint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnPoint.getActionCommand());

			}
		});

		JToggleButton tglBtnLine = new JToggleButton("Line");
		btngrpOblici.add(tglBtnLine);
		pnlShapes.add(tglBtnLine, "cell 0 1,growx,aligny center");
		tglBtnLine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnLine.getActionCommand());

			}
		});

		JToggleButton tglBtnSquare = new JToggleButton("Square");
		btngrpOblici.add(tglBtnSquare);
		pnlShapes.add(tglBtnSquare, "cell 0 2,growx,aligny center");
		tglBtnSquare.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnSquare.getActionCommand());

			}
		});


		JToggleButton tglBtnRectangle = new JToggleButton("Rectangle");
		btngrpOblici.add(tglBtnRectangle);
		pnlShapes.add(tglBtnRectangle, "cell 0 3,growx,aligny center");
		tglBtnRectangle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnRectangle.getActionCommand());

			}
		});

		JToggleButton tglBtnCircle = new JToggleButton("Circle");
		btngrpOblici.add(tglBtnCircle);
		pnlShapes.add(tglBtnCircle, "cell 0 4,growx,aligny center");
		tglBtnCircle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnCircle.getActionCommand());

			}
		});

		JButton btnBorderColor = new JButton("Edge color");
		btnBorderColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnBorderColor.setBackground(controller.pickColor(btnBorderColor.getBackground()));
				setBorderColor(btnBorderColor.getBackground());
			}
		});
		//		btnBorderColor.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				btnBorderColor.setBackground(odabirBoje(btnBorderColor.getBackground()));
		//				bojaIvice = btnBorderColor.getBackground();
		//			}
		//		});

		JToggleButton tglBtnHexagon = new JToggleButton("Hexagon");
		pnlShapes.add(tglBtnHexagon, "cell 0 5,alignx left,growy");
		tglBtnHexagon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.tglBtnClicked(tglBtnHexagon.getActionCommand());

			}
		});
		pnlShapes.add(btnBorderColor, "cell 0 6,growx,aligny center");


		JButton btnInnerColor = new JButton("Area color");
		btnInnerColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnInnerColor.setBackground(controller.pickColor(btnInnerColor.getBackground()));
				setInnerColor(btnInnerColor.getBackground());
			}
		});
		//		btnInnerColor.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				btnInnerColor.setBackground(odabirBoje(btnInnerColor.getBackground()));
		//				bojaUnutrasnjosti = btnInnerColor.getBackground();
		//			}
		//		});
		pnlShapes.add(btnInnerColor, "flowy,cell 0 7,growx,aligny center");

		JPanel pnlLog = new JPanel();
		contentPane.add(pnlLog, BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane();
		pnlLog.add(scrollPane);

		dlmLogList = new DefaultListModel<String>();

		list = new JList();
		list.setVisibleRowCount(4);
		list.setFixedCellWidth(800);
		scrollPane.setViewportView(list);
		list.setModel(dlmLogList);

		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				controller.mouseClicked(arg0);

			}
		});
//		pnlDrawing.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//
//				if(tglBtnSelect.isSelected()){
//					brojElemenata = pnlDrawing.listaOblika.size() - 1;
//
//					for(int i = brojElemenata ; i >= 0 ; i--){
//						if(!pnlDrawing.listaOblika.get(i).sadrzi(arg0.getX(),arg0.getY()))
//							pnlDrawing.listaOblika.get(i).setSelektovan(false);
//					}
//
//
//					for(int i = brojElemenata ; i >= 0 ; i--){
//						if(pnlDrawing.listaOblika.get(i).sadrzi(arg0.getX(),arg0.getY()))
//						{
//							pnlDrawing.listaOblika.get(i).setSelektovan(true);
//							for(int j = 0 ; j <= brojElemenata ; j++)
//							{
//								if(j == i)
//									continue;
//								else
//									pnlDrawing.listaOblika.get(j).setSelektovan(false);
//							}
//							break;
//						}
//					}
//				}
//
//
//				if(tglbtnCrtaj.isSelected()){
//					if(tglBtnPoint.isSelected()){
//						Tacka t = new Tacka(arg0.getX(),arg0.getY(), bojaIvice);
//						t.crtajSe(pnlDrawing.getGraphics());
//						pnlDrawing.listaOblika.add(t);
//					}
//
//					if(tglBtnLine.isSelected()){
//						if(pomocniKlik == false)
//						{
//							pocetnaTacka = new Tacka(arg0.getX(), arg0.getY());
//
//							pomocniKlik = true;
//						}
//						else
//						{
//							krajnjaTacka = new Tacka(arg0.getX(), arg0.getY());
//							Linija l = new Linija(pocetnaTacka, krajnjaTacka, bojaIvice);
//							l.crtajSe(pnlDrawing.getGraphics());
//							pnlDrawing.listaOblika.add(l);
//
//							pomocniKlik = false;
//						}
//					}
//
//					if(tglBtnSquare.isSelected()){
//						Tacka goreLevo = new Tacka(arg0.getX(), arg0.getY());
//						DlgCrtanjeKvadrata dlgKvadrat = new DlgCrtanjeKvadrata();
//						dlgKvadrat.setVisible(true);
//
//						if(dlgKvadrat.prihvaceno)
//						{
//							Kvadrat kv = new Kvadrat(goreLevo, dlgKvadrat.duzinaStranice, bojaIvice, bojaUnutrasnjosti);
//							kv.crtajSe(pnlDrawing.getGraphics());
//							kv.popuni(pnlDrawing.getGraphics());
//							pnlDrawing.listaOblika.add(kv);
//						}
//					}
//
//					if(tglBtnRectangle.isSelected()){
//						Tacka goreLevo = new Tacka(arg0.getX(), arg0.getY());
//						DlgCrtanjePravougaonika dlgPravougaonik = new DlgCrtanjePravougaonika();
//						dlgPravougaonik.setVisible(true);
//
//						if(dlgPravougaonik.prihvaceno){
//							Pravougaonik pr = new Pravougaonik(goreLevo, dlgPravougaonik.sirinaPravougaonika, dlgPravougaonik.visinaPravougaonika, bojaIvice, bojaUnutrasnjosti);
//							pr.crtajSe(pnlDrawing.getGraphics());
//							pr.popuni(pnlDrawing.getGraphics());
//							pnlDrawing.listaOblika.add(pr);
//						}
//					}
//
//					if(tglBtnCircle.isSelected()){
//						Tacka centar = new Tacka(arg0.getX(), arg0.getY());
//						DlgCrtanjeKruga dlgKrug = new DlgCrtanjeKruga();
//						dlgKrug.setVisible(true);
//
//						if(dlgKrug.prihvaceno){
//							Krug kr = new Krug(centar, dlgKrug.r, bojaIvice, bojaUnutrasnjosti);
//							kr.crtajSe(pnlDrawing.getGraphics());
//							kr.popuni(pnlDrawing.getGraphics());
//							pnlDrawing.listaOblika.add(kr);
//						}
//					}
//				}
//			}
//		});
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

	public JButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(JButton btnModify) {
		this.btnModify = btnModify;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JFileChooser getjFileChooser() {
		return jFileChooser;
	}

	public void setjFileChooser(JFileChooser jFileChooser) {
		this.jFileChooser = jFileChooser;
	}

	public JFileChooser getOpenChooser() {
		return openChooser;
	}

	public void setOpenChooser(JFileChooser openChooser) {
		this.openChooser = openChooser;
	}

	public JMenuItem getMntmUndo() {
		return mntmUndo;
	}

	public void setMntmUndo(JMenuItem mntmUndo) {
		this.mntmUndo = mntmUndo;
	}

	public JMenuItem getMntmRedo() {
		return mntmRedo;
	}

	public void setMntmRedo(JMenuItem mntmRedo) {
		this.mntmRedo = mntmRedo;
	}

	public JMenuItem getMntmToFront() {
		return mntmToFront;
	}

	public void setMntmToFront(JMenuItem mntmToFront) {
		this.mntmToFront = mntmToFront;
	}

	public JMenuItem getMntmToBack() {
		return mntmToBack;
	}

	public void setMntmToBack(JMenuItem mntmToBack) {
		this.mntmToBack = mntmToBack;
	}

	public JMenuItem getMntmBringToFront() {
		return mntmBringToFront;
	}

	public void setMntmBringToFront(JMenuItem mntmBringToFront) {
		this.mntmBringToFront = mntmBringToFront;
	}

	public JMenuItem getMntmBringToBack() {
		return mntmBringToBack;
	}

	public void setMntmBringToBack(JMenuItem mntmBringToBack) {
		this.mntmBringToBack = mntmBringToBack;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel<String> getDlmLogList() {
		return dlmLogList;
	}

	public void setDlmLogList(DefaultListModel<String> dlmLogList) {
		this.dlmLogList = dlmLogList;
	}

	public JMenuItem getMntmGetLog() {
		return mntmGetLog;
	}

	public void setMntmGetLog(JMenuItem mntmGetLog) {
		this.mntmGetLog = mntmGetLog;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
//	public Color odabirBoje(Color boja)
//	{
//		Color novaBoja = JColorChooser.showDialog(null, "Odaberite boju:", boja);
//		if(novaBoja != null)
//			return novaBoja;
//		else
//			return boja;
//	}
}
