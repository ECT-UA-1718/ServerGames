
import gamesUtil.Field;

class NnCField extends Field {
	
	public NnCField(int w, int h, int nvalue) {
		super(w,h,nvalue);
		setVIndex(0,'~');
		setVIndex(1,'X');
		setVIndex(2,'O');
	}
	public void play() {
		int c[]=promptCoordinates("Input Coordinates");
		setFieldVal(c[0],c[1],1);
	}
}

public class NaughtsAndCrosses {
	
	public static void main(String[] args) {
		NnCField f=new NnCField(3,3,3);
		f.printField(false,false);
		f.play();
		f.printField(false,false);
	}
}