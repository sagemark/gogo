package com.oreilly.cloud;

import com.netflix.zuul.ZuulFilter;

public class MyZuulFilter extends ZuulFilter{
	@Override
	public String filterType() {
		return "pre";// before routing
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Passed through custom Zuul Filter");
		return null;
	}
}
