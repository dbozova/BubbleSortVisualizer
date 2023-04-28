import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SortingPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;

    private Random random = new Random();
    private int[] array = new int[20];
    private int array_index;
    private int compare_index;

    JButton start = new JButton("Start");
    JButton reset = new JButton("Reset");

    private boolean isRunning;


    public SortingPanel() {
        this.array_index = 0;
        this.compare_index = Integer.MAX_VALUE;
        this.setArray();

        start.setBackground(Color.CYAN);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    isRunning = true;
                    BubbleSortAnimate();
                }catch(Exception exception) {
                    exception.printStackTrace();
                }
            }
            
        });
        reset.setBackground(Color.CYAN);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setArray();
                compare_index = Integer.MAX_VALUE;
                array_index = 0;
                isRunning = false;
                repaint();
            }
            
        });
        this.add(start);
        this.add(reset);
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray() {
        for(int i = 0; i < this.array.length; i++) 
        {
            this.array[i] = random.nextInt(510) + 40;
        }
    }

    public void sortOnlyOneItem() {
        if(array[compare_index] > array[compare_index+1])
        {
            int temp = array[compare_index];
            array[compare_index] = array[compare_index+1];
            array[compare_index+1] = temp;
        }
        if((compare_index+1) >= (array.length - array_index - 1))
        {
            array_index++;
            compare_index = 0;
        }
        else
        compare_index++;
    }

    public boolean isSorted() {
        for(int i = 0; i <array.length - 1; i++)
        {
            if(array[i] > array[i+1])
            {
                return false;
            }
        }
        return true;
    }

    public void BubbleSortAnimate() throws Exception{
       
        compare_index = 0;

        Timer timer = new Timer(200, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               if(isSorted()) 
               {
                   compare_index = Integer.MAX_VALUE;
                   ((Timer)e.getSource()).stop();
               }else
               {
                   if(isRunning == true)
                   sortOnlyOneItem();
               }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        for(int i = 0; i <array.length; i++)
        {
            g.setColor(Color.CYAN);

            if(i == compare_index) // || i == compare_index+1)
            {
                g.setColor(Color.RED);
            }
            else if(i == (compare_index + 1))
            {
                g.setColor(Color.GREEN);
            }

            g.drawRect(i*30, 600 - array[i], 29, array[i]);
            g.fillRect(i*30, 600 - array[i], 29, array[i]);
        }
    }
}
