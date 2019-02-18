package swing.services.Impl;

import swing.services.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public String calculate(String input1, String input2, String comboBox) {
        String result = "";
        switch (comboBox) {
            case "+":
                result = addition(input1, input2);
                break;
            case "-":
                result = subtraction(input1, input2);
                break;
            case "*":
                result = multyplyng(input1, input2);
                break;
            case "/":
                result = division(input1, input2);
                break;
            default:
                System.out.println("wrong input");
        }
        return result;
    }

//    @Override
//    public void update(String result) {
//
//    }
//
//    @Override
//    public void update(String input1, String input2, String comboBox) {
////        eventManager.setResult(calculate(input1, input2, comboBox));
//    }

    private String addition(String input1, String input2) {
        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);
        return Double.toString(d1 + d2);
    }

    private String subtraction(String input1, String input2) {
        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);
        return Double.toString(d1 - d2);
    }

    private String multyplyng(String input1, String input2) {
        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);
        return Double.toString(d1 * d2);
    }

    private String division(String input1, String input2) {
        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);
        return Double.toString(d1 / d2);
    }
}
