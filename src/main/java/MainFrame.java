import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CircleDrawingPanel drawingPanel;

    public MainFrame() {
        // Configurar el marc principal
        setTitle("Exercici 2: Dibuixar cercles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el panell principal amb BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear i afegir el panell personalitzat per dibuixar cercles
        drawingPanel = new CircleDrawingPanel();
        mainPanel.add(drawingPanel, BorderLayout.CENTER);

        // Crear el botó per esborrar cercles
        JButton clearButton = new JButton("Esborrar tots els cercles");
        clearButton.addActionListener(e -> {
            // Esborrar cercles quan es fa clic al botó
            drawingPanel.clearCircles();
        });

        // Afegir el botó a un panell separat i col·locar-lo a la part inferior
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Afegir el panell principal al marc
        add(mainPanel);

        // Ajustar la mida del marc i centrar-lo a la pantalla
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
