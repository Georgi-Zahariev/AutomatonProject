import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Arrow {
	private int begin;
	private int end;
	private char name;

	public Arrow(int a, int b, char c) {
		begin = a;
		end = b;
		name = c;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return begin + " - " + end + " - " + name;
	}

}

class Auto {
	private int N;
	private int K;
	private ArrayList<Integer> arr = new ArrayList<Integer>(K);
	private int M;
	private ArrayList<Arrow> a = new ArrayList<Arrow>(M);

	public Auto(Scanner inp) {

		N = inp.nextInt();
    	K = inp.nextInt();
		for (int i = 0; i < K; i++) {
			int newEl = inp.nextInt();
			arr.add(i, newEl);
		}
		
	M = inp.nextInt();

		for (int j = 0; j < M; j++) {
			int a1 = inp.nextInt();
			int b1 = inp.nextInt();
			char c1 = inp.next().charAt(0);
			Arrow z = new Arrow(a1, b1, c1);
			a.add(j, z);
		}
		inp.nextLine();
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getK() {
		return K;
	}

	public void setK(int k) {
		K = k;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	public ArrayList<Integer> getArr() {
		return arr;
	}

	public ArrayList<Arrow> getA() {
		return a;
	}
	public Arrow getArrow(int p) {
		return a.get(p);
	}
	public boolean isFinal( int p) {
		return arr.contains(p);
	}
	private boolean trace(int p,String w) {
		if(w.isEmpty()) return isFinal(p);
		for( int i=0; i<M ;i++) 
			if(getArrow(i).getBegin()==p && getArrow(i).getName()== w.charAt(0))
				if(trace(getArrow(i).getEnd(), w.substring(1))) return true;
			return false;
		
	}
	public boolean isWord(String s) {
		return trace( 0,s );
	}
	public void showAllWords(int len) {
		
	}
	

	@Override
	public String toString() {
		return "N=" + N + ", K=" + K + ", M=" + M ;

	}

}

public class Main {
	static Scanner inp = null;

	public static void main(String[] args) {
		
		File f = null;
		f = new File("auto.txt");
		try {
			inp = new Scanner(f);
		} catch (Exception e) {
			System.out.println("File Data.txt not found");
			return;
		}

		Auto a = new Auto(inp);
		System.out.println(a.toString());
		ArrayList arr = a.getArr();
		String s = "Ending positions are: ";
		for (int i = 0; i < arr.size(); i++) {
			s += arr.get(i) + "; ";
		}
		System.out.println(s);
		ArrayList arr1 = a.getA();
		String s1 = "All arrows are: ";
		for (int i = 0; i < arr1.size(); i++) {
			s1 += arr1.get(i).toString() + " /  ";
		}
		System.out.println(s1);

		System.out.println(a.isFinal(3));
		System.out.println(a.isWord("ABAA"));
	}

}
