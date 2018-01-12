package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.json.ItemJSONExportDTO;
import app.exam.domain.dto.json.OrderJSONExportDTO;
import app.exam.domain.dto.xml.OrderItemXMLImportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.domain.entities.*;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.ItemsRepository;
import app.exam.repository.OrderItemRepository;
import app.exam.repository.OrderRepository;
import app.exam.service.api.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelParser modelParser;


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void create(OrderXMLImportDTO dto) throws ParseException {
        Order order = new Order();
        order.setCustomer(dto.getCustomer());

        String string = dto.getDate();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = format.parse(string);
        order.setDate(date);

        order.setType(OrderType.valueOf(dto.getType().toUpperCase()));

        Employee employee = this.employeeRepository.findByName(dto.getEmployee());
        if(employee == null){
            throw new IllegalArgumentException("employee does not exist");
        }
        order.setEmployee(employee);


        List<OrderItemXMLImportDTO> dtoItems = dto.getItems();
        Set<OrderItem> orderItems = new HashSet<>();
        BigDecimal totalPrice = new BigDecimal(0);
        OrderItem orderItem = null;
        for (OrderItemXMLImportDTO itemDto : dtoItems) {
            Item item = this.itemsRepository.findByName(itemDto.getName());
            if(item == null){
                throw new IllegalArgumentException("item does not exist");
            }
            orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
            totalPrice.add(item.getPrice());
        }
        order.setOrderItems(orderItems);
        order.setTotalprice(totalPrice);

        this.orderRepository.save(order);
        this.orderItemRepository.save(orderItem);

    }

    @Override
    public EmployeeOrdersJSONExportDTO exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
        OrderType orderType1 = OrderType.valueOf(orderType.toUpperCase());
        List<Order> orders = this.orderRepository.findByEmployeeNameAndType(employeeName, orderType1);
        EmployeeOrdersJSONExportDTO employeeOrdersJSONExportDTO = new EmployeeOrdersJSONExportDTO();


        List<OrderJSONExportDTO> ordersDto = new ArrayList<>();
        for (Order order : orders) {
            employeeOrdersJSONExportDTO.setEmployeeName(order.getEmployee().getName());



            OrderJSONExportDTO orderJSONExportDTO = new OrderJSONExportDTO();
            orderJSONExportDTO.setCustomer(order.getCustomer());

            Set<ItemJSONExportDTO> allOrderItems = new HashSet<>();
            Set<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                ItemJSONExportDTO itemJSONExportDTO= new ItemJSONExportDTO();
                itemJSONExportDTO.setName(orderItem.getItem().getName());
                itemJSONExportDTO.setPrice(orderItem.getItem().getPrice());
                itemJSONExportDTO.setQuantity(orderItem.getQuantity());

                allOrderItems.add(itemJSONExportDTO);
            }

            orderJSONExportDTO.setItems(allOrderItems);
            double sum = orderJSONExportDTO.getItems().stream().mapToDouble(i -> Double.parseDouble(String.valueOf(i.getPrice()))).sum();
            orderJSONExportDTO.setTotalPrice(sum);
            ordersDto.add(orderJSONExportDTO);

        }
//        ordersDto.stream().sorted((f1, f2) -> Double.compare(f2.getTotalPrice(), f1.getTotalPrice()));

        employeeOrdersJSONExportDTO.setEmployeeName(employeeName);
        employeeOrdersJSONExportDTO.setOrders(ordersDto);
        return employeeOrdersJSONExportDTO;
    }
}
