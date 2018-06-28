package org.adempiere.appweb.util.EncryptRLMH;


public class Encrypt {
	
	
	private String value = CodeEncrypt.valueby();
	
    public String getEncrypt(String text)
    {
    	char chain[] = text.toCharArray();
    	String chainAt ="";
    	for(int i = 0; i < chain.length; i++){
    		chainAt = chainAt + asiiE(Character.toString(chain[i]).codePointAt(0));
    	}

    	return chainAt;//String.valueOf(chain);
    }
    
    public String getDecrypt(String text)
    {
    	char chain[] = text.toCharArray();
    	String chainAt ="";
    	boolean appl = false;
    	for(int i = 0; i < chain.length; i++){
    		if(Character.toString(chain[i]).equals("^")){
    			appl= true;
    		}else{
    			chainAt = chainAt + asiiD(chain[i],appl);
    			appl= false;
    		}	
    	}

    	return chainAt;//String.valueOf(chain);
    }
    
    public String asiiD(char text, boolean appl){
    	
    	String low = "";
    	int code = getChainCode(text);
    	
    	if(code < 0){
    		low = Character.toString(text);
    	}else{
    	
	    	if (appl){
	    		code = (code - 29) + 38;
	    	}else{
	    		code = (code - 7);
	    		if(code >= 0 && code <= 9){
	    			code = code + 48;
	    		}else if(code >= 10 && code <= 35){
	    			code = code + 87;
	    		}else if(code >= 36 && code <= 61){
	    			code = code + 29;
	    		}else if(code >= 61 && code <= 74){
	    			code = (code - 29);
	    		}
	    	}
	    	low = Character.toString((char)code);
    	}

    	return low;
    }
    
    public String asiiE(int code){
    	
    	String low = "";
    	
    	if(code >= 33 && code <= 47){
    		code = (code + 29) + 7;
    		if(code > 74){
    			code = code - 74;
    			low = "^" + getChainChar(code + 29);
    		}else{
    			low = getChainChar(code);
    		}
    	}else if((code >= 48 && code <= 57)){
    		code = (code - 48) + 7;
    		low = getChainChar(code);
    	}else if(code >= 65 && code <= 90){
    		code = (code - 29) + 7;
    		low = getChainChar(code);
    	}else if(code >= 97 && code <= 122){
    		code = (code - 87) + 7;
    		low = getChainChar(code);    		
    	}else{
    		low =Character.toString(((char)code));
    	}
    	 
    	return low;
    }

    
    public String getChainChar(int post){
    	int count = 0;
    	String charAt = "";
    	
    	for(int i = 0; i < (value.length()/3); i++){
    		if (i == post){
    			charAt = Character.toString((char)Integer.parseInt(value.substring(count, ((i+1)*3))));
    			break;
    		}
    		count = count + 3;
    	}
    	return charAt;
    }
    
    public int getChainCode(char post){
    	int count = 0;
    	int code = -1;
    	String charAt = "";
    	
    	for(int i = 0; i < (value.length()/3); i++){
     		charAt = Character.toString((char)Integer.parseInt(value.substring(count, ((i+1)*3))));
    		if(charAt.equals(Character.toString(post))){
        			code = i;
        			break;
        	}
    		count = count + 3;
    	}
    	return code;
    }
    
    /*	private String valueby = "05505605710111710207112210307205310407304104807410607507607708910"
			+ "90780651101110801120810500511130821140830970420660671190990681001050691150841081"
			+ "16085086107118120087088121090040049070052079035098036037038033043047044046045054";
	*/
    
}
