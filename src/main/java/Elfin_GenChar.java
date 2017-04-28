/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class Elfin_GenChar {
    public String Odor;
    public  String EntireHeight;
    public String  CapWidth;
     public String StemLength;
    public  String FleshColorandBruising ;
    public String  HymeniumColor;
     public String AbhymeniumColor;
    public  String CapFleshThickness;
    private String Shape;
    private  String SporoCap ;
    private String Taste;
    private String AbhymeniumTexture;
   
   
   
    public Elfin_GenChar(String O,String EH,String CW,String SL,String FCandB,String H,String  AbH,String CFT,String SC,String S,String T,String AT)
    {   setAbhymeniumTexture(AT);
        setShape(S);
        setSporoCap(SC);
        setTaste(T);
        this.Odor=O;
        this.EntireHeight=EH;
        this.CapWidth=CW;
        this.StemLength=SL;
        this.FleshColorandBruising=FCandB;
        this.HymeniumColor=H;
        this.AbhymeniumColor=AbH;
        this.CapFleshThickness=CFT;
       
    }
    
    public void setShape(String S)
    {
    Shape=S;
    }
    
    public void setSporoCap(String SC)
    {
    SporoCap=SC;
    }
    
    public void setTaste(String T)
    {
    Taste=T;
    }
    
    
    public void setAbhymeniumTexture(String AT)
    {
    AbhymeniumTexture=AT;
    }
    
    
     public String getTaste()
    {
    return Taste;
    }
    
    
    public String getAbhymeniumTexture()
    {
    return AbhymeniumTexture;
    }
    
    public String getShape()
    {
    return Shape;
    }
    
    public String getSporoCap()
    {
    return SporoCap;
    }
    
    
  public Elfin_GenChar(Elfin_GenChar egc) 
  {this(egc.AbhymeniumColor,egc.getAbhymeniumTexture(),egc.CapFleshThickness,
  egc.EntireHeight,egc.CapWidth,egc.FleshColorandBruising,egc.HymeniumColor,
  egc.Odor,egc.getShape(),egc.getSporoCap(),egc.StemLength,egc.getTaste());}
}



