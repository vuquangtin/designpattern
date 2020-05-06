package designpatterns.gof.behavioral.interpreter.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <h1>Interpreter</h1> Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể,
 * cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong
 * ngôn ngữ.<br/>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class InterpDemo extends JFrame implements ActionListener {
	  JButton Go;

	  JTextField tx;

	  KidData kdata;

	  JawtList ptable;

	  public InterpDemo() {
	    super("Interpreter Demo");
	    addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });

	    tx = new JTextField(20);
	    Go = new JButton("Go");

	    JPanel p = new JPanel();
	    getContentPane().add(p);
	    p.setLayout(new BorderLayout());
	    JPanel np = new JPanel();
	    p.add("North", np);
	    np.add(tx);
	    np.add(Go);
	    Go.addActionListener(this);
	    ptable = new JawtList(20);
	    p.add("Center", ptable);

	    kdata = new KidData("50free.txt");

	    setSize(new Dimension(400, 200));
	    setVisible(true);
	  }

	  //----------------------------------------
	  public void actionPerformed(ActionEvent e) {
	    Parser p = new Parser(tx.getText());
	    p.setData(kdata, ptable);
	    p.Execute();
	  }

	  //----------------------------------------
	  static public void main(String argv[]) {
	    new InterpDemo();
	  }
	}

	interface Command {
	  public void Execute();
	}
	//this class is just a simple collection of arrays
	//of the data which has been selected

	class Data {
	  Kid[] kids;

	  public Data(Kid[] kd) {
	    kids = kd;
	  }

	  public Kid[] getData() {
	    return kids;
	  }
	}

	class ParseVar extends ParseObject {
	  static final int FRNAME = 0, LNAME = 1, AGE = 2, CLUB = 3, TIME = 4,
	      tabMAX = 5;

	  public ParseVar(String s) {
	    s = s.toLowerCase();
	    value = -1;
	    type = VAR;
	    if (s.equals("frname"))
	      value = FRNAME;
	    if (s.equals("lname"))
	      value = LNAME;
	    if (s.equals("age"))
	      value = AGE;
	    if (s.equals("club"))
	      value = CLUB;
	    if (s.equals("time"))
	      value = TIME;
	  }

	  //--------------------------------------
	  public boolean isLegal() {
	    return (value >= 0);
	  }
	}

	class Parser implements Command {
	  Stack stk;

	  Vector actionList;

	  KidData kdata;

	  Data data;

	  //PrintTable ptable;
	  JawtList ptable;

	  public Parser(String line) {
	    stk = new Stack();
	    actionList = new Vector();

	    StringTokenizer tok = new StringTokenizer(line);
	    while (tok.hasMoreElements()) {
	      ParseObject token = tokenize(tok.nextToken());
	      if (token != null)
	        stk.push(token);
	    }
	  }

	  //----------------------------------------
	  public void setData(KidData k, JawtList pt) {
	    data = new Data(k.getData());
	    ptable = pt;
	  }

	  //----------------------------------------
	  //executes parse of command line
	  public void Execute() {

	    while (stk.hasMoreElements()) {

	      if (topStack(ParseObject.VAR, ParseObject.VAR)) {
	        //reduce (Var Var) to Multvar
	        ParseVar v = (ParseVar) stk.pop();
	        ParseVar v1 = (ParseVar) stk.pop();
	        MultVar mv = new MultVar(v1, v);
	        stk.push(mv);
	      }
	      //reduce MULTVAR VAR to MULTVAR
	      if (topStack(ParseObject.MULTVAR, ParseObject.VAR)) {
	        MultVar mv = new MultVar();
	        MultVar mvo = (MultVar) stk.pop();
	        ParseVar v = (ParseVar) stk.pop();
	        mv.add(v);
	        Vector mvec = mvo.getVector();
	        for (int i = 0; i < mvec.size(); i++)
	          mv.add((ParseVar) mvec.elementAt(i));
	        stk.push(mv);
	      }
	      if (topStack(ParseObject.VAR, ParseObject.MULTVAR)) {
	        //reduce (Multvar Var) to Multvar
	        ParseVar v = (ParseVar) stk.pop();
	        MultVar mv = (MultVar) stk.pop();
	        mv.add(v);
	        stk.push(mv);
	      }
	      //reduce Verb Var to Verb containing vars
	      if (topStack(ParseObject.VAR, ParseObject.VERB)) {
	        addArgsToVerb();
	      }
	      //reduce Verb MultVar to Verb containing vars
	      if (topStack(ParseObject.MULTVAR, ParseObject.VERB)) {
	        addArgsToVerb();
	      }
	      //move top verb to action list
	      if (stk.top().getType() == ParseObject.VERB) {
	        actionList.addElement(stk.pop());
	      }

	    }//while
	    //now execute the verbs
	    //data.setData(kdata.getData());
	    //for (int i = actionList.size() -1; i >= 0; i--)
	    for (int i = 0; i < actionList.size(); i++) {
	      Verb v = (Verb) actionList.elementAt(i);
	      v.setData(data, ptable);
	      v.Execute();
	    }
	  }

	  //----------------------------------------
	  private void addArgsToVerb() {
	    ParseObject v = stk.pop();
	    ParseVerb verb = (ParseVerb) stk.pop();
	    verb.addArgs(v);
	    stk.push(verb);
	  }

	  //----------------------------------------
	  private boolean topStack(int c1, int c2) {
	    return (stk.top().getType() == c1) && (stk.nextTop().getType() == c2);
	  }

	  //----------------------------------------
	  private ParseObject tokenize(String s) {
	    ParseObject obj = getVerb(s);
	    if (obj == null)
	      obj = getVar(s);
	    return obj;
	  }

	  //----------------------------------------
	  private ParseVerb getVerb(String s) {
	    ParseVerb v;
	    v = new ParseVerb(s);
	    if (v.isLegal())
	      return v.getVerb(s);
	    else
	      return null;
	  }

	  //----------------------------------------
	  private ParseVar getVar(String s) {
	    ParseVar v;
	    v = new ParseVar(s);
	    if (v.isLegal())
	      return v;
	    else
	      return null;
	  }

	}

	class Kid {
	  String frname, lname, club;

	  int age;

	  float time;

	  //-------------------------------------
	  public Kid(String line) {
	    StringTokenizer tok = new StringTokenizer(line);

	    String lnum = tok.nextToken();
	    frname = tok.nextToken();
	    lname = tok.nextToken();
	    age = new Integer(tok.nextToken()).intValue();
	    club = tok.nextToken();
	    time = new Float(tok.nextToken()).floatValue();
	  }

	  //-------------------------------
	  public Object getData(int key) {
	    switch (key) {
	    case ParseVar.FRNAME:
	      return frname;
	    case ParseVar.LNAME:
	      return lname;
	    case ParseVar.CLUB:
	      return club;
	    case ParseVar.AGE:
	      return new Integer(age);
	    case ParseVar.TIME:
	      return new Float(time);
	    }

	    return null;
	  }

	  //--------------------------------
	  public int getAge() {
	    return age;
	  }

	  public float getTime() {
	    return time;
	  }

	  public String getFrname() {
	    return frname;
	  }

	  public String getLname() {
	    return lname;
	  }

	  public String getClub() {
	    return club;
	  }
	}

	interface awtList {
	  public void add(String s);

	  public void remove(String s);

	  public String[] getSelectedItems();

	}

	//this is a simple adapter class to
	//convert List awt methods to Swing methods

	class JawtList extends JScrollPane implements ListSelectionListener, awtList {
	  private JList listWindow;

	  private JListData listContents;

	  //-----------------------------------------
	  public JawtList(int rows) {
	    listContents = new JListData();
	    listWindow = new JList(listContents);
	    listWindow.setPrototypeCellValue("Abcdefg Hijkmnop");
	    getViewport().add(listWindow);

	  }

	  //-----------------------------------------
	  public void add(String s) {
	    listContents.addElement(s);
	  }

	  //-----------------------------------------
	  public void remove(String s) {
	    listContents.removeElement(s);
	  }

	  //-----------------------------------------
	  public void clear() {
	    listContents.clear();
	  }

	  //-----------------------------------------
	  public String[] getSelectedItems() {
	    Object[] obj = listWindow.getSelectedValues();
	    String[] s = new String[obj.length];
	    for (int i = 0; i < obj.length; i++)
	      s[i] = obj[i].toString();
	    return s;
	  }

	  //-----------------------------------------
	  public void valueChanged(ListSelectionEvent e) {
	  }

	}
	//  =========================================

	class JListData extends AbstractListModel {
	  private Vector data;

	  //-----------------------------------------
	  public JListData() {
	    data = new Vector();
	  }

	  //-----------------------------------------
	  public int getSize() {
	    return data.size();
	  }

	  //-----------------------------------------
	  public Object getElementAt(int index) {
	    return data.elementAt(index);
	  }

	  //-----------------------------------------
	  public void addElement(String s) {
	    data.addElement(s);
	    fireIntervalAdded(this, data.size() - 1, data.size());
	  }

	  //-----------------------------------------
	  public void removeElement(String s) {
	    data.removeElement(s);
	    fireIntervalRemoved(this, 0, data.size());
	  }

	  //-----------------------------------------
	  public void clear() {
	    int size = data.size();
	    data = new Vector();
	    fireIntervalRemoved(this, 0, size);
	  }
	}

	class ParseObject {
	  public static final int VERB = 1000, VAR = 1010, MULTVAR = 1020;

	  protected int value;

	  protected int type;

	  public int getValue() {
	    return value;
	  }

	  public int getType() {
	    return type;
	  }
	}

	class ParseVerb extends ParseObject {
	  static public final int PRINT = 100, SORTBY = 110, THENBY = 120;

	  protected Vector args;

	  public ParseVerb(String s) {
	    args = new Vector();
	    s = s.toLowerCase();
	    value = -1;
	    type = VERB;
	    if (s.equals("print"))
	      value = PRINT;
	    if (s.equals("sortby"))
	      value = SORTBY;
	  }

	  //-----------------------------------
	  public ParseVerb getVerb(String s) {
	    switch (value) {
	    case PRINT:
	      return new Print(s);
	    case SORTBY:
	      return new Sort(s);
	    }
	    return null;
	  }

	  //-----------------------------------
	  public void addArgs(MultVar mv) {
	    args = mv.getVector();
	  }

	  //-----------------------------------
	  public void addArgs(ParseObject p) {
	    args.addElement(p);
	  }

	  //-----------------------------------
	  public boolean isLegal() {
	    return (value >= 0);
	  }

	  //-----------------------------------
	}

	class Sort extends Verb {
	  Kid[] kids;

	  int pindex;

	  public Sort(String s) {
	    super(s);
	    value = SORTBY;
	  }

	  //-----------------------------------

	  public void Execute() {
	    int sortKey;

	    kids = data.getData();

	    for (int a = 0; a < args.size(); a++) {
	      ParseVar v = (ParseVar) args.elementAt(a);
	      if (v instanceof MultVar) {
	        MultVar mv = (MultVar) v;
	        Vector mvec = mv.getVector();
	        for (int k = mvec.size() - 1; k >= 0; k--) {
	          ParseVar pv = (ParseVar) mvec.elementAt(k);
	          sortKey = pv.getValue();
	          sortByKey(sortKey);
	        }
	      } else {
	        sortKey = v.getValue();
	        sortByKey(sortKey);
	      }
	    }

	  }

	  //----------------------------------------
	  private void sortByKey(int sortkey) {
	    System.out.println(sortkey);
	    for (int i = 0; i < kids.length; i++)
	      for (int j = i + 1; j < kids.length; j++)
	        if (compare(i, j, sortkey)) {
	          Kid tmp = kids[i];
	          kids[i] = kids[j];
	          kids[j] = tmp;
	        }
	  }

	  //----------------------------------------
	  private boolean compare(int i, int j, int key) {
	    boolean cval;

	    switch (key) {
	    case ParseVar.FRNAME:
	      cval = kids[i].getFrname().compareTo(kids[j].getFrname()) > 0;
	      break;
	    case ParseVar.LNAME:
	      cval = kids[i].getLname().compareTo(kids[j].getLname()) > 0;
	      break;
	    case ParseVar.CLUB:
	      cval = kids[i].getClub().compareTo(kids[j].getClub()) > 0;
	      break;
	    case ParseVar.AGE:
	      cval = kids[i].getAge() > kids[j].getAge();
	      break;
	    case ParseVar.TIME:
	      cval = kids[i].getTime() > kids[j].getTime();
	      break;
	    default:
	      cval = false;
	    }
	    return cval;
	  }

	}

	class Verb extends ParseVerb implements Command {
	  protected Data data;

	  protected JawtList ptable;

	  public Verb(String s) {
	    super(s);
	  }

	  public void Execute() {
	  }

	  public void setData(Data dt, JawtList pt) {
	    data = dt;
	    ptable = pt;
	  }
	}

	class Print extends Verb {
	  Kid[] kids;

	  public Print(String s) {
	    super(s);
	    value = PRINT;
	  }

	  //-----------------------------------
	  public void Execute() {
	    String pline;

	    kids = data.getData();
	    //ptable.setDims(kids.length, args.size());
	    ptable.clear();

	    for (int i = 0; i < kids.length; i++) {
	      pline = ""; //line in output list
	      for (int j = 0; j < args.size(); j++) {

	        ParseVar v = (ParseVar) args.elementAt(j);
	        if (v instanceof MultVar) {
	          MultVar mv = (MultVar) v;
	          Vector vlist = mv.getVector();
	          for (int k = 0; k < vlist.size(); k++) {
	            ParseVar pv = (ParseVar) vlist.elementAt(k);
	            //System.out.print(kids[i].getData(pv.getValue())+" ");
	            pline += kids[i].getData(pv.getValue()) + "   ";
	          }
	        } else {
	          // System.out.print(kids[i].getData(v.getValue())+" ");
	          //ptable.setValueAt( kids[i].getData(v.getValue()), i, j);
	          pline += kids[i].getData(v.getValue()) + "   ";
	        }
	      }
	      ptable.add(pline);
	      //System.out.println();
	    }
	    ptable.validate();
	    ptable.repaint();
	  }
	  //-----------------------------------

	}

	class MultVar extends ParseVar {
	  Vector multVec;

	  public MultVar(ParseObject v1, ParseObject v2) {
	    super("");
	    multVec = new Vector();
	    multVec.addElement(v1);
	    multVec.addElement(v2);
	    type = MULTVAR;
	  }

	  public MultVar() {
	    super("");
	    multVec = new Vector();
	    type = MULTVAR;

	  }

	  public void add(ParseObject v1) {
	    multVec.addElement(v1);
	  }

	  public Vector getVector() {
	    return multVec;
	  }

	}

	class KidData {
	  Vector kids;

	  //------------------------------------------
	  public KidData(String filename) {
	    kids = new Vector();
	    InputFile f = new InputFile(filename);
	    String s = f.readLine();
	    while (s != null) {
	      if (s.trim().length() > 0) {
	        Kid k = new Kid(s);
	        kids.addElement(k);
	      }
	      s = f.readLine();
	    }
	  }

	  //--------------------------------
	  public Kid[] getData() {
	    Kid[] kd = new Kid[kids.size()];
	    for (int i = 0; i < kids.size(); i++)
	      kd[i] = (Kid) kids.elementAt(i);
	    return kd;
	  }

	  //--------------------------------

	  public int size() {
	    return kids.size();
	  }

	  //--------------------------------
	  public Kid getKid(int i) {
	    return (Kid) kids.elementAt(i);
	  }

	  //--------------------------------
	  public Vector getKidData(int key) {
	    Vector v = new Vector();
	    for (int i = 0; i < kids.size(); i++)
	      v.addElement(getKid(i).getData(key));
	    return v;
	  }

	  //--------------------------------
	  public int getTableKey(String tabName) {
	    int key = -1;
	    tabName = tabName.toLowerCase();
	    if (tabName.equals("frname"))
	      key = ParseVar.FRNAME;
	    if (tabName.equals("lname"))
	      key = ParseVar.LNAME;
	    if (tabName.equals("age"))
	      key = ParseVar.AGE;
	    if (tabName.equals("club"))
	      key = ParseVar.CLUB;
	    if (tabName.equals("time"))
	      key = ParseVar.TIME;

	    return key;
	  }

	  //----------------------------
	  public String getTableName(int i) {
	    String name = "";
	    switch (i) {
	    case ParseVar.FRNAME:
	      name = "frname";
	    case ParseVar.LNAME:
	      name = "lname";
	    case ParseVar.AGE:
	      name = "age";
	    case ParseVar.CLUB:
	      name = "club";
	    case ParseVar.TIME:
	      name = "time";
	    }
	    return name;
	  }
	  //----------------------------

	}

	class InputFile {
	  RandomAccessFile f = null;

	  boolean errflag;

	  String s = null;

	  public InputFile(String fname) {
	    errflag = false;
	    try {
	      //open file
	      f = new RandomAccessFile(fname, "r");
	    } catch (IOException e) {
	      //print error if not found
	      System.out.println("no file found");
	      errflag = true; //and set flag
	    }
	  }

	  //-----------------------------------------
	  public boolean checkErr() {
	    return errflag;
	  }

	  //-----------------------------------------
	  public String read() {
	    //read a single field up to a comma or end of line
	    String ret = "";
	    if (s == null) //if no data in string
	    {
	      s = readLine(); //read next line
	    }
	    if (s != null) //if there is data
	    {
	      s.trim(); //trim off blanks
	      int i = s.indexOf(","); //find next comma
	      if (i <= 0) {
	        ret = s.trim(); //if no commas go to end of line
	        s = null; //and null out stored string
	      } else {
	        ret = s.substring(0, i).trim(); //return left of comma
	        s = s.substring(i + 1); //save right of comma
	      }
	    } else
	      ret = null;
	    return ret; //return string
	  }

	  //-----------------------------------------
	  public String readLine() {
	    //read in a line from the file
	    s = null;
	    try {
	      s = f.readLine(); //could throw error
	    } catch (IOException e) {
	      errflag = true;
	      System.out.println("File read error");
	    }
	    return s;
	  }

	  //-----------------------------------------
	  public void close() {
	    try {
	      f.close(); //close file
	    } catch (IOException e) {
	      System.out.println("File close error");
	      errflag = true;
	    }
	  }
	  //-----------------------------------------
	}

	class Stack {
	  Vector stk;

	  public Stack() {
	    stk = new Vector();
	  }

	  //----------------------------------------
	  public void push(Object obj) {
	    stk.addElement(obj);
	  }

	  //----------------------------------------
	  public ParseObject pop() {
	    ParseObject obj = (ParseObject) stk.lastElement();
	    int i = stk.size() - 1;
	    stk.removeElementAt(i);
	    return obj;
	  }

	  //----------------------------------------
	  public void dump(String s) {
	    System.out.println(s);
	    dump();
	  }

	  //----------------------------------------

	  public void dump() {
	    for (int i = 0; i < stk.size(); i++) {
	      ParseObject p = (ParseObject) stk.elementAt(i);
	      System.out.println(i + " " + p.getType());
	    }
	  }

	  //----------------------------------------
	  public ParseObject top() {
	    return (ParseObject) stk.lastElement();
	  }

	  //----------------------------------------
	  public boolean hasMoreElements() {
	    return (stk.size() > 0);
	  }

	  //----------------------------------------
	  public ParseObject nextTop() {
	    int i = stk.size();
	    if (i > 1) {
	      return (ParseObject) stk.elementAt(i - 2);
	    } else
	      return null;
	  }

	  //----------------------------------------
	  public void pop2Push(ParseObject p) {
	    int i = stk.size();
	    if (i >= 2) {
	      pop();
	      pop();
	      push(p);
	    } else
	      push(p);
	  }
	}
	//50free.txt
	/*
	1 Amanda McCarthy             12  WCA         29.28
	2 Jamie Falco                 12  HNHS        29.80
	3 Meaghan O'Donnell           12  EDST        30.00
	4 Greer Gibbs                 12  CDEV        30.04
	5 Rhiannon Jeffrey            11  WYW         30.04
	6 Sophie Connolly             12  WAC         30.05
	7 Dana Helyer                 12  ARAC        30.18
	8 Lindsay Marotto             12  OAK         30.23
	9 Sarah Treichel              12  WYW         30.35
	10 Ashley McEntee             12  RAC         30.47
	11 Rachel Brookman            12  CAT         30.51
	12 Michelle Ducharme          12  LEHY        30.51
	13 Karleen Danais             12  NES         30.70
	14 Megan Loock                12  WAC         30.90
	15 Kaitlyn Ament              12  HNHS        30.93
	16 Tara Schoen                12  WYW         31.01
	17 Kate Olshefski             12  NCY         31.01
	18 Emma Zuidema               12  HMST        31.07
	19 Katie Persing              12  OAK         31.14
	20 Christina Monsees          11  RAC         31.27
	21 Kimberly Watcke            12  CDEV        31.50
	22 Colleen Smith              12  AJSC        31.52
	23 Chloe Osborne              12  GYWD        31.74
	24 Natalia Fugate             12  WAC         31.75
	25 Lisa McHale                11  RAC         31.76
	26 Lindsay Cowles             11  NES         31.79
	27 Jacquelyn Yavarone         12  HNHS        31.83
	28 Molly Fenn                 12  WRAT        31.84
	29 Karin Brudvig              12  HMST        31.84
	30 Annie Duffy                12  MGAT        31.90
	31 Nicole Coia                11  WCA         31.94
	32 Elizabeth Rice             12  WYW         31.96
	33 Yvette Landwehr            12  WRAT        32.00
	34 Ashley Recklet             12  SHEL        32.24
	35 Lauren McKenna             11  PSDY        32.27
	36 Kristen Fontaine           12  EDST        32.28
	37 Diana Cooke                12  ZEUS        32.33
	38 Kimberly Gambino           11  NES         32.43
	39 Jenny Morgan               11  NES         32.49
	40 Colleen Coelho             12  CDEV        32.50
	41 Leigh Gordon               12  CDEV        32.62
	42 Caitlin Gillen             12  WYW         32.75
	43 Kristen Skroski            12  HNHS        32.91
	44 Sarah Greenberg            11  CDEV        32.97
	45 Kathy Collins              12  EHBB        33.11
	46 Morgan Bullock             12  ICSC        33.33
	47 Brittany Medlin            12  CAT         33.33
	48 Haley Ottenbreit           12  HNHS        33.35
	49 Laura Kunces               11  WAC         33.64
	50 Hayley Wolfgruber          12  WYW         33.73
	51 Katie Duffy                12  MGAT        34.24


	*/