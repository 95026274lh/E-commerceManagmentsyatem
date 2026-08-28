    package com.jsp.E_commerceManagmentsyatem.service;

    import com.jsp.E_commerceManagmentsyatem.dto.OrderRequestDto;
    import com.jsp.E_commerceManagmentsyatem.dto.OrderResponseDto;
    import com.jsp.E_commerceManagmentsyatem.dto.UserRequestDto;
    import com.jsp.E_commerceManagmentsyatem.dto.UserResponseDto;
    import com.jsp.E_commerceManagmentsyatem.entity.OrderEntity;
    import com.jsp.E_commerceManagmentsyatem.entity.UserEntity;
    import com.jsp.E_commerceManagmentsyatem.repository.OrderRepository;
    import com.jsp.E_commerceManagmentsyatem.repository.UserRepository;
    import lombok.RequiredArgsConstructor;
    import org.apache.catalina.User;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    @RequiredArgsConstructor
    public class OrderService {
        private  final OrderRepository orderRepository;
        private final UserRepository userRepository;

        public ResponseEntity<OrderResponseDto> CreateOrder(Long userid, OrderRequestDto orderRequestDto){
            System.out.println("crete method is started");
            UserEntity user=userRepository.findById(userid).orElseThrow( ()-> new RuntimeException(" user doesnot exist"));
            OrderEntity order=new OrderEntity();
            order.setOrdname(orderRequestDto.getOrdname());
            order.setOrdprice(orderRequestDto.getOrdprice());
            order.setOrddate(orderRequestDto.getOrddate());
            order.setUser(user);
            System.out.println("before save");

            OrderEntity saveorder=orderRepository.save(order);
            System.out.println("After save"+saveorder.getOrdid());

            OrderResponseDto orderResponseDto=new OrderResponseDto();
            orderResponseDto.setOrdid(saveorder.getOrdid());
            orderResponseDto.setOrdname(saveorder.getOrdname());
            orderResponseDto.setOrdprice(saveorder.getOrdprice());
            orderResponseDto.setOrddate(saveorder.getOrddate());

            UserResponseDto userResponseDto=new UserResponseDto();
            userResponseDto.setId(user.getId());
            userResponseDto.setName(user.getName());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setMobile(user.getMobile());


orderResponseDto.setUser(userResponseDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
        }
        public List<OrderEntity> fetchAllOrder() {

          return orderRepository.findAll();



        }
        public OrderResponseDto fetchbyname(String ordname){
            OrderEntity order=orderRepository.findByordname(ordname).orElseThrow(()-> new RuntimeException(" invalid order name"));
            OrderResponseDto orderResponseDto=new OrderResponseDto();
            orderResponseDto.setOrdid(order.getOrdid());
            orderResponseDto.setOrdname(order.getOrdname());
            orderResponseDto.setOrdprice(order.getOrdprice());
            orderResponseDto.setOrddate(order.getOrddate());

            if(order.getUser()!=null){
                UserResponseDto userResponseDto=new UserResponseDto();
                userResponseDto.setId(order.getUser().getId());
                userResponseDto.setName(order.getUser().getName());
                userResponseDto.setEmail(order.getUser().getEmail());
                userResponseDto.setMobile(order.getUser().getMobile());
                orderResponseDto.setUser(userResponseDto);}

            return orderResponseDto;

        }
        public String Delete(){
            orderRepository.deleteAll();
            return " all orders deleted sucessfully";

        }

    }


