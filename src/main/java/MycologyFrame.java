 import   org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.TiesStrategy;



import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.util.Date;
import  java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.FileWriter;
import java.io.File;
import  java.io.BufferedWriter;
import  java.io.IOException;
import java.io.PrintWriter;
import  java.lang.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;


 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 7
 */





public class MycologyFrame extends javax.swing.JFrame {
int  recno =1;
String date_format;
String  Record;
/* Taxon  data fields  */
String Collector; 
JTextArea edField= new JTextArea();
String [] CollectorNo =new String[4];
String  [] Photo= new String [4];
String []Taxon= new String[4];

/* General  data fields  */
String TTL_Height,CCHeight,BF_Taste,BF_CapHght,Sporocap;
String GMCap_Width,BFCap_Width,CapSurface,SporeCap,AbHym,EntireHeight,CapWidth;
String  StemLen,CapfleshThickness,Bruising,HymeniumColor,AbHymeniumColor,photo;
String  [] Taste = new String[3];
 String  [] Odor = new String[3];             
 String Stem_Width,Stem_Base,Crown;
 
/* CAp  data fields*/
String  Spore,Hygro,Mature_Gills,Gills,Cap_Shape;
String jBFCap_Surface,Stem_Texture;        ;
/*Color  data fields */
String  Latex,Latex_Color,Shape,Surface_Text,Surface_Orn,Margin_Shape,CoM;
String Stem_Surface, Stem_Flesh, Pore_Layer;
 String [] Cap_Surface= new String [4];      
String [] Cap_Flesh=new String[4];
 String  Flesh_Const;
 String jBFCap_Flesh,jBF_BR,BJ;

/*Chemicial  data fields */
String   KOH_Cap, Melzer_Cap,KOH_Flesh,Melzer_Flesh,KOH_Partial_Veil,ASCI,Nuclei,SporeOrn;
/*   Gill  data   fields  */
String  Gill_Edge_Shape,Gill_Texture,Gill_Pattern,Gill_Thickness,Gill_Spacing;
String Gill_Attach_to_Stem;
/*Stalk  data fields*/
String [] WidthatWidestPt= new String [3];      
String [] WidthatBase =new String[3];
String GM_StalkPresent,GM_StemConsist,temp; 
String GM_StalkCharShape,GM_StalkCharFlesh,GM_StalkCharSurfText;
String    GM_StalkCharSurfOrn,Ornamentation,Surface_Texture,Stalk_tSO,SFT;
 String       Annulus,Annulus_Color,Length,Stalk,FleshColor,StalkLen,SurfaceColor;
 String   SCShape,Stalk_SO,Surface;
/*Veil  data fields*/
String Veil_Color,Gill_Veil;
/*Universal  Veil  data fields*/
String Universal_Veil_Present,Universal_Veil_Remnant,Color_Remnants;
String   Volva;
/*Branch  Char*/
 String   Rhizo,BranchConst,Flesh,Branches,Stem,Tips;

Boolean  spearman=false,wilcoxan=false, chi_squared=false,U_Test=false;
double alos;
 


    /**
     * Creates new form MycologyFrame
     */
    public MycologyFrame() {
        initComponents();
      
        
        
         jCollectorsedField.addKeyListener(new   KeyAdapter()
        {
           public void keyTyped(java.awt.event.KeyEvent evt)
           {        
           
           if( evt.getKeyCode() == KeyEvent.VK_ENTER)  
           {
              jCollectorsedField.getText();
      
        Taxonomy t= new Taxonomy(null,null,null,jCollectorsedField);}
                   
           }
        });
        
        
        
        
        
        jElfinCollectorsEdFeild.addKeyListener(new   KeyAdapter()
        {
           public void keyTyped(java.awt.event.KeyEvent evt)
           {        
           
           if( evt.getKeyCode() == KeyEvent.VK_ENTER)  
           {
              jElfinCollectorsEdFeild.getText();
      
        Taxonomy t= new Taxonomy(null,null,null,jElfinCollectorsEdFeild);}
                   
           }
        });
    
        
       jCoralFungusCollectorsEdFeild.addKeyListener(new   KeyAdapter()
        {
        
           public void keyTyped(java.awt.event.KeyEvent evt)
           {        
           
           if( evt.getKeyCode() == KeyEvent.VK_ENTER)  
           {
              jCoralFungusCollectorsEdFeild.getText();
           
        Taxonomy t= new Taxonomy(null,null,null,jCoralFungusCollectorsEdFeild);}
                   
           }
        });
    
        

        
jCoralFungusPhotoNoEdFeild.addKeyListener(new   KeyAdapter()
        {
        
           public void keyPressed(java.awt.event.KeyEvent evt)
           {        
           
           if( evt.getKeyCode() == KeyEvent.VK_ENTER)  
            Photo[3]=jCoralFungusPhotoNoEdFeild.getText();
           if (Photo[3].length()>0)
        {Taxonomy t= new Taxonomy(null,null,Photo[3],null);}
                   
           }
        });
    
                
        Date date = new Date(); //declare this above;
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy");
        date_format = format.format(date);
        date_field.setText(date_format);
         date_field2.setText(date_format);
          date_field3.setText(date_format);
             date_field4.setText(date_format);

            
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jStatisticsWindow = new javax.swing.JTabbedPane();
        jCoral_Fungus = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jCoralFungusTaxonEdFeild = new javax.swing.JTextField();
        date_field4 = new javax.swing.JTextField();
        jCoralFungusCollectionNoEdFeild = new javax.swing.JTextField();
        jCoralFungusPhotoNoEdFeild = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jCoralFungusCollectorsEdFeild = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jCoralFungusEHeightEdFeild = new javax.swing.JTextField();
        jCoralFungusCrownEdFeild = new javax.swing.JTextField();
        jCoralFungusStemBaseEdFeild = new javax.swing.JTextField();
        jCoralFungusStemWidthEdFeild = new javax.swing.JTextField();
        jCoralFungusTasteCB = new javax.swing.JComboBox<>();
        jCoralFungusOdourEdField = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jCoralFungusTipsEdFeild = new java.awt.TextField();
        jCoralFungusStemEdFeild = new java.awt.TextField();
        jCoralFungusBranchesEdFeild = new java.awt.TextField();
        jCoralFungusBrusingEdFeild = new java.awt.TextField();
        jLabel85 = new javax.swing.JLabel();
        jCoralFungusBranchJuncCB = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jCoralFungusStalkCB = new javax.swing.JComboBox<>();
        jCoralFungusBCCB = new javax.swing.JComboBox<>();
        jCoralFungusRhizoCB = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jCoralFungusFleshCCB = new javax.swing.JComboBox<>();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jCoralFungusRecNo = new java.awt.TextField();
        jElfin_Fungus = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jElfinSporocapCB = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jElfinShapeCB = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jElfinTaste = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jElfinAbhymenumCB = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jElfinOdorEdFeild = new java.awt.TextField();
        jElfinEntireHeightEdFeild = new java.awt.TextField();
        jElfiinStemLenEdFeild = new java.awt.TextField();
        jElfinCapFleshThicknessEdFeild = new java.awt.TextField();
        jElfinBruising = new java.awt.TextField();
        jElfinHymeniumCol = new java.awt.TextField();
        jElfinAbbhColorEdFeild = new java.awt.TextField();
        jElfinCapWidEdFeild = new java.awt.TextField();
        jLabel51 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jElfinASCICB = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        jElfinNucleiCB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jElfinSporeOrnCB = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jElfinRecNo = new java.awt.TextField();
        jPanel15 = new javax.swing.JPanel();
        jElfinTaxonEdFeild = new javax.swing.JTextField();
        date_field3 = new javax.swing.JTextField();
        jElfincollectorNoEdFeild = new javax.swing.JTextField();
        jElfinPhotoEdFeild = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jElfinCollectorsEdFeild = new javax.swing.JTextArea();
        jElfinSurfaceColor = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jElfinStalkCB = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jElfinStalkLenEdFeild = new java.awt.TextField();
        jElfinWWPtEdFeild = new java.awt.TextField();
        jElfinWidthatBase = new java.awt.TextField();
        jLabel38 = new javax.swing.JLabel();
        jElfinSCShapeCB = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jElfinSFTCB = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jElfinSurfaceColorEdFeild = new java.awt.TextField();
        jElfinFleshColor = new java.awt.TextField();
        jLabel60 = new javax.swing.JLabel();
        jElfinSuraceCB = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        jGilledFungus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jGeneralPanel = new javax.swing.JPanel();
        jGiBTotalHeightlbl = new javax.swing.JLabel();
        jGCapWidthlbl = new javax.swing.JLabel();
        jGMCapCentreHeightbl = new javax.swing.JLabel();
        jGilledMushroomsTotalHeightEditFielld = new javax.swing.JTextField();
        jGilledMushroomCapWidEditField = new javax.swing.JTextField();
        jGilledMushroomCapCentreHgtEdFeild = new javax.swing.JTextField();
        jGilledMushroomOdor = new javax.swing.JLabel();
        jGilledMushroomOdorCombobox = new javax.swing.JComboBox<>();
        jGilledMushroomTasteComboBox = new javax.swing.JComboBox<>();
        jGilledMuysroomTaste = new javax.swing.JLabel();
        jGMRecllbl = new java.awt.Label();
        jColorPanel = new javax.swing.JPanel();
        jGilledMushroomHygrolbl = new javax.swing.JLabel();
        jGilledMushroomHygrophanousComboBox = new javax.swing.JComboBox<>();
        jGilledMushroomCapSurfacelbl = new javax.swing.JLabel();
        jGilledMushroomSporelbl = new javax.swing.JLabel();
        jGilledMushroomStemSurfacelbl = new javax.swing.JLabel();
        jGilledMushroomCapFleshlbl = new javax.swing.JLabel();
        jGilledMushroomStemSuraceEditFeild = new javax.swing.JTextField();
        jGilledMushroomCapFleshEditFeild = new javax.swing.JTextField();
        jGilledMushroomGillslbl = new javax.swing.JLabel();
        jGilledMushroomGillsCB = new javax.swing.JComboBox<>();
        jGilledMushroomStemFleshlbl = new javax.swing.JLabel();
        jGilledMushroomStemFleshEditFeild = new javax.swing.JTextField();
        jGilledMushroomMatureGillslbl = new javax.swing.JLabel();
        jGilledMushroomSporeCB = new javax.swing.JComboBox<>();
        jGilledMushroomMGCB = new javax.swing.JComboBox<>();
        jGilledMushroomCapSurfaceEditField = new javax.swing.JTextField();
        jGBCapPanel = new javax.swing.JPanel();
        jGMSurfaceORnlbl = new javax.swing.JLabel();
        jGMFlesyConstCB = new javax.swing.JComboBox<>();
        jGMLatexColorlbl = new javax.swing.JLabel();
        jGMLatexLbl = new javax.swing.JLabel();
        jGMSuraceTxtlbl = new javax.swing.JLabel();
        jGBShapelbl = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jMGBMarginShapelbl = new javax.swing.JLabel();
        jGMMarginShapeCB = new javax.swing.JComboBox<>();
        label10 = new java.awt.Label();
        jGMLatexCB = new javax.swing.JComboBox<>();
        jGMSurfaceTextCB = new javax.swing.JComboBox<>();
        jGMShapeCB = new javax.swing.JComboBox<>();
        jGMLatexColorEdFld = new javax.swing.JTextField();
        jGMSurfaceOrnCB = new javax.swing.JComboBox<>();
        jGBMarginContlbl = new javax.swing.JLabel();
        jGMMarginContourCB = new javax.swing.JComboBox<>();
        jGBFleshConstlbl = new javax.swing.JLabel();
        jGBVeilColorlbl = new javax.swing.JPanel();
        jGB_VeilColorlbl = new javax.swing.JLabel();
        juGBVeillbl = new javax.swing.JLabel();
        jGMVeilCB = new javax.swing.JComboBox<>();
        jGMVeilColorEdFld = new javax.swing.JTextField();
        jGBGillCharPanel = new javax.swing.JPanel();
        jGBGillEdgeShapelbl = new javax.swing.JLabel();
        jGBGilltexturelbl = new javax.swing.JLabel();
        jGBGillPaternlbl = new javax.swing.JLabel();
        jGMGillPatternCB = new javax.swing.JComboBox<>();
        jGMGillAttachToStemCB = new javax.swing.JComboBox<>();
        jGMGillTextureCB = new javax.swing.JComboBox<>();
        jGMGillEdgeShapeCB = new javax.swing.JComboBox<>();
        jGBGillThicknesslbl = new javax.swing.JLabel();
        jGMThicknessCB = new javax.swing.JComboBox<>();
        jGBGillSpacinglbl = new javax.swing.JLabel();
        jGBGillAttachToStemlbl = new javax.swing.JLabel();
        jGMGillSpacingCB = new javax.swing.JComboBox<>();
        jGMUniversalVeilPanel = new javax.swing.JPanel();
        jGMUniversalVeilPreslbl = new javax.swing.JLabel();
        jGMUniversalVeilPresCB = new javax.swing.JComboBox<>();
        jGMUniversalVeilRemlbl = new javax.swing.JLabel();
        jGMUniversalVeilRemCB = new javax.swing.JComboBox<>();
        jGBVolvalbl = new javax.swing.JLabel();
        jGMColorRemlbl = new javax.swing.JLabel();
        jGMColorRemEdFeild = new javax.swing.JTextField();
        jGMVolvaCB = new javax.swing.JComboBox<>();
        jGBCapCharTitlelbl = new javax.swing.JLabel();
        jGBGillCharlbl = new javax.swing.JLabel();
        jGMTaxonPanel = new javax.swing.JPanel();
        jGilledMushroomsTaxonEdFeild = new javax.swing.JTextField();
        date_field = new javax.swing.JTextField();
        jGilledMushroomColEdField = new javax.swing.JTextField();
        jGilledMushroomsPhotoEdFeild = new javax.swing.JTextField();
        jGMTaxonlbl = new javax.swing.JLabel();
        jGMDateFeildlbl = new javax.swing.JLabel();
        jGMPhotolbl = new javax.swing.JLabel();
        jGMCollectorslbl = new javax.swing.JLabel();
        jGM_CollectorsEdField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jGMVeilTitlelbl = new javax.swing.JLabel();
        jGMUniversalVeilTitlelbl = new javax.swing.JLabel();
        jGM_RecDisplay = new javax.swing.JTextField();
        jGMGenralCharTitlelbl = new javax.swing.JLabel();
        jGMStalkPanel = new javax.swing.JPanel();
        jGMWidthatWidPtEdFld = new javax.swing.JTextField();
        jGMWidttatBaseEdFld = new javax.swing.JTextField();
        jGMStalkPresentlbl = new javax.swing.JLabel();
        jGMWidthatWidPtlbl = new javax.swing.JLabel();
        jGMStalkPresentCB = new javax.swing.JComboBox<>();
        jGMWidthatBaselbl = new javax.swing.JLabel();
        jGMStalkCharShapelbl = new javax.swing.JLabel();
        jGMStalkCharShapeCB = new javax.swing.JComboBox<>();
        jGMStalkCharFleshTextlbl = new javax.swing.JLabel();
        jGBStalkCharFleshTextCB = new javax.swing.JComboBox<>();
        jGMStalkCharSurfTextCB = new javax.swing.JComboBox<>();
        jGMStalkCharSurfTextlbl = new javax.swing.JLabel();
        jGMStalkiCharStemConsistlbl = new javax.swing.JLabel();
        jGMStemConstCB = new javax.swing.JComboBox<>();
        jGMSurfaceOrnlbl = new javax.swing.JLabel();
        jStalkCharSurfOrnCB = new javax.swing.JComboBox<>();
        jGMStalkCharTitlelbl = new javax.swing.JLabel();
        jGMChemCharlTiledbl = new javax.swing.JLabel();
        jGMChemicalPanel = new javax.swing.JPanel();
        jGMKOHEdFld = new javax.swing.JTextField();
        jGMelzersCapSurfEdFld = new javax.swing.JTextField();
        jGMKOHCaplbl = new javax.swing.JLabel();
        jGMMelCapSurlbl = new javax.swing.JLabel();
        jGMKOHFleshlbl = new javax.swing.JLabel();
        jGMKOHFleshEdFld = new javax.swing.JTextField();
        jGMMelzersFleshlbl = new javax.swing.JLabel();
        jGMMelzersFleshEdFld = new javax.swing.JTextField();
        jGMKOHPVlbl = new javax.swing.JLabel();
        jGMKOHParitalVeilEdFld = new javax.swing.JTextField();
        jGMCapCharTittlelbl = new javax.swing.JLabel();
        jGMTaxonTittlelbl = new javax.swing.JLabel();
        jBoleteFungi = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jBCapWidth = new javax.swing.JTextField();
        jBoleteSporoCapCB = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBCapHeight = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jBFTasteCB = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jBFsmelllEdField = new javax.swing.JTextField();
        BoleteRecNo = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBFTaxonEdField = new javax.swing.JTextField();
        date_field2 = new javax.swing.JTextField();
        jBFCollectNoEdFld = new javax.swing.JTextField();
        jPhotoNoEdFeild = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jCollectorsedField = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jBFCapSurface = new java.awt.TextField();
        jBGCapFleshEdField = new java.awt.TextField();
        PoreLayer = new java.awt.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jBFStemSurface = new java.awt.TextField();
        jBFStemFlesh = new java.awt.TextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jBFBruisingEdFeild = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jBoleteCSComboBox = new javax.swing.JComboBox<>();
        jBoleteCapShapeCB = new javax.swing.JComboBox<>();
        jBoleteFleshConstCB = new javax.swing.JComboBox<>();
        jBoleteSurfaceOrnCB = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jBoleteWidthatWidestPt = new javax.swing.JTextField();
        jBoleteWidthatBase = new javax.swing.JTextField();
        jBoleteSCLengthEdFeild = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jBoleteAnnulusColor = new javax.swing.JTextField();
        jBoleteOrnamentionCB = new javax.swing.JComboBox<>();
        jBoleteAnnulusCB = new javax.swing.JComboBox<>();
        jBoleteStalkSurfaceOrnCB = new javax.swing.JComboBox<>();
        jBoleteSurfaceTextureCB = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jWriteButton = new javax.swing.JButton();
        jClearBtn = new javax.swing.JButton();
        jNewRecBtn = new javax.swing.JButton();
        jDBPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jChiSquaredRadBut = new javax.swing.JRadioButton();
        jSpearmanBut = new javax.swing.JRadioButton();
        jWilcoxanBut = new javax.swing.JRadioButton();
        jManWhitneyUTest = new javax.swing.JRadioButton();
        jGTestRadioBut = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel97 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jALOSCB = new javax.swing.JComboBox<>();
        jPerformTests = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jDBPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mycology Forms  Pro 1.0");
        setBackground(new java.awt.Color(229, 95, 95));
        setForeground(new java.awt.Color(207, 132, 57));
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(1010, 1000));
        setResizable(false);

        jStatisticsWindow.setBackground(new java.awt.Color(255, 85, 63));
        jStatisticsWindow.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jStatisticsWindow.setForeground(new java.awt.Color(102, 81, 78));
        jStatisticsWindow.setFont(new java.awt.Font("PT Serif", 1, 14)); // NOI18N
        jStatisticsWindow.setPreferredSize(new java.awt.Dimension(709, 900));

        jPanel2.setBackground(new java.awt.Color(73, 168, 64));

        jPanel10.setBackground(new java.awt.Color(194, 67, 38));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel10.setName("Taxonomy"); // NOI18N

        jCoralFungusTaxonEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusTaxonEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusTaxonEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusTaxonEdFeildKeyTyped(evt);
            }
        });

        date_field4.setEditable(false);
        date_field4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_field4ActionPerformed(evt);
            }
        });

        jCoralFungusCollectionNoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusCollectionNoEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusCollectionNoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusCollectionNoEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusPhotoNoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusPhotoNoEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusPhotoNoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusPhotoNoEdFeildKeyTyped(evt);
            }
        });

        jLabel67.setForeground(new java.awt.Color(240, 227, 227));
        jLabel67.setText("Taxon");

        jLabel68.setForeground(new java.awt.Color(229, 208, 208));
        jLabel68.setText("Date");

        jLabel70.setForeground(new java.awt.Color(238, 202, 202));
        jLabel70.setText("Collector(s)");

        jLabel71.setForeground(new java.awt.Color(235, 211, 211));
        jLabel71.setText("Colection No:");

        jLabel72.setForeground(new java.awt.Color(228, 206, 206));
        jLabel72.setText("Photo  No:");

        jCoralFungusCollectorsEdFeild.setColumns(20);
        jCoralFungusCollectorsEdFeild.setRows(5);
        jCoralFungusCollectorsEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusCollectorsEdFeildKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(jCoralFungusCollectorsEdFeild);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel71)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel68))
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCoralFungusPhotoNoEdFeild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(date_field4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addComponent(jCoralFungusTaxonEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCoralFungusCollectionNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusTaxonEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(date_field4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusCollectionNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusPhotoNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(194, 67, 38));

        jCoralFungusEHeightEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusEHeightEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusEHeightEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusEHeightEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusCrownEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusCrownEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusCrownEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusCrownEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusStemBaseEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusStemBaseEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusStemBaseEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusStemBaseEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusStemWidthEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusStemWidthEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusStemWidthEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusStemWidthEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusTasteCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mild", "Strong", "Plesant", "Unpleasant", "Acrid" }));
        jCoralFungusTasteCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusTasteCBActionPerformed(evt);
            }
        });

        jCoralFungusOdourEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusOdourEdFieldActionPerformed(evt);
            }
        });
        jCoralFungusOdourEdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusOdourEdFieldKeyTyped(evt);
            }
        });

        jLabel73.setForeground(new java.awt.Color(247, 239, 239));
        jLabel73.setText("Entire Height");

        jLabel74.setForeground(new java.awt.Color(240, 227, 227));
        jLabel74.setText("Crown Diameter");

        jLabel75.setForeground(new java.awt.Color(243, 233, 233));
        jLabel75.setText("Stem  base Width");

        jLabel76.setForeground(new java.awt.Color(249, 246, 246));
        jLabel76.setText("Stem  width");

        jLabel77.setForeground(new java.awt.Color(240, 226, 226));
        jLabel77.setText("Odour");

        jLabel78.setForeground(new java.awt.Color(237, 213, 213));
        jLabel78.setText("Taste");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel74))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCoralFungusCrownEdFeild)
                                    .addComponent(jCoralFungusEHeightEdFeild)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel75)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77))))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCoralFungusTasteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jCoralFungusOdourEdField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(jCoralFungusStemWidthEdFeild)))
                                .addComponent(jCoralFungusStemBaseEdFeild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusEHeightEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusCrownEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusStemBaseEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusStemWidthEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCoralFungusOdourEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78)
                    .addComponent(jCoralFungusTasteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(229, 204, 204));
        jLabel79.setText("General  Characteristics");
        jLabel79.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(231, 204, 204));
        jLabel80.setText("Taxonomy");
        jLabel80.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel14.setBackground(new java.awt.Color(197, 64, 38));

        jLabel81.setForeground(new java.awt.Color(228, 211, 211));
        jLabel81.setText("Tips");

        jLabel82.setForeground(new java.awt.Color(229, 212, 212));
        jLabel82.setText("Stem");

        jLabel83.setForeground(new java.awt.Color(237, 215, 215));
        jLabel83.setText("Branches");

        jLabel84.setForeground(new java.awt.Color(244, 229, 229));
        jLabel84.setText("Bruising");

        jCoralFungusTipsEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusTipsEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusTipsEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusTipsEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusStemEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusStemEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusStemEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusStemEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusBranchesEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusBranchesEdFeildActionPerformed(evt);
            }
        });
        jCoralFungusBranchesEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCoralFungusBranchesEdFeildKeyTyped(evt);
            }
        });

        jCoralFungusBrusingEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusBrusingEdFeildActionPerformed(evt);
            }
        });

        jLabel85.setForeground(new java.awt.Color(228, 200, 200));
        jLabel85.setText("Yellow  band at stem  & Branch junction");

        jCoralFungusBranchJuncCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jCoralFungusBranchJuncCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusBranchJuncCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83)
                            .addComponent(jLabel84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCoralFungusBrusingEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCoralFungusBranchesEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addComponent(jLabel82))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCoralFungusTipsEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jCoralFungusStemEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel85)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCoralFungusBranchJuncCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel81))
                            .addComponent(jCoralFungusTipsEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCoralFungusStemEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83)
                            .addComponent(jCoralFungusBranchesEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCoralFungusBrusingEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel84)))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel85)
                        .addComponent(jCoralFungusBranchJuncCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel86.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(238, 227, 227));
        jLabel86.setText("Surface  Color  Characteristics");
        jLabel86.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel16.setBackground(new java.awt.Color(197, 64, 36));

        jCoralFungusStalkCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Slender", "Fused", "Fasced", "?" }));
        jCoralFungusStalkCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusStalkCBActionPerformed(evt);
            }
        });

        jCoralFungusBCCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Firm", "Fraagile", "Flesy fibriouis", "CartiligiouisBrittl", "Rubbery", "Firm  gelatinous", "Slimy  gelatinous" }));
        jCoralFungusBCCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusBCCBActionPerformed(evt);
            }
        });

        jCoralFungusRhizoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jCoralFungusRhizoCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusRhizoCBActionPerformed(evt);
            }
        });

        jLabel87.setForeground(new java.awt.Color(229, 211, 211));
        jLabel87.setText("Stalk  Form");

        jLabel88.setForeground(new java.awt.Color(232, 207, 207));
        jLabel88.setText("Flesh Constituency");

        jLabel89.setForeground(new java.awt.Color(237, 208, 208));
        jLabel89.setText("Branch  consituency");

        jLabel90.setForeground(new java.awt.Color(228, 212, 212));
        jLabel90.setText("Rhizomorps  Present");

        jCoralFungusFleshCCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solid", "Hollow", "Fleshy fibrious", "Brittle", "Rubbery  Fibrilous", "Firm", "cartiligiouis", "Slimy  cartiligiious", "Marbled cartiligious" }));
        jCoralFungusFleshCCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCoralFungusFleshCCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel87)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCoralFungusStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel88)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCoralFungusFleshCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCoralFungusRhizoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jCoralFungusBCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jCoralFungusStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCoralFungusBCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel89))))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jCoralFungusRhizoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90)
                    .addComponent(jCoralFungusFleshCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jLabel91.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(229, 212, 212));
        jLabel91.setText("Branch   &  Stalk  Characteristics");
        jLabel91.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel92.setText("jLabel92");

        jCoralFungusRecNo.setText("textField5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel91)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel86))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel92)
                                .addGap(18, 18, 18)
                                .addComponent(jCoralFungusRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel79)))
                        .addGap(102, 102, 102)
                        .addComponent(jLabel80))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(jCoralFungusRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel86)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel91)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jCoral_FungusLayout = new javax.swing.GroupLayout(jCoral_Fungus);
        jCoral_Fungus.setLayout(jCoral_FungusLayout);
        jCoral_FungusLayout.setHorizontalGroup(
            jCoral_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jCoral_FungusLayout.setVerticalGroup(
            jCoral_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jCoral_FungusLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jStatisticsWindow.addTab("Coral Fungus", jCoral_Fungus);

        jPanel9.setBackground(new java.awt.Color(22, 223, 18));

        jPanel11.setBackground(new java.awt.Color(15, 54, 194));

        jElfinSporocapCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elfin Saddle", "Cup" }));
        jElfinSporocapCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSporocapCBActionPerformed(evt);
            }
        });

        jLabel39.setForeground(new java.awt.Color(237, 218, 218));
        jLabel39.setText("Sporo Cap");

        jLabel40.setForeground(new java.awt.Color(237, 218, 218));
        jLabel40.setText("Shape");

        jElfinShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cup", "Dish", "Cushion", "Rabbit Ear", "Truncate", "Club", "Spatulate", "Saddle Spatulate", "Brain Stipulate", "Pitted Stipulate" }));
        jElfinShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinShapeCBActionPerformed(evt);
            }
        });

        jLabel41.setForeground(new java.awt.Color(234, 222, 222));
        jLabel41.setText("Taste");

        jElfinTaste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mild", "Strong", "Sweet", "Bitter", "Pepper" }));
        jElfinTaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinTasteActionPerformed(evt);
            }
        });

        jLabel42.setForeground(new java.awt.Color(232, 210, 210));
        jLabel42.setText("Abhymenm  Texture ");

        jElfinAbhymenumCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smooth", "Pubecent", "slimy", "Grannular", "Warty", "Fibrillious", "Grasy", "Sticky", "Dry", "Sily", "Hygrophanous" }));
        jElfinAbhymenumCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinAbhymenumCBActionPerformed(evt);
            }
        });

        jLabel43.setForeground(new java.awt.Color(229, 212, 212));
        jLabel43.setText("Odor");

        jLabel44.setForeground(new java.awt.Color(234, 212, 212));
        jLabel44.setText("Cap Width");

        jLabel45.setForeground(new java.awt.Color(234, 207, 207));
        jLabel45.setText("Stem Length");

        jLabel46.setForeground(new java.awt.Color(235, 223, 223));
        jLabel46.setText("Cap Flesh Thickness");

        jLabel47.setForeground(new java.awt.Color(238, 219, 219));
        jLabel47.setText("Flesh color  & Bruising");

        jLabel48.setForeground(new java.awt.Color(234, 216, 216));
        jLabel48.setText("Entire  Height");

        jLabel49.setForeground(new java.awt.Color(231, 204, 204));
        jLabel49.setText("Hymenium  Color");

        jLabel50.setForeground(new java.awt.Color(234, 222, 222));
        jLabel50.setText("Abhymenium Color");

        jElfinOdorEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinOdorEdFeildActionPerformed(evt);
            }
        });
        jElfinOdorEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinOdorEdFeildKeyTyped(evt);
            }
        });

        jElfinEntireHeightEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinEntireHeightEdFeildActionPerformed(evt);
            }
        });
        jElfinEntireHeightEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinEntireHeightEdFeildKeyTyped(evt);
            }
        });

        jElfiinStemLenEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfiinStemLenEdFeildActionPerformed(evt);
            }
        });
        jElfiinStemLenEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfiinStemLenEdFeildKeyTyped(evt);
            }
        });

        jElfinCapFleshThicknessEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinCapFleshThicknessEdFeildActionPerformed(evt);
            }
        });
        jElfinCapFleshThicknessEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinCapFleshThicknessEdFeildKeyTyped(evt);
            }
        });

        jElfinBruising.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinBruisingActionPerformed(evt);
            }
        });
        jElfinBruising.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinBruisingKeyTyped(evt);
            }
        });

        jElfinHymeniumCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinHymeniumColActionPerformed(evt);
            }
        });

        jElfinAbbhColorEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinAbbhColorEdFeildActionPerformed(evt);
            }
        });

        jElfinCapWidEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinCapWidEdFeildActionPerformed(evt);
            }
        });
        jElfinCapWidEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinCapWidEdFeildKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel39)))
                .addGap(67, 67, 67)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jElfinShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jElfinSporocapCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jElfinTaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel45))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jElfiinStemLenEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55))
                            .addComponent(jElfinCapFleshThicknessEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jElfinCapWidEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel43))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jElfinOdorEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jElfinEntireHeightEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel50)))
                        .addGap(29, 29, 29)
                        .addComponent(jElfinAbbhColorEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jElfinAbhymenumCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jElfinBruising, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jElfinHymeniumCol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jElfinSporocapCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jElfinCapWidEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jElfinShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45))
                    .addComponent(jElfiinStemLenEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(jElfinTaste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46))
                    .addComponent(jElfinCapFleshThicknessEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jElfinAbhymenumCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jElfinOdorEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jElfinEntireHeightEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addComponent(jElfinBruising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jElfinHymeniumCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jElfinAbbhColorEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(12, 25, 120));
        jLabel51.setText("General Characteristics");
        jLabel51.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel12.setBackground(new java.awt.Color(15, 54, 194));

        jLabel52.setForeground(new java.awt.Color(237, 218, 218));
        jLabel52.setText("ASCI  stqain in I");

        jElfinASCICB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Amyloid", "Dephanoid" }));
        jElfinASCICB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinASCICBActionPerformed(evt);
            }
        });

        jLabel53.setForeground(new java.awt.Color(226, 198, 198));
        jLabel53.setText("Nuclei beded in Acetocarmine");

        jElfinNucleiCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "N" }));
        jElfinNucleiCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinNucleiCBActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(15, 54, 194));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(237, 212, 216));
        jTextArea1.setRows(5);
        jTextArea1.setText("Spore ornamentation staining  in\ncotton of aniline blue in lactin \nacid or lactin phenoil");
        jScrollPane2.setViewportView(jTextArea1);

        jElfinSporeOrnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Y", "N" }));
        jElfinSporeOrnCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSporeOrnCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jElfinSporeOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jElfinNucleiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jElfinASCICB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jElfinASCICB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel53)
                    .addComponent(jElfinNucleiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jElfinSporeOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel54.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(12, 25, 120));
        jLabel54.setText("Chemical  Properties");
        jLabel54.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(12, 25, 120));
        jLabel55.setText("Taxon Data");
        jLabel55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel56.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(12, 25, 120));
        jLabel56.setText("Rec No:");
        jLabel56.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel15.setBackground(new java.awt.Color(15, 54, 194));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel15.setName("Taxonomy"); // NOI18N

        jElfinTaxonEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinTaxonEdFeildActionPerformed(evt);
            }
        });
        jElfinTaxonEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinTaxonEdFeildKeyTyped(evt);
            }
        });

        date_field3.setEditable(false);
        date_field3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_field3ActionPerformed(evt);
            }
        });

        jElfincollectorNoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfincollectorNoEdFeildActionPerformed(evt);
            }
        });
        jElfincollectorNoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfincollectorNoEdFeildKeyTyped(evt);
            }
        });

        jElfinPhotoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinPhotoEdFeildActionPerformed(evt);
            }
        });
        jElfinPhotoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinPhotoEdFeildKeyTyped(evt);
            }
        });

        jLabel62.setForeground(new java.awt.Color(232, 211, 211));
        jLabel62.setText("Taxon");

        jLabel63.setForeground(new java.awt.Color(238, 223, 223));
        jLabel63.setText("Date");

        jLabel64.setForeground(new java.awt.Color(234, 211, 211));
        jLabel64.setText("Collector(s)");

        jLabel65.setForeground(new java.awt.Color(235, 218, 218));
        jLabel65.setText("Colection No:");

        jLabel66.setForeground(new java.awt.Color(240, 220, 220));
        jLabel66.setText("Photo  No:");

        jElfinCollectorsEdFeild.setColumns(20);
        jElfinCollectorsEdFeild.setRows(5);
        jScrollPane6.setViewportView(jElfinCollectorsEdFeild);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel66)
                            .addComponent(jLabel65)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63))
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jElfinPhotoEdFeild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(date_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addComponent(jElfinTaxonEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jElfincollectorNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jElfinTaxonEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(date_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jElfincollectorNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jElfinPhotoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jElfinSurfaceColor.setBackground(new java.awt.Color(15, 54, 194));

        jLabel34.setForeground(new java.awt.Color(235, 212, 212));
        jLabel34.setText("Stalk Present");

        jElfinStalkCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jElfinStalkCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinStalkCBActionPerformed(evt);
            }
        });

        jLabel35.setForeground(new java.awt.Color(243, 213, 213));
        jLabel35.setText("Length");

        jLabel36.setForeground(new java.awt.Color(240, 223, 223));
        jLabel36.setText("Width at Widest Pt");

        jLabel37.setForeground(new java.awt.Color(237, 224, 224));
        jLabel37.setText("Width at Base ");

        jElfinStalkLenEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinStalkLenEdFeildActionPerformed(evt);
            }
        });
        jElfinStalkLenEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinStalkLenEdFeildKeyTyped(evt);
            }
        });

        jElfinWWPtEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinWWPtEdFeildActionPerformed(evt);
            }
        });
        jElfinWWPtEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinWWPtEdFeildKeyTyped(evt);
            }
        });

        jElfinWidthatBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinWidthatBaseActionPerformed(evt);
            }
        });
        jElfinWidthatBase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinWidthatBaseKeyTyped(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(235, 212, 212));
        jLabel38.setText("Shape");

        jElfinSCShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equal", "Ventricule", "Tapered at Vertex", "Tapered  at base", "Compresed" }));
        jElfinSCShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSCShapeCBActionPerformed(evt);
            }
        });

        jLabel57.setForeground(new java.awt.Color(243, 226, 226));
        jLabel57.setText("Stem flesh  Texture");

        jElfinSFTCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gelatinous", "Frim", "Solid", "Stuffed", "Hollow" }));
        jElfinSFTCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSFTCBActionPerformed(evt);
            }
        });

        jLabel58.setForeground(new java.awt.Color(241, 219, 219));
        jLabel58.setText("Flesh    Color");

        jLabel59.setForeground(new java.awt.Color(231, 216, 216));
        jLabel59.setText("Surface Color");

        jElfinSurfaceColorEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSurfaceColorEdFeildActionPerformed(evt);
            }
        });
        jElfinSurfaceColorEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinSurfaceColorEdFeildKeyTyped(evt);
            }
        });

        jElfinFleshColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinFleshColorActionPerformed(evt);
            }
        });
        jElfinFleshColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jElfinFleshColorKeyTyped(evt);
            }
        });

        jLabel60.setForeground(new java.awt.Color(237, 212, 212));
        jLabel60.setText("Surface");

        jElfinSuraceCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dry", "Moist", "Viscid", "Smooth", "Tomentose", "Ribbed", "Scaly", "Folded", "Wrinkkled", "Fibrilious" }));
        jElfinSuraceCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jElfinSuraceCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jElfinSurfaceColorLayout = new javax.swing.GroupLayout(jElfinSurfaceColor);
        jElfinSurfaceColor.setLayout(jElfinSurfaceColorLayout);
        jElfinSurfaceColorLayout.setHorizontalGroup(
            jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jElfinStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jElfinSurfaceColorLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jElfinStalkLenEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jElfinWWPtEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jElfinWidthatBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(84, 84, 84)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jElfinSCShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel60))
                                .addGap(31, 31, 31)
                                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jElfinSurfaceColorEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jElfinFleshColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jElfinSuraceCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jElfinSFTCB, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jElfinSurfaceColorLayout.setVerticalGroup(
            jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jElfinStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jElfinStalkLenEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jElfinSCShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jElfinSFTCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jElfinWWPtEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jElfinWidthatBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jElfinSurfaceColorEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addGroup(jElfinSurfaceColorLayout.createSequentialGroup()
                                .addComponent(jElfinFleshColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jElfinSurfaceColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jElfinSuraceCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(12, 25, 120));
        jLabel61.setText("Stalk  Characteristics");
        jLabel61.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jElfinRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel54)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel55))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jElfinSurfaceColor, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1587, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addComponent(jElfinRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61)
                .addGap(7, 7, 7)
                .addComponent(jElfinSurfaceColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jElfin_FungusLayout = new javax.swing.GroupLayout(jElfin_Fungus);
        jElfin_Fungus.setLayout(jElfin_FungusLayout);
        jElfin_FungusLayout.setHorizontalGroup(
            jElfin_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jElfin_FungusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jElfin_FungusLayout.setVerticalGroup(
            jElfin_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jStatisticsWindow.addTab("Elfin  Fungus", jElfin_Fungus);

        jGilledFungus.setForeground(new java.awt.Color(102, 102, 102));

        jScrollPane1.setBackground(new java.awt.Color(102, 0, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setForeground(new java.awt.Color(72, 26, 204));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 190, 85));
        jPanel1.setForeground(new java.awt.Color(0, 0, 102));

        jGeneralPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGeneralPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jGeneralPanel.setForeground(new java.awt.Color(222, 237, 249));

        jGiBTotalHeightlbl.setText("Total   Height ");

        jGCapWidthlbl.setText("Cap  Width");

        jGMCapCentreHeightbl.setText("Cap centre  height");

        jGilledMushroomsTotalHeightEditFielld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomsTotalHeightEditFielldActionPerformed(evt);
            }
        });
        jGilledMushroomsTotalHeightEditFielld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomsTotalHeightEditFielldKeyTyped(evt);
            }
        });

        jGilledMushroomCapWidEditField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomCapWidEditFieldActionPerformed(evt);
            }
        });
        jGilledMushroomCapWidEditField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomCapWidEditFieldKeyTyped(evt);
            }
        });

        jGilledMushroomCapCentreHgtEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomCapCentreHgtEdFeildActionPerformed(evt);
            }
        });
        jGilledMushroomCapCentreHgtEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomCapCentreHgtEdFeildKeyTyped(evt);
            }
        });

        jGilledMushroomOdor.setText("Odour");

        jGilledMushroomOdorCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGilledMushroomOdorCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomOdorComboboxActionPerformed(evt);
            }
        });

        jGilledMushroomTasteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mild", "Strong", "Pleasant", "Peppery" }));
        jGilledMushroomTasteComboBox.setName("Taste"); // NOI18N
        jGilledMushroomTasteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomTasteComboBoxActionPerformed(evt);
            }
        });

        jGilledMuysroomTaste.setText("Taste");

        javax.swing.GroupLayout jGeneralPanelLayout = new javax.swing.GroupLayout(jGeneralPanel);
        jGeneralPanel.setLayout(jGeneralPanelLayout);
        jGeneralPanelLayout.setHorizontalGroup(
            jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGeneralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGeneralPanelLayout.createSequentialGroup()
                        .addComponent(jGilledMushroomOdor)
                        .addGap(78, 78, 78)
                        .addComponent(jGilledMuysroomTaste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGilledMushroomTasteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(jGeneralPanelLayout.createSequentialGroup()
                        .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jGeneralPanelLayout.createSequentialGroup()
                                    .addComponent(jGiBTotalHeightlbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jGilledMushroomsTotalHeightEditFielld))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGeneralPanelLayout.createSequentialGroup()
                                    .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jGilledMushroomOdorCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGMCapCentreHeightbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(67, 67, 67)))
                            .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jGilledMushroomCapCentreHgtEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jGeneralPanelLayout.createSequentialGroup()
                                    .addComponent(jGCapWidthlbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jGilledMushroomCapWidEditField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jGeneralPanelLayout.setVerticalGroup(
            jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGeneralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGeneralPanelLayout.createSequentialGroup()
                        .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGiBTotalHeightlbl)
                            .addComponent(jGilledMushroomsTotalHeightEditFielld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGCapWidthlbl)
                            .addComponent(jGilledMushroomCapWidEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGMCapCentreHeightbl)
                            .addComponent(jGilledMushroomCapCentreHgtEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGilledMushroomOdor)
                            .addComponent(jGilledMushroomOdorCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGeneralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGilledMuysroomTaste)
                        .addComponent(jGilledMushroomTasteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jGMRecllbl.setText("Record  #");

        jColorPanel.setBackground(new java.awt.Color(84, 54, 42));
        jColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGilledMushroomHygrolbl.setText("Hygrophanous");

        jGilledMushroomHygrophanousComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGilledMushroomHygrophanousComboBox.setName("hygrophanus"); // NOI18N
        jGilledMushroomHygrophanousComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomHygrophanousComboBoxActionPerformed(evt);
            }
        });

        jGilledMushroomCapSurfacelbl.setText("Cap surface");

        jGilledMushroomSporelbl.setText("Spore Print");

        jGilledMushroomStemSurfacelbl.setText("Stem  Surface");

        jGilledMushroomCapFleshlbl.setText("Cap  Flesh");

        jGilledMushroomStemSuraceEditFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomStemSuraceEditFeildActionPerformed(evt);
            }
        });
        jGilledMushroomStemSuraceEditFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomStemSuraceEditFeildKeyTyped(evt);
            }
        });

        jGilledMushroomCapFleshEditFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomCapFleshEditFeildActionPerformed(evt);
            }
        });
        jGilledMushroomCapFleshEditFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomCapFleshEditFeildKeyTyped(evt);
            }
        });

        jGilledMushroomGillslbl.setText("Gills");

        jGilledMushroomGillsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concolorous", "lLighter", "Darker" }));
        jGilledMushroomGillsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomGillsCBActionPerformed(evt);
            }
        });

        jGilledMushroomStemFleshlbl.setText("Stem Flesh");

        jGilledMushroomStemFleshEditFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomStemFleshEditFeildActionPerformed(evt);
            }
        });
        jGilledMushroomStemFleshEditFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomStemFleshEditFeildKeyTyped(evt);
            }
        });

        jGilledMushroomMatureGillslbl.setText("Mature Gills ");

        jGilledMushroomSporeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGilledMushroomSporeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomSporeCBActionPerformed(evt);
            }
        });

        jGilledMushroomMGCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGilledMushroomMGCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomMGCBActionPerformed(evt);
            }
        });

        jGilledMushroomCapSurfaceEditField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomCapSurfaceEditFieldActionPerformed(evt);
            }
        });
        jGilledMushroomCapSurfaceEditField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomCapSurfaceEditFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jColorPanelLayout = new javax.swing.GroupLayout(jColorPanel);
        jColorPanel.setLayout(jColorPanelLayout);
        jColorPanelLayout.setHorizontalGroup(
            jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jColorPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jGilledMushroomStemFleshlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGilledMushroomStemFleshEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jColorPanelLayout.createSequentialGroup()
                        .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addComponent(jGilledMushroomCapSurfacelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGilledMushroomCapSurfaceEditField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jColorPanelLayout.createSequentialGroup()
                                        .addComponent(jGilledMushroomCapFleshlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jGilledMushroomCapFleshEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jColorPanelLayout.createSequentialGroup()
                                        .addComponent(jGilledMushroomStemSurfacelbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jGilledMushroomStemSuraceEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jGilledMushroomGillslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGilledMushroomHygrolbl))))
                    .addGroup(jColorPanelLayout.createSequentialGroup()
                        .addComponent(jGilledMushroomSporelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGilledMushroomSporeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jGilledMushroomMatureGillslbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGilledMushroomGillsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGilledMushroomMGCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jColorPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jGilledMushroomHygrophanousComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jColorPanelLayout.setVerticalGroup(
            jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jColorPanelLayout.createSequentialGroup()
                        .addComponent(jGilledMushroomCapFleshlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jColorPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGilledMushroomHygrophanousComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGilledMushroomHygrolbl)
                            .addComponent(jGilledMushroomCapFleshEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addComponent(jGilledMushroomCapSurfacelbl)
                                .addGap(20, 20, 20)
                                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGilledMushroomStemSurfacelbl)
                                    .addComponent(jGilledMushroomStemSuraceEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jGilledMushroomCapSurfaceEditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jGilledMushroomGillslbl)
                                .addComponent(jGilledMushroomGillsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGilledMushroomMatureGillslbl)
                                    .addComponent(jGilledMushroomMGCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jColorPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jGilledMushroomSporelbl)
                                    .addComponent(jGilledMushroomSporeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)))
                .addGroup(jColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGilledMushroomStemFleshEditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGilledMushroomStemFleshlbl))
                .addGap(138, 138, 138))
        );

        jGBCapPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGBCapPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGMSurfaceORnlbl.setText("Surface  Ornaamentation");

        jGMFlesyConstCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fleshy", "Brittle", "Spongy", "Tough", "Chalky" }));
        jGMFlesyConstCB.setName("hygrophanus"); // NOI18N
        jGMFlesyConstCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMFlesyConstCBActionPerformed(evt);
            }
        });

        jGMLatexColorlbl.setText("Latex  Color");

        jGMLatexLbl.setText("Latex");

        jGMSuraceTxtlbl.setText("Surface  Texture");

        jGBShapelbl.setText("Shape");

        jMGBMarginShapelbl.setText("Margin  Shape");

        jGMMarginShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Straight", "Uplifted", "Recurved", "Inrolled", "Incurved" }));
        jGMMarginShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMMarginShapeCBActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label10.setForeground(new java.awt.Color(255, 255, 255));
        label10.setName(""); // NOI18N
        label10.setText("Cap  Characteriistics");

        jGMLatexCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGMLatexCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMLatexCBActionPerformed(evt);
            }
        });

        jGMSurfaceTextCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dry", "Greasy", "Sticky", "Slimy" }));
        jGMSurfaceTextCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMSurfaceTextCBActionPerformed(evt);
            }
        });

        jGMShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bell Shaped", "Convex", "Cylindrical", "Depressed", "Funnel", "Mammiliate", "Umnilicate", "Umbonate", "Upturned" }));
        jGMShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMShapeCBActionPerformed(evt);
            }
        });

        jGMLatexColorEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMLatexColorEdFldActionPerformed(evt);
            }
        });

        jGMSurfaceOrnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smooth", "Pubescent", "Fibrilose", "Cracked", "Wrickled", "Scaly" }));
        jGMSurfaceOrnCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMSurfaceOrnCBActionPerformed(evt);
            }
        });

        jGBMarginContlbl.setText("Contours of Margins");

        jGMMarginContourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Striate", "Even", "Wavy", "Irregulate", "Appendiculate" }));
        jGMMarginContourCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMMarginContourCBActionPerformed(evt);
            }
        });

        jGBFleshConstlbl.setText("Flesh constituency");

        javax.swing.GroupLayout jGBCapPanelLayout = new javax.swing.GroupLayout(jGBCapPanel);
        jGBCapPanel.setLayout(jGBCapPanelLayout);
        jGBCapPanelLayout.setHorizontalGroup(
            jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                                .addComponent(jGMLatexLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGMLatexCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGBShapelbl)
                                    .addComponent(jGMLatexColorlbl))
                                .addGap(6, 6, 6)
                                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGMLatexColorEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jGMShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jMGBMarginShapelbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGMMarginShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGBCapPanelLayout.createSequentialGroup()
                                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jGBCapPanelLayout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jGBFleshConstlbl)
                                        .addGap(27, 27, 27)
                                        .addComponent(jGMFlesyConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jGBMarginContlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jGMMarginContourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))))
                    .addComponent(jLabel69)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addComponent(jGMSuraceTxtlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGMSurfaceTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jGMSurfaceORnlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGMSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jGBCapPanelLayout.setVerticalGroup(
            jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBCapPanelLayout.createSequentialGroup()
                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGMLatexLbl)
                            .addComponent(jGMLatexCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGMMarginShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMGBMarginShapelbl))))
                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGBMarginContlbl)
                            .addComponent(jGMMarginContourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGBFleshConstlbl)
                            .addComponent(jGMFlesyConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jGBCapPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGMLatexColorlbl)
                            .addComponent(jGMLatexColorEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGBShapelbl)
                            .addComponent(jGMShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGMSurfaceTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGMSuraceTxtlbl))))
                .addGap(8, 8, 8)
                .addGroup(jGBCapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMSurfaceORnlbl)
                    .addComponent(jGMSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel69)
                .addGap(162, 162, 162)
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGBVeilColorlbl.setBackground(new java.awt.Color(84, 54, 42));
        jGBVeilColorlbl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGB_VeilColorlbl.setText("Veil   color");

        juGBVeillbl.setText("Veil");

        jGMVeilCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Membraneous", "Fibrillous", "Cortina", "Slimy" }));
        jGMVeilCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMVeilCBActionPerformed(evt);
            }
        });

        jGMVeilColorEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMVeilColorEdFldActionPerformed(evt);
            }
        });
        jGMVeilColorEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMVeilColorEdFldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jGBVeilColorlblLayout = new javax.swing.GroupLayout(jGBVeilColorlbl);
        jGBVeilColorlbl.setLayout(jGBVeilColorlblLayout);
        jGBVeilColorlblLayout.setHorizontalGroup(
            jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBVeilColorlblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGB_VeilColorlbl)
                    .addComponent(juGBVeillbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMVeilColorEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMVeilCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jGBVeilColorlblLayout.setVerticalGroup(
            jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBVeilColorlblLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGB_VeilColorlbl)
                    .addComponent(jGMVeilColorEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jGBVeilColorlblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(juGBVeillbl)
                    .addComponent(jGMVeilCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jGBGillCharPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGBGillCharPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGBGillEdgeShapelbl.setText("Gill Edge Shape");

        jGBGilltexturelbl.setText("Gill  Texture");

        jGBGillPaternlbl.setText("Gill Pattern");

        jGMGillPatternCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alternative", "Anastamosting", "Dichotously  Branched", "Irregularly  Branched" }));
        jGMGillPatternCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMGillPatternCBActionPerformed(evt);
            }
        });

        jGMGillAttachToStemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Free", "Adnexed", "Adnate", "Sinuate", "Decurred" }));
        jGMGillAttachToStemCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMGillAttachToStemCBActionPerformed(evt);
            }
        });

        jGMGillTextureCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wavy", "Brittle", "Soft" }));
        jGMGillTextureCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMGillTextureCBActionPerformed(evt);
            }
        });

        jGMGillEdgeShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entire", "Scalloped", "Wavy", "Sinuate", "Eroded" }));
        jGMGillEdgeShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMGillEdgeShapeCBActionPerformed(evt);
            }
        });

        jGBGillThicknesslbl.setText("Gill Thickness");

        jGMThicknessCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moderate", "Broad", "Narrow" }));
        jGMThicknessCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMThicknessCBActionPerformed(evt);
            }
        });

        jGBGillSpacinglbl.setText("Gill Spacing");

        jGBGillAttachToStemlbl.setText("Gill Attrachment To  Stem");

        jGMGillSpacingCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Distant", "Sub-distant", "Close" }));
        jGMGillSpacingCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMGillSpacingCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jGBGillCharPanelLayout = new javax.swing.GroupLayout(jGBGillCharPanel);
        jGBGillCharPanel.setLayout(jGBGillCharPanelLayout);
        jGBGillCharPanelLayout.setHorizontalGroup(
            jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGBGilltexturelbl)
                    .addComponent(jGBGillEdgeShapelbl)
                    .addComponent(jGBGillAttachToStemlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                        .addComponent(jGMGillEdgeShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jGBGillThicknesslbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGMThicknessCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                        .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGMGillAttachToStemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGMGillTextureCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                                .addComponent(jGBGillSpacinglbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGMGillSpacingCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                                .addComponent(jGBGillPaternlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGMGillPatternCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jGBGillCharPanelLayout.setVerticalGroup(
            jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGBGillCharPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jGBGillAttachToStemlbl)
                            .addComponent(jGMGillAttachToStemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGBGillPaternlbl))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGBGillCharPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jGMGillPatternCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGBGillEdgeShapelbl)
                    .addComponent(jGMGillEdgeShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGBGillThicknesslbl)
                    .addComponent(jGMThicknessCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jGBGillCharPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGBGilltexturelbl)
                    .addComponent(jGMGillTextureCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGBGillSpacinglbl)
                    .addComponent(jGMGillSpacingCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jGMUniversalVeilPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGMUniversalVeilPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGMUniversalVeilPreslbl.setText("Universal Veil Present");

        jGMUniversalVeilPresCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGMUniversalVeilPresCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMUniversalVeilPresCBActionPerformed(evt);
            }
        });

        jGMUniversalVeilRemlbl.setText("Universal Veil Remnant ");

        jGMUniversalVeilRemCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Warts", "Path", "Other" }));
        jGMUniversalVeilRemCB.setName("Veil Remnants"); // NOI18N
        jGMUniversalVeilRemCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMUniversalVeilRemCBActionPerformed(evt);
            }
        });

        jGBVolvalbl.setText("Volva");

        jGMColorRemlbl.setText("Color Remnants");

        jGMColorRemEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMColorRemEdFeildActionPerformed(evt);
            }
        });
        jGMColorRemEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMColorRemEdFeildKeyTyped(evt);
            }
        });

        jGMVolvaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Saccate", "Collard", "Sheathing", "Zoned" }));
        jGMVolvaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMVolvaCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jGMUniversalVeilPanelLayout = new javax.swing.GroupLayout(jGMUniversalVeilPanel);
        jGMUniversalVeilPanel.setLayout(jGMUniversalVeilPanelLayout);
        jGMUniversalVeilPanelLayout.setHorizontalGroup(
            jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                                .addComponent(jGMUniversalVeilPreslbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGMUniversalVeilPresCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGBVolvalbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGMVolvaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                                .addComponent(jGMColorRemlbl)
                                .addGap(3, 3, 3)
                                .addComponent(jGMColorRemEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jGMUniversalVeilRemlbl)
                        .addGap(23, 23, 23)
                        .addComponent(jGMUniversalVeilRemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jGMUniversalVeilPanelLayout.setVerticalGroup(
            jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMUniversalVeilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGMUniversalVeilPreslbl)
                        .addComponent(jGMUniversalVeilPresCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGBVolvalbl)
                        .addComponent(jGMVolvaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMUniversalVeilRemCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMUniversalVeilRemlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jGMUniversalVeilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMColorRemlbl)
                    .addComponent(jGMColorRemEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jGBCapCharTitlelbl.setBackground(new java.awt.Color(51, 36, 54));
        jGBCapCharTitlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGBCapCharTitlelbl.setForeground(new java.awt.Color(222, 89, 73));
        jGBCapCharTitlelbl.setText("Color  Characteristics ");
        jGBCapCharTitlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGBGillCharlbl.setBackground(new java.awt.Color(51, 29, 57));
        jGBGillCharlbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGBGillCharlbl.setForeground(new java.awt.Color(222, 86, 79));
        jGBGillCharlbl.setText("Gill  Characteristics ");
        jGBGillCharlbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMTaxonPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGMTaxonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGilledMushroomsTaxonEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomsTaxonEdFeildActionPerformed(evt);
            }
        });
        jGilledMushroomsTaxonEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomsTaxonEdFeildKeyTyped(evt);
            }
        });

        date_field.setEditable(false);

        jGilledMushroomColEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomColEdFieldActionPerformed(evt);
            }
        });
        jGilledMushroomColEdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomColEdFieldKeyTyped(evt);
            }
        });

        jGilledMushroomsPhotoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGilledMushroomsPhotoEdFeildActionPerformed(evt);
            }
        });
        jGilledMushroomsPhotoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGilledMushroomsPhotoEdFeildKeyTyped(evt);
            }
        });

        jGMTaxonlbl.setText("Taxon");

        jGMDateFeildlbl.setText("Date");

        jGMPhotolbl.setText("Photo  No.");

        jGMCollectorslbl.setText("Collector(s) ");

        jGM_CollectorsEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGM_CollectorsEdFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Collecto  No:");

        javax.swing.GroupLayout jGMTaxonPanelLayout = new javax.swing.GroupLayout(jGMTaxonPanel);
        jGMTaxonPanel.setLayout(jGMTaxonPanelLayout);
        jGMTaxonPanelLayout.setHorizontalGroup(
            jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMTaxonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMTaxonPanelLayout.createSequentialGroup()
                        .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGMTaxonPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jGMDateFeildlbl)
                                .addGap(55, 55, 55))
                            .addGroup(jGMTaxonPanelLayout.createSequentialGroup()
                                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jGMTaxonlbl)
                                    .addComponent(jGMCollectorslbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGilledMushroomsTaxonEdFeild, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(date_field)
                            .addComponent(jGilledMushroomColEdField)))
                    .addGroup(jGMTaxonPanelLayout.createSequentialGroup()
                        .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jGMPhotolbl)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGM_CollectorsEdField)
                            .addComponent(jGilledMushroomsPhotoEdFeild))))
                .addGap(30, 30, 30))
        );
        jGMTaxonPanelLayout.setVerticalGroup(
            jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMTaxonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGilledMushroomsTaxonEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMTaxonlbl))
                .addGap(18, 18, 18)
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMDateFeildlbl))
                .addGap(18, 18, 18)
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGilledMushroomColEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMCollectorslbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGM_CollectorsEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jGMTaxonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMPhotolbl)
                    .addComponent(jGilledMushroomsPhotoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jGMVeilTitlelbl.setBackground(new java.awt.Color(51, 26, 47));
        jGMVeilTitlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMVeilTitlelbl.setForeground(new java.awt.Color(222, 73, 67));
        jGMVeilTitlelbl.setText("Veil   Characteristics ");
        jGMVeilTitlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMUniversalVeilTitlelbl.setBackground(new java.awt.Color(51, 33, 60));
        jGMUniversalVeilTitlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMUniversalVeilTitlelbl.setForeground(new java.awt.Color(222, 76, 51));
        jGMUniversalVeilTitlelbl.setText("Universal  Veil   Characteristics");
        jGMUniversalVeilTitlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGM_RecDisplay.setEditable(false);
        jGM_RecDisplay.setText("1");

        jGMGenralCharTitlelbl.setBackground(new java.awt.Color(82, 48, 165));
        jGMGenralCharTitlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMGenralCharTitlelbl.setForeground(new java.awt.Color(222, 38, 16));
        jGMGenralCharTitlelbl.setText("General   Characteristics ");
        jGMGenralCharTitlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMStalkPanel.setBackground(new java.awt.Color(84, 54, 42));
        jGMStalkPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGMWidthatWidPtEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMWidthatWidPtEdFldActionPerformed(evt);
            }
        });
        jGMWidthatWidPtEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMWidthatWidPtEdFldKeyTyped(evt);
            }
        });

        jGMWidttatBaseEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMWidttatBaseEdFldActionPerformed(evt);
            }
        });
        jGMWidttatBaseEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMWidttatBaseEdFldKeyTyped(evt);
            }
        });

        jGMStalkPresentlbl.setText("Stalk  Present");

        jGMWidthatWidPtlbl.setText("Width at Widest Point");

        jGMStalkPresentCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jGMStalkPresentCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMStalkPresentCBActionPerformed(evt);
            }
        });

        jGMWidthatBaselbl.setText("Width at Base");

        jGMStalkCharShapelbl.setText("Shape");

        jGMStalkCharShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equal", "Ventircose", "Tapered at Apex", "Tapered at  base", "Radicate", "Clavate", "Bulbous" }));
        jGMStalkCharShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMStalkCharShapeCBActionPerformed(evt);
            }
        });

        jGMStalkCharFleshTextlbl.setText("Flesh  Texture");

        jGBStalkCharFleshTextCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gelatinous", "Firm", "Solid", "Stuffed", "Hollow", "Flimsy" }));
        jGBStalkCharFleshTextCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGBStalkCharFleshTextCBActionPerformed(evt);
            }
        });

        jGMStalkCharSurfTextCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Viscid", "Sticky", "Smooth", "Fibrillious", "Polished", "Punctuate" }));
        jGMStalkCharSurfTextCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMStalkCharSurfTextCBActionPerformed(evt);
            }
        });

        jGMStalkCharSurfTextlbl.setText("Surface Texture");

        jGMStalkiCharStemConsistlbl.setText("Stem Consistence");

        jGMStemConstCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartiilaginous", "Fibriillous", "Stalky" }));
        jGMStemConstCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMStemConstCBActionPerformed(evt);
            }
        });

        jGMSurfaceOrnlbl.setText("Surface Ornamentation");

        jStalkCharSurfOrnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smooth", "Powdery", "Scaly", "Fibrillous", "Tomentose" }));
        jStalkCharSurfOrnCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStalkCharSurfOrnCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jGMStalkPanelLayout = new javax.swing.GroupLayout(jGMStalkPanel);
        jGMStalkPanel.setLayout(jGMStalkPanelLayout);
        jGMStalkPanelLayout.setHorizontalGroup(
            jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                        .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jGMWidthatWidPtlbl)
                            .addComponent(jGMWidthatBaselbl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGMStalkPresentlbl, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jGMStalkPresentCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGMWidttatBaseEdFld, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jGMWidthatWidPtEdFld)))
                    .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                        .addComponent(jGMStalkiCharStemConsistlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGMStemConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jGMStalkCharShapelbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jGMStalkCharShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jGMStalkPanelLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jGMStalkCharFleshTextlbl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jGBStalkCharFleshTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                                .addComponent(jGMSurfaceOrnlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jStalkCharSurfOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                                .addComponent(jGMStalkCharSurfTextlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGMStalkCharSurfTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jGMStalkPanelLayout.setVerticalGroup(
            jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMStalkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jGMStalkPresentCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jGMStalkPresentlbl, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGMStalkCharShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jGMStalkCharShapelbl)))
                .addGap(18, 18, 18)
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGMWidthatWidPtlbl)
                        .addComponent(jGMWidthatWidPtEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jGMStalkCharFleshTextlbl))
                    .addComponent(jGBStalkCharFleshTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGMWidthatBaselbl)
                        .addComponent(jGMWidttatBaseEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jGMStalkCharSurfTextCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jGMStalkCharSurfTextlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMStemConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMStalkiCharStemConsistlbl)
                    .addGroup(jGMStalkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jStalkCharSurfOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jGMSurfaceOrnlbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGMStalkCharTitlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMStalkCharTitlelbl.setForeground(new java.awt.Color(222, 66, 70));
        jGMStalkCharTitlelbl.setText("Stalk  Characteristics");
        jGMStalkCharTitlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMChemCharlTiledbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMChemCharlTiledbl.setForeground(new java.awt.Color(222, 54, 57));
        jGMChemCharlTiledbl.setText("Chemical  Characteristics");
        jGMChemCharlTiledbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMChemicalPanel.setBackground(new java.awt.Color(84, 54, 52));
        jGMChemicalPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jGMKOHEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMKOHEdFldActionPerformed(evt);
            }
        });
        jGMKOHEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMKOHEdFldKeyTyped(evt);
            }
        });

        jGMelzersCapSurfEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMelzersCapSurfEdFldActionPerformed(evt);
            }
        });

        jGMKOHCaplbl.setText("KOH-Cap  Surface ");

        jGMMelCapSurlbl.setText("Melzers  Cap  Surface");

        jGMKOHFleshlbl.setText("KOH  Flesh");

        jGMKOHFleshEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMKOHFleshEdFldActionPerformed(evt);
            }
        });
        jGMKOHFleshEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMKOHFleshEdFldKeyTyped(evt);
            }
        });

        jGMMelzersFleshlbl.setText("Melzer's  Flesh");

        jGMMelzersFleshEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMMelzersFleshEdFldActionPerformed(evt);
            }
        });
        jGMMelzersFleshEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMMelzersFleshEdFldKeyTyped(evt);
            }
        });

        jGMKOHPVlbl.setText("KOH Partial Veil ");

        jGMKOHParitalVeilEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGMKOHParitalVeilEdFldActionPerformed(evt);
            }
        });
        jGMKOHParitalVeilEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jGMKOHParitalVeilEdFldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jGMChemicalPanelLayout = new javax.swing.GroupLayout(jGMChemicalPanel);
        jGMChemicalPanel.setLayout(jGMChemicalPanelLayout);
        jGMChemicalPanelLayout.setHorizontalGroup(
            jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMChemicalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMMelCapSurlbl)
                    .addComponent(jGMKOHCaplbl)
                    .addComponent(jGMKOHFleshlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jGMelzersCapSurfEdFld)
                    .addComponent(jGMKOHEdFld)
                    .addComponent(jGMKOHFleshEdFld, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMMelzersFleshlbl)
                    .addComponent(jGMKOHPVlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jGMMelzersFleshEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMKOHParitalVeilEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jGMChemicalPanelLayout.setVerticalGroup(
            jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGMChemicalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMKOHCaplbl)
                    .addComponent(jGMKOHEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMMelzersFleshlbl)
                    .addComponent(jGMMelzersFleshEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMelzersCapSurfEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMMelCapSurlbl)
                    .addComponent(jGMKOHPVlbl)
                    .addComponent(jGMKOHParitalVeilEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jGMChemicalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMKOHFleshlbl)
                    .addComponent(jGMKOHFleshEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jGMCapCharTittlelbl.setBackground(new java.awt.Color(51, 38, 76));
        jGMCapCharTittlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMCapCharTittlelbl.setForeground(new java.awt.Color(222, 56, 60));
        jGMCapCharTittlelbl.setText("Cap  Characteristics");
        jGMCapCharTittlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jGMTaxonTittlelbl.setBackground(new java.awt.Color(51, 38, 69));
        jGMTaxonTittlelbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jGMTaxonTittlelbl.setForeground(new java.awt.Color(222, 67, 33));
        jGMTaxonTittlelbl.setText("Taxonomic Info");
        jGMTaxonTittlelbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jGMRecllbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGM_RecDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jGBVeilColorlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGMUniversalVeilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGMUniversalVeilTitlelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jGMStalkCharTitlelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMStalkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jGMVeilTitlelbl))
                    .addComponent(jGBCapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGBGillCharlbl)
                    .addComponent(jGBGillCharPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMChemCharlTiledbl)
                    .addComponent(jGMCapCharTittlelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGMChemicalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGeneralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jGMGenralCharTitlelbl))
                            .addComponent(jGBCapCharTitlelbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jGMTaxonTittlelbl)
                            .addComponent(jGMTaxonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(2765, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jGMRecllbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGM_RecDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGMGenralCharTitlelbl)
                        .addGap(12, 12, 12)
                        .addComponent(jGeneralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGBCapCharTitlelbl)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jGMTaxonTittlelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jGMTaxonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGMCapCharTittlelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGBCapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGBGillCharlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGBGillCharPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jGMVeilTitlelbl)
                    .addComponent(jGMUniversalVeilTitlelbl))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jGMUniversalVeilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jGBVeilColorlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGMStalkCharTitlelbl)
                .addGap(18, 18, 18)
                .addComponent(jGMStalkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jGMChemCharlTiledbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGMChemicalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jGilledFungusLayout = new javax.swing.GroupLayout(jGilledFungus);
        jGilledFungus.setLayout(jGilledFungusLayout);
        jGilledFungusLayout.setHorizontalGroup(
            jGilledFungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGilledFungusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 2145, Short.MAX_VALUE)
                .addContainerGap())
        );
        jGilledFungusLayout.setVerticalGroup(
            jGilledFungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGilledFungusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jStatisticsWindow.addTab("Gilled  Fungi", jGilledFungus);

        jBoleteFungi.setBackground(new java.awt.Color(193, 180, 129));
        jBoleteFungi.setMaximumSize(new java.awt.Dimension(700, 700));
        jBoleteFungi.setName(""); // NOI18N
        jBoleteFungi.setPreferredSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(197, 64, 38));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jBCapWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCapWidthActionPerformed(evt);
            }
        });
        jBCapWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBCapWidthKeyReleased(evt);
            }
        });

        jBoleteSporoCapCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolete", "Polypore" }));
        jBoleteSporoCapCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteSporoCapCBActionPerformed(evt);
            }
        });

        jLabel6.setText("Cap   Width");

        jLabel7.setText("Sporo Cap  Type");

        jLabel8.setText("Cap  Height");

        jBCapHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCapHeightActionPerformed(evt);
            }
        });
        jBCapHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBCapHeightKeyTyped(evt);
            }
        });

        jLabel9.setText("Taste");

        jBFTasteCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mild", "Strong", "Pleasant", "Unpleasant", "Peppery" }));
        jBFTasteCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFTasteCBActionPerformed(evt);
            }
        });

        jLabel13.setText("Smell");

        jBFsmelllEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFsmelllEdFieldActionPerformed(evt);
            }
        });
        jBFsmelllEdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFsmelllEdFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(29, 29, 29)
                            .addComponent(jBCapHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(26, 26, 26)
                            .addComponent(jBCapWidth))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBoleteSporoCapCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addComponent(jBFTasteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBFsmelllEdField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBoleteSporoCapCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jBCapWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCapHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jBFTasteCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jBFsmelllEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        BoleteRecNo.setBackground(new java.awt.Color(234, 233, 233));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(246, 24, 24));
        jLabel11.setText("Taxonomy");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(234, 33, 33));
        jLabel12.setText("General   Characteristics");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(194, 67, 38));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.setName("Taxonomy"); // NOI18N

        jBFTaxonEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFTaxonEdFieldActionPerformed(evt);
            }
        });
        jBFTaxonEdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFTaxonEdFieldKeyTyped(evt);
            }
        });

        date_field2.setEditable(false);
        date_field2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_field2ActionPerformed(evt);
            }
        });

        jBFCollectNoEdFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFCollectNoEdFldActionPerformed(evt);
            }
        });
        jBFCollectNoEdFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFCollectNoEdFldKeyTyped(evt);
            }
        });

        jPhotoNoEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhotoNoEdFeildActionPerformed(evt);
            }
        });
        jPhotoNoEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPhotoNoEdFeildKeyTyped(evt);
            }
        });

        jLabel1.setText("Taxon");

        jLabel2.setText("Date");

        jLabel3.setText("Collector(s)");

        jLabel4.setText("Colection No:");

        jLabel5.setText("Photo  No:");

        jCollectorsedField.setColumns(20);
        jCollectorsedField.setRows(5);
        jScrollPane3.setViewportView(jCollectorsedField);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPhotoNoEdFeild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(date_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(16, 16, 16)))
                    .addComponent(jBFTaxonEdField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBFCollectNoEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFTaxonEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(date_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBFCollectNoEdFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPhotoNoEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel14.setBackground(new java.awt.Color(216, 21, 41));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(224, 27, 27));
        jLabel14.setText("Rec No");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBackground(new java.awt.Color(194, 67, 38));

        jLabel15.setText("Cap  Surface");

        jLabel16.setText("Cap Flesh");

        jLabel17.setText("Pore layer");

        jBFCapSurface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFCapSurfaceActionPerformed(evt);
            }
        });
        jBFCapSurface.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFCapSurfaceKeyTyped(evt);
            }
        });

        jBGCapFleshEdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGCapFleshEdFieldActionPerformed(evt);
            }
        });
        jBGCapFleshEdField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBGCapFleshEdFieldKeyTyped(evt);
            }
        });

        PoreLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoreLayerActionPerformed(evt);
            }
        });
        PoreLayer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PoreLayerKeyTyped(evt);
            }
        });

        jLabel18.setText("Stem Surface ");

        jBFStemSurface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFStemSurfaceActionPerformed(evt);
            }
        });
        jBFStemSurface.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFStemSurfaceKeyTyped(evt);
            }
        });

        jBFStemFlesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFStemFleshActionPerformed(evt);
            }
        });
        jBFStemFlesh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFStemFleshKeyTyped(evt);
            }
        });

        jLabel19.setText("Stem  Flesh");

        jLabel20.setText("Bruising  Reactions ");

        jBFBruisingEdFeild.setBackground(new java.awt.Color(222, 229, 240));
        jBFBruisingEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFBruisingEdFeildActionPerformed(evt);
            }
        });
        jBFBruisingEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBFBruisingEdFeildKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGCapFleshEdField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBFCapSurface, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PoreLayer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBFStemSurface, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFStemFlesh, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jBFBruisingEdFeild))
                .addGap(55, 55, 55))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jBFCapSurface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jBGCapFleshEdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(PoreLayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jBFStemSurface, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBFStemFlesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBFBruisingEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(194, 67, 38));

        jBoleteCSComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dry", "Greasy", "Sticky", "Slimy" }));
        jBoleteCSComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteCSComboBoxActionPerformed(evt);
            }
        });

        jBoleteCapShapeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Convex", "Irregular", "Centrally Depressed" }));
        jBoleteCapShapeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteCapShapeCBActionPerformed(evt);
            }
        });

        jBoleteFleshConstCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fleshy", "Brittle", "Spongy" }));
        jBoleteFleshConstCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteFleshConstCBActionPerformed(evt);
            }
        });

        jBoleteSurfaceOrnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Smooth", "Pubescent", "Fibrilliant", "Wrinkled", "Scaly", "Granular", "Velvety" }));
        jBoleteSurfaceOrnCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteSurfaceOrnCBActionPerformed(evt);
            }
        });

        jLabel22.setText("Surface    Texture");

        jLabel23.setText("Cap  Shape");

        jLabel24.setText("Flesh Constituency");

        jLabel25.setText("Surface Ornamention");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBoleteCSComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBoleteCapShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoleteSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBoleteFleshConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jBoleteCSComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBoleteFleshConstCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBoleteCapShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jLabel25)
                    .addComponent(jBoleteSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel21.setBackground(new java.awt.Color(246, 24, 24));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(246, 24, 24));
        jLabel21.setText("Color Characteristics ");
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setBackground(new java.awt.Color(246, 24, 24));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(246, 24, 24));
        jLabel26.setText("Cap  Characteristics");
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel8.setBackground(new java.awt.Color(194, 67, 38));

        jBoleteWidthatWidestPt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteWidthatWidestPtActionPerformed(evt);
            }
        });
        jBoleteWidthatWidestPt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBoleteWidthatWidestPtKeyTyped(evt);
            }
        });

        jBoleteWidthatBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteWidthatBaseActionPerformed(evt);
            }
        });
        jBoleteWidthatBase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBoleteWidthatBaseKeyTyped(evt);
            }
        });

        jBoleteSCLengthEdFeild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteSCLengthEdFeildActionPerformed(evt);
            }
        });
        jBoleteSCLengthEdFeild.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBoleteSCLengthEdFeildKeyTyped(evt);
            }
        });

        jLabel27.setText("Width  at  widest point");

        jLabel28.setText("Width at Base");

        jLabel29.setText("Length");

        jLabel30.setText("Annulus Color");

        jBoleteAnnulusColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteAnnulusColorActionPerformed(evt);
            }
        });
        jBoleteAnnulusColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jBoleteAnnulusColorKeyTyped(evt);
            }
        });

        jBoleteOrnamentionCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Glandular", "Dotted", "Powdery", "Scabous", "Fibrilious", "Finely Reticulated", ".Courselky  Reticulated", "Scaly" }));
        jBoleteOrnamentionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteOrnamentionCBActionPerformed(evt);
            }
        });

        jBoleteAnnulusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Membraneous", "Fibrillious", "Cortina", "Slimy" }));
        jBoleteAnnulusCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteAnnulusCBActionPerformed(evt);
            }
        });

        jBoleteStalkSurfaceOrnCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gelatinous", "Solid", "Firn", "Stuffed", "Hollow" }));
        jBoleteStalkSurfaceOrnCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteStalkSurfaceOrnCBActionPerformed(evt);
            }
        });

        jBoleteSurfaceTextureCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equal", "Ventricose", "Tapered at Apex", "Tapered at  base.Clavate.Bulbous" }));
        jBoleteSurfaceTextureCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoleteSurfaceTextureCBActionPerformed(evt);
            }
        });

        jLabel31.setText("Annulus");

        label1.setForeground(new java.awt.Color(239, 235, 235));
        label1.setText("Surface Ornamentation");

        label3.setText("Surace   Texture");
        label3.setVisible(false);

        label4.setForeground(new java.awt.Color(236, 231, 231));
        label4.setText("Surface  Texture");

        jLabel32.setText("Ornamentation");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel29))
                    .addComponent(jLabel27)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel28))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel31)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBoleteSCLengthEdFeild, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBoleteWidthatWidestPt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBoleteWidthatBase, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBoleteAnnulusColor, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBoleteStalkSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBoleteSurfaceTextureCB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBoleteOrnamentionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBoleteAnnulusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBoleteSCLengthEdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(jBoleteWidthatWidestPt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jBoleteStalkSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBoleteSurfaceTextureCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jBoleteWidthatBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jBoleteAnnulusColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30)))
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addComponent(jBoleteAnnulusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBoleteOrnamentionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(246, 24, 24));
        jLabel33.setText("Stalk Characteristics");
        jLabel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jBoleteFungiLayout = new javax.swing.GroupLayout(jBoleteFungi);
        jBoleteFungi.setLayout(jBoleteFungiLayout);
        jBoleteFungiLayout.setHorizontalGroup(
            jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12))
                            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel21))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel26))
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(19, 19, 19)
                                .addComponent(BoleteRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(330, 330, 330)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1232, 1232, 1232))
        );
        jBoleteFungiLayout.setVerticalGroup(
            jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoleteFungiLayout.createSequentialGroup()
                .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBoleteFungiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoleteRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(24, 24, 24)
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jBoleteFungiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jStatisticsWindow.addTab("Bolete and Polyporus Fungus ", jBoleteFungi);

        jPanel21.setBackground(new java.awt.Color(225, 133, 18));

        jTable2.setBackground(new java.awt.Color(126, 81, 6));
        jTable2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data  No.", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setDropMode(javax.swing.DropMode.INSERT);
        jTable2.setGridColor(new java.awt.Color(1, 1, 14));
        jTable2.setOpaque(false);
        jScrollPane7.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1470, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(938, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jStatisticsWindow.addTab("Statistics  Window", jPanel20);

        jPanel18.setBackground(new java.awt.Color(212, 167, 138));
        jPanel18.setForeground(new java.awt.Color(210, 150, 36));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel94.setText("Data Base  Buttons");
        jLabel94.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(221, 198, 198), java.awt.Color.darkGray, java.awt.Color.lightGray));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel93.setText("Form  Buttons");
        jLabel93.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(221, 198, 198), java.awt.Color.darkGray, java.awt.Color.lightGray));

        jPanel17.setBackground(new java.awt.Color(203, 157, 32));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(216, 189, 189), new java.awt.Color(26, 24, 24)));
        jPanel17.setName("Form Buttons"); // NOI18N

        jWriteButton.setText("Write ");
        jWriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWriteButtonActionPerformed(evt);
            }
        });

        jClearBtn.setText("Clear");
        jClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearBtnActionPerformed(evt);
            }
        });

        jNewRecBtn.setText("New  Record");
        jNewRecBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewRecBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jClearBtn)
                    .addComponent(jWriteButton)
                    .addComponent(jNewRecBtn))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jNewRecBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jClearBtn)
                .addGap(18, 18, 18)
                .addComponent(jWriteButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDBPanel1.setBackground(new java.awt.Color(207, 157, 32));
        jDBPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(216, 189, 189), new java.awt.Color(180, 210, 42), new java.awt.Color(26, 24, 24), new java.awt.Color(137, 118, 118)));
        jDBPanel1.setName("Form Buttons"); // NOI18N

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jChiSquaredRadBut.setText("Chi Squared Test for  ");
        jChiSquaredRadBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChiSquaredRadButActionPerformed(evt);
            }
        });

        jSpearmanBut.setText("Spearman Rank Correlation");
        jSpearmanBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSpearmanButActionPerformed(evt);
            }
        });

        jWilcoxanBut.setText("Wilcoxan Signed  Rank Test");
        jWilcoxanBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWilcoxanButActionPerformed(evt);
            }
        });

        jManWhitneyUTest.setText("Mann-Whitney  U  Test ");
        jManWhitneyUTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManWhitneyUTestActionPerformed(evt);
            }
        });

        jGTestRadioBut.setText("   G-Test");
        jGTestRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGTestRadioButActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Paired t-Test");

        jRadioButton4.setText("t-test");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChiSquaredRadBut)
                    .addComponent(jWilcoxanBut)
                    .addComponent(jManWhitneyUTest)
                    .addComponent(jGTestRadioBut)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSpearmanBut, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jChiSquaredRadBut)
                .addGap(1, 1, 1)
                .addComponent(jSpearmanBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jWilcoxanBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jManWhitneyUTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jGTestRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel97.setBackground(new java.awt.Color(172, 70, 30));
        jLabel97.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel97.setText("Hypothesis Testing Options");
        jLabel97.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(221, 198, 198), java.awt.Color.darkGray, java.awt.Color.lightGray));
        jLabel97.setOpaque(true);

        jRadioButton2.setText("Single tailed");

        jRadioButton3.setText("Two Tailed");

        jALOSCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.05", "0.025", "0.01", "0.005" }));
        jALOSCB.setBorder(javax.swing.BorderFactory.createTitledBorder("alpha  level of   significance"));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jALOSCB, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jALOSCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPerformTests.setText("Perform  Tests");
        jPerformTests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPerformTestsActionPerformed(evt);
            }
        });

        jLabel96.setBackground(new java.awt.Color(172, 70, 30));
        jLabel96.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel96.setText("Statistical   Tests");
        jLabel96.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(221, 198, 198), java.awt.Color.darkGray, java.awt.Color.lightGray));
        jLabel96.setOpaque(true);

        javax.swing.GroupLayout jDBPanel1Layout = new javax.swing.GroupLayout(jDBPanel1);
        jDBPanel1.setLayout(jDBPanel1Layout);
        jDBPanel1Layout.setHorizontalGroup(
            jDBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDBPanel1Layout.createSequentialGroup()
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDBPanel1Layout.createSequentialGroup()
                .addGroup(jDBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDBPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDBPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDBPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDBPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPerformTests)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jDBPanel1Layout.setVerticalGroup(
            jDBPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDBPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPerformTests)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel93)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDBPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDBPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(973, Short.MAX_VALUE))
        );

        jDBPanel.setBackground(new java.awt.Color(207, 157, 32));
        jDBPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(216, 189, 189), new java.awt.Color(180, 210, 42), new java.awt.Color(26, 24, 24), new java.awt.Color(137, 118, 118)));
        jDBPanel.setName("Form Buttons"); // NOI18N

        jButton1.setText("Add    Record ");

        jButton3.setText("Delete");

        jButton2.setText("Browse");

        javax.swing.GroupLayout jDBPanelLayout = new javax.swing.GroupLayout(jDBPanel);
        jDBPanel.setLayout(jDBPanelLayout);
        jDBPanelLayout.setHorizontalGroup(
            jDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDBPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jDBPanelLayout.setVerticalGroup(
            jDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDBPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jStatisticsWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDBPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDBPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jStatisticsWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 1244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jStatisticsWindow.getAccessibleContext().setAccessibleName("Coral");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    protected void clear_fields()
    {
         
        

       jGilledMushroomCapWidEditField.setText("   ");
         jGilledMushroomsTotalHeightEditFielld.setText("   ");
         jGilledMushroomCapCentreHgtEdFeild.setText("  ");
         jGilledMushroomCapSurfaceEditField.setText("  ");
         jGilledMushroomStemFleshEditFeild.setText("   ");
         jGilledMushroomStemSuraceEditFeild.setText("   ");
         jGilledMushroomCapFleshEditFeild.setText("   ");
         jGMelzersCapSurfEdFld.setText("   ");
         jGMKOHEdFld.setText("   ");
          jGMKOHParitalVeilEdFld.setText("  ");
          jGMMelzersFleshEdFld.setText("   ");
          jGMWidthatWidPtEdFld.setText("  ");
           jGMWidttatBaseEdFld.setText("  ");
           jGMVeilColorEdFld.setText("  ");
            jGMColorRemEdFeild.setText("  ");
            jGMLatexColorEdFld.setText("   ");
            jGilledMushroomStemFleshEditFeild.setText("   ");
          jGilledMushroomCapSurfaceEditField.setText("  ");
          jGilledMushroomStemFleshEditFeild.setText("  ");
    }
    
    private void jGilledMushroomCapSurfaceEditFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomCapSurfaceEditFieldActionPerformed
          jGilledMushroomCapSurfaceEditField.setEnabled(true);
        Cap_Surface[0]=jGilledMushroomCapSurfaceEditField.getText();
        
    }//GEN-LAST:event_jGilledMushroomCapSurfaceEditFieldActionPerformed

    private void jGilledMushroomStemFleshEditFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomStemFleshEditFeildActionPerformed
      jGilledMushroomStemFleshEditFeild.setEnabled(true);
        Stem_Flesh=jGilledMushroomStemFleshEditFeild.getText();
        
    }//GEN-LAST:event_jGilledMushroomStemFleshEditFeildActionPerformed

    private void jGilledMushroomGillsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomGillsCBActionPerformed
       Object GM_GillsObj= jGilledMushroomGillsCB.getSelectedItem();
       Gills = GM_GillsObj.toString();
    }//GEN-LAST:event_jGilledMushroomGillsCBActionPerformed

    private void jGilledMushroomStemSuraceEditFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomStemSuraceEditFeildActionPerformed
       jGilledMushroomStemSuraceEditFeild.setEnabled(true);
        Stem_Surface=jGilledMushroomStemSuraceEditFeild.getText();
   
    }//GEN-LAST:event_jGilledMushroomStemSuraceEditFeildActionPerformed

    private void jGilledMushroomHygrophanousComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomHygrophanousComboBoxActionPerformed
      Object GM_HygroObj= jGilledMushroomHygrophanousComboBox.getSelectedItem();  
      Hygro = GM_HygroObj.toString();

    }//GEN-LAST:event_jGilledMushroomHygrophanousComboBoxActionPerformed

    private void jGilledMushroomTasteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomTasteComboBoxActionPerformed
      
        Object GM_TasteObj = jGilledMushroomTasteComboBox.getSelectedItem();
        Taste[0]  = GM_TasteObj.toString();
       
        
    }//GEN-LAST:event_jGilledMushroomTasteComboBoxActionPerformed

    private void jGilledMushroomOdorComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomOdorComboboxActionPerformed
 
        Object GM_OdorObj = jGilledMushroomOdorCombobox.getSelectedItem();
        Odor[0] =GM_OdorObj.toString();
    }//GEN-LAST:event_jGilledMushroomOdorComboboxActionPerformed

    private void jGilledMushroomCapCentreHgtEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomCapCentreHgtEdFeildActionPerformed
       jGilledMushroomCapCentreHgtEdFeild.setEnabled(true);
        CCHeight= jGilledMushroomCapCentreHgtEdFeild.getText();
          
    }//GEN-LAST:event_jGilledMushroomCapCentreHgtEdFeildActionPerformed

    private void jGMFlesyConstCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMFlesyConstCBActionPerformed
       Object GM_FleshyConstObj =  jGMFlesyConstCB.getSelectedItem();
     Flesh_Const  = GM_FleshyConstObj.toString();

    }//GEN-LAST:event_jGMFlesyConstCBActionPerformed

    private void jGMMarginShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMMarginShapeCBActionPerformed
   Object GM_MarginShapeObj = jGMMarginShapeCB.getSelectedItem();
    Margin_Shape = GM_MarginShapeObj.toString();
    }//GEN-LAST:event_jGMMarginShapeCBActionPerformed

    private void jGMGillPatternCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMGillPatternCBActionPerformed
        Object GM_Obj = jGMGillPatternCB.getSelectedItem();
        Gill_Pattern=GM_Obj.toString();
    }//GEN-LAST:event_jGMGillPatternCBActionPerformed

    private void jClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearBtnActionPerformed
         int  retcode; 
          String  msg="Want to delete Taxon and the data.";
         if (jGilledFungus.isShowing())
         {    
         clear_fields();
         retcode=JOptionPane.showConfirmDialog(this, msg,"Delete Question", WIDTH);
         if (retcode == JOptionPane.YES_OPTION)      
         {                                                    
          jGilledMushroomColEdField.setText("   "); 
          jGilledMushroomsPhotoEdFeild.setText("   ");
           jGilledMushroomsTaxonEdFeild.setText("   ");
         }
         } 
         
         
         
          if (jBoleteFungi.isShowing())
         {    
            retcode=JOptionPane.showConfirmDialog(this, msg,"Delete Question", WIDTH); 
            if (retcode == JOptionPane.YES_OPTION)      
         {                         
            jBFTaxonEdField.setText("    ");
              jBFCollectNoEdFld.setText("   ");         
         }
            jBCapHeight.setText("   ");
            jBFCapSurface.setText("   "); 
            jBGCapFleshEdField.setText("   "); 
            PoreLayer.setText("   ");  
          jBFBruisingEdFeild.setText("   ");
          jBFTaxonEdField.setText("   ");
         date_field2.setText("   ");
         }
         
         if (jElfin_Fungus.isShowing())
         {    
             retcode=JOptionPane.showConfirmDialog(this, msg,"Delete Question", WIDTH); 
            if (retcode == JOptionPane.YES_OPTION)    
            {
              jElfinPhotoEdFeild.setText("  ");
            jElfincollectorNoEdFeild.setText("   ");
           jElfinTaxonEdFeild.setText("   ");
         }
           jElfinCapFleshThicknessEdFeild.setText("   ");
             jElfiinStemLenEdFeild.setText("   ");
             jElfinCapWidEdFeild.setText("    ");
            jElfinHymeniumCol.setText("    ");
             jElfiinStemLenEdFeild.setText("  ");
              jElfinCapWidEdFeild.setText("   ");
           jElfinAbbhColorEdFeild.setText("   ");
            jElfinBruising.setText("    ");
           jElfinEntireHeightEdFeild.setText("   ");
           jElfinOdorEdFeild.setText("  ");
          jElfiinStemLenEdFeild.setText("   ");
          jElfinCapFleshThicknessEdFeild.setText("  ");
          jElfinAbbhColorEdFeild.setText("   ");
          jElfinBruising.setText("  ");
          recno++;
          Record=Integer.toString(recno);
          jElfinRecNo.setText(Record);
          jElfinHymeniumCol.setText("   ");
          date_field3.setText(date_format);
          
         }
         
         if (jCoral_Fungus.isShowing())
         {    
              retcode=JOptionPane.showConfirmDialog(this, msg,"Delete Question", WIDTH); 
            if (retcode == JOptionPane.YES_OPTION)
            {    
             jCoralFungusTaxonEdFeild.setText("  ");
             jElfincollectorNoEdFeild.setText("   ");
             jCoralFungusPhotoNoEdFeild.setText("  ");
            }
             jCoralFungusEHeightEdFeild.setText("   ");
             jCoralFungusStemWidthEdFeild.setText("    ");
             jCoralFungusStemWidthEdFeild.setText("   ");
             jCoralFungusOdourEdField.setText("  ");
             jCoralFungusTipsEdFeild.setText("    ");
             jCoralFungusStemEdFeild.setText("   ");
            jCoralFungusBranchesEdFeild.setText("  "); 
           jCoralFungusBrusingEdFeild.setText("  ");   
          recno++;
          Record=Integer.toString(recno);
          jCoralFungusRecNo.setText(Record);
          date_field4.setText(date_format);
          
         }   
         
         
         
         
         
    }//GEN-LAST:event_jClearBtnActionPerformed

    private void jGMVeilCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMVeilCBActionPerformed
        Object GM_Veilobj = jGMVeilCB.getSelectedItem();
         Gill_Veil=GM_Veilobj.toString();
    }//GEN-LAST:event_jGMVeilCBActionPerformed

    private void jNewRecBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewRecBtnActionPerformed
        
         if (jGilledFungus.isShowing())
         {    
        clear_fields();
         jGilledMushroomColEdField.setText("   "); 
         jGilledMushroomsPhotoEdFeild.setText("  ");
          jGilledMushroomsTaxonEdFeild.setText("   ");
          recno++;
          Record=Integer.toString(recno);
          jGM_RecDisplay.setText(Record);
          date_field.setText(date_format);
          jGMKOHFleshEdFld.setText("    ");
         }
         
          if (jBoleteFungi.isShowing())
         {    
            
            jBCapHeight.setText("  ");
            jBFCapSurface.setText("   "); 
            jBGCapFleshEdField.setText("  "); 
            PoreLayer.setText("  ");  
          jBFBruisingEdFeild.setText("  ");
          jBFTaxonEdField.setText("  ");
          jElfinCapWidEdFeild.setText(" ");
          recno++;
          Record=Integer.toString(recno);
          BoleteRecNo.setText(Record);
          date_field2.setText(date_format);
          
         }
         
        if(jElfin_Fungus.isShowing())
        {
         jElfinCapFleshThicknessEdFeild.setText("   ");
             jElfiinStemLenEdFeild.setText("   ");
             jElfinCapWidEdFeild.setText("   ");
            jElfinHymeniumCol.setText( "   ");
             jElfiinStemLenEdFeild.setText("   ");
              jElfinCapWidEdFeild.setText(" ");
              jElfinPhotoEdFeild.setText(" ");
            jElfincollectorNoEdFeild.setText(" ");
           jElfinTaxonEdFeild.setText(" ");
           jElfinAbbhColorEdFeild.setText(" ");
            jElfinBruising.setText(" ");
           jElfinEntireHeightEdFeild.setText("  ");
           jElfinOdorEdFeild.setText("  ");
          jElfiinStemLenEdFeild.setText("  ");
          jElfinCapFleshThicknessEdFeild.setText("  ");
          jElfinAbbhColorEdFeild.setText("  ");
          jElfinBruising.setText("  ");
          recno++;
          Record=Integer.toString(recno);
          jElfinRecNo.setText(Record);
          jElfinHymeniumCol.setText("  ");
          date_field3.setText(date_format);
        }
          
         
          
       if (jCoral_Fungus.isShowing())
         {    
             jCoralFungusTaxonEdFeild.setText("  ");
             jCoralFungusPhotoNoEdFeild.setText(" ");
             jCoralFungusEHeightEdFeild.setText(" ");
             jCoralFungusStemWidthEdFeild.setText(" ");
             jCoralFungusStemWidthEdFeild.setText(" ");
             jCoralFungusOdourEdField.setText("  ");
             jCoralFungusTipsEdFeild.setText("  ");
             jCoralFungusStemEdFeild.setText("  ");
            jCoralFungusBranchesEdFeild.setText("  "); 
           jCoralFungusBrusingEdFeild.setText("   ");   
          recno++;
          Record=Integer.toString(recno);
          jCoralFungusRecNo.setText(Record);
          date_field4.setText(date_format);
          
         }   
          
          
          
          
    }//GEN-LAST:event_jNewRecBtnActionPerformed

    private void jWriteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWriteButtonActionPerformed
     
  String    taxonmsg="\r\n\r\nTaxonomic  Info"
                + "\r\nTaxon %s"
               + " \r\nDate   %s "
               + "\r\n Collector(s)  %s"
                + "\r\n   Collector No   %s"
               + "\r\n Photo  No.  %s";
       if (jGilledFungus.isShowing())
        {       
      
      String  genmsg ="   \r\n\r\nGeneral Characteristics"
              + "\r\nTotal  Height  %s"
              + " \r\nCap  Width  %s  "
              + "\r\nCap  Centre Height  %s "
              + "\r\nOdour  %s "
              + "\r\n Taste  %s";  
      
       String  Colormsg ="   \r\n\r\nColor Characteristics "
              + "\r\n  Cap Flesh  %s"
              + "\r\n Cap  Surface%s " 
              + "\r\nStem Surface %s "
              + "\r\n Spore Print  %s "
              + "\r\nStem Flesh  %s"
               + "\r\n  Hygrophanous %s"
               + "\r\nGills   %s"
               + "  \r\n Mature Gills   %s"; 
      
       
       String  Capmsg ="   \r\n \r\n  Cap Characteristics"
              + "\r\nLatex %s"
              + "\r\n Latex Color %s  " 
              + "\r\nShape  %s  "
              + "\r\nSurface Texture  %s "
              + "\r\nSurface Ornamentation   %s"
               + "\r\nMargin  Shape %s"
               + "\r\nContours of Margins   %s"
               + "\r\nFlesh Constituency   %s"; 
       
       String  Chemmsg ="   \r\n \r\nChemical Characteristics"
              + "\r\n KOH  Cap. Surface  %s"
              + " \r\n Melzer's Cap  Surface %s "
              + "\r\nKOH  Flesh  %s "
              + "\r\n Melzer's  Flesh  %s \r\n"
               + "\r\n KOH  Partial  Veil  %s";
       
        String  Stalkmsg ="   \r\n \r\nStalk Characteristics"
              + "\r\n Stalk  Present  %s"
              + " \r\n Width at Widest Pt %s "
              + "\r\n Width at Base   %s "
              + "\r\n Stem Consistency  %s "
               + "\r\nShape %s  \r\n"
                + "\r\n Flesh  Texture    %s "
                + "\r\n Surface Texture   %s "
                +"\r\n Surface Ornamentation  %s";
                
        String  Gillmsg =" \r\n \r\nGill Characteristics\r\n \r\n"
              + "Gill Attachment  to Stem  %s\r\n"
              + " Gill  Edge Shape %s  \r\n"
              + "Gill  Texture  %s \r \n"
              + "Gill Pattern %s \r\n"
               + "Gill Thickness %s  \r\n"
                + "Gill  Spacing    %s \r\n";
            
                
        String  Veilmsg =" \r\n \r\nVeil  Characteristics"
              + "\r\nVeil Color %s"
              + " \r\n Veil %s"  ;
              
        String UniversalVeilmsg =" Universal  Veil  Characteristics\r\n \r\n"
              + "Universal Veil  Present  %s\r\n"
              + " Universal Veil  Remnant %s  \r\n"
              + "Color  Re%s \r \n"
              + "Volva %s \r\n";
        
         

       try{
                 File  progFile;   
                   progFile =new File("Gilled Fungi.txt");
                   if(!progFile.exists()){
                       progFile.createNewFile();
                 }
           
            
            FileWriter  fw=  new FileWriter(progFile,true);
            BufferedWriter  bw =new BufferedWriter(fw);
            PrintWriter  pw = new PrintWriter(bw);
            pw.printf(taxonmsg, Taxon[0],date_format,Collector,CollectorNo[0],Photo[0]);
            pw.printf(genmsg,TTL_Height,GMCap_Width,CCHeight,Odor[0],Taste[0]);
            pw.printf(Colormsg,Spore,Cap_Surface[0], Stem_Surface,Cap_Flesh[0],Stem_Flesh, Hygro,Gills,Mature_Gills );
            pw.printf(Capmsg,Latex,Latex_Color,Shape,Surface_Text,Surface_Orn,Margin_Shape,CoM,Flesh_Const);
            pw.printf(Gillmsg,Gill_Attach_to_Stem,Gill_Edge_Shape,Gill_Texture,Gill_Pattern,Gill_Thickness,Gill_Spacing);
            pw.printf(Veilmsg,Veil_Color,Gill_Veil);
            pw.printf(UniversalVeilmsg,Universal_Veil_Present,Universal_Veil_Remnant,Color_Remnants,Volva);  
            pw.printf(Stalkmsg, WidthatWidestPt[0],WidthatBase[0],GM_StalkPresent,GM_StemConsist,GM_StalkCharShape,
                        GM_StalkCharFlesh,GM_StalkCharSurfText,GM_StalkCharSurfOrn);  
            pw.printf(Chemmsg,KOH_Cap, Melzer_Cap,KOH_Flesh,Melzer_Flesh,KOH_Partial_Veil );  
            pw.close();
             }  catch  (IOException  ioe){
                     System.out.println("Error  occured:");
                     ioe.printStackTrace();
             }
               }
          if (jBoleteFungi.isShowing())
       {
           String  genmsg ="   \r\n\r\nGeneral Characteristics"
              + "\r\nSporo Cap  Type  %s"
              + " \r\nCap  Width  %s  "
              + "\r\nCap  Height  %s "
              + "\r\nTaste  %s "
              + "\r\n Smell  %s";
           
           
           String  Colormsg ="   \r\n\r\nColor Characteristics "
              + "\r\n  Cap Flesh  %s"
              + "\r\n Cap  Surface%s " 
              + "\r\n  Pore Layer %s "
              + "\r\n Bruising Reactions  %s";
           
           
           String  Capmsg ="   \r\n \r\n  Cap Characteristics"
              + "\r\n  Surface Texture %s"
              + "\r\n Cap Shape %s  " 
              + "\r\n  Flesh  Constituency  %s "
              + "\r\nSurface Ornamentation   %s";
              
               
           String  Stalkmsg ="   \r\n \r\nStalk Characteristics"
              + "\r\n Length %s"
              + " \r\n Width at Widest Pt %s "
              + "\r\n Width at Base   %s "
              + "\r\n Annulus Color  %s "
               + "\r\n  Annulus %s  \r\n"
                + "\r\n Surface Ornamentation  %s "
                + "\r\n Surface Texture   %s "
                +" \r\n Ornamentation  %s";
           
           
         
             Taxonomy t= new Taxonomy(Taxon[1],CollectorNo[1],Photo[1],   jCollectorsedField);
             General_Characteristics  g= new General_Characteristics(Sporocap,jBFCap_Surface,BF_CapHght,Taste[0],Odor[1]);
             Color c = new  Color(Cap_Surface[1],jBFCap_Flesh, Pore_Layer,Stem_Surface,Stem_Flesh,jBF_BR);
              Cap    cap= new  Cap(Stem_Texture,Cap_Shape,Flesh_Const,Surface_Orn);
              Stalk  s= new Stalk(  Length,Annulus,Annulus_Color,WidthatWidestPt[1],WidthatBase[1],Stalk_SO,Surface_Texture,Ornamentation);
            
            
             
                try{
                 File  progFile;   
                   progFile =new File("Bolete  Fungi.txt");
                   if(!progFile.exists()){
                       progFile.createNewFile();
                 }       
                 
                      
           FileWriter  fw=  new FileWriter(progFile,true);
            BufferedWriter  bw =new BufferedWriter(fw);
            PrintWriter  pw = new PrintWriter(bw);
           pw.printf(taxonmsg,t.Taxon ,date_format,t.editors.getText(),t.colNo,t.PhotoNo);
           pw.printf(genmsg,g.Sporocap,g.Cap_width,g.Cap_height,g.Taste,g.Odour);
           pw.printf(Colormsg,c.Cap_Surface,c.Cap_Flesh,c.Pore_layer,c.Stem_Flesh,c.Stem_Surface,c.Bruising);
           pw.printf(Capmsg,cap.Surface_Texture,cap.Cap_Shape,cap.Flesh_Constiuency,cap.Surface_Ornamention);
           pw.printf(Stalkmsg,s.Length,s.WidthatWidestPt,s.WidthatBase,s.Annulus_Color,s.Annulus,
                         Surface_Orn,s.Surface_Texture,s.Ornamentation);
           pw.close();
                         
                }catch(IOException  ioe){
                     System.out.println("Error  occured:");
                     ioe.printStackTrace();
                }
{
    
    }//GEN-LAST:event_jWriteButtonActionPerformed
    }
          
          if (jElfin_Fungus.isShowing())
       {
           
       Taxonomy t= new Taxonomy(Taxon[2],CollectorNo[2],Photo[2],   jElfinCollectorsEdFeild);
      Elfin_Chemical_properties ecp = new Elfin_Chemical_properties(ASCI,Nuclei,SporeOrn);
      Elfin_GenChar  egp= new Elfin_GenChar(Odor[2],EntireHeight,CapWidth,StemLen,Bruising,HymeniumColor,AbHymeniumColor,CapfleshThickness,SporeCap,Shape,Taste[1],AbHym);
       Elfin_StalkChar s=new Elfin_StalkChar(WidthatWidestPt[2],WidthatBase[2],StalkLen,Stalk,SCShape,SurfaceColor,FleshColor,SFT,Surface);
       
      
      
      String  Chemmsg ="   \r\n \r\nChemical Characteristics"
              + "\r\n ASCI  stain in Iodine %s"
              + " \r\n Nuclei  embedded in AcetoCarmine %s"
              + "\r\n Spore  ornamentation staining in cotton of analine"
              + " \r\n blue or lactin  acid  %s ";
             
       String  genmsg ="   \r\n\r\nGeneral Characteristics"
              + "\r\nSporo Cap Type  %s"
              + " \r\nShape  %s  "
              + "\r\n  Taste  %s "
              + "\r\nAbhymenium Texture  %s "
              + "\r\nOdor   %s"
               + "\r\n Entire  Height%s"
                +"   \r\n  Cap  Width  %s"
                + " \r\n Stem Length  %s"
               +"\r\nCap Flesh  Thickness  %s"
               +"  \r\nFlesh Color and  Brusing %s"
               +"\r\nHymenium Color  %s"
               + "\r\n Abhymenium Color  %s" ;  
      
       
        String  Stalkmsg ="   \r\n \r\nStalk Characteristics"
              + "\r\n Stalk  Present  %s"
              + " \r\n  Length    %s "
              + "\r\n Width at  Widest  Pt  %s "
              + "\r\n Width at Base  %s "
               + "\r\n  Shape   %s  \r\n"
                + "\r\n Stem  Flesh  Texture  %s "
                + "\r\n Surface Color  %s "
                +" \r\n  Flesh  Color  %s"
                +" \r\n  Surface     %s";
                
       
  
       
       try{
                 File  progFile;   
                   progFile =new File("Elfin Fungi.txt");
                   if(!progFile.exists()){
                       progFile.createNewFile();
                 }   
            FileWriter  fw=  new FileWriter(progFile,true);
            BufferedWriter  bw =new BufferedWriter(fw);
            PrintWriter  pw = new PrintWriter(bw);
            pw.printf(taxonmsg,t.Taxon ,date_format,t.editors.getText(),t.colNo,t.PhotoNo);
             pw.printf(Chemmsg,ecp.getASCI(),ecp.getA_T(),ecp.getS_O_S());
            pw.printf(genmsg,egp.getSporoCap(),egp.getShape(),egp.getTaste(),egp.getAbhymeniumTexture(),egp.Odor,
                    egp.EntireHeight,egp.CapWidth,egp.StemLength,egp.CapFleshThickness,egp.FleshColorandBruising,
                    egp.AbhymeniumColor,egp.HymeniumColor);
                       pw.printf(Stalkmsg,s.getStalk(),s.Length,s.WidthatWidestPt,s.WidthatBase,
                              s.getShape(),s.getStemFleshText(), s.Surface_Color,s.Flesh_Color,s.getSurface());    
         pw.close();
         }catch(IOException  ioe){
                     System.out.println("Error  occured:");
                     ioe.printStackTrace();
                }
                              
       }
       
           if(jCoral_Fungus.isShowing())
       {
        
         String  surfacemsg ="   \r\n \r\n Surface Color  Characteristics"
              + "\r\n Tips %s"
              + "\r\n Stem %s  " 
              + "\r\n  Branches  %s "
              + "\r\n  Bruising   %s"
               + "\r\nYellow band at stme & band junction %s " ;
             
         String  branchmsg ="   \r\n \r\n  Branch Characteristics"
              + "\r\n  Stalk form %s"
              + "\r\n Flesh  Constituency  %s  " 
              + "\r\n  Branch Constituency  %s "
              + "\r\n Rhizomorps  present %s";
         
          String  genmsg ="   \r\n\r\nGeneral Characteristics"
              + "\r\nEntire  Height  %s"
              + " \r\nCrown Diameter  %s  "
              + "\r\n  Stem base width %s "
              +"\r\n  Stem  width %s"
                  + "\r\nOdour  %s "
              + "\r\n  Taste  %s"; 
         
       Taxonomy t= new Taxonomy(Taxon[3],CollectorNo[3],Photo[3], jCoralFungusCollectorsEdFeild);
       Coral_GenChar c_gc=new  Coral_GenChar(EntireHeight,Crown,Stem_Base,Stem_Width,Odor[2],Taste[2]);
       Branch_Char bc = new Branch_Char(Rhizo,BranchConst,Stalk,Flesh);
        SurfaceColor  sc = new SurfaceColor(Tips,Stem,Branches,Bruising,BJ);
       

       try{
                 File  progFile;   
                   progFile =new File("Coral Fungi.txt");
                   if(!progFile.exists()){
                       progFile.createNewFile();
                 }   
            FileWriter  fw=  new FileWriter(progFile,true);
            BufferedWriter  bw =new BufferedWriter(fw);
            PrintWriter  pw = new PrintWriter(bw);
            pw.printf(taxonmsg,t.Taxon ,date_format,t.editors.getText(),t.colNo,t.PhotoNo);
              pw.printf(genmsg,c_gc.Entire_height,c_gc.Crown_diam,c_gc.Stem_base_width,
                      c_gc.Stem_width,c_gc.Odor,c_gc.getTaste());
            pw.printf(surfacemsg,sc.Tips,sc.Stem,sc.Branches,sc.Bruising,sc.getBJ());
            pw.printf(branchmsg,bc.getStalkForm(),bc.getFlesh(),bc.getBranch(),bc.getRhizo());
           pw.close();
       }catch(IOException  ioe){
                     System.out.println("Error  occured:");
                     ioe.printStackTrace();
                }

        
       }}
    
    private void jGMStalkPresentCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMStalkPresentCBActionPerformed
        Object GM_StalkPresentObj = jGMStalkPresentCB.getSelectedItem();
           GM_StalkPresent=GM_StalkPresentObj.toString();
    }//GEN-LAST:event_jGMStalkPresentCBActionPerformed

    private void jGMStemConstCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMStemConstCBActionPerformed
         Object GM_StemConsistObj = jGMStemConstCB.getSelectedItem();
          GM_StemConsist=GM_StemConsistObj.toString();
    }//GEN-LAST:event_jGMStemConstCBActionPerformed

    private void jGMStalkCharShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMStalkCharShapeCBActionPerformed
         Object GM_StalkCharShapeObj = jGMStalkCharShapeCB.getSelectedItem();
         GM_StalkCharShape=GM_StalkCharShapeObj .toString();
    }//GEN-LAST:event_jGMStalkCharShapeCBActionPerformed

    private void jGBStalkCharFleshTextCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGBStalkCharFleshTextCBActionPerformed
         Object GM_StalkCharFleshObj = jGBStalkCharFleshTextCB.getSelectedItem();
          GM_StalkCharFlesh=GM_StalkCharFleshObj .toString();
    }//GEN-LAST:event_jGBStalkCharFleshTextCBActionPerformed

    private void jGMStalkCharSurfTextCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMStalkCharSurfTextCBActionPerformed
         Object GM_StalkCharSurfTextObj =jGMStalkCharSurfTextCB.getSelectedItem();
          GM_StalkCharSurfText=GM_StalkCharSurfTextObj .toString();
    }//GEN-LAST:event_jGMStalkCharSurfTextCBActionPerformed

    private void jStalkCharSurfOrnCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStalkCharSurfOrnCBActionPerformed
       
        Object GM_StalkCharSurfOrnbObj =jStalkCharSurfOrnCB.getSelectedItem();
                 GM_StalkCharSurfOrn=GM_StalkCharSurfOrnbObj.toString();
    }//GEN-LAST:event_jStalkCharSurfOrnCBActionPerformed

    private void jGilledMushroomsTaxonEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomsTaxonEdFeildActionPerformed
         int sLen;
      try{ 
        Taxon[0]   =   jGilledMushroomsTaxonEdFeild.getText();
        sLen=Taxon[0].length();
        if(sLen>0)
        { Taxonomy t= new Taxonomy(Taxon[0],null,null,null);}
         else
           JOptionPane.showMessageDialog(null,"Taxon feild is empty","error",JOptionPane.ERROR_MESSAGE);
      }catch (Exception e){}
    }//GEN-LAST:event_jGilledMushroomsTaxonEdFeildActionPerformed

    private void jGilledMushroomsPhotoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomsPhotoEdFeildActionPerformed
      int sLen;
      try{
        Photo[0]= jGilledMushroomsPhotoEdFeild.getText();
        sLen=Photo[0].length();
        if(sLen>0)
        {Taxonomy t= new Taxonomy(null,null,Photo[0],null);}
        
      JOptionPane.showMessageDialog(null,"Photo feild is empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception e){}
    }//GEN-LAST:event_jGilledMushroomsPhotoEdFeildActionPerformed

    private void jGilledMushroomColEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomColEdFieldActionPerformed
        Collector= jGilledMushroomColEdField.getText();
    }//GEN-LAST:event_jGilledMushroomColEdFieldActionPerformed

    private void jGMKOHFleshEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMKOHFleshEdFldActionPerformed
         KOH_Flesh=jGMKOHFleshEdFld.getText();

    }//GEN-LAST:event_jGMKOHFleshEdFldActionPerformed

    private void jGMelzersCapSurfEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMelzersCapSurfEdFldActionPerformed
       Melzer_Cap= jGMelzersCapSurfEdFld.getText();
    }//GEN-LAST:event_jGMelzersCapSurfEdFldActionPerformed

    private void jGMKOHEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMKOHEdFldActionPerformed
         KOH_Cap=jGMKOHEdFld.getText();
    }//GEN-LAST:event_jGMKOHEdFldActionPerformed

    private void jGMKOHParitalVeilEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMKOHParitalVeilEdFldActionPerformed
        KOH_Partial_Veil= jGMKOHParitalVeilEdFld.getText();
    }//GEN-LAST:event_jGMKOHParitalVeilEdFldActionPerformed

    private void jGMMelzersFleshEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMMelzersFleshEdFldActionPerformed
        Melzer_Flesh=jGMMelzersFleshEdFld.getText();
    }//GEN-LAST:event_jGMMelzersFleshEdFldActionPerformed

    private void jGMWidthatWidPtEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMWidthatWidPtEdFldActionPerformed
       WidthatWidestPt[0]  =jGMWidthatWidPtEdFld.getText();
    }//GEN-LAST:event_jGMWidthatWidPtEdFldActionPerformed

    private void jGMWidttatBaseEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMWidttatBaseEdFldActionPerformed
       WidthatBase[0]  =   jGMWidttatBaseEdFld.getText();

    }//GEN-LAST:event_jGMWidttatBaseEdFldActionPerformed

    private void jGMColorRemEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMColorRemEdFeildActionPerformed
    Color_Remnants= jGMColorRemEdFeild.getText();
    }//GEN-LAST:event_jGMColorRemEdFeildActionPerformed

    private void jGMLatexColorEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMLatexColorEdFldActionPerformed
    Latex_Color = jGMLatexColorEdFld.getText();
    }//GEN-LAST:event_jGMLatexColorEdFldActionPerformed

    private void jGilledMushroomCapFleshEditFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomCapFleshEditFeildActionPerformed
        Cap_Flesh[0]   = jGilledMushroomCapFleshEditFeild.getText();
    }//GEN-LAST:event_jGilledMushroomCapFleshEditFeildActionPerformed

    private void jGMGillAttachToStemCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMGillAttachToStemCBActionPerformed

        Object GM_jGGBGillAttachToStemObj =jGMGillAttachToStemCB.getSelectedItem();
        Gill_Attach_to_Stem= GM_jGGBGillAttachToStemObj .toString();

    }//GEN-LAST:event_jGMGillAttachToStemCBActionPerformed

    private void jGMGillEdgeShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMGillEdgeShapeCBActionPerformed
        Object GM_GillEdgeShapeObj = jGMGillEdgeShapeCB.getSelectedItem();
          Gill_Edge_Shape= GM_GillEdgeShapeObj.toString();
       
    }//GEN-LAST:event_jGMGillEdgeShapeCBActionPerformed

    private void jGMGillTextureCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMGillTextureCBActionPerformed
        Object GM_GillTextureObj =  jGMGillTextureCB.getSelectedItem();
           Gill_Texture=GM_GillTextureObj.toString();
    }//GEN-LAST:event_jGMGillTextureCBActionPerformed

    private void jGMThicknessCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMThicknessCBActionPerformed
       Object GM_ThicknessObj = jGMThicknessCB.getSelectedItem();
        Gill_Thickness=GM_ThicknessObj.toString();
    }//GEN-LAST:event_jGMThicknessCBActionPerformed

    private void jGMGillSpacingCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMGillSpacingCBActionPerformed
        Object GM_GillSpacingObj =jGMGillSpacingCB.getSelectedItem();
        Gill_Spacing=GM_GillSpacingObj.toString();
        

    }//GEN-LAST:event_jGMGillSpacingCBActionPerformed

    private void jGilledMushroomsTotalHeightEditFielldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomsTotalHeightEditFielldActionPerformed
       TTL_Height =jGilledMushroomsTotalHeightEditFielld.getText();
    }//GEN-LAST:event_jGilledMushroomsTotalHeightEditFielldActionPerformed

    private void jGilledMushroomCapWidEditFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomCapWidEditFieldActionPerformed
        GMCap_Width =jGilledMushroomCapWidEditField.getText();
    }//GEN-LAST:event_jGilledMushroomCapWidEditFieldActionPerformed

    private void jGilledMushroomSporeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomSporeCBActionPerformed
     Object  GM_SporeObj = jGilledMushroomSporeCB.getSelectedItem();
     Spore=GM_SporeObj .toString();
    }//GEN-LAST:event_jGilledMushroomSporeCBActionPerformed

    private void jGMLatexCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMLatexCBActionPerformed
      Object  GM_LatexObj =jGMLatexCB.getSelectedItem();
     Latex=GM_LatexObj .toString();
    }//GEN-LAST:event_jGMLatexCBActionPerformed

    private void jGMShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMShapeCBActionPerformed
   Object  GM_GShapeObj =  jGMShapeCB.getSelectedItem();
     Shape=GM_GShapeObj .toString();
    }//GEN-LAST:event_jGMShapeCBActionPerformed

    private void jGMSurfaceTextCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMSurfaceTextCBActionPerformed
       Object  GM_SuraceTextObj =  jGMSurfaceTextCB.getSelectedItem();
     Surface_Orn=GM_SuraceTextObj .toString();
    }//GEN-LAST:event_jGMSurfaceTextCBActionPerformed

    private void jGMSurfaceOrnCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMSurfaceOrnCBActionPerformed
         Object  GM_SuraceOrnObj =  jGMSurfaceOrnCB.getSelectedItem();
     Surface_Text=GM_SuraceOrnObj .toString();
    }//GEN-LAST:event_jGMSurfaceOrnCBActionPerformed

    private void jGMMarginContourCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMMarginContourCBActionPerformed
          Object GM_MarginContourObj = jGMMarginContourCB.getSelectedItem();
     Surface_Text=GM_MarginContourObj .toString();
    }//GEN-LAST:event_jGMMarginContourCBActionPerformed

    private void jGilledMushroomsTotalHeightEditFielldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomsTotalHeightEditFielldKeyTyped
       char iCode=evt.getKeyChar();
       if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
        jGilledMushroomsTotalHeightEditFielld.getText();
    }//GEN-LAST:event_jGilledMushroomsTotalHeightEditFielldKeyTyped

    private void jGilledMushroomCapWidEditFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomCapWidEditFieldKeyTyped
         char iCode=evt.getKeyChar();
         if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGilledMushroomCapWidEditField.getText();
    }//GEN-LAST:event_jGilledMushroomCapWidEditFieldKeyTyped

    private void jGilledMushroomCapCentreHgtEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomCapCentreHgtEdFeildKeyTyped
         char iCode=evt.getKeyChar();
         if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGilledMushroomCapCentreHgtEdFeild.getText();
    }//GEN-LAST:event_jGilledMushroomCapCentreHgtEdFeildKeyTyped

    private void jGilledMushroomsTaxonEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomsTaxonEdFeildKeyTyped
        char iCode=evt.getKeyChar();
         if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGilledMushroomsTaxonEdFeild.getText();
    }//GEN-LAST:event_jGilledMushroomsTaxonEdFeildKeyTyped

    private void jGilledMushroomColEdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomColEdFieldKeyTyped
         char iCode=evt.getKeyChar();
           if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
                jGilledMushroomColEdField.getText();
    }//GEN-LAST:event_jGilledMushroomColEdFieldKeyTyped

    private void jGilledMushroomsPhotoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomsPhotoEdFeildKeyTyped
        char iCode=evt.getKeyChar();
         if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              jGilledMushroomsPhotoEdFeild.getText();
    }//GEN-LAST:event_jGilledMushroomsPhotoEdFeildKeyTyped

    private void jGilledMushroomCapSurfaceEditFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomCapSurfaceEditFieldKeyTyped
           char iCode=evt.getKeyChar();
            if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
                jGilledMushroomCapSurfaceEditField.getText();
    }//GEN-LAST:event_jGilledMushroomCapSurfaceEditFieldKeyTyped

    private void jGilledMushroomStemSuraceEditFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomStemSuraceEditFeildKeyTyped
          char iCode=evt.getKeyChar(); 
           if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
               jGilledMushroomStemSuraceEditFeild.getText();
    }//GEN-LAST:event_jGilledMushroomStemSuraceEditFeildKeyTyped

    private void jGilledMushroomCapFleshEditFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomCapFleshEditFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              jGilledMushroomCapFleshEditFeild.getText();
    }//GEN-LAST:event_jGilledMushroomCapFleshEditFeildKeyTyped

    private void jGilledMushroomStemFleshEditFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGilledMushroomStemFleshEditFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
               jGilledMushroomStemFleshEditFeild.getText();
    }//GEN-LAST:event_jGilledMushroomStemFleshEditFeildKeyTyped

    private void jGilledMushroomMGCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGilledMushroomMGCBActionPerformed
       Object GM_MGObj = jGilledMushroomMGCB.getSelectedItem();
                 Mature_Gills= jGilledMushroomMGCB.toString();
    }//GEN-LAST:event_jGilledMushroomMGCBActionPerformed

    private void jGMVeilColorEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMVeilColorEdFldActionPerformed
        Veil_Color=jGMVeilColorEdFld.getText();
    }//GEN-LAST:event_jGMVeilColorEdFldActionPerformed

    private void jGMVeilColorEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMVeilColorEdFldKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER && Character.isLetterOrDigit(iCode))
              jGMVeilColorEdFld.getText();
    }//GEN-LAST:event_jGMVeilColorEdFldKeyTyped

    private void jGMUniversalVeilPresCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMUniversalVeilPresCBActionPerformed
   Object GM_UniversalVeilPresObj =   jGMUniversalVeilPresCB.getSelectedItem();
                 Universal_Veil_Present= GM_UniversalVeilPresObj .toString();
    }//GEN-LAST:event_jGMUniversalVeilPresCBActionPerformed

    private void jGMUniversalVeilRemCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMUniversalVeilRemCBActionPerformed
     Object GM_UniversalVeilRemObj =   jGMUniversalVeilRemCB.getSelectedItem();
                 Universal_Veil_Remnant= GM_UniversalVeilRemObj  .toString();
    }//GEN-LAST:event_jGMUniversalVeilRemCBActionPerformed

    private void jGMColorRemEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMColorRemEdFeildKeyTyped
    char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGMColorRemEdFeild.getText();
    }//GEN-LAST:event_jGMColorRemEdFeildKeyTyped

    private void jGMVolvaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMVolvaCBActionPerformed
       Object GM_VolvaObj =   jGMVolvaCB.getSelectedItem();
            Volva= GM_VolvaObj .toString();
    }//GEN-LAST:event_jGMVolvaCBActionPerformed

    private void jGMWidthatWidPtEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMWidthatWidPtEdFldKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          
        
             jGMWidthatWidPtEdFld.getText();
    }//GEN-LAST:event_jGMWidthatWidPtEdFldKeyTyped

    private void jGMWidttatBaseEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMWidttatBaseEdFldKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGMWidttatBaseEdFld.getText();
    }//GEN-LAST:event_jGMWidttatBaseEdFldKeyTyped

    
    private void jGMKOHEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMKOHEdFldKeyTyped
         char iCode=evt.getKeyChar();
           if(iCode== KeyEvent.VK_ENTER && Character.isLetterOrDigit(iCode))
             jGMKOHEdFld.getText();
    }//GEN-LAST:event_jGMKOHEdFldKeyTyped

    private void jGMKOHFleshEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMKOHFleshEdFldKeyTyped
         char iCode=evt.getKeyChar();
         if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             jGMKOHFleshEdFld.getText();
    }//GEN-LAST:event_jGMKOHFleshEdFldKeyTyped

    private void jGMMelzersFleshEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMMelzersFleshEdFldKeyTyped
            char iCode=evt.getKeyChar();
             if(iCode== KeyEvent.VK_ENTER && Character.isLetterOrDigit(iCode))
             jGMMelzersFleshEdFld.getText();
    }//GEN-LAST:event_jGMMelzersFleshEdFldKeyTyped

    private void jGMKOHParitalVeilEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jGMKOHParitalVeilEdFldKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              jGMKOHParitalVeilEdFld.getText();
    }//GEN-LAST:event_jGMKOHParitalVeilEdFldKeyTyped

    
   
    private void date_field2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_field2ActionPerformed
      date_field.setText(date_format);
    }//GEN-LAST:event_date_field2ActionPerformed

    private void jBFCollectNoEdFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFCollectNoEdFldActionPerformed
        int   sLen;
         try{
        CollectorNo[1] =    jBFCollectNoEdFld.getText();
        sLen= CollectorNo[1] .length();
        if(sLen>0)
        {Taxonomy t= new Taxonomy(null,CollectorNo[1],null,null);}
        else
        JOptionPane.showMessageDialog(null,"Collector No feild is empty","error",JOptionPane.ERROR_MESSAGE); 
         }catch(Exception e){}
    }//GEN-LAST:event_jBFCollectNoEdFldActionPerformed

    private void jPhotoNoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhotoNoEdFeildActionPerformed
       int sLen;
       try{
        Photo[1]=jPhotoNoEdFeild.getText();
       sLen=Photo[1].length();
       if(sLen>0)
       {Taxonomy t= new Taxonomy(null,null,Photo[1],null);}
       else
           JOptionPane.showMessageDialog(null,"Photo No feild is empty","error",JOptionPane.ERROR_MESSAGE);
       }catch(Exception e){}
     
       
    }//GEN-LAST:event_jPhotoNoEdFeildActionPerformed

    private void jBFTaxonEdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFTaxonEdFieldKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              jBFTaxonEdField.getText();
    }//GEN-LAST:event_jBFTaxonEdFieldKeyTyped

    private void jPhotoNoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPhotoNoEdFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              Photo[1]=jPhotoNoEdFeild.getText();
    }//GEN-LAST:event_jPhotoNoEdFeildKeyTyped

    private void jBFTaxonEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFTaxonEdFieldActionPerformed
        int sLen;
        try{
        Taxon[1]=   jBFTaxonEdField.getText();
        sLen=Taxon[1].length();
         if(sLen>0)
         {Taxonomy t= new Taxonomy(Taxon[1],null,null, null);}
          else
          JOptionPane.showMessageDialog(null,"Taxonl feild empty","error",JOptionPane.ERROR_MESSAGE);
        }catch(Exception e) {};
    }//GEN-LAST:event_jBFTaxonEdFieldActionPerformed

    private void jBFCollectNoEdFldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFCollectNoEdFldKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              CollectorNo[1]=jBFCollectNoEdFld.getText();
               Taxonomy t= new Taxonomy(null,null,CollectorNo[1],null);
          }
    }//GEN-LAST:event_jBFCollectNoEdFldKeyTyped

    private void jBFsmelllEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFsmelllEdFieldActionPerformed
    int sLen;
          try{
        Odor[1]=jBFsmelllEdField.getText();
           sLen=  Odor[1].length();
       if (sLen>0)
         {    General_Characteristics  g= new General_Characteristics(null,Odor[1],null,null,null);   }
        else
            JOptionPane.showMessageDialog(null," Odour feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};   
       
    }//GEN-LAST:event_jBFsmelllEdFieldActionPerformed

    private void jBFsmelllEdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFsmelllEdFieldKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
               Odor[1] = jBFsmelllEdField.getText();
               General_Characteristics  g= new General_Characteristics(null,Odor[1],null,null,null);
          }
    }//GEN-LAST:event_jBFsmelllEdFieldKeyTyped

    private void jBFTasteCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFTasteCBActionPerformed
   Object BF_TasteObj =   jBFTasteCB.getSelectedItem();
   Taste[0]=  BF_TasteObj .toString();
   General_Characteristics  g= new General_Characteristics(null,null,null,null,Taste[0]);
    
    }//GEN-LAST:event_jBFTasteCBActionPerformed

    private void jBCapHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCapHeightActionPerformed
    int sLen;
     
         try{
            BF_CapHght=jBCapHeight.getText();
           sLen=  BF_CapHght.length();
       if (sLen>0)
         {    General_Characteristics  g= new General_Characteristics(null,null,null,BF_CapHght,null);   }
        else
            JOptionPane.showMessageDialog(null," Cap Height feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};   
    }//GEN-LAST:event_jBCapHeightActionPerformed

    private void jBCapHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCapHeightKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
                BF_CapHght= jBCapHeight.getText();
               General_Characteristics  g= new General_Characteristics(null,null,null,BF_CapHght,null);
          }
    }//GEN-LAST:event_jBCapHeightKeyTyped

    private void jBCapWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCapWidthActionPerformed
       int sLen;
       try{
           BFCap_Width=    jBCapWidth.getText();
         sLen=  BFCap_Width.length();
       if (sLen>0)
         {    General_Characteristics  g= new General_Characteristics(null,null,BFCap_Width,null,null);   }
        else
            JOptionPane.showMessageDialog(null," Cap Width feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
 
    }//GEN-LAST:event_jBCapWidthActionPerformed

    private void jBCapWidthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBCapWidthKeyReleased
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              BFCap_Width= jBCapWidth.getText();
               General_Characteristics  g= new General_Characteristics(null,null,BFCap_Width,null,null);
          }
    }//GEN-LAST:event_jBCapWidthKeyReleased

    private void jBoleteSporoCapCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteSporoCapCBActionPerformed
      Object BF_SporocapObj =   jBoleteSporoCapCB.getSelectedItem();
   Sporocap=   BF_SporocapObj.toString();
   General_Characteristics  g= new General_Characteristics(Sporocap,null,null,null,null);
    }//GEN-LAST:event_jBoleteSporoCapCBActionPerformed

    private void jGM_CollectorsEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGM_CollectorsEdFieldActionPerformed
          CollectorNo[0] =jGM_CollectorsEdField.getText();
    }//GEN-LAST:event_jGM_CollectorsEdFieldActionPerformed

    private void jBFCapSurfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFCapSurfaceActionPerformed
      int sLen;
      try{
        Cap_Surface[1]=   jBFCapSurface.getText();
         sLen=Cap_Surface[1] .length();
       if (sLen>0)
         {   Color   c=  new Color(Cap_Surface[1],null,null,null,null,null);    }
        else
            JOptionPane.showMessageDialog(null," Cap Surface feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
 
    }//GEN-LAST:event_jBFCapSurfaceActionPerformed

    private void jBFCapSurfaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFCapSurfaceKeyTyped
          char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
          Cap_Surface[1] =    jBFCapSurface.getText();
             Color   c=  new Color(Cap_Surface[1],null,null,null,null,null);
    }//GEN-LAST:event_jBFCapSurfaceKeyTyped
    } 
    
    
    private void jBGCapFleshEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGCapFleshEdFieldActionPerformed
       int sLen;
       try{
        jBFCap_Flesh=jBGCapFleshEdField.getText();
         sLen=jBFCap_Flesh .length();
       if (sLen>0)
         {    Color   c=  new Color( null,jBFCap_Flesh,null,null,null,null);     }
        else
            JOptionPane.showMessageDialog(null," Cap Flesh feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
       
    }//GEN-LAST:event_jBGCapFleshEdFieldActionPerformed

    private void jBGCapFleshEdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBGCapFleshEdFieldKeyTyped
      char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              jBFCap_Flesh= jBGCapFleshEdField.getText();
             Color   c=  new Color( null,jBFCap_Flesh,null,null,null,null);
    }//GEN-LAST:event_jBGCapFleshEdFieldKeyTyped
   }

    private void PoreLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoreLayerActionPerformed
        int  sLen;
        try{
        Pore_Layer= PoreLayer.getText();
         sLen=Pore_Layer .length();
       if (sLen>0)
         {      Color   c=  new Color( null,null,Pore_Layer,null,null,null); }
        else
            JOptionPane.showMessageDialog(null," Pore feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
        Color   c=  new Color( null,null,Pore_Layer,null,null,null);
        
    }//GEN-LAST:event_PoreLayerActionPerformed

    private void PoreLayerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PoreLayerKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              Pore_Layer= PoreLayer.getText();
             Color   c=  new Color( null,null,Pore_Layer,null,null,null);
    }          
    }//GEN-LAST:event_PoreLayerKeyTyped

    private void jBFStemFleshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFStemFleshActionPerformed
     int sLen;
     try{
        Stem_Flesh= jBFStemFlesh.getText();
           sLen=Stem_Flesh .length();
       if (sLen>0)
         {    Color   c=  new Color( null,null,null,null,Stem_Flesh,null);   }
        else
            JOptionPane.showMessageDialog(null," Stem Flesh empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
       
    }//GEN-LAST:event_jBFStemFleshActionPerformed

    private void jBFStemFleshKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFStemFleshKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              Stem_Flesh= jBFStemFlesh.getText();
             Color   c=  new Color( null,null,null,null,Stem_Flesh,null);
    }      
    }//GEN-LAST:event_jBFStemFleshKeyTyped

    private void jBFStemSurfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFStemSurfaceActionPerformed
       int  sLen;
       try{
        Stem_Surface= jBFStemSurface.getText();
        sLen=Stem_Surface .length();
       if (sLen>0)
         {   Color   c=  new Color( null,null,null,Stem_Surface,null,null);   }
        else
            JOptionPane.showMessageDialog(null," Stem Surface empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
        
    }//GEN-LAST:event_jBFStemSurfaceActionPerformed

    private void jBFStemSurfaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFStemSurfaceKeyTyped
      char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              Stem_Surface= jBFStemSurface.getText();
             Color   c=  new Color( null,null,null,Stem_Surface,null,null);
    }      
    }//GEN-LAST:event_jBFStemSurfaceKeyTyped

    private void jBFBruisingEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFBruisingEdFeildActionPerformed
        int sLen;
        try{    
        jBF_BR=jBFBruisingEdFeild.getText();
         sLen=jBF_BR .length();
       if (sLen>0)
         {  Color   c=  new Color( null,null,null,null,null,jBF_BR);      }
        else
            JOptionPane.showMessageDialog(null," Brusing feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
     
    }//GEN-LAST:event_jBFBruisingEdFeildActionPerformed

    private void jBFBruisingEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBFBruisingEdFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              jBF_BR= jBFBruisingEdFeild.getText();
             Color   c=  new Color( null,null,null,null,null,jBF_BR);
    }      
    }//GEN-LAST:event_jBFBruisingEdFeildKeyTyped

    private void jBoleteCSComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteCSComboBoxActionPerformed
         Object jBolete_CSObj= jBoleteCSComboBox.getSelectedItem();
        Stem_Texture=jBolete_CSObj.toString();
        Cap    cap= new Cap(Stem_Texture,null,null,null);
        
    }//GEN-LAST:event_jBoleteCSComboBoxActionPerformed

    private void jBoleteCapShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteCapShapeCBActionPerformed
     Object jBolete_CapShapeObj=  jBoleteCapShapeCB.getSelectedItem();
       Cap_Shape=jBolete_CapShapeObj.toString();
        Cap    cap= new Cap(null,Cap_Shape,null,null);
        
    }//GEN-LAST:event_jBoleteCapShapeCBActionPerformed

    private void jBoleteFleshConstCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteFleshConstCBActionPerformed
         Object jBolete_FleshObj=  jBoleteFleshConstCB.getSelectedItem();
       Flesh_Const=jBolete_FleshObj.toString();
        Cap    cap= new Cap(null,null,Flesh_Const,null);
        
    }//GEN-LAST:event_jBoleteFleshConstCBActionPerformed

    private void jBoleteSurfaceOrnCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteSurfaceOrnCBActionPerformed
       Object jBolete_SurfaceOrnObj=jBoleteSurfaceOrnCB .getSelectedItem();
       Surface_Orn=jBolete_SurfaceOrnObj.toString();
        Cap    cap= new Cap(null,null,null,Surface_Orn);
    }//GEN-LAST:event_jBoleteSurfaceOrnCBActionPerformed

    private void jBoleteOrnamentionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteOrnamentionCBActionPerformed
       Object jBolete_StalkCharOrnObj= jBoleteOrnamentionCB.getSelectedItem();
       Ornamentation=jBolete_StalkCharOrnObj.toString();
        Stalk  s= new Stalk(null,null,null,null,null,null,null,Ornamentation);
    }//GEN-LAST:event_jBoleteOrnamentionCBActionPerformed

    private void jBoleteSurfaceTextureCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteSurfaceTextureCBActionPerformed
        Object jBolete_SurfaceTextureObj= jBoleteSurfaceTextureCB.getSelectedItem();
       Surface_Texture=jBolete_SurfaceTextureObj.toString();
        Stalk  s= new Stalk(null,null,null,null,null,null,Surface_Texture,null);
    }//GEN-LAST:event_jBoleteSurfaceTextureCBActionPerformed

    private void jBoleteStalkSurfaceOrnCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteStalkSurfaceOrnCBActionPerformed
        Object jBolete_StalkSurfaceOrnObj= jBoleteStalkSurfaceOrnCB.getSelectedItem();
       Stalk_SO=jBolete_StalkSurfaceOrnObj.toString();
        Stalk  s= new Stalk(null,null,null,null,null,Stalk_SO,null,null);
    }//GEN-LAST:event_jBoleteStalkSurfaceOrnCBActionPerformed

    private void jBoleteAnnulusCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteAnnulusCBActionPerformed
      Object jBolete_AnnulusObj=jBoleteAnnulusCB.getSelectedItem();
       Annulus=jBolete_AnnulusObj.toString();
        Stalk  s= new Stalk(null,Annulus,null,null,null,null,null,null);
    }//GEN-LAST:event_jBoleteAnnulusCBActionPerformed

    private void jBoleteAnnulusColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteAnnulusColorActionPerformed
       int  sLen;
       try{
              Annulus_Color= jBoleteAnnulusColor.getText();
             sLen=Annulus_Color .length();
       if (sLen>0)
         {     Stalk  s= new Stalk(null,null,Annulus_Color,null,null,null,null,null);     }
        else
            JOptionPane.showMessageDialog(null," Annulus Color feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
                  

    }//GEN-LAST:event_jBoleteAnnulusColorActionPerformed

    private void jBoleteAnnulusColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoleteAnnulusColorKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
              Annulus_Color= jBoleteAnnulusColor.getText();
                      Stalk  s= new Stalk(null,null,Annulus_Color,null,null,null,null,null);
          }
    }//GEN-LAST:event_jBoleteAnnulusColorKeyTyped

    private void jBoleteWidthatBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoleteWidthatBaseKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
            WidthatBase[1]  = jBoleteWidthatBase.getText();
                      Stalk  s= new Stalk(null,null,null,null,WidthatBase[1],null,null,null);
    }                                            

    }//GEN-LAST:event_jBoleteWidthatBaseKeyTyped

    private void jBoleteWidthatBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteWidthatBaseActionPerformed
       int  sLen;
       try{
        WidthatBase[1]  = jBoleteWidthatBase.getText();
            sLen=WidthatBase[1] .length();
       if (sLen>0)
         {        Stalk  s= new Stalk(null,null,null,null,WidthatBase[1],null,null,null);   }
        else
            JOptionPane.showMessageDialog(null," Width at  Base feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
                  
          
    }//GEN-LAST:event_jBoleteWidthatBaseActionPerformed

    private void jBoleteWidthatWidestPtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteWidthatWidestPtActionPerformed
      int sLen;
        try{
        WidthatWidestPt[1]  = jBoleteWidthatWidestPt.getText();
          sLen=WidthatWidestPt[1] .length();
       if (sLen>0)
         {      Stalk  s= new Stalk(null,null,null,WidthatWidestPt[1],null,null,null,null);  }
        else
            JOptionPane.showMessageDialog(null," WidthatWidest Pt feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
                      
    }//GEN-LAST:event_jBoleteWidthatWidestPtActionPerformed

    private void jBoleteWidthatWidestPtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoleteWidthatWidestPtKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
            WidthatWidestPt[1]  = jBoleteWidthatWidestPt.getText();
                      Stalk  s= new Stalk(null,null,null,WidthatWidestPt[1],null,null,null,null);
          
    }             
    }//GEN-LAST:event_jBoleteWidthatWidestPtKeyTyped

    private void jBoleteSCLengthEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoleteSCLengthEdFeildActionPerformed
        int sLen;
        try{
            Length  = jBoleteSCLengthEdFeild.getText();
            sLen=Length.length();
       if (sLen>0)
         {   Stalk  s= new Stalk(Length,null,null,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Length feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
                    
    }//GEN-LAST:event_jBoleteSCLengthEdFeildActionPerformed

    private void jBoleteSCLengthEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoleteSCLengthEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {
           Length  =jBoleteSCLengthEdFeild.getText();
                      Stalk  s= new Stalk(null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jBoleteSCLengthEdFeildKeyTyped
    
    private void jElfinASCICBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinASCICBActionPerformed
          Object jElfinASCIObj= jElfinASCICB.getSelectedItem();
        ASCI=jElfinASCIObj.toString();
        Elfin_Chemical_properties ecp=  new Elfin_Chemical_properties(ASCI,null,null);
        
    }//GEN-LAST:event_jElfinASCICBActionPerformed

    private void jElfinNucleiCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinNucleiCBActionPerformed
        Object jElfinNucleiObj= jElfinNucleiCB.getSelectedItem();
       Nuclei=jElfinNucleiObj.toString();
        Elfin_Chemical_properties ecp=  new Elfin_Chemical_properties(null,Nuclei,null);
    }//GEN-LAST:event_jElfinNucleiCBActionPerformed

    private void jElfinSporeOrnCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSporeOrnCBActionPerformed
        Object jElfinSporeOrnObj= jElfinSporeOrnCB.getSelectedItem();
       SporeOrn=jElfinSporeOrnObj.toString();
        Elfin_Chemical_properties ecp=  new Elfin_Chemical_properties(null,null,SporeOrn);
    }//GEN-LAST:event_jElfinSporeOrnCBActionPerformed

    
    
    private void jElfinSporocapCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSporocapCBActionPerformed
     Object  jElfinSporeCapObj=jElfinSporocapCB.getSelectedItem();
     SporeCap= jElfinSporeCapObj.toString();
     Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,null,SporeCap,null,null,null);
    }//GEN-LAST:event_jElfinSporocapCBActionPerformed

    
    private void jElfinShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinShapeCBActionPerformed
         Object  jElfinShapeObj=jElfinShapeCB.getSelectedItem();
     Shape= jElfinShapeObj.toString();
     Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,null,null,Shape,null,null);
      
     
    }//GEN-LAST:event_jElfinShapeCBActionPerformed

    
    private void jElfinTasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinTasteActionPerformed
         Object  jElfinTasteObj=jElfinTaste.getSelectedItem();
     Taste[2]= jElfinTasteObj.toString();
     Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,null,null,null,Taste[2],null);
    }//GEN-LAST:event_jElfinTasteActionPerformed

    private void jElfinAbhymenumCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinAbhymenumCBActionPerformed
     Object  jElfinAbhymenumObj=jElfinAbhymenumCB.getSelectedItem();
     AbHym= jElfinAbhymenumObj.toString();
     Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,null,null,null,null,AbHym);
    }//GEN-LAST:event_jElfinAbhymenumCBActionPerformed

    private void jElfinOdorEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinOdorEdFeildActionPerformed
     int sLen;
     try{
         Odor[2]  = jElfinOdorEdFeild.getText();
           sLen=Odor[2].length();
        if (sLen>0)
         { Elfin_GenChar egp=new Elfin_GenChar(Odor[2],null,null,null,null,null,null,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Entire Height feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
     
    }//GEN-LAST:event_jElfinOdorEdFeildActionPerformed

    private void jElfinOdorEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinOdorEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
            Odor[2]  = jElfinOdorEdFeild.getText();
           Elfin_GenChar egp=new Elfin_GenChar(Odor[2],null,null,null,null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinOdorEdFeildKeyTyped

    private void jElfinEntireHeightEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinEntireHeightEdFeildActionPerformed
        int  sLen;
        try{
            EntireHeight  = jElfinEntireHeightEdFeild.getText();
            sLen=EntireHeight.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,EntireHeight,null,null,null,null,null,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Entire Height feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
       
    }//GEN-LAST:event_jElfinEntireHeightEdFeildActionPerformed

    private void jElfinEntireHeightEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinEntireHeightEdFeildKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
            EntireHeight = jElfinEntireHeightEdFeild.getText();
           Elfin_GenChar egp=new Elfin_GenChar(null,EntireHeight,null,null,null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinEntireHeightEdFeildKeyTyped

    private void jElfinCapWidEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinCapWidEdFeildActionPerformed
     int sLen;
     try{
          CapWidth = jElfinCapWidEdFeild.getText();
        sLen=CapWidth.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,CapWidth,null,null,null,null,null,CapfleshThickness,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Cap  Width feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
        
      
    }//GEN-LAST:event_jElfinCapWidEdFeildActionPerformed

    private void jElfinCapWidEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinCapWidEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
            CapWidth = jElfinCapWidEdFeild.getText();
           Elfin_GenChar egp=new Elfin_GenChar(null,null,CapWidth,null,null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinCapWidEdFeildKeyTyped

    private void jElfiinStemLenEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfiinStemLenEdFeildActionPerformed
       int sLen;
       try{
            StemLen=jElfiinStemLenEdFeild.getText();
          sLen=StemLen.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,null,StemLen,null,null,null,null,CapfleshThickness,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Stem length feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
       
          
    }//GEN-LAST:event_jElfiinStemLenEdFeildActionPerformed

    private void jElfiinStemLenEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfiinStemLenEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
            StemLen =jElfiinStemLenEdFeild.getText();
           Elfin_GenChar egp=new Elfin_GenChar(null,null,null,StemLen,null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfiinStemLenEdFeildKeyTyped

    private void jElfinCapFleshThicknessEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinCapFleshThicknessEdFeildActionPerformed
     int sLen;
     try{
           CapfleshThickness=jElfinCapFleshThicknessEdFeild.getText();
       sLen=CapfleshThickness.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,null,CapfleshThickness,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Cap  Flesh feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};   
    
    }//GEN-LAST:event_jElfinCapFleshThicknessEdFeildActionPerformed

    private void jElfinCapFleshThicknessEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinCapFleshThicknessEdFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
            CapfleshThickness= jElfinCapFleshThicknessEdFeild.getText();
           Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,null,CapfleshThickness,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinCapFleshThicknessEdFeildKeyTyped

    private void jElfinBruisingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinBruisingActionPerformed
     int sLen;
     try{
        Bruising=jElfinBruising.getText();
          sLen=Bruising.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,Bruising,null,null,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null,"  Bruising  feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
  
    }//GEN-LAST:event_jElfinBruisingActionPerformed

    private void jElfinBruisingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinBruisingKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
           Bruising=jElfinBruising.getText();
           Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,Bruising,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinBruisingKeyTyped

    private void jElfinHymeniumColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinHymeniumColActionPerformed
      int sLen;
        try{  
             HymeniumColor=jElfinHymeniumCol.getText();
           sLen=HymeniumColor.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,HymeniumColor,null,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Hymenium feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};  
            
        HymeniumColor=jElfinHymeniumCol.getText();
    Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,HymeniumColor,null,null,null,null,null,null);
    }//GEN-LAST:event_jElfinHymeniumColActionPerformed

    private void jElfinAbbhColorEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinAbbhColorEdFeildActionPerformed
  int  sLen;
     try{
        AbHymeniumColor=jElfinAbbhColorEdFeild.getText();
          sLen=AbHymeniumColor.length();
        if (sLen>0)
         {Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,AbHymeniumColor,null,null,null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Hymenium feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){}; 
    Elfin_GenChar egp=new Elfin_GenChar(null,null,null,null,null,null,AbHymeniumColor,null,null,null,null,null);
    }//GEN-LAST:event_jElfinAbbhColorEdFeildActionPerformed

    private void jElfinTaxonEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinTaxonEdFeildActionPerformed
      int sLen;
      try{
        Taxon[2]=jElfinTaxonEdFeild.getText();
        sLen=Taxon[2].length();
        if (sLen>0)
         {Taxonomy t= new Taxonomy(Taxon[2],null,null,null);}
        else
            JOptionPane.showMessageDialog(null," Taxon feild empty","error",JOptionPane.ERROR_MESSAGE);
      }catch(Exception  e){};
    }//GEN-LAST:event_jElfinTaxonEdFeildActionPerformed

    private void jElfinTaxonEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinTaxonEdFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER && Character.isLetterOrDigit(iCode))
              jBFTaxonEdField.getText();
          Taxonomy t= new Taxonomy(Taxon[2],null,null,null);
    }//GEN-LAST:event_jElfinTaxonEdFeildKeyTyped

    private void date_field3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_field3ActionPerformed
               date_field3.setText(date_format);
    }//GEN-LAST:event_date_field3ActionPerformed

    private void jElfincollectorNoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfincollectorNoEdFeildActionPerformed
         int  sLen; 
         try{
        CollectorNo[2]=jElfincollectorNoEdFeild.getText();
        sLen=CollectorNo[2].length();
         if (sLen>0)
         { Taxonomy t= new Taxonomy(null,null,CollectorNo[2],null);}
         else
             JOptionPane.showMessageDialog(null,"CollectNo label feild empty","error",JOptionPane.ERROR_MESSAGE);
         }catch(Exception e){}
        
    }//GEN-LAST:event_jElfincollectorNoEdFeildActionPerformed

    private void jElfincollectorNoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfincollectorNoEdFeildKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
              CollectorNo[2]=jElfincollectorNoEdFeild.getText();
          Taxonomy t= new Taxonomy(null, null,null,null);
    }//GEN-LAST:event_jElfincollectorNoEdFeildKeyTyped

    private void jElfinPhotoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinPhotoEdFeildActionPerformed
    int  sLen;
       try{   
        Photo[2]=jElfinPhotoEdFeild.getText();
        sLen=Photo[2].length();
        if (sLen>0)
         { Taxonomy t= new Taxonomy(null,null,Photo[2],null);}
        else
        JOptionPane.showMessageDialog(null,"Photo feild is empty","error",JOptionPane.ERROR_MESSAGE);
       } catch(NullPointerException e){};

    }//GEN-LAST:event_jElfinPhotoEdFeildActionPerformed

    private void jElfinPhotoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinPhotoEdFeildKeyTyped
    char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
             Photo[2]=jElfinPhotoEdFeild.getText();
          Taxonomy t= new Taxonomy(null, null,Photo[2],null);
    }//GEN-LAST:event_jElfinPhotoEdFeildKeyTyped

    private void jElfinStalkCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinStalkCBActionPerformed
         Object  jElfinStalkObj= jElfinStalkCB.getSelectedItem();
     Stalk= jElfinStalkObj.toString();
     Elfin_StalkChar  s=  new Elfin_StalkChar(null,null,null,Stalk,null,null,null,null,null);
     
    }//GEN-LAST:event_jElfinStalkCBActionPerformed

    private void jElfinStalkLenEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinStalkLenEdFeildActionPerformed
   int sLen;
        try{
       StalkLen=jElfinStalkLenEdFeild.getText();
        sLen= StalkLen.length();
          if (sLen>0)
         {Elfin_StalkChar s=new Elfin_StalkChar(null,null,StalkLen,null,null,null,null,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Flesh  Color feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
    Elfin_StalkChar s=new Elfin_StalkChar(null,null,StalkLen,null,null,null,null,null,null);
    }//GEN-LAST:event_jElfinStalkLenEdFeildActionPerformed

    private void jElfinFleshColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinFleshColorActionPerformed
     int sLen;
        try{
        FleshColor= jElfinFleshColor.getText();
         sLen= FleshColor.length();
          if (sLen>0)
         {Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,null,FleshColor,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Flesh  Color feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
    Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,null,FleshColor,null,null);
    }//GEN-LAST:event_jElfinFleshColorActionPerformed

    private void jElfinFleshColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinFleshColorKeyTyped
   char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
              jElfinFleshColor.requestFocus();
             FleshColor=jElfinFleshColor.getText();
            Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,null,FleshColor,null,null);
    }//GEN-LAST:event_jElfinFleshColorKeyTyped
    }
    
    private void jElfinStalkLenEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinStalkLenEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
              jElfinStalkLenEdFeild.requestFocus();
              StalkLen=jElfinStalkLenEdFeild.getText();
              Elfin_StalkChar s=new Elfin_StalkChar(null,null,StalkLen,null,null,null,null,null,null);
    }                                 
    }//GEN-LAST:event_jElfinStalkLenEdFeildKeyTyped

    private void jElfinSurfaceColorEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSurfaceColorEdFeildActionPerformed
     int sLen;
        try{
        SurfaceColor=jElfinSurfaceColorEdFeild.getText();
        sLen= SurfaceColor.length();
          if (sLen>0)
         {Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,SurfaceColor,null,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Surface feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
    Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,SurfaceColor,null,null,null);
    }//GEN-LAST:event_jElfinSurfaceColorEdFeildActionPerformed

    private void jElfinSurfaceColorEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinSurfaceColorEdFeildKeyTyped
         char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jElfinSurfaceColorEdFeild.requestFocus();
              SurfaceColor=jElfinSurfaceColorEdFeild.getText();
              Elfin_StalkChar s=new Elfin_StalkChar(null,null,null,null,null,SurfaceColor,null,null,null);
    }                                 
    }//GEN-LAST:event_jElfinSurfaceColorEdFeildKeyTyped

    private void jElfinWidthatBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinWidthatBaseActionPerformed
       int sLen;
        
        try{
        WidthatBase[2]=jElfinWidthatBase.getText();
        sLen= WidthatBase[2].length();
          if (sLen>0)
         {Elfin_StalkChar s=new Elfin_StalkChar(null,WidthatBase[2],null,null,null,null,null,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Width  at Base feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
        
        Elfin_StalkChar s=new Elfin_StalkChar(null,WidthatBase[2],null,null,null,null,null,null,null);
    }//GEN-LAST:event_jElfinWidthatBaseActionPerformed

    private void jElfinWidthatBaseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinWidthatBaseKeyTyped
      char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jElfinWidthatBase.requestFocus();
             jElfinWidthatBase.getText();
              Elfin_StalkChar s=new Elfin_StalkChar(null,WidthatBase[2],null,null,null,null,null,null,null);
    }                                 
    }//GEN-LAST:event_jElfinWidthatBaseKeyTyped

    private void jElfinWWPtEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinWWPtEdFeildActionPerformed
   int  sLen;

       try{
        WidthatWidestPt[2]=jElfinWWPtEdFeild.getText();
     sLen= WidthatWidestPt[2].length();
          if (sLen>0)
          {Elfin_StalkChar s=new Elfin_StalkChar(WidthatWidestPt[2],null,null,null,null,null,null,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Width at Widest Pt feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
    }//GEN-LAST:event_jElfinWWPtEdFeildActionPerformed

    private void jElfinSFTCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSFTCBActionPerformed
    Object  jElfinSFTobj= jElfinStalkCB.getSelectedItem();
     SFT= jElfinSFTobj.toString();
     Elfin_StalkChar  s=  new Elfin_StalkChar(null,null,null,null,null,null,null,SFT,null);
    }//GEN-LAST:event_jElfinSFTCBActionPerformed

    private void jElfinSCShapeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSCShapeCBActionPerformed
       Object  jElfinSCShapeObj= jElfinSCShapeCB.getSelectedItem();
     SCShape= jElfinSCShapeObj.toString();
     Elfin_StalkChar  s=  new Elfin_StalkChar(null,null,null,null,null,SCShape,null,null,null);
    }//GEN-LAST:event_jElfinSCShapeCBActionPerformed

    private void jElfinWWPtEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jElfinWWPtEdFeildKeyTyped
      char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jElfinWWPtEdFeild.requestFocus();
          WidthatWidestPt[2]=jElfinWWPtEdFeild.getText();
            Elfin_StalkChar s=new Elfin_StalkChar( WidthatWidestPt[2],null,null,null,null,null,null,null,null);
          }
    }//GEN-LAST:event_jElfinWWPtEdFeildKeyTyped

    private void jElfinSuraceCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jElfinSuraceCBActionPerformed
        Object  jElfinSurfaceObj= jElfinSuraceCB.getSelectedItem();
     Surface= jElfinSurfaceObj.toString();
     Elfin_StalkChar  s=  new Elfin_StalkChar(null,null,null,null,null,null,null,null,Surface);
    }//GEN-LAST:event_jElfinSuraceCBActionPerformed

    private void jCoralFungusTaxonEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusTaxonEdFeildActionPerformed
        int  sLen;
       try{
        
        Taxon[3]= jCoralFungusTaxonEdFeild.getText();
         sLen= Taxon[3].length();
          if (sLen>0)
          {Taxonomy t= new Taxonomy(Taxon[3],null,null,null);}
          else
        JOptionPane.showMessageDialog(null,"Taxon feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
    }//GEN-LAST:event_jCoralFungusTaxonEdFeildActionPerformed

    private void jCoralFungusTaxonEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusTaxonEdFeildKeyTyped
        char iCode=evt.getKeyChar();
        
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusTaxonEdFeild.requestFocus();
             Taxon[3]=jCoralFungusTaxonEdFeild.getText();
              Taxonomy t= new Taxonomy(Taxon[3],null,null,null);
    }//GEN-LAST:event_jCoralFungusTaxonEdFeildKeyTyped
    }
    private void date_field4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_field4ActionPerformed
          date_field4.setText(date_format);
    }//GEN-LAST:event_date_field4ActionPerformed

    private void jCoralFungusCollectionNoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusCollectionNoEdFeildActionPerformed
     int  sLen;
       try{
       
        CollectorNo[3]=jElfincollectorNoEdFeild.getText();
         sLen= CollectorNo[3].length();
          if (sLen>0)
          {Taxonomy t= new Taxonomy(null,CollectorNo[3],null,null);}
          else
        JOptionPane.showMessageDialog(null,"Photo  label feild empty","error",JOptionPane.WARNING_MESSAGE);
       
       } catch(NullPointerException e){}
        
    }//GEN-LAST:event_jCoralFungusCollectionNoEdFeildActionPerformed

    private void jCoralFungusCollectionNoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusCollectionNoEdFeildKeyTyped
       char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusCollectionNoEdFeild.requestFocus();
             CollectorNo[3]=jCoralFungusCollectionNoEdFeild.getText();
              Taxonomy t= new Taxonomy(null,CollectorNo[3],null,null);
    }                                                 
    }//GEN-LAST:event_jCoralFungusCollectionNoEdFeildKeyTyped

    private void jCoralFungusPhotoNoEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusPhotoNoEdFeildActionPerformed
      int  sLen;

       try{
 
        Photo[3]=jCoralFungusPhotoNoEdFeild.getText();
         sLen= Photo[3].length();
         
         if (sLen>0)
         { Taxonomy t= new Taxonomy(null,null,Photo[3],null);}
         else
      JOptionPane.showMessageDialog(null,"Photo  field empty","Error",JOptionPane.WARNING_MESSAGE);
              
       }catch(NullPointerException e) { }
              
      
    }//GEN-LAST:event_jCoralFungusPhotoNoEdFeildActionPerformed

    private void jCoralFungusPhotoNoEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusPhotoNoEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusPhotoNoEdFeild.requestFocus();
             CollectorNo[3]=jCoralFungusPhotoNoEdFeild.getText();
              Taxonomy t= new Taxonomy(null,null,Photo[3],null);
    }//GEN-LAST:event_jCoralFungusPhotoNoEdFeildKeyTyped
    }
    
    private void jCoralFungusCollectorsEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusCollectorsEdFeildKeyTyped
        
    }//GEN-LAST:event_jCoralFungusCollectorsEdFeildKeyTyped

    private void jCoralFungusRhizoCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusRhizoCBActionPerformed
     Object  jCoralFungusRhizoObj= jCoralFungusRhizoCB.getSelectedItem();
     Rhizo= jCoralFungusRhizoObj.toString();
     Branch_Char  bc = new Branch_Char(Rhizo,null,null,null);
     
    }//GEN-LAST:event_jCoralFungusRhizoCBActionPerformed

    private void jCoralFungusBCCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusBCCBActionPerformed
        Object  jCoralFungusBCCBObj=jCoralFungusBCCB .getSelectedItem();
     BranchConst= jCoralFungusBCCBObj.toString();
     Branch_Char  bc = new Branch_Char(null,BranchConst,null,null);
    }//GEN-LAST:event_jCoralFungusBCCBActionPerformed

    private void jCoralFungusFleshCCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusFleshCCBActionPerformed
      Object  jCoralFungusFleshCBObj= jCoralFungusFleshCCB.getSelectedItem();
     Flesh= jCoralFungusFleshCBObj.toString();
     Branch_Char bc = new Branch_Char(null,null,null,Flesh);
    }//GEN-LAST:event_jCoralFungusFleshCCBActionPerformed

    private void jCoralFungusStalkCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusStalkCBActionPerformed
        Object  jCoralFungusStalkCBObj= jCoralFungusStalkCB.getSelectedItem();
     Stalk= jCoralFungusStalkCBObj.toString();
     Branch_Char bc = new Branch_Char(null,null,Stalk,null);
    }//GEN-LAST:event_jCoralFungusStalkCBActionPerformed

    private void jCoralFungusBranchJuncCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusBranchJuncCBActionPerformed
        Object  jCoralFungusBranchJuncCBObj=  jCoralFungusBranchJuncCB.getSelectedItem();
     BJ= jCoralFungusBranchJuncCBObj.toString();
    SurfaceColor  sc = new SurfaceColor(null,null,null,null,BJ);
    }//GEN-LAST:event_jCoralFungusBranchJuncCBActionPerformed

    private void jCoralFungusBrusingEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusBrusingEdFeildActionPerformed
       int  sLen;

       try{
 
        Bruising=jCoralFungusBrusingEdFeild.getText();
         sLen=Bruising.length();
         
         if (sLen>0)
         { SurfaceColor  sc = new SurfaceColor(null,null,null,Bruising,null);}
         else
      JOptionPane.showMessageDialog(null,"Bruising   field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusBrusingEdFeildActionPerformed

    private void jCoralFungusBranchesEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusBranchesEdFeildActionPerformed
      int  sLen;

       try{
 
        Branches=jCoralFungusBranchesEdFeild.getText();
         sLen=Branches.length();
         
         if (sLen>0)
         { SurfaceColor  sc = new SurfaceColor(null,null,null,Branches,null);}
         else
      JOptionPane.showMessageDialog(null,"Branch   field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusBranchesEdFeildActionPerformed

    private void jCoralFungusBranchesEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusBranchesEdFeildKeyTyped
        char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER && Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusBranchesEdFeild.requestFocus();
             Branches=jCoralFungusBranchesEdFeild.getText();
            SurfaceColor  sc = new SurfaceColor(null,null,null,Branches,null);
    }          
    }//GEN-LAST:event_jCoralFungusBranchesEdFeildKeyTyped

    private void jCoralFungusStemEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusStemEdFeildActionPerformed
        int  sLen;

       try{
 
        Stem=jCoralFungusStemEdFeild.getText();
         sLen=Stem.length();
         
         if (sLen>0)
         { SurfaceColor  sc = new SurfaceColor(null,Stem,null,null,null);}
         else
      JOptionPane.showMessageDialog(null,"Stem  field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusStemEdFeildActionPerformed

    private void jCoralFungusStemEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusStemEdFeildKeyTyped
      char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusStemEdFeild.requestFocus();
             Stem=jCoralFungusStemEdFeild.getText();
            SurfaceColor  sc = new SurfaceColor(null,Stem,null,null,null);
    }          
    }//GEN-LAST:event_jCoralFungusStemEdFeildKeyTyped

    private void jCoralFungusTipsEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusTipsEdFeildActionPerformed
    int  sLen;

       try{
 
        Tips=jCoralFungusTipsEdFeild.getText();
         sLen=Tips.length();
         
         if (sLen>0)
         { SurfaceColor  sc = new SurfaceColor(Tips,null,null,null,null);}
         else
      JOptionPane.showMessageDialog(null,"Tips  field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusTipsEdFeildActionPerformed

    private void jCoralFungusTipsEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusTipsEdFeildKeyTyped
    char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusTipsEdFeild.requestFocus();
             Tips=jCoralFungusTipsEdFeild.getText();
            SurfaceColor  sc = new SurfaceColor(Tips,null,null,null,null);
    }         
    }//GEN-LAST:event_jCoralFungusTipsEdFeildKeyTyped

    private void jCoralFungusTasteCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusTasteCBActionPerformed
   Object  jCoralFungusTasteCBObj=  jCoralFungusTasteCB.getSelectedItem();
     Taste[2]= jCoralFungusTasteCBObj.toString();
     Coral_GenChar c_gc=new  Coral_GenChar(null,null,null,null,null,Taste[2]);
    }//GEN-LAST:event_jCoralFungusTasteCBActionPerformed

    private void jCoralFungusOdourEdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusOdourEdFieldActionPerformed
       int  sLen;

       try{
 
        Odor[2]=jCoralFungusOdourEdField.getText();
         sLen=Odor[2].length();
         
         if (sLen>0)
         { Coral_GenChar c_gc=new  Coral_GenChar(null,null,null,null,Odor[2],null); }
         else
      JOptionPane.showMessageDialog(null,"Odor field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusOdourEdFieldActionPerformed

    private void jCoralFungusStemWidthEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusStemWidthEdFeildActionPerformed
       int  sLen;

       try{
 
        Stem_Width=jCoralFungusStemWidthEdFeild.getText();
         sLen=Odor[2].length();
         
         if (sLen>0)
         { Coral_GenChar c_gc=new  Coral_GenChar(null,null,null,Stem_Width,null,null); }
         else
      JOptionPane.showMessageDialog(null,"Odor field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusStemWidthEdFeildActionPerformed

    private void jCoralFungusStemBaseEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusStemBaseEdFeildActionPerformed
        int  sLen;

       try{
 
        Stem_Base=jCoralFungusStemBaseEdFeild.getText();
         sLen=Stem_Base.length();
         
         if (sLen>0)
         { Coral_GenChar c_gc=new  Coral_GenChar(null,null,Stem_Base,null,null,null); }
         else
      JOptionPane.showMessageDialog(null,"Stem Base field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusStemBaseEdFeildActionPerformed

    private void jCoralFungusCrownEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusCrownEdFeildActionPerformed
        int  sLen;

       try{
 
        Crown=jCoralFungusCrownEdFeild.getText();
         sLen=Crown.length();
         
         if (sLen>0)
         { Coral_GenChar c_gc=new  Coral_GenChar(null,Crown,null,null,null,null); }
         else
      JOptionPane.showMessageDialog(null,"Crown field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusCrownEdFeildActionPerformed

    private void jCoralFungusEHeightEdFeildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusEHeightEdFeildActionPerformed
        int  sLen;

       try{
 
        EntireHeight=jCoralFungusEHeightEdFeild.getText();
         sLen=EntireHeight.length();
         
         if (sLen>0)
         { Coral_GenChar c_gc=new  Coral_GenChar(EntireHeight,null,null,null,null,null); }
         else
      JOptionPane.showMessageDialog(null,"Entire Height field empty","Error",JOptionPane.WARNING_MESSAGE);
          
       }catch(NullPointerException e) { }
    }//GEN-LAST:event_jCoralFungusEHeightEdFeildActionPerformed

    private void jCoralFungusOdourEdFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusOdourEdFieldKeyTyped
 char iCode=evt.getKeyChar();
          if(iCode== KeyEvent.VK_ENTER || Character.isLetterOrDigit(iCode))
          {  
             jCoralFungusOdourEdField.requestFocus();
             Odor[2]=jCoralFungusTipsEdFeild.getText();
        Coral_GenChar  c_gc = new Coral_GenChar(null,null,null,null,Odor[2],null);
    }   
    }//GEN-LAST:event_jCoralFungusOdourEdFieldKeyTyped

    private void jCoralFungusStemWidthEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusStemWidthEdFeildKeyTyped
     char iCode=evt.getKeyChar();
          if(Character.isLetterOrDigit(iCode) || iCode== KeyEvent.VK_ENTER )
          {  
             jCoralFungusStemWidthEdFeild.requestFocus();
             Stem_Width=jCoralFungusTipsEdFeild.getText();
        Coral_GenChar  g_gc = new Coral_GenChar(null,null,null,Stem_Width,null,null);
    }   
    }//GEN-LAST:event_jCoralFungusStemWidthEdFeildKeyTyped

    private void jCoralFungusStemBaseEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusStemBaseEdFeildKeyTyped
        char iCode=evt.getKeyChar();
        
          if(  Character.isLetterOrDigit(iCode)  || iCode== KeyEvent.VK_ENTER  )
          {  
             jCoralFungusStemBaseEdFeild.requestFocus();
             Stem_Base=jCoralFungusStemBaseEdFeild.getText();
        Coral_GenChar  g_gc = new Coral_GenChar(null,null,Stem_Base,null,null,null);
    }   
    }//GEN-LAST:event_jCoralFungusStemBaseEdFeildKeyTyped

    private void jCoralFungusCrownEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusCrownEdFeildKeyTyped
        char iCode=evt.getKeyChar();
        
          if(  Character.isLetterOrDigit(iCode)  || iCode== KeyEvent.VK_ENTER  )
          {  
             jCoralFungusCrownEdFeild.requestFocus();
             Crown=jCoralFungusCrownEdFeild.getText();
        Coral_GenChar  g_gc = new Coral_GenChar(null,Crown,null,null,null,null);
    }   
    }//GEN-LAST:event_jCoralFungusCrownEdFeildKeyTyped

    private void jCoralFungusEHeightEdFeildKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoralFungusEHeightEdFeildKeyTyped
       char iCode=evt.getKeyChar();
        
          if(  Character.isLetterOrDigit(iCode)  || iCode== KeyEvent.VK_ENTER  )
          {  
             jCoralFungusEHeightEdFeild.requestFocus();
             EntireHeight=jCoralFungusEHeightEdFeild.getText();
        Coral_GenChar  g_gc = new Coral_GenChar(EntireHeight ,null,null,null,null,null);
    }   
    }//GEN-LAST:event_jCoralFungusEHeightEdFeildKeyTyped

    private void jWilcoxanButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWilcoxanButActionPerformed
        if(jWilcoxanBut.isSelected())
        {
            wilcoxan=true;
            spearman=false;
            jChiSquaredRadBut.setSelected(false);
            jSpearmanBut.setSelected(false);

        }
    }//GEN-LAST:event_jWilcoxanButActionPerformed

    private void jSpearmanButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSpearmanButActionPerformed
        if(jSpearmanBut.isSelected())
        {
            spearman=true;
            wilcoxan=false;
            jChiSquaredRadBut.setSelected(false);
            jWilcoxanBut.setSelected(false);

        }
    }//GEN-LAST:event_jSpearmanButActionPerformed

    private void jChiSquaredRadButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiSquaredRadButActionPerformed

        if(jChiSquaredRadBut.isSelected())
        {
            chi_squared=true;
            spearman=false;
            wilcoxan=false;
            jSpearmanBut.setSelected(false);
            jWilcoxanBut.setSelected(false);

        }

    }//GEN-LAST:event_jChiSquaredRadButActionPerformed

    private void jPerformTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPerformTestsActionPerformed
        if(  jStatisticsWindow.isShowing()  &&   chi_squared   &&  spearman==false   && wilcoxan==false   && U_Test==false)
        {
            chi_squared = false;
        }

        if(  jStatisticsWindow.isShowing()  &&   chi_squared ==false  &&  spearman  && wilcoxan==false   && U_Test==false)
        {
            spearman = false;
        }

        if(  jStatisticsWindow.isShowing()  &&   chi_squared ==false  &&  spearman==false  && wilcoxan  &&  U_Test== false)
        {
            wilcoxan = false;
        }

        if(  jStatisticsWindow.isShowing()  &&   chi_squared ==false  &&  spearman==false  && wilcoxan==false  &&  U_Test)
        {
            wilcoxan = false;
        }
        
        
        
        
    }//GEN-LAST:event_jPerformTestsActionPerformed

    private void jManWhitneyUTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManWhitneyUTestActionPerformed
         if(jManWhitneyUTest.isSelected())
        {
             U_Test=true;
            spearman=false;
            wilcoxan=false;
            chi_squared = false;
            jChiSquaredRadBut.setSelected(false);
            jWilcoxanBut.setSelected(false);
            jSpearmanBut.setSelected(false);
        }
    }//GEN-LAST:event_jManWhitneyUTestActionPerformed

    private void jGTestRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGTestRadioButActionPerformed
       if(jGTestRadioBut.isSelected())
        {
             U_Test=false;
            spearman=false;
            wilcoxan=false;
            chi_squared = false;
            jChiSquaredRadBut.setSelected(false);
            jWilcoxanBut.setSelected(false);
            jSpearmanBut.setSelected(false);
        }
    }//GEN-LAST:event_jGTestRadioButActionPerformed
 
    
    
    
    
    
   
   

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    File  progFile;   
    progFile =new File("Mycology.txt");
    if(!progFile.exists())
    {progFile.createNewFile();}
    
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MycologyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MycologyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MycologyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MycologyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MycologyFrame().setVisible(true);
                
                 
                  
       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField BoleteRecNo;
    private java.awt.TextField PoreLayer;
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField date_field2;
    private javax.swing.JTextField date_field3;
    private javax.swing.JTextField date_field4;
    private javax.swing.JComboBox<String> jALOSCB;
    private java.awt.TextField jBCapHeight;
    private javax.swing.JTextField jBCapWidth;
    private javax.swing.JTextField jBFBruisingEdFeild;
    private java.awt.TextField jBFCapSurface;
    private javax.swing.JTextField jBFCollectNoEdFld;
    private java.awt.TextField jBFStemFlesh;
    private java.awt.TextField jBFStemSurface;
    private javax.swing.JComboBox<String> jBFTasteCB;
    private javax.swing.JTextField jBFTaxonEdField;
    private javax.swing.JTextField jBFsmelllEdField;
    private java.awt.TextField jBGCapFleshEdField;
    private javax.swing.JComboBox<String> jBoleteAnnulusCB;
    private javax.swing.JTextField jBoleteAnnulusColor;
    private javax.swing.JComboBox<String> jBoleteCSComboBox;
    private javax.swing.JComboBox<String> jBoleteCapShapeCB;
    private javax.swing.JComboBox<String> jBoleteFleshConstCB;
    private javax.swing.JPanel jBoleteFungi;
    private javax.swing.JComboBox<String> jBoleteOrnamentionCB;
    private javax.swing.JTextField jBoleteSCLengthEdFeild;
    private javax.swing.JComboBox<String> jBoleteSporoCapCB;
    private javax.swing.JComboBox<String> jBoleteStalkSurfaceOrnCB;
    private javax.swing.JComboBox<String> jBoleteSurfaceOrnCB;
    private javax.swing.JComboBox<String> jBoleteSurfaceTextureCB;
    private javax.swing.JTextField jBoleteWidthatBase;
    private javax.swing.JTextField jBoleteWidthatWidestPt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JRadioButton jChiSquaredRadBut;
    private javax.swing.JButton jClearBtn;
    private javax.swing.JTextArea jCollectorsedField;
    private javax.swing.JPanel jColorPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jCoralFungusBCCB;
    private javax.swing.JComboBox<String> jCoralFungusBranchJuncCB;
    private java.awt.TextField jCoralFungusBranchesEdFeild;
    private java.awt.TextField jCoralFungusBrusingEdFeild;
    private javax.swing.JTextField jCoralFungusCollectionNoEdFeild;
    private javax.swing.JTextArea jCoralFungusCollectorsEdFeild;
    private javax.swing.JTextField jCoralFungusCrownEdFeild;
    private javax.swing.JTextField jCoralFungusEHeightEdFeild;
    private javax.swing.JComboBox<String> jCoralFungusFleshCCB;
    private javax.swing.JTextField jCoralFungusOdourEdField;
    private javax.swing.JTextField jCoralFungusPhotoNoEdFeild;
    private java.awt.TextField jCoralFungusRecNo;
    private javax.swing.JComboBox<String> jCoralFungusRhizoCB;
    private javax.swing.JComboBox<String> jCoralFungusStalkCB;
    private javax.swing.JTextField jCoralFungusStemBaseEdFeild;
    private java.awt.TextField jCoralFungusStemEdFeild;
    private javax.swing.JTextField jCoralFungusStemWidthEdFeild;
    private javax.swing.JComboBox<String> jCoralFungusTasteCB;
    private javax.swing.JTextField jCoralFungusTaxonEdFeild;
    private java.awt.TextField jCoralFungusTipsEdFeild;
    private javax.swing.JPanel jCoral_Fungus;
    private javax.swing.JPanel jDBPanel;
    private javax.swing.JPanel jDBPanel1;
    private java.awt.TextField jElfiinStemLenEdFeild;
    private javax.swing.JComboBox<String> jElfinASCICB;
    private java.awt.TextField jElfinAbbhColorEdFeild;
    private javax.swing.JComboBox<String> jElfinAbhymenumCB;
    private java.awt.TextField jElfinBruising;
    private java.awt.TextField jElfinCapFleshThicknessEdFeild;
    private java.awt.TextField jElfinCapWidEdFeild;
    private javax.swing.JTextArea jElfinCollectorsEdFeild;
    private java.awt.TextField jElfinEntireHeightEdFeild;
    private java.awt.TextField jElfinFleshColor;
    private java.awt.TextField jElfinHymeniumCol;
    private javax.swing.JComboBox<String> jElfinNucleiCB;
    private java.awt.TextField jElfinOdorEdFeild;
    private javax.swing.JTextField jElfinPhotoEdFeild;
    private java.awt.TextField jElfinRecNo;
    private javax.swing.JComboBox<String> jElfinSCShapeCB;
    private javax.swing.JComboBox<String> jElfinSFTCB;
    private javax.swing.JComboBox<String> jElfinShapeCB;
    private javax.swing.JComboBox<String> jElfinSporeOrnCB;
    private javax.swing.JComboBox<String> jElfinSporocapCB;
    private javax.swing.JComboBox<String> jElfinStalkCB;
    private java.awt.TextField jElfinStalkLenEdFeild;
    private javax.swing.JComboBox<String> jElfinSuraceCB;
    private javax.swing.JPanel jElfinSurfaceColor;
    private java.awt.TextField jElfinSurfaceColorEdFeild;
    private javax.swing.JComboBox<String> jElfinTaste;
    private javax.swing.JTextField jElfinTaxonEdFeild;
    private java.awt.TextField jElfinWWPtEdFeild;
    private java.awt.TextField jElfinWidthatBase;
    private javax.swing.JPanel jElfin_Fungus;
    private javax.swing.JTextField jElfincollectorNoEdFeild;
    private javax.swing.JLabel jGBCapCharTitlelbl;
    private javax.swing.JPanel jGBCapPanel;
    private javax.swing.JLabel jGBFleshConstlbl;
    private javax.swing.JLabel jGBGillAttachToStemlbl;
    private javax.swing.JPanel jGBGillCharPanel;
    private javax.swing.JLabel jGBGillCharlbl;
    private javax.swing.JLabel jGBGillEdgeShapelbl;
    private javax.swing.JLabel jGBGillPaternlbl;
    private javax.swing.JLabel jGBGillSpacinglbl;
    private javax.swing.JLabel jGBGillThicknesslbl;
    private javax.swing.JLabel jGBGilltexturelbl;
    private javax.swing.JLabel jGBMarginContlbl;
    private javax.swing.JLabel jGBShapelbl;
    private javax.swing.JComboBox<String> jGBStalkCharFleshTextCB;
    private javax.swing.JPanel jGBVeilColorlbl;
    private javax.swing.JLabel jGBVolvalbl;
    private javax.swing.JLabel jGB_VeilColorlbl;
    private javax.swing.JLabel jGCapWidthlbl;
    private javax.swing.JLabel jGMCapCentreHeightbl;
    private javax.swing.JLabel jGMCapCharTittlelbl;
    private javax.swing.JLabel jGMChemCharlTiledbl;
    private javax.swing.JPanel jGMChemicalPanel;
    private javax.swing.JLabel jGMCollectorslbl;
    private javax.swing.JTextField jGMColorRemEdFeild;
    private javax.swing.JLabel jGMColorRemlbl;
    private javax.swing.JLabel jGMDateFeildlbl;
    private javax.swing.JComboBox<String> jGMFlesyConstCB;
    private javax.swing.JLabel jGMGenralCharTitlelbl;
    private javax.swing.JComboBox<String> jGMGillAttachToStemCB;
    private javax.swing.JComboBox<String> jGMGillEdgeShapeCB;
    private javax.swing.JComboBox<String> jGMGillPatternCB;
    private javax.swing.JComboBox<String> jGMGillSpacingCB;
    private javax.swing.JComboBox<String> jGMGillTextureCB;
    private javax.swing.JLabel jGMKOHCaplbl;
    private javax.swing.JTextField jGMKOHEdFld;
    public javax.swing.JTextField jGMKOHFleshEdFld;
    private javax.swing.JLabel jGMKOHFleshlbl;
    private javax.swing.JLabel jGMKOHPVlbl;
    private javax.swing.JTextField jGMKOHParitalVeilEdFld;
    private javax.swing.JComboBox<String> jGMLatexCB;
    private javax.swing.JTextField jGMLatexColorEdFld;
    private javax.swing.JLabel jGMLatexColorlbl;
    private javax.swing.JLabel jGMLatexLbl;
    private javax.swing.JComboBox<String> jGMMarginContourCB;
    private javax.swing.JComboBox<String> jGMMarginShapeCB;
    private javax.swing.JLabel jGMMelCapSurlbl;
    private javax.swing.JTextField jGMMelzersFleshEdFld;
    private javax.swing.JLabel jGMMelzersFleshlbl;
    private javax.swing.JLabel jGMPhotolbl;
    private java.awt.Label jGMRecllbl;
    private javax.swing.JComboBox<String> jGMShapeCB;
    private javax.swing.JLabel jGMStalkCharFleshTextlbl;
    private javax.swing.JComboBox<String> jGMStalkCharShapeCB;
    private javax.swing.JLabel jGMStalkCharShapelbl;
    private javax.swing.JComboBox<String> jGMStalkCharSurfTextCB;
    private javax.swing.JLabel jGMStalkCharSurfTextlbl;
    private javax.swing.JLabel jGMStalkCharTitlelbl;
    private javax.swing.JPanel jGMStalkPanel;
    private javax.swing.JComboBox<String> jGMStalkPresentCB;
    private javax.swing.JLabel jGMStalkPresentlbl;
    private javax.swing.JLabel jGMStalkiCharStemConsistlbl;
    private javax.swing.JComboBox<String> jGMStemConstCB;
    private javax.swing.JLabel jGMSuraceTxtlbl;
    private javax.swing.JLabel jGMSurfaceORnlbl;
    private javax.swing.JComboBox<String> jGMSurfaceOrnCB;
    private javax.swing.JLabel jGMSurfaceOrnlbl;
    private javax.swing.JComboBox<String> jGMSurfaceTextCB;
    private javax.swing.JPanel jGMTaxonPanel;
    private javax.swing.JLabel jGMTaxonTittlelbl;
    private javax.swing.JLabel jGMTaxonlbl;
    private javax.swing.JComboBox<String> jGMThicknessCB;
    private javax.swing.JPanel jGMUniversalVeilPanel;
    private javax.swing.JComboBox<String> jGMUniversalVeilPresCB;
    private javax.swing.JLabel jGMUniversalVeilPreslbl;
    private javax.swing.JComboBox<String> jGMUniversalVeilRemCB;
    private javax.swing.JLabel jGMUniversalVeilRemlbl;
    private javax.swing.JLabel jGMUniversalVeilTitlelbl;
    private javax.swing.JComboBox<String> jGMVeilCB;
    private javax.swing.JTextField jGMVeilColorEdFld;
    private javax.swing.JLabel jGMVeilTitlelbl;
    private javax.swing.JComboBox<String> jGMVolvaCB;
    private javax.swing.JLabel jGMWidthatBaselbl;
    private javax.swing.JTextField jGMWidthatWidPtEdFld;
    private javax.swing.JLabel jGMWidthatWidPtlbl;
    private javax.swing.JTextField jGMWidttatBaseEdFld;
    private javax.swing.JTextField jGM_CollectorsEdField;
    private javax.swing.JTextField jGM_RecDisplay;
    private javax.swing.JTextField jGMelzersCapSurfEdFld;
    private javax.swing.JRadioButton jGTestRadioBut;
    private javax.swing.JPanel jGeneralPanel;
    private javax.swing.JLabel jGiBTotalHeightlbl;
    private javax.swing.JPanel jGilledFungus;
    private javax.swing.JTextField jGilledMushroomCapCentreHgtEdFeild;
    private javax.swing.JTextField jGilledMushroomCapFleshEditFeild;
    private javax.swing.JLabel jGilledMushroomCapFleshlbl;
    private javax.swing.JTextField jGilledMushroomCapSurfaceEditField;
    private javax.swing.JLabel jGilledMushroomCapSurfacelbl;
    private javax.swing.JTextField jGilledMushroomCapWidEditField;
    private javax.swing.JTextField jGilledMushroomColEdField;
    private javax.swing.JComboBox<String> jGilledMushroomGillsCB;
    private javax.swing.JLabel jGilledMushroomGillslbl;
    private javax.swing.JLabel jGilledMushroomHygrolbl;
    private javax.swing.JComboBox<String> jGilledMushroomHygrophanousComboBox;
    private javax.swing.JComboBox<String> jGilledMushroomMGCB;
    private javax.swing.JLabel jGilledMushroomMatureGillslbl;
    private javax.swing.JLabel jGilledMushroomOdor;
    private javax.swing.JComboBox<String> jGilledMushroomOdorCombobox;
    private javax.swing.JComboBox<String> jGilledMushroomSporeCB;
    private javax.swing.JLabel jGilledMushroomSporelbl;
    private javax.swing.JTextField jGilledMushroomStemFleshEditFeild;
    private javax.swing.JLabel jGilledMushroomStemFleshlbl;
    private javax.swing.JTextField jGilledMushroomStemSuraceEditFeild;
    private javax.swing.JLabel jGilledMushroomStemSurfacelbl;
    private javax.swing.JComboBox<String> jGilledMushroomTasteComboBox;
    private javax.swing.JTextField jGilledMushroomsPhotoEdFeild;
    public javax.swing.JTextField jGilledMushroomsTaxonEdFeild;
    private javax.swing.JTextField jGilledMushroomsTotalHeightEditFielld;
    private javax.swing.JLabel jGilledMuysroomTaste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jMGBMarginShapelbl;
    private javax.swing.JRadioButton jManWhitneyUTest;
    private javax.swing.JButton jNewRecBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jPerformTests;
    private javax.swing.JTextField jPhotoNoEdFeild;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton jSpearmanBut;
    private javax.swing.JComboBox<String> jStalkCharSurfOrnCB;
    public javax.swing.JTabbedPane jStatisticsWindow;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jWilcoxanBut;
    public javax.swing.JButton jWriteButton;
    private javax.swing.JLabel juGBVeillbl;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label3;
    private java.awt.Label label4;
    // End of variables declaration//GEN-END:variables
}
