package view;

import com.github.amsacode.predict4java.GroundStationPosition;
import com.github.amsacode.predict4java.SatNotFoundException;
import com.github.amsacode.predict4java.SatPassTime;
import com.github.amsacode.predict4java.TLE;
import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwind.util.Logging;
import gov.nasa.worldwind.util.StatusBar;
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener;
import model.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.EarthUtil;
import util.ExtendedPassPredictor;
import util.WWJUtil;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author Mohammad
 */
@SuppressWarnings({"UnusedParameters", "FieldCanBeLocal", "WeakerAccess",
        "unused", "unchecked", "WhileLoopReplaceableByForEach", "ForLoopReplaceableByForEach", "AccessStaticViaInstance", "MagicConstant", "InfiniteLoopStatement"})
public class Root extends JFrame implements Runnable {

    private static final long serialVersionUID = -5720473795150511569L;
    private Facility facility = null;
    public static List<String> satLevel = new ArrayList<>();
    SatLevelDialog levelDialog = new SatLevelDialog(this, true);
    int panelIndex = 0;
    int colorIndex = 0;
    public static ResultDialog resultDialog = new ResultDialog(null, false);

    static {
        try {
            String architecture = System.getProperty("os.arch");
            if ("x86".equals(architecture))
                System.loadLibrary("WebView32");
            else
                System.loadLibrary("WebView64");
        } catch (Throwable t) {
            String message = Logging.getMessage("WebView.ExceptionCreatingWebView", t);
            Logging.logger().severe(message);
        }

        Configuration.setValue(
                "gov.nasa.worldwind.avkey.DataFileStoreConfigurationFileName",
                "src/resource/CacheLocationConfiguration.xml");
    }

    public Root() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Thread thread = new Thread(this);
        thread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        top = new javax.swing.JPanel();
        Go = new javax.swing.JButton();
        removeFacilityFromList = new javax.swing.JButton();
        runPassPrediction = new javax.swing.JButton();
        NewFacility = new javax.swing.JButton();
        CustomFacility = new javax.swing.JButton();
        CustomSatellite = new javax.swing.JButton();
        Compass = new javax.swing.JToggleButton();
        WorldView = new javax.swing.JToggleButton();
        Scale = new javax.swing.JToggleButton();
        excelSat = new javax.swing.JButton();
        allSatsButton = new javax.swing.JButton();
        tilteCheckBox = new javax.swing.JCheckBox();
        settingButton = new javax.swing.JButton();
        levelComboBox = new javax.swing.JComboBox<>();
        satLevelButton = new javax.swing.JButton();
        center = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        localTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        universalTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        localDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        universalDate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        left = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facilityList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        customeFacilityMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        CustomSatelliteMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        SaveMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        compassMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        worldMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        scaleMenuItem = new javax.swing.JCheckBoxMenuItem();
        placeNameMenuItem = new javax.swing.JCheckBoxMenuItem();
        openStreetMenuItem = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        top.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        top.setPreferredSize(new java.awt.Dimension(701, 70));

