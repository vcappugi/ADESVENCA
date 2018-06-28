package org.adempiere.util.EncryptRLMH;

public class CodeEncrypt {

	private static String value = "789eufGzgH5hI)0JjKLMYmNAnoPpQ23qRrSa*BCwcDdiEsTltUVkvxWXyZ(1F4O#b$%&!+/,.-6";
	//public static String valueby =code();
	/*public static String valueby = "05505605710111710207112210307205310407304104807410607507607708910"
			+ "90780651101110801120810500511130821140830970420660671190990681001050691150841081"
			+ "16085086107118120087088121090040049070052079035098036037038033043047044046045054";
	*/
	public static String valueby(){
    	char chain[] = value.toCharArray();
    	String chainAt ="";
    	String valueby = "";
    	for(int i = 0; i < chain.length; i++){
    		chainAt =""+ Character.toString(chain[i]).codePointAt(0);
    		if(chainAt.length() == 1){
    			chainAt= "00" + chainAt;
    		}
    		if(chainAt.length() == 2){
    			chainAt= "0" + chainAt;
    		}
    		
    		valueby = valueby + chainAt;
    	}
    	return valueby;
	}
	
}
