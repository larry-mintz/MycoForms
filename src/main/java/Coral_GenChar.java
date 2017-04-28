/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
 public  class Coral_GenChar {
   public  String Entire_height;
    public String  Crown_diam;
    public  String Stem_base_width;
    public String Stem_width;
    public  String Odor;
    private  String Taste;
    
  public Coral_GenChar(String   E,String C, String  Sbase, String SW,String O, String T)
  {
   this.Entire_height=E;
   this.Crown_diam=C;
   this.Stem_base_width=Sbase;
   this.Stem_width=SW;
   this.Odor=O;
   setTaste(T);
  }
  public void setTaste(String T)
    {
    Taste=T;
    }
  public String getTaste()
    {
    return Taste;
    }
  
  public Coral_GenChar(Coral_GenChar  c_gc)
  {
  this(c_gc.Entire_height,c_gc.Crown_diam,c_gc.Stem_base_width,c_gc.Stem_width,c_gc.Odor,c_gc.getTaste()) ;       
  }
 }

