package carTravel.service.car;

import carTravel.dto.CarDto;
import carTravel.dto.IssueDto;
import carTravel.entity.Issue;

public interface CarService {
    void create (CarDto dto);
    CarDto get(long id);
    void update(long id, CarDto newData);
    void delete(long id);
}
