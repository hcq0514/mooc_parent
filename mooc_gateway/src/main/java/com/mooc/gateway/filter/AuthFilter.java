//package com.mooc.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
////        String pattern = ".*user.*";
////        RequestPath path = exchange.getRequest().getPath();
////        //如果是跳到登录页面的请求则直接放行
//////        if (("/api/item/page").equals(path.toString())) {
//////            return chain.filter(exchange);
//////        }
////        if (Pattern.matches(pattern,path.toString())){
////            return chain.filter(exchange);
////        }
////        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
////        //重定向(redirect)到登录页面
////        if (StringUtils.isBlank(token)) {
////            String url = "http://www.mall.com/login.html";
////            ServerHttpResponse response = exchange.getResponse();
////            //303状态码表示由于请求对应的资源存在着另一个URI，应使用GET方法定向获取请求的资源
////            response.setStatusCode(HttpStatus.SEE_OTHER);
////            response.getHeaders().set(HttpHeaders.LOCATION, url);
////            return response.setComplete();
////        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return -100;
//    }
//}
