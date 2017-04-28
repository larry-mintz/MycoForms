/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows 7
 */
public class Stalk {
    public  String  Length;
    public String  Annulus;
    public String Annulus_Color;
    public  String  WidthatWidestPt;
    public  String  WidthatBase;
    public String Surface_Orn;
    public String Surface_Texture;
    public  String Ornamentation;
    
    
    public Stalk(String  Len,String An,String AnC,String WatWPt,String WidatB,String SO,String ST,String Orn)
    {
    this.Annulus=An;
    this.Annulus_Color=AnC;
   this.WidthatWidestPt=WatWPt;
   this.WidthatBase=WidatB;
   this.Surface_Orn=SO;
   this.Ornamentation=Orn;
   this.Length=Len;
   this.Surface_Texture=ST;
    }
      public  Stalk()
      {}
}
