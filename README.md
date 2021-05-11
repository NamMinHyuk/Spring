## Spring-Study 1일차  
        
        
***   
      
- Spring tools (STS - Spring Tool Suite)      
  4 -> boot      
  3 -> legacy      
  3(standalone)     
        
- Solution > Framework > Library       
       
   Solution : 문제에 대한 해결 방안       
   framework : 어플리케이션을 만들기 위해 필요한 공통적인 부분을 미리 만들어 놓고,       
	      어플리케이션마다 다른 부분들을 개발자가 완성       
   Library : *.jar      
    
      
- EJB (Enterprise JavaBean) - X     
- POJO (Plain Old Java Object) - O  순수하게 자바만 가지고도 만들 수 있다.       
  (경량 컨테이너) - 최근에 나온 프레임워크 python - django,js - node.js(express)가 더 가볍기 때문에 그때는 '경량'      
       
Spring이 객체를 만든다.(가장 큰 기본특징)      
특징     
1. DI(Dependency Injection) - 의존,주입(객체만들면서 값 주입) / IoC(Inversion of Control) - 제어 역전(객체생성을 설정하면서함)      
2. AOP(Asperct Oriented Programming)      
3. OCP(Open-Closed Principle)              
      
DI/loC - 강결합 : 결합도가 강하다   ,   약결합 : 결합도를 느슨하게    
팩토리 메서드(디자인 패턴) 신입 때 공부할 1순위 -> design pattern (조금 어렵다)    
       
# DI - 관리하는 방법      
1. Construction Injection     
2. Setter Injection      
3. Method Injection   
          
ApplicationContext, ClassPathXmlApplicationContext      
BeanFactory > ApplicationContext > ClassPathXmlApplicationContext      
ApplicationContext 객체는 스프링 컨테이너의 인스턴스 이다.        
스프링은 ApplicationContext 인터페이스의 몇가지 기본 구현을 제공한다.        
 그 중, ClassPathXmlApplicationContext는 XML 형식의 독립형 어플리케이션에 적합.      
(지정된 ClassPath에서 XML 파일을 읽어서 객체 생성)      
      
Container 	: 담는 그릇 (bean을 저장하고 관리하는 객체)       
Content 		: 기능      
Context	 	: 기능을 구현하기 위한 정보 (설정)    
     
ApplicationContext : 프로젝트를 실행하기 위한 설정   
       
Maven - 빌드 / 배포 관리 tool     
Dependency Hierarchy       
     
constructor-arg : 생성자 찾음        
property          : setter 찾음        
      
- 싱글톤 레지스트리  : 스프링은 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공한다.    
   (스프링 bean 오브젝트는 내부적으로 싱글톤 레지스트리를 만들어서 연동)       
- 추상클래스에서는 new 사용해서 객체 생성 못한다.      
group ID -> org.springframework , Artifact ID -> spring-core    
참고자료 [maven][https://search.maven.org/]  ,  [mvrepository][https://mvnrepository.com/]   

면접 : spring 이 뭔지 물어볼 수 있음 잘외우기 ★★★