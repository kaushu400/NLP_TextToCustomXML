package com.kk.nlp.dataclasses;

import com.kk.nlp.Interfaces.IXML_Item;

public class Word extends SentencePartsWP  implements IXML_Item {

	private String word;
	
	public Word(String word){
		this.setWord(word);
	}
	
	public String getXMLTagString() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * Overriding toString method to get the value (word)
	 */
	@Override
	public String toString(){
		return this.word;
	}

}
