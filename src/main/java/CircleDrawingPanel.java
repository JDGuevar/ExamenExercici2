
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircleDrawingPanel extends JPanel {

    private final CircleManager circleManager;

    public CircleDrawingPanel() {
        // Configurar les dimensions i el color de fons del panell
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.WHITE);

        // Crear el gestor de cercles
        circleManager = new CircleManager();

        // TODO: Afegir un MouseListener per gestionar els clics del ratolí i afegir cercles
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO: Afegir un cercle al gestor amb les coordenades del clic
                // circleManager.addCircle(e.getX(), e.getY());
                // TODO: Redibuixar el panell després d'afegir el cercle
                circleManager.addCircle(e.getX(), e.getY());
                repaint(); // Redibuixa el panell per mostrar el nou cercle
            }
        });
        
       

        // TODO: Crear i inicialitzar un Timer per eliminar cercles després de 5 segons
        // Usa el mètode checkAndRemoveExpiredCircles() de CircleManager
        // i redibuixar el panell.
        Timer timer = new Timer(100, e -> {
            circleManager.checkAndRemoveExpiredCircles();
            repaint(); // Redibuixa el panell per reflectir els canvis
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Millorar la qualitat del dibuix (antialiasing)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuixar tots els cercles
        for (TimedCircle circle : circleManager.getCircles()) {
            g2d.setColor(circle.getColor());
            g2d.fillOval(circle.getX() - 15, circle.getY() - 15, 30, 30);
        }
    }
    

    // Esborrar tots els cercles i actualitzar el panell
    public void clearCircles() {
        // Hint: pensa també a redibuixar el panell per reflectir els canvis
        circleManager.clearAllCircles();
        repaint();
    }
}
