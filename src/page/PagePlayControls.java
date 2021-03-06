package page;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import widgets.InputField;
import widgets.NumberInputField;
import utils.console;


class PagePlayControls extends JPanel {

    protected JButton playButton;
    protected NumberInputField playStartField;
    protected JToggleButton loopButton;
    protected NumberInputField loopStartField;
    protected NumberInputField loopStopField;
    protected NumberInputField BPMField;
    public JTextField infoField;

    private Icon playIcon = new ImageIcon("assets/media-playback-start.png");
    private Icon stopIcon = new ImageIcon("assets/media-playback-stop.png");
    private Icon loopIcon = new ImageIcon("assets/media-playlist-repeat2.png");

    public PagePlayControls(Page pageController) {

        Dimension playControlButtonSize = new Dimension(40, 28);
        Dimension numberFieldSize = new Dimension(50, 30);

        playButton = new JButton(playIcon);
        playButton.setPreferredSize(playControlButtonSize);
        playButton.setMaximumSize(playControlButtonSize);
        playButton.setFocusPainted(false);

        playButton.addActionListener((ActionEvent ae) -> {
            pageController.handlePlayControls(Constants.BUTTON_PLAY);
        });
        add(playButton);

        playStartField = new NumberInputField(1);
        playStartField.setMinimum(1);
        playStartField.setPreferredSize(numberFieldSize);
        playStartField.setMaximumSize(numberFieldSize);
        playStartField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pageController.handlePlayControls(Constants.FIELD_PLAYSTART);
            }
        });
        add(playStartField);

        loopButton = new JToggleButton(loopIcon);
        loopButton.setPreferredSize(playControlButtonSize);
        loopButton.setMaximumSize(playControlButtonSize);
        loopButton.setFocusPainted(false);

        loopButton.addActionListener((ActionEvent ae) -> {
            pageController.handlePlayControls(Constants.BUTTON_LOOP);
        });
        add(loopButton);

        loopStartField = new NumberInputField(1);
        loopStartField.setPreferredSize(numberFieldSize);
        loopStartField.setMaximumSize(numberFieldSize);
        loopStartField.setMinimum(1);
        loopStartField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pageController.handlePlayControls(Constants.FIELD_LOOPSTART);
            }
        });
        add(loopStartField);

        JLabel label = new JLabel(" - ");
        add(label);

        loopStopField = new NumberInputField(2);
        loopStopField.setPreferredSize(numberFieldSize);
        loopStopField.setMaximumSize(numberFieldSize);
        loopStopField.setMinimum(1);
        loopStopField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pageController.handlePlayControls(Constants.FIELD_LOOPSTOP);
            }
        });
        add(loopStopField);

        add(Box.createHorizontalGlue());

        JLabel BPMlabel = new JLabel(" BPM ");
        //BPMlabel.setFocusable(true);
        add(BPMlabel);

        BPMField = new NumberInputField(120);
        BPMField.setPreferredSize(numberFieldSize);
        BPMField.setMaximumSize(numberFieldSize);
        BPMField.setMinimum(1);
        BPMField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pageController.handlePlayControls(Constants.FIELD_BPM);
            }
        });
        add(BPMField);

        add(Box.createHorizontalStrut(15));
        JLabel infoLabel = new JLabel(" INFO ");
        //BPMlabel.setFocusable(true);
        add(infoLabel);
        infoField = new InputField();
        infoField.setPreferredSize(new Dimension(350, 30));
        infoField.setMaximumSize(new Dimension(350, 30));
        infoField.setText("info");

        add(infoField);
    }

    protected void showPlaying() {
        playButton.setIcon(stopIcon);
    }

    protected void showStopped() {
        playButton.setIcon(playIcon);
    }


}