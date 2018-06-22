
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;

public class ClientGUI extends JFrame {


    ClientGUI(){
        super("ClientGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(null);

        panel.setBounds(0, 0, 1000, 1000);
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Container container = this.getContentPane();
        WorkJSON workJSON = new WorkJSON();

        System.out.println(Client.set.copyOnWriteArraySet.size());

        // ******************************************************
        JButton xline = new JButton();
        JButton yline = new JButton();
        yline.setBounds(0, 500, 1000, 1);
        xline.setBounds(500, 0, 1, 1000);
        panel.add(xline);
        panel.add(yline);
        for (Policeman policemen : Client.set.copyOnWriteArraySet){
            System.out.println(WorkJSON.toJSON(policemen));
            MyButton button = new MyButton();
            button.setAge(policemen.getAge());
            button.setName(policemen.getName());
            int x = 500 + policemen.getX1()+policemen.getHeight();
            int y = 500 - policemen.getY1();
            int w = policemen.getWidth();
            int h = policemen.getHeight();
            Colours colour = Colours.valueOf(policemen.getColour().toUpperCase());
            Rectangle bounds = new Rectangle(x, y, w, h);
            button.setBounds(bounds);
            button.setToolTipText("Name: "+ policemen.getName() + ", Age: " + policemen.getAge());
            switch(colour){
                case BLUE:
                    button.setBackground(Color.BLUE);
                    break;
                case GREEN:
                    button.setBackground(Color.GREEN);
                    break;
                case YELLOW:
                    button.setBackground(Color.YELLOW);
                    break;
                default:
                    button.setBackground(Color.WHITE);
                    break;
            }
            panel.add(button);
        }
        // *********************************************************


        JCheckBox greenBox = new JCheckBox("Green");
        JCheckBox yellowBox = new JCheckBox("Yellow");
        JCheckBox blueBox = new JCheckBox("Blue");

        GridLayout layout = new GridLayout(1, 3, 5, 12);
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(layout);
        boxPanel.add(greenBox);
        boxPanel.add(yellowBox);
        boxPanel.add(blueBox);
        filterPanel.add(boxPanel);


        JSlider ageSlider = new JSlider(0, 100, 0);
        JPanel sliderPanel = new JPanel();

        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);
        ageSlider.setMajorTickSpacing(20);
        ageSlider.setMinorTickSpacing(5);


        sliderPanel.add(ageSlider);
        sliderPanel.add(new JLabel("Age"));
        filterPanel.add(sliderPanel);

        TextField name = new TextField(10);
        JPanel namePanel = new JPanel();
        namePanel.add(name);
        namePanel.add(new JLabel("Name"));
        filterPanel.add(namePanel);


        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> {


                    Arrays.stream(panel.getComponents()).forEach(
                            e1 -> {
                                if (e1.getClass() == MyButton.class) {
                                    MyButton button = (MyButton) e1;
                                    if (greenBox.isSelected() && !blueBox.isSelected() && !yellowBox.isSelected()) {
                                        if(e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255){
                                            if (button.getName().equals(name.getText()) && (button.getAge() == ageSlider.getValue())
                                                || (name.getText().equals("") && ageSlider.getValue() == 0)
                                                || (button.getName().equals(name.getText()) && ageSlider.getValue() == 0)
                                                || (name.getText().equals("") && button.getAge() == ageSlider.getValue())){

                                        new Thread(() -> {
                                            for (int i = 0; i < 255; i++) {
                                                e1.setBackground(new Color(i, 255 - i, 0));
                                                try {
                                                    Thread.sleep(10);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            for (int i = 0; i < 255; i++) {
                                                e1.setBackground(new Color(255 - i, i, 0));
                                                try {
                                                    Thread.sleep(15);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                        }).start();
                                    }}
                                    } else if (blueBox.isSelected() && !greenBox.isSelected() && !yellowBox.isSelected()) {
                                        if(e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 255 && e1.getBackground().getGreen() == 0){
                                            if (button.getName().equals(name.getText()) && (button.getAge() == ageSlider.getValue())
                                                    || (name.getText().equals("") && ageSlider.getValue() == 0)
                                                    || (button.getName().equals(name.getText()) && ageSlider.getValue() == 0)
                                                    || (name.getText().equals("") && button.getAge() == ageSlider.getValue())) {
                                                new Thread(() -> {
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(i, 0, 255 - i));
                                                        try {
                                                            Thread.sleep(10);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(255 - i, 0, i));
                                                        try {
                                                            Thread.sleep(15);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                }).start();
                                            }}}
                                            else if (yellowBox.isSelected() && !greenBox.isSelected() && !blueBox.isSelected()){
                                        if(e1.getBackground().getRed() == 255 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255){
                                        if (button.getName().equals(name.getText()) && (button.getAge() == ageSlider.getValue())
                                                || (name.getText().equals("") && ageSlider.getValue() == 0)
                                                || (button.getName().equals(name.getText()) && ageSlider.getValue() == 0)
                                                || (name.getText().equals("") && button.getAge() == ageSlider.getValue())) {
                                            new Thread(() -> {
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(255, 255 - i, 0));
                                                    try {
                                                        Thread.sleep(10);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(255, i, 0));
                                                    try {
                                                        Thread.sleep(15);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            }).start();

                                        }}}
                                        else if((button.getName().equals(name.getText()) && button.getAge() == ageSlider.getValue()) || (name.getText().equals("") && button.getAge() == ageSlider.getValue() )
                                    || (button.getName().equals(name.getText()) && ageSlider.getValue() == 0)){
                                        new Thread(() -> {
                                            int red = e1.getBackground().getRed();
                                            int redbilo = red;
                                            int green = e1.getBackground().getGreen();
                                            int greenbilo = green;
                                            int blue = e1.getBackground().getBlue();
                                            int bluebilo = blue;

                                            while (red<255){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                red++;
                                            }
                                            while (green>0){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                green--;
                                            }
                                            while (blue>0){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                blue--;
                                            }
                                            try {
                                                Thread.sleep(10);
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                            }
                                            while (blue<bluebilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                blue++;
                                            }
                                            while (green<greenbilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                green++;
                                            }

                                            while (red>redbilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                red--;
                                            }


                                        }).start();

                                    }else if(yellowBox.isSelected() && greenBox.isSelected() && !blueBox.isSelected()){
                                        if(e1.getBackground().getRed() == 255 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255){
                                            new Thread(() -> {
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(255, 255 - i, 0));
                                                    try {
                                                        Thread.sleep(10);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(255, i, 0));
                                                    try {
                                                        Thread.sleep(15);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            }).start();
                                        }else if(e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255){
                                            new Thread(() -> {
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(i, 255 - i, 0));
                                                    try {
                                                        Thread.sleep(10);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                                for (int i = 0; i < 255; i++) {
                                                    e1.setBackground(new Color(255 - i, i, 0));
                                                    try {
                                                        Thread.sleep(15);
                                                    } catch (InterruptedException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            }).start();}
                                        }else if(yellowBox.isSelected() && !greenBox.isSelected() && blueBox.isSelected()){
                                            if(e1.getBackground().getRed() == 255 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255){
                                                new Thread(() -> {
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(255, 255 - i, 0));
                                                        try {
                                                            Thread.sleep(10);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(255, i, 0));
                                                        try {
                                                            Thread.sleep(15);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                }).start();
                                            }else if(e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 255 && e1.getBackground().getGreen() == 0) {
                                                new Thread(() -> {
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(i, 0, 255 - i));
                                                        try {
                                                            Thread.sleep(10);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                    for (int i = 0; i < 255; i++) {
                                                        e1.setBackground(new Color(255 - i, 0, i));
                                                        try {
                                                            Thread.sleep(15);
                                                        } catch (InterruptedException e2) {
                                                            e2.printStackTrace();
                                                        }
                                                    }
                                                }).start();
                                            }
                                    }else if(!yellowBox.isSelected() && greenBox.isSelected() && blueBox.isSelected()) {
                                                if (e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 0 && e1.getBackground().getGreen() == 255) {
                                                    new Thread(() -> {
                                                        for (int i = 0; i < 255; i++) {
                                                            e1.setBackground(new Color(i, 255 - i, 0));
                                                            try {
                                                                Thread.sleep(10);
                                                            } catch (InterruptedException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                        for (int i = 0; i < 255; i++) {
                                                            e1.setBackground(new Color(255 - i, i, 0));
                                                            try {
                                                                Thread.sleep(15);
                                                            } catch (InterruptedException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                    }).start();
                                                } else if (e1.getBackground().getRed() == 0 && e1.getBackground().getBlue() == 255 && e1.getBackground().getGreen() == 0) {
                                                    new Thread(() -> {
                                                        for (int i = 0; i < 255; i++) {
                                                            e1.setBackground(new Color(i, 0, 255 - i));
                                                            try {
                                                                Thread.sleep(10);
                                                            } catch (InterruptedException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                        for (int i = 0; i < 255; i++) {
                                                            e1.setBackground(new Color(255 - i, 0, i));
                                                            try {
                                                                Thread.sleep(15);
                                                            } catch (InterruptedException e2) {
                                                                e2.printStackTrace();
                                                            }
                                                        }
                                                    }).start();
                                                }

                                            }else if(yellowBox.isSelected() && greenBox.isSelected() && blueBox.isSelected()){
                                        new Thread(() -> {
                                            int red = e1.getBackground().getRed();
                                            int redbilo = red;
                                            int green = e1.getBackground().getGreen();
                                            int greenbilo = green;
                                            int blue = e1.getBackground().getBlue();
                                            int bluebilo = blue;

                                            while (red<255){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                red++;
                                            }
                                            while (green>0){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                green--;
                                            }
                                            while (blue>0){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(5);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                blue--;
                                            }
                                            try {
                                                Thread.sleep(10);
                                            } catch (InterruptedException e2) {
                                                e2.printStackTrace();
                                            }
                                            while (blue<bluebilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                blue++;
                                            }
                                            while (green<greenbilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                green++;
                                            }

                                            while (red>redbilo){
                                                e1.setBackground(new Color(red, green, blue));
                                                try {
                                                    Thread.sleep(7);
                                                } catch (InterruptedException e2) {
                                                    e2.printStackTrace();
                                                }
                                                red--;
                                            }


                                        }).start();
                                    }
                                }

                            });
                });


        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.getClient().receiveCollection();
                panel.removeAll();
                panel.add(xline);
                panel.add(yline);
                for (Policeman policemen : Client.set.copyOnWriteArraySet){
                    System.out.println(WorkJSON.toJSON(policemen));
                    MyButton button = new MyButton();
                    button.setAge(policemen.getAge());
                    button.setName(policemen.getName());
                    int x = 500 + policemen.getX1()+policemen.getHeight();
                    int y = 500 - policemen.getY1();
                    int w = policemen.getWidth();
                    int h = policemen.getHeight();
                    Colours colour = Colours.valueOf(policemen.getColour().toUpperCase());
                    Rectangle bounds = new Rectangle(x, y, w, h);
                    button.setBounds(bounds);
                    button.setToolTipText("Name: "+ policemen.getName() + ", Age: " + policemen.getAge());
                    switch(colour){
                        case BLUE:
                            button.setBackground(Color.BLUE);
                            break;
                        case GREEN:
                            button.setBackground(Color.GREEN);
                            break;
                        case YELLOW:
                            button.setBackground(Color.YELLOW);
                            break;
                        default:
                            button.setBackground(Color.WHITE);
                            break;
                    }
                    panel.add(button);
                    panel.repaint();
                    container.repaint();
                }
            }
        });

        filterPanel.add(startButton);
        filterPanel.add(updateButton);
        filterPanel.setBounds(1050, 0, 300, 200);
        setSize(new Dimension(1500, 1500));
        container.add(panel);
        container.add(filterPanel);
        container.setLayout(null);
        setVisible(true);

    }
    }




