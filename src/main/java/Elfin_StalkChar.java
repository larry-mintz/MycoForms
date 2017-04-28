/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class Elfin_StalkChar {
    public  String  WidthatWidestPt;
    public  String  WidthatBase;
    public  String  Length;
    public  String  Stalk;
    public String Shape;
     public String StemFleshText;
      public String Surface_Color;
       public String Flesh_Color;
       public String  Surface;
       
    public Elfin_StalkChar(String WWpt,String WB,String len,String Stalk,String S ,String SC,String FC,String SFT,String  Surf) 
    {
    this.Length=len;
    this.WidthatBase=WB;
    this.WidthatWidestPt=WWpt;
    this.Flesh_Color=FC;
    this.Surface_Color=SC;
    setShape(S);
    setStemFleshText(SFT);
    setStalk(Stalk);
    setSurface(Surf);
    }
    public void setSurface(String Surf)
    {
    Surface=Surf;
    }
    
    public void setShape(String S)
    {
    Shape=S;
    }
    
    public void setStalk(String stalk)
    {
    Stalk=stalk;
    }
    
    public void setStemFleshText(String SFT)
    {
    StemFleshText=SFT;
   
    }
    
     public String getShape()
    {
    return Shape;
    }
    
      public String getStemFleshText()
    {
    return StemFleshText;
   
    }
      
    public String getStalk()
    {
    return Stalk;
   
    } 
    
    
     public String getSurface()
    {
    return Surface;
    }
     
}
