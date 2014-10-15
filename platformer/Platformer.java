import java.awt.Canvas;

public class Platformer extends Canvas implements Runnable{

    private static final long serialVersionUID = -6261436164361361187L;
    
    private boolean running = false;
    private Thread thread;

    public synchronized void start() {
	if (running) {
	    return;
	}
	
	running = true;
	thread = new Thread(this);
	thread.start();
    }

    //Thread
    public void run() {
    }

    public static void main(String[] args) {
	new Window(800, 600, "Platformer 0.1", new Platformer());
    }
}
