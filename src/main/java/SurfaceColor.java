/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class SurfaceColor {
   public String  Tips;
   public String  Stem;
   public  String Branches;
   public String  Bruising;
   private  String  BranchJunction;
   
 public SurfaceColor(String T,String S,String B,String Br,String BJ)  
 {
 this.Tips=T;
 this.Stem=S;
 this.Bruising=B;
 this.Branches=Br;
 setBJ(BJ);
 }
 
 public void setBJ(String BJ)
    {
    BranchJunction=BJ;
    }
 
 public String  getBJ()
    {
    return BranchJunction;
    }
 
 public  SurfaceColor(SurfaceColor  sc)
    {   
    this(sc.Tips,sc.Branches,sc.Stem,sc.Bruising,sc.getBJ());
    }
 }
   

