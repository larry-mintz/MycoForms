/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */

/**
 *
 * @author Windows 7
 */
public class Stat {
   public   String critical_value ;
 public     String pvalue ;
       
 
 public Stat( String cv,  String pv)
 {
     
 this.critical_value=cv;
 this.pvalue=pv;
 }
 
 public Stat(Stat  s)
 {
     this(s.critical_value,s.pvalue);
 }
 
 
       
}
