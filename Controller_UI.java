import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.SystemColor;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTable;
//import javax.swing.UIManager;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
//import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JToolBar;
//import javax.swing.JPopupMenu;
//import javax.swing.JMenuBar;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
//import javax.swing.*;

public class Controller_UI {

	private JFrame frmPicfSimulator;
	// private JTable table_Panel_Fileregister_SFR_GPR;
	public static Highlighter.Highlight[] highlights;
	public static JPanel panel_5 = new JPanel(new BorderLayout());
	public static JPanel panel_ProgrammLSTDatei = new JPanel(new BorderLayout());
	public static JTextArea textArea_Panel_ProgrammLSTDatei = new JTextArea();
	public static JPanel panel = new JPanel();
	public static JPanel panel_SFR_W = new JPanel();
	public static JLabel lbl_SFR_W_WRegister = new JLabel("W-Register:");
	public static JLabel lbl_SFR_W_PCL = new JLabel("PCL:");
	public static JLabel lbl_SFR_W_PCLATH = new JLabel("PCLATH:");
	public static JLabel lbl_SFR_W_PCintern = new JLabel("PC intern:");
	public static JLabel lbl_SFR_W_Status = new JLabel("Status:");
	public static JLabel lbl_SFR_W_FSR = new JLabel("FSR:");
	public static JLabel lbl_SFR_W_WRegister_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_PCL_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_PCLATH_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_PCintern_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_Status_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_FSR_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_Option = new JLabel("Option:");
	public static JLabel lbl_SFR_W_Vorteiler = new JLabel("Vorteiler:");
	public static JLabel lbl_SFR_W_Timer0 = new JLabel("Timer0:");
	public static JLabel lbl_SFR_W_Option_Value = new JLabel("00");
	public static JLabel lbl_SFR_W_Vorteiler_Value = new JLabel("1:1");
	public static JLabel lbl_SFR_W_Timer0_Value = new JLabel("00");
	public static JPanel panel_2 = new JPanel();
	public static JPanel panel_Stack = new JPanel();
	public static JLabel lbl_Stack_0001 = new JLabel("0001");
	public static JLabel lbl_Stack_0002 = new JLabel("0002");
	public static JLabel lbl_Stack_0003 = new JLabel("0003");
	public static JLabel lbl_Stack_0004 = new JLabel("0004");
	public static JLabel lbl_Stack_0005 = new JLabel("0005");
	public static JLabel lbl_Stack_0006 = new JLabel("0006");
	public static JLabel lbl_Stack_0007 = new JLabel("0007");
	public static JLabel lbl_Stack_0008 = new JLabel("0008");
	public static JPanel panel_1 = new JPanel();
	public static JPanel panel_SFRBit = new JPanel();
	public static JLabel lbl_SFRBit_Status = new JLabel("Status:");
	public static JLabel lbl_SFRBit_Option = new JLabel("Option:");
	public static JLabel lbl_SFRBit_Intcon = new JLabel("Intcon:");
	public static JLabel lbl_SFRBit_IRP = new JLabel("IRP");
	public static JLabel lbl_SFRBit_RP1 = new JLabel("RP1");
	public static JLabel lbl_SFRBit_RP0 = new JLabel("RP0");
	public static JLabel lbl_SFRBit_TO = new JLabel("TO");
	public static JLabel lbl_SFRBit_PD = new JLabel("PD");
	public static JLabel lbl_SFRBit_Z = new JLabel("Z");
	public static JLabel lbl_SFRBit_DC = new JLabel("DC");
	public static JLabel lbl_SFRBit_C = new JLabel("C");
	public static JLabel lbl_SFRBit_IRP_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_RP1_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_RP0_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_TO_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_PD_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_Z_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_DC_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_C_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_RPu = new JLabel("RPu");
	public static JLabel lbl_SFRBit_RPu_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_IEg_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_IEg = new JLabel("IEg");
	public static JLabel lbl_SFRBit_TCs = new JLabel("TCs");
	public static JLabel lbl_SFRBit_TCs_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_TSe_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_TSe = new JLabel("TSe");
	public static JLabel lbl_SFRBit_PSA = new JLabel("PSA");
	public static JLabel lbl_SFRBit_PSA_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_PS2_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_PS2 = new JLabel("PS2");
	public static JLabel lbl_SFRBit_PS1 = new JLabel("PS1");
	public static JLabel lbl_SFRBit_PS1_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_PS0_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_PS0 = new JLabel("PS0");
	public static JLabel lbl_SFRBit_GIE = new JLabel("GIE");
	public static JLabel lbl_SFRBit_GIE_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_EIE_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_EIE = new JLabel("EIE");
	public static JLabel lbl_SFRBit_TIE = new JLabel("TIE");
	public static JLabel lbl_SFRBit_TIE_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_IE_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_IE = new JLabel("IE");
	public static JLabel lbl_SFRBit_RIE = new JLabel("RIE");
	public static JLabel lbl_SFRBit_RIE_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_TIF_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_TIF = new JLabel("TIF");
	public static JLabel lbl_SFRBit_IF = new JLabel("IF");
	public static JLabel lbl_SFRBit_IF_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_RIF_Value = new JLabel("0");
	public static JLabel lbl_SFRBit_RIF = new JLabel("RIF");
	public static JPanel panel_8 = new JPanel();
	public static JPanel panel_Fileregister_SFR_GPR = new JPanel();
	public static JScrollPane scrollPane = new JScrollPane();
	public static String[] columnHeaders = { "0x", "+0", "+1", "+2", "+3", "+4", "+5", "+6", "+7" };
	public static Object[][] data = {
			{ "00", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "08", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "10", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "18", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "20", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "28", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "30", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "38", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "40", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "48", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "50", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "58", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "60", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "68", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "70", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "78", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "80", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "88", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "90", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "98", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "A0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "A8", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "B0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "B8", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "C0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "C8", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "D0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "D8", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "E0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "E8", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "F0", " ", " ", " ", " ", " ", " ", " ", " " },
			{ "F8", " ", " ", " ", " ", " ", " ", " ", " " }
	};;
	public static JTable table_Panel_Fileregister_SFR_GPR = new JTable(data, columnHeaders);
	public static JPanel panel_3 = new JPanel();
	public static JPanel panel_PortA = new JPanel();
	public static JLabel lbl_PortA_Tris = new JLabel("Tris");
	public static JLabel lbl_PortA_Pin = new JLabel("Pin");
	// public static JCheckBox checkbox_PortA_Tris_Value7 = new JCheckBox("7");
	// public static JCheckBox checkbox_PortA_Tris_Value6 = new JCheckBox("6");
	// public static JCheckBox checkbox_PortA_Tris_Value5 = new JCheckBox("5");
	public static JCheckBox checkbox_PortA_Tris_Value4 = new JCheckBox("4");
	public static JCheckBox checkbox_PortA_Tris_Value3 = new JCheckBox("3");
	public static JCheckBox checkbox_PortA_Tris_Value2 = new JCheckBox("2");
	public static JCheckBox checkbox_PortA_Tris_Value1 = new JCheckBox("1");
	public static JCheckBox checkbox_PortA_Tris_Value0 = new JCheckBox("0");
	public static JCheckBox checkbox_PortA_Pin_Value0 = new JCheckBox("0");
	public static JCheckBox checkbox_PortA_Pin_Value1 = new JCheckBox("1");
	public static JCheckBox checkbox_PortA_Pin_Value2 = new JCheckBox("2");
	public static JCheckBox checkbox_PortA_Pin_Value3 = new JCheckBox("3");
	public static JCheckBox checkbox_PortA_Pin_Value4 = new JCheckBox("4");
	public static JPanel panel_4 = new JPanel();
	public static JPanel panel_PortB = new JPanel();
	public static JLabel lbl_PortB_Pin = new JLabel("Pin");
	public static JLabel lbl_PortB_Tris = new JLabel("Tris");
	public static JCheckBox checkbox_PortB_Tris_Value7 = new JCheckBox("7");
	public static JCheckBox checkbox_PortB_Tris_Value6 = new JCheckBox("6");
	public static JCheckBox checkbox_PortB_Tris_Value5 = new JCheckBox("5");
	public static JCheckBox checkbox_PortB_Tris_Value4 = new JCheckBox("4");
	public static JCheckBox checkbox_PortB_Pin_Value4 = new JCheckBox("4");
	public static JCheckBox checkbox_PortB_Pin_Value3 = new JCheckBox("3");
	public static JCheckBox checkbox_PortB_Tris_Value3 = new JCheckBox("3");
	public static JCheckBox checkbox_PortB_Tris_Value2 = new JCheckBox("2");
	public static JCheckBox checkbox_PortB_Pin_Value2 = new JCheckBox("2");
	public static JCheckBox checkbox_PortB_Pin_Value1 = new JCheckBox("1");
	public static JCheckBox checkbox_PortB_Tris_Value1 = new JCheckBox("1");
	public static JCheckBox checkbox_PortB_Tris_Value0 = new JCheckBox("0");
	public static JCheckBox checkbox_PortB_Pin_Value0 = new JCheckBox("0");
	public static JCheckBox checkbox_PortB_Pin_Value5 = new JCheckBox("5");
	public static JCheckBox checkbox_PortB_Pin_Value6 = new JCheckBox("6");
	public static JCheckBox checkbox_PortB_Pin_Value7 = new JCheckBox("7");
	public static JPanel panel_6 = new JPanel();
	public static JPanel panel_Timing = new JPanel();
	public static JPanel panel_7 = new JPanel();
	public static JPanel panel_Bedienelemente = new JPanel();
	public static JButton btn_Bedienelemente_Start = new JButton("Start");
	public static JButton btn_Bedienelemente_Stopp = new JButton("Stopp");
	public static JButton btn_Bedienelemente_Reset = new JButton("Reset");
	public static JButton btn_Bedienelemente_1Schritt = new JButton("1 Schritt");
	public static JToolBar Toolbar = new JToolBar();
	public static JFileChooser chooser = new JFileChooser();
	public static JButton btn_Datei_Laden = new JButton("Datei laden");
	static DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(
			Color.GREEN);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller_UI window = new Controller_UI();
					window.frmPicfSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Controller_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	// @SuppressWarnings("deprecation")
	private void initialize() {
		frmPicfSimulator = new JFrame();
		frmPicfSimulator.setTitle("PIC16F84 Simulator");
		frmPicfSimulator.setBounds(100, 100, 1200, 750);
		frmPicfSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPicfSimulator.getContentPane().setLayout(null);

		// JPanel panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "Programm (LST-Datei)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(4, 256, 734, 462);
		frmPicfSimulator.getContentPane().add(panel_5);
		// panel_5.setLayout(null);

		// JPanel panel_ProgrammLSTDatei = new JPanel();
		panel_ProgrammLSTDatei.setBounds(6, 16, 722, 435);
		// panel_ProgrammLSTDatei.setLayout(null);
		panel_5.add(panel_ProgrammLSTDatei);
		panel_ProgrammLSTDatei.setBackground(Color.WHITE);
		// panel_ProgrammLSTDatei.setLayout(null);

		// JTextArea textArea_Panel_ProgrammLSTDatei = new JTextArea();
		textArea_Panel_ProgrammLSTDatei.setEditable(false);
		textArea_Panel_ProgrammLSTDatei.setBounds(10, 11, 702, 800);
		// create the middle panel components

		JScrollPane scroll = new JScrollPane(textArea_Panel_ProgrammLSTDatei);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// textArea_Panel_ProgrammLSTDatei.add(scroll);
		panel_ProgrammLSTDatei.add(scroll);
		panel_ProgrammLSTDatei.setVisible(true);

		// JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "SFR + W", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 38, 262, 207);
		frmPicfSimulator.getContentPane().add(panel);
		panel.setLayout(null);

		// JPanel panel_SFR_W = new JPanel();
		panel_SFR_W.setBounds(6, 16, 250, 180);
		panel.add(panel_SFR_W);
		panel_SFR_W.setBackground(Color.WHITE);
		panel_SFR_W.setLayout(null);

		// JLabel lbl_SFR_W_WRegister = new JLabel("W-Register:");
		lbl_SFR_W_WRegister.setBounds(10, 11, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_WRegister);

		// JLabel lbl_SFR_W_PCL = new JLabel("PCL:");
		lbl_SFR_W_PCL.setBounds(10, 36, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_PCL);

		// JLabel lbl_SFR_W_PCLATH = new JLabel("PCLATH:");
		lbl_SFR_W_PCLATH.setBounds(10, 61, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_PCLATH);

		// JLabel lbl_SFR_W_PCintern = new JLabel("PC intern:");
		lbl_SFR_W_PCintern.setBounds(10, 86, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_PCintern);

		// JLabel lbl_SFR_W_Status = new JLabel("Status:");
		lbl_SFR_W_Status.setBounds(10, 111, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_Status);

		// JLabel lbl_SFR_W_FSR = new JLabel("FSR:");
		lbl_SFR_W_FSR.setBounds(10, 136, 74, 14);
		panel_SFR_W.add(lbl_SFR_W_FSR);

		// JLabel lbl_SFR_W_WRegister_Value = new JLabel("00");
		lbl_SFR_W_WRegister_Value.setBounds(94, 11, 39, 14);
		panel_SFR_W.add(lbl_SFR_W_WRegister_Value);

		// JLabel lbl_SFR_W_PCL_Value = new JLabel("00");
		lbl_SFR_W_PCL_Value.setBounds(94, 36, 39, 14);
		panel_SFR_W.add(lbl_SFR_W_PCL_Value);

		// JLabel lbl_SFR_W_PCLATH_Value = new JLabel("00");
		lbl_SFR_W_PCLATH_Value.setBounds(93, 61, 40, 14);
		panel_SFR_W.add(lbl_SFR_W_PCLATH_Value);

		// JLabel lbl_SFR_W_PCintern_Value = new JLabel("00");
		lbl_SFR_W_PCintern_Value.setBounds(93, 86, 40, 14);
		panel_SFR_W.add(lbl_SFR_W_PCintern_Value);

		// JLabel lbl_SFR_W_Status_Value = new JLabel("00");
		lbl_SFR_W_Status_Value.setBounds(93, 111, 40, 14);
		panel_SFR_W.add(lbl_SFR_W_Status_Value);

		// JLabel lbl_SFR_W_FSR_Value = new JLabel("00");
		lbl_SFR_W_FSR_Value.setBounds(93, 136, 40, 14);
		panel_SFR_W.add(lbl_SFR_W_FSR_Value);

		// JLabel lbl_SFR_W_Option = new JLabel("Option:");
		lbl_SFR_W_Option.setBounds(143, 11, 97, 14);
		panel_SFR_W.add(lbl_SFR_W_Option);

		// JLabel lbl_SFR_W_Vorteiler = new JLabel("Vorteiler:");
		lbl_SFR_W_Vorteiler.setBounds(143, 36, 97, 14);
		panel_SFR_W.add(lbl_SFR_W_Vorteiler);

		// JLabel lbl_SFR_W_Timer0 = new JLabel("Timer0:");
		lbl_SFR_W_Timer0.setBounds(143, 61, 97, 14);
		panel_SFR_W.add(lbl_SFR_W_Timer0);

		// JLabel lbl_SFR_W_Option_Value = new JLabel("00");
		lbl_SFR_W_Option_Value.setBounds(201, 11, 39, 14);
		panel_SFR_W.add(lbl_SFR_W_Option_Value);

		// JLabel lbl_SFR_W_Vorteiler_Value = new JLabel("1:1");
		lbl_SFR_W_Vorteiler_Value.setBounds(201, 36, 39, 14);
		panel_SFR_W.add(lbl_SFR_W_Vorteiler_Value);

		// JLabel lbl_SFR_W_Timer0_Value = new JLabel("00");
		lbl_SFR_W_Timer0_Value.setBounds(201, 61, 39, 14);
		panel_SFR_W.add(lbl_SFR_W_Timer0_Value);

		// JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Stack", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(637, 38, 101, 207);
		frmPicfSimulator.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		// JPanel panel_Stack = new JPanel();
		panel_Stack.setBounds(6, 16, 89, 180);
		panel_2.add(panel_Stack);
		panel_Stack.setBackground(Color.WHITE);
		panel_Stack.setLayout(null);

		// JLabel lbl_Stack_0001 = new JLabel("0001");
		lbl_Stack_0001.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0001.setBounds(24, 22, 35, 14);
		panel_Stack.add(lbl_Stack_0001);

		// JLabel lbl_Stack_0002 = new JLabel("0002");
		lbl_Stack_0002.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0002.setBounds(24, 36, 35, 14);
		panel_Stack.add(lbl_Stack_0002);

		// JLabel lbl_Stack_0003 = new JLabel("0003");
		lbl_Stack_0003.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0003.setBounds(24, 50, 35, 14);
		panel_Stack.add(lbl_Stack_0003);

		// JLabel lbl_Stack_0004 = new JLabel("0004");
		lbl_Stack_0004.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0004.setBounds(24, 64, 35, 14);
		panel_Stack.add(lbl_Stack_0004);

		// JLabel lbl_Stack_0005 = new JLabel("0005");
		lbl_Stack_0005.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0005.setBounds(24, 78, 35, 14);
		panel_Stack.add(lbl_Stack_0005);

		// JLabel lbl_Stack_0006 = new JLabel("0006");
		lbl_Stack_0006.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0006.setBounds(24, 92, 35, 14);
		panel_Stack.add(lbl_Stack_0006);

		// JLabel lbl_Stack_0007 = new JLabel("0007");
		lbl_Stack_0007.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0007.setBounds(24, 106, 35, 14);
		panel_Stack.add(lbl_Stack_0007);

		// JLabel lbl_Stack_0008 = new JLabel("0008");
		lbl_Stack_0008.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Stack_0008.setBounds(24, 120, 35, 14);
		panel_Stack.add(lbl_Stack_0008);

		// JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "SFR (Bit)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(264, 38, 375, 207);
		frmPicfSimulator.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		// JPanel panel_SFRBit = new JPanel();
		panel_SFRBit.setBounds(6, 16, 363, 180);
		panel_1.add(panel_SFRBit);
		panel_SFRBit.setBackground(Color.WHITE);
		panel_SFRBit.setLayout(null);

		// JLabel lbl_SFRBit_Status = new JLabel("Status:");
		lbl_SFRBit_Status.setBounds(10, 11, 48, 14);
		panel_SFRBit.add(lbl_SFRBit_Status);

		// JLabel lbl_SFRBit_Option = new JLabel("Option:");
		lbl_SFRBit_Option.setBounds(10, 61, 48, 14);
		panel_SFRBit.add(lbl_SFRBit_Option);

		// JLabel lbl_SFRBit_Intcon = new JLabel("Intcon:");
		lbl_SFRBit_Intcon.setBounds(10, 111, 48, 14);
		panel_SFRBit.add(lbl_SFRBit_Intcon);

		// JLabel lbl_SFRBit_IRP = new JLabel("IRP");
		lbl_SFRBit_IRP.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IRP.setBounds(68, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IRP);

		// JLabel lbl_SFRBit_RP1 = new JLabel("RP1");
		lbl_SFRBit_RP1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RP1.setBounds(103, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RP1);

		// JLabel lbl_SFRBit_RP0 = new JLabel("RP0");
		lbl_SFRBit_RP0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RP0.setBounds(138, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RP0);

		// JLabel lbl_SFRBit_TO = new JLabel("TO");
		lbl_SFRBit_TO.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TO.setBounds(173, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TO);

		// JLabel lbl_SFRBit_PD = new JLabel("PD");
		lbl_SFRBit_PD.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PD.setBounds(208, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PD);

		// JLabel lbl_SFRBit_Z = new JLabel("Z");
		lbl_SFRBit_Z.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_Z.setBounds(243, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_Z);

		// JLabel lbl_SFRBit_DC = new JLabel("DC");
		lbl_SFRBit_DC.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_DC.setBounds(278, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_DC);

		// JLabel lbl_SFRBit_C = new JLabel("C");
		lbl_SFRBit_C.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_C.setBounds(313, 11, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_C);

		// JLabel lbl_SFRBit_IRP_Value = new JLabel("0");
		lbl_SFRBit_IRP_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IRP_Value.setBounds(68, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IRP_Value);

		// JLabel lbl_SFRBit_RP1_Value = new JLabel("0");
		lbl_SFRBit_RP1_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RP1_Value.setBounds(103, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RP1_Value);

		// JLabel lbl_SFRBit_RP0_Value = new JLabel("0");
		lbl_SFRBit_RP0_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RP0_Value.setBounds(138, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RP0_Value);

		// JLabel lbl_SFRBit_TO_Value = new JLabel("0");
		lbl_SFRBit_TO_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TO_Value.setBounds(173, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TO_Value);

		// JLabel lbl_SFRBit_PD_Value = new JLabel("0");
		lbl_SFRBit_PD_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PD_Value.setBounds(208, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PD_Value);

		// JLabel lbl_SFRBit_Z_Value = new JLabel("0");
		lbl_SFRBit_Z_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_Z_Value.setBounds(243, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_Z_Value);

		// JLabel lbl_SFRBit_DC_Value = new JLabel("0");
		lbl_SFRBit_DC_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_DC_Value.setBounds(278, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_DC_Value);

		// JLabel lbl_SFRBit_C_Value = new JLabel("0");
		lbl_SFRBit_C_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_C_Value.setBounds(313, 36, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_C_Value);

		// JLabel lbl_SFRBit_RPu = new JLabel("RPu");
		lbl_SFRBit_RPu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RPu.setBounds(68, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RPu);

		// JLabel lbl_SFRBit_RPu_Value = new JLabel("0");
		lbl_SFRBit_RPu_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RPu_Value.setBounds(68, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RPu_Value);

		// JLabel lbl_SFRBit_IEg_Value = new JLabel("0");
		lbl_SFRBit_IEg_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IEg_Value.setBounds(103, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IEg_Value);

		// JLabel lbl_SFRBit_IEg = new JLabel("IEg");
		lbl_SFRBit_IEg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IEg.setBounds(103, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IEg);

		// JLabel lbl_SFRBit_TCs = new JLabel("TCs");
		lbl_SFRBit_TCs.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TCs.setBounds(138, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TCs);

		// JLabel lbl_SFRBit_TCs_Value = new JLabel("0");
		lbl_SFRBit_TCs_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TCs_Value.setBounds(138, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TCs_Value);

		// JLabel lbl_SFRBit_TSe_Value = new JLabel("0");
		lbl_SFRBit_TSe_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TSe_Value.setBounds(173, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TSe_Value);

		// JLabel lbl_SFRBit_TSe = new JLabel("TSe");
		lbl_SFRBit_TSe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TSe.setBounds(173, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TSe);

		// JLabel lbl_SFRBit_PSA = new JLabel("PSA");
		lbl_SFRBit_PSA.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PSA.setBounds(208, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PSA);

		// JLabel lbl_SFRBit_PSA_Value = new JLabel("0");
		lbl_SFRBit_PSA_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PSA_Value.setBounds(208, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PSA_Value);

		// JLabel lbl_SFRBit_PS2_Value = new JLabel("0");
		lbl_SFRBit_PS2_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS2_Value.setBounds(243, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS2_Value);

		// JLabel lbl_SFRBit_PS2 = new JLabel("PS2");
		lbl_SFRBit_PS2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS2.setBounds(243, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS2);

		// JLabel lbl_SFRBit_PS1 = new JLabel("PS1");
		lbl_SFRBit_PS1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS1.setBounds(278, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS1);

		// JLabel lbl_SFRBit_PS1_Value = new JLabel("0");
		lbl_SFRBit_PS1_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS1_Value.setBounds(278, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS1_Value);

		// JLabel lbl_SFRBit_PS0_Value = new JLabel("0");
		lbl_SFRBit_PS0_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS0_Value.setBounds(313, 86, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS0_Value);

		// JLabel lbl_SFRBit_PS0 = new JLabel("PS0");
		lbl_SFRBit_PS0.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_PS0.setBounds(313, 61, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_PS0);

		// JLabel lbl_SFRBit_GIE = new JLabel("GIE");
		lbl_SFRBit_GIE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_GIE.setBounds(68, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_GIE);

		// JLabel lbl_SFRBit_GIE_Value = new JLabel("0");
		lbl_SFRBit_GIE_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_GIE_Value.setBounds(68, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_GIE_Value);

		// JLabel lbl_SFRBit_EIE_Value = new JLabel("0");
		lbl_SFRBit_EIE_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_EIE_Value.setBounds(103, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_EIE_Value);

		// JLabel lbl_SFRBit_EIE = new JLabel("EIE");
		lbl_SFRBit_EIE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_EIE.setBounds(103, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_EIE);

		// JLabel lbl_SFRBit_TIE = new JLabel("TIE");
		lbl_SFRBit_TIE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TIE.setBounds(138, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TIE);

		// JLabel lbl_SFRBit_TIE_Value = new JLabel("0");
		lbl_SFRBit_TIE_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TIE_Value.setBounds(138, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TIE_Value);

		// JLabel lbl_SFRBit_IE_Value = new JLabel("0");
		lbl_SFRBit_IE_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IE_Value.setBounds(173, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IE_Value);

		// JLabel lbl_SFRBit_IE = new JLabel("IE");
		lbl_SFRBit_IE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IE.setBounds(173, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IE);

		// JLabel lbl_SFRBit_RIE = new JLabel("RIE");
		lbl_SFRBit_RIE.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RIE.setBounds(208, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RIE);

		// JLabel lbl_SFRBit_RIE_Value = new JLabel("0");
		lbl_SFRBit_RIE_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RIE_Value.setBounds(208, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RIE_Value);

		// JLabel lbl_SFRBit_TIF_Value = new JLabel("0");
		lbl_SFRBit_TIF_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TIF_Value.setBounds(243, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TIF_Value);

		// JLabel lbl_SFRBit_TIF = new JLabel("TIF");
		lbl_SFRBit_TIF.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_TIF.setBounds(243, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_TIF);

		// JLabel lbl_SFRBit_IF = new JLabel("IF");
		lbl_SFRBit_IF.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IF.setBounds(278, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IF);

		// JLabel lbl_SFRBit_IF_Value = new JLabel("0");
		lbl_SFRBit_IF_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_IF_Value.setBounds(278, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_IF_Value);

		// JLabel lbl_SFRBit_RIF_Value = new JLabel("0");
		lbl_SFRBit_RIF_Value.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RIF_Value.setBounds(313, 136, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RIF_Value);

		// JLabel lbl_SFRBit_RIF = new JLabel("RIF");
		lbl_SFRBit_RIF.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SFRBit_RIF.setBounds(313, 111, 25, 14);
		panel_SFRBit.add(lbl_SFRBit_RIF);

		// JPanel panel_8 = new JPanel();
		panel_8.setBorder(
				new TitledBorder(null, "Fileregister (SFR + GPR)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(736, 256, 444, 300);
		frmPicfSimulator.getContentPane().add(panel_8);
		panel_8.setLayout(null);

		// JPanel panel_Fileregister_SFR_GPR = new JPanel();
		panel_Fileregister_SFR_GPR.setBounds(6, 16, 432, 273);
		panel_8.add(panel_Fileregister_SFR_GPR);
		panel_Fileregister_SFR_GPR.setBackground(Color.WHITE);
		panel_Fileregister_SFR_GPR.setLayout(null);

		// JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 412, 251);
		panel_Fileregister_SFR_GPR.add(scrollPane);

		// String[] columnHeaders = { "0x", "+0", "+1", "+2", "+3", "+4", "+5", "+6",
		// "+7" };
		/*
		 * Object[][] data = {
		 * { "00", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "08", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "10", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "18", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "20", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "28", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "30", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "38", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "40", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "48", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "50", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "58", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "60", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "68", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "70", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "78", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "80", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "88", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "90", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "98", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "A0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "A8", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "B0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "B8", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "C0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "C8", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "D0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "D8", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "E0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "E8", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "F0", " ", " ", " ", " ", " ", " ", " ", " " },
		 * { "F8", " ", " ", " ", " ", " ", " ", " ", " " }
		 * };
		 */

		// table_Panel_Fileregister_SFR_GPR = new JTable(data, columnHeaders);
		scrollPane.setViewportView(table_Panel_Fileregister_SFR_GPR);
		table_Panel_Fileregister_SFR_GPR.setBorder(new LineBorder(Color.BLACK));
		table_Panel_Fileregister_SFR_GPR.setBackground(Color.WHITE);
		table_Panel_Fileregister_SFR_GPR.setEnabled(false);

		// JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Port A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(736, 38, 444, 101);
		frmPicfSimulator.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		// JPanel panel_PortA = new JPanel();
		panel_PortA.setBounds(6, 16, 432, 74);
		panel_3.add(panel_PortA);
		panel_PortA.setBackground(Color.WHITE);
		panel_PortA.setLayout(null);

		// JLabel lbl_PortA_Tris = new JLabel("Tris");
		lbl_PortA_Tris.setBounds(10, 11, 30, 14);
		panel_PortA.add(lbl_PortA_Tris);

		// JLabel lbl_PortA_Pin = new JLabel("Pin");
		lbl_PortA_Pin.setBounds(10, 36, 30, 14);
		panel_PortA.add(lbl_PortA_Pin);

		// JCheckBox checkbox_PortA_Tris_Value7 = new JCheckBox("7");
		// checkbox_PortA_Tris_Value7.setBounds(46, 7, 40, 23);
		// panel_PortA.add(checkbox_PortA_Tris_Value7);

		// JCheckBox checkbox_PortA_Tris_Value6 = new JCheckBox("6");
		// checkbox_PortA_Tris_Value6.setBounds(88, 7, 40, 23);
		// panel_PortA.add(checkbox_PortA_Tris_Value6);

		// JCheckBox checkbox_PortA_Tris_Value5 = new JCheckBox("5");
		// checkbox_PortA_Tris_Value5.setBounds(130, 7, 40, 23);
		// panel_PortA.add(checkbox_PortA_Tris_Value5);

		// JCheckBox checkbox_PortA_Tris_Value4 = new JCheckBox("4");
		checkbox_PortA_Tris_Value4.setBounds(172, 7, 40, 23);
		panel_PortA.add(checkbox_PortA_Tris_Value4);

		// JCheckBox checkbox_PortA_Tris_Value3 = new JCheckBox("3");
		checkbox_PortA_Tris_Value3.setBounds(214, 7, 40, 23);
		panel_PortA.add(checkbox_PortA_Tris_Value3);

		// JCheckBox checkbox_PortA_Tris_Value2 = new JCheckBox("2");
		checkbox_PortA_Tris_Value2.setBounds(256, 7, 40, 23);
		panel_PortA.add(checkbox_PortA_Tris_Value2);

		// JCheckBox checkbox_PortA_Tris_Value1 = new JCheckBox("1");
		checkbox_PortA_Tris_Value1.setBounds(298, 7, 40, 23);
		panel_PortA.add(checkbox_PortA_Tris_Value1);

		// JCheckBox checkbox_PortA_Tris_Value0 = new JCheckBox("0");
		checkbox_PortA_Tris_Value0.setBounds(340, 7, 40, 23);
		panel_PortA.add(checkbox_PortA_Tris_Value0);

		// JCheckBox checkbox_PortA_Pin_Value0 = new JCheckBox("0");
		checkbox_PortA_Pin_Value0.setBounds(340, 36, 40, 23);
		panel_PortA.add(checkbox_PortA_Pin_Value0);

		// JCheckBox checkbox_PortA_Pin_Value1 = new JCheckBox("1");
		checkbox_PortA_Pin_Value1.setBounds(298, 36, 40, 23);
		panel_PortA.add(checkbox_PortA_Pin_Value1);

		// JCheckBox checkbox_PortA_Pin_Value2 = new JCheckBox("2");
		checkbox_PortA_Pin_Value2.setBounds(256, 36, 40, 23);
		panel_PortA.add(checkbox_PortA_Pin_Value2);

		// JCheckBox checkbox_PortA_Pin_Value3 = new JCheckBox("3");
		checkbox_PortA_Pin_Value3.setBounds(214, 36, 40, 23);
		panel_PortA.add(checkbox_PortA_Pin_Value3);

		// JCheckBox checkbox_PortA_Pin_Value4 = new JCheckBox("4");
		checkbox_PortA_Pin_Value4.setBounds(172, 36, 40, 23);
		panel_PortA.add(checkbox_PortA_Pin_Value4);

		// JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Port B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(736, 144, 444, 101);
		frmPicfSimulator.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		// JPanel panel_PortB = new JPanel();
		panel_PortB.setBounds(6, 16, 432, 74);
		panel_4.add(panel_PortB);
		panel_PortB.setBackground(Color.WHITE);
		panel_PortB.setLayout(null);

		// JLabel lbl_PortB_Pin = new JLabel("Pin");
		lbl_PortB_Pin.setBounds(10, 36, 30, 14);
		panel_PortB.add(lbl_PortB_Pin);

		// JLabel lbl_PortB_Tris = new JLabel("Tris");
		lbl_PortB_Tris.setBounds(10, 11, 30, 14);
		panel_PortB.add(lbl_PortB_Tris);

		// JCheckBox checkbox_PortB_Tris_Value7 = new JCheckBox("7");
		checkbox_PortB_Tris_Value7.setBounds(46, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value7);

		// JCheckBox checkbox_PortB_Tris_Value6 = new JCheckBox("6");
		checkbox_PortB_Tris_Value6.setBounds(88, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value6);

		// JCheckBox checkbox_PortB_Tris_Value5 = new JCheckBox("5");
		checkbox_PortB_Tris_Value5.setBounds(130, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value5);

		// JCheckBox checkbox_PortB_Tris_Value4 = new JCheckBox("4");
		checkbox_PortB_Tris_Value4.setBounds(172, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value4);

		// JCheckBox checkbox_PortB_Pin_Value4 = new JCheckBox("4");
		checkbox_PortB_Pin_Value4.setBounds(172, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value4);

		// JCheckBox checkbox_PortB_Pin_Value3 = new JCheckBox("3");
		checkbox_PortB_Pin_Value3.setBounds(214, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value3);

		// JCheckBox checkbox_PortB_Tris_Value3 = new JCheckBox("3");
		checkbox_PortB_Tris_Value3.setBounds(214, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value3);

		// JCheckBox checkbox_PortB_Tris_Value2 = new JCheckBox("2");
		checkbox_PortB_Tris_Value2.setBounds(256, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value2);

		// JCheckBox checkbox_PortB_Pin_Value2 = new JCheckBox("2");
		checkbox_PortB_Pin_Value2.setBounds(256, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value2);

		// JCheckBox checkbox_PortB_Pin_Value1 = new JCheckBox("1");
		checkbox_PortB_Pin_Value1.setBounds(298, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value1);

		// JCheckBox checkbox_PortB_Tris_Value1 = new JCheckBox("1");
		checkbox_PortB_Tris_Value1.setBounds(298, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value1);

		// JCheckBox checkbox_PortB_Tris_Value0 = new JCheckBox("0");
		checkbox_PortB_Tris_Value0.setBounds(340, 7, 40, 23);
		panel_PortB.add(checkbox_PortB_Tris_Value0);

		// JCheckBox checkbox_PortB_Pin_Value0 = new JCheckBox("0");
		checkbox_PortB_Pin_Value0.setBounds(340, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value0);

		// JCheckBox checkbox_PortB_Pin_Value5 = new JCheckBox("5");
		checkbox_PortB_Pin_Value5.setBounds(130, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value5);

		// JCheckBox checkbox_PortB_Pin_Value6 = new JCheckBox("6");
		checkbox_PortB_Pin_Value6.setBounds(88, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value6);

		// JCheckBox checkbox_PortB_Pin_Value7 = new JCheckBox("7");
		checkbox_PortB_Pin_Value7.setBounds(46, 36, 40, 23);
		panel_PortB.add(checkbox_PortB_Pin_Value7);

		// JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Timing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(736, 567, 239, 151);
		frmPicfSimulator.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		// JPanel panel_Timing = new JPanel();
		panel_Timing.setBounds(6, 16, 227, 124);
		panel_6.add(panel_Timing);
		panel_Timing.setBackground(Color.WHITE);

		// JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Bedienelemente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(973, 573, 208, 145);
		frmPicfSimulator.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		// JPanel panel_Bedienelemente = new JPanel();
		panel_Bedienelemente.setBounds(6, 16, 196, 118);
		panel_7.add(panel_Bedienelemente);
		panel_Bedienelemente.setBackground(Color.WHITE);
		panel_Bedienelemente.setLayout(null);

		// JButton btn_Bedienelemente_Start = new JButton("Start");
		btn_Bedienelemente_Start.setBounds(10, 7, 176, 23);
		panel_Bedienelemente.add(btn_Bedienelemente_Start);

		// JButton btn_Bedienelemente_Stopp = new JButton("Stopp");
		btn_Bedienelemente_Stopp.setBounds(10, 32, 176, 23);
		panel_Bedienelemente.add(btn_Bedienelemente_Stopp);

		// JButton btn_Bedienelemente_Reset = new JButton("Reset");
		btn_Bedienelemente_Reset.setBounds(10, 85, 176, 23);
		panel_Bedienelemente.add(btn_Bedienelemente_Reset);
		btn_Bedienelemente_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				W_Register.resetValue();
				// lbl_SFR_W_PCL_Value
				// lbl_SFR_W_PCLATH_Value
				PC.resetProgrammCounter();
				StatusReg.resetStatusReg();
				// lbl_SFR_W_FSR_Value
				Option.resetOption();
				// lbl_SFR_W_Vorteiler_Value
				// lbl_SFR_W_Timer0_Value
				Intcon.resetIntcon();
				Stack.resetStack();
				Tris_Ra.resetTrisA();
				Port_RA.resetPort_RA();
				Tris_RB.resetTrisB();
				Port_RB.resetPort_RB();
				textArea_Panel_ProgrammLSTDatei.getHighlighter().removeAllHighlights();
				try {
					textArea_Panel_ProgrammLSTDatei.getHighlighter().addHighlight(
							textArea_Panel_ProgrammLSTDatei
									.getLineStartOffset(Flash.firstCommandLine[PC.programCounter]),
							textArea_Panel_ProgrammLSTDatei
									.getLineEndOffset(Flash.firstCommandLine[PC.programCounter]),
							painter);
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				uiUpdate();
			}
		});

		// JButton btn_Bedienelemente_1Schritt = new JButton("1 Schritt");
		btn_Bedienelemente_1Schritt.setBounds(10, 58, 176, 23);
		panel_Bedienelemente.add(btn_Bedienelemente_1Schritt);
		btn_Bedienelemente_1Schritt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionRegister.nextInstruction();
				System.out.println("Programmcounter: " + PC.programCounter);
				if (PC.programCounter < Flash.firstCommandLine.length) {
					try {
						textArea_Panel_ProgrammLSTDatei.getHighlighter().addHighlight(
								textArea_Panel_ProgrammLSTDatei
										.getLineStartOffset(Flash.firstCommandLine[PC.programCounter]),
								textArea_Panel_ProgrammLSTDatei
										.getLineEndOffset(Flash.firstCommandLine[PC.programCounter]),
								painter);

						// if (PC.programCounter > 0) {
						textArea_Panel_ProgrammLSTDatei.getHighlighter().removeAllHighlights();

						// }
						textArea_Panel_ProgrammLSTDatei.getHighlighter().addHighlight(
								textArea_Panel_ProgrammLSTDatei
										.getLineStartOffset(Flash.firstCommandLine[PC.programCounter]),
								textArea_Panel_ProgrammLSTDatei
										.getLineEndOffset(Flash.firstCommandLine[PC.programCounter]),
								painter);

					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}

					uiUpdate();
				}

				// lbl_SFR_W_WRegister_Value.setText(Integer.toHexString(W_Register.getValue()));
			}
		});

		// JToolBar Toolbar = new JToolBar();
		Toolbar.setFloatable(false);
		Toolbar.setBounds(2, 1, 1178, 36);
		frmPicfSimulator.getContentPane().add(Toolbar);

		// JFileChooser chooser = new JFileChooser();
		// Dialog zum Speichern von Dateien anzeigen

		// JButton btn_Datei_Laden = new JButton("Datei laden");
		btn_Datei_Laden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ret = chooser.showOpenDialog(null);

				/* Abfrage, ob auf "Öffnen" geklickt wurde */
				if (ret == JFileChooser.APPROVE_OPTION) {
					// Ausgabe der ausgewaehlten Datei
					textArea_Panel_ProgrammLSTDatei.setText(null);
					String sProgram = Flash.readFile(chooser.getSelectedFile().getName());
					textArea_Panel_ProgrammLSTDatei.insert(sProgram, 0);
					try {
						if (PC.programCounter > 0) {
							textArea_Panel_ProgrammLSTDatei.getHighlighter().removeAllHighlights();
						}
						textArea_Panel_ProgrammLSTDatei.getHighlighter().addHighlight(
								textArea_Panel_ProgrammLSTDatei
										.getLineStartOffset(Flash.firstCommandLine[PC.programCounter]),
								textArea_Panel_ProgrammLSTDatei
										.getLineEndOffset(Flash.firstCommandLine[PC.programCounter]),
								painter);
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}

					uiUpdate();
				}
			}
		});
		Toolbar.add(btn_Datei_Laden);

	}

	public static void uiUpdate() {
		System.out.println("W_Register: " + W_Register.getValue());
		lbl_SFR_W_WRegister_Value.setText(Integer.toHexString(W_Register.getValue()).toUpperCase());
		// lbl_SFR_W_PCL_Value
		// lbl_SFR_W_PCLATH_Value
		lbl_SFR_W_PCintern_Value.setText(Integer.toHexString(PC.programCounter));
		lbl_SFR_W_Status_Value.setText(StatusReg.getStatus());
		// lbl_SFR_W_FSR_Value
		lbl_SFR_W_Option_Value.setText(Option.getOption());
		// lbl_SFR_W_Vorteiler_Value
		// lbl_SFR_W_Timer0_Value

		// Status Register
		lbl_SFRBit_IRP_Value.setText(Integer.toString(StatusReg.getIRP()));
		lbl_SFRBit_RP1_Value.setText(Integer.toString(StatusReg.getRP1()));
		lbl_SFRBit_RP0_Value.setText(Integer.toString(StatusReg.getRP0()));
		lbl_SFRBit_TO_Value.setText(Integer.toString(StatusReg.getTO()));
		lbl_SFRBit_PD_Value.setText(Integer.toString(StatusReg.getPD()));
		lbl_SFRBit_Z_Value.setText(Integer.toString(StatusReg.getZeroFlag()));
		lbl_SFRBit_DC_Value.setText(Integer.toString(StatusReg.getDigitCarryFlag()));
		lbl_SFRBit_C_Value.setText(Integer.toString(StatusReg.getCarryFlag()));

		// Option Register
		lbl_SFRBit_RPu_Value.setText(Integer.toString(Option.getRBPU()));
		lbl_SFRBit_IEg_Value.setText(Integer.toString(Option.getINTDEG()));
		lbl_SFRBit_TCs_Value.setText(Integer.toString(Option.getT0CS()));
		lbl_SFRBit_TSe_Value.setText(Integer.toString(Option.getT0SE()));
		lbl_SFRBit_PSA_Value.setText(Integer.toString(Option.getPSA()));
		lbl_SFRBit_PS2_Value.setText(Integer.toString(Option.getPS2()));
		lbl_SFRBit_PS1_Value.setText(Integer.toString(Option.getPS1()));
		lbl_SFRBit_PS0_Value.setText(Integer.toString(Option.getPS0()));

		// INTCON Register
		lbl_SFRBit_GIE_Value.setText(Integer.toString(Intcon.getGIE()));
		lbl_SFRBit_EIE_Value.setText(Integer.toString(Intcon.getEEIE()));
		lbl_SFRBit_TIE_Value.setText(Integer.toString(Intcon.getT0IE()));
		lbl_SFRBit_IE_Value.setText(Integer.toString(Intcon.getINTE()));
		lbl_SFRBit_RIE_Value.setText(Integer.toString(Intcon.getRBIE()));
		lbl_SFRBit_TIF_Value.setText(Integer.toString(Intcon.getT0IF()));
		lbl_SFRBit_IF_Value.setText(Integer.toString(Intcon.getINTF()));
		lbl_SFRBit_RIF_Value.setText(Integer.toString(Intcon.getRBIF()));

		// Stack
		lbl_Stack_0001.setText(Integer.toHexString(Stack.getValueUI(0)));
		lbl_Stack_0002.setText(Integer.toHexString(Stack.getValueUI(1)));
		lbl_Stack_0003.setText(Integer.toHexString(Stack.getValueUI(2)));
		lbl_Stack_0004.setText(Integer.toHexString(Stack.getValueUI(3)));
		lbl_Stack_0005.setText(Integer.toHexString(Stack.getValueUI(4)));
		lbl_Stack_0006.setText(Integer.toHexString(Stack.getValueUI(5)));
		lbl_Stack_0007.setText(Integer.toHexString(Stack.getValueUI(6)));
		lbl_Stack_0008.setText(Integer.toHexString(Stack.getValueUI(7)));

		// Port A, Tris, Pin
		checkbox_PortA_Tris_Value4.setSelected(Tris_Ra.getTrisA(4));
		checkbox_PortA_Tris_Value3.setSelected(Tris_Ra.getTrisA(3));
		checkbox_PortA_Tris_Value2.setSelected(Tris_Ra.getTrisA(2));
		checkbox_PortA_Tris_Value1.setSelected(Tris_Ra.getTrisA(1));
		checkbox_PortA_Tris_Value0.setSelected(Tris_Ra.getTrisA(0));
		checkbox_PortA_Pin_Value4.setSelected(Port_RA.getPortRA(4));
		checkbox_PortA_Pin_Value3.setSelected(Port_RA.getPortRA(3));
		checkbox_PortA_Pin_Value2.setSelected(Port_RA.getPortRA(2));
		checkbox_PortA_Pin_Value1.setSelected(Port_RA.getPortRA(1));
		checkbox_PortA_Pin_Value0.setSelected(Port_RA.getPortRA(0));

		// Port B, Tris, Pin
		checkbox_PortB_Tris_Value7.setSelected(Tris_RB.getTris_B(7));
		checkbox_PortB_Tris_Value6.setSelected(Tris_RB.getTris_B(6));
		checkbox_PortB_Tris_Value5.setSelected(Tris_RB.getTris_B(5));
		checkbox_PortB_Tris_Value4.setSelected(Tris_RB.getTris_B(4));
		checkbox_PortB_Tris_Value3.setSelected(Tris_RB.getTris_B(3));
		checkbox_PortB_Tris_Value2.setSelected(Tris_RB.getTris_B(2));
		checkbox_PortB_Tris_Value1.setSelected(Tris_RB.getTris_B(1));
		checkbox_PortB_Tris_Value0.setSelected(Tris_RB.getTris_B(0));
		checkbox_PortB_Pin_Value7.setSelected(Port_RB.getPort_RB(7));
		checkbox_PortB_Pin_Value6.setSelected(Port_RB.getPort_RB(6));
		checkbox_PortB_Pin_Value5.setSelected(Port_RB.getPort_RB(5));
		checkbox_PortB_Pin_Value4.setSelected(Port_RB.getPort_RB(4));
		checkbox_PortB_Pin_Value3.setSelected(Port_RB.getPort_RB(3));
		checkbox_PortB_Pin_Value2.setSelected(Port_RB.getPort_RB(2));
		checkbox_PortB_Pin_Value1.setSelected(Port_RB.getPort_RB(1));
		checkbox_PortB_Pin_Value0.setSelected(Port_RB.getPort_RB(0));

		// table_Panel_Fileregister_SFR_GPR
		for (int i = 0; i < 32; i++) {			
			for (int j = 0; j < 8; j++) {
				int value = 0;
				if(i*8+j > 127)
				{
					StatusReg.setRP0(1);
					value = RAM.getRam((i*8) + j - 128);
				}
				else{
					StatusReg.setRP0(0);
					value = RAM.getRam((i*8) + j);
				}
				if (value == -1) {
					table_Panel_Fileregister_SFR_GPR.setValueAt("x", i, j+1);
				} else {
					table_Panel_Fileregister_SFR_GPR.setValueAt(value, i, j+1);

				}
			}

		}
		StatusReg.setRP0(0);
	}
}
