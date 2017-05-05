/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class Branch_Char {
 private  String  Rhizo;
 private  String Branch_Constituency;
 private  String Stalk_form;
 private  String  Flesh_Constituency;
 private  String  MelzersReagent;
 private String  GreenReactant;
 
 public  Branch_Char(String R,String B_C,String S_f, String F_C,String  MR,String GR)
 {
     setRhizo(R);
     setBranch(B_C);
     setStalkForm(S_f);
     setFlesh(F_C);
     setMelzersR(MR);
     setGreenR(GR);
 }
  public void setRhizo(String R)
    {
     Rhizo=R;
    }
 public void setGreenR(String GR)
    {
    GreenReactant=GR;
    }
 public void setMelzersR(String MR)
    {
    MelzersReagent=MR;
    }
 public void setBranch(String B_C)
    {
    Branch_Constituency=B_C;
    }
 
public void setStalkForm(String S_f)
    {
    Stalk_form=S_f;
    }
 public void setFlesh(String F_C)
    {
    Flesh_Constituency=F_C;
    }
 
 public String getRhizo()
    {
    return Rhizo;
    }
 public String getBranch()
    {
    return Branch_Constituency;
    }
 
public String  getStalkForm()
    {
    return Stalk_form;
    }
 public String  getFlesh()
    {
    return Flesh_Constituency;
    }
 
 public String  getMelzersR()
    {
    return MelzersReagent;
    }
 public String  getGreenReactant()
    {
    return  GreenReactant;
    }
 
 public  Branch_Char(Branch_Char  bc)
    {   
    this(bc.getBranch(),bc.getRhizo(),bc.getStalkForm(),bc.getFlesh(),bc.getGreenReactant(),bc.getMelzersR());
    }
}
