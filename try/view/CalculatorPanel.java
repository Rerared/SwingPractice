package swing.view;

import swing.EventManager;
import swing.Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel implements Listener  {
    EventManager eventManager;
    JTextField input1;
    JTextField input2;
    JTextField result;
    JButton btn;
    JComboBox<String> comboBox;

    public CalculatorPanel() {
        eventManager = EventManager.getInstance();
        String[] actions = new String[]{"+", "-", "*", "/"};

        input1 = new JTextField(10);
        input2 = new JTextField(10);
        result = new JTextField(10);
        btn = new JButton("Calculate");
        comboBox = new JComboBox<>(actions);

        add(input1);
        add(comboBox);
        add(input2);
        add(btn);
        add(result);

        eventManager.subscribe(this);

        btn.addActionListener(new ButtonClickL());
    }

    @Override
    public void update(String resultStr) {
        result.setText(resultStr);
    }

    @Override
    public void update(String input1, String input2, String comboBox) {

    }


    class ButtonClickL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            eventManager.setInput(input1.getText(),input2.getText(),(String)comboBox.getSelectedItem());
        }
    }
}
