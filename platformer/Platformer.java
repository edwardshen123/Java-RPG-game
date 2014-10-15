import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.lang.Thread;

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
        	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int update = 0;
	int frame = 0;
	while (running) {
	    long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
	    while (delta >= 1) {
		tick();
		update++;
		delta--;
	    }
	    render();
	    frame++;
	    
	    if (System.currentTimeMillis() - timer > 1000) {
		timer += 1000;
		System.out.println("FPS: " + frame + " | TICKS: " + update);
		frame = 0;
		update = 0;
	    }
	}
    }

    private void tick() {
    }
    
    private void render() {
	BufferStrategy bs = getBufferStrategy();
	if (bs == null) {
	    createBufferStrategy(3);
	    return;
	}

	Graphics g = bs.getDrawGraphics();
	//////////////////////////////////
	//Game Graphics
	g.setColor(Color.black);
	g.fillRect(0, 0, getWidth(), getHeight());
	

	//////////////////////////////////	
	g.dispose();
	bs.show();
    }

    public static void main(String[] args) {
	new Window(800, 600, "Platformer 0.1", new Platformer());
    }
}
