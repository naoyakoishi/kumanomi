package logic.oauth;

import java.util.HashMap;
import java.util.Map;

public class twitterLogic {

	/**
	 * TODO mock
	 * @return Map<String, String> friendMap
	 */
	public static Map<String, String> getFriendMap() {
		Map<String, String> friendMap = new HashMap<String, String>();
		for(int i = 0;i < 5; i++) {
			String num = String.valueOf(i);
			friendMap.put("id" + num, "name" + num);
		}
		return friendMap;
	}
}
