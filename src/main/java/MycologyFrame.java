 import   org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import   org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.TDistribution;
 import org.apache.commons.math3.distribution.FDistribution;
 import  java.util.Arrays;
 import javax.swing.table.*;
import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;            
import java.util.Date;
import java.text.SimpleDateFormat;
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


 
import org.apache.commons.math3.stat.inference.TestUtils;


 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dr  Frankenshroom
 */




public class MycologyFrame extends javax.swing.JFrame {

   
//<editor-fold defaultstate="collapsed" desc="comment">
       
//</editor-fold>
    
    
       double [] pvalue = new double [15];
               double [] critical_value = new double [15];
    int  recno =1,dof=1,n=1,df1,df2,y,m;
String date_format,alphadisplay;
String  Record,H0,H1;
/* Taxon  data fields  */
String Collector,_pval; 
   File  t_testFile; 
JTextArea edField= new JTextArea();
String [] CollectorNo =new String[4];
String  [] Photo= new String [4];
String []Taxon= new String[4];
 double chisquareVal, pval,testvalue;
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
 String jBFCap_Flesh,jBF_BR,BJ,answer,CV;

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
 String   SCShape,Stalk_SO,Surface,MelzersR,GreensR;
/*Veil  data fields*/
String Veil_Color,Gill_Veil;
/*Universal  Veil  data fields*/
String Universal_Veil_Present,Universal_Veil_Remnant,Color_Remnants;
String   Volva;
/*Branch  Char*/
 String   Rhizo,BranchConst,Flesh,Branches,Stem,Tips;

Boolean  KS=false,wilcoxan=false, chi_squared=false,U_Test=false,Ftest=false, j1Tailed=false;
 Boolean  t_Test=false,TwoSampleT=false,Gtest=false,j2tailed=false, paired_t=false,one_sample=false;
double alpha,ttest,paired_Tstat,tStar;
 
String  NullTestOption,ATO,NullOption, _var,ans;
  int df=1;
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

