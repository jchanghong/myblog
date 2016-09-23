/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package changhong.com.web;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;

@Controller
public class CustomErrorController implements ErrorController, ErrorAttributes

{
	public static String errstring = "";

	@RequestMapping(value = "/error")
	public String error(Model model) {
		CustomErrorController.errstring = model.toString();
		// CustomErrorController.errstring = exception.getMessage() + "<br>" +
		// exception.getStackTrace();
		return "myerror.html";
	}

	@ResponseBody
	@RequestMapping(value = "/geterror/")
	public String geterrmesage() {
		return CustomErrorController.errstring;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.autoconfigure.web.ErrorAttributes#getError(org.
	 * springframework.web.context.request.RequestAttributes)
	 */
	@Override
	public Throwable getError(RequestAttributes arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.autoconfigure.web.ErrorAttributes#
	 * getErrorAttributes(org.springframework.web.context.request.
	 * RequestAttributes, boolean)
	 */
	@Override
	public Map<String, Object> getErrorAttributes(RequestAttributes arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
