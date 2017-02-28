package view;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwind.util.Logging;
import gov.nasa.worldwind.util.StatusBar;
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener;
import model.Facility;
import model.SatReport;
import model.Satellite;
import name.gano.astro.AER;
import name.gano.astro.time.Time;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * @author Mohammad
 */
public class Root extends JFrame implements Runnable {
    private static final long serialVersionUID = -5720473795150511569L;
    private Facility facility = null;

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
    public static javax.swing.JList<Facility> facilityList;
    private javax.swing.JMenu fileMenu;
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
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JCheckBoxMenuItem openStreetMenuItem;
    private javax.swing.JCheckBoxMenuItem placeNameMenuItem;
    private javax.swing.JButton removeFacilityFromList;
    private javax.swing.JButton runPassPrediction;
    private javax.swing.JButton satDetailsButton;
    private javax.swing.JButton satReport;
    private javax.swing.JCheckBoxMenuItem scaleMenuItem;
    private javax.swing.JPanel top;
    private javax.swing.JLabel universalDate;
    private javax.swing.JLabel universalTime;
    private javax.swing.JCheckBoxMenuItem worldMenuItem;
    // End of variables declaration

    /**
     * Creates new form root
     */
    public Root() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        Thread thread = new Thread(this);
        thread.start();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WWJUtil.createWWJ();

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        Root r = new Root();
//        r.testTable();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Root().setVisible(true);
            }
        });
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        Help = new javax.swing.JButton();
        Compass = new javax.swing.JToggleButton();
        WorldView = new javax.swing.JToggleButton();
        Scale = new javax.swing.JToggleButton();
        Exit = new javax.swing.JButton();
        satReport = new javax.swing.JButton();
        satDetailsButton = new javax.swing.JButton();
        excelSat = new javax.swing.JButton();
        allSatsButton = new javax.swing.JButton();
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
        runPassPrediction.setForeground(new java.awt.Color(255, 255, 0));
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

        CustomSatellite.setText("ماهواره");
        CustomSatellite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomSatelliteActionPerformed(evt);
            }
        });

        Help.setText("راهنما");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
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

        Exit.setText("خروج");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        satReport.setText("گزارش ماهواره ها");
        satReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satReportActionPerformed(evt);
            }
        });

        satDetailsButton.setText("جزییات ماهواره");
        satDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satDetailsButtonActionPerformed(evt);
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

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Go)
                                .addGap(18, 18, 18)
                                .addComponent(removeFacilityFromList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NewFacility)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CustomFacility, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CustomSatellite)
                                .addGap(18, 18, 18)
                                .addComponent(Scale)
                                .addGap(18, 18, 18)
                                .addComponent(WorldView)
                                .addGap(18, 18, 18)
                                .addComponent(Compass)
                                .addGap(18, 18, 18)
                                .addComponent(Help)
                                .addGap(18, 18, 18)
                                .addComponent(satReport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(satDetailsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excelSat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(allSatsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(Exit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runPassPrediction, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(Help)
                                        .addComponent(Exit)
                                        .addComponent(satReport)
                                        .addComponent(satDetailsButton)
                                        .addComponent(excelSat)
                                        .addComponent(allSatsButton))
                                .addContainerGap())
        );

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        bottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("زمان محلی");

        localTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localTime.setForeground(new java.awt.Color(255, 255, 0));
        localTime.setText("00:00:00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("زمان جهانی");

        universalTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalTime.setForeground(new java.awt.Color(255, 255, 0));
        universalTime.setText("00:00:00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("تاریخ محلی");

        localDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localDate.setForeground(new java.awt.Color(255, 255, 0));
        localDate.setText("14/10/2016");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("تاریخ جهانی");

        universalDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalDate.setForeground(new java.awt.Color(255, 255, 0));
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
                        .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, 1401, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
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


    private void satReportActionPerformed(java.awt.event.ActionEvent evt) {

        SatReportDialog satReportDialog = new SatReportDialog(this, true);
        DefaultTableModel model = (DefaultTableModel) satReportDialog.jTable1.getModel();
        SatReportDialog.jTable1.setRowHeight(80);
        List<SatReport> satReports = EarthUtil.getSatReports();

        for (SatReport satReport : satReports) {
            Object[] raw = new Object[16];
            raw[0] = satReport.getName();
            raw[1] = satReport.getMadeIn();
            raw[2] = satReport.getLaunchDate();
            raw[3] = satReport.getTilt();
            raw[4] = satReport.getAltitude();
            raw[5] = satReport.getRCS();
            raw[6] = satReport.getCircuit();
            raw[7] = satReport.getSatelliteLife();
            raw[8] = satReport.getSensor();
            raw[9] = satReport.getSensorType();
            raw[10] = satReport.getSpatialResolution();
            raw[11] = satReport.getTemporalResolution();
            raw[12] = satReport.getRadiometricResolution();
            raw[13] = satReport.getWidthPassage();
            raw[14] = satReport.getBondNumber();
            raw[15] = satReport.getSpectralRange();
            model.addRow(raw);
        }

        satReportDialog.setVisible(true);

    }

    private void satDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {

        AddSatDetailsDialog addSatDetailsDialog = new AddSatDetailsDialog(this, true);
        addSatDetailsDialog.setVisible(true);

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
            Object[] raw = new Object[4];
            raw[2] = satellite.getDisplayName();
            String satelliteOne = "";
            switch (satellite.getSatelliteOne()) {
                case 0:
                    satelliteOne = "بیش از 9 متر";
                    break;
                case 1:
                    satelliteOne = "بین 4.5 تا 9 متر";
                    break;
                case 2:
                    satelliteOne = "بین 2.5 تا 4.5 متر";
                    break;
                case 3:
                    satelliteOne = "بین 1.2 تا 2.5 متر";
                    break;
                case 4:
                    satelliteOne = "بین 0.75 تا 1.2 متر";
                    break;
            }

            raw[1] = satelliteOne;
            raw[0] = "حذف";
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

                            Integer satOne = cell.getColumnIndex();

                            String stringCellValue = cell.getStringCellValue();
                            if (!stringCellValue.isEmpty() && !Objects.equals(stringCellValue, "")) {
                                String satName = stringCellValue.split("\\(")[0];

                                Satellite satellite = new Satellite(satName, satOne, null, null, null);
                                EarthUtil.addSatellite(satellite);
                            }
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
        System.out.println(WWJUtil.getOpenStreetLayer());
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
        // TODO add your handling code here:
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

    private String[][] valuesAt = new String[100][100];

    int calcultedRow = 0;

    private void runPassPredictionActionPerformed(java.awt.event.ActionEvent evt) {
        if (facilityList.getModel().getSize() != 0) {
            try {
                calcultedRow = 0;
                valuesAt = new String[100][100];
                passPrediction();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "خطایی در پردازش شما رخ داده است.", "نا موفق", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "طلفا تجهیزات خود را انتخاب کنید.", "نا موفق", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void passPrediction() throws Exception {
        int countFacilities = facilityList.getModel().getSize();
        ListModel<Facility> listModel = facilityList.getModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS z");
        Time currentJulianDate = new Time();
        currentJulianDate.setDateFormat(dateFormat);
        List<Satellite> satellites = EarthUtil.getSatellites();
        ResultDialog resultDialog = new ResultDialog(this, true);
        DefaultTableModel model = (DefaultTableModel) ResultDialog.resultTable.getModel();
        ResultDialog.resultTable.setRowHeight(80);


        for (int index = 0; index < countFacilities; index++) {
            Facility facility = listModel.getElementAt(index);
            for (Satellite satellite : satellites) {
                if (checkCondition(facility, satellite)) {

                    // Define GroundStation
                    double[] lla = {facility.getLatitude(), facility.getLongitude(), 0};
                    GroundStation groundStation = new GroundStation("", lla, currentJulianDate.getJulianDate());
                    groundStation.setElevationConst(0);
                    groundStation.setStationName(facility.getDisplayName());

                    // Define AbstractSatellite by reading tle file
                    File file = new File("src/resource/tle/tle.txt");
                    if (file.exists()) {
                        String lineOne = "";
                        String lineTwo = "";
                        final Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            final String lineFromFile = scanner.nextLine();
                            String line = lineFromFile.trim().toLowerCase();
                            String satName = satellite.getDisplayName().trim().toLowerCase();
                            if (line.contains(satName)) {
                                // a match!
                                lineOne = scanner.nextLine();
                                lineTwo = scanner.nextLine();
                                scanner.close();
                                break;
                            }
                        }

                        if (!Objects.equals(lineOne, "") & !Objects.equals(lineTwo, "")) {
                            AbstractSatellite abstractSatellite = new SatelliteTleSGP4(satellite.getDisplayName(), lineOne, lineTwo);
                            abstractSatellite.setDisplayName(satellite.getDisplayName());

                            Calendar startCalendar = EarthUtil.dateToCalendar(facility.getStartDate());
                            Time start = new Time(startCalendar.get(Calendar.YEAR),
                                    startCalendar.get(Calendar.MONTH) + 1,
                                    startCalendar.get(Calendar.DAY_OF_MONTH),
                                    startCalendar.get(Calendar.HOUR_OF_DAY),
                                    startCalendar.get(Calendar.MINUTE),
                                    startCalendar.get(Calendar.SECOND));
                            start.setDateFormat(dateFormat);

                            double timeSpanDays = EarthUtil.daysBetween(facility.getStartDate(), facility.getEndDate());


                            runPassPrediction(timeSpanDays, groundStation, abstractSatellite, start, model);
                        }
                    }
                }
            }
        }

        ResultDialog.resultTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();

                    ResultDetails resultDetails = new ResultDetails(null, true);
                    resultDetails.resultDetailTextArea.setFont(resultDetails.resultDetailTextArea.getFont().deriveFont(14f));
                    resultDetails.resultDetailTextArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    resultDetails.resultDetailTextArea.append(valuesAt[row][column]);
                    resultDetails.resultDetailTextArea.append("\n");
                    resultDetails.setVisible(true);
                }
            }
        });

        resultDialog.setVisible(true);
    }

    private boolean checkCondition(Facility facility, Satellite satellite) {
        boolean valid = true;
        Integer facilityOne = facility.getFacilityOne();
        Integer satelliteOne = satellite.getSatelliteOne();

        if (satelliteOne < facilityOne) {
            valid = false;
        }
        return valid;
    }

    int modelRow = 0;

    @SuppressWarnings("Duplicates")
    private void runPassPrediction(double timeSpanDays, GroundStation gs, AbstractSatellite sat,
                                   Time startJulianDate, DefaultTableModel model) throws ParseException {
        double timeStepSec = 60;
        double jdStart = startJulianDate.getJulianDate();
        double time0, h0;
        double time1 = jdStart;
        double h1 = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(time1), time1)[1] - gs.getElevationConst();
        double lastRise = 0;
        String riseTimeStr = null;
        String durStr = null;
        int row = 0;
        calcultedRow = 0;
        Date lastDay = null;
        StringBuilder eachDay = new StringBuilder();
        for (double jd = jdStart; jd <= jdStart + timeSpanDays; jd += timeStepSec / (60.0 * 60.0 * 24.0)) {
            time0 = time1;
            time1 = jd + timeStepSec / (60.0 * 60.0 * 24.0);
            h0 = h1;
            h1 = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(time1), time1)[1] - gs.getElevationConst();
            // rise
            if (h0 <= 0 && h1 > 0) {
                double riseTime = findSatRiseSetRoot(sat, gs, time0, time1, h0, h1);
                lastRise = riseTime;
                riseTimeStr = startJulianDate.convertJD2String(riseTime);
            }

            // set
            if (h1 <= 0 && h0 > 0) {
                double setTime = findSatRiseSetRoot(sat, gs, time0, time1, h0, h1);
                // add duration
                if (lastRise > 0) {
                    DecimalFormat fmt2Dig = new DecimalFormat("00.000");

                    double duration = (setTime - lastRise) * 24.0 * 60.0 * 60.0; // seconds
                    durStr = fmt2Dig.format(duration);
                }
            }

            if (riseTimeStr != null && durStr != null) {

                SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSSZ");
                format.setTimeZone(TimeZone.getTimeZone("Iran"));
                Date parse = format.parse(riseTimeStr);
                if (lastDay == null) {
                    lastDay = parse;
                }

                Calendar parsCal = Calendar.getInstance();
                parsCal.setTime(parse);
                int parsDay = parsCal.get(Calendar.DAY_OF_MONTH);

                Calendar lastCal = Calendar.getInstance();
                lastCal.setTime(lastDay);
                int lDay = lastCal.get(Calendar.DAY_OF_MONTH);


                String riseDate = EarthUtil.convertJulianToPersian(parse, "EEEE d MMMM y");
                Float floatDur = Float.parseFloat(durStr);
                int intDur = floatDur.intValue();

                Calendar cal = Calendar.getInstance();
                cal.setTime(parse);
                cal.add(Calendar.SECOND, intDur);
                Date time = cal.getTime();
                String untilTime = EarthUtil.convertJulianToPersian(time, "HH:mm:ss");

                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(parse);
                cal1.set(Calendar.HOUR_OF_DAY, 0);
                cal1.set(Calendar.MINUTE, 0);
                cal1.set(Calendar.SECOND, 0);
                cal1.set(Calendar.MILLISECOND, 0);
                Date x1 = cal.getTime();

                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(lastDay);
                cal2.set(Calendar.HOUR_OF_DAY, 0);
                cal2.set(Calendar.MINUTE, 0);
                cal2.set(Calendar.SECOND, 0);
                cal2.set(Calendar.MILLISECOND, 0);
                Date x2 = cal2.getTime();


                int diffInDays = (int) ((x1.getTime() - x2.getTime()) / (1000 * 60 * 60 * 24));
                if (diffInDays == 1) {
                    lastDay = null;
                    // TODO add new row
                    Object[] objects = new Object[27];
                    objects[25] = riseDate;
                    objects[26] = gs.getStationName();

                    if (calcultedRow == timeSpanDays)
                        break;

                    if (calcultedRow >= modelRow) {
                        model.addRow(objects);
                        modelRow++;
                    }
                    calcultedRow++;
                    String[] split = eachDay.toString().split("//");
                    SimpleDateFormat format2 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                    format2.setTimeZone(TimeZone.getTimeZone("Iran"));

                    for (String s : split) {
                        int column = Integer.parseInt(s.substring(11, 13));
                        String valueAt = valuesAt[row][column];
                        String[] split1 = s.split("-");

                        StringBuilder popUp = new StringBuilder();
                        popUp.append("از ساعت");
                        popUp.append("\n");
                        String tilTime = EarthUtil.convertJulianToPersian(format2.parse(split1[0]), "HH:mm:ss");
                        popUp.append(tilTime);
                        popUp.append("\n");
                        popUp.append("تا ساعت");
                        popUp.append("\n");
                        popUp.append(split1[1]);
                        popUp.append("\n");

                        if (valueAt != null) {
                            valueAt += popUp.toString();
                            valueAt += "توسط ماهواره " + "\n" + sat.getDisplayName();
                            valueAt += "\n";
                            popUp.append("************************");
                            popUp.append("\n");
                            ResultDialog.resultTable.setValueAt("خطر", row, column);
                            valuesAt[row][column] = valueAt;
                        } else {
                            ResultDialog.resultTable.setValueAt("خطر", row, column);
                            valuesAt[row][column] = popUp.toString() + " توسط ماهواره " + "\n" + sat.getDisplayName() + "\n";
                        }
                    }

                    eachDay = new StringBuilder();
                    row++;
                } else if (parsDay - lDay < 1) {
                    eachDay.append(parse);
                    eachDay.append("-");
                    eachDay.append(untilTime);
                    eachDay.append("//");

                }
                riseTimeStr = null;
                durStr = null;
            }


        }
        System.out.println();
    }

    @SuppressWarnings("Duplicates")
    private double findSatRiseSetRoot(AbstractSatellite sat, GroundStation gs, double time0, double time1, double f0, double f1) {
        double tol = (1.157407E-5) / 4;
        while (Math.abs(time1 - time0) > 2 * tol) {
            double timeMid = (time1 + time0) / 2.0;
            double fmid = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(timeMid), timeMid)[1] - gs.getElevationConst();
            if (f0 * fmid > 0) {
                f0 = fmid;
                time0 = timeMid;

            } else {
                f1 = fmid;
                time1 = timeMid;
            }
        }
        double a = (f1 - f0) / (time1 - time0);
        double b = f1 - a * time1;
        return -b / a;

    }
    // End of variables declaration
}
