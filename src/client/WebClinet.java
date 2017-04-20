package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static client.SwingServer.GetWeather;

/**
 * Created by rain on 2017/4/19.
 */
public class WebClinet {

    private JComboBox comboBox1;
    private JButton search;
    private JTextField textField1;
    private JPanel WORK;
    private JTextArea textArea1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("WebClinet");
        frame.setContentPane(new WebClinet().WORK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public WebClinet() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.append("\n");
                int selectIndex= comboBox1.getSelectedIndex();
                String str = textField1.getText();
                String[]  results = null;
                switch (selectIndex){
                    case 0:
                        String result = SwingServer.GetPhoneInfo(str);
                        textArea1.append(result);
                        break;
                    case 1:
                        results = SwingServer.GetWeather(str);
                        for(String st : results){
                            textArea1.append(st);
                        }
                        break;
                    case 2:
                        results = SwingServer.GetIpInfo(str);
                        for(String st : results){
                            textArea1.append(st);
                        }
                        break;
                        default:

                }
            }
        });
    }
}
