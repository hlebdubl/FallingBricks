import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener {

    private int count = 0;
    private int[][] brickLayout;
    private BrickLayout b;
    private ArrayList<Brick> bricks;
    private ArrayList<Brick> fallingBricks = new ArrayList<Brick>();
    private long startTime = System.currentTimeMillis();
    private int[][] fallLayout = new int[30][40];


    public DrawPanel() {
        this.addMouseListener(this);
        this.b = new BrickLayout("src/bricks", 40, true);
        brickLayout = b.getBrickLayout();
        this.bricks = b.getBackUp();
    }


    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int x = 10;
        int y = 10;

        Graphics2D g2 = (Graphics2D)g;

        int count = 0;
        while(count != bricks.size()){


                if(count != bricks.size()){
                    fallingBricks.add(bricks.get(count));
                    Brick current = bricks.get(count);

                    int start = current.getStart();
                    int end = current.getEnd();

                    for(int i = start; i <= end; i ++ ){
                        fallLayout[current.getFall()][i] = 1;
                    }
                }

                for(int i = 0; i < fallingBricks.size(); i ++){
                    if(fallingBricks.get(i).getFall() != fallingBricks.get(i).getHeight()){
                        fallingBricks.get(i).setFall(fallingBricks.get(i).getFall() + 1);
                    }
                }

                count ++;

                for (int c = 0; c < 40; c++) {
                    for (int r = 0; r < 30; r++) {
                        g.drawRect(x, y, 20, 20);

                        if (fallLayout[r][c] == 1) {
                            g2.setColor(Color.RED);
                            g2.fillRect(x, y, 20, 20);
                            g2.setColor(Color.BLACK);
                        }

                        y += 25;
                    }
                    x += 25;
                    y = 10;
                }
            }
    }


    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}