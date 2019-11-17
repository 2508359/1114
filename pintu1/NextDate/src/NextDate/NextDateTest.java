package NextDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


	@RunWith(Parameterized.class)
		public class NextDateTest{
			NextDate testObject;
			private int inData;
			private boolean exData;	
		

    @Parameters
    public static Collection data() {
    	return Arrays.asList(new Object[][]{
    		{2000,true},
    		{1800,false},
    		{2008,true},
    		{2000,false}
    	});
    }
    
    public NextDateTest(int inData,boolean exData) {
    	this.inData=inData;
    	this.exData=exData;	
    }
	

    @Before
    public void setUp()throws Exception {
    	testObject=new NextDate();
    	
    }
    @After
    public void tearDown() throws Exception{
    	
    }


    @Test
   public void testIsleap() {

    	testObject.year=inData;
    	
    	assertEquals(exData,testObject.isleap());
    }
   }


