package edu.escuelaing.arsw.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import edu.escuelaing.arsw.model.OperationMemory;

@Controller
public class MathOperationsController {
    @Autowired
    private OperationMemory memory;

    @GetMapping("/")
    public String showCalculator(Model model) {
        model.addAttribute("currentValue", memory.getValue());
        return "calculator_view";
    }

    @PostMapping("/perform")
    public String performOperation(@RequestParam(name = "input", defaultValue = "0") String input, 
                                   @RequestParam(name = "operation") String operation, 
                                   Model model) {
        double inputValue = parseInput(input);
        double result = executeOperation(operation, inputValue);
        
        updateModelAttributes(model, input, result);
        return "calculator_view";
    }

    @PostMapping("/reset")
    public String resetMemory(Model model) {
        memory.clear();
        model.addAttribute("currentValue", 0);
        return "calculator_view";
    }

    private double parseInput(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double executeOperation(String operation, double input) {
        switch (operation) {
            case "add": return memory.getValue() + input;
            case "subtract": return memory.getValue() - input;
            case "multiply": return memory.getValue() * input;
            case "divide": return input != 0 ? memory.getValue() / input : memory.getValue();
            default: return memory.getValue();
        }
    }

    private void updateModelAttributes(Model model, String input, double result) {
        model.addAttribute("inputValue", input);
        model.addAttribute("currentValue", result);
        memory.setValue(result);
    }
}