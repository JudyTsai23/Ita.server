package com.web.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

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