        MycologyMultiplex = new javax.swing.JTabbedPane();
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
        jLabel93 = new javax.swing.JLabel();
        jMRCB = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        jGreenCB = new javax.swing.JComboBox<>();
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
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        StatsTable = new javax.swing.JTable();
        StatsWindowPane = new javax.swing.JTabbedPane();
        ChiSquarePane = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        NULLTextDisplay = new javax.swing.JTextField();
        H1Displayfeild = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        DOFDisplay = new javax.swing.JTextField();
        alphaDisplay = new javax.swing.JTextField();
        jChiValueDisplay = new javax.swing.JTextField();
        jCriticalDisplay = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        pValueDisplay = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        chi_criteria = new javax.swing.JLabel();
        kiCriteria = new javax.swing.JLabel();
        resultDisplay = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        GtestPane = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel221 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        gdf = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        F_test_label1 = new javax.swing.JLabel();
        Gpval = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        GHypo = new javax.swing.JTextField();
        GAlt = new javax.swing.JTextField();
        G_dof = new javax.swing.JTextField();
        G_alpha = new javax.swing.JTextField();
        Gtestval = new javax.swing.JTextField();
        gpval = new javax.swing.JTextField();
        criteria = new javax.swing.JLabel();
        solution = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        G_crit = new javax.swing.JTextField();
        WilcoxanPane = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        ManWhitneyPane = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        KendalWTestPane = new javax.swing.JPanel();
        jLabel237 = new javax.swing.JLabel();
        w_label = new javax.swing.JLabel();
        F_test_label3 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        kendal_result = new javax.swing.JLabel();
        Kendal_descision = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        w_alpha = new java.awt.TextField();
        W_coeff = new java.awt.TextField();
        score = new java.awt.TextField();
        kendal_cv = new java.awt.TextField();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        textField6 = new java.awt.TextField();
        textField7 = new java.awt.TextField();
        jLabel243 = new javax.swing.JLabel();
        Kendal_cv = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        kcv = new javax.swing.JLabel();
        jLabel244 = new javax.swing.JLabel();
        kendal_pval = new javax.swing.JTextField();
        Paired_tTestPanel = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        ALOSPairedt = new javax.swing.JTextField();
        pairedTValue = new javax.swing.JTextField();
        pairedT_CV = new javax.swing.JTextField();
        pairedT_pval = new javax.swing.JTextField();
        pairedT_df = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        pairedT_H0 = new javax.swing.JTextField();
        pairedT_H1 = new javax.swing.JTextField();
        NullOpt = new javax.swing.JTextField();
        pairedT_alt = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        pairedTCrit = new javax.swing.JLabel();
        TwoSampletTestPane = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        ALOS_tSample = new java.awt.TextField();
        H12Test = new java.awt.TextField();
        Two_tCritical = new java.awt.TextField();
        TwoTest_pval = new java.awt.TextField();
        HO2Test = new java.awt.TextField();
        twoSampleT = new java.awt.TextField();
        testOption = new java.awt.TextField();
        testOpt2 = new java.awt.TextField();
        jLabel141 = new javax.swing.JLabel();
        jDOF2Display = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        pairedTresult = new javax.swing.JLabel();
        twoSampleCrit = new javax.swing.JLabel();
        FTestPane = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        F_test_label = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        F_alpha = new javax.swing.JTextField();
        F_Test = new javax.swing.JTextField();
        F_crit = new javax.swing.JTextField();
        f_df1 = new javax.swing.JTextField();
        F_df2 = new javax.swing.JTextField();
        F_pvalue = new javax.swing.JTextField();
        F_result = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        F_H0 = new javax.swing.JTextField();
        F_H1 = new javax.swing.JTextField();
        F_criteria = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        F_H0_sign = new javax.swing.JTextField();
        F_H1_sign = new javax.swing.JTextField();
        tTestPane = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        tTestH1 = new javax.swing.JTextField();
        tTestH0 = new javax.swing.JTextField();
        testsign = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        H1testsign = new javax.swing.JTextField();
        t_alos = new javax.swing.JTextField();
        tdof = new javax.swing.JTextField();
        T_test = new javax.swing.JTextField();
        t_pval = new javax.swing.JTextField();
        tResult = new javax.swing.JLabel();
        t_Critical = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        tCritieria = new javax.swing.JLabel();
        tCritieria1 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        tCriteria = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        OneSampleVariancePane = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        var_alpha_lbl = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        size = new javax.swing.JTextField();
        var_alpha = new javax.swing.JTextField();
        var_ts = new javax.swing.JTextField();
        var_cv = new javax.swing.JTextField();
        var_p = new javax.swing.JTextField();
        var_H0 = new javax.swing.JTextField();
        var_H1 = new javax.swing.JTextField();
        statement = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        var_alt = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        varCrit = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        var_opt1 = new javax.swing.JTextField();
        jClearResults = new javax.swing.JButton();
        jSave = new javax.swing.JButton();
        col1 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        col2 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        Treatment = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 0), new java.awt.Dimension(3, 32767));
        jPanel32 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        col3 = new javax.swing.JTextField();
        col4 = new javax.swing.JTextField();
        col5 = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jAddRecord2db = new javax.swing.JButton();
        jDeleteRecButton = new javax.swing.JButton();
        jBrowseButton = new javax.swing.JButton();
        jLabel95 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jAddRecord = new javax.swing.JButton();
        jClear = new javax.swing.JButton();
        jWrite = new javax.swing.JButton();
        jLabel96 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPerfromTestBut = new javax.swing.JButton();
        j2SampleTTestradiobut = new javax.swing.JRadioButton();
        jtTestRadioBut = new javax.swing.JRadioButton();
        jGtestRadioBut = new javax.swing.JRadioButton();
        jWilcoxanRadioBut = new javax.swing.JRadioButton();
        jUTestRadioBut = new javax.swing.JRadioButton();
        jKSTest = new javax.swing.JRadioButton();
        j1TailedRadioButton = new javax.swing.JRadioButton();
        j2TailedRadioButton = new javax.swing.JRadioButton();
        jLabel98 = new javax.swing.JLabel();
        jChiSquared = new javax.swing.JRadioButton();
        jH0EdFeild = new javax.swing.JTextField();
        jH1EditFeild = new javax.swing.JTextField();
        jALOSCB = new javax.swing.JComboBox<>();
        jTestType = new javax.swing.JComboBox<>();
        jTwoSampleVarianceRadioBut = new javax.swing.JRadioButton();
        jPaired_tTestRadioBut = new javax.swing.JRadioButton();
        jVarianceRadioBut = new javax.swing.JRadioButton();
        jLabel97 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mycology Forms  Pro 1.0");
        setBackground(new java.awt.Color(229, 95, 95));
        setForeground(new java.awt.Color(207, 132, 57));
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(1150, 1050));
        setResizable(false);
        setSize(new java.awt.Dimension(1150, 1050));

        MycologyMultiplex.setBackground(new java.awt.Color(255, 85, 63));
        MycologyMultiplex.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MycologyMultiplex.setForeground(new java.awt.Color(102, 81, 78));
        MycologyMultiplex.setFont(new java.awt.Font("PT Serif", 1, 14)); // NOI18N
        MycologyMultiplex.setPreferredSize(new java.awt.Dimension(709, 900));

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

        jCoralFungusStalkCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Slender", "Fused", "Fasced" }));
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

        jLabel93.setText("Green' reaction to ferous Oxide");

        jMRCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Amylod", "Dextrinoid" }));
        jMRCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRCBActionPerformed(evt);
            }
        });

        jLabel94.setForeground(new java.awt.Color(237, 208, 208));
        jLabel94.setText("Melzer'a   Reagent   on Interior");

        jGreenCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Flesh interior", "Hymenium" }));
        jGreenCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGreenCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel94)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jMRCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jGreenCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel88)
                                        .addGap(29, 29, 29)
                                        .addComponent(jCoralFungusFleshCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel90)
                                .addGap(30, 30, 30)
                                .addComponent(jCoralFungusRhizoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel87)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCoralFungusStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCoralFungusBCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCoralFungusStalkCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel87))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(jCoralFungusFleshCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(jGreenCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(jMRCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(jCoralFungusBCCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel90)
                            .addComponent(jCoralFungusRhizoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
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
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addGap(18, 18, 18)
                        .addComponent(jCoralFungusRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addGap(103, 630, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(jCoralFungusRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel79)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel86))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jCoral_FungusLayout = new javax.swing.GroupLayout(jCoral_Fungus);
        jCoral_Fungus.setLayout(jCoral_FungusLayout);
        jCoral_FungusLayout.setHorizontalGroup(
            jCoral_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jCoral_FungusLayout.setVerticalGroup(
            jCoral_FungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCoral_FungusLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MycologyMultiplex.addTab("Coral Fungus", jCoral_Fungus);

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
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel51)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel61))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jElfinRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addGap(147, 147, 147)
                                .addComponent(jLabel55))
                            .addComponent(jElfinSurfaceColor, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56)
                    .addComponent(jElfinRecNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61)
                .addGap(7, 7, 7)
                .addComponent(jElfinSurfaceColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
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

        MycologyMultiplex.addTab("Elfin  Fungus", jElfin_Fungus);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        jGilledFungusLayout.setVerticalGroup(
            jGilledFungusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jGilledFungusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        MycologyMultiplex.addTab("Gilled  Fungi", jGilledFungus);

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
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoleteCapShapeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jBoleteSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBoleteSCLengthEdFeild, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBoleteWidthatWidestPt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoleteWidthatBase, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBoleteAnnulusColor, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(66, 66, 66))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(33, 33, 33)
                                .addComponent(jBoleteAnnulusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBoleteStalkSurfaceOrnCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jBoleteWidthatBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBoleteAnnulusColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)))
                            .addComponent(jLabel28)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBoleteOrnamentionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jBoleteAnnulusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MycologyMultiplex.addTab("Bolete and Polyporus Fungus ", jBoleteFungi);

        jPanel18.setBackground(new java.awt.Color(225, 177, 131));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(16, 1, 1), java.awt.Color.lightGray));

        StatsTable.setBackground(new java.awt.Color(190, 108, 40));
        StatsTable.setBorder(new javax.swing.border.MatteBorder(null));
        StatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Treatment", "Col  1/obs", "col  2/ expected", "ranked obs", "ranked obs", "ranked obs"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Long.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StatsTable.setColumnSelectionAllowed(true);
        StatsTable.setGridColor(new java.awt.Color(1, 1, 11));
        StatsTable.setOpaque(false);
        StatsTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                StatsTableFocusGained(evt);
            }
        });
        jScrollPane7.setViewportView(StatsTable);
        StatsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        StatsWindowPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel26.setBackground(new java.awt.Color(243, 210, 174));
        jPanel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel99.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(17, 1, 1));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("d.f");
        jLabel99.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel100.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(23, 3, 3));
        jLabel100.setText("<html> &#967; <sup>2</sup> value  </html>");
        jLabel100.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel101.setBackground(new java.awt.Color(7, 7, 10));
        jLabel101.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(17, 1, 1));
        jLabel101.setText("Critical  value");
        jLabel101.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel102.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(13, 9, 9));
        jLabel102.setText("<html> &#945;  level of significance </html>  ");
        jLabel102.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel103.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(7, 0, 0));
        jLabel103.setText("<html>H<sub>0</sub></html>");
        jLabel103.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel104.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(7, 0, 0));
        jLabel104.setText("<html>H<sub>a</sub></html>");
        jLabel104.setBorder(new javax.swing.border.MatteBorder(null));

        NULLTextDisplay.setEditable(false);
        NULLTextDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NULLTextDisplayActionPerformed(evt);
            }
        });

        H1Displayfeild.setEditable(false);

        jLabel105.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(8, 0, 0));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Hypothesis");

        DOFDisplay.setEditable(false);

        alphaDisplay.setEditable(false);

        jChiValueDisplay.setEditable(false);

        jCriticalDisplay.setEditable(false);

        jLabel107.setBackground(new java.awt.Color(7, 7, 10));
        jLabel107.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(17, 1, 1));
        jLabel107.setText("p-value");
        jLabel107.setBorder(new javax.swing.border.MatteBorder(null));

        pValueDisplay.setEditable(false);

        jLabel108.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(13, 0, 0));
        jLabel108.setText("<html> Since &#967; <sup>2</sup> is </html>");

        jLabel233.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(8, 0, 0));
        jLabel233.setText("Criteria");

        jLabel234.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(8, 0, 0));
        jLabel234.setText("Result");

        jLabel235.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(2, 0, 0));
        jLabel235.setText("<html> Reject  H<sub>0</sub>  if &#967;<sup>2</sup></html>");

        chi_criteria.setText("jLabel236");

        kiCriteria.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kiCriteria.setText("jLabel109");

        resultDisplay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        resultDisplay.setText("jLabel110");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(DOFDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel26Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(alphaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jChiValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel26Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel235, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kiCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250)
                                .addComponent(chi_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jCriticalDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel101)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NULLTextDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(H1Displayfeild, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resultDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NULLTextDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H1Displayfeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(jLabel107)
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DOFDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alphaDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jChiValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCriticalDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pValueDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chi_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel235, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kiCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultDisplay))))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ChiSquarePaneLayout = new javax.swing.GroupLayout(ChiSquarePane);
        ChiSquarePane.setLayout(ChiSquarePaneLayout);
        ChiSquarePaneLayout.setHorizontalGroup(
            ChiSquarePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChiSquarePaneLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ChiSquarePaneLayout.setVerticalGroup(
            ChiSquarePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChiSquarePaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ChiSquarePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StatsWindowPane.addTab("Chi-Squared  Test", ChiSquarePane);

        jPanel35.setBackground(new java.awt.Color(238, 203, 182));
        jPanel35.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel221.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(10, 0, 0));
        jLabel221.setText("Hypothesis");

        jLabel223.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(17, 6, 6));
        jLabel223.setText("<html>H<sub>0</sub></html>");

        jLabel224.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(17, 6, 6));
        jLabel224.setText("<html> H<sub>a</sub></html>");

        gdf.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        gdf.setForeground(new java.awt.Color(17, 1, 1));
        gdf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gdf.setText("df");
        gdf.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel226.setBackground(new java.awt.Color(229, 229, 238));
        jLabel226.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(35, 5, 5));
        jLabel226.setText("<html>&#945; level of  significance </html>");
        jLabel226.setBorder(new javax.swing.border.MatteBorder(null));

        F_test_label1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F_test_label1.setForeground(new java.awt.Color(35, 5, 5));
        F_test_label1.setText("G- test value");
        F_test_label1.setBorder(new javax.swing.border.MatteBorder(null));

        Gpval.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Gpval.setForeground(new java.awt.Color(35, 5, 5));
        Gpval.setText("P- value");
        Gpval.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel228.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(35, 5, 5));
        jLabel228.setText("Descision Criteria");
        jLabel228.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel229.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(35, 5, 5));
        jLabel229.setText("         Result");
        jLabel229.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel230.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(2, 0, 0));
        jLabel230.setText("<html> Reject  H<sub>0</sub>  if   G</html>");

        GHypo.setEditable(false);
        GHypo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        GAlt.setEditable(false);
        GAlt.setText("jTextField6");

        G_dof.setEditable(false);
        G_dof.setText("jTextField7");

        G_alpha.setEditable(false);
        G_alpha.setText("jTextField8");

        Gtestval.setEditable(false);
        Gtestval.setText("jTextField9");

        gpval.setEditable(false);
        gpval.setText("jTextField10");

        criteria.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        criteria.setText("jLabel225");

        solution.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        solution.setText("jLabel225");

        jLabel225.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(35, 5, 5));
        jLabel225.setText("Aprox.Critical Val.");
        jLabel225.setBorder(new javax.swing.border.MatteBorder(null));

        G_crit.setEditable(false);
        G_crit.setText("jTextField7");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GAlt)
                        .addGap(284, 284, 284))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel221)
                            .addComponent(GHypo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(gdf, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(G_dof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(G_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(F_test_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(Gtestval, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(G_crit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(gpval, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Gpval, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(solution, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel221, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GHypo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel226, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_test_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gpval, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel225, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gpval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Gtestval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(G_crit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(G_dof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(G_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(solution, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout GtestPaneLayout = new javax.swing.GroupLayout(GtestPane);
        GtestPane.setLayout(GtestPaneLayout);
        GtestPaneLayout.setHorizontalGroup(
            GtestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        GtestPaneLayout.setVerticalGroup(
            GtestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        StatsWindowPane.addTab("G  Test ", GtestPane);

        jPanel34.setBackground(new java.awt.Color(222, 222, 235));
        jPanel34.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout WilcoxanPaneLayout = new javax.swing.GroupLayout(WilcoxanPane);
        WilcoxanPane.setLayout(WilcoxanPaneLayout);
        WilcoxanPaneLayout.setHorizontalGroup(
            WilcoxanPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        WilcoxanPaneLayout.setVerticalGroup(
            WilcoxanPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        StatsWindowPane.addTab("Wilcoxan Sign  Test ", WilcoxanPane);

        jPanel33.setBackground(new java.awt.Color(222, 222, 237));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ManWhitneyPaneLayout = new javax.swing.GroupLayout(ManWhitneyPane);
        ManWhitneyPane.setLayout(ManWhitneyPaneLayout);
        ManWhitneyPaneLayout.setHorizontalGroup(
            ManWhitneyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ManWhitneyPaneLayout.setVerticalGroup(
            ManWhitneyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        StatsWindowPane.addTab("Mann  Whitney  ", ManWhitneyPane);

        KendalWTestPane.setBackground(new java.awt.Color(209, 183, 183));
        KendalWTestPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel237.setBackground(new java.awt.Color(229, 229, 238));
        jLabel237.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(35, 5, 5));
        jLabel237.setText("<html>&#945; level of  significance </html>");
        jLabel237.setBorder(new javax.swing.border.MatteBorder(null));

        w_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        w_label.setForeground(new java.awt.Color(35, 5, 5));
        w_label.setText("W");
        w_label.setBorder(new javax.swing.border.MatteBorder(null));

        F_test_label3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F_test_label3.setForeground(new java.awt.Color(35, 5, 5));
        F_test_label3.setText("Kendal  test value");
        F_test_label3.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel238.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(35, 5, 5));
        jLabel238.setText("P- Val.");
        jLabel238.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel239.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(35, 5, 5));
        jLabel239.setText("Result");
        jLabel239.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel240.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(35, 5, 5));
        jLabel240.setText("Descision Criteria");
        jLabel240.setBorder(new javax.swing.border.MatteBorder(null));

        kendal_result.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        kendal_result.setText("jLabel205");

        Kendal_descision.setText("jLabel205");

        jLabel222.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(10, 0, 0));
        jLabel222.setText("Hypothesis");

        jLabel241.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel241.setForeground(new java.awt.Color(17, 6, 6));
        jLabel241.setText("<html>H<sub>0</sub></html>");

        jLabel242.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(17, 6, 6));
        jLabel242.setText("<html>H<sub>a</sub></html>");

        textField6.setEnabled(false);
        textField6.setText("textField6");

        textField7.setEnabled(false);

        jLabel243.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(17, 6, 6));
        jLabel243.setText("<html>Reject H<sub>0</sub>  if  the  </html>");

        Kendal_cv.setText("jLabel145");

        jLabel145.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(10, 0, 0));
        jLabel145.setText("columns are <");

        kcv.setText("jLabel205");

        jLabel244.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(35, 5, 5));
        jLabel244.setText("Critical Val.");
        jLabel244.setBorder(new javax.swing.border.MatteBorder(null));

        kendal_pval.setText("jTextField7");

        javax.swing.GroupLayout KendalWTestPaneLayout = new javax.swing.GroupLayout(KendalWTestPane);
        KendalWTestPane.setLayout(KendalWTestPaneLayout);
        KendalWTestPaneLayout.setHorizontalGroup(
            KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendalWTestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(w_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(W_coeff, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(w_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendalWTestPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(F_test_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel244, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kendal_pval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(207, 207, 207))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kendal_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kendal_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel222))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, KendalWTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Kendal_descision, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(326, 326, 326)
                        .addComponent(kcv))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(kendal_result, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KendalWTestPaneLayout.setVerticalGroup(
            KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel241, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(w_label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel237, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(F_test_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel238, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KendalWTestPaneLayout.createSequentialGroup()
                        .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(w_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kendal_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kendal_pval, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel240, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(W_coeff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Kendal_cv, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KendalWTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel243, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kcv)
                    .addComponent(Kendal_descision, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel239, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kendal_result, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        StatsWindowPane.addTab("Kendal Coefficient of Concordance Test", KendalWTestPane);

        Paired_tTestPanel.setBackground(new java.awt.Color(221, 208, 175));
        Paired_tTestPanel.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel134.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(4, 0, 0));
        jLabel134.setText("Hypothesis");

        jLabel147.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(4, 0, 0));
        jLabel147.setText("<html>H<sub>0</sub></html>");

        jLabel148.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(4, 0, 0));
        jLabel148.setText("<html> H<sub>a</sub></html>");

        jLabel149.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(4, 0, 0));
        jLabel149.setText("df");
        jLabel149.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel152.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(35, 5, 5));
        jLabel152.setText("<html>&#945; level  of  significance </html>");
        jLabel152.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel153.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(17, 6, 6));
        jLabel153.setText("Crtical  Value");
        jLabel153.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel154.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(35, 5, 5));
        jLabel154.setText("paired t- test value");
        jLabel154.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel155.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(17, 6, 6));
        jLabel155.setText("p-value");
        jLabel155.setBorder(new javax.swing.border.MatteBorder(null));

        ALOSPairedt.setEditable(false);
        ALOSPairedt.setText("jTextField1");

        pairedTValue.setEditable(false);
        pairedTValue.setText("jTextField2");

        pairedT_CV.setEditable(false);
        pairedT_CV.setText("jTextField3");

        pairedT_pval.setEditable(false);
        pairedT_pval.setText("jTextField4");

        pairedT_df.setEditable(false);
        pairedT_df.setText("jTextField5");

        jLabel150.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(17, 6, 6));
        jLabel150.setText("<html>  &mu <sub>1</sub></html>");

        pairedT_H0.setEditable(false);
        pairedT_H0.setText("jTextField7");

        pairedT_H1.setEditable(false);
        pairedT_H1.setText("jTextField8");

        NullOpt.setEditable(false);

        pairedT_alt.setEditable(false);

        jLabel158.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(17, 6, 6));
        jLabel158.setText("<html> &mu <sub>2</sub></html>");

        jLabel159.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(17, 2, 2));

        jLabel184.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(17, 6, 6));
        jLabel184.setText("<html>  &mu <sub>1</sub></html>");

        jLabel185.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(17, 6, 6));
        jLabel185.setText("<html> &mu <sub>2</sub></html>");

        jLabel227.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(19, 1, 1));
        jLabel227.setText("Descision Criteria");

        jLabel231.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(35, 5, 5));
        jLabel231.setText("         Result");
        jLabel231.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel232.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(2, 0, 0));
        jLabel232.setText("<html> Reject  H<sub>0</sub>  if  </html>");

        pairedTCrit.setText("jLabel109");

        javax.swing.GroupLayout Paired_tTestPanelLayout = new javax.swing.GroupLayout(Paired_tTestPanel);
        Paired_tTestPanel.setLayout(Paired_tTestPanelLayout);
        Paired_tTestPanelLayout.setHorizontalGroup(
            Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(pairedT_H0, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                            .addComponent(pairedT_H1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(pairedTValue, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel154)))
                                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(pairedTCrit))
                                            .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)))
                                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pairedT_alt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NullOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel134)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pairedT_df, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(ALOSPairedt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228)
                .addComponent(pairedT_CV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pairedT_pval, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Paired_tTestPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        Paired_tTestPanelLayout.setVerticalGroup(
            Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paired_tTestPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel134)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_H0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NullOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel185, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel184, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_alt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel155, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALOSPairedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedTValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_pval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedT_df, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Paired_tTestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pairedTCrit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel231, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel159, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        StatsWindowPane.addTab("Paired  t -test", Paired_tTestPanel);

        TwoSampletTestPane.setBackground(new java.awt.Color(250, 202, 168));

        jLabel127.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(10, 0, 0));
        jLabel127.setText("Hypothesis");

        jLabel132.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(17, 6, 6));
        jLabel132.setText("<html> H<sub>0</sub></html>");

        jLabel133.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(17, 6, 6));
        jLabel133.setText("<html>H<sub>a</sub></html>");

        jLabel135.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(17, 6, 6));
        jLabel135.setText("Test  Statistic ");
        jLabel135.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel136.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(35, 5, 5));
        jLabel136.setText("<html>&#945; level  of  significance </html>");
        jLabel136.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel137.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(17, 6, 6));
        jLabel137.setText("Crtical  Value");
        jLabel137.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel138.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(17, 6, 6));
        jLabel138.setText("p-value");
        jLabel138.setBorder(new javax.swing.border.MatteBorder(null));

        ALOS_tSample.setEditable(false);
        ALOS_tSample.setText("textField1");

        H12Test.setEditable(false);
        H12Test.setText("textField2");

        Two_tCritical.setEditable(false);
        Two_tCritical.setText("textField3");

        TwoTest_pval.setEditable(false);
        TwoTest_pval.setText("textField4");

        HO2Test.setEditable(false);
        HO2Test.setText("textField6");

        twoSampleT.setText("textField7");

        testOption.setText("textField8");

        testOpt2.setEditable(false);
        testOpt2.setText("textField9");

        jLabel141.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(17, 6, 6));
        jLabel141.setText("df");
        jLabel141.setBorder(new javax.swing.border.MatteBorder(null));

        jDOF2Display.setText("jTextField1");

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(7, 0, 0));
        jLabel186.setText("<html>  &mu  <sub>1</sub></html>");

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(7, 0, 0));
        jLabel144.setText("<html> &mu  <sub>2</sub></html>");

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(7, 0, 0));
        jLabel188.setText("<html> &mu  <sub>2</sub></html>");

        jLabel195.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(7, 0, 0));
        jLabel195.setText("<html>  &mu  <sub>1</sub></html>");

        jLabel196.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(35, 5, 5));
        jLabel196.setText("Descision Criteria");
        jLabel196.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel197.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(2, 0, 0));
        jLabel197.setText("<html> Reject  H<sub>0</sub>  if  </html>");

        jLabel198.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(35, 5, 5));
        jLabel198.setText("Descision ");
        jLabel198.setBorder(new javax.swing.border.MatteBorder(null));

        pairedTresult.setText("jLabel109");

        twoSampleCrit.setText("jLabel110");

        javax.swing.GroupLayout TwoSampletTestPaneLayout = new javax.swing.GroupLayout(TwoSampletTestPane);
        TwoSampletTestPane.setLayout(TwoSampletTestPaneLayout);
        TwoSampletTestPaneLayout.setHorizontalGroup(
            TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(H12Test, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(testOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HO2Test, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(testOption, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jDOF2Display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(ALOS_tSample, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(twoSampleT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Two_tCritical, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TwoSampletTestPaneLayout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101))
                            .addComponent(pairedTresult, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(TwoTest_pval, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(twoSampleCrit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        TwoSampletTestPaneLayout.setVerticalGroup(
            TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(testOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel188, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(testOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TwoSampletTestPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(HO2Test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel186, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel195, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(H12Test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TwoTest_pval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TwoSampletTestPaneLayout.createSequentialGroup()
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDOF2Display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ALOS_tSample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twoSampleT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Two_tCritical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel196, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(TwoSampletTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel197, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(twoSampleCrit))))
                .addGap(30, 30, 30)
                .addComponent(jLabel198, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pairedTresult, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        StatsWindowPane.addTab("2-Sample t-test ", TwoSampletTestPane);

        FTestPane.setBackground(new java.awt.Color(247, 247, 247));

        jLabel170.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(17, 1, 1));
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel170.setText("df1");
        jLabel170.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel175.setBackground(new java.awt.Color(229, 229, 238));
        jLabel175.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(35, 5, 5));
        jLabel175.setText("<html>&#945; level of  significance </html>");
        jLabel175.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel176.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(35, 5, 5));
        jLabel176.setText("Descision Criteria");
        jLabel176.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel177.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(35, 5, 5));
        jLabel177.setText("Critical Val.");
        jLabel177.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel178.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(35, 5, 5));
        jLabel178.setText("P- value");
        jLabel178.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel179.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(10, 0, 0));
        jLabel179.setText("Hypothesis");

        jLabel180.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(17, 6, 6));
        jLabel180.setText("<html>H<sub>0</sub></html>");

        jLabel181.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(17, 6, 6));
        jLabel181.setText("<html> H<sub>a</sub></html>");

        F_test_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        F_test_label.setForeground(new java.awt.Color(35, 5, 5));
        F_test_label.setText("F- test value");
        F_test_label.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel183.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(17, 1, 1));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel183.setText("df2");
        jLabel183.setBorder(new javax.swing.border.MatteBorder(null));

        F_alpha.setEditable(false);
        F_alpha.setText("jTextField1");

        F_Test.setEditable(false);
        F_Test.setText("jTextField1");

        F_crit.setEditable(false);
        F_crit.setText("jTextField1");

        f_df1.setEditable(false);
        f_df1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        f_df1.setText("jTextField1");

        F_df2.setEditable(false);
        F_df2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        F_df2.setText("jTextField1");

        F_pvalue.setEditable(false);
        F_pvalue.setText("jTextField1");

        F_result.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        F_result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        F_result.setText("jLabel165");

        jLabel182.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(35, 5, 5));
        jLabel182.setText("         Result");
        jLabel182.setBorder(new javax.swing.border.MatteBorder(null));

        F_H0.setText("jTextField1");

        F_H1.setText("jTextField2");

        F_criteria.setText("jLabel165");

        jLabel174.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(2, 0, 0));
        jLabel174.setText("<html> Reject  H<sub>0</sub>  if  </html>");

        jLabel146.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(17, 1, 1));
        jLabel146.setText("<html> &sigma <sub>0<</sub><sup>2</sup></html>");

        jLabel165.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(17, 1, 1));
        jLabel165.setText("<html> &sigma <sub>0<</sub><sup>2</sup></html>");

        jLabel171.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(17, 1, 1));
        jLabel171.setText("<html> &sigma <sub>1<</sub><sup>2</sup></html>");

        jLabel172.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(17, 1, 1));
        jLabel172.setText("<html> &sigma <sub>1<</sub><sup>2</sup></html>");

        jTextField3.setText("jTextField3");

        F_H0_sign.setEditable(false);
        F_H0_sign.setText("jTextField4");

        F_H1_sign.setEditable(false);
        F_H1_sign.setText("jTextField5");

        javax.swing.GroupLayout FTestPaneLayout = new javax.swing.GroupLayout(FTestPane);
        FTestPane.setLayout(FTestPaneLayout);
        FTestPaneLayout.setHorizontalGroup(
            FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FTestPaneLayout.createSequentialGroup()
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(FTestPaneLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FTestPaneLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(F_H0, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(F_H1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FTestPaneLayout.createSequentialGroup()
                                .addComponent(F_H1_sign, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(FTestPaneLayout.createSequentialGroup()
                                        .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                                .addComponent(F_H0_sign, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))))
                    .addGroup(FTestPaneLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(f_df1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(F_df2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(F_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(F_test_label, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(F_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(F_crit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(F_pvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(FTestPaneLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(F_result, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(173, 173, 173))
                            .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(FTestPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(F_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FTestPaneLayout.setVerticalGroup(
            FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FTestPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel179, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_H0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_H0_sign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_H1_sign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel170, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel183, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel175, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel177, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(F_test_label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_df1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(F_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(F_df2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(F_Test, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(F_crit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(F_pvalue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel174, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(F_result, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StatsWindowPane.addTab("F  Test", FTestPane);

        tTestPane.setBackground(new java.awt.Color(201, 187, 169));
        tTestPane.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel115.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(35, 5, 5));
        jLabel115.setText("<html>H<sub>a</sub></html>");
        jLabel115.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel116.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(35, 5, 5));
        jLabel116.setText("df");
        jLabel116.setBorder(new javax.swing.border.MatteBorder(null));

        tTestH1.setEditable(false);

        tTestH0.setEditable(false);

        testsign.setEditable(false);
        testsign.setText("jTextField3");

        jLabel117.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(35, 5, 5));
        jLabel117.setText("<html>H<sub>0</sub></html>");
        jLabel117.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel118.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(35, 5, 5));
        jLabel118.setText("<html>&#945; level  of  significance </html>");
        jLabel118.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel119.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(35, 5, 5));
        jLabel119.setText("t- test value");
        jLabel119.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel120.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(35, 5, 5));
        jLabel120.setText("critical  value");
        jLabel120.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel121.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(35, 5, 5));
        jLabel121.setText("p-value");
        jLabel121.setBorder(new javax.swing.border.MatteBorder(null));

        H1testsign.setEditable(false);
        H1testsign.setText("jTextField4");

        t_alos.setEditable(false);

        tdof.setText("jTextField6");

        T_test.setEditable(false);

        t_pval.setEditable(false);

        tResult.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tResult.setForeground(new java.awt.Color(17, 2, 2));

        jLabel130.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(7, 0, 0));
        jLabel130.setText("<html> &mu  <sub>2</sub></html>");

        jLabel122.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(5, 0, 0));
        jLabel122.setText("Hypothesis");

        jLabel156.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(7, 0, 0));
        jLabel156.setText("<html>  &mu  <sub>1</sub></html>");

        jLabel157.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(7, 0, 0));
        jLabel157.setText("<html> &mu  <sub>2</sub></html>");

        jLabel199.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(35, 5, 5));
        jLabel199.setText("Descision Criteria");
        jLabel199.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel200.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(35, 5, 5));
        jLabel200.setText("Descision Criteria");
        jLabel200.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel201.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(35, 5, 5));
        jLabel201.setText("Descision Criteria");
        jLabel201.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel202.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(35, 5, 5));
        jLabel202.setText("Descision Criteria");
        jLabel202.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel204.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(35, 5, 5));
        jLabel204.setText("Descision Criteria");
        jLabel204.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel139.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(19, 1, 1));
        jLabel139.setText("Descision Criteria");

        jLabel142.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(19, 1, 1));
        jLabel142.setText("Result");

        jLabel236.setFont(new java.awt.Font("Tekton Pro Ext", 1, 14)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(7, 0, 0));
        jLabel236.setText("<html>  &mu  <sub>1</sub></html>");

        tCritieria.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        tCritieria1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel143.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(19, 1, 1));
        jLabel143.setText("<html> Reject H <sub>0 </sub>  if  t</html>");

        tCriteria.setText("jLabel109");

        jLabel123.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(35, 5, 5));
        jLabel123.setText("p- value");
        jLabel123.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout tTestPaneLayout = new javax.swing.GroupLayout(tTestPane);
        tTestPane.setLayout(tTestPaneLayout);
        tTestPaneLayout.setHorizontalGroup(
            tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tTestPaneLayout.createSequentialGroup()
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jLabel122, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(tTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTestH0, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(H1testsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTestH1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(testsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tTestPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(tResult, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(tTestPaneLayout.createSequentialGroup()
                                    .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(tTestPaneLayout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(29, 29, 29)
                                            .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(tTestPaneLayout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(tdof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)
                                            .addComponent(t_alos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(T_test, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(24, 24, 24)
                                    .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(t_Critical, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(tTestPaneLayout.createSequentialGroup()
                                .addComponent(tCritieria1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(tTestPaneLayout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(tTestPaneLayout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tCriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_pval, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tTestPaneLayout.createSequentialGroup()
                                .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tCritieria, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tTestPaneLayout.createSequentialGroup()
                    .addContainerGap(388, Short.MAX_VALUE)
                    .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(264, 264, 264)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(274, 274, 274)
                    .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(378, Short.MAX_VALUE)))
        );
        tTestPaneLayout.setVerticalGroup(
            tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tTestPaneLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel122)
                .addGap(27, 27, 27)
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel130, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tTestH0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(H1testsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel236, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTestH1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testsign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t_Critical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(T_test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t_pval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tdof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_alos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tCriteria)))
                    .addGroup(tTestPaneLayout.createSequentialGroup()
                        .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tTestPaneLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(tCritieria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tCritieria1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel142)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tResult, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(669, 669, 669))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(558, 558, 558)
                    .addComponent(jLabel199, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(558, 558, 558)
                    .addComponent(jLabel200, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tTestPaneLayout.createSequentialGroup()
                    .addContainerGap(464, Short.MAX_VALUE)
                    .addComponent(jLabel201, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(548, 548, 548)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(558, 558, 558)
                    .addComponent(jLabel202, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
            .addGroup(tTestPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tTestPaneLayout.createSequentialGroup()
                    .addGap(558, 558, 558)
                    .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );

        StatsWindowPane.addTab("t  test  ", tTestPane);

        OneSampleVariancePane.setBackground(new java.awt.Color(237, 225, 192));

        jLabel151.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(17, 1, 1));
        jLabel151.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel151.setText("N");
        jLabel151.setBorder(new javax.swing.border.MatteBorder(null));

        var_alpha_lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        var_alpha_lbl.setForeground(new java.awt.Color(35, 5, 5));
        var_alpha_lbl.setText("<html>&#945; level  of  significance </html>");
        var_alpha_lbl.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel163.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(17, 6, 6));
        jLabel163.setText("Test  Statistic ");
        jLabel163.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel164.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(17, 6, 6));
        jLabel164.setText("Critical  Value");
        jLabel164.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel166.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(10, 0, 0));
        jLabel166.setText("Hypothesis");

        jLabel167.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(17, 6, 6));
        jLabel167.setText("<html> H <sub>0</sub></html>");

        jLabel168.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(17, 6, 6));
        jLabel168.setText("<html>H<sub>a</sub></html>");

        size.setText("jTextField1");

        var_alpha.setText("jTextField2");

        var_ts.setEditable(false);
        var_ts.setText("jTextField3");

        var_cv.setEditable(false);
        var_cv.setText("jTextField4");

        var_p.setText("jTextField2");

        var_H0.setEditable(false);
        var_H0.setText("jTextField2");

        var_H1.setEditable(false);
        var_H1.setText("jTextField3");

        statement.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel169.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(17, 6, 6));
        jLabel169.setText("<html>&sigma<sub>1</sub></html>");

        var_alt.setEditable(false);

        jLabel189.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(17, 6, 6));
        jLabel189.setText("<html>&sigma<sub>2</sub></html>");

        jLabel190.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(17, 6, 6));
        jLabel190.setText("<html>&sigma<sub>1</sub></html>");

        jLabel191.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(17, 6, 6));
        jLabel191.setText("<html>&sigma<sub>2</sub></html>");

        jLabel192.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(35, 5, 5));
        jLabel192.setText("Descision Criteria");
        jLabel192.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel193.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(35, 5, 5));
        jLabel193.setText("Result");
        jLabel193.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel194.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(2, 0, 0));
        jLabel194.setText("<html> Reject  H<sub>0</sub>  if &chi <sup>2 </sup>( </html>");

        varCrit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        varCrit.setText("jLabel109");

        jLabel205.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(35, 5, 5));
        jLabel205.setText("p-value");
        jLabel205.setBorder(new javax.swing.border.MatteBorder(null));

        var_opt1.setEditable(false);
        var_opt1.setText("jTextField4");

        javax.swing.GroupLayout OneSampleVariancePaneLayout = new javax.swing.GroupLayout(OneSampleVariancePane);
        OneSampleVariancePane.setLayout(OneSampleVariancePaneLayout);
        OneSampleVariancePaneLayout.setHorizontalGroup(
            OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addComponent(var_H1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(var_alt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addComponent(var_H0, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(var_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(var_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varCrit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                        .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(181, 181, 181))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OneSampleVariancePaneLayout.createSequentialGroup()
                                        .addComponent(var_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)))
                                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(var_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(statement, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(var_alpha_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(var_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                                .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        OneSampleVariancePaneLayout.setVerticalGroup(
            OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(var_H0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(var_opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel168, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(var_H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel190, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(var_alt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel189, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel151)
                            .addComponent(var_alpha_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(var_ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(var_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(OneSampleVariancePaneLayout.createSequentialGroup()
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel205, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(var_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(var_cv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OneSampleVariancePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel194, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varCrit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel193, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statement, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        StatsWindowPane.addTab("1-Sample variance test", OneSampleVariancePane);

        jClearResults.setText("clear  results");
        jClearResults.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.lightGray));
        jClearResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearResultsActionPerformed(evt);
            }
        });

        jSave.setText("save  results to disk");
        jSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.black, java.awt.Color.lightGray));
        jSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveActionPerformed(evt);
            }
        });

        jLabel106.setForeground(new java.awt.Color(19, 3, 3));
        jLabel106.setText("Enter  title  for column  # 1");
        jLabel106.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel113.setForeground(new java.awt.Color(19, 3, 3));
        jLabel113.setText("Enter  title  for column   # 2");
        jLabel113.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        Treatment.setText("jTextField1");

        jLabel114.setForeground(new java.awt.Color(19, 3, 3));
        jLabel114.setText("Enter  title  for treatment");
        jLabel114.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPanel32.setBackground(new java.awt.Color(231, 214, 214));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        jLabel173.setForeground(new java.awt.Color(150, 121, 99));
        jLabel173.setText("Enter  title  for col# 3");
        jLabel173.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel187.setForeground(new java.awt.Color(150, 121, 99));
        jLabel187.setText("Enter  title  for column #5");
        jLabel187.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel203.setForeground(new java.awt.Color(150, 121, 99));
        jLabel203.setText("Enter  title for column #4");
        jLabel203.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        col3.setDisabledTextColor(new java.awt.Color(225, 171, 131));
        col3.setSelectedTextColor(new java.awt.Color(212, 169, 169));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StatsWindowPane, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jClearResults)
                        .addGap(82, 82, 82)
                        .addComponent(jSave))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel113)
                                        .addGap(4, 4, 4)
                                        .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel203)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addComponent(jLabel187)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Treatment, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel173)
                                .addGap(38, 38, 38)
                                .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(Treatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel173)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(col3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(col1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel203)
                    .addComponent(col4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(col2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel187)
                    .addComponent(col5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jClearResults, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(325, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(StatsWindowPane, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        MycologyMultiplex.addTab("Statistics Window", jPanel17);

        jPanel19.setBackground(new java.awt.Color(213, 194, 168));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jAddRecord2db.setText("Add New Record");
        jAddRecord2db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRecord2dbActionPerformed(evt);
            }
        });

        jDeleteRecButton.setText("Delete  Record");
        jDeleteRecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteRecButtonActionPerformed(evt);
            }
        });

        jBrowseButton.setText("Browse");
        jBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddRecord2db)
                    .addComponent(jDeleteRecButton)
                    .addComponent(jBrowseButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAddRecord2db)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDeleteRecButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBrowseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel95.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(225, 28, 28));
        jLabel95.setText("Form   Buttons");
        jLabel95.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel95.setOpaque(true);

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jAddRecord.setText("New  record");
        jAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddRecordActionPerformed(evt);
            }
        });

        jClear.setText("Clear");
        jClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearActionPerformed(evt);
            }
        });

        jWrite.setText("Write");
        jWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAddRecord)
                    .addComponent(jClear)
                    .addComponent(jWrite))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jAddRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWrite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel96.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(225, 28, 28));
        jLabel96.setText("db   Buttons");
        jLabel96.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel96.setOpaque(true);

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jPerfromTestBut.setText("Perform  tests");
        jPerfromTestBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPerfromTestButActionPerformed(evt);
            }
        });

        j2SampleTTestradiobut.setText("2   Sample  t  test");
        j2SampleTTestradiobut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2SampleTTestradiobutActionPerformed(evt);
            }
        });

        jtTestRadioBut.setText("t  test");
        jtTestRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTestRadioButActionPerformed(evt);
            }
        });

        jGtestRadioBut.setText("g  Test");
        jGtestRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGtestRadioButActionPerformed(evt);
            }
        });

        jWilcoxanRadioBut.setText("Wilcoxan Signed Rank test");
        jWilcoxanRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWilcoxanRadioButActionPerformed(evt);
            }
        });

        jUTestRadioBut.setText("Mann Whitney U  Test");
        jUTestRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUTestRadioButActionPerformed(evt);
            }
        });

        jKSTest.setText("Kendal's  W  Test");
        jKSTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKSTestActionPerformed(evt);
            }
        });

        j1TailedRadioButton.setText("One  tailed  hypothesis");

        j2TailedRadioButton.setText("two  tailed  hypothesis");
        j2TailedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2TailedRadioButtonActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(225, 28, 28));
        jLabel98.setText("Hypothesis  Options");
        jLabel98.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel98.setOpaque(true);

        jChiSquared.setText("Chi  Squared Test ");
        jChiSquared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChiSquaredActionPerformed(evt);
            }
        });

        jH0EdFeild.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jH0EdFeild.setBorder(javax.swing.BorderFactory.createTitledBorder("Null Hypothesis "));
        jH0EdFeild.setOpaque(false);

        jH1EditFeild.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jH1EditFeild.setBorder(javax.swing.BorderFactory.createTitledBorder("Alternative  Hypothesis"));
        jH1EditFeild.setOpaque(false);

        jALOSCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.5", "0.2", "0.1", "0.05", "0.025", "0.01", "0.005" }));
        jALOSCB.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "alpha  level  of significance  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        jALOSCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jALOSCBActionPerformed(evt);
            }
        });

        jTestType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=", ">=", "<=" }));
        jTestType.setBorder(javax.swing.BorderFactory.createTitledBorder("Test option"));
        jTestType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTestTypeActionPerformed(evt);
            }
        });

        jTwoSampleVarianceRadioBut.setText("F  Test-2  Sample  Test");
        jTwoSampleVarianceRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTwoSampleVarianceRadioButActionPerformed(evt);
            }
        });

        jPaired_tTestRadioBut.setText("Paired t -Test");
        jPaired_tTestRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPaired_tTestRadioButActionPerformed(evt);
            }
        });

        jVarianceRadioBut.setText("1  Sample Variance  Test");
        jVarianceRadioBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVarianceRadioButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPerfromTestBut)
                .addGap(95, 95, 95))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j1TailedRadioButton)
                    .addComponent(jPaired_tTestRadioBut)
                    .addComponent(jTwoSampleVarianceRadioBut)
                    .addComponent(jtTestRadioBut)
                    .addComponent(j2SampleTTestradiobut)
                    .addComponent(jGtestRadioBut)
                    .addComponent(jUTestRadioBut)
                    .addComponent(jKSTest)
                    .addComponent(jWilcoxanRadioBut)
                    .addComponent(jH1EditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jALOSCB, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTestType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(j2TailedRadioButton)
                    .addComponent(jH0EdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChiSquared)
                    .addComponent(jVarianceRadioBut)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChiSquared)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtTestRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2SampleTTestradiobut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGtestRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUTestRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jWilcoxanRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jKSTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTwoSampleVarianceRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaired_tTestRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jVarianceRadioBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(j1TailedRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j2TailedRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jH0EdFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jH1EditFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jALOSCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTestType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPerfromTestBut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel97.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(225, 28, 28));
        jLabel97.setText("Statistical  Window   Options");
        jLabel97.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jLabel97.setOpaque(true);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel97)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MycologyMultiplex, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(MycologyMultiplex, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MycologyMultiplex.getAccessibleContext().setAccessibleName("Coral");

        getAccessibleContext().setAccessibleName("Mycology Forms   1.0");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
  public void Remove( int col_index){
  TableColumn tcol = StatsTable.getColumnModel().getColumn(col_index);
  StatsTable.removeColumn(tcol);
  }
    
    protected void checkNulloption()
{
     if (  j2tailed == true)
   {NullOption= "=";
   ATO="<>";
   }
}
    

public  void   simplelogger(Exception  e)
{
  try{  
FileWriter   f =   new  FileWriter("log.txt",true);
BufferedWriter   out  = new BufferedWriter(f);
PrintWriter  p =  new PrintWriter(out,true);
e.printStackTrace(p);
  }
  catch(Exception err){};
}


public  void setColumns()
 {
     
   if(KS==true)
   {
       
       switch (y) {
     
       case 2:
           for(int i=2;i<StatsTable.getColumnCount();++i)    
          {Remove(4);}
          Remove(1);
       break;
       case 3:
        Remove(6);
         Remove(5);
        Remove(1);
       break;
       case 4:
        Remove(6);
        Remove(1);
       break;
       case 5:
       Remove(1);
       break;
      
       }
   
   }  
       
  if(chi_squared==true   ||  Gtest==true)
  {
  Remove(5);
Remove(4);
Remove(4);
  }
 if(t_Test==true   || one_sample==true || wilcoxan==true)
 {

Remove(6);
Remove(5);
Remove(4);
Remove(2);
Remove(1);

 
 }
 
 if(TwoSampleT==true    ||  Ftest==true   || paired_t==true|| U_Test==true)
 {
   StatsTable.moveColumn(1, 6);
   Remove(6);
   
     for(int i=1;i<StatsTable.getColumnCount();++i)    
        {
            Remove(3);}
      
   
    
    
  
  
  
  
    
  
         

 
      
 
 
 

  
 
 
     }
 
 }

   protected  void clear_table()
   {
      for(int i = 0; i<10;++i)
   {StatsTable.setValueAt(0.0, i,3);
     StatsTable.setValueAt(0, i,2);
     StatsTable.setValueAt(0, i,4);
     StatsTable.setValueAt(0, i,5);
     StatsTable.setValueAt(0, i,6);
   }  
   }     
           
         
    
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

    private void jClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearActionPerformed
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
         
         
         
         
         
    }//GEN-LAST:event_jClearActionPerformed

    private void jGMVeilCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGMVeilCBActionPerformed
        Object GM_Veilobj = jGMVeilCB.getSelectedItem();
         Gill_Veil=GM_Veilobj.toString();
    }//GEN-LAST:event_jGMVeilCBActionPerformed

    private void jAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRecordActionPerformed
        
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
          
          
          
          
    }//GEN-LAST:event_jAddRecordActionPerformed

    private void jWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWriteActionPerformed
     
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
    
    }//GEN-LAST:event_jWriteActionPerformed
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
              + "\r\n Rhizomorps  present %s"
           + "\r\n  Melzer's Reagent to interior  %s "
              + "\r\n  Green reaction to ferrous oxide %s";
         
         
          String  genmsg ="   \r\n\r\nGeneral Characteristics"
              + "\r\nEntire  Height  %s"
              + " \r\nCrown Diameter  %s  "
              + "\r\n  Stem base width %s "
              +"\r\n  Stem  width %s"
                  + "\r\nOdour  %s "
              + "\r\n  Taste  %s"; 
         
       Taxonomy t= new Taxonomy(Taxon[3],CollectorNo[3],Photo[3], jCoralFungusCollectorsEdFeild);
       Coral_GenChar c_gc=new  Coral_GenChar(EntireHeight,Crown,Stem_Base,Stem_Width,Odor[2],Taste[2]);
       Branch_Char bc= new Branch_Char(Rhizo,BranchConst,Stalk,Flesh,MelzersR,GreensR);
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
     Rhizo = jCoralFungusRhizoObj.toString();
        Branch_Char  bc =new  Branch_Char(Rhizo,null,null,null,null,null);
     
    }//GEN-LAST:event_jCoralFungusRhizoCBActionPerformed

    private void jCoralFungusBCCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusBCCBActionPerformed
        Object  jCoralFungusBCCBObj=jCoralFungusBCCB .getSelectedItem();
     BranchConst= jCoralFungusBCCBObj.toString();
        Branch_Char  bc =new  Branch_Char(null,BranchConst,null,null,null,null);
    }//GEN-LAST:event_jCoralFungusBCCBActionPerformed

    private void jCoralFungusFleshCCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusFleshCCBActionPerformed
      Object  jCoralFungusFleshCBObj= jCoralFungusFleshCCB.getSelectedItem();
     Flesh= jCoralFungusFleshCBObj.toString();
        Branch_Char  bc =new  Branch_Char(null,null,null,Flesh,null,null);
    }//GEN-LAST:event_jCoralFungusFleshCCBActionPerformed

    private void jCoralFungusStalkCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCoralFungusStalkCBActionPerformed
        Object  jCoralFungusStalkCBObj= jCoralFungusStalkCB.getSelectedItem();
     Stalk= jCoralFungusStalkCBObj.toString();
    Branch_Char  bc =new  Branch_Char(null,null,Stalk,null,null,null);
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

    private void jMRCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRCBActionPerformed
        Object  jMRCBCBObj=  jMRCB.getSelectedItem();
     MelzersR= jMRCBCBObj.toString();
        Branch_Char  bc =new  Branch_Char(null,null,null,null,MelzersR,null);
    }//GEN-LAST:event_jMRCBActionPerformed

    private void jGreenCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGreenCBActionPerformed
          Object  jMRCBCBObj=  jMRCB.getSelectedItem();
     GreensR= jMRCBCBObj.toString();
        Branch_Char  bc =new  Branch_Char(null,null,null,null,GreensR,null);
    }//GEN-LAST:event_jGreenCBActionPerformed

    private void jAddRecord2dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddRecord2dbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddRecord2dbActionPerformed

    private void jDeleteRecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteRecButtonActionPerformed
         JOptionPane.showMessageDialog(null,"Delete  Window","error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jDeleteRecButtonActionPerformed

    private void jBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrowseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrowseButtonActionPerformed

    private void jPerfromTestButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPerfromTestButActionPerformed
       
       
       double chisquareVal,testvalue;
    
       int  rows=StatsTable.getRowCount();
         int df=1;

                         
     
        
        if(ChiSquarePane.isShowing()  &&  chi_squared)
           {   
                
         long [] observed =  new long[100];
         double [] expected  = new double[100];
         long data[]  = new long[100];
         double data1[]  = new double[100];
       
       try{
       for(int i=0;  i<=rows;++i)
    {if (StatsTable.getValueAt(i,0) != null)
      {data[i]=Long.parseLong(StatsTable.getValueAt(i, 2).toString() );
         data1[i]= Double.parseDouble(StatsTable.getValueAt(i, 3).toString() );
      df++;
       
      }
    
     }
       
      }catch(Exception e)   {
            //JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
          simplelogger(e);}
       
     
  
      expected = Arrays.copyOf(data1,df-1);
  observed  = Arrays.copyOf(data,df-1) ;
     
             if(expected.length==observed.length)
              {    
             ChiSquaredDistribution  chi  =  new ChiSquaredDistribution(df,alpha) ;
              
              chisquareVal=TestUtils.chiSquare(expected, observed);
                String  _chi= String.format("%1.3f",chisquareVal);
              critical_value[0]=  chi.inverseCumulativeProbability(alpha);
               String CV=String.format("%1.3f",critical_value[0]);
              pvalue[0]=TestUtils.chiSquareTest(expected, observed);
             _pval= String.format("%1.3f",pvalue[0]);
              DOFDisplay.setText(Double.toString(df));
              pValueDisplay.setText(_pval);
              
                     H0=jH0EdFeild.getText();
                      
                      H1=jH1EditFeild.getText();
                     
                 NULLTextDisplay.setText(H0);
               H1Displayfeild.setText(H1);
               alphaDisplay.setText(Double.toString(alpha));
         
              jChiValueDisplay.setText(_chi);
               jCriticalDisplay.setText(CV);
               
                String  c1=String.format(" <= %5.3f",critical_value[0]);
         String  c2=String.format(" >= %5.3f",critical_value[0]);
         String  c3=String.format(" = %5.3f",critical_value[0]);
      String  lessthan= String.format("  %2.3f <= %2.3f  we  can  accept  the Null Hypothesis",  chisquareVal,critical_value[0]);
     String  GTthan= String.format("  %2.3f >= %2.3f  we  can  accept  the Null Hypothesis",  chisquareVal,critical_value[0]);     
            String  ha_lessthan= String.format("  Since    %2.3f>  %2.3f  we  can  reject  the Null Hypothesis",chisquareVal,critical_value[0]);
       String  ha_GTthan= String.format("  Since    %2.3f< %2.3f   we  can  reject  the Null Hypothesis",chisquareVal,critical_value[0]);
           
               if(critical_value[0]<=  chisquareVal)
               kiCriteria.setText(c1);
                  if(critical_value[0]>=  chisquareVal)
               kiCriteria.setText(c2);
                 if(critical_value[0]==  chisquareVal)
               kiCriteria.setText(c3);
               
              if(critical_value[0]<=  chisquareVal)
               resultDisplay.setText(lessthan);
                  if(critical_value[0]>=  chisquareVal)
               resultDisplay.setText(GTthan);
                 if(critical_value[0]==  chisquareVal)
               resultDisplay.setText(c3);
              }
           }
        
       if(tTestPane.isShowing()  & t_Test)
           { double sample[]=new double[1000];
          
             double data[]=  new  double [1000];
           
               double  sdev,mu,Ybar;
                              
   try{
       for(int i=0;  i<=rows;i++)
    {
      
       if (Integer.parseInt(StatsTable.getValueAt(i,0).toString()) != 0)
      data[i]=Double.parseDouble(StatsTable.getValueAt(i, 1).toString());

        df++; 

 
     }
       
      }catch(Exception e)   {simplelogger(e);
      //JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
      }
    
              String  ans;
        ans = JOptionPane.showInputDialog("Enter sample  mean: ");
        mu= Double.parseDouble(ans);
              sample  = Arrays.copyOf(data,df-1) ;
               
               
             
              SummaryStatistics Stats = new SummaryStatistics();
                       for (int i = 0; i <df-1; i++) 
                       {Stats.addValue(sample[i]);
           
                       }
                  
                       TDistribution t = new TDistribution(df-1);
                       if( j2tailed==true )
                       critical_value[1]=2*t.inverseCumulativeProbability(1- (2*alpha/2));
                        NullOption="<=";
                          if(NullOption.equals("<= "))
                              critical_value[1]=t.inverseCumulativeProbability(1- alpha);
                           NullOption=">=";
                           if( NullOption.equals(">=") )
                              critical_value[1]=t.inverseCumulativeProbability(alpha);
                    
                            
                        sdev=Stats.getStandardDeviation();
                        Ybar=Stats.getMean();
                       ttest=Math.abs(Ybar-mu)/sdev;
                        String _t= String.format("%1.3f",ttest);
                         pvalue[1]=TestUtils.tTest(mu, sample );   
                       tdof.setText(Double.toString(df-1));  
                      t_alos.setText(Double.toString(alpha));
                      String _CV= String.format("%1.3f",critical_value[1]);              
                      t_Critical.setText(_CV);
                      
                      T_test.setText(_t);
                     
                      t_pval.setText(Double.toString(pvalue[1]));
                       
                     H0=jH0EdFeild.getText();
                      tTestH0.setText(H0);
                      H1=jH1EditFeild.getText();
                     
                      tTestH1.setText(H1); 
                                 
                      testsign.setText(ATO);
                      H1testsign.setText(NullOption);
                    
                      
                      String  c1=String.format(" <= %5.3f",critical_value[2]);
         String  c2=String.format(" >= %5.3f",critical_value[2]);
         String  c3=String.format(" = %5.3f",critical_value[2]);
         String  lessthan= String.format("  Since    %2.3f <= %2.3f  we  can  accept  the Null Hypothesis",ttest,critical_value[1]);
     String  GTthan= String.format("  Since    %2.3f >= %2.3f  we  can't  accept  the Null Hypothesis",ttest,critical_value[1]);
       String  ha_lessthan= String.format("  Since    %2.3f>  %2.3f  we  can't  reject  the Null Hypothesis",ttest,critical_value[1]);
       String  ha_GTthan= String.format("  Since    %2.3f< %2.3f   we  can  reject  the Null Hypothesis",ttest,critical_value[1]);
           
       
       
       if  (tStar<=critical_value[1])
         tResult.setText(lessthan);
     if(tStar> critical_value[1]);
         tResult.setText(ha_lessthan);
     if(tStar>= critical_value[1])
            tResult.setText(GTthan); 
      if(tStar< critical_value[1])
              tResult.setText(ha_GTthan); 
       
               
               if(critical_value[1]<=tStar)
               tCriteria.setText(_t);
                  if(critical_value[1]>=tStar)
               tCriteria.setText(_t);
                 if(critical_value[1]==tStar)
                  tCriteria.setText(_t);
                      
                   
                      
                
                     
    }//GEN-LAST:event_jPerfromTestButActionPerformed
    
    
    if(TwoSampletTestPane.isShowing() &&  TwoSampleT)
           {  double  TwoSampleTest,var,  n1_den,n2_den,den;
               double   num, TwoSampleDev;
                  double obs[]=new  double[1000];
                  double obs2[]=new  double[1000];
                  int  n1;
                  int n2;
                  double data[]= new  double[1000];
                  double data1[]  = new double[1000];
                    try{
       for(int i=0;  i<=rows;++i)
    {if (StatsTable != null)
      {data[i]=Double.parseDouble(StatsTable.getValueAt(i, 2).toString() );
       data1[i]= Double.parseDouble(StatsTable.getValueAt(i, 3).toString() );
       
      }
    
     }
       
      }catch(Exception e)   {  
          simplelogger(e);
          JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
      }
               
          obs = Arrays.copyOf(data,data.length) ;
           obs2  = Arrays.copyOf(data1,data1.length);
            n1=data.length;
            n2=data1.length;
            dof=n1+n2-2;
            
           SummaryStatistics Stats = new SummaryStatistics();
                       for (int i = 0; i < obs.length; i++) 
                       {Stats.addValue(obs[i]);
                       }
          
                       
                SummaryStatistics Stats2 = new SummaryStatistics();
                       for (int i = 0; i < obs2.length; i++) 
                       {
                        Stats2.addValue(obs2[i]);}
                     
                         num=Stats.getMean()-Stats2.getMean();
          
                        TwoSampleTest = TestUtils.t(obs, obs2);
                       
                     
                       var=(Stats2.getVariance()+Stats.getVariance())/dof;
                       n1_den=1.0/n1;
                       n2_den=1.0/n2;
                       den=n1_den+n2_den;
                       TwoSampleDev=Math.sqrt(var*den);
                       tStar=num/TwoSampleDev;;
                       pvalue[2]=TestUtils.tTest(obs,obs2 ); 
                      
                       ALOS_tSample.setText(Double.toString(alpha));
                       twoSampleT.setText(Double.toString(tStar));
                       HO2Test.setText(H0);
                       H12Test.setText(H1);
                       jDOF2Display.setText(Integer.toString(dof));
                       TwoTest_pval.setText(Double.toString(pvalue[2]));
                       TDistribution t = new TDistribution(dof);
                   
                       if(  j2tailed==true )
                       critical_value[2]=2*t.inverseCumulativeProbability(1- (2*alpha/2));
                          if( NullTestOption.equals("<=" )   &&    j2tailed==false )
                             critical_value[2]=t.inverseCumulativeProbability(1- alpha);
                           if( NullTestOption.equals( ">=") && j2tailed==false )
                             critical_value[2]=t.inverseCumulativeProbability(alpha);
                           
                 
                           testOption.setText(NullOption);
                           testOpt2.setText(ATO);
                           Two_tCritical.setText(Double.toString(critical_value[2]));
                     String  c1=String.format(" t*<= %5.3f",critical_value[2]);
         String  c2=String.format("t* >= %5.3f",critical_value[2]);
         String  c3=String.format(" t*= %5.3f",critical_value[2]);
         String  lessthan= String.format("  Since    %2.3f <= %2.3f  we  can  accept  the Null Hypothesis",paired_Tstat,critical_value[2]);
     String  GTthan= String.format("  Since    %2.3f >= %2.3f  we  can't  accept  the Null Hypothesis",paired_Tstat,critical_value[2]);
       String  ha_lessthan= String.format("  Since    %2.3f>  %2.3f  we  can't  reject  the Null Hypothesis",paired_Tstat,critical_value[2]);
       String  ha_GTthan= String.format("  Since    %2.3f< %2.3f   we  can  reject  the Null Hypothesis",paired_Tstat,critical_value[2]);
        

   
           if  (ttest<=critical_value[2])
         tResult.setText(lessthan);
     if(ttest> critical_value[2]);
         tResult.setText(ha_lessthan);
     if(ttest>= critical_value[2])
            tResult.setText(GTthan); 
      if(ttest< critical_value[2])
              tResult.setText(ha_GTthan); 
      
               if(critical_value[2]<=ttest)
               twoSampleCrit.setText(c1);
                  if(critical_value[2]>=ttest)
               twoSampleCrit.setText(c2);
                 if(critical_value[2]==ttest)
                  twoSampleCrit.setText(c3);
                      
      
      
                           
    }                    
    
    
     if(GtestPane.isShowing() &&  Gtest)
     {
         long g1[]=new long[1000];  
         double g2[]=new double[1000];
         
         double [] expected = new double[1000];
         long[] observed = new long[1000];
         
          try{
       for(int i=0;  i<=4;++i)
    {if (StatsTable != null)
      {g1[i]=Long.parseLong(StatsTable.getValueAt(i, 2).toString() );
       g2[i]= Double.parseDouble(StatsTable.getValueAt(i, 3).toString() );
     df++;
      }
    
     }
       
      }catch(Exception e)   {simplelogger(e);
      JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
      }
          
    observed= Arrays.copyOf(g1,df-1);
    expected  =Arrays.copyOf(g2,df-1);
         System.out.println(Arrays.toString(observed));
         System.out.println(Arrays.toString(expected));
         if(observed.length==expected.length)
         {
         pvalue[8]=TestUtils.gTest(expected, observed);
         String _gpval= String.format("%5.3f",pvalue[8]);
         gpval.setText(_gpval);
         G_dof.setText(Integer.toString(df));
         String _gtest=String.format("%5.3f",TestUtils.g(expected, observed));
         Gtestval.setText(_gtest);
         G_alpha.setText(Double.toString(alpha));
           ChiSquaredDistribution chisquared=  new ChiSquaredDistribution(df,alpha);
             critical_value[8]=chisquared.inverseCumulativeProbability(alpha);
             String gcrit= String.format("%5.3f",critical_value[8]);
             String sol1= String.format("Since G>=%5.3f. We  reject H0",critical_value[8]);
             String sol2= String.format("Since G<=%5.3f. We  reject H0",critical_value[8]);
             String sol3= String.format("Since G=%5.3f. We  reject H0",critical_value[8]);
                 String alt1= String.format("Since G>%5.3f. We  accept H0",critical_value[8]);
             String alt2= String.format("Since G<%5.3f. We  accep H0",critical_value[8]);
              H0=jH0EdFeild.getText();
             GHypo.setText(H0);
               H0=jH0EdFeild.getText();
                H1=jH1EditFeild.getText();
               GAlt.setText(H1);
               
             G_crit.setText(gcrit);
        String  c1=String.format(" <= %5.3f",critical_value[8]);
         String  c2=String.format(" >= %5.3f",critical_value[8]);
         String  c3=String.format(" = %5.3f",critical_value[8]);
         
            NullOption="<=";
           if( NullOption.equals( "<=" ))
          {
               criteria.setText(c1);
               solution.setText(sol1);
          }
           NullOption=">=";
          if( NullOption.equals (">=")  )
          {criteria.setText(c2);
           solution.setText(sol2);
           }
           
           if(TestUtils.g(expected, observed)>critical_value[8])
               solution.setText(alt1);
            if(TestUtils.g(expected, observed)<critical_value[8])
               solution.setText(alt2);
           
       
           if(j2tailed==true )
           {
      
               criteria.setText(c3);
               solution.setText(sol3);
           }
         }
    }
     
     
    if(WilcoxanPane.isShowing() &&  wilcoxan)
           {
                   
    }     
   if(ManWhitneyPane.isShowing() &&  U_Test)
           {
                   
    }     
    
    
     if(KendalWTestPane.isShowing() && KS)
           {
             double  R,S,W,test ;
             int n=1;
             
          double [] rank = new double [10];
        
     
       m=Integer.parseInt(ans);
       

    try{
      for(int i=0;  i<=rows;i++)
    {if (StatsTable.getValueAt(i,0) != null)
     {n++;
         switch(m){
     case 2:
      {
       rank[i]+= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() )
                        + Double.parseDouble(StatsTable.getValueAt(i, 3).toString() );
                  
       break;
     }
     case 3:
      {
       rank[i]+= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() )
                + Double.parseDouble(StatsTable.getValueAt(i, 3).toString() )
                 + Double.parseDouble(StatsTable.getValueAt(i, 4).toString() ); 
       break;
     }
       case 4:
      {
       rank[i]+= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() )
                + Double.parseDouble(StatsTable.getValueAt(i, 3).toString() )
                 + Double.parseDouble(StatsTable.getValueAt(i, 4).toString() )
               + Double.parseDouble(StatsTable.getValueAt(i, 5).toString() ); 
       break;
     }
       case 5:
      {
       rank[i]+= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() )
                + Double.parseDouble(StatsTable.getValueAt(i, 3).toString() )
                 + Double.parseDouble(StatsTable.getValueAt(i, 4).toString() )
               + Double.parseDouble(StatsTable.getValueAt(i, 5).toString() )
                   + Double.parseDouble(StatsTable.getValueAt(i, 6).toString() );
       break;
     } 
     
     }
     }
    }
       
     }catch(Exception e)   {simplelogger(e);
     //JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
     }
    
        R=m*(n+1)/2;
        Kendal_cv.setText(ans);
         SummaryStatistics  KendalW = new SummaryStatistics();
                       for (int i = 0; i < rank.length; i++) 
                       {KendalW.addValue(rank[i]);}
                       
           S=KendalW.getSumsq();            
             W=12*S/(Math.pow(m,2)*(Math.pow(n,3)-n));
           test=12*S/( m*(Math.pow(n,2)-1));
           if  (n<7)
           {
                  W=12*S/(Math.pow(m,2)*(Math.pow(n,3)-n));
            TDistribution t = new TDistribution(30);
           critical_value[12]= t.inverseCumulativeProbability(alpha);
          pvalue[12]=1-t.cumulativeProbability(critical_value[12]);
           String _w=String.format("4.3%f",W);
          W_coeff.setText(_w);
           }
          if  (n>7)
           {
       
         double X=m*(n-1)*W;
            String _w=String.format("4.3%f",X);
            ChiSquaredDistribution  chi=new ChiSquaredDistribution(n-1);
             critical_value[12]= chi.inverseCumulativeProbability(alpha);
          
           }
          w_alpha.setText(Double.toString(alpha));
          
          String  W_test=String.format("4.3%f",test);
          score.setText(W_test);
          kendal_cv.setText(Double.toString(critical_value[12]));
          kcv.setText(Double.toString(critical_value[12]));
          kendal_pval.setText(Double.toString(pvalue[12]));
          Kendal_descision.setText(Integer.toString(m));
          Kendal_cv.setText(Double.toString(critical_value[12]));
          String H0= String.format("Since   %2.3f  <%2.3f  we  can't  reject  the Null Hypothesis",test,critical_value[12]);
           String Ha= String.format("Since   %2.3f  >%2.3f  we  can  reject  the Null Hypothesis",test,critical_value[12]);
           
           if(test<critical_value[12])
               kendal_result.setText(H0);
           else
                kendal_result.setText(Ha);
           }
        
                
    
            
             
               
           
     
      if(FTestPane.isShowing() && Ftest  )
           {
                double s1[]=new double[1000];
                  double s2[]=new double[1000];
                  double  v,v1,sd,sd1,Ftest,L,U;
                  double   f1[]= new  double[1000];
                  double  f2[]= new  double[1000];
                  
            try{
       for(int i=0;  i<=5;++i)
    {if (StatsTable.getValueAt(i,0) != null)
      {f1[i]=Double.parseDouble(StatsTable.getValueAt(i, 1).toString() );
      f2[i]= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() );
       ++df1;
       ++df2;
      }
    
     }
       
      }catch(Exception e)   {simplelogger(e);
      //JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info.");
     
      }
               
        s1 = Arrays.copyOf(f1,df1) ;
        s2  = Arrays.copyOf(f2,df2);
        
       
                        
                  SummaryStatistics ftest = new SummaryStatistics();
                       for (int i = 0; i < s1.length; i++) 
                       {ftest.addValue(s1[i]);}
                         
                 SummaryStatistics ftest2 = new SummaryStatistics();
                       for (int i = 0; i < s2.length; i++) 
                       {ftest2.addValue(s2[i]);}
                v=ftest.getVariance();
                v1=ftest2.getVariance();
                sd=ftest.getStandardDeviation();
                sd1=ftest2.getStandardDeviation();
                 Ftest=(v/sd)/(v1/sd1)  ;
             FDistribution  f=   new FDistribution(s1.length-1,s2.length-1);
               FDistribution  f_UB=   new FDistribution(s1.length-1,s2.length-1);
                FDistribution  f_LB=   new FDistribution(s1.length-1,s2.length-1);
                H0=jH0EdFeild.getText();
                H1=jH1EditFeild.getText();
               F_H0.setText(H0);
               F_H1.setText(H1);
               
                   
                  if( NullTestOption.equals(">="  ) )
                  {    NullOption=">=";
                       ATO="<";
                          critical_value[7]=f.inverseCumulativeProbability(alpha);
                         String criteria = String.format("F>=%5.3f",critical_value[7]);
                        F_criteria.setText(criteria);
                        F_H0_sign.setText(NullOption);
                        F_H1_sign.setText(ATO);
                          String _fcrit =String.format("%5.3f",critical_value[7]);
                          F_crit.setText(_fcrit);
                  }
                  
                     
                     if( NullTestOption.equals("<=") ){
                          NullOption="<=";
                          ATO=">";
                          critical_value[7]=f.inverseCumulativeProbability(1-alpha);
                             String criteria1= String.format("F<=%5.3f",critical_value[7]);
                         F_criteria.setText(criteria1);
                           F_H0_sign.setText(NullOption);
                           F_H1_sign.setText(ATO);
                     }
                     
                     
                     
                        if( j2tailed == true )
                        {
                            NullOption="=";
                          ATO="<>";
                     critical_value[5]=f_LB.inverseCumulativeProbability(alpha/2);
                   critical_value[6]=f_LB.inverseCumulativeProbability(1-(alpha/2));
                    L=(v/v1)*(1.0/critical_value[6]);
                  U=(v/v1)*( 1.0/ critical_value[5]);
                         String crit3= String.format("%5.3f<=F<=%5.3f",critical_value[6],critical_value[5]);
                         F_criteria.setText(crit3);
                         critical_value[7]=critical_value[5];
                           F_H0_sign.setText(NullOption);
                           F_H1_sign.setText(ATO);
                     }
                      F_alpha.setText(Double.toString(alpha));
                        String _ftest= String.format("%5.3f",Ftest);
                      F_Test.setText(_ftest);
              f_df1.setText(Integer.toString(s1.length-1));
              F_df2.setText(Integer.toString(s2.length-1));
                     
                  if((v/v1)>=critical_value[7] &&   j1Tailed==true)
                  {pvalue[7]=1-f.cumulativeProbability(critical_value[7]);
                  String desc= String.format("Since %5.3f   >= %5.3f,we  accept H0",Ftest,critical_value[7]); 
                  String pval2 = String.format("%5.3f",1-f.cumulativeProbability(critical_value[7]));
                   F_pvalue.setText(pval2);
                    F_result.setText(desc);
                     
                  }
           
                  
                  if( (v/v1)<critical_value[7] && j1Tailed==true )
                  {pvalue[7]=1-f.cumulativeProbability(critical_value[7]);
                  String desc= String.format("Since %5.3f< %5.3f,we  reject H0",Ftest,critical_value[7]); 
                   String pval2 = String.format("%5.3f",1-f.cumulativeProbability(critical_value[7]));
                   F_pvalue.setText(pval2);
                      F_result.setText(desc);
                  
                  }
                  
                  
                if((v/v1)<=critical_value[7] &&   j1Tailed==true)
                {   pvalue[7]=1-f.cumulativeProbability(critical_value[7]);
                  String ans= String.format("Since %5.3f<= %5.3f ,we  accept H0",Ftest,critical_value[7]); 
                 String pval2 = String.format("%5.3f",1-f.cumulativeProbability(critical_value[7]));
                   F_pvalue.setText(pval2);
                   F_result.setText(ans);
                }
                  
                if((v/v1)>critical_value[7] &&   j1Tailed==true)
                {   pvalue[7]=1-f.cumulativeProbability(critical_value[7]);
                  String desc2= String.format("Since %5.3f > %5.3f ,we  reject H0",Ftest,critical_value[7]); 
              F_result.setText(desc2);
                              
                }
                             
                
                
                  if((critical_value[5] <=(v/v1) )  ||(  critical_value[6] <=(v/v1))  &&   j2tailed==true)
                  {
                   
                    pvalue[7]=1-f.cumulativeProbability(critical_value[5]);
                    String desc3= String.format("Since %5.3f  =<F<= %5.3f,we  accept H0",critical_value[5],critical_value[6]); 
                     String pval2 = String.format("%5.3f",1-f.cumulativeProbability(critical_value[7]));
                   F_pvalue.setText(pval2);
                   F_result.setText(desc3);
                  }
                  
               
               
              
            
            
           }
     
     
     
     if(OneSampleVariancePane.isShowing()  &&  one_sample)
           {
               
               double  var,num,beta=0,LBcv=1,UBcv=1;
                 double sample[]=new double[1000];
                 double  [] variance_t= new double [1000]; 
                 
                try{
       for(int i=0;  i<=10;++i)
             {if (StatsTable.getValueAt(i,0)  != null)
      {
       variance_t[i]= Double.parseDouble(StatsTable.getValueAt(i, 1).toString() ); 
      
      } }  
      }catch(Exception e)   {simplelogger(e);
      //JOptionPane.showMessageDialog(null,"Input error: see err.log  for more info."); 
      
      }
        
            
                    sample = Arrays.copyOf(variance_t,variance_t.length); 
          
                SummaryStatistics Stats = new SummaryStatistics();
                       for (int i = 0; i < sample.length; i++) 
                       {Stats.addValue(sample[i]);
                       }    
                        n=sample.length;
                       num= (n-1)*Stats.getVariance();
                       var= num/Stats.getStandardDeviation(); 
                       
            NullTestOption="<=";           
            if( NullTestOption.equals( "<=") )
            {
      
           ChiSquaredDistribution chisquared=  new ChiSquaredDistribution(n-1,1-alpha);
                    critical_value[4]=chisquared.inverseCumulativeProbability(1-alpha);
                    pvalue[4]= 1-chisquared.cumulativeProbability(critical_value[4]);
           
           }
            NullTestOption=">=";
              if( NullTestOption.equals( ">=")   &&    j2tailed==false )
            {
         
           ChiSquaredDistribution chisquared=  new ChiSquaredDistribution(n-1,alpha);
                    critical_value[4]=chisquared.inverseCumulativeProbability(alpha);
                    pvalue[4]= 1-chisquared.cumulativeProbability(critical_value[4]);
           
           }
            
            
           
         size.setText(Integer.toString(n));
   
             
               if( j2tailed == true)
             {
                  NullTestOption="==";
                  ATO="<>";
              beta=1-(alpha/2);
             ChiSquaredDistribution LB =  new ChiSquaredDistribution(n-1,alpha/2);
             ChiSquaredDistribution UB =  new ChiSquaredDistribution(n-1,beta);
              LBcv = ((n-1)*Stats.getVariance())/LB.inverseCumulativeProbability(alpha/2);
              UBcv =  ((n-1)*Stats.getVariance())/UB.inverseCumulativeProbability(beta);
             
             if(var <LBcv  ||var> UBcv)
             {critical_value[4]=LBcv;
              pvalue[4]=1 -LB.cumulativeProbability(critical_value[4]);    
             }else
                {critical_value[4]=UBcv;
              pvalue[4]=1 -UB.cumulativeProbability(critical_value[4]);    
             } 
                 
                 
              
             }
                
                H0=jH0EdFeild.getText();
                  H1=jH1EditFeild.getText();
                var_H0.setText(H0);
                var_H1.setText(H1);
                         var_opt1.setText(NullTestOption);
             var_alt.setText(ATO);
               _var=String.format("%2.3f",var);
              String _cv= String.format("%2.3f",critical_value[4]);
                  var_ts.setText(_var);
                  var_cv.setText(_cv);
                  var_alpha.setText(Double.toString(alpha));
                  String _pv = String.format("%2.3f",pvalue[4]);
                  var_p.setText(_pv);
           
       String  varcrit1=String.format("%2.3f, %d)<=%2.3f",1-alpha/2,n-1,var);    
        String  varcrit2=String.format("%2.3f, %d)>=%2.3f",alpha,n-1,var);   
       String  varcrit3=String.format("%2.3f, %d)<>%2.3f",1-alpha,n-1,var);   
         
     String  lessthan= String.format("  Since    %2.3f <= %2.3f  we  can  accept  the Null Hypothesis",var,critical_value[4]);
     String  GTthan= String.format("  Since    %2.3f >= %2.3f  we  can  accept  the Null Hypothesis",var,critical_value[4]);
       String  ha_lessthan= String.format("  Since    %2.3f>  %2.3f  we  can  reject  the Null Hypothesis",var,critical_value[4]);
       String  ha_GTthan= String.format("  Since    %2.3f< %2.3f   we  can  reject  the Null Hypothesis",var,critical_value[4]);
     String  NotEq = String.format("  Since    %2.3f<> %2.3f   we  can  reject  the Null Hypothesis",var,critical_value[4]);
     
       
       if  (var<=critical_value[4])
        {
         statement.setText(lessthan);
         varCrit.setText(varcrit1);
        }
        else
     {
         statement.setText(ha_lessthan);
          varCrit.setText(varcrit2);
     }
     
     
     if(var>= critical_value[4])
     {
        statement.setText(GTthan); 
       varCrit.setText(varcrit3); 
     }
     else
        statement.setText(ha_GTthan); 
     
     
    if(j2tailed==true)
    {
    String j2tailstatement = String.format("Since %2.3f <=%2.3f<= %2.3f, we cannot reject the Null Hypothesis",LBcv,var,UBcv);
    statement.setText(j2tailstatement);
    }
    else
       statement.setText(NotEq); 
           
   
           } 
     
     
     if(Paired_tTestPanel.isShowing()   &&  paired_t)
     {  double t0[] =new double [1000];
         double t1[]= new double[1000];
         
         boolean pairedTtest;
     double sample1[]=new  double[1000];
        double sample2[]=new double[1000];
               
                 
       try{
       for(int i=0;  i<=rows;++i)
    {if (StatsTable.getValueAt(i,0) != null)
      {t0[i]=Double.parseDouble(StatsTable.getValueAt(i, 1).toString() );
       t1[i]= Double.parseDouble(StatsTable.getValueAt(i, 2).toString() );
       dof++;
      }
    
     }
       
      }catch(Exception e)   {simplelogger(e);}
         sample1 = Arrays.copyOf(t0,dof) ;
          sample2  = Arrays.copyOf(t1,dof);         
                 
              
         SummaryStatistics Stats = new SummaryStatistics();
                       for (int i = 0; i < sample1.length; i++) 
                       {Stats.addValue(sample1[i]);
                       }
          
                       
                SummaryStatistics Stats2 = new SummaryStatistics();
                       for (int i = 0; i < sample2.length; i++) 
                       {
                        Stats2.addValue(sample2[i]);}
                  TDistribution t = new TDistribution(dof);
                  
   
     pairedT_H0.setText(H0);
     pairedT_H1.setText(H1);     
     paired_Tstat= TestUtils.pairedT(sample1, sample2);
    String answer = String.format("%1.3f",paired_Tstat);
        
            pairedTValue.setText(answer);
             ALOSPairedt.setText(Double.toString(alpha));
           pairedT_df.setText(Integer.toString(dof));
    pvalue[3]=TestUtils.pairedTTest(sample1, sample2);
     String _pval= String.format("%1.3f",pvalue[3]);
     pairedT_pval.setText(_pval);
     
     
   if( j2tailed == true )
       critical_value[3] =2*t.inverseCumulativeProbability(1- (2*alpha/2));
   NullOption="<=";
  if( NullOption.equals( "<="))
      critical_value[3]= t.inverseCumulativeProbability(1- alpha);
  NullOption=">=";
   if( NullOption.equals(">=")  )
       critical_value[3] = t.inverseCumulativeProbability(alpha);
   
     String CV = String.format("%1.3f",critical_value[3]);
     pairedT_CV.setText(CV);
    String  c1=String.format(" W<= %5.3f",critical_value[3]);
         String  c2=String.format("W >= %5.3f",critical_value[3]);
         String  c3=String.format(" W= %5.3f",critical_value[3]);
      NullOpt.setText(NullOption);
     pairedT_alt.setText(ATO);
                   if(critical_value[3]==paired_Tstat)
                 twoSampleCrit.setText(c2);
  
         String  lessthan= String.format("  Since    %2.3f <= %2.3f  we  can  accept  the Null Hypothesis",paired_Tstat,critical_value[3]);
     String  GTthan= String.format("  Since    %2.3f >= %2.3f  we  can't  accept  the Null Hypothesis",paired_Tstat,critical_value[3]);
       String  ha_lessthan= String.format("  Since    %2.3f>  %2.3f  we  can't  reject  the Null Hypothesis",paired_Tstat,critical_value[3]);
       String  ha_GTthan= String.format("  Since    %2.3f< %2.3f   we  can  reject  the Null Hypothesis",paired_Tstat,critical_value[3]);
        

     if  (paired_Tstat<=critical_value[3])
         pairedTresult.setText(lessthan);
     if(paired_Tstat> critical_value[3]);
         pairedTresult.setText(ha_lessthan);
     if(paired_Tstat>= critical_value[3])
            pairedTresult.setText(GTthan); 
      if(paired_Tstat< critical_value[3])
              pairedTresult.setText(ha_GTthan);  
              
               if(critical_value[3]<=paired_Tstat)
               twoSampleCrit.setText(c1);
                  if(critical_value[3]>=paired_Tstat)
               twoSampleCrit.setText(c2);
                 if(critical_value[3]==paired_Tstat)
                 twoSampleCrit.setText(c2);
     
             
           
     }
     
   }
    private void j2SampleTTestradiobutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j2SampleTTestradiobutActionPerformed
       
       if( j2SampleTTestradiobut.isSelected())
       {TwoSampleT=true;
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jKSTest.setSelected(false);
            jChiSquared.setSelected(false);
             jtTestRadioBut.setSelected(false);
       }
           
    }//GEN-LAST:event_j2SampleTTestradiobutActionPerformed

    private void jChiSquaredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChiSquaredActionPerformed
        
        if(jChiSquared.isSelected())
        {
            
            chi_squared=true;
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jKSTest.setSelected(false);
           jtTestRadioBut.setSelected(false);
        }
        
    }//GEN-LAST:event_jChiSquaredActionPerformed

    private void jGtestRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGtestRadioButActionPerformed
   
         if(jGtestRadioBut.isSelected())
         {
          Gtest=true;
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jKSTest.setSelected(false);
          jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jtTestRadioBut.setSelected(false);
         }
    }//GEN-LAST:event_jGtestRadioButActionPerformed

    private void jWilcoxanRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWilcoxanRadioButActionPerformed
     
         if(jWilcoxanRadioBut.isSelected())
         {
             wilcoxan=true;
          jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false); 
        jGtestRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jKSTest.setSelected(false);
           jtTestRadioBut.setSelected(false);
    }//GEN-LAST:event_jWilcoxanRadioButActionPerformed
    }
    
    private void jUTestRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUTestRadioButActionPerformed
        
          if(jUTestRadioBut.isSelected())
          {
             U_Test=true; 
        jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jKSTest.setSelected(false);
            jtTestRadioBut.setSelected(false);
    }//GEN-LAST:event_jUTestRadioButActionPerformed
    }
    
    private void jKSTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKSTestActionPerformed
        
          if(jKSTest.isSelected())
          { 
              KS=true;
             ans = JOptionPane.showInputDialog("You can have up to 5  columns");
             y= Integer.parseInt(ans);
            setColumns();
  
        col3.setEditable(true);
        jLabel173.setForeground(java.awt.Color.BLACK);
              col4.setEditable(true);
         jLabel203.setForeground(java.awt.Color.BLACK);     
              col5.setEditable(true);
          jLabel187.setForeground(java.awt.Color.BLACK);   
        jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
           jtTestRadioBut.setSelected(false);
          }
    }//GEN-LAST:event_jKSTestActionPerformed

    private void jtTestRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTestRadioButActionPerformed
        if(jtTestRadioBut.isSelected())
          {
             t_Test=true;
              jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
             jVarianceRadioBut.setSelected(false);
          jTwoSampleVarianceRadioBut.setSelected(false);
          }
    }//GEN-LAST:event_jtTestRadioButActionPerformed

    private void jALOSCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jALOSCBActionPerformed
      
        Object jALOSCBObj= jALOSCB.getSelectedItem();
       alpha= Double.parseDouble(jALOSCBObj.toString());
       
       alphadisplay =jALOSCBObj.toString();
       
    }//GEN-LAST:event_jALOSCBActionPerformed

    private void j2TailedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j2TailedRadioButtonActionPerformed
         if(j2TailedRadioButton.isSelected())
         {
             j1TailedRadioButton.setSelected(false);
             alpha=alpha/2;
            j2tailed=true;
         }
    }//GEN-LAST:event_j2TailedRadioButtonActionPerformed
   
    private void jTestTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTestTypeActionPerformed
       
        Object jTestTypeObj =  jTestType.getSelectedItem();
       NullTestOption  = jTestTypeObj.toString();
        if( NullTestOption.equals(">="))
        {
           ATO="<";
           NullOption=">=";
        }
        
       if(NullTestOption.equals("<="))
       {
           ATO= ">";
           NullOption="<=";
       }
       
         if(NullTestOption.equals("=" ))
         {
           ATO="<>";      
           NullOption= "=";
         } 
      
    }//GEN-LAST:event_jTestTypeActionPerformed

    private void jPaired_tTestRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPaired_tTestRadioButActionPerformed
        if(jPaired_tTestRadioBut.isSelected())
          {
              paired_t=true;
               jKSTest.setSelected(false);
              jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jVarianceRadioBut.setSelected(false);
          jTwoSampleVarianceRadioBut.setSelected(false);
          }
    }//GEN-LAST:event_jPaired_tTestRadioButActionPerformed

    private void jVarianceRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVarianceRadioButActionPerformed
       if(jVarianceRadioBut.isSelected())
          {
              one_sample=true;
               jKSTest.setSelected(false);
              jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jVarianceRadioBut.setSelected(true);
          jTwoSampleVarianceRadioBut.setSelected(false);
          jPaired_tTestRadioBut.setSelected(false);
          }
    }//GEN-LAST:event_jVarianceRadioButActionPerformed

    private void jTwoSampleVarianceRadioButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTwoSampleVarianceRadioButActionPerformed
         if(jTwoSampleVarianceRadioBut.isSelected())
          {
              Ftest=true;
               jKSTest.setSelected(false);
              jChiSquared.setSelected(false);
        j2SampleTTestradiobut.setSelected(false);
         jGtestRadioBut.setSelected(false);
          jWilcoxanRadioBut.setSelected(false);
          jUTestRadioBut.setSelected(false);
          jVarianceRadioBut.setSelected(false);
          jPaired_tTestRadioBut.setSelected(false);
          }
          
    }//GEN-LAST:event_jTwoSampleVarianceRadioButActionPerformed

    private void jSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveActionPerformed

        if(FTestPane.isShowing() && Ftest  )
        {
            String  ftest="\r\nNull Hypothesis   %s"
            + "\r\nAlternative Hypothesis   %s"
            + "\r\n  df1   %s"
            + "\r\n df2 %s"
            + "\r\n a.l.o.s   %s"
            + "\r\n F  test value    %s"
            + "\r\nCritical value   %s"
            + "\r\n p-value   %s";

            try{
                File F_test;
                F_test =new File("Ftest.txt");
                if(!F_test.exists()){
                    F_test.createNewFile();
                }

                FileWriter  fw=  new FileWriter(F_test,true);
                BufferedWriter  bw =new BufferedWriter(fw);
                PrintWriter  pw = new PrintWriter(bw);
                pw.printf(ftest,H0,H1,df1,df2,alpha,Ftest,critical_value[7],pvalue[7]);
                pw.close();
            }catch(IOException  ioe){
                System.out.println("Error  occured:");
                ioe.printStackTrace();
            }

        }

        if(OneSampleVariancePane.isShowing()  &&  one_sample)
        {
            String  vartest="\r\nNull Hypothesis   %s"
            + "\r\nAlternative Hypothesis   %s"
            + "\r\n  N  %s"
            + "\r\n a.l.o.s   %s"
            + "\r\n 1- Sample Variance value    %s"
            + "\r\nCritical value   %s"
            + "\r\n p-value   %s";
            try{
                File var_test;
                var_test =new File("vartest.txt");
                if(!var_test.exists()){
                    var_test.createNewFile();
                }

                FileWriter  fw=  new FileWriter(var_test,true);
                BufferedWriter  bw =new BufferedWriter(fw);
                PrintWriter  pw = new PrintWriter(bw);
                pw.printf(vartest,H0,H1,n,alpha,_var,critical_value[4],pvalue[4]);
                pw.close();
            }catch(IOException  ioe){
                System.out.println("Error  occured:");
                ioe.printStackTrace();
            }
        }

        if(Paired_tTestPanel.isShowing()   &&  paired_t)
        {

            String  pairedt_test="\r\nNull Hypothesis   %s"
            + "\r\nAlternative Hypothesis   %s"
            + "\r\ndf   %s"
            + "\r\n a.l.o.s   %s"
            + "\r\n Paired- T value    %s"
            + "\r\nCritical value   %s"
            + "\r\n p-value   %s";
            try{
                File  pairedt_testFile;
                pairedt_testFile =new File("pairedT.txt");
                if(!pairedt_testFile.exists()){
                    pairedt_testFile.createNewFile();
                }
                FileWriter  fw=  new FileWriter(pairedt_testFile,true);
                BufferedWriter  bw =new BufferedWriter(fw);
                PrintWriter  pw = new PrintWriter(bw);
                pw.printf(pairedt_test,H0,H1,dof,alpha,paired_Tstat,critical_value[3],pvalue[3]);

                pw.close();
            }catch(IOException  ioe){
                System.out.println("Error  occured:");
                ioe.printStackTrace();
            }
        }

        if(TwoSampletTestPane.isShowing()   &&  TwoSampleT)
        {
            String  t2_test="\r\nNull Hypothesis   %s"
            + "\r\nAlternative Hypothesis   %s"
            + "\r\ndf   %s"
            + "\r\na.l.o.s   %s"
            + "\r\n2 Sample T value    %s"
            + "\r\nCritical value   %s"
            + "\r\n p-value   %s";

            try{
                File  t2_testFile;
                t2_testFile =new File("2Sample_test.txt");
                if(!t2_testFile.exists()){
                    t2_testFile.createNewFile();
                }
                FileWriter  fw=  new FileWriter(t2_testFile,true);
                BufferedWriter  bw =new BufferedWriter(fw);
                PrintWriter  pw = new PrintWriter(bw);
                pw.printf(t2_test,H0,H1,dof,alpha,  tStar ,critical_value[2],pvalue[2]);
                pw.close();
            }catch(IOException  ioe){
                System.out.println("Error  occured:");
                ioe.printStackTrace();
            }  }

            if(t_Test & tTestPane.isShowing() )
            {
                String  t_test="\r\nNull Hypothesis   %s"
                + "\r\nAlternative Hypothesis   %s"
                + "\r\ndf   %s"
                + "\r\na.l.o.s   %s"
                + "\r\nT value    %s"
                + "\r\nCritical value   %s"
                + "\r\n p-value   %s";

                try{
                    File  t_testFile;
                    t_testFile =new File("t_test.txt");
                    if(!t_testFile.exists()){
                        t_testFile.createNewFile();
                    }
                    FileWriter  fw=  new FileWriter(t_testFile,true);
                    BufferedWriter  bw =new BufferedWriter(fw);
                    PrintWriter  pw = new PrintWriter(bw);
                    pw.printf(t_test,H0,H1,df,alpha,ttest,critical_value[1],pvalue[1]);
                    pw.close();
                }catch(IOException  ioe){
                    System.out.println("Error  occured:");
                    ioe.printStackTrace();
                }

                if(ChiSquarePane.isShowing() &&  chi_squared)

                {
                    String  chitest="\r\nNull Hypothesis   %s"
                    + "\r\nAlternative Hypothesis   %s"
                    + "\r\ndf   %s"
                    + "\r\na.l.o.s   %s"
                    + "\r\nChi value    %f"
                    + "\r\nCritical value   %f"
                    + "\r\np-value   %f";

                    try{
                        File  ChitestFile;
                        ChitestFile =new File("chisquaredtest.txt");
                        if(!ChitestFile.exists()){
                            ChitestFile.createNewFile();
                        }
                        FileWriter  fw=  new FileWriter(ChitestFile,true);
                        BufferedWriter  bw =new BufferedWriter(fw);
                        PrintWriter  pw = new PrintWriter(bw);
                        pw.printf(chitest,H0,H1,df,alpha,chisquareVal,critical_value[0],pvalue[0]);
                        pw.close();
                    }catch(IOException  ioe){
                        System.out.println("Error  occured:");
                        ioe.printStackTrace();
                    }

                }

            }
    }//GEN-LAST:event_jSaveActionPerformed

    private void jClearResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClearResultsActionPerformed
        jH0EdFeild.setText("    ");
        jH1EditFeild.setText( "   ");
        col1.setText("   ");
        col2.setText("   ");
        clear_table();

        if(ChiSquarePane.isShowing() &&  chi_squared)
        {
            alphaDisplay.setText("   ");
            critical_value[0]=0.0;
            jChiValueDisplay.setText( "    ");
            jCriticalDisplay.setText("    ");

        }

        if(GtestPane.isShowing() &&  Gtest)
        {
            pvalue[8]=0.0;
            critical_value[8]=0.0;
            Gtestval.setText("  ");
            G_alpha.setText("   ");
            alpha=0.0;
        }

        if(tTestPane.isShowing()   &&  t_Test)
        {
            t_alos.setText("   ");
            T_test.setText("     ");
            t_pval.setText("      ");
            critical_value[1]=0.0;
            pvalue[1]=0.0;
            testsign.setText("    ");
            H1testsign.setText("    ");

        }
        if(TwoSampletTestPane.isShowing()   &&  TwoSampleT)
        {
            ALOS_tSample.setText("   ");
            twoSampleT.setText("   ");
            HO2Test.setText("   ");
            H12Test.setText("    ");
            jDOF2Display.setText("      ");
            pvalue[2]=0.0;
            critical_value[2]=0.0;
            TwoTest_pval.setText("    ");
        }

        if(Paired_tTestPanel.isShowing()   &&  paired_t)
        {

            pairedT_H0.setText("    ");
            pairedT_H1.setText("   ");
            pairedTValue.setText("    ");
            ALOSPairedt.setText("     ");
            pairedT_df.setText("     ");
            pvalue[3]=0.0;
            critical_value[3]=0.0;
            pairedT_pval.setText("      ");
        }

        if(FTestPane.isShowing() && Ftest  )
        {
            F_alpha.setText("    ");
            F_Test.setText("    ");
            F_crit.setText("     ");
            f_df1.setText("     ");
            F_df2.setText("    ");
            pvalue[7]=0.0;
            critical_value[7]=0.0;
            critical_value[6]=0.0;
            critical_value[5]=0.0;
        }
    }//GEN-LAST:event_jClearResultsActionPerformed

    private void NULLTextDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NULLTextDisplayActionPerformed

        NULLTextDisplay.setText(H0);
    }//GEN-LAST:event_NULLTextDisplayActionPerformed

    private void StatsTableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_StatsTableFocusGained
        String  header,header2,header0,h3,h4,h5;
        int  cols;

        col3.setEditable(false);
        col4.setEditable(false);
        col5.setEditable(false);

        Treatment.setEditable(false);

        StatsTable.setShowGrid(true);
        int rows=StatsTable.getRowCount();

        for(int i = 0; i<rows;++i)
        {StatsTable.setValueAt(i+1, i,0);

        }

        StatsTable.setGridColor(java.awt.Color.black);

        if( Ftest==true  || TwoSampleT==true||paired_t==true|| U_Test==true)
        {
            header=col1.getText();
            header2=col2.getText();
            StatsTable.getColumnModel().getColumn(2).setHeaderValue(header);
            StatsTable.getColumnModel().getColumn(3).setHeaderValue(header2);
        }

        if(chi_squared==true   ||  Gtest==true)
        {
            Treatment.setEditable(true);
            header0=Treatment.getText();
            header=col1.getText();
            header2=col2.getText();
            StatsTable.getColumnModel().getColumn(1).setHeaderValue(header0);
            StatsTable.getColumnModel().getColumn(2).setHeaderValue(header);
            StatsTable.getColumnModel().getColumn(3).setHeaderValue(header2);
        }

        if(t_Test==true ||  one_sample==true)
        {
            Treatment.setEditable(false);
            col2.setEditable(false);
            header=col1.getText();
            StatsTable.getColumnModel().getColumn(2).setHeaderValue(header);
            StatsTable.getColumnModel().getColumn(1).setHeaderValue(header);
        }

        StatsTable.repaint();

        setColumns();
    }//GEN-LAST:event_StatsTableFocusGained
      
    
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
    private javax.swing.JTextField ALOSPairedt;
    private java.awt.TextField ALOS_tSample;
    private java.awt.TextField BoleteRecNo;
    private javax.swing.JPanel ChiSquarePane;
    private javax.swing.JTextField DOFDisplay;
    private javax.swing.JPanel FTestPane;
    private javax.swing.JTextField F_H0;
    private javax.swing.JTextField F_H0_sign;
    private javax.swing.JTextField F_H1;
    private javax.swing.JTextField F_H1_sign;
    private javax.swing.JTextField F_Test;
    private javax.swing.JTextField F_alpha;
    private javax.swing.JTextField F_crit;
    private javax.swing.JLabel F_criteria;
    private javax.swing.JTextField F_df2;
    private javax.swing.JTextField F_pvalue;
    private javax.swing.JLabel F_result;
    private javax.swing.JLabel F_test_label;
    private javax.swing.JLabel F_test_label1;
    private javax.swing.JLabel F_test_label3;
    private javax.swing.JTextField GAlt;
    private javax.swing.JTextField GHypo;
    private javax.swing.JTextField G_alpha;
    private javax.swing.JTextField G_crit;
    private javax.swing.JTextField G_dof;
    private javax.swing.JLabel Gpval;
    private javax.swing.JPanel GtestPane;
    private javax.swing.JTextField Gtestval;
    private java.awt.TextField H12Test;
    private javax.swing.JTextField H1Displayfeild;
    private javax.swing.JTextField H1testsign;
    private java.awt.TextField HO2Test;
    private javax.swing.JPanel KendalWTestPane;
    private javax.swing.JLabel Kendal_cv;
    private javax.swing.JLabel Kendal_descision;
    private javax.swing.JPanel ManWhitneyPane;
    public javax.swing.JTabbedPane MycologyMultiplex;
    private javax.swing.JTextField NULLTextDisplay;
    private javax.swing.JTextField NullOpt;
    private javax.swing.JPanel OneSampleVariancePane;
    private javax.swing.JPanel Paired_tTestPanel;
    private java.awt.TextField PoreLayer;
    private javax.swing.JTable StatsTable;
    private javax.swing.JTabbedPane StatsWindowPane;
    private javax.swing.JTextField T_test;
    private javax.swing.JTextField Treatment;
    private javax.swing.JPanel TwoSampletTestPane;
    private java.awt.TextField TwoTest_pval;
    private java.awt.TextField Two_tCritical;
    private java.awt.TextField W_coeff;
    private javax.swing.JPanel WilcoxanPane;
    private javax.swing.JTextField alphaDisplay;
    private javax.swing.JLabel chi_criteria;
    private javax.swing.JTextField col1;
    private javax.swing.JTextField col2;
    private javax.swing.JTextField col3;
    private javax.swing.JTextField col4;
    private javax.swing.JTextField col5;
    private javax.swing.JLabel criteria;
    private javax.swing.JTextField date_field;
    private javax.swing.JTextField date_field2;
    private javax.swing.JTextField date_field3;
    private javax.swing.JTextField date_field4;
    private javax.swing.JTextField f_df1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel gdf;
    private javax.swing.JTextField gpval;
    private javax.swing.JRadioButton j1TailedRadioButton;
    private javax.swing.JRadioButton j2SampleTTestradiobut;
    private javax.swing.JRadioButton j2TailedRadioButton;
    private javax.swing.JComboBox<String> jALOSCB;
    private javax.swing.JButton jAddRecord;
    private javax.swing.JButton jAddRecord2db;
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
    public javax.swing.JButton jBrowseButton;
    private javax.swing.JRadioButton jChiSquared;
    private javax.swing.JTextField jChiValueDisplay;
    private javax.swing.JButton jClear;
    private javax.swing.JButton jClearResults;
    private javax.swing.JTextArea jCollectorsedField;
    private javax.swing.JPanel jColorPanel;
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
    private javax.swing.JTextField jCriticalDisplay;
    private javax.swing.JTextField jDOF2Display;
    private javax.swing.JButton jDeleteRecButton;
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
    private javax.swing.JComboBox<String> jGreenCB;
    private javax.swing.JRadioButton jGtestRadioBut;
    private javax.swing.JTextField jH0EdFeild;
    private javax.swing.JTextField jH1EditFeild;
    private javax.swing.JRadioButton jKSTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
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
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jMGBMarginShapelbl;
    private javax.swing.JComboBox<String> jMRCB;
    private javax.swing.JRadioButton jPaired_tTestRadioBut;
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
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jPerfromTestBut;
    private javax.swing.JTextField jPhotoNoEdFeild;
    private javax.swing.JButton jSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jStalkCharSurfOrnCB;
    private javax.swing.JComboBox<String> jTestType;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JRadioButton jTwoSampleVarianceRadioBut;
    private javax.swing.JRadioButton jUTestRadioBut;
    private javax.swing.JRadioButton jVarianceRadioBut;
    private javax.swing.JRadioButton jWilcoxanRadioBut;
    public javax.swing.JButton jWrite;
    private javax.swing.JRadioButton jtTestRadioBut;
    private javax.swing.JLabel juGBVeillbl;
    private javax.swing.JLabel kcv;
    private java.awt.TextField kendal_cv;
    private javax.swing.JTextField kendal_pval;
    private javax.swing.JLabel kendal_result;
    private javax.swing.JLabel kiCriteria;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private javax.swing.JTextField pValueDisplay;
    private javax.swing.JLabel pairedTCrit;
    private javax.swing.JTextField pairedTValue;
    private javax.swing.JTextField pairedT_CV;
    private javax.swing.JTextField pairedT_H0;
    private javax.swing.JTextField pairedT_H1;
    private javax.swing.JTextField pairedT_alt;
    private javax.swing.JTextField pairedT_df;
    private javax.swing.JTextField pairedT_pval;
    private javax.swing.JLabel pairedTresult;
    private javax.swing.JLabel resultDisplay;
    private java.awt.TextField score;
    private javax.swing.JTextField size;
    private javax.swing.JLabel solution;
    private javax.swing.JLabel statement;
    private javax.swing.JLabel tCriteria;
    private javax.swing.JLabel tCritieria;
    private javax.swing.JLabel tCritieria1;
    private javax.swing.JLabel tResult;
    private javax.swing.JTextField tTestH0;
    private javax.swing.JTextField tTestH1;
    private javax.swing.JPanel tTestPane;
    private javax.swing.JTextField t_Critical;
    private javax.swing.JTextField t_alos;
    private javax.swing.JTextField t_pval;
    private javax.swing.JTextField tdof;
    private java.awt.TextField testOpt2;
    private java.awt.TextField testOption;
    private javax.swing.JTextField testsign;
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    private javax.swing.JLabel twoSampleCrit;
    private java.awt.TextField twoSampleT;
    private javax.swing.JLabel varCrit;
    private javax.swing.JTextField var_H0;
    private javax.swing.JTextField var_H1;
    private javax.swing.JTextField var_alpha;
    private javax.swing.JLabel var_alpha_lbl;
    private javax.swing.JTextField var_alt;
    private javax.swing.JTextField var_cv;
    private javax.swing.JTextField var_opt1;
    private javax.swing.JTextField var_p;
    private javax.swing.JTextField var_ts;
    private java.awt.TextField w_alpha;
    private javax.swing.JLabel w_label;
    // End of variables declaration//GEN-END:variables
}
