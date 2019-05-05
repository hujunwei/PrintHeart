import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.lang.*;


public class Cardioid extends JFrame {
	private static final int WIDTH=500;
	private static final int HEIGHT=500;
	private static int WINDOW_WIDTH=Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int WINDOW_HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;
    
	private List<Color> initializeColors() {
		List<Color> colors = new ArrayList<>();
		colors.add(Color.RED);
		colors.add(Color.BLACK);
		colors.add(Color.MAGENTA);
		colors.add(Color.BLACK);
		colors.add(Color.PINK);
		colors.add(Color.BLACK);
        return colors;
	};

	private void sleep(int milliseconds) {
		try{
			Thread.sleep(milliseconds);
		}
		catch(Exception e){
			System.exit(0);
		}
	}
    
	public Cardioid(){
		super("To my wife:Tan^_^^_^  Happy 10th Anniverary");    
		this.setBackground(Color.BLACK);
		this.setLocation((WINDOW_WIDTH-WIDTH)/2,(WINDOW_HEIGHT-HEIGHT)/2);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(getLayout());
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}

	public void paint(Graphics g){
		double x,y,r;
		Image image=this.createImage(WIDTH,HEIGHT);
        int cid = 0;
        List<Color> colors = initializeColors();
        while (cid < Integer.MAX_VALUE) {
			Graphics pic=image.getGraphics();		
			for(int i=-2;i<90;i++){
				for(int j=-2;j<90;j++){
					r=Math.PI/45+Math.PI/45*i*(1-Math.sin(Math.PI/45*j))*18;
					x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*i)+WIDTH/2;
					y=-r*Math.sin(Math.PI/45*j)+HEIGHT/3;
					pic.setColor(colors.get(cid % colors.size()));
					pic.fillOval((int)x, (int)y, 2, 2);
					if (colors.get(cid % colors.size()) != Color.BLACK) {
						sleep(1);
					}
				}
				g.drawImage(image, 0, 0, this);
			}
			pic = null;
			cid++;
	    }   
	}

	public static void main(String[] args) {
		new Cardioid();
	}
}



