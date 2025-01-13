package topicrepository;

import java.util.List;

public interface CategoryRepository {
	Category findById(int categoryId);

	List findByCategoryName(String categoryName);

}