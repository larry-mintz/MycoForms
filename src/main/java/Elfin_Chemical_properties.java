/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class Elfin_Chemical_properties {
    
    private   String  ASCI ;
    private String Acetocarmine_Test;
    private String  Spore_Ornamentation_Staining;      
    
    public Elfin_Chemical_properties(String A,String  A_T, String S_O_S)
    {   setASCI(A);
         setA_T(A_T);
         setS_O_S(S_O_S);
    }
    
    public void setASCI(String A)
    {
    ASCI=A;
    }
    
     public void setA_T(String A_T)
     {
     Acetocarmine_Test=A_T;
     }
             
       public void setS_O_S(String S_O_S)
       {
        Spore_Ornamentation_Staining=S_O_S;
               
       }
       
     public String getS_O_S()
       {
        return Spore_Ornamentation_Staining;
               
       }
    
     public String getA_T()
     {
    return  Acetocarmine_Test;
     } 
     
     public   String getASCI()
     {return ASCI;}
    
    public Elfin_Chemical_properties(Elfin_Chemical_properties  ecp)
    {   
        this(ecp.getASCI(),ecp.getA_T(),ecp.getS_O_S());
    }
    
    
    
}
