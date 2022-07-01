package hello.core;

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



}
