import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class MyFrame extends JFrame implements ActionListener {

    int x = 2;
    public int getX(){
        return this.x;
    }

    JButton button;

    String final1 = "";
    String final2 = "";
    String final3[] = {"", "", "", ""};

    String final4;

    ArrayList<JCheckBox> checkboxes;
    
    String scripts[] = {"update apoc_parameters_values set param_value = 1 where param_id is null and (object_id = 999 or  object_id = 11 or  object_id = 35);",
            "update apoc_parameters_values set param_value = 1 where param_id is null and (object_id = 999 or  object_id = 6);",
            "update apoc_parameters_values set param_value = 1 where param_id is null and (object_id = 999 or  object_id = 23 or  object_id = 24 or  object_id = 28);",
            "update apoc_parameters_values set param_value = 1 where param_id is null and (object_id = 999 or  object_id = 112 or  object_id = 109 or  object_id = 110 or  object_id = 111);",
    };


    MyFrame() throws ParseException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(7, 1, 50, 15));

        button = new JButton("Сломать БД");
        button.addActionListener(this);

        JLabel label1 = new JLabel("Выберите модули");

        checkboxes = new ArrayList<JCheckBox>();
        String names[] = {"Амбулаторная карма","План влечения", "Страхи в ванне", "Лаботомия"};
        for (int i = 0; i < names.length; i++) {
            JCheckBox checkbox = new JCheckBox(names[i]);
            checkboxes.add(checkbox);
            this.add(checkbox);//for further use you add it to the list
        }

        this.add(button);
        this.setSize(700, 700);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        {
            if (e.getSource() == button) {
                for (int z = 0; z < checkboxes.size(); z++) {
                    if (checkboxes.get(z).isSelected()) {
                        this.final3[z] = final1.concat(scripts[z]);
                        this.x = 0;
                        System.out.println(final3[z].toString());
                    }
                }
                StringJoiner joiner = new StringJoiner("");
                for(int i = 0; i < final3.length; i++) {
                    joiner.add(final3[i]);
                }
                this.final4 = joiner.toString();


            }


        }
    }

}



