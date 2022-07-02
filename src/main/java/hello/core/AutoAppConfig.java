package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// Component를 쫙 긁어서 빈으로 등록 시킴
// Cofiguration 어노테이션이 붙은 클래스는 제외
// Configuration 내부에 Component가 같이 붙어 있어서 제외했음
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION
        ,classes = Configuration.class
        )
)

public class AutoAppConfig {

        @Autowired
        MemberRepository memberRepository;
        @Autowired
        DiscountPolicy discountPolicy;

//        @Bean
        OrderService orderService(){
                return new OrderServiceImpl(memberRepository, discountPolicy);
        }

//        @Bean
        MemberRepository memberRepository(){
                return new MemoryMemberRepository();
        }

}
