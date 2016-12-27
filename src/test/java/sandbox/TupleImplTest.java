package sandbox;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TupleImplTest {

	@Test
	public void testTuple() throws Exception {
		String a = "g";
		Integer b = 1;
		
		List<Object> o = new ArrayList<>();
		o.add(a);
		o.add(b);
		
		for(Object obj : o){
			System.out.println(obj);
			System.out.println(obj.getClass().getName());
			if(obj.getClass().getName().equals("java.lang.String")){
				System.out.println(((String)obj) + "::" );
			}else{
				System.out.println(((Integer)obj) + 10);
			}
		}
	}
}
