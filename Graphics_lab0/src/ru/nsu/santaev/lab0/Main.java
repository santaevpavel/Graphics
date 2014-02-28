package ru.nsu.santaev.lab0;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static final String MAIN_FRAME_TITLE = "Лабороторная работа #0";

	public static void main(String[] args) {
		final ArrayList<Point> figure = new ArrayList<Point>();
		final MainFrame mainFrame = new MainFrame(MAIN_FRAME_TITLE);
		mainFrame.setVisible(true);

		ImageIcon iconNew = new ImageIcon("res/images/draw_square.png");

		Action actionDrawSquare = new AbstractAction("New", iconNew) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				figure.clear();
				for (int i = 0; i < 100; i++) {
					figure.add(new Point(i + 100, 100));
					figure.add(new Point(100, i + 100));
					figure.add(new Point(i + 100, 200));
					figure.add(new Point(200, i + 100));
				}
				
				mainFrame.setFigure(figure);
				mainFrame.repaint();
			}
		};
		ImageIcon iconNew2 = new ImageIcon("res/images/draw_triangle.png");

		Action actionDrawTriangle = new AbstractAction("New", iconNew2) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				figure.clear();
				for (int i = 0; i < 100; i++) {
					figure.add(new Point(100 + i, 200));
					figure.add(new Point(200, 100 + i));
					figure.add(new Point(100 + i, 200 - i));
				}
				
				mainFrame.setFigure(figure);
				mainFrame.repaint();
			}
		};
		ImageIcon iconNew3 = new ImageIcon("res/images/draw_circle.png");

		Action actionDrawCircle = new AbstractAction("New", iconNew3) {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				figure.clear();
				int radius = 50;
				int x = 150;
				int y = 150;
				for (int i = 100; i < 400; i++) {
					for (int j = 100; j < 400; j++) {
						if ((x - i) * (x - i) + (y - j) * (y - j) <= radius * radius){
							figure.add(new Point(i, j));
						}
					}
				}
				mainFrame.setFigure(figure);
				mainFrame.repaint();
			}
		};
		
		
		mainFrame.addButtonToToolbar(actionDrawSquare);
		mainFrame.addButtonToToolbar(actionDrawTriangle);
		mainFrame.addButtonToToolbar(actionDrawCircle);
		
	}

}
