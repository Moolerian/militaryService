package view;

/**
 * @author mohammad
 */
public class SatLevelDialog extends javax.swing.JDialog {

    /**
     * Creates new form SatLevelDialog
     */
    public SatLevelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        OneCheckBox = new javax.swing.JCheckBox();
        TwoCheckBox = new javax.swing.JCheckBox();
        ThreeCheckBox = new javax.swing.JCheckBox();
        FourCheckBox = new javax.swing.JCheckBox();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 250));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getSize() + 2f));
        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("دسته بندی محاسبات");

        OneCheckBox.setText("حرارتی");

        TwoCheckBox.setText("چند طیفی");

        ThreeCheckBox.setText("رادار");

        FourCheckBox.setText("پنکروماتیک");

        SaveButton.setText("ذخیره");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(FourCheckBox))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(TwoCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ThreeCheckBox)
                                                        .addComponent(OneCheckBox))
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(OneCheckBox)
                                        .addComponent(TwoCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ThreeCheckBox)
                                        .addComponent(FourCheckBox))
                                .addGap(18, 18, 18)
                                .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Root.satLevel.clear();
        if (OneCheckBox.isSelected()) {
            Root.satLevel.add("حرارتی");
        }
        if (TwoCheckBox.isSelected()) {
            Root.satLevel.add("چند طیفی");
        }
        if (ThreeCheckBox.isSelected()) {
            Root.satLevel.add("رادار");
        }
        if (FourCheckBox.isSelected()) {
            Root.satLevel.add("پنکروماتیک");
        }

        this.setVisible(false);

    }

    public static void main(String[] args) {
        SatLevelDialog dialog = new SatLevelDialog(null, false);
        dialog.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JCheckBox FourCheckBox;
    private javax.swing.JCheckBox OneCheckBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JCheckBox ThreeCheckBox;
    private javax.swing.JCheckBox TwoCheckBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}
