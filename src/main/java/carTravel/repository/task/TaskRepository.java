package carTravel.repository.task;

import carTravel.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Tasks, Integer> {
}
