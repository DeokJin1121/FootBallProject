package fo0tballproject_package;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fo0tballproject_package.MainFrame;

public class LoadingLabel extends JLabel {
	private int barSize;		// 바의 현재 크기
	private int maxBarSize;		// 바의 최대 크기'
	
	public LoadingLabel(int maxBarSize) {
		this.barSize = 0;
		this.maxBarSize = maxBarSize;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(100, 150, 255));		
		int width = (int)((double)getWidth() / maxBarSize * barSize);
		if(width == 0) {
			return;
		}
		g.fillRect(0, 0, width, getHeight());	// 넓이 및 높이만큼 채우는 것
	}
	public synchronized void fill() {			// synchronized => 이 동작을 하는 동안 다른 건 가만히 있도록
		if(barSize == maxBarSize) {				// public => fill() 과 consume() 을 다른 클래스에서도 보이도록 public을 줌
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint();
		notify();			// 다시 실행 [ <-> wait(); ]
	}
}