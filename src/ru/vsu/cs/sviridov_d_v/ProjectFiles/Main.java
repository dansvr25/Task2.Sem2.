package ru.vsu.cs.sviridov_d_v.ProjectFiles;

import ru.vsu.cs.sviridov_d_v.Utils.SwingUtils;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }
}