import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Task2 extends JFrame {
    public Task2(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<JButton> buttons = new ArrayList<>();

        setLayout(new GridLayout(4, 5));
        int row = 4;
        int column = 5;
        for (int i = 0; i < row; ++i)//i - row j - column
        {
            for (int j = 0; j < column; ++j) {
                JButton button = new JButton(j + i * column + 1 + "");
                button.setBackground(Color.WHITE);

                MouseAdapter adapter = new MouseAdapter() {
                    String buttonTitle;
                    @Override
                    public void mousePressed(MouseEvent e) {
                        buttonTitle = button.getText();
                        button.setText("Clicked");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        button.setText(buttonTitle);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button.setBackground(Color.GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setBackground(Color.WHITE);
                    }

                };
                button.addMouseListener(adapter);
                buttons.add(button);
                add(button);
            }
        }


    }
}
