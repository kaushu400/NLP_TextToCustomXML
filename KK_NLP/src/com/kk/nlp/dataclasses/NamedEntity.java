/**
 * 
 */
package com.kk.nlp.dataclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Kaushal
 *
 */
public class NamedEntity extends SentencePartsWP {
	
	private String namedEntityFilePath = "src/nlp_data/NER.txt";
	private ArrayList<String> namedEntityList = new ArrayList<String>();
	private String namedEntity;
	
	/**
	 * Default constructor
	 */
	public NamedEntity(){
		
	}
	/**
	 * Overloaded constructor 
	 * @param namedEntity - String namedEntity
	 */
	public NamedEntity(String namedEntity){
		this.namedEntity = namedEntity;
	}
	
	/**
	 * @return the namedEntity
	 */
	public String getNamedEntity() {
		return namedEntity;
	}

	/**
	 * @param namedEntity the namedEntity to set
	 */
	public void setNamedEntity(String namedEntity) {
		this.namedEntity = namedEntity;
	}
	
	/**
	 * Overriding toString method to get the value (word)
	 */
	@Override
	public String toString(){
		return this.namedEntity;
	}

	/**
	 * @param word - word to be tested if it's named entity
	 * @return boolean - true if the input is a named entity else false
	 */
	public boolean IsNamedEntity(String word) {
		return namedEntityList.contains(word);
	}
	
	/**
	 * This method will call the readNamedEntityToArrayList method and fill the array
	 */
		
	public void init(){
		readNamedEntityToArrayList();
	}
	
	
	/**
	 * Read the NamedEntity file here and fill the array list (namedEntity)
	 */
	private void readNamedEntityToArrayList(){
		File file = new File(namedEntityFilePath);
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				//System.out.println(sc.nextLine());
				namedEntityList.add(sc.next());
			}
			//System.out.println(namedEntityList);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Named Entity input file not found ");
			System.exit(1);
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Just for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		NamedEntity ne = new NamedEntity("test");
		ne.readNamedEntityToArrayList();
		System.out.println(ne.namedEntityList);
		System.out.println(ne.IsNamedEntity("Franz Ferdinand"));
		System.out.println(ne.IsNamedEntity("Test"));
	}
	

	
}
