import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BrickLayout {

    private ArrayList<Brick> bricks;
    private int[][] brickLayout;
    private int cols;
    private int currentHeight = 0;




    public int[][] getBrickLayout() {
        return brickLayout;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    public BrickLayout(String fileName, int cols, boolean dropAllBricks) {
        this.cols = cols;
        ArrayList<String> fileData = getFileData(fileName);
        bricks = new ArrayList<Brick>();
        for (String line : fileData) {
            String[] points = line.split(",");
            int start = Integer.parseInt(points[0]);
            int end = Integer.parseInt(points[1]);
            Brick b = new Brick(start, end);
            bricks.add(b);
        }
        int count = 0;
        brickLayout = new int[bricks.size()][cols];
        if (dropAllBricks) {
            while (bricks.size() != 0) {
                doOneBrick(count);
                count++;
            }
        }
    }

    public void doOneBrick(int count) {
        if (bricks.size() != 0) {
            Brick b = bricks.remove(0);

            int start = b.getStart();
            int end  = b.getEnd();

            if(count == 0){
                for(int i = start; i <= end; i ++){
                    brickLayout[brickLayout.length - 1 - currentHeight][i] = 1;
                }
                currentHeight ++;
            }
            else{
                if(add(start, end)){
                    for(int i = start; i <= end; i ++){
                        brickLayout[brickLayout.length - 1 - currentHeight][i] = 1;
                    }
                    currentHeight ++;
                }
                else{
                    int row = fromZero(start,end);
                    for(int i = start; i <= end; i ++){
                        brickLayout[row][i] = 1;
                    }
                }
            }
        }
    }

    public boolean add(int start, int end){
        for(int i = start; i == end; i ++){
            if(checkBrickSpot(currentHeight, i)){
                return  true;
            }
        }
        return false;
    }

    public int fromZero(int start, int end) {
        int fromZero = brickLayout.length - 1;
        for (int i = start; i <= end; i++) {
            if (brickLayout[fromZero][i] == 1) {
                fromZero--;
                i = start;
            }
        }
        return fromZero;
    }

    public ArrayList<String> getFileData(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }
        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        return fileData;
    }

    public boolean checkBrickSpot(int r, int c) {
        if(brickLayout[r][c] == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}
