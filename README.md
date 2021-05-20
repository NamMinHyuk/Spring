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
       
특징     
(가장 큰 기본특징) - Spring이 객체를 만든다.      
1. DI(Dependency Injection) - 의존,주입(객체만들면서 값 주입) / IoC(Inversion of Control) - 제어 역전(객체생성을 설정하면서함)      
2. AOP(Asperct Oriented Programming)      
3. OCP(Open-Closed Principle)              
      
DI/loC - 강결합 : 결합도가 강하다   ,   약결합 : 결합도를 느슨하게    
팩토리 메서드(디자인 패턴) 신입 때 공부할 1순위 -> design pattern (조금 어렵다)    
       
DI - 관리하는 방법      
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
Content 	: 기능      
Context	 	: 기능을 구현하기 위한 정보 (설정)    
     
ApplicationContext : 프로젝트를 실행하기 위한 설정   
       
Maven - 빌드 / 배포 관리 tool     
Dependency Hierarchy       
     
constructor-arg   : 생성자 찾음        
property          : setter 찾음        
      
- 싱글톤 레지스트리  : 스프링은 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공한다.    
   (스프링 bean 오브젝트는 내부적으로 싱글톤 레지스트리를 만들어서 연동)       
- 추상클래스에서는 new 사용해서 객체 생성 못한다.      
group ID -> org.springframework , Artifact ID -> spring-core    
참고자료 [maven][https://search.maven.org/]  ,  [mvrepository][https://mvnrepository.com/]   

## Spring-Study 2일차  
        
        
***   
     
constructor-arg   ref="" 객체를 불러온다.   
c: constructor , p: property   
lazy-init="true" : default -> false 이고 true 이면 초기화(객체생성)를 호출 되면 하는 것이다.      
     
<메세지 국제화>        
MessageSourceAware는 번들이 지정된 properties 파일을 setMessageSource로 전달        
      
ResourceBundleMessageSource의 setBaseName()을 통해 전달된 파일을 setMessageSource로 자동 매핑      
ResourceBundleMessageSource와 MessageSourceAware는 쌍으로 사용      

## Spring-Study 3일차  
        
        
***   
      
autowire 속성값    
 1. byName : (id,name으로)setter와 같은 이름이 있으면 자동 할당      
 2. byType : setter와 같은 타입이 있으면 자동 할당 -> 같은 타입의 빈이 두개 이상 있으면 에외 발생!      
 3. constructor : 생성자의 파라미터와 같은 타입이 있으면 자동 할당 (id나 name으로 호출)      
 4. default : constructor -> byType      
     * 기본 생성자가 있으면, 기본 생성자 호출     
    
Spring Annotation     
- annotation은 java 1.5부터 지원한다.     
- 스프링은 어노테이션을 이용하여 빈과 관련된 정보를 설정    
    
Spring Annotation 설정    
1. CommonAnnotationBeanPostProcessor 클래스를 설정파일에 bean 객체로 등록하여 annotation 적용    
 <bean class="org.springframework.beans.factory.annotation.CommonAnnotationBeanPostProcessor" />    
         
2. <context:annotation-config />태그를 이용    
  @Autowired, @Required, @Resource, @PostConstructor, @PreDestroy 등의 annotation을 자동 처리해주는 bean post processor      
      
3. <context:component-scan base-package="" /> 태그를 이용      
  @Component, @Controller, @Service, @Repository 등의 annotation을 자동 처리      
        
4. <mvc:annotation-driven /> 태그를 이용      
  @RequestMapping, @Valid, ... 등의 spring mvc component들을 자동 처리.      
  HandlerMapping, HandlerAdapter를 등록하여 @Controller에 요청 연결.      
  해당 태그가 없어도 <context:component-scan /> 이 있으면 mvc application 동작      
       
* 4개의 stereotype annotation (component-scan에 의해 자동 등록)      
@Component : stereotype annotation의 조상      
@Controller : Spring MVC에서 컨트롤러로 인식      
@Service : 역할 부여 없이 스캔 대상이 됨. 비즈니스 로직(biz)로 사용      
@Repository : 일반적으로 dao에 사용, Exception을 DataAccessException으로 변환      
      
1. @Component      
패키지 : org.springframework.stereotype      
버전 : spring 2.5      
클래스에 선언하며 해당 클래스를 자동으로 bean 등록. bean의 이름은 해당 클래스명 (첫글자 소문자)      
범위는 디폴트로 singleton이며 @Scope를 이용해 지정할 수 있다.      
      
2. @Autowired      
패키지 : org.springframework.beans.factory.annotation      
버전 : spring 2.5      
Autowired annotation은 spring에서 의존관계를 자동으로 설정할 때 사용.      
이 어노테이션은 생성자, 필드, 메서드 세곳에 적용 가능하며, 타입을 이용한 프로퍼티 자동 설정기능을 제공.      
즉, 해당 타입의 빈 객체가 없거나 2개 이상일 경우 예외를 발생시킨다.      
프로퍼티 설정 메서드 (setter) 형식이 아닌 일반 메서드에도 적용 가능.      
프로퍼티 설정이 필수가 아닌 경우 @Autowired(required=false)로 선언한다. (default = true)      
autowire 속성의 값을 byType으로 설정할 경우, 같은 타입의 빈이 2개 이상 존재하면 예외가 발생하는데      
@Autowired도 같은 문제가 발생한다. 이때, @Qualifier를 사용하면 동일한 타입의 빈 중 특정 빈을 사용하도록 설정 가능하다.      
      
ex)      
@Autowired      
@Qualifier("mytest")      
private Test test;      
      
