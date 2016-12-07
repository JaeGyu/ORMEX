package jpabook.start;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JPATest {

	@Test
	public void 동일성_테스트() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("a", "aa");

		System.out.println(map.get("a") == new String("aa"));
		System.out.println(map.get("a") == "aa");
		System.out.println(map.get("a").equals(new String("aa")));
		
	}
}
