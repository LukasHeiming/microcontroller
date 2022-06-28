import java.util.concurrent.TimeUnit;

public class UI_Thread extends Thread {
    @Override
	public void run() {
		while (true) {
            System.out.print("");
			while (!Controller_UI.killThread) {
				try {
					Thread.sleep(10);
					//TimeUnit.SECONDS.sleep(0.01);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Controller_UI.do1Command();
			}
		}
	}
}
