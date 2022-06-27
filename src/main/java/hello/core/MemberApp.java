package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {


    // psvm
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();


        // 스프링 컨테이너
        // 모든 걸 다 관리해준다.
        // Appconfig에 있는 환경 설정을 가지고 스프링 빈으로 등록한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 메소드 이름을 적어줌, Type (반환 타입에 맞춤)
        applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);

//        Member findMember = memberService.findMember(1L);
        // soutv
        System.out.println("new member = " + member.getName());
//        System.out.println("findMember = " + findMember.getName());


    }
}
