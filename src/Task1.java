import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task1 extends JFrame {

    private JList leftList;
    private JList rightList;

    private JButton toRightButton;
    private JButton toLeftButton;

    public Task1(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createItems();
        addButtonEvent();
        addItems();
    }

    public void createItems() {
        DefaultListModel leftListModel = new DefaultListModel();
        leftListModel.addElement("aaa");
        leftListModel.addElement("bbb");
        leftListModel.addElement("ccc");
        DefaultListModel rightListModel = new DefaultListModel();
        rightListModel.addElement("ddd");
        rightListModel.addElement("eee");
        rightListModel.addElement("fff");
        leftList = new JList(leftListModel);
        rightList = new JList(rightListModel);
        leftList.setPreferredSize(new Dimension(50, this.getHeight()));
        rightList.setPreferredSize(new Dimension(50, this.getHeight()));

        toRightButton = new JButton(">");
        toLeftButton = new JButton("<");
    }

    public void addItems() {
        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.add(toRightButton, BorderLayout.NORTH);
        centralPanel.add(toLeftButton, BorderLayout.SOUTH);

        add(leftList, BorderLayout.WEST);
        add(centralPanel, BorderLayout.CENTER);
        add(rightList, BorderLayout.EAST);
    }

    public void addButtonEvent() {
        toRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (leftList.isSelectionEmpty())
                    return;

                DefaultListModel leftModel = (DefaultListModel) leftList.getModel();
                DefaultListModel rightModel = (DefaultListModel) rightList.getModel();
                rightModel.addAll(leftList.getSelectedValuesList());
                int[] indexes = leftList.getSelectedIndices();
                for (int i = indexes.length - 1; i >= 0; --i) {
                    leftModel.remove(indexes[i]);
                }
                leftList.setModel(leftModel);
                rightList.setModel(rightModel);
            }
        });
        toLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rightList.isSelectionEmpty())
                    return;

                DefaultListModel leftModel = (DefaultListModel) leftList.getModel();
                DefaultListModel rightModel = (DefaultListModel) rightList.getModel();
                leftModel.addAll(rightList.getSelectedValuesList());
                int[] indexes = rightList.getSelectedIndices();
                for (int i = indexes.length - 1; i >= 0; --i) {
                    rightModel.remove(indexes[i]);
                }
                leftList.setModel(leftModel);
                rightList.setModel(rightModel);
            }
        });
    }
}
