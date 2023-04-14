package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;

    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;


    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    private JButton vypocitatButton;

    private JSpinner husySpinner;
    private JSpinner kraliciSpinner;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání
        /*husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
       kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        add(kraliciLabel);
        add(kraliciField);*/

        husySpinner = new JSpinner( new SpinnerNumberModel(0,0,1000,1));
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        add(husyLabel);
        add(husySpinner);


        kraliciSpinner = new JSpinner ( new SpinnerNumberModel(0,0,1000,1));
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        add(kraliciLabel);
        add(kraliciSpinner);

        vypocitatButton=new JButton("Vypočítej");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"right,span");


        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        add(pocetHlavLabel);
        add(pocetHlavField);
       pocetHlavField.setEditable(false);
           isEnabled();

           pocetHlavField.setText(vypocetHlav());

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        add(pocetNohouLabel);
        add(pocetNohouField);
        pocetNohouField.setEditable(false);
        pocetNohouField.setText(vypocetNoh());

        pack();
        vypocitatButton.addActionListener(this::vypocetHlav);
        vypocitatButton.addActionListener(this::vypocetNoh);
    }


    public JTextField getHusyField() {
        return husyField;
    }

    public void setHusyField(JTextField husyField) {
        this.husyField = husyField;
    }

    public JTextField getKraliciField() {
        return kraliciField;
    }

    public void setKraliciField(JTextField kraliciField) {
        this.kraliciField = kraliciField;
    }


    private void vypocetHlav(ActionEvent ActionEvent) {
        int husy = (int) husySpinner.getValue();
        int kralici = (int) kraliciSpinner.getValue();

        int vypocetHlav = husy + kralici;
        System.out.println(vypocetHlav);
    }

        private void vypocetNoh(ActionEvent ActionEvent) {
            int husy = (int) husySpinner.getValue();
            int kralici= (int) kraliciSpinner.getValue();
        int vypocetNohHus = husy * 2;

        int vypocetNohKraliku = kralici * 4;

        int vypocetNoh = vypocetNohHus + vypocetNohKraliku;
        System.out.println (vypocetNoh);
    }
}
