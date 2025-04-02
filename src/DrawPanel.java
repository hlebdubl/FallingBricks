import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid;
    private int count = 0;
    private int[][] brickLayout;

    public DrawPanel() {
        this.addMouseListener(this);
    }

    BrickLayout b = new BrickLayout("src/bricks", 40, false);

    protected void paintComponent(Graphics g) {
        brickLayout = b.getBrickLayout();

        super.paintComponent(g);

        int x = 10;
        int y = 10;

        Graphics2D g2 = (Graphics2D)g;


        for (int c = 0; c < 40; c++) {
            for (int r = 0; r < 30; r++) {
                g.drawRect(x, y, 20, 20);

                if (brickLayout[r][c] == 1) {
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


    public void mouseClicked(MouseEvent e) {
        if(count == 0){
            b.doOneBrick(0);
            count++;
        }
       else{
            b.doOneBrick(1);
        }
        System.out.println(b.getCurrentHeight());
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