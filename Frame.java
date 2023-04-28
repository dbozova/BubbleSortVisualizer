import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

public class Frame  extends JFrame{
    private static final long serialVersionUID = 1L;

    private SortingPanel panel = new SortingPanel();
    
    public Frame() {
        this.setTitle("Bubble sort");
        this.getContentPane().setPreferredSize(new DimensionUIResource(600, 600));
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public SortingPanel getPanel() {
        return this.panel;
    }
    
}