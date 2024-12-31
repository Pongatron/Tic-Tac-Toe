package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener, ActionListener {

    JPanel panel;
    JLabel label1, label2, label3,
            label4, label5, label6,
            label7, label8, label9;

    public MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3,10,10));
        panel.setBackground(Color.black);

        createGridLabels();

        label1.addMouseListener(this);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        left.setBackground(Color.lightGray);
        right.setBackground(Color.lightGray);
        top.setBackground(Color.lightGray);
        bottom.setBackground(Color.lightGray);

        left.setPreferredSize(new Dimension(100,100));
        right.setPreferredSize(new Dimension(100,100));
        top.setPreferredSize(new Dimension(100,100));
        bottom.setPreferredSize(new Dimension(100,100));



        this.add(panel, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);



        //this.pack();
        this.setVisible(true);
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == label1){
            label1.setBackground(Color.gray);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == label1){
            label1.setBackground(Color.white);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void createGridLabels(){

        label1 = new JLabel();
        label1.setBackground(Color.white);
        label1.setOpaque(true);

        label2 = new JLabel();
        label2.setBackground(Color.white);
        label2.setOpaque(true);

        label3 = new JLabel();
        label3.setBackground(Color.white);
        label3.setOpaque(true);

        label4 = new JLabel();
        label4.setBackground(Color.white);
        label4.setOpaque(true);

        label5 = new JLabel();
        label5.setBackground(Color.white);
        label5.setOpaque(true);

        label6 = new JLabel();
        label6.setBackground(Color.white);
        label6.setOpaque(true);

        label7 = new JLabel();
        label7.setBackground(Color.white);
        label7.setOpaque(true);

        label8 = new JLabel();
        label8.setBackground(Color.white);
        label8.setOpaque(true);

        label9 = new JLabel();
        label9.setBackground(Color.white);
        label9.setOpaque(true);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);

    }
}
