import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @see http://stackoverflow.com/q/3066590/230513
 * @see http://stackoverflow.com/questions/5274962
 */
public class MVCGame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new MVCGame()::display);
    }

    public void display() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

final class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        Model model = new Model();
        View view = new View(model);
        Control control = new Control(model, view);
        JLabel label = new JLabel("Guess what color!", JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);
        this.add(view, BorderLayout.CENTER);
        this.add(control.createPanel(), BorderLayout.SOUTH);
    }
}

/**
 * Control panel
 */
final class Control {

    private final Model model;
    private final View view;
    private final JButton reset = new JButton("Reset");

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.add(reset);
        reset.addActionListener(new ButtonHandler());
        return panel;
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if ("Reset".equals(cmd)) {
                model.reset();
            }
        }
    }
}

/**
 * View
 */
final class View extends JPanel {

    private static final String PROMPT = "Click a button.";
    private final Model model;
    private final ColorIcon icon = new ColorIcon(80, Color.gray);
    private final JLabel label = new JLabel(PROMPT, icon, JLabel.CENTER);

    public View(Model model) {
        super(new BorderLayout());
        this.model = model;
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);
        this.add(label, BorderLayout.CENTER);
        this.add(genButtonPanel(), BorderLayout.SOUTH);
        model.addObserver(new ModelObserver());
    }

    private JPanel genButtonPanel() {
        JPanel panel = new JPanel();
        for (Piece p : Piece.values()) {
            PieceButton pb = new PieceButton(p);
            pb.addActionListener(new ButtonHandler());
            panel.add(pb);
        }
        return panel;
    }

    private class ModelObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            if (arg == null) {
                label.setText(PROMPT);
                icon.color = Color.gray;
            } else {
                if ((Boolean) arg) {
                    label.setText("Win!");
                } else {
                    label.setText("Keep trying.");
                }
            }
        }
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PieceButton pb = (PieceButton) e.getSource();
            icon.color = pb.piece.color;
            label.repaint();
            model.check(pb.piece);
        }
    }

    private final static class PieceButton extends JButton {

        private Piece piece;

        public PieceButton(Piece piece) {
            this.piece = piece;
            this.setIcon(new ColorIcon(16, piece.color));
        }
    }

    private static class ColorIcon implements Icon {

        private final int size;
        private Color color;

        public ColorIcon(int size, Color color) {
            this.size = size;
            this.color = color;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.fillOval(x, y, size, size);
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }
    }
}

/**
 * Model
 */
class Model extends Observable {

    private static final Random rnd = new Random();
    private static final Piece[] pieces = Piece.values();
    private Piece hidden = init();

    private Piece init() {
        return pieces[rnd.nextInt(pieces.length)];
    }

    public void reset() {
        hidden = init();
        setChanged();
        notifyObservers();
    }

    public void check(Piece guess) {
        setChanged();
        notifyObservers(guess.equals(hidden));
    }
}

enum Piece {

    Red(Color.red), Green(Color.green), Blue(Color.blue);
    public Color color;

    private Piece(Color color) {
        this.color = color;
    }
}