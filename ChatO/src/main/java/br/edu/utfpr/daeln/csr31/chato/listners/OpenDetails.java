package br.edu.utfpr.daeln.csr31.chato.listners;

import br.edu.utfpr.daeln.csr31.chato.DetailsView;
import br.edu.utfpr.daeln.csr31.chato.beans.Message;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author rapha
 */
public class OpenDetails implements MouseListener {

    private final Message message;

    /**
     *
     * @param message
     */
    public OpenDetails(Message message) {
        this.message = message;
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2 && me.getButton() == 1) {
            DetailsView details = new DetailsView(message);
            details.setVisible(true);
            details.setTitle("Message Details");
        }
    }

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {

    }
}
