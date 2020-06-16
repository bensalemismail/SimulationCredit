package com.bensalem.ws;

public class Opperations {
	
	public  double  annuite(double C, double n, double t) {
	   	 double tm = Math.pow(1 + t,(double)1/12) - 1;
	   	 double a = (Math.pow(1+tm, n)* tm * C)/(Math.pow(1+tm, n) - 1 );
	   	 return a ;  
	   	 
	    }
	    
	    
	    public double capital(double a , double n, double t) {
	   	 double tm = Math.pow(1 + t,(double)1/12) - 1; 
	   	 double C = ( a * (Math.pow(1+tm, n) - 1 ) )/(Math.pow(1+tm, n)* tm );
	   	 return C ;
	    }
	    
	    
	    public int duree(double C , double a, double t) {
	   	 double tm = Math.pow(1 + t,(double)1/12) - 1; 
	   	 double n = Math.log(a/(a- tm*C)) / Math.log(1+tm);
	   	      
	   	 return (int) Math.round(n);                      
	    }

}
