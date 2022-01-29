package com.web.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		// 允許跨域請求的來源
		config.addAllowedOrigin("/*");
		// 允許跨域攜帶cookie資訊
		config.setAllowCredentials(true);
		// 允許使用哪些請求方式
		config.addAllowedMethod("/*");
		// 允許哪些header
		config.addAllowedHeader("/*");
		// 可獲取哪些Header(跨域預設不能取得全部Header資訊)
		config.addExposedHeader("/*");
		
		// 映射路徑
		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		configSource.registerCorsConfiguration("/**", config);
		
		return new CorsFilter(configSource);
	}

}
