package topicrepository;

import java.util.List;

public interface TopicRepository {

Topic findById(int topicId);

List findByTopic(String topic);

List findByStorageFolder(String topic);

}
