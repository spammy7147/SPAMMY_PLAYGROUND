package hello.login;

import hello.login.web.filter.LogFilter;
import hello.login.web.filter.LoginCheckFilter;
import hello.login.web.interceptor.LogInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * ? 한 문자 일치
     * * 경로(/) 안에서 0개 이상의 문자 일치
     * ** 경로 끝까지 0개 이상의 경로(/) 일치
     * {spring} 경로(/)와 일치하고 spring이라는 변수로 캡처
     * {spring:[a-z]+} matches the regexp [a-z]+ as a path variable named "spring"
     * {spring:[a-z]+} regexp [a-z]+ 와 일치하고, "spring" 경로 변수로 캡처
     * {*spring} 경로가 끝날 때 까지 0개 이상의 경로(/)와 일치하고 spring이라는 변수로 캡처
     * /pages/t?st.html — matches /pages/test.html, /pages/tXst.html but not /pages/
     * toast.html
     * /resources/*.png — matches all .png files in the resources directory
     * /resources/** — matches all files underneath the /resources/ path, including /
     * resources/image.png and /resources/css/spring.css
     * /resources/{*path} — matches all files underneath the /resources/ path and
     * captures their relative path in a variable named "path"; /resources/image.png
     * will match with "path" → "/image.png", and /resources/css/spring.css will match
     * with "path" → "/css/spring.css"
     * /resources/{filename:\\w+}.dat will match /resources/spring.dat and assign the
     * value "spring" to the filename variable
     *
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");

    }

//    @Bean
//    public FilterRegistrationBean logFilter() {
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new LogFilter());
//        filterRegistrationBean.setOrder(1);
//        filterRegistrationBean.addUrlPatterns("/*");
//
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean loginCheckFilter() {
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new LoginCheckFilter());
//        filterRegistrationBean.setOrder(2);
//        filterRegistrationBean.addUrlPatterns("/*");
//
//        return filterRegistrationBean;
//    }
}
