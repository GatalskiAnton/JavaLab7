import javax.swing.*;
import java.awt.*;

public class Task3 extends JFrame {
    private JRadioButton leftButton;
    private JRadioButton rightButton;

    private final Icon circleIcon = new ImageIcon("Circle.png");
    private final Icon squareIcon = new ImageIcon("Square.png");
    private final Icon triangleIcon = new ImageIcon("Triangle.png");
    private final Icon pentagonIcon = new ImageIcon("Pentagon.png");
    private final Icon arrowIcon = new ImageIcon("Arrow.png");


    public Task3(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        leftButton = new JRadioButton(circleIcon);

        rightButton = new JRadioButton(circleIcon);

        ButtonGroup group = new ButtonGroup();
        group.add(leftButton);
        group.add(rightButton);

        addIcons();
        addIcons();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    void addIcons() {
        leftButton.setSelectedIcon(squareIcon);
        leftButton.setDisabledIcon(triangleIcon);
        leftButton.setPressedIcon(pentagonIcon);
        leftButton.setRolloverIcon(arrowIcon);

        rightButton.setSelectedIcon(squareIcon);
        rightButton.setDisabledIcon(triangleIcon);
        rightButton.setPressedIcon(pentagonIcon);
        rightButton.setRolloverIcon(arrowIcon);
    }
}
