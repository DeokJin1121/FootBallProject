package fotballproject;

import fotballproject.MainFrame;

import javax.swing.JLabel;

import fotballproject.LoadingLabel;

public class FillThread extends Thread{

	private LoadingLabel bar;
	
	public FillThread(LoadingLabel bar) {
		this.bar = bar;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(50);			// run() 은 항상 예외처리
				//bar.consume()		// 0.2초마다 bar을 불러서 consume 실행
				bar.fill();
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
}