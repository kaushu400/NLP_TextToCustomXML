/**
 * 
 */
package com.kk.nlp.dataclasses;

import java.util.ArrayList;

import com.kk.nlp.Interfaces.IXML_Item;

/**
 * @author Kaushal
 *
 */
public class Paragraph implements IXML_Item {

	public ArrayList<Sentence> sentence = new ArrayList<Sentence>();
	/* (non-Javadoc)
	 * @see com.kk.nlp.Interfaces.IXML_Item#getXMLTagString()
	 */
	public String getXMLTagString() {
		// TODO Auto-generated method stub
		return null;
	}

}
