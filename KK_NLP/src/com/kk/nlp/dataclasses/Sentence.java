/**
 * 
 */
package com.kk.nlp.dataclasses;

import java.util.ArrayList;
import java.util.Iterator;

import com.kk.nlp.Interfaces.IXML_Item;

/**
 * @author Kaushal
 *
 */
public class Sentence extends Paragraph implements IXML_Item {

	private ArrayList<String> eachSentences = new ArrayList<String>();
	
	/**
	 * @return the eachSentences
	 */
	public ArrayList<String> getEachSentences() {
		return eachSentences;
	}

	/**
	 * @param eachSentences the eachSentences to set
	 */
	public void setEachSentences(String sentence) {
		this.eachSentences.add(sentence);
	}

	private ArrayList<SentencePartsWP> sentenceParts = new ArrayList<SentencePartsWP>();
	
	public void addSentencePart(SentencePartsWP sentencePartsWP){
		sentenceParts.add(sentencePartsWP);
	}	
	
	@Override
	public String getXMLTagString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for(SentencePartsWP sp : sentenceParts){
			if(sp instanceof Word){
				sb.append("<word>" + sp.toString() + "</word>");
			} else {
				sb.append("<punctuation>" + sp.toString() + "</punctuation>");
			}
		}
		return sb.toString();
	}

	
}
