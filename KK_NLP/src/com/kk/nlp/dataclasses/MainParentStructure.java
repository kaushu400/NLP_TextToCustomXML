/**
 * 
 */
package com.kk.nlp.dataclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kaushal Kathwadia
 *
 */
public class MainParentStructure {

	public static ArrayList<Paragraph> paragraphs = new ArrayList<Paragraph>();
	
	/**
	 * @param String sentence - sentence to be broken down
	 * @return String - XML representation of the the Sentence parts (words, punctuations)
	 */
	public static String parseWordsAndPuncatuations(String sentence){
		Sentence sen = new Sentence();
		NamedEntity namedEntity = new NamedEntity();
		namedEntity.init();
				int beginIndex2 = 0;
				Matcher matcher2 = Pattern.compile("\\W").matcher(sentence);
				while (matcher2.find()) {
					if (beginIndex2 != matcher2.start()) {
						String word = sentence.substring(beginIndex2, matcher2.start());
						System.out.println(word +" - "+ namedEntity.IsNamedEntity(word));
						
						if(namedEntity.IsNamedEntity(word)){
							sen.addSentencePart(new NamedEntity(word));
						} else {
							sen.addSentencePart(new Word(word));
						}
						beginIndex2 = matcher2.end();
					} else
						beginIndex2++;
					sen.addSentencePart(new Punctuation(matcher2.group()));
				}
				return sen.getXMLTagString();
	}                                          
	
	
	
	public static void main(String[] args){
		StringBuffer sbFullXML = new StringBuffer("<xml>");
		Sentence sentence = new Sentence();
		
		File file = new File("src/nlp_data/nlp_data.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Input data file not found ");
			System.exit(1);
			e.printStackTrace();
		}
		StringBuffer sbWholeFile = new StringBuffer();
		while(sc.hasNext()){
			String temp = sc.nextLine();
			sbWholeFile.append(temp);
		}
		sc.close();
		
		String wholeFile = sbWholeFile.toString();
	
		String SENTENCE_BREAKER = "(\\.|\\?|\\!|\\.\"|\\.'|\\?\"|\\?'|\\!\"|\\!')\\s+[A-Z|\"|\']";
		Matcher matcher = Pattern.compile(SENTENCE_BREAKER).matcher(wholeFile);
		int beginIndex = 0;
		while(matcher.find()){
			sentence.setEachSentences(wholeFile.substring(beginIndex, matcher.end()-1));
			beginIndex = matcher.end()-1;
		}
		//fix for the last sentence
		sentence.setEachSentences(wholeFile.substring(beginIndex));

		for(int i=0; i < sentence.getEachSentences().size(); i++){
			//System.out.println("SENTENCE " + i);
			sbFullXML.append("<sentence>");
			String wordsAndPunctuations =  parseWordsAndPuncatuations(sentence.getEachSentences().get(i));
			sbFullXML.append(wordsAndPunctuations);
			sbFullXML.append("</sentence>");
			}
		sbFullXML.append("</xml>");
		System.out.println(sbFullXML.toString());
		try {
			FileWriter fw  = new FileWriter(new File("src/output/fullXML.xml"));
			fw.write(sbFullXML.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