3. @Qualifier      
패키지 : org.springframework.beans.factory.annotation      
버전 : spring 2.5      
@Autowired annotation이 byType 기반이기 때문에 2개 이상의 동일타입 빈 객체가 존재할 시 특정 빈을 사용하도록 선언.      
@Qualifier("beanName")의 형태로 @Autowired와 함께 사용한다.      
      
4. @Required      
패키지 : org.springframework.beans.factory.annotaiton      
버전 : spring 2.0      
필수 프로퍼티임을 명시하는 것으로, 프로퍼티 설정 메서드(setter)에 붙이면 된다.      
필수 프로퍼티를 설정하지 않을 경우 빈 생성시 예외 발생.      
      
5. @Repository      
패키지 : org.springframework.stereotype      
버전 : spring 2.0      
dao에 사용되며 Exception을 DataAccessException으로 변환.      
      
6. @Service      
패키지 : org.springframework.stereotype      
버전 : spring 2.0      
@Service를 적용한 class는 비즈니스 로직(biz)로 취급.      
      
7. @Resource      
패키지 : javax.annotation.Resource      
버전 : java 1.6 % jee 5      
어플리케이션에서 필요로 하는 자원을 자동 연결. name 속성에 자동으로 연결될 빈 객체의 이름을 입력.      
      
ex)      
@Resource(name="testDao")	// byName -> byType      


## Spring-Study 4일차  
        
        
***   
      
AOP(Aspect Oriented Programming) : 관점지향 프로그래밍     
      
- CC(Core Concern) - (taget) 주(핵심) 관심사항      
- CCC(Cross Cutting Concern) - (Advice) 공통 관심사항. Logging, transaction 등      
      
Join Point : advice/ccc가 연결될 수 있는 (target/cc가 호출되는)모든 시점       
Pointcut : advice/ccc가 연결되는 시점      
Advice : ccc 실제 구현 code      
Advisor(Aspect) : AOP의 중심단위, Advice + Pointcut       
Weaving : 일련의 과정      
      
@Before : target 실행 전      
@AfterThrowing : 에러 발생 예외일때 묶는다.      
@AfterReturning : 에러없이 정상 실행 리턴값을 묶는다.      
@After : target 실행 후       


## Spring-Study 5~6일차   
        
        
***   
      
src-main-webapp : context root     
   
순서
01. pom.xml   
     ojdbc6, mybatis, mybatis-spring, commons-dbcp, spring-orm    
02. web.xml    
03. /WEB-INF/spring/sqls/test.sql    
04. dto, dao, biz, controller    
05. src/main/resources/mybatis/myboard-mapper.xml     
06. src/main/resources/mybatis/db.properties     
07. /WEB-INF/spring/sqls/config.xml      
08. applicationContext.xml     
     
proxy 객체가 interface가지고 가져옴 (interface 안쓰면 CGLib씀)    
      
spring이 내부적으로 commandObj가 받아서 dto에 넣어줌      
sqlSessionTemplate은 commit , close도 알아서 해줌     
       
        
## Spring-Study 7일차        
        
        
***   
      
MVC패턴 Spring 순서     
01. pom.xml에 dependency 추가      
01-1. root-context -> applicationContext.xml로 바꾸고 appServlet에 넣는다.     
02. web.xml 설정 , context root 위치 바꾼다.     
03. /WEB-INF/spring/sqls/test.sql     
04. dto, dao, biz, controller     
05. src/main/resources/mybatis/myboard-mapper.xml  -  (namespace 위치 주의!! mapper에 써야함)     
06. src/main/resources/mybatis/db.properties     
07. /WEB-INF/spring/sqls/config.xml - typeAlias , mapper에서 resources : src/main/resources로 연결된다.     
08. applicationContext.xml - classpath : src/main/resources로 연결해준다. 1)db.properties 2)dataSource 3)mybatis 4)mybatis template     
      
Filter - client req가 server로 갈때  Filter를 거치고 server에서 resp가 client로 갈때 Filter를 거친다.      
chain.doFilter(request,response); 가 없으면 웹사이트가 백지가 response 된다.      
      
Filter 순서는 javax.servlet.Filter interface를 상속받는 class를 만들고 -> web.xml 에서 Filter를 설정해준다.      
