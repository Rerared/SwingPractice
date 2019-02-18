package swing;

import swing.services.CalculatorService;
import swing.services.Impl.CalculatorServiceImpl;

import java.util.*;

public class EventManager {
    private CalculatorService calculatorService;
    private static EventManager eventManager = new EventManager();
    private List<Listener> listeners = new ArrayList<>();
    private String input1;
    private String input2;
    private String comboBox;
    private String result;

    private EventManager() {
        calculatorService = new CalculatorServiceImpl();
    }

    public static EventManager getInstance() {
        return eventManager;
    }

    public void subscribe(Listener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(Listener listener) {
        listeners.remove(listener);
    }

    public void notifyAll(String input1, String input2, String comboBox) {
        for (Listener listener : listeners) {
            listener.update(input1,input2,comboBox);
        }
    }

    public void notifyAll(String result) {
        for (Listener listener : listeners) {
            listener.update(result);
        }
    }

    public void setInput(String input1, String input2, String comboBox) {
        this.input1 = input1;
        this.input2 = input2;
        this.comboBox = comboBox;
        setResult(calculatorService.calculate(this.input1,this.input2,this.comboBox));
        notifyAll(this.input1 , this.input2, this.comboBox);
    }

    public String getInput1() {
        return input1;
    }

    public String getInput2() {
        return input2;
    }


    public String getComboBox() {
        return comboBox;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
        notifyAll(this.result);
    }
}
