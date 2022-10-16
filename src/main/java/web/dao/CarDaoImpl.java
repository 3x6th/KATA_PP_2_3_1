package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1L, "Tesla", "Black"));
        cars.add(new Car(25L, "AUDI", "RED"));
        cars.add(new Car(123L, "Mazda", "Silver"));
        cars.add(new Car(565L, "BMW", "Grey"));
        cars.add(new Car(2L, "TOYOTA", "white"));
        cars.add(new Car(3L, "LADA", "purple"));
    }


    @Override
    public List<Car> getCars(int count) {
        return count >= 5 ? cars : cars.stream().limit(count).collect(Collectors.toList());
    }
}
