package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Override
    public List<Car> listCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Audi quattro S6", "dark green", 2018));
        carList.add(new Car("BMW M3", "light blue", 1988));
        carList.add(new Car("Alfa Romeo Julia", "bright orange", 1998));
        carList.add(new Car("Fiat Uno", "arctic white", 2008));
        return carList;
    }
}
