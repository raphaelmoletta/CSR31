package br.edu.utfpr.daeln.csr31.chat4dpam5;

import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Range;
import com.orsoncharts.axis.Axis3D;
import com.orsoncharts.axis.NumberAxis3D;
import com.orsoncharts.axis.ValueAxis3D;
import com.orsoncharts.data.Dataset3D;
import com.orsoncharts.data.xyz.XYZSeriesCollection;
import com.orsoncharts.plot.Plot3D;
import com.orsoncharts.plot.XYZPlot;
import com.orsoncharts.renderer.Renderer3D;
import com.orsoncharts.renderer.xyz.BarXYZRenderer;
import com.orsoncharts.renderer.xyz.XYZRenderer;
import java.awt.Toolkit;

/**
 *
 * @author rapha
 */
public class DetailsView extends javax.swing.JFrame {
    /**
     * Creates new form DetailsView
     * @param message
     */
    public DetailsView(Message message) {
        initComponents();
        jTextAreaText.setText(message.getText());
        jTextAreaBinary.setText(message.getBinary());
        jTextAreaEncoded.setText(message.getEncoded());
        jLabelEncoded.setText("Encoded (" + message.getEncoder().toString() + "):");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("logo.png")));
        XYZSeriesCollection dataset = new XYZSeriesCollection();
        XYZRenderer renderer = new BarXYZRenderer();
        ValueAxis3D xAxis = new NumberAxis3D("X", new Range(-2, 2));
        ValueAxis3D yAxis = new NumberAxis3D("Y", new Range(-2, 2));
        ValueAxis3D zAxis = new NumberAxis3D("Z", new Range(-2, 2));
        
        Plot3D plot = new XYZPlot(dataset, renderer, xAxis, yAxis, zAxis);
        Chart3D chart = plot.getChart();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaText = new javax.swing.JTextArea();
        jLabelBinary = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaBinary = new javax.swing.JTextArea();
        jLabelEncoded = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaEncoded = new javax.swing.JTextArea();
        jPanelChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelText.setText("Text:");

        jTextAreaText.setColumns(20);
        jTextAreaText.setRows(5);
        jScrollPane1.setViewportView(jTextAreaText);

        jLabelBinary.setText("Binary:");

        jTextAreaBinary.setColumns(20);
        jTextAreaBinary.setRows(5);
        jScrollPane2.setViewportView(jTextAreaBinary);

        jLabelEncoded.setText("Encoded:");

        jTextAreaEncoded.setColumns(20);
        jTextAreaEncoded.setRows(5);
        jScrollPane3.setViewportView(jTextAreaEncoded);

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBinary, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addComponent(jLabelEncoded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBinary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEncoded)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelEncoded.getAccessibleContext().setAccessibleName("Encoded:");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBinary;
    private javax.swing.JLabel jLabelEncoded;
    private javax.swing.JLabel jLabelText;
    private javax.swing.JPanel jPanelChart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaBinary;
    private javax.swing.JTextArea jTextAreaEncoded;
    private javax.swing.JTextArea jTextAreaText;
    // End of variables declaration//GEN-END:variables
}