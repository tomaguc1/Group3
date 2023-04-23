import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JLabel on JButton Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        int rows = 3;
        int cols = 3;

        JPanel panel = new JPanel(new GridLayout(rows, cols));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JPanel buttonLabelPanel = createButtonWithLabel("Button " + i + "," + j, "Label " + i + "," + j);
                panel.add(buttonLabelPanel);
            }
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JPanel createButtonWithLabel(String buttonText, String labelText) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                JButton button = new JButton(buttonText);
                button.setSize(getSize());
                button.paint(g);
                JLabel label = new JLabel(labelText, SwingConstants.CENTER);
                label.setSize(getSize());
                label.paint(g);
            }
        };
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setOpaque(false);

        return panel;
    }
}