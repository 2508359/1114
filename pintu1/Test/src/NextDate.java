
public class NextDate {
     private int year;
	 public boolean isleap() {
     boolean ntrue;
		if((this.year%4==0&&this.year%100!=0)||(this.year%400==0))
    		 return ntrue;
     }
        else {
    	 return false;
     }
}
