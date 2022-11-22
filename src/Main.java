import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Task1 window1 = new Task1("Task1");
        Task2 window2 = new Task2("Task2");
        Task3 window3 = new Task3("Task3");

        window1.setSize(new Dimension(500,500));
        window1.setVisible(true);
        window1.setLocationRelativeTo(null);

    }
}
