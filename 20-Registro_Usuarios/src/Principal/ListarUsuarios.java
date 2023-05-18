
package Principal;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class ListarUsuarios extends javax.swing.JFrame {
    Menu ventaMenu;
    JLabel etiqueta;
    public ListarUsuarios(Menu ventanaMenu) {
        this.ventaMenu = ventanaMenu;
        initComponents();
        initAlternComponents();
    }
    public void initAlternComponents(){
         contenUsuarios.setLayout(new BoxLayout(contenUsuarios, BoxLayout.Y_AXIS));
         contenUsuarios.setBackground(Color.white);
         setLocationRelativeTo(null);
         setIconImage( getToolkit().createImage(ClassLoader.getSystemResource("images/icono.png")));
         listar();
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenUsuarios = new javax.swing.JPanel();
        btnAtrasLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(3, 215, 242));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listar Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setForeground(new java.awt.Color(102, 102, 102));

        contenUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenUsuariosLayout = new javax.swing.GroupLayout(contenUsuarios);
        contenUsuarios.setLayout(contenUsuariosLayout);
        contenUsuariosLayout.setHorizontalGroup(
            contenUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        contenUsuariosLayout.setVerticalGroup(
            contenUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contenUsuarios);

        btnAtrasLista.setBackground(new java.awt.Color(3, 215, 242));
        btnAtrasLista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAtrasLista.setForeground(new java.awt.Color(0, 0, 0));
        btnAtrasLista.setText("Atras");
        btnAtrasLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btnAtrasLista, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtrasLista, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasListaActionPerformed
        this.ventaMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAtrasListaActionPerformed
    public void listar(){
        for(int i=0; i<this.ventaMenu.indexPersona;i++){
            if(this.ventaMenu.listapersonas[i]!=null){
                etiqueta = new JLabel (i + " / " + this.ventaMenu.listapersonas[i].getCedula() + " /  " + this.ventaMenu.listapersonas[i].getNombre());
                contenUsuarios.add(etiqueta);
            }
            revalidate();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtrasLista;
    private javax.swing.JPanel contenUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
