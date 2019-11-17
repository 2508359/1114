package NextDate;

public class NextDate {
	int year;
	public boolean isleap() {
		boolean ntrue;
		if((this.year%4==0&&this.year%100!=0)||(this.year%400==0)) {
	    		 return true;
	     }else
	    	 return false;
	}

}
