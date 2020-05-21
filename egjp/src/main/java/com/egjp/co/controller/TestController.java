/*
 * Copyright 2008-2009 the original author or authors.
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
package com.egjp.co.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egjp.co.service.TestService;
import com.egjp.co.vo.JsonTestVO;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class TestController {

	/** EgovSampleService */
	@Resource(name = "testService")
	private TestService testService;

//	@RequestMapping(value = "/testJson.do")
//	public String selectList(ModelMap model) throws Exception {
//		model.addAttribute("resultList", testService.selectList());
//		return "test2";
//	}
	
	@ResponseBody
	@RequestMapping(value = "/testJson.do", method = RequestMethod.POST)
	public Map<String, String> testJson(@RequestBody JsonTestVO obj, HttpServletRequest req) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		result.put("result1", "하하하");
		result.put("result2", "호호호");
		return result;
	}

}
