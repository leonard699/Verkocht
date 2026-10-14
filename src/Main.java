import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(1280, 720);
        window.setVisible(true);
        window.setFocusable(true);
        window.setDefaultCloseOperation(3);
        window.setLocationRelativeTo(null);
        window.setAlwaysOnTop(true);
        window.setResizable(false);
    }
}