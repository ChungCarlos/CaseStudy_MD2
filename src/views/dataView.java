package views;

import javax.swing.*;

public class dataView {
    public static void main(String[] args) {
        // Tạo một JFrame
        JFrame frame = new JFrame("MenuBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Tạo một JMenu
        JMenu fileMenu = new JMenu("File");

        // Tạo các JMenuItem cho JMenu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Thêm các JMenuItem vào JMenu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Thêm JMenu vào JMenuBar
        menuBar.add(fileMenu);

        // Đặt JMenuBar vào JFrame
        frame.setJMenuBar(menuBar);

        // Thiết lập kích thước và hiển thị JFrame
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
