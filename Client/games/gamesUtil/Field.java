/* --Field Class--
	To be used as a parent class for games that require a 2D grid
 */

package gamesUtil;
import java.util.Scanner;

public class Field { //this class is to be used as a parent class for games that require a 2D based field
	static Scanner sc=new Scanner(System.in);
	
	private int[][] field; //holds the actual values (value codes) of each tile
	private int w; //field.length
	private int h; //field[].length
	private char[] values; //if the game requires special values (characters, special numbers, ...) they are stored in this array, in which the indexes correspond to the values in field[][]
	private boolean strvals=false; //identifies whether values[] is being used
	
	//creates a Field which does not rewquire values[]
	public Field(int w, int h) {
		this.field=new int[w][h];
		this.w=w;
		this.h=h;
	}
	//creates a Field using values[]-- nvalue is the quantity of values required
	public Field(int w, int h, int nvalue) {
		this.field=new int[w][h];
		this.w=w;
		this.h=h;
		this.values=new char[nvalue];
		this.strvals=true;
	}
	//stores a value code (pos) as the given character (val)
	public void setVIndex(int pos, char val) {
		values[pos]=val;
	}
	public void setFieldVal(int x, int y, int val) {
		field[x][y]=val;
	}
	//returns tile value code
	public int getFieldVal(int x, int y) {
		return field[x][y];
	}
	//returns character value
	public char getTileVal(int x, int y) {
		return values[field[x][y]];
	}
	//prints the field and horizontal and vertical scale (according to the argument values)
	public void printField(boolean hscale, boolean vscale) {
		System.out.println();
		if (hscale) {
			//if vscale is true, prints the initial interval equivalent to said scale
			if (vscale) {
				printNtimes(" ",String.format("%d",h).length()+1,false);
				printNtimes(" ",String.format("%d",w-1).length(),false);
			}
			//print the number of columns with the appopriate offset
			for (int i=0;i<w;i++) {
				System.out.printf("%d",i+1);
				printNtimes(" ",String.format("%d",w-1).length()-String.format("%d",i+1).length()+1,false);
				if (i==w-1) {
					System.out.println();
				}
			}
			System.out.println();
		}
		//prints the field values (codes or not)
		for (int j=0;j<h;j++) {
			//print vertical scale, formatted according to the max number of digits required
			if (vscale) {
				printNtimes(" ",String.format("%d",h).length()-String.format("%d",j+1).length(),false);
				System.out.printf("%d ",j+1);
				printNtimes(" ",String.format("%d",w-1).length(),false);
			}
			//prints values with appropriate offset
			for (int i=0;i<w;i++) {
				printTile(i,j);
				if (hscale) printNtimes(" ",String.format("%d",w-1).length(),false); //offset
				else System.out.print(" ");
			}
			//prints as many lines as necessary to keep with horizontal offset
			if (hscale) printNtimes("\n",String.format("%d",w-1).length()-2,false);
			System.out.println();
		}
		System.out.println();
	}
	public int[] promptCoordinates(String prompt) {
		int[] coord=new int[2];
		String answer;
		boolean repeat=true;
		do {
			System.out.print(prompt+"(X/Y): ");
			answer=sc.nextLine();
			try {
				answer.trim();
				coord[0]=Integer.parseInt(answer.split("/")[0]);
				coord[1]=Integer.parseInt(answer.split("/")[1]);
				if (checkRange(1,w,coord[0]) && checkRange(1,h,coord[1])) repeat=false;
			}
			catch (Exception e) {}
			if (repeat) System.out.println("Invalid Coordinates");
		} while(repeat);
		coord[0]--;
		coord[1]--;
		return coord;
	}
	//if tile values are set to characters, prints based on values[], else print the int value
	public void printTile(int x, int y) {
		if (strvals) System.out.print(values[field[x][y]]);
		else System.out.print(field[x][y]);
	}
	//prints a line of the given character or expression
	public void printNtimes(String x, int n, boolean line) {
		for (int i = 0;i < n;i++) { 
			System.out.printf(x);
		}
		if (line) System.out.println();
	}
	//checks an int n in [x,y]
	public boolean checkRange(int x, int y, int n) {
		return (n>=x) && (n<=y);
	}
	//uncoment main() for testing purposes
	/*public static void main(String[] args) {
		Field TestInt=new Field(3,3);
		Field TestStr=new Field(15,15,3);
		TestStr.setVIndex(0,'A');
		TestStr.setVIndex(1,'B');
		TestStr.setVIndex(2,'C');
		TestInt.printField(false,true);
		TestStr.printField(false,true);
		int c[]=TestStr.promptCoordinates("Coordinates");
		int x=c[0];
		int y=c[1];
		System.out.print(x+" "+y);
	}*/
}

//by PivZ