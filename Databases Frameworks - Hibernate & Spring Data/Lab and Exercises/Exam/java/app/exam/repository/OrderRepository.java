package app.exam.repository;

import app.exam.domain.entities.Order;
import app.exam.domain.entities.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

    @Query("SELECT o FROM Order as o " +
            "where o.employee.name = :name and o.type = :type")
    List<Order> findByEmployeeNameAndType(@Param("name") String name, @Param("type")OrderType type);
}
