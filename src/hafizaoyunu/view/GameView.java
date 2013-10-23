package hafizaoyunu.view;

import hafizaoyunu.view.*;
import hafizaoyunu.controller.GameController;
import hafizaoyunu.model.Cell;
import hafizaoyunu.model.Settings;
import info.clearthought.layout.TableLayout;
import info.clearthought.layout.TableLayoutConstraints;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends JFrame {
    private Timer timer;
    private JPanel gamePanel;
    private JToolBar toolBar;
    private JTextField scoreField;
    private GameController controller = new GameController();
    public static Settings settings=new Settings();

    public GameView() {
        super("Hafizani Zorla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
        initGamePanel();
        initToolBar();
        initButtons();
        controller.start();
        timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DrawButtons();
            }
        });
    }

    private void initButtons() {
        for (int j = 0; j < settings.getColumnCount(); j++) {
            for (int i = 0; i < settings.getRowCount(); i++) {
                putButtonAt(Cell.createEmptyCell(j,i));
            }
        }
    }

    private void initGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setBackground(new Color(204, 255, 105));

        double size[][] =new double[2][Math.max(settings.getColumnCount(), settings.getRowCount())];
        size[0] =new double[settings.getColumnCount()];
        size[1] =new double[settings.getRowCount()];

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < settings.getRowCount(); i++) {
                size[j][i]=TableLayout.FILL;
            }
        }
        
        double size1[][] = {{TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL},
            {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}
        };

        gamePanel.setLayout(new TableLayout(size));

        ((TableLayout) gamePanel.getLayout()).setHGap(5);
        ((TableLayout) gamePanel.getLayout()).setVGap(5);

        gamePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(gamePanel, BorderLayout.CENTER);
    }

    private void initLayout() {
        setLayout(new BorderLayout());
    }

    public void putButtonAt(Cell cell) {
        JButton button = new CellButton(cell,new OpenAction()); 
        gamePanel.add(button, new TableLayoutConstraints(cell.getColumn(),cell.getRow()));
        gamePanel.repaint();
        gamePanel.validate();
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void clean() {
        gamePanel.removeAll();
        gamePanel.repaint();
        gamePanel.validate();
    }

    private void initToolBar() {
        toolBar = new JToolBar();
        toolBar.add(new SettingsAction());
        scoreField =new JTextField();
        toolBar.add(scoreField);
        getContentPane().add(toolBar, BorderLayout.NORTH);
    }

    private void DrawButtons() {
        clean();
        scoreField.setText(controller.getScore()+"");
        Cell[][] cells = controller.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                putButtonAt(cells[j][i]);
            }
        }
        timer.stop();
    }

    class OpenAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {                      
            final CellButton button = (CellButton) e.getSource();            
            char chr = controller.open(button.getColumn(),button.getRow());
            button.setText(String.valueOf(chr));
            
            if(controller.isGameOver()){
                showMessage("Game Over...");
                return;
            }
            
            timer.start();
        }
    }

    class StartAction extends AbstractAction {
        public StartAction() {
            super("Start");
        }

        public void actionPerformed(ActionEvent e) {
            controller.start();
        }
    }
    
    class SettingsAction extends AbstractAction{
        public SettingsAction() {
            super("Settings");
        }
        public void actionPerformed(ActionEvent e) {
            SettingsView settingsView =new SettingsView(GameView.this, enabled);
            settingsView.setVisible(true);
        }
        
    }

    public static void main(String[] args) {
        GameView gameView = new GameView();
        gameView.setSize(800, 600);
        gameView.setVisible(true);
    }
}