        Go.setText("برو");
        Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoActionPerformed(evt);
            }
        });

        removeFacilityFromList.setText("حذف از لیست");
        removeFacilityFromList.setToolTipText("");
        removeFacilityFromList.setEnabled(false);
        removeFacilityFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFacilityFromListActionPerformed(evt);
            }
        });

        runPassPrediction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        runPassPrediction.setForeground(java.awt.Color.darkGray);
        runPassPrediction.setText("پردازش");
        runPassPrediction.setToolTipText("");
        runPassPrediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runPassPredictionActionPerformed(evt);
            }
        });

        NewFacility.setText("تجهیزات");
        NewFacility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFacilityActionPerformed(evt);
            }
        });

        CustomFacility.setText("معرفی تجهیزات");
        CustomFacility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomFacilityActionPerformed(evt);
            }
        });

        CustomSatellite.setText("تعریف ماهواره");
        CustomSatellite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomSatelliteActionPerformed(evt);
            }
        });

        Compass.setText("جهت");
        Compass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompassActionPerformed(evt);
            }
        });

        WorldView.setText("دید جهانی");
        WorldView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorldViewActionPerformed(evt);
            }
        });

        Scale.setText("مقیاس");
        Scale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScaleActionPerformed(evt);
            }
        });

        excelSat.setText("تعریف دسته ایی ماهواره");
        excelSat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelSatActionPerformed(evt);
            }
        });

        allSatsButton.setText("لیست ماهواره ها");
        allSatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSatsButtonActionPerformed(evt);
            }
        });

        tilteCheckBox.setText("tilt");
        tilteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tilteCheckBoxActionPerformed(evt);
            }
        });

        settingButton.setText("تنظیمات اخطار");
        settingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingButtonActionPerformed(evt);
            }
        });

        levelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"آشکار سازی", "شناسایی"}));

        satLevelButton.setText("دسته بندی ماهواره ها");
        satLevelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satLevelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addComponent(Go)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeFacilityFromList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NewFacility)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CustomFacility, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CustomSatellite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(excelSat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allSatsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Compass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Scale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WorldView)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(settingButton)
                                .addGap(18, 18, 18)
                                .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(satLevelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(tilteCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runPassPrediction, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        topLayout.setVerticalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(runPassPrediction, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Go)
                                        .addComponent(removeFacilityFromList)
                                        .addComponent(NewFacility)
                                        .addComponent(CustomFacility)
                                        .addComponent(CustomSatellite)
                                        .addComponent(Scale)
                                        .addComponent(WorldView)
                                        .addComponent(Compass)
                                        .addComponent(excelSat)
                                        .addComponent(allSatsButton)
                                        .addComponent(tilteCheckBox)
                                        .addComponent(settingButton)
                                        .addComponent(levelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(satLevelButton))
                                .addGap(28, 28, 28))
        );

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        bottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("زمان محلی");

        localTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localTime.setForeground(java.awt.Color.darkGray);
        localTime.setText("00:00:00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("زمان جهانی");

        universalTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalTime.setForeground(java.awt.Color.darkGray);
        universalTime.setText("00:00:00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("تاریخ محلی");

        localDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localDate.setForeground(java.awt.Color.darkGray);
        localDate.setText("14/10/2016");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("تاریخ جهانی");

        universalDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalDate.setForeground(java.awt.Color.darkGray);
        universalDate.setText("14/10/2016");

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(universalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(localDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(universalTime)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(localTime, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        bottomLayout.setVerticalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(localTime)
                                        .addComponent(jLabel2)
                                        .addComponent(universalTime)
                                        .addComponent(jLabel3)
                                        .addComponent(localDate)
                                        .addComponent(jLabel5)
                                        .addComponent(universalDate))
                                .addContainerGap())
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, 1446, Short.MAX_VALUE)
        );
        centerLayout.setVerticalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerLayout.createSequentialGroup()
                                .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        left.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        facilityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facilityList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilityListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(facilityList);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
                leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
                leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
        );

        getContentPane().add(left, java.awt.BorderLayout.LINE_START);

        fileMenu.setText("File");

        newMenuItem.setText("تجهیزات");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);
        fileMenu.add(jSeparator3);

        customeFacilityMenuItem.setText("تعریف تجهیزات");
        customeFacilityMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customeFacilityMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(customeFacilityMenuItem);
        fileMenu.add(jSeparator4);

        CustomSatelliteMenuItem.setText("تعریف ماهواره");
        CustomSatelliteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomSatelliteMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(CustomSatelliteMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        SaveMenuItem.setText("ذخیره");
        SaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(SaveMenuItem);

        menuBar.add(editMenu);

        jMenu1.setText("view");

        compassMenuItem.setText("جهت");
        compassMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compassMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(compassMenuItem);
        jMenu1.add(jSeparator1);

        worldMenuItem.setText("دید جهانی");
        worldMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worldMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(worldMenuItem);
        jMenu1.add(jSeparator2);

        scaleMenuItem.setText("مقیاس");
        scaleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(scaleMenuItem);

        placeNameMenuItem.setText("نام مناطق جهان");
        placeNameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeNameMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(placeNameMenuItem);

        openStreetMenuItem.setText("نام مناطق و راهها");
        openStreetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openStreetMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openStreetMenuItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        WWJUtil.createWWJ();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Root root = new Root();
                root.setVisible(true);
            }
        });


    }

    private void settingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SettingDialog settingDialog = new SettingDialog(null, false);
        Root.resultDialog.setVisible(false);
        settingDialog.setVisible(true);
    }

    @Override
    public void run() {
        StatusBar statusBar = new StatusBar();
        this.add(statusBar, BorderLayout.PAGE_END);
        statusBar.setEventSource(WWJUtil.getWwj());


        /******* Date Section*******/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = Calendar.getInstance().getTime();
        this.localDate.setText(EarthUtil.convertJulianToPersianForUi(date));
        this.universalDate.setText(dateFormat.format(date));

        /******** Time Section *********/
        SimpleDateFormat localFormatter = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat universalFormatter = new SimpleDateFormat("hh:mm:ss");
        universalFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            while (true) {
                Date time = Calendar.getInstance().getTime();
                this.localTime.setText(localFormatter.format(time));
                this.universalTime.setText(universalFormatter.format(time));
                Thread.sleep(1000);
            }
        } catch (Exception ignored) {
        }

        menuBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    private void satReportActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(null, "not impl yet");

    }

    private void satDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {

        JOptionPane.showMessageDialog(null, "not impl yet");

    }

    @SuppressWarnings("Duplicates")
    private void allSatsButtonActionPerformed(java.awt.event.ActionEvent evt) {

        final ShowSats showSats = new ShowSats(this, true);
        final DefaultTableModel model = (DefaultTableModel) showSats.satBrowser.getModel();
        showSats.satBrowser.setRowHeight(80);
        List<Satellite> sats = EarthUtil.getSatellites();

        showSats.satBrowser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int column = target.getSelectedColumn();
                    int row = target.getSelectedRow();
                    if (column == 0) {
                        // remove row
                        int reply = JOptionPane.showConfirmDialog(null, "آیا برای حذف کردن اطمینان دارید ؟");
                        if (reply == JOptionPane.YES_OPTION) {
                            String satName = (String) showSats.satBrowser.getValueAt(row, 2);
                            EarthUtil.removeByName(satName);
                            model.removeRow(row);
                            showSats.pack();
                            showSats.revalidate();
                            showSats.repaint();
                            showSats.doLayout();
                        }
                    }
                }
            }
        });

        for (int i = 0; i < sats.size(); i++) {
            Satellite satellite = sats.get(i);
            Object[] raw = new Object[6];
            raw[2] = satellite.getDisplayName();
            String satelliteOne = String.valueOf(satellite.getSatelliteOne());

            raw[1] = satelliteOne;
            raw[0] = "حذف";
            raw[3] = satellite.getSatelliteTwo();
            raw[4] = satellite.getSatelliteThree();
            raw[5] = satellite.getSatelliteFour();
            model.addRow(raw);
        }

        showSats.setVisible(true);
    }

    private void excelSatActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser fileDialog = new JFileChooser();
        fileDialog.addChoosableFileFilter(new FileNameExtensionFilter(".xlsx", "xlsx"));
        fileDialog.setAcceptAllFileFilterUsed(false);
        int returnVal = fileDialog.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            int reply = JOptionPane.showConfirmDialog(this, "آیا برای اضافه کردن اطمینان دارید ؟");
            if (reply == JOptionPane.YES_OPTION) {
                try {
                    this.setEnabled(false);

                    FileInputStream excelFile = new FileInputStream(fileDialog.getSelectedFile());
                    Workbook workbook = new XSSFWorkbook(excelFile);
                    Sheet datatypeSheet = workbook.getSheetAt(0);
                    Iterator<Row> rowIterator = datatypeSheet.iterator();
                    rowIterator.next();
                    while (rowIterator.hasNext()) {

                        Row currentRow = rowIterator.next();
                        Iterator<Cell> cellIterator = currentRow.iterator();

                        while (cellIterator.hasNext()) {

                            Cell cell = cellIterator.next();

                            String satName = cell.getStringCellValue();

                            Cell cellOne = cellIterator.next();
                            double satOne = cellOne.getNumericCellValue();

                            Cell cellTwo = cellIterator.next();
                            double satTwo = cellTwo.getNumericCellValue();

                            Cell cellThree = cellIterator.next();
                            double satThree = cellThree.getNumericCellValue();

                            Cell cellFour = cellIterator.next();
                            String satFour = cellFour.getStringCellValue();


                            Satellite satellite = new Satellite(satName, satOne, satTwo, satThree, satFour);
                            EarthUtil.addSatellite(satellite);
                        }

                    }

                    this.setEnabled(true);
                    JOptionPane.showMessageDialog(this, "اطلاعات فایل با موفقیت به پایگاه داده اضافه شد", "پیغام", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "خطا رخ داده است", "خطا", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void GoActionPerformed(java.awt.event.ActionEvent evt) {
        GoDialog goDialog = new GoDialog(this, false);
        goDialog.setVisible(true);
    }

    private void scaleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getScaleLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getScaleLayer());
        }
    }

    private void worldMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getWorldMapLayer());
            WWJUtil.getWwj().addSelectListener(new ClickAndGoSelectListener
                    (WWJUtil.getWwj(), WorldMapLayer.class));
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getWorldMapLayer());
        }
    }

    private void compassMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getCompassLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getCompassLayer());
        }
    }

    private void placeNameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem placeNames = (JCheckBoxMenuItem) evt.getSource();
        if (placeNames.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getPlaceNameLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getPlaceNameLayer());
        }
    }

    private void openStreetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem openStreet = (JCheckBoxMenuItem) evt.getSource();
        if (openStreet.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getOpenStreetLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getOpenStreetLayer());
        }
    }

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FacilityDialog facilityDialog = new FacilityDialog(this, true);
            EarthUtil.createFacilityTree();
            facilityDialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "خطایی در پردازش شما رخ داده است.", "نا موفق", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void facilityListMouseClicked(java.awt.event.MouseEvent evt) {
        facility = ((JList<Facility>) evt.getSource()).getSelectedValue();
        if (evt.getClickCount() == 2) {
            FacilityPropertyDialog propertyDialog = new FacilityPropertyDialog(this, true);
            propertyDialog.setCurrentFacility(facility);
            propertyDialog.setVisible(true);
        } else if (evt.getClickCount() == 1) {
            WWJUtil.addFacilityToEarth(facility);
            removeFacilityFromList.setEnabled(true);
        }
    }

    private void customeFacilityMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        CreateFacilityDialog facilityDialog = new CreateFacilityDialog(this, true);
        facilityDialog.setVisible(true);
    }

    private void removeFacilityFromListActionPerformed(java.awt.event.ActionEvent evt) {
        if (facility != null) {
            FacilityDialog.getModel().remove(facilityList.getSelectedIndex());
            validate();
            repaint();
            doLayout();
        }
    }

    private void CustomSatelliteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        CreateSatelliteDialog createSatelliteDialog = new CreateSatelliteDialog(this, rootPaneCheckingEnabled);
        createSatelliteDialog.setVisible(true);
    }

    private void NewFacilityActionPerformed(java.awt.event.ActionEvent evt) {
        newMenuItemActionPerformed(evt);
    }

    private void CustomFacilityActionPerformed(java.awt.event.ActionEvent evt) {
        customeFacilityMenuItemActionPerformed(evt);
    }

    private void CustomSatelliteActionPerformed(java.awt.event.ActionEvent evt) {
        CustomSatelliteMenuItemActionPerformed(evt);
    }

    private void CompassActionPerformed(java.awt.event.ActionEvent evt) {
        JToggleButton toggleButton = (JToggleButton) evt.getSource();
        if (toggleButton.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getCompassLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getCompassLayer());
        }
    }

    private void WorldViewActionPerformed(java.awt.event.ActionEvent evt) {
        JToggleButton toggleButton = (JToggleButton) evt.getSource();
        if (toggleButton.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getWorldMapLayer());
            WWJUtil.getWwj().addSelectListener(new ClickAndGoSelectListener
                    (WWJUtil.getWwj(), WorldMapLayer.class));
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getWorldMapLayer());
        }
    }

    private void ScaleActionPerformed(java.awt.event.ActionEvent evt) {
        JToggleButton scale = (JToggleButton) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getScaleLayer());
            WWJUtil.getWwj().addSelectListener(new ClickAndGoSelectListener(WWJUtil.getWwj(), WorldMapLayer.class));
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getScaleLayer());
        }
    }

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {

        AboutDialog aboutDialog = new AboutDialog(this, false);
        aboutDialog.setVisible(true);

    }

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void SaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "این قسمت در دست ساخت میباشد", "پیغام", JOptionPane.INFORMATION_MESSAGE);
    }

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "این قسمت در دست ساخت میباشد", "پیغام", JOptionPane.INFORMATION_MESSAGE);
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {

        int confirmed = JOptionPane.showConfirmDialog(null,
                "آیا تمایل به خروج از برنامه را دارید ؟", "خروج",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void runPassPredictionActionPerformed(java.awt.event.ActionEvent evt) {
        if (facilityList.getModel().getSize() != 0) {
            try {
                passPrediction();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "لطفا برنامه ببندید و مجدد اجرا کنید.", "نا موفق", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "طلفا تجهیزات خود را انتخاب کنید.", "نا موفق", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isInTilteProcess = false;

    private void tilteCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBox checkBox = (JCheckBox) evt.getSource();
        if (checkBox.isSelected()) {
            isInTilteProcess = true;
        }
    }

    @SuppressWarnings("Duplicates")
    private void passPrediction() throws Exception {
        int countFacilities = facilityList.getModel().getSize();
        ListModel<Facility> facilities = facilityList.getModel();
        List<Satellite> satellites = EarthUtil.getSatellites();
        JPanel centeredPanel;
        List<ExtendedSatPassTime> allPasses = new ArrayList<>();
        for (int index = 0; index < countFacilities; index++) {
            Facility facility = facilities.getElementAt(index);
            double timeSpanDays = EarthUtil.daysBetween(facility.getStartDate(), facility.getEndDate());
            for (int i = 0; i < timeSpanDays; i++) {
                Date calculatingDate = EarthUtil.addDays(facility.getStartDate(), i);
                for (Satellite satellite : satellites) {
                    if (checkCondition(facility, satellite)) {

                        File file = new File("src/resource/tle/tle.txt");
                        if (file.exists()) {
                            String lineOne = "";
                            String lineTwo = "";
                            String satName = "";
                            final Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                final String lineFromFile = scanner.nextLine();
                                String line = lineFromFile.trim().toLowerCase();
                                satName = satellite.getDisplayName().trim().toLowerCase();
                                if (line.contains(satName)) {
                                    // a match!
                                    lineOne = scanner.nextLine();
                                    lineTwo = scanner.nextLine();
                                    scanner.close();
                                    break;
                                }
                            }

                            // do prediction

                            if (lineOne.length() > 0 && lineTwo.length() > 0 && satName.length() > 0) {

                                String[] tleString = {satName, lineOne, lineTwo};
                                TLE tle = new TLE(tleString);

                                GroundStationPosition position = new GroundStationPosition(facility.getLatitude(), facility.getLongitude(), 0);
                                ExtendedPassPredictor passPredictor;
                                try {
                                    passPredictor = new ExtendedPassPredictor(tle, position);
                                } catch (SatNotFoundException e) {
                                    continue;
                                }

                                double satPassWidth;
                                double satPassWidthTilte;
                                satPassWidth = satellite.getSatelliteTwo() == 0 ? 30 : satellite.getSatelliteTwo();
                                satPassWidthTilte = satellite.getSatelliteThree() == 0 ? 70 : satellite.getSatelliteThree();

                                if (isInTilteProcess) {
                                    passPredictor.setWidthPassage(satPassWidthTilte);
                                } else {
                                    passPredictor.setWidthPassage(satPassWidth);
                                }
                                System.out.println(satName);
                                List<SatPassTime> passed = passPredictor.getPasses(calculatingDate, 24, false);
                                // now create results
                                // result for one facility and first satellite and the first day of calculating
                                for (SatPassTime passTime : passed) {
                                    ExtendedSatPassTime extendedSatPassTime = new ExtendedSatPassTime();
                                    extendedSatPassTime.setSatName(satName);
                                    extendedSatPassTime.setStartTime(passTime.getStartTime());
                                    extendedSatPassTime.setEndTime(passTime.getEndTime());
                                    extendedSatPassTime.setTca(passTime.getTCA());
                                    extendedSatPassTime.setMaxEl(passTime.getMaxEl());
                                    extendedSatPassTime.setAos(passTime.getAosAzimuth());
                                    extendedSatPassTime.setLos(passTime.getLosAzimuth());
                                    extendedSatPassTime.setPolePassed(passTime.getPolePassed());
                                    extendedSatPassTime.setFacilityName(facility.getDisplayName());
                                    extendedSatPassTime.setPassPredictor(passPredictor);
                                    allPasses.add(extendedSatPassTime);
                                }

                            }
                        }
                    }
                }// next sat

            }// next day

        }

        Collections.sort(allPasses, new Comparator<ExtendedSatPassTime>() {
            public int compare(ExtendedSatPassTime o1, ExtendedSatPassTime o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });

        for (ExtendedSatPassTime passTime : allPasses) {
            Date now = new Date();
            if (now.before(passTime.getStartTime())) {
                panelIndex++;
            }
        }
        centeredPanel = new JPanel(new GridLayout(panelIndex, 1));

        for (ExtendedSatPassTime passTime : allPasses) {
            colorIndex++;
            Date now = new Date();
            if (now.before(passTime.getStartTime())) {
                JPanel innerPanel = new JPanel(new GridLayout(1, 1));

                ResultPanel resultPanel = new ResultPanel();
                Color color;
                if (colorIndex % 2 == 0) {
                    color = new Color(71, 95, 133);
                } else {
                    color = new Color(71, 60, 133);
                }
                resultPanel.setColor(color);
                resultPanel.sat.setText(passTime.getSatName());


                URL resource = resultDialog.getClass().getResource("/resource/" + passTime.getSatName() + ".png");

                if (resource == null) {
                    resource = resultDialog.getClass().getResource("/resource/" + "RSDK-ONE" + ".png");
                }

                resultPanel.pic.setIcon(new javax.swing.ImageIcon(resource));

                resultPanel.setStartDate(passTime.getStartTime());
                SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");

                String time = EarthUtil.convertJulianToPersianForUi(passTime.getStartTime()) +
                        " - " +
                        localDateFormat.format(passTime.getStartTime()) +
                        "- " +
                        localDateFormat.format(passTime.getEndTime());
                resultPanel.time.setText(time);

                SatPassDetails satPassDetails = new SatPassDetails();
                satPassDetails.setAos(passTime.getAos());
                satPassDetails.setLos(passTime.getLos());
                satPassDetails.setTca(passTime.getTca().toString());
                satPassDetails.setEndTime(localDateFormat.format(passTime.getEndTime()));
                satPassDetails.setStartTime(localDateFormat.format(passTime.getStartTime()));
                satPassDetails.setSatName(passTime.getSatName());
                satPassDetails.setFacilityName(passTime.getFacilityName());
                satPassDetails.setMaxEl(passTime.getMaxEl());
                satPassDetails.setPolePassed(passTime.getPolePassed());
                satPassDetails.setPassPredictor(passTime.getPassPredictor());

                resultPanel.setSatPassDetails(satPassDetails);

                resultPanel.run();
                innerPanel.add(resultPanel);
                centeredPanel.add(innerPanel);
            }
        }


        JScrollPane scrollPane = new JScrollPane(centeredPanel);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(5, 60, 400, 540);

        resultDialog.add(scrollPane);
        resultDialog.setVisible(true);

    }

    private boolean checkCondition(Facility facility, Satellite satellite) {
        boolean valid = false;

        if (!satLevel.contains(satellite.getSatelliteFour())) {
            return false;
        }
        double facilityArea = facility.getArea();
        double satelliteOne = satellite.getSatelliteOne();
        double canSee = 0;
        int selectedIndex = levelComboBox.getSelectedIndex();
        if (selectedIndex == 0) { // آشکار سازی

            canSee = 3 * (Math.pow(satelliteOne, 2));

        } else if (selectedIndex == 1) { // شناسایی
            canSee = 10 * (Math.pow(satelliteOne, 2));
        }

        if (canSee <= facilityArea) {
            valid = true;
        }
        return valid;
    }

    private void satLevelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        levelDialog.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JToggleButton Compass;
    private javax.swing.JButton CustomFacility;
    private javax.swing.JButton CustomSatellite;
    private javax.swing.JMenuItem CustomSatelliteMenuItem;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Go;
    private javax.swing.JButton Help;
    private javax.swing.JButton NewFacility;
    private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JToggleButton Scale;
    private javax.swing.JToggleButton WorldView;
    private javax.swing.JButton allSatsButton;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel center;
    private javax.swing.JCheckBoxMenuItem compassMenuItem;
    private javax.swing.JMenuItem customeFacilityMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JButton excelSat;
    static javax.swing.JList<Facility> facilityList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox tilteCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPanel left;
    private javax.swing.JLabel localDate;
    private javax.swing.JLabel localTime;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JComboBox<String> levelComboBox;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JCheckBoxMenuItem openStreetMenuItem;
    private javax.swing.JCheckBoxMenuItem placeNameMenuItem;
    private javax.swing.JButton removeFacilityFromList;
    private javax.swing.JButton runPassPrediction;
    private javax.swing.JButton satLevelButton;
    private javax.swing.JButton satDetailsButton;
    private javax.swing.JButton satReport;
    private javax.swing.JCheckBoxMenuItem scaleMenuItem;
    private javax.swing.JPanel top;
    private javax.swing.JLabel universalDate;
    private javax.swing.JLabel universalTime;
    private javax.swing.JButton settingButton;
    private javax.swing.JCheckBoxMenuItem worldMenuItem;
    // End of variables declaration
}
