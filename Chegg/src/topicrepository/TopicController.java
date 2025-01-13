package topicrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//implement TopicRepository interface
public class TopicController implements TopicRepository {
	
	private static TopicRepository topics;
	
	// Added unimplemented methods of TopicRepository interface
	@Override
	public Topic findById(int topicId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByTopic(String topic) {
		return null;
	}

	@Override
	public List findByStorageFolder(String topic) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String args[]) {
		ArrayList<Topic> bunchOfTopic = new ArrayList<Topic>();
		
		ArrayList<TopicRepository> topicRepository = new ArrayList<TopicRepository>();

        String[] topicWords = {"Multi Threading", "Inner Classes",  "Collections", "Generics", "Development", "JVM"};

        //Using java 8 features (stream, lambda)
        IntStream.range(0,10).forEach(it -> {
            String buzzWord = topicWords[it % topicWords.length]; // each topic from topicWords
//            System.out.print(it + "-->");
//            System.out.print(buzzWord + "--->");
//            System.out.print((it % topicWords.length) + "\n");
            Topic topic = new Topic((it % topicWords.length),buzzWord,"JAVA" ); // create Topic object
            bunchOfTopic.add(topic);
        });
        
        
        for (Topic item : bunchOfTopic) {   
        	System.out.println(item.getTopicId() + " >> " + item.getTopic() + " >> " + item.getStorageFolder());
        }
	}
}
