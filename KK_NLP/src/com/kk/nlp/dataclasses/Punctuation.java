/**
 * 
 */
package com.kk.nlp.dataclasses;

import com.kk.nlp.Interfaces.IXML_Item;

/**
 * @author Kaushal
 *
 */
public class Punctuation extends SentencePartsWP implements IXML_Item {

	private String punctuation;
	
	public Punctuation(String punc){
		this.setPunctuation(punc);
	}
	
	public String getXMLTagString() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return the punctuation
	 */
	public String getPunctuation() {
		return punctuation;
	}
	/**
	 * @param punctuation - the punctuation to set
	 */
	public void setPunctuation(String punctuation) {
		this.punctuation = punctuation;
	}
	
	/**
	 * Overriding toString method to get the value (punctuation)
	 */
	@Override
	public String toString(){
		return this.punctuation;
	}

}
