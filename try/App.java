package swing;

import swing.view.CalculatorPanel;
import swing.view.HistoryPanel;

import javax.swing.*;

public class App extends JFrame {
    CalculatorPanel calculatorPanel;
    HistoryPanel historyPanel;
    JTabbedPane tabbedPane;

    public App() {
        calculatorPanel = new CalculatorPanel();
        historyPanel = new HistoryPanel();
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Calculator", calculatorPanel);
        tabbedPane.addTab("History", historyPanel);
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
