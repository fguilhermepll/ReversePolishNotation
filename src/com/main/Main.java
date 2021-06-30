package com.main;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	/*
	 * PRIORIDADES
	 * '(' = prioridade 1
	 * '+' ou '-' prioridade = 2
	 * '*' ou '/' prioridade = 3
	 */
	
	
	public static void main(String [] args) {
		
		Stack<Character> stack = new Stack<Character>();
		
		String expr = "";
		
		Scanner scan = new Scanner(System.in);
		expr = scan.next();
		scan.close();
		
		int i = 0;
		while(i < expr.length()) {
			if(expr.charAt(i) == '+' || expr.charAt(i) == '-' || expr.charAt(i) == '/' || expr.charAt(i) == '*') {
				while(!stack.empty() && checkPriority(expr.charAt(i), stack.peek()) == 0) {
					char pop = stack.pop();
					System.out.print(pop);
				}
				stack.push(expr.charAt(i));
			}
			
			if(expr.charAt(i) == '(') {
				stack.push(expr.charAt(i));
			}else if(!isSymbol(expr.charAt(i))) {
				System.out.print(expr.charAt(i));
			}else if(expr.charAt(i) == ')') {
				int find = 0;
				while(expr.charAt(find) != '(') {
					char pop = stack.pop();
					if(pop != '(') {
						System.out.print(pop);
					}
					find++;
				}
			}
			
			i++;
		}
		while(!stack.empty()) {
			char pop = stack.pop();
			System.out.print(pop);
		}
	}
	
	private static int checkPriority(char ch, char top) {
		int priorityTop = 0, priorityCh = 0;
		
		switch(top) {
			case '(':
				priorityTop = 1;
				break;
			case ')':
				priorityTop = 1;
				break;
			case '+':
				priorityTop = 2;
				break;
			case '-':
				priorityTop = 2;
				break;
			case '*':
				priorityTop = 3;
				break;
			case '/':
				priorityTop = 3;
				break;
		}
		
		switch(ch) {
			case '(':
				priorityCh = 1;
				break;
			case ')':
				priorityCh = 1;
				break;
			case '+':
				priorityCh = 2;
				break;
			case '-':
				priorityCh = 2;
				break;
			case '*':
				priorityCh = 3;
				break;
			case '/':
				priorityCh = 3;
				break;
		}
		
		if(priorityTop > priorityCh || priorityTop == priorityCh) {
			return 0;
		}else {
			return 1;
		}
				
	}
	
	public static boolean isSymbol(char ch) {
		if(ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '(' || ch == ')') {
			return true;
		}else {
			return false;
		}
	}
	
}
