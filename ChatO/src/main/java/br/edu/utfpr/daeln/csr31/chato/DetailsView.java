package br.edu.utfpr.daeln.csr31.chato;

import br.edu.utfpr.daeln.csr31.chato.beans.Message;
import br.edu.utfpr.daeln.csr31.chato.datas.DataD4Pam5;
import br.edu.utfpr.daeln.csr31.chato.interfaces.Protocol;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author rapha
 */
public class DetailsView extends javax.swing.JFrame {

    private static final long serialVersionUID = -8153929403863946512L;

    /**
     * Creates new form DetailsView
     *
     * @param message
     */
    public DetailsView(Message message) {
        initComponents();
        jTextAreaText.setText(message.getText());
        jTextAreaText.setLineWrap(true);
        jTextAreaText.setWrapStyleWord(true);
        
        jTextAreaBinary.setText(message.getBinary());
        jTextAreaBinary.setLineWrap(true);
        jTextAreaText.setWrapStyleWord(true);
        
        jTextAreaEncoded.setText(message.getEncoded());
        jTextAreaEncoded.setLineWrap(true);
        jTextAreaEncoded.setWrapStyleWord(true);
        
        jLabelEncoded.setText("Encoded (" + message.getEncoder().toString() + "):");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("logo.png")));

        CategoryDataset dataset = convertToDataset(message);

        final JFreeChart chart = ChartFactory.createBarChart(null, "D4 Packages", "Pam5", dataset); 
        chart.setBackgroundPaint(Color.white);
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        // OPTIONAL CUSTOMISATION COMPLETED.

        // add the chart to a panelchato.
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        chartPanel.setPreferredSize(jPanelChart.getSize());
        
        
        jPanelChart.setLayout(new BorderLayout());
        jPanelChart.add(chartPanel, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
                 */
    //@SuppressWarnings("unchecked")
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelText.setText("Text:");

        jTextAreaText.setEditable(false);
        jTextAreaText.setColumns(20);
        jTextAreaText.setRows(5);
        jScrollPane1.setViewportView(jTextAreaText);

        jLabelBinary.setText("Binary:");

        jTextAreaBinary.setEditable(false);
        jTextAreaBinary.setColumns(20);
        jTextAreaBinary.setRows(5);
        jScrollPane2.setViewportView(jTextAreaBinary);

        jLabelEncoded.setText("Encoded:");

        jTextAreaEncoded.setEditable(false);
        jTextAreaEncoded.setColumns(20);
        jTextAreaEncoded.setRows(5);
        jScrollPane3.setViewportView(jTextAreaEncoded);

        jPanelChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelChartLayout = new javax.swing.GroupLayout(jPanelChart);
        jPanelChart.setLayout(jPanelChartLayout);
        jPanelChartLayout.setHorizontalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelChartLayout.setVerticalGroup(
            jPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jLabelEncoded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
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
                .addComponent(jPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    private CategoryDataset convertToDataset(Message message) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (message.getEncoder() == Protocol.ENCODER.D4Pam5) {
            for (int i = 0; i < message.getData().length; i++) {
                byte[] bytes = ((DataD4Pam5) message.getData()[i]).getData();
                for (int j = 0; j < bytes.length; j++) {
                    dataset.addValue(bytes[j], new Integer(j), new Integer(i));
                }
            }
        }
        return dataset;
    }
}
