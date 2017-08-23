///*
// * Copyright 2002-2016 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package changhong.com.web;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.boot.autoconfigure.web.AbstractErrorController;
//import org.springframework.boot.autoconfigure.web.ErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class CustomErrorController extends AbstractErrorController
//
//{
//	Map<String, Object> model = new
//
//	HashMap<>();
//
//	/**
//	 * @param errorAttributes
//	 */
//	public CustomErrorController(ErrorAttributes errorAttributes) {
//		super(errorAttributes);
//		// TODO Auto-generated constructor stub
//	}
//
//	@RequestMapping(value = "/error")
//	public String error(HttpServletRequest request) {
//		this.model = getErrorAttributes(request, true);
//		return "myerror.html";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/geterrormap")
//	public Map<String, Object> geterrmesage() {
//
//		return model;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see org.springframework.boot.autoconfigure.web.AbstractErrorController#
//	 * getErrorAttributes(javax.servlet.http.HttpServletRequest, boolean)
//	 */
//	@Override
//	protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
//		// TODO Auto-generated method stub
//		return super.getErrorAttributes(request, includeStackTrace);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see org.springframework.boot.autoconfigure.web.AbstractErrorController#
//	 * resolveErrorView(javax.servlet.http.HttpServletRequest,
//	 * javax.servlet.http.HttpServletResponse,
//	 * org.springframework.http.HttpStatus, java.util.Map)
//	 */
//	@Override
//	protected ModelAndView resolveErrorView(HttpServletRequest request, HttpServletResponse response, HttpStatus status,
//			Map<String, Object> model) {
//		this.model = model;
//		// TODO Auto-generated method stub
//		return super.resolveErrorView(request, response, status, model);
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
//}
