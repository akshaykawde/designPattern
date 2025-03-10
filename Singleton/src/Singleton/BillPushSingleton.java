package Singleton;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class BillPushSingleton implements Serializable {
	   
		private BillPushSingleton(){
			System.out.println("Craeting SingleTon using BillPugh");
		}
	    private static class SingletonHelper{
	        private static final BillPushSingleton INSTANCE = new BillPushSingleton();
	    }
	    public static BillPushSingleton getInstance(){
	        return SingletonHelper.INSTANCE;
	    }
}
class TestBill{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		BillPushSingleton BillObject1=BillPushSingleton.getInstance();
		BillPushSingleton BillObject2=BillPushSingleton.getInstance();
		System.out.println(BillObject1.hashCode());
		System.out.println(BillObject2.hashCode());
}
}