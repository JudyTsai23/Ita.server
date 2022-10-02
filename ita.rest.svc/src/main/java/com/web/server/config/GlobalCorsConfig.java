package com.web.server.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

@WebFilter(filterName="CorsFilter")
@Configuration
public class GlobalCorsConfig implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "*");
        chain.doFilter(req, res);
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		CorsConfiguration config = new CorsConfiguration();
//		// 允許跨域請求的來源
//		config.addAllowedOrigin("/*");
//		// 允許跨域攜帶cookie資訊
//		config.setAllowCredentials(true);
//		// 允許使用哪些請求方式
////		config.setAllowedMethods(Arrays.asList("GET", "PUT", "POST","DELETE"));
//		config.addAllowedMethod(HttpMethod.POST);
//		config.addAllowedMethod(HttpMethod.GET);
//		config.addAllowedMethod(HttpMethod.PUT);
//		config.addAllowedMethod(HttpMethod.DELETE);
//		// 允許哪些header
//		config.addAllowedHeader("/*");
//		// 可獲取哪些Header(跨域預設不能取得全部Header資訊)
//		config.addExposedHeader("/*");
//		
//		// 映射路徑
//		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
//		configSource.registerCorsConfiguration("/**", config);
//		
//		return new CorsFilter(configSource);
//	}
	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                //映射路徑
//                registry.addMapping("/*")
//                        //允許使用那些請求方式
//                        .allowedMethods("*")
//                        //允許哪些Header
//                        .allowedHeaders("/*");
//            }
//        };
//    }
}
