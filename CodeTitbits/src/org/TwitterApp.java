import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApp {

	public static void main(String[] args) throws TwitterException {
		ConfigurationBuilder cb =  new ConfigurationBuilder();
		cb.setDebugEnabled(true)
			.setOAuthConsumerKey("hjtEuUY04uf7jNXJy2bSDUyt6")
			.setOAuthConsumerSecret("P7Yu4MlTQ7jTVTuOglzC1ryHW983wj55j8XXxRk8a7FkEomWpv")
			.setOAuthAccessToken("184086796-T0Kxh5lkPH8oaaFnIL3tp0dwRBrHmni3bk4aYesR")
			.setOAuthAccessTokenSecret("i019i8DmPWE9Z5wRtQolXrpW9GZcgO6xBjLaV3cjjEP2u");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		List<Status> status = twitter.getHomeTimeline();
		for(Status st : status) {
			System.out.println(st.getUser().getName() + "---------" + st.getText());
		}
	}
}
//Register at https://apps.twitter.com/ - Name, Description, Website
//	Permission - Read, Write and Access direct messages
//	Generate Access Token and plug stuff in the code