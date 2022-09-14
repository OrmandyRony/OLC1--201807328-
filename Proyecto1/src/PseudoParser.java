
import analizadores.AnalizadorLexico;
import analizadores.AnalizadorSintactico;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ormandyrony
 */
public class PseudoParser extends javax.swing.JFrame {
    private File ficheroActual;
    AnalizadorLexico lexico;
    AnalizadorSintactico sintactico;
    /**
     * Creates new form PseudoParser
     */
    public PseudoParser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCodigo = new javax.swing.JTextArea();
        clean = new javax.swing.JButton();
        run = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAs = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        flowChart = new javax.swing.JMenuItem();
        errors = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        userManual = new javax.swing.JMenuItem();
        technicalManual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PseudoParser");

        txtAreaCodigo.setColumns(20);
        txtAreaCodigo.setRows(5);
        jScrollPane1.setViewportView(txtAreaCodigo);

        clean.setText("Clean");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        run.setBackground(new java.awt.Color(153, 204, 0));
        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        openFile.setText("Open file");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        jMenu1.add(openFile);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jMenu1.add(save);

        saveAs.setText("Save as ...");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });
        jMenu1.add(saveAs);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Report");

        flowChart.setText("Flowchart");
        jMenu2.add(flowChart);

        errors.setText("Errors");
        jMenu2.add(errors);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        userManual.setText("User manual");
        jMenu3.add(userManual);

        technicalManual.setText("Technical manual");
        jMenu3.add(technicalManual);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clean)
                        .addGap(18, 18, 18)
                        .addComponent(run)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run)
                    .addComponent(clean))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        // TODO add your handling code here:
        this.abrirVentanaGuardar();
    }//GEN-LAST:event_saveAsActionPerformed

    /**
     * Open window for choose directorio in that save the file
     */
    private void abrirVentanaGuardar() {
        JFileChooser  fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int seleccion = fc.showSaveDialog(this.getContentPane());

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            this.ficheroActual = fc.getSelectedFile();
            escribirFichero();

        } 
    }
    
    private void escribirFichero() {
        try ( FileWriter fw = new FileWriter(this.ficheroActual)) {
            fw.write(this.txtAreaCodigo.getText());
        } catch (IOException ex) {
            Logger.getLogger(PseudoParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int seleccion = fc.showOpenDialog(this.getContentPane());
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            this.ficheroActual = fc.getSelectedFile();
            
            try (FileReader fr = new FileReader(this.ficheroActual)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena += (char) valor;
                    valor = fr.read();
                }
                
                this.txtAreaCodigo.setText(cadena);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PseudoParser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PseudoParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if (this.ficheroActual == null) {
            this.abrirVentanaGuardar();
        } else {
            this.escribirFichero();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        // TODO add your handling code here:
        this.txtAreaCodigo.setText("");
   
    }//GEN-LAST:event_cleanActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        System.out.println("Analizador");
        // lexico = new AnalizadorLexico(this.txtAreaCodigo.getText());
        try {
            AnalizadorLexico lexico2 = new AnalizadorLexico(new StringReader(this.txtAreaCodigo.getText()));
            AnalizadorSintactico sintactico2 = new AnalizadorSintactico(lexico2);
            sintactico2.parse();
        } catch (Exception e) {
        }
        
        System.out.println("Finalizar analizador");
        
    }//GEN-LAST:event_runActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PseudoParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PseudoParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PseudoParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PseudoParser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PseudoParser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clean;
    private javax.swing.JMenuItem errors;
    private javax.swing.JMenuItem flowChart;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JButton run;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAs;
    private javax.swing.JMenuItem technicalManual;
    private javax.swing.JTextArea txtAreaCodigo;
    private javax.swing.JMenuItem userManual;
    // End of variables declaration//GEN-END:variables
}
