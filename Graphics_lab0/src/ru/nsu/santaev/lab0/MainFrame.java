package ru.nsu.santaev.lab0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static final int MIN_WIDTH = 800;
	public static final int MIN_HEIGHT = 600;

	private static String menuFileTitle = "Ôאיכ";
	private static String subMenuFileTitle = "Íמגûי פאיכ";
	private static String menuHelpTitle = "Ïמלמשü";

	private JToolBar toolBar = null;
	private JPanel drawPanel = null;  
	
	private ArrayList<Point> figure = new ArrayList<Point>();

	public MainFrame(String title) {
		super(title);
		setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI();

	}

	protected void createGUI() {
		createMenu();
		createToolBar();
		drawPanel = new DrawJPanel();
		getContentPane().add(drawPanel);
	}

	protected void createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu(menuFileTitle);
		menuBar.add(fileMenu);
		
		JMenuItem fileMenuSubItem1 = new JMenuItem(subMenuFileTitle);
		fileMenu.add(fileMenuSubItem1);

		JMenu helpMenu = new JMenu(menuHelpTitle);
		menuBar.add(helpMenu);

		setJMenuBar(menuBar);
	}

	protected void createToolBar() {
		toolBar = new JToolBar();

		ImageIcon iconNew = new ImageIcon("res/images/new_file.png");
		ImageIcon iconSave = new ImageIcon("res/images/save_file.png");
		
		Action actionNew = new AbstractAction("New", iconNew) {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Clicked " + "new file");
			}
		};
		Action actionSave = new AbstractAction("Save", iconSave) {
			private static final long serialVersionUID = 1L;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setTitle("Clicked " + "save file");
			}
		};
		
		addButtonToToolbar(actionNew);
		addButtonToToolbar(actionSave);		
		getContentPane().add(toolBar, BorderLayout.NORTH);
	}
	public void addButtonToToolbar(Action action){
		JButton button = new SmallButton(action);
		toolBar.add(button);
	}
	class SmallButton extends JButton {

		private static final long serialVersionUID = 1L;

		public SmallButton(Action act) {
			super((Icon) act.getValue(Action.SMALL_ICON));

			setMargin(new Insets(1, 1, 1, 1));
			addActionListener(act);
			//addMouseListener(act);
		}

		public float getAlignmentY() {
			return 0.5f;
		}

	}
	public JPanel getDrawPanel() {
		return drawPanel;
	}

	public void setDrawPanel(JPanel drawPanel) {
		this.drawPanel = drawPanel;
	}
	

	public ArrayList<Point> getFigure() {
		return figure;
	}

	public void setFigure(ArrayList<Point> figure) {
		this.figure = figure;
	}
	class DrawJPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		public DrawJPanel(){
			setBackground(Color.WHITE);
			System.out.println("OnCreate");
		}
		protected void updateGraphics(Graphics graph){
			int height = getHeight();
			int width = getWidth();
			if (figure == null){
				return;
			}
			for (Point point : figure) {
				//System.out.println("Draw " + point.x + " " + point.y);
				graph.drawLine(point.x, point.y, point.x, point.y);
			}
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//System.out.println("Update");
			updateGraphics(g);
		}
	}

}
