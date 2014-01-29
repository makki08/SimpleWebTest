package org.feueac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Servlet implementation class CreateMatrix
 */
@WebServlet("/CreateMatrixPath")
public class CreateMatrix extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] docs = {"Shipment of gold damaged in a fire", 
				"Delivery of silver arrived in a silver truck", 
				"Shipment of gold arrived in a truck"};
		
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<ArrayList<String>> wordsInDocs = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < docs.length; i++) {
			String[] words = docs[i].replaceAll("[^a-zA-Z]", " ").toLowerCase().split("[ ]+");
			ArrayList<String> wordsInDoc = new ArrayList<String>();
			for (String s : words) {
				wordsInDoc.add(s);
				if (wordList.contains(s)) {
					continue;
				} else {
					wordList.add(s);
				}
			}
			wordsInDocs.add(wordsInDoc);
		}
		
		Collections.sort(wordList);
		
		for (String s : wordList) {
			System.out.println(s);
		}
		
		System.out.println("*******************");
		
		int table[][] = new int[wordList.size()][docs.length];
		
		for (int i = 0; i < wordsInDocs.size(); i++) {
			int size = wordsInDocs.get(i).size();
			String words[] = new String[size];
			wordsInDocs.get(i).toArray(words);
			for (String s : words) {
				if (wordList.contains(s.toString())) {
					int index = wordList.indexOf(s.toString());
					table[index][i] += 1;  
				}
			}
			System.out.println("*******************");
		}
		
		for (int i = 0; i < wordList.size(); i++) {
			for (int j = 0; j < docs.length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

}
