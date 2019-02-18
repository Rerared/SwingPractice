package swing.view;

import swing.EventManager;
import swing.Listener;

import javax.swing.*;
import java.awt.*;

public class HistoryPanel extends JPanel implements Listener {
    private EventManager eventManager;
    private JList<String> history;
    private DefaultListModel listModel;

    public HistoryPanel() {
        eventManager = EventManager.getInstance();
        listModel = new DefaultListModel();
        history = new JList<>(listModel);
        eventManager.subscribe(this);

        add(new JScrollPane(history));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        listModel.addElement("231");
//        add(history);
    }

    @Override
    public void update(String result) {
        listModel.addElement(result);
    }

    @Override
    public void update(String input1, String input2, String comboBox) {

    }
}
