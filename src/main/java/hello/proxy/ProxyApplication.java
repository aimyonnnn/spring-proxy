package hello.proxy;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class , AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
@Import(ProxyFactoryConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}

/**
 * @Import(AppV1Config.class) 어노테이션은 AppV1Config 클래스를
 * Spring의 애플리케이션 컨텍스트에 등록하는 역할을 합니다.
 * 이렇게 등록된 AppV1Config 클래스는 Spring이 관리하는 빈(Bean)들을 설정하고 생성하는 역할을 합니다.
 *
 * AppV1Config 클래스에는 @Configuration 어노테이션이 붙어 있으며,
 * 이 클래스 내부에는 @Bean 어노테이션이 붙은 메소드들이 있습니다.
 * 이 메소드들은 각각 OrderControllerV1, OrderServiceV1, OrderRepositoryV1 타입의 빈을 생성하고 등록하는 역할을 합니다.
 *
 * 따라서 @Import(AppV1Config.class)를 통해 AppV1Config 클래스를 애플리케이션 컨텍스트에 등록하면,
 * AppV1Config 클래스가 정의한 빈들이 모두 Spring의 애플리케이션 컨텍스트에 등록되고,
 * 이 빈들은 필요한 곳에서 사용될 수 있게 됩니다.
 *
 * @SpringBootApplication(scanBasePackages = "hello.proxy.app") 어노테이션은
 * hello.proxy.app 패키지와 그 하위 패키지를 스캔하여 Spring이 관리해야 할 빈들을 찾아내는 역할을 합니다.
 * 이렇게 찾아낸 빈들 역시 애플리케이션 컨텍스트에 등록되며, 필요한 곳에서 사용될 수 있게 됩니다.
 */