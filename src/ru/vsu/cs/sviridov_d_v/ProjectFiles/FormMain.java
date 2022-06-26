package ru.vsu.cs.sviridov_d_v.ProjectFiles;

import ru.vsu.cs.sviridov_d_v.Utils.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormMain extends JFrame {
    private JPanel panelMain;
    private JTable tableFibonacci;
    private JButton buttonFibonacci;
    private JTextArea textNumbers;

    public FormMain() {
        this.setTitle("Таск 2");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableFibonacci, 40, true, true, true, true);
        tableFibonacci.setRowHeight(25);

        buttonFibonacci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line = textNumbers.getText();
                int num = Integer.parseInt(line);
                SimpleLinkedList<Integer> fib = Fibonacci.fibonacci(num);
                int[] fibonacci = new int[fib.size()];
                for (int i = 0; i < fib.size(); i ++) {
                    try {
                        fibonacci[i] = fib.get(i);
                    } catch (SimpleLinkedList.SimpleLinkedListException ex) {
                        ex.printStackTrace();
                    }
                }
                JTableUtils.writeArrayToJTable(tableFibonacci, fibonacci);
            }
        });
    }
}