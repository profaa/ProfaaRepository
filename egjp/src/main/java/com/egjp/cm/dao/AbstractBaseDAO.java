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
package com.egjp.cm.dao;

import java.util.List;

import com.egjp.cm.vo.AbstractBaseVO;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
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

public class AbstractBaseDAO extends EgovAbstractMapper {	
	public <E> List<E> selectList(String queryId) {
		return this.selectList(queryId, null);
	}
	
	public <E> List<E> selectList(String queryId, AbstractBaseVO baseVO) {
		if (baseVO == null) {
			return super.selectList(queryId);
		}
		
		// get total count
		baseVO.setCmPageSearchKind("01");
		AbstractBaseVO rtnVO = selectOne(queryId, baseVO);
		
		// get result list
		baseVO.setCmPageSearchKind("02");
		List<E> rtnVOList = super.selectList(queryId, baseVO);
		if (rtnVOList != null && rtnVOList.size() > 0 && rtnVO != null) {
			((List<AbstractBaseVO>)rtnVOList).get(0).setCmTotalPageCount(rtnVO.getCmTotalPageCount());
		}
		return rtnVOList;
	}
}
