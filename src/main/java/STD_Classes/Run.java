package STD_Classes;
import GUI_Frontend.AlliedGrid;

import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import GUI_Frontend.BoardGUI;
public class Run {

	public static void main(String[] args) {
		
		Board b = new Board();
		new BoardGUI();
		b.printBoard();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter X:");
		int x=s.nextInt();
		System.out.println("Enter Y:");
		int y=s.nextInt();
		
		Position position = new Position(y,x);
		b.move(position);
		b.printBoard();
		
		
		
		
		
		
		
		
		//b.printBoard();
		/*
		int x = 0;
		int y= 5;
		Position position = new Position(x,y);
		b.move(position);
		b.printBoard();
		*/
		
	}
}
